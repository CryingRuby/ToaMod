
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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModMenus;
import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.ToaSkillHandler;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaAbstractContainerRemovable;

import java.util.function.Supplier;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class SkillRewardGUIMenu extends ToaAbstractContainerRemovable implements Supplier<Map<Integer, Slot>> {
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
	private ToaSkillHandler.SkillType skillType;

	public SkillRewardGUIMenu(int id, Inventory inv, FriendlyByteBuf extraData, ToaSkillHandler.SkillType skillType) {
		this(id, inv, extraData);
		this.skillType = skillType;
	}

	public SkillRewardGUIMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ToamodModMenus.SKILL_REWARD_GUI.get(), id, 27);
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
		//first collumn
		for (int i = 0; i < 4; i++) {
			final int setSlot = i;
			this.customSlots.put(i, this.addSlot(new SlotItemHandler(internal, i, 9, 8 + 18 * i) {
				private final int slot = setSlot;

				@Override
				public boolean mayPickup(Player entity) {
					return false;
				}

				@Override
				public boolean mayPlace(ItemStack stack) {
					return false;
				}
			}));
		}
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 27, 62) {
			private final int slot = 4;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}
		}));
		//second collumn
		for (int i = 0; i < 4; i++) {
			final int setSlot = 5 + i;
			this.customSlots.put(5 + i, this.addSlot(new SlotItemHandler(internal, 5 + i, 45, 62 - 18 * i) {
				private final int slot = setSlot;

				@Override
				public boolean mayPickup(Player entity) {
					return false;
				}

				@Override
				public boolean mayPlace(ItemStack stack) {
					return false;
				}
			}));
		}
		this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 63, 8) {
			private final int slot = 9;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}
		}));
		//3rd collum
		for (int i = 0; i < 4; i++) {
			final int setSlot = 10 + i;
			this.customSlots.put(10 + i, this.addSlot(new SlotItemHandler(internal, 10 + i, 81, 8 + 18 * i) {
				private final int slot = setSlot;

				@Override
				public boolean mayPickup(Player entity) {
					return false;
				}

				@Override
				public boolean mayPlace(ItemStack stack) {
					return false;
				}
			}));
		}
		this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 99, 62) {
			private final int slot = 14;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}
		}));
		//4th collumn
		for (int i = 0; i < 4; i++) {
			final int setSlot = 15 + i;
			this.customSlots.put(15 + i, this.addSlot(new SlotItemHandler(internal, 15 + i, 117, 62 - 18 * i) {
				private final int slot = setSlot;

				@Override
				public boolean mayPickup(Player entity) {
					return false;
				}

				@Override
				public boolean mayPlace(ItemStack stack) {
					return false;
				}
			}));
		}
		this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 135, 8) {
			private final int slot = 19;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}
		}));
		//5th collumn (last, +2 slots)
		for (int i = 0; i < 6; i++) {
			final int setSlot = 20 + i;
			this.customSlots.put(20 + i, this.addSlot(new SlotItemHandler(internal, 20 + i, 153, 8 + 18 * i) {
				private final int slot = setSlot;

				@Override
				public boolean mayPickup(Player entity) {
					return false;
				}

				@Override
				public boolean mayPlace(ItemStack stack) {
					return false;
				}
			}));
		}
		//Back slot
		this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 81, 98) {
			private final int slot = 26;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 1 + 8 + sj * 18, 40 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 1 + 8 + si * 18, 40 + 142));

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

	private void refreshVisualItems() {
		if(skillType == null)
			return;

		ToamodModVariables.PlayerVariables capability = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables()));
		int skillLvl = 0;
		double skillXp = 0.0;
		ItemStack setItem = null;
		ListTag lore = new ListTag();
		switch (this.skillType) {
			case COMBAT :
				skillLvl = (int) capability.skillAttackLvl;
				skillXp = capability.skillAttackXp;
				setItem = new ItemStack(Items.GOLDEN_SWORD);
			case MINING :
				skillLvl = (int) capability.skillDefenseLvl;
				skillXp = capability.skillDefenseXp;
				setItem = new ItemStack(Items.GOLDEN_PICKAXE);
			case MAGIC :
				skillLvl = (int) capability.skillMagicLvl;
				skillXp = capability.skillMagicXp;
				setItem = new ItemStack(Items.ENCHANTED_BOOK);
			case COOKING :
				skillLvl = (int) capability.skillCookingLvl;
				skillXp = capability.skillCookingXp;
				setItem = new ItemStack(Items.GOLDEN_APPLE);
			default :
		};
		//Slot 0
		{
			setItem.setHoverName(Component.literal("§a" + skillType.Name + " Skill"));
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(skillType.Description)));
			finalizeItem(setItem, 0, lore);
		}
		//Other VItem slots
		for (int i = 1; i < customSlots.size(); i++) {
			String color;
			lore = new ListTag();
			if (i < skillLvl) {
				setItem = new ItemStack(((i % 5 == 0) ? Items.EMERALD_BLOCK : Items.LIME_DYE));
				color = "§a";
			} else {
				setItem = new ItemStack(((i % 5 == 0) ? Items.REDSTONE_BLOCK : ToamodModItems.DARK_RED_DYE.get()));
				color = "§c";
			}

			setItem.setHoverName(Component.literal(color + skillType.Name + " Level " + ToaFormats.RomanNumbers[skillLvl]));
			setVSkillItemTxt(lore, skillLvl);
			addUnlockedStateToLore(lore, i, skillLvl, skillXp);
			finalizeItem(setItem, i, lore);

		}
		//Go-Back Slot
		((Slot) customSlots.get(slotCount - 1)).set(getBackVItem());

	}

	//This time only activates
	private void slotChanged() {
		BlockPos _bpos = new BlockPos(x, y, z);
		NetworkHooks.openScreen((ServerPlayer) entity, createMenuToOpen("SkillsMenu", _bpos, SkillsMenuMenu.class), _bpos);
	}

	private void setVSkillItemTxt(ListTag lore, int skillLvl) {
		List<String> rewards = ToaSkillHandler.getSkillRewardStrings(skillLvl, skillType);
		if (rewards == null)
			return;
		for (String c : rewards) {
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(c)));
		}
	}

	private void addUnlockedStateToLore(ListTag lore, int lvlIndex, int playerSkillLvl, double playerSkillXp) {
		double progress = playerSkillXp / (double) ToaSkillHandler.XpForLevelUp[playerSkillLvl];
		String unlockedState = (lvlIndex <= playerSkillLvl)
				? "§aUNLOCKED"
				: ToaFormats.getPercentageLine(Math.min(progress, 1), 16) + " §e" + ToaFormats.doubleToString(playerSkillXp) + "§6/§e" + ToaFormats.formatWholeNumber(ToaSkillHandler.XpForLevelUp[playerSkillLvl]);
		lore.add(StringTag.valueOf(StringTag.quoteAndEscape(unlockedState)));
	}

	private void finalizeItem(ItemStack setItem, int setSlot, ListTag lore) {
		setItem.getOrCreateTag().putBoolean("delete", true);
		setItem.getOrCreateTag().getCompound("display").put("Lore", lore);
		((Slot) customSlots.get(setSlot)).set(setItem);
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
