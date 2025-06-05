
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
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModMenus;
import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaAbstractContainerRemovable;
import net.mcreator.toamod.StatHandler;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import java.lang.reflect.Constructor;

import io.netty.buffer.Unpooled;

public class PlayerProfileMenu extends ToaAbstractContainerRemovable implements Supplier<Map<Integer, Slot>> {
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

	public PlayerProfileMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ToamodModMenus.PLAYER_PROFILE.get(), id, 7, -1);
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
		for (int i = 0; i < 7; i++) {
			final int slotid = i;
			this.customSlots.put(i, this.addSlot(new SlotItemHandler(internal, i, 13 + 22 * i, 33) {
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
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 0 + 8 + sj * 18, 0 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 0 + 8 + si * 18, 0 + 142));
		refreshVisualItems();
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
		if(world.isClientSide())
			return;
			
		BlockPos _bpos = BlockPos.containing(x, y, z);
		MenuProvider menu = null;
		
		switch(slotid){
			case 0:
				menu = createMenuToOpen("SkillsMenu", _bpos, SkillsMenuMenu.class);
				break;		
			case 1:
				menu = createMenuToOpen("MilestonesMenu", _bpos, MilestonesMenuMenu.class);
				break;
			case 2:
				//menu = createMenuToOpen("PetsMenu", _bpos, PetsMenuMenu.class);
				break;
			case 3:
				menu = createMenuToOpen("PlayerStatsMenu", _bpos, PlayerStatsMenuMenu.class);
				break;
			case 4:
				//TO-DO: menu = createMenuToOpen("GuidesMenu", _bpos, GuidesMenuMenu.class);
				break;
			case 5:
				menu = createMenuToOpen("CollectionMenu", _bpos, CollectionMenuMenu.class);
				break;
			case 6:
				menu = createMenuToOpen("ArtefactsMenu", _bpos, ArtefactsMenuMenu.class);
				break;
			default: return;
		}
		NetworkHooks.openScreen((ServerPlayer) entity, menu, _bpos);
	}

	private void refreshVisualItems() {
		System.out.println("refreshVisual items called");
		ItemStack setItem = null;
		ListTag lore = new ListTag();
		//Skills
		{
			setItem = new ItemStack(Items.DIAMOND_SWORD);
			setItem.setHoverName(Component.literal("§r§9Skills§r"));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
			int combatLevel = (int) (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl;
			int miningLevel = (int) (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillDefenseLvl;
			int magicLevel = (int) (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillMagicLvl;
			//int cookingLevel = entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).skillCookingLvl;
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Combat Level: §9" + combatLevel)));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Mining Level: §9" + miningLevel)));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Magic Level: §9" + magicLevel)));
			//lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§Cooking Level: "+ cookingLevel)));
			setItem.getOrCreateTag().putInt("HideFlags", 2);
			finalizeVItem(setItem, 0, lore);
			System.out.println("Item to put in slot 0: " + setItem.getItem() + " (" + setItem.getDisplayName().getString() + ")");
			System.out.println("item in slot 0: " + (((Slot) customSlots.get(0)).getItem().getItem()));
		}
		//Milestones
		{
			setItem = new ItemStack(Items.NETHERITE_PICKAXE);
			lore = new ListTag();
			setItem.setHoverName(Component.literal("§r§9Milestones§r"));
			int minMileLvl = (int) (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneLvl;
			int comMileLvl = (int) (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl;
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Combat Lvl: §9" + comMileLvl)));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Mining Lvl: §9" + minMileLvl)));
			setItem.getOrCreateTag().putInt("HideFlags", 2);
			finalizeVItem(setItem, 1, lore);

		}
		//Pets
		setItem = new ItemStack(Items.LIGHT_GRAY_STAINED_GLASS_PANE);
		lore = new ListTag();
		setItem.setHoverName(Component.literal("§r§4COOMING SOON§r"));
		//finalizeVItem(setItem, 2, lore);
		//FOR NOW remove following and use above when implemented
			setItem.getOrCreateTag().getCompound("display").put("Lore", lore);
			setItem.getOrCreateTag().putBoolean("delete", true);
			((Slot) customSlots.get(2)).set(setItem);
		//Stats
		{
			setItem = new ItemStack(Items.PLAYER_HEAD);
			lore = new ListTag();
			setItem.setHoverName(Component.literal("§r§9" + entity.getName().getString()));
			System.out.println("player name for stats: " + entity.getName().getString());
			float[] stats = StatHandler.getPlayerStats(entity);
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Health: §c" + ToaFormats.floatToString(stats[8]))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Strength: §c" + ToaFormats.floatToString(stats[0]))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Dexterity: §c" + ToaFormats.floatToString(stats[1]))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Intelligence: §c" + ToaFormats.floatToString(stats[2]))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Wisdom: §c" + ToaFormats.floatToString(stats[3]))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Crit Rate: §c" + ToaFormats.floatToString(stats[4]))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Crit Dmg: §c" + ToaFormats.floatToString(stats[5]))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Lifesteal: §c" + ToaFormats.floatToString(stats[6]))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Armor: §c" + ToaFormats.floatToString(stats[7]))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Magic Res: §c" + ToaFormats.floatToString(stats[9]))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Magic Find: §c" + ToaFormats.floatToString(stats[10]))));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Mining Fortune: §c" + ToaFormats.floatToString(stats[11]))));
			finalizeVItem(setItem, 3, lore);
		}
		//Guide
		setItem = new ItemStack(Items.BOOK);
		lore = new ListTag();
		setItem.setHoverName(Component.literal("§r§9Guides§r"));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Tipps and tricks for many areas of the game.")));
		finalizeVItem(setItem, 4, lore);
		//RNG-Pittysystem
		setItem = new ItemStack(Items.NETHER_STAR);
		lore = new ListTag();
		setItem.setHoverName(Component.literal("§r§9RNG Meter§r"));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Luck based item drop pitty-system.")));
		finalizeVItem(setItem, 5, lore);
		//Artefacts
		setItem = new ItemStack(ToamodModItems.ARTEFACTS_ITEM.get());
		lore = new ListTag();
		setItem.setHoverName(Component.literal("§r§9Artefacts§r"));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Artefacts grant stats and other effects.")));
		finalizeVItem(setItem, 6, lore);
		entity.containerMenu.broadcastChanges();
	}

	private void finalizeVItem(ItemStack setItem, int setSlot, ListTag lore) {
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§eClick to view")));
		setItem.getOrCreateTag().getCompound("display").put("Lore", lore);
		setItem.getOrCreateTag().putBoolean("delete", true);
		((Slot) customSlots.get(setSlot)).set(setItem);
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
