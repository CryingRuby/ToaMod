package net.mcreator.toamod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.toamod.init.ToamodModMobEffects;
import net.mcreator.toamod.init.ToamodModEnchantments;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class OnEntityAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(),
					event.getSource().getEntity());
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
		double damage = 0;
		double armorMR = 0;
		double critRate = 0;
		double critDmg = 0;
		double i = 0;
		double reflectDmg = 0;
		damageItem = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("dmgType"))
				.equals("magic")) {
			if (sourceentity instanceof Player) {
				damage = GetPlayerAPProcedure.execute(sourceentity);
				armorMR = entity.getPersistentData().getDouble("magicResistance");
			} else {
				damage = sourceentity.getPersistentData().getDouble("abilityPower");
				armorMR = GetPlayerMRProcedure.execute(sourceentity);
			}
			dmgType = "magic";
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(
						new TextComponent(
								("AP:" + GetPlayerADProcedure.execute(sourceentity) + " , Ar/Mr:" + GetPlayerMRProcedure.execute(sourceentity))),
						(false));
		} else {
			if (sourceentity instanceof Player) {
				damage = GetPlayerADProcedure.execute(sourceentity);
				armorMR = entity.getPersistentData().getDouble("armor");
			} else {
				damage = sourceentity.getPersistentData().getDouble("attackDamage");
				armorMR = GetPlayerARProcedure.execute(sourceentity);
			}
			dmgType = "physical";
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(
						new TextComponent(
								("AD:" + GetPlayerADProcedure.execute(sourceentity) + " , Ar/Mr:" + GetPlayerARProcedure.execute(sourceentity))),
						(false));
		}
		if (sourceentity instanceof Player) {
			critRate = GetPlayerCRProcedure.execute(entity, sourceentity);
			critDmg = GetPlayerCDProcedure.execute(sourceentity);
		} else {
			critRate = sourceentity.getPersistentData().getDouble("critRate");
			critRate = sourceentity.getPersistentData().getDouble("critDmg");
		}
		if (sourceentity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("dmgType: " + dmgType)), (false));
		if (sourceentity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					new TextComponent(
							("CR: " + GetPlayerCRProcedure.execute(entity, sourceentity) + " , CD: " + GetPlayerCDProcedure.execute(sourceentity))),
					(false));
		damage = damage / (1 + armorMR / 100);
		if (Mth.nextInt(new Random(), 1, 100) <= critRate) {
			damage = damage + damage * (critDmg / 100);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 20, 0.5, 0.5, 0.5, 0.5);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CRIT, x, y, z, 20, 0.5, 0.5, 0.5, 0.5);
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(ToamodModMobEffects.VULNERABLE.get()) : false) {
			damage = damage * 0.25;
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.EXECUTING.get(), damageItem) != 0) {
			damage = damage * (((((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
					- (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1))
					/ (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) * 100 * 0.1
					* EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.EXECUTING.get(), damageItem)) / 100);
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.IGNITE.get(), damageItem) != 0) {
			entity.setSecondsOnFire(4);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= Math.round(damage)) {
			OnEntityKilledProcedure.execute(world, x, y, z, entity, sourceentity);
		}
		if (entity instanceof LivingEntity _entity)
			_entity.hurt(new DamageSource("true").bypassArmor(), Math.round(damage));
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.LIFE_STEEL.get(), damageItem) != 0) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth(Math.round((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
						+ damage * 0.1 * EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.LIFE_STEEL.get(), damageItem)));
		}
		reflectDmg = 0;
		for (int index0 = 0; index0 < (int) (4); index0++) {
			if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.LIFE_STEEL.get(),
					(entity instanceof LivingEntity _entGetArmor
							? _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int) i))
							: ItemStack.EMPTY)) != 0) {
				reflectDmg = reflectDmg
						+ damage * 0.5 * EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.LIFE_STEEL.get(), damageItem);
			}
		}
		if (sourceentity instanceof LivingEntity _entity)
			_entity.hurt(new DamageSource("true").bypassArmor(), Math.round(reflectDmg));
		if (sourceentity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("damage: " + damage)), (false));
	}
}
