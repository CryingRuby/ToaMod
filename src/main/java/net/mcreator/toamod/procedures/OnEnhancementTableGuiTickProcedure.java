package net.mcreator.toamod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.init.ToamodModEnchantments;

import java.util.function.Supplier;
import java.util.Map;

public class OnEnhancementTableGuiTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack finalItem = ItemStack.EMPTY;
		double trueEnchLvl = 0;
		if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == ToamodModItems.ENCHANTMENT_BOOK
						.get()) {
			finalItem = ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).copy());
			trueEnchLvl = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("enchlvl");
			if (("Sword")
					.equals((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("type"))) {
				if (("Sharpness").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get()) == trueEnchLvl
										&& 9 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get()))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					finalItem.getOrCreateTag().putDouble("AD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD")
									+ 4 * (trueEnchLvl - (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get()))));
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.SHARPNESS.get())) {
							_enchantments.remove(ToamodModEnchantments.SHARPNESS.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.SHARPNESS.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if (("Executing").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.EXECUTING.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.EXECUTING.get()) == trueEnchLvl
										&& 5 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.EXECUTING.get()))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.EXECUTING.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.EXECUTING.get())) {
							_enchantments.remove(ToamodModEnchantments.EXECUTING.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.EXECUTING.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if (("Lifesteel").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get()) == trueEnchLvl
										&& 3 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get()))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.LIFESTEAL.get())) {
							_enchantments.remove(ToamodModEnchantments.LIFESTEAL.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.LIFESTEAL.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if (("Critical").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.CRITICAL.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.CRITICAL.get()) == trueEnchLvl
										&& 6 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.CRITICAL.get()))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.CRITICAL.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					finalItem.getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD")
									+ 10 * (trueEnchLvl - (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(ToamodModEnchantments.CRITICAL.get()))));
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.CRITICAL.get())) {
							_enchantments.remove(ToamodModEnchantments.CRITICAL.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.CRITICAL.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if (("ManaFlow").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get()) == trueEnchLvl
										&& 3 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get()))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					finalItem.getOrCreateTag().putDouble("MANA",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MANA")
									+ 20 * (trueEnchLvl - (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get()))));
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.MANAFLOW.get())) {
							_enchantments.remove(ToamodModEnchantments.MANAFLOW.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.MANAFLOW.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if (("Scavenger").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.SCAVENGER.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.SCAVENGER.get()) == trueEnchLvl
										&& 3 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.SCAVENGER.get()))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.SCAVENGER.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.SCAVENGER.get())) {
							_enchantments.remove(ToamodModEnchantments.SCAVENGER.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.SCAVENGER.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (("Staff")
					.equals((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("type"))
					&& "Powerful,ManaFlow".contains((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getString("enchantment"))) {
				if (("Powerful").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.POWERFUL.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.POWERFUL.get()) == trueEnchLvl
										&& 9 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.POWERFUL.get()))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.POWERFUL.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					finalItem.getOrCreateTag().putDouble("MP",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MP")
									+ 6 * (trueEnchLvl - (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(ToamodModEnchantments.POWERFUL.get()))));
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.POWERFUL.get())) {
							_enchantments.remove(ToamodModEnchantments.POWERFUL.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.POWERFUL.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if (("ManaFlow").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get()) == trueEnchLvl
										&& 3 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get()))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					finalItem.getOrCreateTag().putDouble("MANA",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MANA")
									+ 20 * (trueEnchLvl - (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get()))));
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.MANAFLOW.get())) {
							_enchantments.remove(ToamodModEnchantments.MANAFLOW.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.MANAFLOW.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (("Armor")
					.equals((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("type"))
					&& "Protection,MagicShield,Spikes,StickyFeet"
							.contains((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getString("enchantment"))) {
				if (("Protection").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.PROTECTION.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.PROTECTION.get()) == trueEnchLvl
										&& 5 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.PROTECTION.get()))
						&& !(EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get(),
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)) != 0)) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.PROTECTION.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					finalItem.getOrCreateTag().putDouble("AR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AR")
									+ 8 * (trueEnchLvl - (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(ToamodModEnchantments.PROTECTION.get()))));
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.PROTECTION.get())) {
							_enchantments.remove(ToamodModEnchantments.PROTECTION.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.PROTECTION.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if (("MagicShield").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get()) == trueEnchLvl
										&& 5 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get()))
						&& !(EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.PROTECTION.get(),
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)) != 0)) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					finalItem.getOrCreateTag().putDouble("MR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MR")
									+ 8 * (trueEnchLvl - (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get()))));
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.MAGICSHIELD.get())) {
							_enchantments.remove(ToamodModEnchantments.MAGICSHIELD.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.MAGICSHIELD.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if (("Spikes").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.SPIKES.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.SPIKES.get()) == trueEnchLvl
										&& 5 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.SPIKES.get()))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.SPIKES.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.SPIKES.get())) {
							_enchantments.remove(ToamodModEnchantments.SPIKES.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.SPIKES.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if (("StickyFeet").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ("Boots").equals((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getString("subType"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.STICKYFEET.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.STICKYFEET.get()) == trueEnchLvl
										&& 4 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.STICKYFEET.get()))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.STICKYFEET.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.STICKYFEET.get())) {
							_enchantments.remove(ToamodModEnchantments.STICKYFEET.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.STICKYFEET.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (("Pickaxe")
					.equals((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("type"))
					&& "Fortune".contains((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getString("enchantment"))) {
				if (("Fortune").equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.FORTUNE.get()) < trueEnchLvl
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(ToamodModEnchantments.FORTUNE.get()) == trueEnchLvl
										&& 4 > (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(ToamodModEnchantments.FORTUNE.get()))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(ToamodModEnchantments.FORTUNE.get()) == trueEnchLvl) {
						trueEnchLvl = trueEnchLvl + 1;
					}
					finalItem.getOrCreateTag().putDouble("MINF",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MINF")
									+ 20 * (trueEnchLvl - (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(ToamodModEnchantments.FORTUNE.get()))));
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalItem);
						if (_enchantments.containsKey(ToamodModEnchantments.FORTUNE.get())) {
							_enchantments.remove(ToamodModEnchantments.FORTUNE.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalItem);
						}
					}
					finalItem.enchant(ToamodModEnchantments.FORTUNE.get(), (int) trueEnchLvl);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == finalItem.getItem())
					&& new Object() {
						public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getBoolean(tag);
							return false;
						}
					}.getValue(world,
							BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
									(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
									(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ),
							"validRecipe")) {
				if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = finalItem.copy();
					_setstack.setCount(1);
					((Slot) _slots.get(0)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				SetCombatItemLoreGuiOutputProcedure.execute(world, entity);
			}
		}
	}
}
