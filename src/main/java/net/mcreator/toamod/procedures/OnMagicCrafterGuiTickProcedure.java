package net.mcreator.toamod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;

import java.util.function.Supplier;
import java.util.Map;

public class OnMagicCrafterGuiTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack finalItem = ItemStack.EMPTY;
		String AmountsReq = "";
		String slotString = "";
		double u = 0;
		double maxEnchUnlocked = 0;
		double i = 0;
		double maxPossibleEnchLvl = 0;
		slotString = SlotsToRecipeStringProcedure.execute(entity);
		if (((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).playerRecipes).contains(slotString)) {
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
			if (("pure_iron,pure_iron,pure_iron,pure_iron,empty_book,pure_iron,pure_iron,pure_iron,pure_iron;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlSharpnessProcedure.execute(entity);
				if (maxEnchUnlocked > 7) {
					maxEnchUnlocked = 7;
				}
				AmountsReq = "01-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked - 1)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "Sharpness");
			} else if (("iron_bar,iron_bar,iron_bar,iron_bar,empty_book,iron_bar,iron_bar,iron_bar,iron_bar;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlSharpnessProcedure.execute(entity);
				if (maxEnchUnlocked > 9) {
					maxEnchUnlocked = 9;
				}
				AmountsReq = "01-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked - 8)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "Sharpness");
			} else if (("pure_crystal,iron_bar,iron_bar,iron_bar,empty_book,iron_bar,iron_bar,iron_bar,iron_bar;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 10;
				AmountsReq = "01,04,04,04,01,04,04,04,04";
				finalItem.getOrCreateTag().putString("enchantment", "Sharpness");
			} else if (("coal,coal,coal,coal,empty_book,coal,coal,coal,coal;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlProtectionProcedure.execute(entity);
				if (maxEnchUnlocked > 5) {
					maxEnchUnlocked = 5;
				}
				AmountsReq = "02-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "Protection");
			} else if (("pure_crystal,coal_bar,coal_bar,obsidian,empty_book,obsidian,coal_bar,coal_bar,obsidian;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 6;
				AmountsReq = "01,02,02,05,01,05,02,02,05";
				finalItem.getOrCreateTag().putString("enchantment", "Protection");
			} else if (("red_crystal,red_crystal,red_crystal,red_crystal,empty_book,red_crystal,red_crystal,red_crystal,red_crystal;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlExecutingProcedure.execute(entity);
				if (maxEnchUnlocked > 5) {
					maxEnchUnlocked = 5;
				}
				AmountsReq = "04-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked + 1)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "Executing");
			} else if (("pure_crystal,red_crystal_cluster,red_crystal_cluster,fiery_heart,empty_book,fiery_heart,red_crystal_cluster,red_crystal_cluster,fiery_heart;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 6;
				AmountsReq = "01,02,02,01,01,01,02,02,01";
				finalItem.getOrCreateTag().putString("enchantment", "Executing");
			} else if (("drop_of_blood,drop_of_blood,drop_of_blood,drop_of_blood,empty_book,drop_of_blood,drop_of_blood,drop_of_blood,drop_of_blood;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlLifeStealProcedure.execute(entity);
				if (maxEnchUnlocked > 3) {
					maxEnchUnlocked = 3;
				}
				AmountsReq = "01-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked - 1)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "LifeSteal");
			} else if (("pure_crystal,drop_of_blood,drop_of_blood,burning_soul,empty_book,burning_soul,drop_of_blood,drop_of_blood,burning_soul;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 4;
				AmountsReq = "01,16,16,02,01,02,16,16,02";
				finalItem.getOrCreateTag().putString("enchantment", "LifeSteal");
			} else if (("crystal_shard,crystal_shard,crystal_shard,crystal_shard,empty_book,crystal_shard,crystal_shard,crystal_shard,crystal_shard;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlSharpnessProcedure.execute(entity);
				if (maxEnchUnlocked > 2) {
					maxEnchUnlocked = 2;
				}
				AmountsReq = "32-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked + 4)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "Powerful");
			} else if (("crystal,crystal,crystal,crystal,empty_book,crystal,crystal,crystal,crystal;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlSharpnessProcedure.execute(entity);
				if (maxEnchUnlocked > 9) {
					maxEnchUnlocked = 9;
				}
				AmountsReq = "01-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked - 3)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "Powerful");
			} else if (("pure_crystal,crystal_cluster,crystal_cluster,crystal_cluster,empty_book,crystal_cluster,crystal_cluster,crystal_cluster,crystal_cluster;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 10;
				AmountsReq = "01,01,01,01,01,01,01,01,01";
				finalItem.getOrCreateTag().putString("enchantment", "Powerful");
			} else if (("pure_gold,pure_gold,pure_gold,pure_gold,empty_book,pure_gold,pure_gold,pure_gold,pure_gold;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlScavengerProcedure.execute(entity);
				if (maxEnchUnlocked > 3) {
					maxEnchUnlocked = 3;
				}
				AmountsReq = "08-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked + 2)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "Scavenger");
			} else if (("pure_crystal,gold_bar,gold_bar,golden_heart,empty_book,golden_heart,gold_bar,gold_bar,golden_heart;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 4;
				AmountsReq = "01,01,01,01,01,01,01,01,01";
				finalItem.getOrCreateTag().putString("enchantment", "Scavenger");
			} else if (("black_thorn,black_thorn,black_thorn,black_thorn,empty_book,black_thorn,black_thorn,black_thorn,black_thorn;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlSpikesProcedure.execute(entity);
				if (maxEnchUnlocked > 5) {
					maxEnchUnlocked = 5;
				}
				AmountsReq = "08-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked - 1)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "Spikes");
			} else if (("pure_crystal,black_thorn,black_thorn,tusk,empty_book,tusk,black_thorn,black_thorn,tusk;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 6;
				AmountsReq = "01,64,64,16,01,16,64,64,16";
				finalItem.getOrCreateTag().putString("enchantment", "Spikes");
			} else if (("slime_mushroom,slime_mushroom,slime_mushroom,slime_mushroom,empty_book,slime_mushroom,slime_mushroom,slime_mushroom,slime_mushroom;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlStickyFeetProcedure.execute(entity);
				if (maxEnchUnlocked > 3) {
					maxEnchUnlocked = 3;
				}
				AmountsReq = "08-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked + 3)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "StickyFeet");
			} else if (("slime_mushroom_colony,slime_mushroom_colony,slime_mushroom_colony,slime_mushroom_colony,empty_book,slime_mushroom_colony,slime_mushroom_colony,slime_mushroom_colony,slime_mushroom_colony;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 4;
				AmountsReq = "01,01,01,01,01,01,01,01,01";
				finalItem.getOrCreateTag().putString("enchantment", "StickyFeet");
			} else if (("pure_crystal,slime_mushroom_colony,slime_mushroom_colony,coal_bar,empty_book,coal_bar,slime_mushroom_colony,slime_mushroom_colony,coal_bar;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 5;
				AmountsReq = "01,04,04,01,01,01,04,04,01";
				finalItem.getOrCreateTag().putString("enchantment", "StickyFeet");
			} else if (("pure_gold,pure_iron,pure_iron,pure_gold,empty_book,pure_gold,pure_iron,pure_iron,pure_gold;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 1;
				AmountsReq = "04-04x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "Fortune");
			} else if (("pure_gold,mithril,mithril,pure_iron,empty_book,pure_iron,mithril,mithril,pure_gold;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 2;
				AmountsReq = "16,08,08,16,01,16,08,08,16";
				finalItem.getOrCreateTag().putString("enchantment", "Fortune");
			} else if (("pure_gold,mithril,red_copper,pure_iron,empty_book,pure_iron,red_copper,mithril,pure_gold;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlFortuneProcedure.execute(entity);
				if (maxEnchUnlocked > 4) {
					maxEnchUnlocked = 4;
				}
				AmountsReq = "32-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked + 2)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "Fortune");
			} else if (("pure_crystal,obsidian,coal_bar,blue_copper_bar,empty_book,iron_bar,red_copper_bar,pure_gold_bar,mithril_bar;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 5;
				AmountsReq = "01,16,03,01,01,02,02,02,02";
				finalItem.getOrCreateTag().putString("enchantment", "Fortune");
			} else if (("mithril,mithril,mithril,mithril,empty_book,mithril,mithril,mithril,mithril;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlProtectionProcedure.execute(entity);
				if (maxEnchUnlocked > 5) {
					maxEnchUnlocked = 5;
				}
				AmountsReq = "02-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "MagicShield");
			} else if (("pure_crystal,mithril_bar,mithril_bar,obsidian,empty_book,obsidian,mithril_bar,mithril_bar,obsidian;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 6;
				AmountsReq = "01,01,01,05,01,05,01,01,05";
				finalItem.getOrCreateTag().putString("enchantment", "MagicShield");
			} else if (("tusk,tusk,tusk,tusk,empty_book,tusk,tusk,tusk,tusk;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = GetEnchUnlockedLvlCriticalProcedure.execute(entity);
				if (maxEnchUnlocked > 6) {
					maxEnchUnlocked = 6;
				}
				AmountsReq = "01-" + new java.text.DecimalFormat("##").format(Math.pow(2, maxEnchUnlocked - 1)) + "x-Round";
				finalItem.getOrCreateTag().putString("enchantment", "Critical");
			} else if (("pure_crystal,refined_tusk,refined_tusk,shadow_claw,empty_book,shadow_claw,refined_tusk,refined_tusk,shadow_claw;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCH_BOOK.get());
				maxEnchUnlocked = 7;
				AmountsReq = "01,01,01,03,01,03,01,01,03";
				finalItem.getOrCreateTag().putString("enchantment", "Critical");
			} else if (("air,air,air,enchantment_book,rune_fragments,enchantment_book,air,air,air;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.ENCHANTMENT_BOOK.get());
				AmountsReq = "EnchComb";
				finalItem.getOrCreateTag().putDouble("rarity", 2);
			} else if (("air,air,air,super_enchantment_book,rune_fragments,super_enchantment_book,air,air,air;").equals(slotString)) {
				finalItem = new ItemStack(ToamodModItems.SUPER_ENCHANTMENT_BOOK.get());
				AmountsReq = "EnchComb";
				finalItem.getOrCreateTag().putDouble("rarity", 5);
			}
			if ((AmountsReq).length() > 0 && (AmountsReq.substring(5, 6)).startsWith("x")) {
				AmountsReq = AmountsReq.replace("-" + AmountsReq.substring(4, 5), "-0" + AmountsReq.substring(4, 5));
			}
			if (AmountsReq.contains("x-Round")) {
				if (maxEnchUnlocked == 0) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", false);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				while (new Object() {
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
						"validRecipe") && new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(AmountsReq.substring(3, 5)) / Math.pow(2, u) >= new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(AmountsReq.substring(0, 2))) {
					i = 0;
					for (int index1 = 0; index1 < 9; index1++) {
						if (i != 4 && new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount((int) (i + 1)) < new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(AmountsReq.substring(3, 5)) / Math.pow(2, u)) {
							if (new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(AmountsReq.substring(0, 2)) == new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(AmountsReq.substring(3, 5)) / Math.pow(2, u)) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
											(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
											(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putBoolean("validRecipe", false);
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							maxEnchUnlocked = maxEnchUnlocked - 1;
							break;
						}
						i = i + 1;
					}
					u = u + 1;
				}
			} else if ((AmountsReq).equals("EnchComb")) {
				if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						.equals("Sharpness")
						|| ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getString("enchantment")).equals("Powerful")) {
					maxPossibleEnchLvl = 9;
					maxEnchUnlocked = GetEnchUnlockedLvlSharpnessProcedure.execute(entity);
				} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("Protection")
						|| ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getString("enchantment")).equals("MagicShield")) {
					maxPossibleEnchLvl = 6;
					maxEnchUnlocked = GetEnchUnlockedLvlProtectionProcedure.execute(entity);
				} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("Executing")) {
					maxPossibleEnchLvl = 6;
					maxEnchUnlocked = GetEnchUnlockedLvlExecutingProcedure.execute(entity);
				} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("Critical")) {
					maxPossibleEnchLvl = 7;
					maxEnchUnlocked = GetEnchUnlockedLvlCriticalProcedure.execute(entity);
				} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("LifeSteel")) {
					maxPossibleEnchLvl = 4;
					maxEnchUnlocked = GetEnchUnlockedLvlLifeStealProcedure.execute(entity);
				} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("ManaFlow")) {
					maxPossibleEnchLvl = 4;
					maxEnchUnlocked = GetEnchUnlockedLvlManaFlowProcedure.execute(entity);
				} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("Scavenger")) {
					maxPossibleEnchLvl = 4;
					maxEnchUnlocked = GetEnchUnlockedLvlScavengerProcedure.execute(entity);
				} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("Spikes")) {
					maxPossibleEnchLvl = 6;
					maxEnchUnlocked = GetEnchUnlockedLvlSpikesProcedure.execute(entity);
				} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("StickyFeet")) {
					maxPossibleEnchLvl = 5;
					maxEnchUnlocked = GetEnchUnlockedLvlStickyFeetProcedure.execute(entity);
				} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("Fortune")) {
					maxPossibleEnchLvl = 5;
					maxEnchUnlocked = GetEnchUnlockedLvlFortuneProcedure.execute(entity);
				} else {
					if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
							.equals("UltimateWise")) {
						maxPossibleEnchLvl = 3;
						maxEnchUnlocked = maxPossibleEnchLvl;
					} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getString("enchantment")).equals("QuickCast")) {
						maxPossibleEnchLvl = 2;
						maxEnchUnlocked = maxPossibleEnchLvl;
					}
				}
				if (!(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("enchantment"))
						.equals((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getString("enchantment")))
						&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("enchlvl")
								+ 1 > maxEnchUnlocked
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
										.getDouble("enchlvl") + 1 > maxPossibleEnchLvl)) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("validRecipe", false);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
				for (int index2 = 0; index2 < 9; index2++) {
					if (new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount((int) (i + 1)) < new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(AmountsReq.substring((int) (3 * i), (int) (3 * i + 2)))) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
									(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
									(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("validRecipe", false);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					i = i + 1;
				}
			}
			if (new Object() {
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
					"validRecipe")
					&& (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == finalItem.getItem())
							|| finalItem.getOrCreateTag()
									.getDouble("enchlvl") != (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
											.getOrCreateTag().getDouble("enchlvl")
							|| !(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getString("enchantment")).equals(finalItem.getOrCreateTag().getString("enchantment"))))) {
				if (finalItem.getItem() == ToamodModItems.ENCH_BOOK.get()) {
					finalItem.getOrCreateTag().putDouble("rarity", 0);
					finalItem.getOrCreateTag().putDouble("enchlvl", maxEnchUnlocked);
					finalItem.setHoverName(Component.literal(
							(Component.translatable("item.toamod.ench_book").getString() + " \u00A77(" + Component.translatable(("rarity.prefix." + new java.text.DecimalFormat("##").format(finalItem.getOrCreateTag().getDouble("rarity")))).getString()
									+ Component.translatable(("enchantment.toamod." + (finalItem.getOrCreateTag().getString("enchantment")).toLowerCase())).getString() + " "
									+ Component.translatable(("number.roman." + new java.text.DecimalFormat("##").format(finalItem.getOrCreateTag().getDouble("enchlvl")))).getString() + "\u00A77)\u00A7r")));
					if ((finalItem.getOrCreateTag().getString("enchantment")).equals("Sharpness") || (finalItem.getOrCreateTag().getString("enchantment")).equals("Powerful")) {
						if (finalItem.getOrCreateTag().getDouble("enchlvl") == 10) {
							finalItem.getOrCreateTag().putDouble("mdReq", 200);
						} else if (finalItem.getOrCreateTag().getDouble("enchlvl") >= 8) {
							finalItem.getOrCreateTag().putDouble("mdReq", (25 * finalItem.getOrCreateTag().getDouble("enchlvl") - 75));
						} else {
							finalItem.getOrCreateTag().putDouble("mdReq", (15 * finalItem.getOrCreateTag().getDouble("enchlvl")));
						}
					} else if ((finalItem.getOrCreateTag().getString("enchantment")).equals("Protection") || (finalItem.getOrCreateTag().getString("enchantment")).equals("MagicShield")) {
						if (finalItem.getOrCreateTag().getDouble("enchlvl") == 6) {
							finalItem.getOrCreateTag().putDouble("mdReq", 175);
						} else {
							finalItem.getOrCreateTag().putDouble("mdReq", (25 * finalItem.getOrCreateTag().getDouble("enchlvl")));
						}
					} else if ((finalItem.getOrCreateTag().getString("enchantment")).equals("Executing")) {
						if (finalItem.getOrCreateTag().getDouble("enchlvl") == 6) {
							finalItem.getOrCreateTag().putDouble("mdReq", 450);
						} else {
							finalItem.getOrCreateTag().putDouble("mdReq", (12.5 * Math.pow(finalItem.getOrCreateTag().getDouble("enchlvl"), 2) - 12.5 * finalItem.getOrCreateTag().getDouble("enchlvl") + 50));
						}
					} else if ((finalItem.getOrCreateTag().getString("enchantment")).equals("LifeSteal")) {
						if (finalItem.getOrCreateTag().getDouble("enchlvl") == 4) {
							finalItem.getOrCreateTag().putDouble("mdReq", 350);
						} else {
							finalItem.getOrCreateTag().putDouble("mdReq", (75 * finalItem.getOrCreateTag().getDouble("enchlvl")));
						}
					} else if ((finalItem.getOrCreateTag().getString("enchantment")).equals("Critical")) {
						if (finalItem.getOrCreateTag().getDouble("enchlvl") == 7) {
							finalItem.getOrCreateTag().putDouble("mdReq", 400);
						} else if (finalItem.getOrCreateTag().getDouble("enchlvl") == 6) {
							finalItem.getOrCreateTag().putDouble("mdReq", 325);
						} else {
							finalItem.getOrCreateTag().putDouble("mdReq", (50 * finalItem.getOrCreateTag().getDouble("enchlvl")));
						}
					} else if ((finalItem.getOrCreateTag().getString("enchantment")).equals("Scavenger")) {
						if (finalItem.getOrCreateTag().getDouble("enchlvl") == 4) {
							finalItem.getOrCreateTag().putDouble("mdReq", 175);
						} else {
							finalItem.getOrCreateTag().putDouble("mdReq", (30 * finalItem.getOrCreateTag().getDouble("enchlvl")));
						}
					} else if ((finalItem.getOrCreateTag().getString("enchantment")).equals("ManaFlow")) {
						if (finalItem.getOrCreateTag().getDouble("enchlvl") == 4) {
							finalItem.getOrCreateTag().putDouble("mdReq", 150);
						} else {
							finalItem.getOrCreateTag().putDouble("mdReq", (25 * finalItem.getOrCreateTag().getDouble("enchlvl")));
						}
					} else if ((finalItem.getOrCreateTag().getString("enchantment")).equals("StickyFeet")) {
						if (finalItem.getOrCreateTag().getDouble("enchlvl") == 5) {
							finalItem.getOrCreateTag().putDouble("mdReq", 750);
						} else {
							finalItem.getOrCreateTag().putDouble("mdReq", (12.5 * Math.pow(finalItem.getOrCreateTag().getDouble("enchlvl"), 2) + 62.5 * finalItem.getOrCreateTag().getDouble("enchlvl") + 50));
						}
					} else if ((finalItem.getOrCreateTag().getString("enchantment")).equals("Fortune")) {
						if (finalItem.getOrCreateTag().getDouble("enchlvl") == 4) {
							finalItem.getOrCreateTag().putDouble("mdReq", 350);
						} else {
							finalItem.getOrCreateTag().putDouble("mdReq", (60 * finalItem.getOrCreateTag().getDouble("enchlvl")));
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = finalItem.copy();
						_setstack.setCount(1);
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("data modify block " + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX) + " "
										+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY) + " "
										+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ)
										+ " Items[0].tag.display.Lore set value ['{\"text\":\" \"}','{\"text\":\""
										+ (Component.translatable("item.toamod.ench_book.description").getString()).replace("<VAR>", new java.text.DecimalFormat("##").format(finalItem.getOrCreateTag().getDouble("mdReq")))
										+ "\"}','{\"text\":\" \"}','{\"text\":\"\u00A77Type: \u00A79Magical Book\u00A7r\"}','{\"text\":\"\u00A77Rarity: "
										+ Component.translatable(("rarity.prefix." + new java.text.DecimalFormat("##").format(finalItem.getOrCreateTag().getDouble("rarity")))).getString()
										+ (Component.translatable(("rarity.name." + new java.text.DecimalFormat("##").format(finalItem.getOrCreateTag().getDouble("rarity")))).getString()).toUpperCase() + "\u00A7r\"}']"));
				}
			}
		} else if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
						(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
						(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("validRecipe", false);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(0)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}
