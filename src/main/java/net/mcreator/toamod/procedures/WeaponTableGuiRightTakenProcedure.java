package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.function.Supplier;
import java.util.Map;

public class WeaponTableGuiRightTakenProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double i = 0;
		i = 10;
		for (int index0 = 0; index0 < (int) (2); index0++) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
					&& _current.get() instanceof Map _slots) {
				((Slot) _slots.get((int) i)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			i = i + 1;
		}
	}
}
