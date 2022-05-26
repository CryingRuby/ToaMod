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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.toamod.network.ToamodModVariables;
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
					event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity,
			double amount) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack damageItem = ItemStack.EMPTY;
		double damage = 0;
		damageItem = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		damage = amount;
		if (sourceentity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("entity attacked:"), (false));
		if (ToamodModVariables.WorldVariables.get(world).vanillaCrit) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(Math.round((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + damage * (1 / 3)));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("dmg before reduce: " + damage)), (false));
			damage = Math.round(damage * (2 / 3));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("dmg after reduce: " + damage)), (false));
			ToamodModVariables.WorldVariables.get(world).vanillaCrit = false;
			ToamodModVariables.WorldVariables.get(world).syncData(world);
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("(vanilla crit reduce)"), (false));
		}
		if (Mth.nextInt(new Random(), 1, 100) <= (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).kritChance) {
			damage = damage + damage * ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).kritDamage / 100);
			entity.hurt(DamageSource.GENERIC, (float) (damage * ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).kritDamage / 100)));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 20, 0.5, 0.5, 0.5, 0.5);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CRIT, x, y, z, 20, 0.5, 0.5, 0.5, 0.5);
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(ToamodModMobEffects.VULNERABLE.get()) : false) {
			entity.hurt(DamageSource.MAGIC, (float) (damage * 0.25));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.EXECUTING.get(), damageItem) != 0) {
			entity.hurt(DamageSource.GENERIC,
					(float) (damage * (((((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
							- (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1))
							/ (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) * 100 * 0.1
							* EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.EXECUTING.get(), damageItem)) / 100)));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.LIFE_STEEL.get(), damageItem) != 0) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
						+ damage * 0.1 * EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.LIFE_STEEL.get(), damageItem)));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.IGNITE.get(), damageItem) != 0) {
			entity.setSecondsOnFire(4);
		}
		if (sourceentity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("Damage Dealt: " + damage)), (false));
	}
}
