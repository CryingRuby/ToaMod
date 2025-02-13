
package net.mcreator.toamod.world.inventory;

import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.network.ForgerGuiSlotMessage;
import net.mcreator.toamod.init.ToamodModMenus;
import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.ToamodMod;
import net.mcreator.toamod.ToaReforgeable;
import net.mcreator.toamod.ReforgeType;
import net.mcreator.toamod.CustomNbtHandler;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import io.netty.buffer.Unpooled;

public class ForgerGuiMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
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
	private ArrayList<Integer> visualItemIds = new ArrayList<>();
	private ItemStack modifyItem = null;

	public ForgerGuiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ToamodModMenus.FORGER_GUI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(13);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		//GUI probably not bound to anything
		if (pos != null) {
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
		}
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 35, 39) {
			private final int slot = 0;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return stack.getItem() instanceof ToaReforgeable;
			}

			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(0, 0, 0);
			}
			@Override
			public void onTake(Player entity, ItemStack stack) {
				super.onTake(entity, stack);
				slotChanged(slot, 1, 0);
			}

			@Override
			public void onQuickCraft(ItemStack a, ItemStack b) {
				super.onQuickCraft(a, b);
				slotChanged(slot, 2, b.getCount() - a.getCount());
			}

		}));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				final int slotId = i * 4 + j + 1;
				this.customSlots.put(slotId, this.addSlot(new SlotItemHandler(internal, slotId, 80 + 18 * j, 21 + 18 * i) {
					private final int slot = slotId;

					@Override
					public boolean mayPlace(ItemStack stack) {
						return false;
					}

					@Override
					public void onTake(Player entity, ItemStack stack) {
						super.onTake(entity, stack);
						slotChanged(slot, 1, 0);
					}

					@Override
					public void onQuickCraft(ItemStack a, ItemStack b) {
						super.onQuickCraft(a, b);
						slotChanged(slot, 2, b.getCount() - a.getCount());
					}
				}));
			}
		}
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 0 + 8 + sj * 18, 0 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 0 + 8 + si * 18, 0 + 142));
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
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 13) {
				if (!this.moveItemStackTo(itemstack1, 13, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 13, false)) {
				if (index < 13 + 27) {
					if (!this.moveItemStackTo(itemstack1, 13 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 13, 13 + 27, false))
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
			slot.onTake(playerIn, itemstack1);
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

	/*
	*
	 * Only drops input item, other items are just visual-items
	 */
	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				playerIn.drop(internal.extractItem(0, internal.getStackInSlot(0).getCount(), false), false);
			} else {
				playerIn.getInventory().placeItemBackInInventory(internal.extractItem(0, internal.getStackInSlot(0).getCount(), false));
			}
		}
	}

	private void slotChanged(int slotid, int ctype, int meta) {
		System.out.println("slotid:" + slotid + ", ctype:" + ctype + ", meta=" + meta);
		if (this.world != null) {
			if (this.world.isClientSide()) {
				ToamodMod.PACKET_HANDLER.sendToServer(new ForgerGuiSlotMessage(slotid, x, y, z, ctype, meta));
				ForgerGuiSlotMessage.handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			} else {
				//Serverside -> onButtonItem clicked
				if (entity instanceof ServerPlayer ply) {
					System.out.println("ServerPlayer it is!");
					if (slotid == 0) {
						if(ctype == 0){
							refreshVisualItems();
							System.out.println("Item in Slot 0 on place-event: "+internal.getStackInSlot(0).getItem()+" | "+((Slot) customSlots.get(0)).getItem()+"   <- Please one of them don't be air :praying:");
							this.modifyItem = internal.getStackInSlot(0).copy(); //idk whether i sould add an .copy() or not
							
						}
						else{
							for(int i = 0; i < customSlots.size(); i++){;
								((Slot) customSlots.get(i)).set(ItemStack.EMPTY);
							}
							this.modifyItem = null;
							entity.containerMenu.broadcastChanges();
						}
						return;
					}
					System.out.println("After refresh VItems");
					System.out.println("Open sub-GUI with bound-item: "+this.modifyItem.getItem());
					final ItemStack transferItem = this.modifyItem;
					
					//here a new gui is definetly opened so remove all vItems
					for(int i = 0; i < customSlots.size(); i++){;
						((Slot) customSlots.get(i)).set(ItemStack.EMPTY);
					}
					entity.containerMenu.broadcastChanges();

					BlockPos _bpos = BlockPos.containing(x, y, z);
					if (slotid == 1) {
						NetworkHooks.openScreen((ServerPlayer) ply, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("ForgerReforge");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new ForgerReforgeMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos), transferItem);
							}
						}, _bpos);
						return;
					}
					if(slotid == 2){
						/*NetworkHooks.openScreen((ServerPlayer) ply, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("ForgerEnchants");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new ForgerEnchantsMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos), internal.getStackInSlot(0));
							}
						}, _bpos);*/
						return;
					}
					//Else if any slot with index 3 or higher is clicked
					int vItemId = visualItemIds.get(slotid - 3);
					switch(vItemId){
						case 0: 
							NetworkHooks.openScreen((ServerPlayer) ply, new MenuProvider() {
								@Override
								public Component getDisplayName() {
									return Component.literal("ForgerRunes");
								}
	
								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									return new ForgerRunesMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos), transferItem);
								}
							}, _bpos);
							break;
						case 1:
							break;
						default: return;
					}
				}
			}
		}
	}

	/**
	 * Refreshes the visual items of this gui at given slot made to link to other gui where the player can precisely modify the selected items' upgrades
	 * 
	 * 
	 */
	private void refreshVisualItems() {
		ItemStack inputItem = internal.getStackInSlot(0);
		CompoundTag upgrades = inputItem.getOrCreateTag().getCompound("Upgrades");
		if (inputItem.getItem() == Items.AIR || upgrades == null)
			return;
		int setSlot = 3; //Reforge and Enchantments are on all items so index is only required at 3 and after
		ItemStack setItem = null;
		ListTag lore = new ListTag();
		//Reforge
		{
			setItem = new ItemStack(ToamodModItems.REFORGE_GEMSTONE.get());
			lore = new ListTag();
			setItem.setHoverName(Component.literal("§r§9Reforge§r"));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("")));
			ReforgeType reforge = ReforgeType.getByName(inputItem.getOrCreateTag().getCompound("Upgrades").getString("reforge"));
			String reforgeString = (reforge == null) ? "§8None§r" : reforge.getProperties().rarity.Prefix + reforge.name.substring(0, 1).toUpperCase() + reforge.name.substring(1);
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Current: " + reforgeString)));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("")));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§eClick to modify§r")));
			setItem.getOrCreateTag().getCompound("display").put("Lore", lore);
			((Slot) customSlots.get(1)).set(setItem);
		}
		//Enchantments
		{
			setItem = new ItemStack(ToamodModItems.ENCHANTMENT_BOOK.get());
			lore = new ListTag();
			setItem.setHoverName(Component.literal("§r§9Enchantments§r"));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("")));
			ArrayList<String> enchs = CustomNbtHandler.enchantsToLoreString(inputItem.getOrCreateTag().getList("Enchantments", 10));
			if (enchs == null || enchs.isEmpty()) {
				lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§8None§r")));
			} else {
				for (int i = 0; i < enchs.size(); i++) {
					lore.add(StringTag.valueOf(StringTag.quoteAndEscape(enchs.get(i))));
				}
			}
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("")));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§eClick to modify§r")));
			setItem.getOrCreateTag().getCompound("display").put("Lore", lore);
			((Slot) customSlots.get(2)).set(setItem);
		}
		//inputItem has Rune-Slots
		if (inputItem.getOrCreateTag().getCompound("display").getList("Lore", 8) != null) {
			setItem = new ItemStack(ToamodModItems.RUNE.get());
			lore = new ListTag();
			setItem.setHoverName(Component.literal("§r§9Runes§r"));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("")));
			String runeString = inputItem.getOrCreateTag().getCompound("display").getList("Lore", 8).get(0).toString().substring(2).replace("\"'","");
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(runeString)));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("")));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§eClick to modify§r")));
			setItem.getOrCreateTag().getCompound("display").put("Lore", lore);
			((Slot) customSlots.get(setSlot)).set(setItem);
			setSlot++;
			visualItemIds.add(0);
		}
		//setItem = new ItemStack(ToamodModItems.MODIFIERS_ICON.get());
		//setItem = new ItemStack(ToamodModItems.STAR.get());
		//setItem = new ItemStack(ToamodModItems.PRESTIGE_ITEM.get());
		//setItem = new ItemStack(ToamodModItems.AUGMENTATIONS_ICON.get());

		entity.containerMenu.broadcastChanges();
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
