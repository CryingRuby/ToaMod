package net.mcreator.toamod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.monster.Zombie;
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
		if (entity instanceof Zombie) {
			entity.getPersistentData().putDouble("lvl", 17);
			entity.setCustomName(new TextComponent(("Zombie \u00A77Lvl. \u00A74" + entity.getPersistentData().getDouble("lvl") + " \u00A77(\u00A7c"
					+ (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + "\u2665\u00A77)\u00A7r")));
		}
	}
}
