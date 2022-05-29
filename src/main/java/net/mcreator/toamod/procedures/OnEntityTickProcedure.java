package net.mcreator.toamod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnEntityTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
		execute(event, event.getEntityLiving());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity) {
			entity.getPersistentData().putDouble("lvl", 17);
			entity.setCustomName(
					new TextComponent(
							((entity.getDisplayName().getString()).replace(
									" lvl. \u00A7d" + entity.getPersistentData().getDouble("lvl") + " \u00A77(\u00A7c"
											+ Math.round(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + "\u2665\u00A77)\u00A7r",
									""))));
			entity.setCustomName(new TextComponent(
					(entity.getDisplayName().getString() + " \u00A77lvl. \u00A7d" + entity.getPersistentData().getDouble("lvl") + " \u00A77(\u00A7c"
							+ Math.round(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + "\u2665\u00A77)\u00A7r")));
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null)
					_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
							"data merge entity @s {CustomNameVisible:1b}");
			}
		}
	}
}
