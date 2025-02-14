package net.mcreator.toamod.procedures;

import org.apache.commons.lang3.tuple.MutablePair;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModMobEffects;
import net.mcreator.toamod.init.ToamodModEnchantments;
import net.mcreator.toamod.enchantment.VampirismEnchantment;
import net.mcreator.toamod.enchantment.SpikesEnchantment;
import net.mcreator.toamod.enchantment.ExecutingEnchantment;
import net.mcreator.toamod.ToaElement;
import net.mcreator.toamod.StatHandler;

@Mod.EventBusSubscriber
public class OnEntityAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event == null || event.getEntity() == null || event.getSource().getEntity() == null || event.getSource().getEntity().level().isClientSide() || !(event.getSource().getEntity() instanceof LivingEntity) || event.getEntity().getPersistentData().getInt("dmgCooldown") > 0) {
			return;
		}
		
		LivingEntity entity = event.getEntity();
		LivingEntity source = (LivingEntity) event.getSource().getEntity();
		if (event.getEntity().hasEffect(ToamodModMobEffects.INVINCIBLE.get())) {
			if (source instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("msg.enemy_immune").getString())), false);
			if (!entity.level().isClientSide()) {
				entity.level().playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
			} else {
				entity.level().playLocalSound(entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1, false);
			}
			return;
		}

		ItemStack handItem = null;
		float[] offStats; //0 str, 1 int, 2 cr, 3 cd, 4 lifesteal, 5 hp
		MutablePair<ToaElement, Float> elem = null;
		float[] defStats; //0 hp, 1 ar, 2 mr
		float[] dmgMods = {1, 1}; //modifier with which the physical / eleméntal Dmg will be multiplied with

		//################################################
		//Gather source-dmg stats and entity-def-stats
		//################################################

		if (source instanceof Player ply) {
			handItem = ply.getItemInHand(InteractionHand.MAIN_HAND);
			offStats = StatHandler.getPlayerStats(ply, new byte[]{0, 3, 5, 6, 7, 8});
			if (handItem.getOrCreateTag().getCompound("Stats") != null) {
				ToaElement elm = ToaElement.getByName(handItem.getOrCreateTag().getCompound("Stats").getString("element"));
				if (elm != null)
					elem = new MutablePair<ToaElement, Float>(elm, handItem.getOrCreateTag().getCompound("Stats").getFloat("elem_dmg"));
			}
			defStats = StatHandler.getEntityStats(entity, new byte[]{8, 9, 10});
		} else if (entity instanceof Player ply) {
			handItem = ply.getItemInHand(InteractionHand.MAIN_HAND);
			offStats = StatHandler.getEntityStats(entity, new byte[]{0, 3, 5, 6, 7, 8});
			ToaElement elm = ToaElement.getByName(entity.getPersistentData().getString("element"));
			if (elm != null)
				elem = new MutablePair<ToaElement, Float>(elm, entity.getPersistentData().getFloat("elem_dmg"));

			defStats = StatHandler.getPlayerStats(ply, new byte[]{8, 9, 10});
		} else
			return; //Only calc any dmg if this event is between entity and player (either player attacking or being attacked)

		double[] damage = new double[2]; //[physical, elemental]
		damage[0] = 1.25 * offStats[0] / (1 + defStats[1] / 100);
		if (elem != null)
			damage[1] = 1.45 * elem.getRight() * (1 + offStats[1] / 100) / (1 + defStats[2] / 100);

		//################################################
		//Damage modifiers
		//################################################
		//Critical Hits
		if (Math.random() < offStats[3] / 100.0) {
			dmgMods[0] += offStats[4] / 100.0f;
		}
		//Effects
		if (entity.hasEffect(ToamodModMobEffects.VULNERABLE.get())) {
			dmgMods[0] += 0.25;
			dmgMods[1] += 0.25;
		}

		//Enchantments		For lvl 6 its 3% dmg increase per 1% missing health 
		if (source instanceof Player && handItem != null && handItem.getEnchantmentLevel(ToamodModEnchantments.EXECUTING.get()) > 0) {
			int execEnchLvl = handItem.getEnchantmentLevel(ToamodModEnchantments.EXECUTING.get());
			float execFac = ((execEnchLvl == 0) ? 0 : ((ExecutingEnchantment) ToamodModEnchantments.EXECUTING.get()).values[execEnchLvl - 1]);
			float dmgBonus = (float) (entity.getMaxHealth() - entity.getHealth()) / entity.getMaxHealth() * execFac;
			dmgMods[0] += dmgBonus;
			dmgMods[1] += dmgBonus;
		}
		//Other
		if (source.getPersistentData().getDouble("enhNextAtk") > 10e-5) {
			dmgMods[0] += source.getPersistentData().getFloat("enhNextAtk");
			source.getPersistentData().putDouble("enhNextAtk", 0);
			source.getPersistentData().putInt("enhAtkCD", 0);
		}

		//################################################
		//Calc Final Dmg
		//################################################
		int finalDmg = (int) Math.ceil(damage[0] * dmgMods[0] + damage[1] * dmgMods[1]);
		System.out.println("dmg dealt: " + finalDmg + ",   with dmg:["+damage[0]+", "+dmgMods[0]+" Fac]  +  elem-dmg:["+damage[1]+", "+dmgMods[1]+" Fac]");

		//OnEnemyKilled  (if source is Player)
		if (source instanceof Player && entity.getPersistentData().getDouble("currentHealth") - finalDmg < 10e-13 && entity.getPersistentData().getInt("dmgCooldown") == 0) {
			OnEntityKilledProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, source);
		}

		//################################################
		//Deal Dmg 
		//################################################
		if (entity instanceof Player) {
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentHealth - finalDmg;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentHealth = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = false;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.outOfCombat = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.getPersistentData().putInt("CombatCooldown", 100);
		} else {
			entity.getPersistentData().putDouble("currentHealth", (entity.getPersistentData().getDouble("currentHealth") - finalDmg));
			ReloadEntityHealthDisplayProcedure.execute(entity);
		}

		//################################################
		//Post Dmg dealt effects (like Vampirism / Reflect) 
		//################################################
		//Vampirism Enchant - heal by dmg
		int vampEnchLvl = (handItem == null) ? 0 : handItem.getEnchantmentLevel(ToamodModEnchantments.VAMPIRISM.get());
		double regenFac = offStats[4] + ((vampEnchLvl == 0) ? 0 : ((VampirismEnchantment) ToamodModEnchantments.VAMPIRISM.get()).getProperties().LIFESTEAL[vampEnchLvl - 1]);
		if (regenFac > 10e-13) {
			if (source instanceof Player) {
				{
					double _setval = Math.round((source.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentHealth + finalDmg * regenFac);
					source.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						if (_setval > capability.maxHealth)
							capability.currentHealth = capability.maxHealth;
						else
							capability.currentHealth = _setval;
						capability.syncPlayerVariables(source);
					});
				}
			} else {
				source.getPersistentData().putDouble("currentHealth", Math.round(source.getPersistentData().getDouble("currentHealth") + finalDmg * regenFac));
				ReloadEntityHealthDisplaySourceProcedure.execute(source);
			}
		}
		//Spikes Enchant - reflect dmg
		double reflectDmg = 0;
		int spkEnchLvl = handItem.getEnchantmentLevel(ToamodModEnchantments.SPIKES.get());
		double reflFac = (spkEnchLvl == 0) ? 0 : ((SpikesEnchantment) ToamodModEnchantments.SPIKES.get()).values[spkEnchLvl - 1];
		for (int i = 0; i < 4; i++) {
			if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.SPIKES.get(), entity.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int) i))) != 0) {
				reflectDmg += finalDmg * reflFac;
			}
		}
		if (reflectDmg > 10e-14) {
			if (entity instanceof Player) {
				source.getPersistentData().putDouble("currentHealth", (source.getPersistentData().getDouble("currentHealth") - Math.ceil(reflectDmg)));
				ReloadEntityHealthDisplaySourceProcedure.execute(source);
			} else {
				double _setval = (source.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentHealth - Math.round(reflectDmg);
				source.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentHealth = _setval;
					capability.syncPlayerVariables(source);
				});
			}
		}
		//0.5s invincibility for attacked entity to avoid to fast damaging bugs + balancing
		entity.getPersistentData().putDouble("dmgCooldown", 10);
	}
}
