
package net.mcreator.toamod.world.inventory;

import org.checkerframework.checker.units.qual.s;

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
import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaAbstractContainerRemovable;
import net.mcreator.toamod.StatHandler;
import net.mcreator.toamod.ReforgeType;
import net.mcreator.toamod.CustomNbtHandler;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class ForgerReforgeMenu extends ToaAbstractContainerRemovable implements Supplier<Map<Integer, Slot>> {
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

	/**
	 * Basically only for the registration, NOT used directly (only through the Constructor with ItemStack)
	 * 
	 */
	public ForgerReforgeMenu(int id, Inventory inv, FriendlyByteBuf extraData, ItemStack boundItem) {
		this(id, inv, extraData);

		//transfer mofifying item from prior gui   -> throws NullPointerException if called without the ItemStack Gui interface
		((Slot) customSlots.get(0)).set(boundItem);
		refreshVisualItems();
		((Slot) customSlots.get(slotCount-1)).set(getBackVItem());
	}
	public ForgerReforgeMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ToamodModMenus.FORGER_REFORGE.get(), id, 14, 0);
		System.out.println("ForgerReforges - after super called. slotCount: "+slotCount);
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

		this.customSlots.put(slotCount-1, this.addSlot(new SlotItemHandler(internal, slotCount-1, 35, 57) {
			private final int slot = slotCount-1;

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

	/*public ForgerReforgeMenu(int id, Inventory inv, FriendlyByteBuf extraData, ItemStack boundItem) {
		this(id, inv, extraData);
		//transfer mofifying item from prior gui   -> throws NullPointerException if called without the ItemStack Gui interface
		((Slot) customSlots.get(0)).set(boundItem);
		refreshVisualItems();
	}*/

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
		ItemStack boundItem = ((Slot) customSlots.get(0)).getItem();
		if (slotid == 0 || slotid == slotCount-1) {
			setExitedByESC(false);
			NetworkHooks.openScreen((ServerPlayer) entity, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("ForgerReforge");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new ForgerGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos), boundItem);
				}
			}, _bpos);
			return;
		}
		//other slots -> change Reforges

		ReforgeType appliedReforge = ReforgeType.getByName(boundItem.getOrCreateTag().getCompound("Upgrades").getString("reforge"));
		ReforgeType[] possibleReforges = ReforgeType.getAllByType(ToaItemType.getByName(boundItem.getOrCreateTag().getString("type")));

		//apply cost
		int bItemRarity = ((Slot) customSlots.get(0)).getItem().getOrCreateTag().getInt("rarity");
		int playerCor = StatHandler.getPlayerCor(entity);
		ItemStack gemItem = new ItemStack(ToamodModItems.REFORGE_GEMSTONE.get());
		gemItem.getOrCreateTag().putString("reforge", possibleReforges[slotid - 1].getName());
		boolean hasGemItem = entity.getInventory().findSlotMatchingItem(gemItem) > -1;
		
		if (slotid > possibleReforges.length || !(entity instanceof ServerPlayer) || playerCor < possibleReforges[slotid - 1].getApplyCost(bItemRarity) || !hasGemItem || appliedReforge == possibleReforges[slotid - 1]){
			refreshVisualItems(slotid - 1, slotid);
			return;
		}
			

		//apply apply-cost
		StatHandler.addPlayerCor(entity, -1 * possibleReforges[slotid - 1].getApplyCost(bItemRarity));
		entity.getInventory().items.get(entity.getInventory().findSlotMatchingItem(gemItem)).shrink(1);
		//TO-DO remove gemItem
			
		//remove stats from current reforge
		if (appliedReforge != null) {
			System.out.println("substract current reforge: " + appliedReforge);
			ToaProperties.applyReforgeToItem(appliedReforge, boundItem, -1);
		}
		//apply selected reforge
		System.out.println("add selected reforge: " + possibleReforges[slotid - 1]);
		ToaProperties.applyReforgeToItem(possibleReforges[slotid - 1], boundItem, 1);
		for (int i = 1; i < customSlots.size(); i++) {
			((Slot) customSlots.get(i)).set(ItemStack.EMPTY);
		}
		CompoundTag upgr = boundItem.getOrCreateTag().getCompound("Upgrades");
		upgr.putString("reforge", possibleReforges[slotid - 1].getName());
		boundItem.getOrCreateTag().put("Upgrades", upgr);
		//Refresh Item lore to display changes
		CustomNbtHandler.setLoreOfItem(boundItem);
		setExitedByESC(false);
		NetworkHooks.openScreen((ServerPlayer) entity, new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.literal("ForgerReforge");
			}

			@Override
			public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
				return new ForgerGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos), boundItem);
			}
		}, _bpos);
	}

	public int getSizeReforges() {
		ItemStack boundItem = ((Slot) customSlots.get(0)).getItem();
		if(boundItem.isEmpty())
			return 0;
		return ReforgeType.getAllByType(ToaItemType.getByName(boundItem.getOrCreateTag().getString("type"))).length;
	}

	private void refreshVisualItems() {
		refreshVisualItems(0, -1);
	}

	/**
	 * refreshes the visual items from slot begin (inclusive) to end (exclusive)
	 * @param inclusive
	 * @param exclusive
	 */
	private void refreshVisualItems(int begin, int end) {
		ItemStack boundItem = ((Slot) customSlots.get(0)).getItem();
		//boundItem should never be null/non-existing
		if (boundItem == null || boundItem.getItem() == Items.AIR || begin < 0 || end < -1)
			return;
		//set reforge items in slot
		ReforgeType appliedReforge = ReforgeType.getByName(boundItem.getOrCreateTag().getCompound("Upgrades").getString("reforge"));
		ReforgeType[] possibleReforges = ReforgeType.getAllByType(ToaItemType.getByName(boundItem.getOrCreateTag().getString("type")));
		int rarity = boundItem.getOrCreateTag().getInt("rarity");
		//Set items in Slots
		int tillSlot = ((end == -1) ? possibleReforges.length : end);
		for (int i = begin; i < tillSlot; i++) {
			ItemStack setItem = new ItemStack(ToamodModItems.REFORGE_GEMSTONE.get());
			setItem.getOrCreateTag().putString("reforge", possibleReforges[i].getName());
			//Add lore with stats for the specific item-rarity
			ToaProperties reforgeProps = possibleReforges[i].getProperties();
			ListTag lore = new ListTag();
			//Go through each present stat and collect Stat-Name and the value of that stat with the items rarity
			for (int s = 0; s < reforgeProps.getPresentIDs().size(); s++) {
				byte currId = reforgeProps.getPresentIDs().get(s);
				float statValue = reforgeProps.getValueByID(currId)[rarity];
				if (statValue == 0) {
					continue;
				}
				String loreString = "§7" + reforgeProps.getStatNameByID(currId) + ": §c" + ((statValue > 0) ? "+" : "") + ToaFormats.floatToString(statValue); //"-" comes from negative number
				if (currId >= 5 && currId <= 7)
					loreString += "%";
				lore.add(StringTag.valueOf(StringTag.quoteAndEscape(loreString)));
			}
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
			boolean isAlreadyApplied = appliedReforge != null && appliedReforge == possibleReforges[i];
			//if item has reforge mark applied reforge with enchantment texture + text
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(((isAlreadyApplied) ? "§aAlready applied" : "§eCost to apply:"))));
			if (isAlreadyApplied) {
				setItem.enchant(null, 0);
			} else {
				int playerCor = StatHandler.getPlayerCor(entity);
				ItemStack gemItem = new ItemStack(ToamodModItems.REFORGE_GEMSTONE.get());
				gemItem.getOrCreateTag().putString("reforge", possibleReforges[i].getName());
				boolean hasGemItem = entity.getInventory().findSlotMatchingItem(gemItem) > -1;
				System.out.println("player-cor: " + playerCor + " hasGemItemInInv: " + hasGemItem);

				lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§8- §6" + possibleReforges[i].getApplyCost(rarity) + " Cor " + ToaFormats.indicatorByBool(playerCor >= possibleReforges[i].getApplyCost(rarity)))));
				lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§8- §71x §fGemstone (§7" + ToaFormats.firstCharToUpper(possibleReforges[i].getName()) + "§f) " + ToaFormats.indicatorByBool(hasGemItem))));
			}
			CompoundTag display = new CompoundTag();
			display.put("Lore", lore);
			setItem.getOrCreateTag().put("display", display);
			setItem.setHoverName(Component.literal("§r§fGemstone (§7" + ToaFormats.firstCharToUpper(possibleReforges[i].getName()) + "§r§f)"));
			setItem.getOrCreateTag().putBoolean("delete", true);
			System.out.println("	set reforge-item in slot: "+ (i+1));
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
		}
		for (int i = 1; i < slotCount; i++) {
			((Slot) customSlots.get(i)).set(ItemStack.EMPTY);
		}
	}


	public Map<Integer, Slot> get() {
		return customSlots;
	}


}
