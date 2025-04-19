
package net.mcreator.toamod.world.inventory;

import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
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
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.init.ToamodModMenus;
import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.init.ToamodModEnchantments;
import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantmentHandler;
import net.mcreator.toamod.ToaEnchantment;
import net.mcreator.toamod.ToaAbstractContainerRemovable;
import net.mcreator.toamod.CustomNbtHandler;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class ForgerEnchantsApplyMenu extends ToaAbstractContainerRemovable implements Supplier<Map<Integer, Slot>> {
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
	private ToaEnchantment boundEnchant;

	public ForgerEnchantsApplyMenu(int id, Inventory inv, FriendlyByteBuf extraData, ItemStack boundItem, ToaEnchantment enchant) {
		this(id, inv, extraData);
		this.boundEnchant = enchant;
		((Slot) customSlots.get(0)).set(boundItem);
		refreshVisualItems();
		((Slot) customSlots.get(slotCount - 1)).set(getBackVItem());
	}

	public ForgerEnchantsApplyMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ToamodModMenus.FORGER_ENCHANTS_APPLY.get(), id, 14, 0);
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
		if (slotid == 0) {
			setExitedByESC(false);
			NetworkHooks.openScreen((ServerPlayer) entity, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("ForgerGui");
				}
				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new ForgerGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos), boundItem);
				}
			}, _bpos);
			return;
		}
		if (slotid == slotCount - 1) {
			setExitedByESC(false);
			NetworkHooks.openScreen((ServerPlayer) entity, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("ForgerEnchants");
				}
				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new ForgerEnchantsMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos), boundItem);
				}
			}, _bpos);
			return;
		}
		
		//apply new enchantment level
		int appliedLevel = boundItem.getEnchantmentLevel(boundEnchant);
		int newLevel = boundEnchant.getMinLevel() + slotid - 1;
		ToaProperties props = boundEnchant.getProperties();
		//Check if requirements are fulfilled
		
		//if slot of applied Level is selected remove the enchant and return to enchant gui
		if(slotid == appliedLevel){
			Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(boundItem);
			if (_enchantments.containsKey(boundEnchant)) {
				_enchantments.remove(boundEnchant);
				EnchantmentHelper.setEnchantments(_enchantments, boundItem);
			}
			if(!boundEnchant.getProperties().getPresentIDs().isEmpty())
				ToaProperties.applyEnchantToItem(boundEnchant, boundItem, appliedLevel - 1, -1);
			CustomNbtHandler.setLoreOfItem(boundItem);

			setExitedByESC(false);
			NetworkHooks.openScreen((ServerPlayer) entity, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("ForgerEnchants");
				}
				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new ForgerEnchantsMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos), boundItem);
				}
			}, _bpos);
			return;
		}

		ItemStack enchItem = new ItemStack(ToamodModItems.ENCHANTMENT_BOOK.get());
		enchItem.enchant(boundEnchant, boundEnchant.getMaxLevel());
		boolean hasEnchItem = entity.getInventory().findSlotMatchingItem(enchItem) > -1;
		int xpCost = boundEnchant.getXpCost()[slotid - 1];

		System.out.println("Ply has EnchItem: "+hasEnchItem+",	Ench Item: "+enchItem.getOrCreateTag());
		
		if (slotid == appliedLevel || entity.experienceLevel < xpCost || (slotid == boundEnchant.getMaxLevel() && !hasEnchItem)) {
			refreshVisualItems(slotid, slotid);
			System.out.println("Requirements NOT met! ply xp lvls: " + entity.experienceLevel + " < " + xpCost + " => " + (entity.experienceLevel < xpCost));
			return;
		}
		
		System.out.println("appliedLevel: " + appliedLevel + ", newLevel: " + newLevel);
		//apply apply-cost
		entity.experienceLevel -= xpCost;
		if (slotid == boundEnchant.getMaxLevel()){
			entity.getInventory().items.get(entity.getInventory().findSlotMatchingItem(enchItem)).shrink(1);
		}
		if (props != null && !props.getPresentIDs().isEmpty()) {
			if (appliedLevel > 0) {
				System.out.println("remove enchant " + boundEnchant.getEnchantName() + " at index: " + (appliedLevel - 1));
				ToaProperties.applyEnchantToItem(boundEnchant, boundItem, appliedLevel - 1, -1);
			}
			System.out.println("add enchant " + boundEnchant.getEnchantName() + " at index: " + (newLevel - 1));
			ToaProperties.applyEnchantToItem(boundEnchant, boundItem, newLevel - 1, 1);
 
		}
		//apply enchantment to item
		System.out.println("###Data before enchant boundItemTag:	"+boundItem.getOrCreateTag());
		ToaEnchantmentHandler.enchantItem(boundItem, boundEnchant, newLevel);
		//((Slot) customSlots.get(0)).set(boundItem);
		System.out.println("###Data before setLore boundItemTag:	"+boundItem.getOrCreateTag());
		CustomNbtHandler.setLoreOfItem(boundItem);
		
		entity.containerMenu.broadcastChanges();
		setExitedByESC(false);
		NetworkHooks.openScreen((ServerPlayer) entity, new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.literal("ForgerEnchants");
			}
			@Override
			public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
				return new ForgerEnchantsMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos), boundItem);
			}
		}, _bpos);
	}

	public int getEnchantLevels() {
		if (boundEnchant == null) {
			ItemStack boundItem = internal.getStackInSlot(1);
			int enchLvls = boundItem.getOrCreateTag().getInt("vSlotCount");
			boundItem.getOrCreateTag().remove("vSlotCount");
			return enchLvls;
		} else {
			return boundEnchant.getMaxLevel() - boundEnchant.getMinLevel() + 1;
		}
	}

	private void refreshVisualItems() {
		refreshVisualItems(1, -1);
	}

	/**
	 * refreshes the visual items from slot begin (inclusive) to end (inclusive)
	 * @param inclusive
	 * @param inclusive
	 */
	private void refreshVisualItems(int begin, int end) {
		ItemStack boundItem = internal.getStackInSlot(0);
		//boundItem should never be null/non-existing
		if (boundItem == null || boundItem.getItem() == Items.AIR || begin < 0 || end < -1)
			return;
		int appliedLevel = boundItem.getEnchantmentLevel(boundEnchant);
		int[] xpCost = boundEnchant.getXpCost();
		int tillSlot = ((end == -1) ? getEnchantLevels() : end);
		System.out.println("tillSlot: " + tillSlot);

		ItemStack enchItem = new ItemStack(ToamodModItems.ENCHANTMENT_BOOK.get());
		enchItem.enchant(boundEnchant, boundEnchant.getMaxLevel());
		boolean hasEnchItem = entity.getInventory().findSlotMatchingItem(enchItem) > -1;
		
		for (int i = begin; i <= tillSlot; i++) {
			ItemStack setItem = new ItemStack(ToamodModItems.ENCHANTMENT_BOOK.get());
			ListTag lore = new ListTag();
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(boundEnchant.getDescription(i))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
			if (i == appliedLevel) {
				lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§aAlready applied§r")));
				lore.add(StringTag.valueOf(StringTag.quoteAndEscape("")));
				lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§cClick to remove")));
			} else {
				lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§eCost to apply:§r")));
				lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§8- §3" + xpCost[i - 1] + " Levels "+ToaFormats.indicatorByBool(entity.experienceLevel >= xpCost[i - 1]))));
				if (i == boundEnchant.getMaxLevel())
					lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§8- §71x §9Enchantment Book§7(" + boundEnchant.getEnchantName() + " " + ToaFormats.RomanNumbers[boundEnchant.getMaxLevel()] + ")§r "+ToaFormats.indicatorByBool(hasEnchItem))));
			}
			setItem.setHoverName(boundEnchant.getFullname(i));
			setItem.getOrCreateTag().getCompound("display").put("Lore", lore);
			setItem.getOrCreateTag().putBoolean("delete", true);
			((Slot) customSlots.get(i)).set(setItem.copy());
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
		}
		for (int i = 1; i < slotCount; i++) {
			((Slot) customSlots.get(i)).set(ItemStack.EMPTY);
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
