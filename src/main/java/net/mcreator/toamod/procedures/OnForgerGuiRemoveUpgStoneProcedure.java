package net.mcreator.toamod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.function.Supplier;
import java.util.Map;

public class OnForgerGuiRemoveUpgStoneProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack upgradingStone = ItemStack.EMPTY;
		upgradingStone = GetUpgStoneByTypeProcedure.execute();
		upgradingStone.getOrCreateTag().putString("upgradingType",
				((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("upgradingType")));
		(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getOrCreateTag().putString("upgradingType", "");
		upgradingStone.getOrCreateTag().putDouble("bonusAD", GetUpgradingStoneADProcedure.execute(entity));
		(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getOrCreateTag()
				.putDouble("bonusAD",
						((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getDouble("bonusAD") - GetUpgradingStoneADProcedure.execute(entity)));
		upgradingStone.getOrCreateTag().putDouble("bonusAP", GetUpgradingStoneAPProcedure.execute());
		(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getOrCreateTag()
				.putDouble("bonusAP",
						((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getDouble("bonusAP") - GetUpgradingStoneAPProcedure.execute()));
		upgradingStone.getOrCreateTag().putDouble("bonusAR", GetUpgradingStoneARProcedure.execute());
		(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getOrCreateTag()
				.putDouble("bonusAR",
						((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getDouble("bonusAR") - GetUpgradingStoneARProcedure.execute()));
		upgradingStone.getOrCreateTag().putDouble("bonusMR", GetUpgradingStoneMRProcedure.execute());
		(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getOrCreateTag()
				.putDouble("bonusMR",
						((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getDouble("bonusMR") - GetUpgradingStoneMRProcedure.execute()));
		upgradingStone.getOrCreateTag().putDouble("bonusCR", GetUpgradingStoneCRProcedure.execute());
		(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getOrCreateTag()
				.putDouble("bonusCR",
						((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getDouble("bonusCR") - GetUpgradingStoneCRProcedure.execute()));
		upgradingStone.getOrCreateTag().putDouble("bonusCD", GetUpgradingStoneCDProcedure.execute());
		(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getOrCreateTag()
				.putDouble("bonusCD",
						((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getDouble("bonusCD") - GetUpgradingStoneCDProcedure.execute()));
		upgradingStone.getOrCreateTag().putDouble("bonusMana", GetUpgradingStoneManaProcedure.execute());
		(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getOrCreateTag()
				.putDouble("bonusMana",
						((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getDouble("bonusMana") - GetUpgradingStoneManaProcedure.execute()));
		if (!((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(2)).getItem()
				: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY);
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (!((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(3)).getItem()
				: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY);
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = upgradingStone;
			_setstack.setCount(1);
			((Slot) _slots.get(3)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY);
			_setstack.setCount(1);
			((Slot) _slots.get(2)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			((Slot) _slots.get(0)).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
	}
}
