package net.mcreator.toamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;

import java.util.function.Supplier;
import java.util.Map;

public class OnUncommanRuneIllfangDropSelectedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double i = 0;
		{
			String _setval = Component.translatable("item.toamod.rune_uncomman").getString();
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.IllfangRNGSelected = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		for (int index0 = 0; index0 < 8; index0++) {
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				((Slot) _slots.get((int) i)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			i = i + 1;
		}
	}
}
