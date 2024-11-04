package net.mcreator.toamod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.decoration.GlowItemFrame;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnEntityTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double dmg = 0;
		double hp = 0;
		String hpTxt = "";
		boolean hpUpdate = false;
		if (entity instanceof LivingEntity && !entity.getPersistentData().getBoolean("npc")) {
			if (entity.getPersistentData().getDouble("dmgCooldown") > 0) {
				entity.getPersistentData().putDouble("dmgCooldown", (entity.getPersistentData().getDouble("dmgCooldown") - 1));
			}
			if (entity.getPersistentData().getDouble("currentHealth") <= 0 && !(entity instanceof Player) && !(entity instanceof ItemEntity) && !(entity instanceof ItemFrame) && !(entity instanceof GlowItemFrame)) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~ ~-300 ~");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
					}
				}
			}
		}
		if (entity.getPersistentData().getBoolean("npc")) {
			if (entity.getPersistentData().getDouble("txtDelay") > 0) {
				entity.getPersistentData().putDouble("txtDelay", (entity.getPersistentData().getDouble("txtDelay") - 1));
			}
			OnNPCTickProcedure.execute(world, x, y, z, entity);
		}
	}
}
