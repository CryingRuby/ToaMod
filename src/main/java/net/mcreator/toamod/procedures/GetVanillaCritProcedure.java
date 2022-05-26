package net.mcreator.toamod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.CriticalHitEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.toamod.network.ToamodModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GetVanillaCritProcedure {
	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		execute(event, event.getPlayer().level, event.getPlayer(), event.isVanillaCritical());
	}

	public static void execute(LevelAccessor world, Entity sourceentity, boolean isvanillacritical) {
		execute(null, world, sourceentity, isvanillacritical);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity, boolean isvanillacritical) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("vanillacrit check:"), (false));
		if (isvanillacritical) {
			ToamodModVariables.WorldVariables.get(world).vanillaCrit = true;
			ToamodModVariables.WorldVariables.get(world).syncData(world);
		}
		ToamodModVariables.WorldVariables.get(world).vanillaCrit = false;
		ToamodModVariables.WorldVariables.get(world).syncData(world);
	}
}
