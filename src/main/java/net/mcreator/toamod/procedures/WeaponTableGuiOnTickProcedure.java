package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;

import java.util.function.Supplier;
import java.util.Map;

public class WeaponTableGuiOnTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean validRecipeLeft = false;
		boolean validRecipeRight = false;
		validRecipeLeft = false;
		validRecipeRight = false;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("hier mit if Recipes machen"), (false));
		if (!validRecipeLeft) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
					&& _current.get() instanceof Map _slots) {
				((Slot) _slots.get(9)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!validRecipeRight) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
					&& _current.get() instanceof Map _slots) {
				((Slot) _slots.get(13)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}
