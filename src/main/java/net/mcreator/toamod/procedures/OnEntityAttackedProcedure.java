package net.mcreator.toamod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModMobEffects;
import net.mcreator.toamod.init.ToamodModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnEntityAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack damageItem = ItemStack.EMPTY;
		String dmgType = "";
		String hpTxt = "";
		boolean resetDmgCooldown = false;
		double damage = 0;
		double armorMR = 0;
		double critRate = 0;
		double critDmg = 0;
		double i = 0;
		double reflectDmg = 0;
		double actualDmg = 0;
		double hp = 0;
		double varToHP = 0;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ToamodModMobEffects.INVINCIBLE.get()))) {
			damageItem = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			if ((damageItem.getOrCreateTag().getString("dmgType")).equals("magic")) {
				if (sourceentity instanceof Player) {
					damage = GetPlayerMPProcedure.execute(sourceentity);
					armorMR = entity.getPersistentData().getDouble("MR");
				} else {
					damage = sourceentity.getPersistentData().getDouble("MP");
					armorMR = armorMR;
				}
				dmgType = "magic";
			} else {
				if (sourceentity instanceof Player) {
					damage = GetPlayerADProcedure.execute(sourceentity);
					armorMR = entity.getPersistentData().getDouble("AR");
				} else {
					damage = sourceentity.getPersistentData().getDouble("AD");
					armorMR = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).armor;
				}
				dmgType = "physical";
			}
			if (sourceentity instanceof Player) {
				critRate = GetPlayerCRProcedure.execute(entity, sourceentity);
				critDmg = GetPlayerCDProcedure.execute(sourceentity);
			} else {
				critRate = sourceentity.getPersistentData().getDouble("CR");
				critRate = sourceentity.getPersistentData().getDouble("CD");
			}
			damage = damage / (1 + armorMR / 100);
			if (Mth.nextInt(RandomSource.create(), 1, 100) <= critRate) {
				damage = damage + damage * (critDmg / 100);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 20, 0.5, 0.5, 0.5, 0.5);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CRIT, x, y, z, 20, 0.5, 0.5, 0.5, 0.5);
			}
			if (entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(ToamodModMobEffects.VULNERABLE.get())) {
				damage = damage * 0.25;
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.EXECUTING.get(), damageItem) != 0) {
				damage = damage
						* (((((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) / (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1))
								* 100 * 0.1 * damageItem.getEnchantmentLevel(ToamodModEnchantments.EXECUTING.get())) / 100);
			}
			if (!(entity instanceof Player)) {
				if (sourceentity.getPersistentData().getDouble("enhNextAtk") > 0) {
					damage = damage * (1 + sourceentity.getPersistentData().getDouble("enhNextAtk"));
					entity.getPersistentData().putDouble("enhNextAtk", 0);
					entity.getPersistentData().putDouble("enhAtkCD", 0);
				}
				if (entity.getPersistentData().getDouble("currentHealth") <= Math.round(damage) && entity.getPersistentData().getDouble("dmgCooldown") == 0) {
					resetDmgCooldown = true;
					OnEntityKilledProcedure.execute(world, x, y, z, entity, sourceentity);
				}
			}
			if (entity.getPersistentData().getDouble("dmgCooldown") == 0) {
				if (entity instanceof Player) {
					{
						double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentHealth - Math.ceil(damage);
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
					entity.getPersistentData().putDouble("CombatCooldown", 100);
				} else {
					entity.getPersistentData().putDouble("currentHealth", (entity.getPersistentData().getDouble("currentHealth") - Math.ceil(damage)));
					ReloadEntityHealthDisplayProcedure.execute(entity);
				}
				resetDmgCooldown = true;
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get(), damageItem) != 0) {
				if (sourceentity instanceof Player) {
					{
						double _setval = Math.round((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentHealth
								+ damage * 0.1 * damageItem.getEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get()));
						sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.currentHealth = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else {
					sourceentity.getPersistentData().putDouble("currentHealth", Math.round(sourceentity.getPersistentData().getDouble("currentHealth") + damage * 0.1 * damageItem.getEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get())));
					ReloadEntityHealthDisplaySourceProcedure.execute(sourceentity);
				}
			}
			reflectDmg = 0;
			for (int index0 = 0; index0 < 4; index0++) {
				if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.SPIKES.get(),
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int) i)) : ItemStack.EMPTY)) != 0) {
					reflectDmg = reflectDmg + damage * 0.15 * damageItem.getEnchantmentLevel(ToamodModEnchantments.SPIKES.get());
				}
				i = i + 1;
			}
			if (entity.getPersistentData().getDouble("dmgCooldown") == 0 && Math.ceil(reflectDmg) > 0) {
				if (entity instanceof Player) {
					sourceentity.getPersistentData().putDouble("currentHealth", (sourceentity.getPersistentData().getDouble("currentHealth") - Math.ceil(reflectDmg)));
					ReloadEntityHealthDisplaySourceProcedure.execute(sourceentity);
				} else {
					{
						double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentHealth - Math.round(reflectDmg);
						sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.currentHealth = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
				resetDmgCooldown = true;
			}
			if (resetDmgCooldown) {
				entity.getPersistentData().putDouble("dmgCooldown", 10);
			}
		} else {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("msg.enemy_immune").getString())), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
