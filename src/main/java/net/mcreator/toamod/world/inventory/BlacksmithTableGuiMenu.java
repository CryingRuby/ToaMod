
package net.mcreator.toamod.world.inventory;

import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.SimpleContainer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.procedures.OnBlacksmithTableClosedProcedure;
import net.mcreator.toamod.jei_recipes.BlacksmithTableTypeRecipe;
import net.mcreator.toamod.init.ToamodModMenus;
import net.mcreator.toamod.block.entity.BlacksmithTableBlockEntity;
import net.mcreator.toamod.CustomNbtHandler;

import java.util.function.Supplier;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber
public class BlacksmithTableGuiMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public BlacksmithTableGuiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ToamodModMenus.BLACKSMITH_TABLE_GUI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(10);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		if (pos != null) {
			boundBlockEntity = this.world.getBlockEntity(pos);
			if (boundBlockEntity != null)
				boundBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					this.internal = capability;
					this.bound = true;
				});
			/* ALTERNATIV STATT DEM BLOCK OBEN
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
				itemstack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					this.internal = capability;
					this.bound = true;
				});
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntity(extraData.readVarInt());
				if (boundEntity != null)
					boundEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			} else { // might be bound to block
				boundBlockEntity = this.world.getBlockEntity(pos);
				if (boundBlockEntity != null)
					boundBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			}
			*/
		}
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 138, 36) {
			private final int slot = 0;

			@Override
			public void onTake(Player entity, ItemStack stack) {
				super.onTake(entity, stack);
				slotChanged(0, 1, 0);
			}

			@Override
			public void onQuickCraft(ItemStack a, ItemStack b) {
				super.onQuickCraft(a, b);
				slotChanged(0, 2, b.getCount() - a.getCount());
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}
		}));
		//Adds all 9 input slots
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				final int slotID = i * 3 + j + 1;
				this.customSlots.put(slotID, this.addSlot(new SlotItemHandler(internal, slotID, 30 + 18 * j, 18 + 18 * i) {
					private final int slot = slotID;

					@Override
					public void setChanged() {
						super.setChanged();
						slotChanged(slot, 0, 0);
					}
					/*@Override
					public void onTake(Player entity, ItemStack stack) {
						super.onTake(entity, stack);
						slotChanged(slot, 1, 0);
					}
					
					@Override
					public void onQuickCraft(ItemStack a, ItemStack b) {
						super.onQuickCraft(a, b);
						slotChanged(slot, 2, b.getCount() - a.getCount());
					}*/
				}));
			}
		}
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 5 + 8 + sj * 18, 1 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 5 + 8 + si * 18, 1 + 142));
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			boolean quickCrafted = false;
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 10) {
				if (!this.moveItemStackTo(itemstack1, 10, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
				quickCrafted = true;
			} else if (!this.moveItemStackTo(itemstack1, 0, 10, false)) {
				if (index < 10 + 27) {
					if (!this.moveItemStackTo(itemstack1, 10 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 10, 10 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0)
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
			if (itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;
			//if(!quickCrafted)
			//slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean moveItemStackTo(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
		boolean flag = false;
		int i = p_38905_;
		if (p_38907_) {
			i = p_38906_ - 1;
		}
		if (p_38904_.isStackable()) {
			while (!p_38904_.isEmpty()) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot = this.slots.get(i);
				ItemStack itemstack = slot.getItem();
				if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameTags(p_38904_, itemstack)) {
					int j = itemstack.getCount() + p_38904_.getCount();
					int maxSize = Math.min(slot.getMaxStackSize(), p_38904_.getMaxStackSize());
					if (j <= maxSize) {
						p_38904_.setCount(0);
						itemstack.setCount(j);
						slot.set(itemstack);
						flag = true;
					} else if (itemstack.getCount() < maxSize) {
						p_38904_.shrink(maxSize - itemstack.getCount());
						itemstack.setCount(maxSize);
						slot.set(itemstack);
						flag = true;
					}
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
				}
			}
		}
		if (!p_38904_.isEmpty()) {
			if (p_38907_) {
				i = p_38906_ - 1;
			} else {
				i = p_38905_;
			}
			while (true) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot1 = this.slots.get(i);
				ItemStack itemstack1 = slot1.getItem();
				if (itemstack1.isEmpty() && slot1.mayPlace(p_38904_)) {
					if (p_38904_.getCount() > slot1.getMaxStackSize()) {
						slot1.setByPlayer(p_38904_.split(slot1.getMaxStackSize()));
					} else {
						slot1.setByPlayer(p_38904_.split(p_38904_.getCount()));
					}
					slot1.setChanged();
					flag = true;
					break;
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
				}
			}
		}
		return flag;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		OnBlacksmithTableClosedProcedure.execute(world, entity);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 1; j < internal.getSlots(); ++j) {
					playerIn.drop(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
				}
			} else {
				for (int i = 1; i < internal.getSlots(); ++i) {
					playerIn.getInventory().placeItemBackInInventory(internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
				}
			}
		}
	}

	private void slotChanged(int slotid, int ctype, int meta) {
		System.out.println("BlacksmithTableGUIMenu - slotChanged -> try call refreshRecipe");
		if (this.world.isClientSide())
			return;
		if (boundBlockEntity instanceof BlacksmithTableBlockEntity bT) {
			System.out.println("block at x=" + x + ", y=" + y + ", z=" + z + " has BlacksmithTableBlockEntity - call refreshRecipe in bT");
			if (slotid == 0) {
				System.out.println("	Slot is 0 -> extract Input-item due to crafting");
				craftItems(ctype == 2);
			}
			refreshRecipe();
		}
	}

	public boolean hasRecipe(Optional<BlacksmithTableTypeRecipe> recipe) {
		return !recipe.isEmpty();
	}

	public void refreshRecipe() {
		if (this.world.isClientSide())
			return;
		System.out.println("BT-GUIMenu - refreshRecipe called");
		Optional<BlacksmithTableTypeRecipe> recipe = getCurrentRecipe();
		if (!hasRecipe(recipe)) {
			System.out.println("BT-GUIMenu - has no valid recipe");
			if (!this.customSlots.get(0).getItem().isEmpty())
				this.customSlots.get(0).set(ItemStack.EMPTY);
			return;
		}
		System.out.println("Valid recipe found -> set Item in output slot");
		ItemStack result = recipe.get().getResultItem();
		if (recipe.get().getHasNbt()) {
			System.out.println("Recipe has Nbt -> call methods");
			CustomNbtHandler.applyItemBaseStats(result);
			if (recipe.get().getCopyNbtFromSlot() > 0) {
				System.out.println("Recipe has NbtCopy -> call copyUpgrades");
				CustomNbtHandler.copyUpgrades(this.customSlots.get(recipe.get().getCopyNbtFromSlot()).getItem(), result);
			}
			CustomNbtHandler.setLoreOfItem(result);
		}
		this.customSlots.get(0).set(result);
	}

	private Optional<BlacksmithTableTypeRecipe> getCurrentRecipe() {
		SimpleContainer inventory = new SimpleContainer(this.customSlots.size());
		for (int i = 1; i < customSlots.size(); i++) {
			System.out.println("	found Item in slot: " + i + " : " + customSlots.get(i).getItem().getItem());
			inventory.setItem(i, customSlots.get(i).getItem());
		}
		return world.getRecipeManager().getRecipeFor(BlacksmithTableTypeRecipe.Type.INSTANCE, inventory, world);
	}

	private void craftItems(boolean multiCrafted) {
		if (multiCrafted) {
			//variable maxCraftable here for better code understanding (it's redundant)
			//The -1 is because the shift+click it selfs adds the result item with base Count 1 times to the inv
			int maxCraftable = getMaxCraftableAmount() - 1;
			int actualItemAmountCrafted = maxCraftable;
			ItemStack resultItem = getCurrentRecipe().get().getResultItem();
			int completeItemCount = maxCraftable * resultItem.getCount();
			System.out.println("		maxCraftable: " + maxCraftable + ", base resultItemCount: " + resultItem.getCount());
			ItemStack setItem;
			while (completeItemCount > 0) {
				System.out.println("		CompleteItemCount: " + completeItemCount);
				setItem = resultItem.copy();
				System.out.println("			Result-Craft Amount: min{~maxStackSize: " + (resultItem.getMaxStackSize() - resultItem.getMaxStackSize() % resultItem.getCount()) + "; mit maxStackSize: " + resultItem.getMaxStackSize() + " und Abzug: "
						+ (resultItem.getMaxStackSize() % resultItem.getCount()) + " | completeItemCount: " + completeItemCount + " }");
				setItem.setCount(Math.min(resultItem.getMaxStackSize(), completeItemCount));
				int tempItemCount = setItem.getCount();
				System.out.println("			tempItemCount: " + tempItemCount);
				System.out.println("			moveItems to inv; setItemCount: " + setItem.getCount());
				moveItemStackTo(setItem, 10, this.slots.size(), true);
				System.out.println("			setItem: " + setItem.getItem() + ", Count: " + setItem.getCount());
				//if not maximum possible crafted could be added to inv, calc actual amount the recipe is crafted
				if (!setItem.isEmpty()) {
					System.out.println("!!!!		Stacks couldn't be all added -> reduce actualAmountsCrafted. tempItemCount: " + tempItemCount + ", setItemCount: " + setItem.getCount() + "; actualItemAmountCrafted: "
							+ (maxCraftable - (completeItemCount - tempItemCount + setItem.getCount()) / resultItem.getCount()));
					actualItemAmountCrafted = maxCraftable - (int) Math.ceil((completeItemCount - tempItemCount + setItem.getCount()) / (double) resultItem.getCount());
					removeExcessiveItems(resultItem, resultItem.getMaxStackSize() % resultItem.getCount());

					/**
					 * PROBLEM - Imagine: 
					 * 
					 * ResultItem hat Count 3. Im Inv ist 1 Slot frei. Es sollen 100 oder so result items gecraftet werden.
					 * der erste Stack (64x) wird geplaced alles easy. Dann zweiter Stack wir nichts platziert, also 36 werden abgezogen.
					 * ABER warte: 64 / 3 = 21.333 ??? -> Naja 64 ist halt kein Vielfaches vom Count des Result item.
					 * 
					 * 2 Lösungen (Präventiv oder im Nachhinein):
					 * 	- Beim Count setzten nicht .getMaxStackSize(), sondern davon halt was abziehen, sodass vielfaches von Result-Count   (completeItemCount ist dann immer Vielfaches von Result-Count; fun-fact: Am Anfang ist das schon jetzt so)
					 * 	- Wenn nicht alles ins inv passt, dann vorm abbrechen (also hier) die überschüssigen Items wieder aus inv nehmen. Idk maybe bissl scheiße, weil wieder inv durchgehen.
					 */
					break;
				}
				completeItemCount -= tempItemCount;
				System.out.println("			reduce cICount to " + completeItemCount);
			}
			System.out.println("		All possible items placed in inv -> extracting input-items for " + actualItemAmountCrafted + "x (+1) the recipe");
			//+1 to extract items from shift+click itself
			extractItemsFromCrafting(actualItemAmountCrafted + 1);
		} else
			extractItemsFromCrafting(1);
	}

	private void removeExcessiveItems(ItemStack matchItem, int amount){
		if(amount <= 0)
			return;
			
		Inventory inv = entity.getInventory();
		for (int i = 0; i < inv.items.size(); i++) {
			if (inv.items.get(i).isEmpty())
				continue;
			ItemStack item = inv.items.get(i);
			if (ItemStack.isSameItemSameTags(item, matchItem)) {
				System.out.println("		item has delete nbt tag true -> clear");
				item.shrink(amount);
				entity.containerMenu.broadcastChanges();
				return;
			}
		}

	}

	private int getMaxCraftableAmount() {
		Optional<BlacksmithTableTypeRecipe> recipe = getCurrentRecipe();
		if (!hasRecipe(recipe))
			return 0;
		//if valid recipe is in BT checks how often it could be crafted
		/**the max is 64 because inputs have to be at least 1*/
		int maxCraftAmount = 64;
		NonNullList<Ingredient> recipeIngr = recipe.get().getIngredients();
		for (int i = 0; i < recipeIngr.size(); i++) {
			if (recipeIngr.get(i).isEmpty())
				continue;
			//Could be done by simply checking the count of the item in Slot. BUT for future I probably will change recipes that the inputs are able to have different counts than 1
			int tempMaxCraftable = this.customSlots.get(i + 1).getItem().getCount() / recipeIngr.get(i).getItems()[0].getCount();
			if (tempMaxCraftable < maxCraftAmount)
				maxCraftAmount = tempMaxCraftable;
		}
		return maxCraftAmount;
	}

	private void extractItemsFromCrafting(int craftAmount) {
		if (craftAmount < 1)
			return;
		for (int i = 1; i < customSlots.size(); i++) {
			this.customSlots.get(i).getItem().shrink(1 * craftAmount);
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		Player entity = event.player;
		if (event.phase == TickEvent.Phase.END && entity.containerMenu instanceof BlacksmithTableGuiMenu) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
		}
	}
}
