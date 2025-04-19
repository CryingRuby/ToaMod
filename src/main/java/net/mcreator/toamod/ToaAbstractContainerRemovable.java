package net.mcreator.toamod;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

public abstract class ToaAbstractContainerRemovable extends AbstractContainerMenu {
	public final int slotCount;
	protected final int nonVItemSlot;
	//Used to differanciate the gui closed by ESC from closed by redirecting -> ESC => drop item in NonVItemSlot
	private boolean exitedByESC = true;

	public ToaAbstractContainerRemovable(@Nullable MenuType<?> menuType, int id, int slotCount) {
		this(menuType, id, slotCount, -1);
	}

	public ToaAbstractContainerRemovable(@Nullable MenuType<?> menuType, int id, int slotCount, int nonVItemSlot) {
		super(menuType, id);
		this.slotCount = slotCount;
		this.nonVItemSlot = nonVItemSlot;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index == nonVItemSlot && !this.moveItemStackTo(itemstack1, slotCount, this.slots.size(), true))
				return ItemStack.EMPTY;
			//move from gui to ply inv
			if (index < slotCount) {
				slot.onTake(playerIn, itemstack1);
			} else if (!this.moveItemStackTo(itemstack1, 0, slotCount, false)) { //move from ply inv to gui
				if (index < 13 + 27) {
					if (!this.moveItemStackTo(itemstack1, slotCount + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, slotCount, slotCount + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
		}
		return ItemStack.EMPTY;
	}

	public ItemStack getBackVItem() {
		ItemStack item = new ItemStack(Items.ARROW);
		item.setHoverName(Component.literal("§b§lBack§r"));
		item.getOrCreateTag().putBoolean("delete", true);
		return item;
	}

	/**
	 * Clears illegal visual items from carried slot and (one) from player inventory. Should be called in click event
	 */
	public void clearIllegalVItems(Player entity){
		//When called in click event illegal item can only be on either the carried slot or inventory
		if(!clearIllegalCarried());
			clearIllegalFromInv(entity);
	}

	/**
	 * Removes any item from the carried slot if it is just a visual item (has nbt "delete" = true)
	 * 
	 * @return if illegal item was in carried slot
	 */
	private boolean clearIllegalCarried() {
		if (getCarried() != null && getCarried().getOrCreateTag().getBoolean("delete")) {
			setCarried(ItemStack.EMPTY);
			return true;
		}
		return false;
	}

	public boolean isExitedByESC(){
		return this.exitedByESC;
	}

	public void setExitedByESC(boolean bool){
		this.exitedByESC = bool;
	}


	/**
	 * Removes first visual item (has nbt "delete" = true) from player inventory.
	 * Used after shift-right click visual item to inventory => after that only 1 visual item can be in player inventory
	 * 
	 * @return if illegal item has been removed
	 */
	private boolean clearIllegalFromInv(Player entity) {
		System.out.println("called clearillegalFromInv");
		Inventory inv = entity.getInventory();
		System.out.println("items-size: " + inv.items.size());
		for (int i = 0; i < inv.items.size(); i++) {
			if (inv.items.get(i).isEmpty())
				continue;
			ItemStack item = inv.items.get(i);
			System.out.println("	testing for clearing item in slot: " + i + ", item: " + item.getItem());
			if (item.getOrCreateTag().getBoolean("delete")) {
				System.out.println("		item has delete nbt tag true -> clear");
				item.setCount(0);
				entity.containerMenu.broadcastChanges();
				return true;
			}
		}
		return false;
	}

}
