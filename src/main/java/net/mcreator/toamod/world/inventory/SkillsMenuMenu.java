
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
import net.mcreator.toamod.ToaSkillHandler;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaAbstractContainerRemovable;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class SkillsMenuMenu extends ToaAbstractContainerRemovable implements Supplier<Map<Integer, Slot>> {
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

	public SkillsMenuMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ToamodModMenus.SKILLS_MENU.get(), id, 5);
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
		for (int i = 0; i < slotCount-1; i++) {
			final int slotid = i;
			this.customSlots.put(slotid, this.addSlot(new SlotItemHandler(internal, slotid, 25 + 36 * i, 20) {
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

		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 79, 52) {
			private final int slot = 4;

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
		if (world.isClientSide())
			return;
		BlockPos _bpos = BlockPos.containing(x, y, z);
		MenuProvider menu = null;

		switch (slotid) {
			case 0 :
				menu = createMenuToOpen("SkillRewardGUI", _bpos, SkillRewardGUIMenu.class, ToaSkillHandler.SkillType.COMBAT);
				break;
			case 1 :
				menu = createMenuToOpen("SkillRewardGUI", _bpos, SkillRewardGUIMenu.class, ToaSkillHandler.SkillType.MINING);

				break;
			case 2 :
				menu = createMenuToOpen("SkillRewardGUI", _bpos, SkillRewardGUIMenu.class, ToaSkillHandler.SkillType.MAGIC);
				break;
			case 3 :
				//TO-DO remove // when cooking skill release
				//menu = createMenuToOpen("SkillRewardGUI", _bpos, SkillRewardGUIMenu.class, ToaSkillHandler.SkillType.COOKING);
				break;
			case 4 :
				menu = createMenuToOpen("PlayerProfile", _bpos, PlayerProfileMenu.class);
			default :
				return;
		}
		NetworkHooks.openScreen((ServerPlayer) entity, menu, _bpos);
	}

	private void refreshVisualItems() {
		ItemStack setItem = null;
		ListTag lore = new ListTag();
		{
			ToamodModVariables.PlayerVariables plyVars = entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables());
			//Combat
			{
				setItem = new ItemStack(Items.DIAMOND_SWORD);
				setVSkillItemTxt(setItem, lore, ToaSkillHandler.SkillType.COMBAT, (int) plyVars.skillAttackLvl, plyVars.skillAttackXp);
				finalizeVItem(setItem, 0, lore);
			}
			//Mining
			{
				setItem = new ItemStack(Items.DIAMOND_PICKAXE);
				lore = new ListTag();
				setVSkillItemTxt(setItem, lore, ToaSkillHandler.SkillType.MINING, (int) plyVars.skillDefenseLvl, plyVars.skillDefenseXp);
				finalizeVItem(setItem, 1, lore);
			}
			//Magic
			{
				setItem = new ItemStack(Items.ENCHANTED_BOOK);
				lore = new ListTag();
				setVSkillItemTxt(setItem, lore, ToaSkillHandler.SkillType.MAGIC, (int) plyVars.skillMagicLvl, plyVars.skillMagicXp);
				finalizeVItem(setItem, 2, lore);
			}
			//Cooking
			{
				setItem = new ItemStack(Items.BARRIER);
				lore = new ListTag();
				setItem.setHoverName(Component.literal("§4§lCOMING SOON"));
				//setVSkillItemTxt(setItem, lore, ToaSkillHandler.SkillType.COOKING, plyVars.skillCookingLvl, plyVars.skillCookingXp);
				//finalizeVItem(setItem, 3, lore);
				setItem.getOrCreateTag().putBoolean("delete", true);
				((Slot) customSlots.get(3)).set(setItem);
			}
			setItem = getBackVItem();
			setItem.getOrCreateTag().putBoolean("delete", true);
			((Slot) customSlots.get(4)).set(setItem);
		}
	}

	private void finalizeVItem(ItemStack setItem, int setSlot, ListTag lore) {
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§eClick to view")));
		setItem.getOrCreateTag().getCompound("display").put("Lore", lore);
		setItem.getOrCreateTag().putInt("HideFlags", 3);
		setItem.getOrCreateTag().putBoolean("delete", true);
		((Slot) customSlots.get(setSlot)).set(setItem);
	}

	private void setVSkillItemTxt(ItemStack setItem, ListTag lore, ToaSkillHandler.SkillType skillType, int skillLvl, double skillXp) {
		double progress = skillXp / (double) ToaSkillHandler.XpForLevelUp[skillLvl];
		setItem.setHoverName(Component.literal("§9" + skillType.Name + " " + ToaFormats.RomanNumbers[skillLvl]));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§8Current level: " + skillLvl)));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape("")));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape(skillType.Description)));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape("")));
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape("§7Progress to Level "+ ToaFormats.RomanNumbers[skillLvl] +": §e" + ToaFormats.doubleToString(progress * 100) + "%")));
		lore.add(StringTag.valueOf(
				StringTag.quoteAndEscape(ToaFormats.getPercentageLine(Math.min(progress, 1), 16) + " §e" + ToaFormats.formatWholeNumber((int) Math.floor(skillXp)) + "§6/§e" + ToaFormats.formatWholeNumber(ToaSkillHandler.XpForLevelUp[skillLvl]))));
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
