
package net.mcreator.toamod.world.inventory;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
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
import net.mcreator.toamod.ReforgeType;
import net.mcreator.toamod.CustomNbtHandler;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class ForgerReforgeMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
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
	private int sizeReforges;

	/**
	 * Basically only for the registration, NOT used directly (only through the Constructor with ItemStack)
	 * 
	 */
	public ForgerReforgeMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ToamodModMenus.FORGER_REFORGE.get(), id);
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
		if (pos != null) {
			boundBlockEntity = this.world.getBlockEntity(pos);
			if (boundBlockEntity != null)
				boundBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					this.internal = capability;
					this.bound = true;
				});
		}
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 35, 37) {
			private final int slot = 0;

			@Override
			public void onTake(Player entity, ItemStack stack) {
				super.onTake(entity, stack);
				slotChanged(slot, 1, 0);
			}
		}));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				final int slotid = i * 4 + j + 1;
				this.customSlots.put(slotid, this.addSlot(new SlotItemHandler(internal, slotid, 89 + 18 * j, 19 + 18 * i) {
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
		System.out.println("Constructor of ReforgeMenu finished");
	}

	public ForgerReforgeMenu(int id, Inventory inv, FriendlyByteBuf extraData, ItemStack boundItem) {
		this(id, inv, extraData);
		System.out.println("Constructor of ForgerReforgeMenu call");
		//transfer mofifying item from prior gui   -> throws NullPointerException if called without the ItemStack Gui interface
		((Slot) customSlots.get(0)).set(boundItem);
		//set reforge items in slot
		ReforgeType appliedReforge = ReforgeType.getByName(boundItem.getOrCreateTag().getCompound("Upgrades").getString("reforge"));
		System.out.println("item in slot 0: " + boundItem.getItem() + ", type:  " + ToaItemType.getByName(boundItem.getOrCreateTag().getString("type")));
		ReforgeType[] possibleReforges = ReforgeType.getByType(ToaItemType.getByName(boundItem.getOrCreateTag().getString("type")));
		System.out.println("possible reforges length: " + possibleReforges.length);
		int rarity = boundItem.getOrCreateTag().getInt("rarity");
		this.sizeReforges = possibleReforges.length;
		//Set items in Slots
		for (int i = 0; i < possibleReforges.length; i++) {
			ItemStack setItem = new ItemStack(ToamodModItems.REFORGE_GEMSTONE.get());
			System.out.println("	put String: \"reforge\", \"" + possibleReforges[i].name + "\" , id: " + possibleReforges[i].getID());
			setItem.getOrCreateTag().putString("reforge", possibleReforges[i].name);
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
			CompoundTag display = new CompoundTag();
			display.put("Lore", lore);
			setItem.getOrCreateTag().put("display", display);
			setItem.setHoverName(Component.literal("§r§fGemstone (§7" + ToaFormats.firstCharToUpper(possibleReforges[i].name) + "§r§f)"));
			//if item has reforge mark applied reforge with enchantment texture + text
			if (appliedReforge != null && appliedReforge == possibleReforges[i]) {
				setItem.enchant(null, 0);
			}
			((Slot) customSlots.get(i + 1)).set(setItem.copy());
		}
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
			if (index < 2) {
				if (!this.moveItemStackTo(itemstack1, 2, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 2, false)) {
				if (index < 2 + 27) {
					if (!this.moveItemStackTo(itemstack1, 2 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 2, 2 + 27, false))
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

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					playerIn.drop(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					playerIn.getInventory().placeItemBackInInventory(internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
				}
			}
		}
	}

	private void slotChanged(int slotid, int ctype, int meta) {
		if (slotid == 0) {
			entity.closeContainer();
			return;
		}
		//other slots -> change Reforges
		ItemStack boundItem = ((Slot) customSlots.get(0)).getItem();
		ReforgeType appliedReforge = ReforgeType.getByName(boundItem.getOrCreateTag().getCompound("Upgrades").getString("reforge"));
		ReforgeType[] possibleReforges = ReforgeType.getByType(ToaItemType.getByName(boundItem.getOrCreateTag().getString("type")));
		if (slotid > possibleReforges.length || !(entity instanceof ServerPlayer))
			return;
		//remove stats from current reforge
		if (appliedReforge != null) {
			if (appliedReforge == possibleReforges[slotid-1])
				return;
			System.out.println("substract current reforge: " + appliedReforge);
			ToaProperties.applyReforgeToItem(appliedReforge, boundItem, -1);
		}
		//apply selected reforge
		System.out.println("add selected reforge: " + possibleReforges[slotid-1]);
		ToaProperties.applyReforgeToItem(possibleReforges[slotid-1], boundItem, 1);
		for (int i = 1; i < customSlots.size(); i++) {
			((Slot) customSlots.get(i)).set(ItemStack.EMPTY);
		}

		CompoundTag upgr = boundItem.getOrCreateTag().getCompound("Upgrades");
		upgr.putString("reforge", possibleReforges[slotid-1].name);
		
		//Refresh Item lore to display changes
		CustomNbtHandler.setLoreOfItem(boundItem);

		BlockPos _bpos = BlockPos.containing(x, y, z);
		System.out.println("try open forgerGuiMenu");
		NetworkHooks.openScreen((ServerPlayer) entity, new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.literal("ForgerReforge");
			}

			@Override
			public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
				return new ForgerGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
			}
		}, _bpos);
	}

	public int getSizeReforges() {
		ItemStack boundItem = ((Slot) customSlots.get(0)).getItem();
		ReforgeType[] possibleReforges = ReforgeType.getByType(ToaItemType.getByName(boundItem.getOrCreateTag().getString("type")));
		return possibleReforges.length;
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}

	private void selectReforge(int slotid) {
	}
}
