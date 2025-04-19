
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

import net.mcreator.toamod.init.ToamodModMenus;
import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantmentHandler;
import net.mcreator.toamod.ToaEnchantment;
import net.mcreator.toamod.ToaAbstractContainerRemovable;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import io.netty.buffer.Unpooled;

public class ForgerEnchantsMenu extends ToaAbstractContainerRemovable implements Supplier<Map<Integer, Slot>> {
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

	private ArrayList<Integer> blockedSlots = new ArrayList<>();

	public ForgerEnchantsMenu(int id, Inventory inv, FriendlyByteBuf extraData, ItemStack boundItem) {
		this(id, inv, extraData);
		((Slot) customSlots.get(0)).set(boundItem);
		refreshVisualItems();
		((Slot) customSlots.get(slotCount - 1)).set(getBackVItem());
	}

	public ForgerEnchantsMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ToamodModMenus.FORGER_ENCHANTS.get(), id, 14, 0);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(slotCount);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
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
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 35, 21) {
			private final int slot = 0;

			@Override
			public void onTake(Player entity, ItemStack stack) {
				super.onTake(entity, stack);
				slotChanged(0, 1, 0);
			}
		}));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				final int slotid = i * 4 + j + 1;
				this.customSlots.put(slotid, this.addSlot(new SlotItemHandler(internal, slotid, 80 + 18 * j, 21 + 18 * i) {
					private final int slot = slotid;

					@Override
					public boolean mayPlace(ItemStack stack) {
						return false;
					}

					@Override
					public void onTake(Player entity, ItemStack stack) {
						super.onTake(entity, stack);
						ItemStack boundItem = internal.getStackInSlot(0);
						ToaEnchantment selectedEnchant = ToaEnchantmentHandler.getEnchantsByType(ToaItemType.getByName(boundItem.getOrCreateTag().getString("type")))[slotid - 1];
						internal.getStackInSlot(1).getOrCreateTag().putInt("vSlotCount", selectedEnchant.getMaxLevel() - selectedEnchant.getMinLevel() + 1);
						System.out.println("vSlotCount: "+ (selectedEnchant.getMaxLevel() - selectedEnchant.getMinLevel() + 1));
						System.out.println("item nbt string: "+internal.getStackInSlot(1).getOrCreateTag());
						slotChanged(slot, 1, 0);
					}
				}));
			}
		}
		this.customSlots.put(slotCount - 1, this.addSlot(new SlotItemHandler(internal, slotCount - 1, 35, 57) {
			private final int slot = slotCount - 1;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}

			@Override
			public void onTake(Player entity, ItemStack stack) {
				super.onTake(entity, stack);
				slotChanged(slot, 1, 0);
			}
		}));
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


	private void slotChanged(int slotid, int ctype, int meta) {
		if (world.isClientSide())
			return;

		clearIllegalVItems(entity);

		BlockPos _bpos = BlockPos.containing(x, y, z);
		ItemStack boundItem = internal.getStackInSlot(0);
		if (slotid == 0 || slotid == slotCount - 1) {
			((Slot) customSlots.get(1)).set(ItemStack.EMPTY);
			setExitedByESC(false);
			NetworkHooks.openScreen((ServerPlayer) entity, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("ForgerGui");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new ForgerGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
			return;
		}

		//If enchantment is incompatible with any applied enchant disable click redirection
		if(blockedSlots.contains(slotid)){
			System.out.println("enchant is blocked by other refreshVItems + return | EnchantsMenu");
			refreshVisualItems(slotid - 1, slotid);
			return;
		}
		
		ToaEnchantment selectedEnchant = ToaEnchantmentHandler.getEnchantsByType(ToaItemType.getByName(boundItem.getOrCreateTag().getString("type")))[slotid - 1];
		
		//open sub screen
		setExitedByESC(false);
		NetworkHooks.openScreen((ServerPlayer) entity, new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.literal("ForgerEnchantsApply");
			}

			@Override
			public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
				return new ForgerEnchantsApplyMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos), boundItem, selectedEnchant);
			}
		}, _bpos);
	}

	public int getSizeEnchants() {
		ItemStack boundItem = internal.getStackInSlot(0);
		return ToaEnchantmentHandler.getEnchantsByType(ToaItemType.getByName(boundItem.getOrCreateTag().getString("type"))).length;
	}

	private void refreshVisualItems() {
		refreshVisualItems(0, -1);
	}

	/**
	 * refreshes the visual items from slot begin (inclusive) to end (exklusive)
	 * @param inclusive
	 * @param exklusive
	 */
	private void refreshVisualItems(int begin, int end) {
		ItemStack boundItem = internal.getStackInSlot(0);
		//boundItem should never be null/non-existing
		if (boundItem == null || boundItem.getItem() == Items.AIR || begin < 0 || end < -1)
			return;
		blockedSlots = new ArrayList<>();
		
		ArrayList<ToaEnchantment> appliedEnchants = ToaEnchantmentHandler.getEnchantsByNBT(boundItem.getOrCreateTag().getList("Enchantments", 10));
		ToaEnchantment[] possibleEnchants = ToaEnchantmentHandler.getEnchantsByType(ToaItemType.getByName(boundItem.getOrCreateTag().getString("type")));
		int tillSlot = ((end == -1) ? possibleEnchants.length : end);
		
		for (int i = begin; i < tillSlot; i++) {
			ItemStack setItem = new ItemStack(ToamodModItems.ENCHANTMENT_BOOK.get());
			ListTag lore = new ListTag();
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§8Max Level: "+possibleEnchants[i].getDescription(possibleEnchants[i].getMaxLevel()))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));

			//test if incompatible enchant is already applied to the item
			for (int j = 0; j < appliedEnchants.size(); j++) {
				if (possibleEnchants[i].equalEnchantTypes(appliedEnchants.get(j))) {
					lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§eCurrent Level: §9" + boundItem.getOrCreateTag().getList("Enchantments", 10).getCompound(j).getInt("lvl"))));
					lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
					setItem.enchant(null, 0);
					//if enchant is applied it can't be applied twice nor incompatible with applied enchants -> end for
					break;
				} 
				else if (!possibleEnchants[i].isCompatibleWith(appliedEnchants.get(j))) { 
					//If enchant is not applied it checks if it can be applied
					lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§4Incompatible enchants applied:")));
					lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§c- "+appliedEnchants.get(j).getEnchantName())));
					lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
					lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§cRemove the enchant to apply this.")));
					blockedSlots.add(i+1);
					//if it's not compatible it can't be applied -> end for
					break;
				}
				
			}
			//if enchant in slot i is not blocked by any applied enchant add Lore line
			if (blockedSlots.isEmpty() || blockedSlots.get(blockedSlots.size() - 1) != i + 1)
				lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§eClick to modify")));
			CompoundTag display = new CompoundTag();
			display.put("Lore", lore);
			setItem.getOrCreateTag().put("display", display);
			setItem.setHoverName(Component.literal("§9" + possibleEnchants[i].getEnchantName() + " §7(" + ToaFormats.RomanNumbers[possibleEnchants[i].getMinLevel()] + "-" + ToaFormats.RomanNumbers[possibleEnchants[i].getMaxLevel()] + "§7)§r"));
			setItem.getOrCreateTag().putBoolean("delete", true);
			((Slot) customSlots.get(i + 1)).set(setItem.copy());
		}
		entity.containerMenu.broadcastChanges();
	}

	/**
	 * Only drops the item in the nonVItemSlot
	 */
	@Override
	public void removed(Player playerIn) {
		if(world.isClientSide())
			return;
		super.removed(playerIn);
		if (playerIn instanceof ServerPlayer serverPlayer && serverPlayer.hasDisconnected()) {
			playerIn.drop(internal.extractItem(0, internal.getStackInSlot(0).getCount(), false), false);
		}

		if(isExitedByESC()){
			playerIn.getInventory().placeItemBackInInventory(internal.extractItem(0, internal.getStackInSlot(nonVItemSlot).getCount(), false));
			((Slot) customSlots.get(0)).set(ItemStack.EMPTY);
			((Slot) customSlots.get(1)).set(ItemStack.EMPTY);
		}
		for (int i = 2; i < slotCount; i++) {
			((Slot) customSlots.get(i)).set(ItemStack.EMPTY);
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
