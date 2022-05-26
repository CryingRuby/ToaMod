package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;

import java.util.function.Supplier;
import java.util.Map;

public class ArmoryTableOnTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean validRecipe = false;
		double i = 0;
		validRecipe = false;
		i = 0;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("hier Recipe einf\u00FCgen"), (false));
		if (!validRecipe) {
			for (int index0 = 0; index0 < (int) (0); index0++) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					((Slot) _slots.get((int) i)).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			i = i + 1;
		}
	}
}
