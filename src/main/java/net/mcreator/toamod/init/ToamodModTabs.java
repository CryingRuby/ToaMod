
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.toamod.ToamodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ToamodModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ToamodMod.MODID);
	public static final RegistryObject<CreativeModeTab> TOA_MOD_TAB = REGISTRY.register("toa_mod_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.toamod.toa_mod_tab")).icon(() -> new ItemStack(ToamodModItems.MAGIC_DUST.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ToamodModBlocks.CURSED_OBSIDIAN.get().asItem());
				tabData.accept(ToamodModBlocks.MAGMA.get().asItem());
				tabData.accept(ToamodModBlocks.COAL_ORE.get().asItem());
				tabData.accept(ToamodModBlocks.IRON_ORE.get().asItem());
				tabData.accept(ToamodModBlocks.GOLD_ORE.get().asItem());
				tabData.accept(ToamodModBlocks.JADE_ORE.get().asItem());
				tabData.accept(ToamodModBlocks.CRISTAL_ORE.get().asItem());
				tabData.accept(ToamodModBlocks.CHEST_NORMAL.get().asItem());
				tabData.accept(ToamodModBlocks.CHEST_EPIC.get().asItem());
				tabData.accept(ToamodModBlocks.CHEST_LEGENDARY.get().asItem());
				tabData.accept(ToamodModBlocks.ORE_RESPAWN_STONE.get().asItem());
				tabData.accept(ToamodModBlocks.CONTROL_BARRIER.get().asItem());
				tabData.accept(ToamodModItems.LEEK.get());
				tabData.accept(ToamodModItems.GRAPES.get());
				tabData.accept(ToamodModItems.STRAWBERRY.get());
				tabData.accept(ToamodModItems.BLUEBERRY.get());
				tabData.accept(ToamodModItems.CRANBERRY.get());
				tabData.accept(ToamodModItems.BROCCOLI.get());
				tabData.accept(ToamodModItems.COFFEE_BEANS.get());
				tabData.accept(ToamodModItems.CUP_OF_COFFEE.get());
				tabData.accept(ToamodModItems.RAW_MUTTON.get());
				tabData.accept(ToamodModItems.COOKED_MUTTON.get());
				tabData.accept(ToamodModItems.RAW_TURKEY.get());
				tabData.accept(ToamodModItems.COOKED_TURKEY.get());
				tabData.accept(ToamodModItems.RAW_RAGOUT_RABBIT.get());
				tabData.accept(ToamodModItems.COOKED_RAGOUT_RABBIT.get());
				tabData.accept(ToamodModItems.RAW_CRAB.get());
				tabData.accept(ToamodModItems.RAW_GROUPER.get());
				tabData.accept(ToamodModItems.TOMATO.get());
				tabData.accept(ToamodModItems.ONION.get());
				tabData.accept(ToamodModItems.CHICKEN_GUMBO.get());
				tabData.accept(ToamodModItems.STEAK_AND_CHIPS.get());
				tabData.accept(ToamodModItems.SPICY_SPICED_CHILLI.get());
				tabData.accept(ToamodModItems.RABBIT_RAGOUT.get());
				tabData.accept(ToamodModItems.FISH_MEAL.get());
				tabData.accept(ToamodModItems.HAM_SOUP.get());
				tabData.accept(ToamodModItems.LAMB_PLATE.get());
				tabData.accept(ToamodModItems.MANGO.get());
				tabData.accept(ToamodModItems.SWEAT_ROASTED_CHICKEN.get());
				tabData.accept(ToamodModItems.BANANA_SPLIT.get());
				tabData.accept(ToamodModItems.CHILLI.get());
				tabData.accept(ToamodModItems.CHOCOLATE.get());
				tabData.accept(ToamodModItems.CHOCOLATE_STRAWBERRY.get());
				tabData.accept(ToamodModBlocks.COOKING_TABLE.get().asItem());
				tabData.accept(ToamodModItems.JADE_SWORD.get());
				tabData.accept(ToamodModBlocks.LOG.get().asItem());
				tabData.accept(ToamodModItems.FOOTLONG.get());
				tabData.accept(ToamodModItems.RAW_BEEF.get());
				tabData.accept(ToamodModItems.COOKED_BEEF.get());
				tabData.accept(ToamodModItems.TACO.get());
				tabData.accept(ToamodModItems.WARM_BREAKFAST.get());
				tabData.accept(ToamodModItems.SWEET_HAM.get());
				tabData.accept(ToamodModItems.RAW_HAM.get());
				tabData.accept(ToamodModBlocks.CREATURE_BARRIER.get().asItem());
				tabData.accept(ToamodModBlocks.ENHANCMENT_TABLE.get().asItem());
				tabData.accept(ToamodModBlocks.MAGIC_CRAFTER.get().asItem());
				tabData.accept(ToamodModBlocks.FORGER.get().asItem());
				tabData.accept(ToamodModBlocks.HARD_STONE.get().asItem());
				tabData.accept(ToamodModBlocks.HARD_STONE_SLAB.get().asItem());
				tabData.accept(ToamodModBlocks.GOBLIN_OMLETTE.get().asItem());
				tabData.accept(ToamodModBlocks.PLAYER_BARRIER.get().asItem());
				tabData.accept(ToamodModBlocks.PESTO_GOBLIN_OMLETTE.get().asItem());
				tabData.accept(ToamodModItems.FRIED_GOBLIN_EGG.get());
				tabData.accept(ToamodModItems.GOBLIN_EGG.get());
				tabData.accept(ToamodModItems.POWER_CATALYST_1.get());
				tabData.accept(ToamodModItems.POWER_CATALYST_2.get());
				tabData.accept(ToamodModItems.POWER_CATALYST_3.get());
				tabData.accept(ToamodModItems.POWER_CATALYST_4.get());
				tabData.accept(ToamodModItems.POWER_CATALYST_5.get());
				tabData.accept(ToamodModBlocks.INV_CONTROL_BARRIER.get().asItem());
				tabData.accept(ToamodModBlocks.EMPHEIAS_SOUL.get().asItem());
				tabData.accept(ToamodModBlocks.RESPAWN_ORE.get().asItem());
				tabData.accept(ToamodModBlocks.MITHRIL_ORE.get().asItem());
				tabData.accept(ToamodModItems.MITHRIL_SWORD.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> DECORATION = REGISTRY.register("decoration",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.toamod.decoration")).icon(() -> new ItemStack(ToamodModBlocks.DEC_CRAFTING_TABLE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ToamodModBlocks.DEC_CRAFTING_TABLE.get().asItem());
				tabData.accept(ToamodModBlocks.DEC_BARREL_VERTICAL.get().asItem());
				tabData.accept(ToamodModBlocks.DEC_BARREL_HORIZONTAL.get().asItem());
				tabData.accept(ToamodModBlocks.DEC_ANVIL.get().asItem());
				tabData.accept(ToamodModBlocks.DEC_GRINDSTONE.get().asItem());
				tabData.accept(ToamodModBlocks.DEC_GRINDSTONE_DOWN.get().asItem());
				tabData.accept(ToamodModBlocks.DEC_GRINDSTONE_SIDE.get().asItem());
				tabData.accept(ToamodModBlocks.SMOOTH_ACACIA_PLANKS.get().asItem());
				tabData.accept(ToamodModBlocks.SMOOTH_BIRCH_PLANKS.get().asItem());
				tabData.accept(ToamodModBlocks.SMOOTH_CRIMSON_PLANKS.get().asItem());
				tabData.accept(ToamodModBlocks.SMOOTH_DARK_OAK_PLANKS.get().asItem());
				tabData.accept(ToamodModBlocks.SMOOTH_JUNGLE_PLANKS.get().asItem());
				tabData.accept(ToamodModBlocks.SMOOTH_OAK_PLANKS.get().asItem());
				tabData.accept(ToamodModBlocks.SMOOTH_WARPED_PLANKS.get().asItem());
				tabData.accept(ToamodModBlocks.SMOOTH_SPRUCE_PLANKS.get().asItem());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> TOA_ARMORS = REGISTRY.register("toa_armors",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.toamod.toa_armors")).icon(() -> new ItemStack(ToamodModItems.IRON_ARMOR_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ToamodModItems.WOOD_ARMOR_HELMET.get());
				tabData.accept(ToamodModItems.WOOD_ARMOR_CHESTPLATE.get());
				tabData.accept(ToamodModItems.WOOD_ARMOR_LEGGINGS.get());
				tabData.accept(ToamodModItems.WOOD_ARMOR_BOOTS.get());
				tabData.accept(ToamodModItems.IRON_ARMOR_HELMET.get());
				tabData.accept(ToamodModItems.IRON_ARMOR_CHESTPLATE.get());
				tabData.accept(ToamodModItems.IRON_ARMOR_LEGGINGS.get());
				tabData.accept(ToamodModItems.IRON_ARMOR_BOOTS.get());
				tabData.accept(ToamodModItems.HARDENED_IRON_ARMOR_HELMET.get());
				tabData.accept(ToamodModItems.HARDENED_IRON_ARMOR_CHESTPLATE.get());
				tabData.accept(ToamodModItems.HARDENED_IRON_ARMOR_LEGGINGS.get());
				tabData.accept(ToamodModItems.HARDENED_IRON_ARMOR_BOOTS.get());
				tabData.accept(ToamodModItems.GOLD_ARMOR_HELMET.get());
				tabData.accept(ToamodModItems.GOLD_ARMOR_CHESTPLATE.get());
				tabData.accept(ToamodModItems.GOLD_ARMOR_LEGGINGS.get());
				tabData.accept(ToamodModItems.GOLD_ARMOR_BOOTS.get());
				tabData.accept(ToamodModItems.CRISTAL_ARMOR_HELMET.get());
				tabData.accept(ToamodModItems.CRISTAL_ARMOR_CHESTPLATE.get());
				tabData.accept(ToamodModItems.CRISTAL_ARMOR_LEGGINGS.get());
				tabData.accept(ToamodModItems.CRISTAL_ARMOR_BOOTS.get());
				tabData.accept(ToamodModItems.JADE_ARMOR_HELMET.get());
				tabData.accept(ToamodModItems.JADE_ARMOR_CHESTPLATE.get());
				tabData.accept(ToamodModItems.JADE_ARMOR_LEGGINGS.get());
				tabData.accept(ToamodModItems.JADE_ARMOR_BOOTS.get());
				tabData.accept(ToamodModItems.DRAGON_ARMOR_HELMET.get());
				tabData.accept(ToamodModItems.DRAGON_ARMOR_CHESTPLATE.get());
				tabData.accept(ToamodModItems.DRAGON_ARMOR_LEGGINGS.get());
				tabData.accept(ToamodModItems.DRAGON_ARMOR_BOOTS.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> TOA_SPECIALS = REGISTRY.register("toa_specials",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.toamod.toa_specials")).icon(() -> new ItemStack(ToamodModItems.MYTHIC_RUNE_SCROLL.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ToamodModItems.GOLDEN_HEART.get());
				tabData.accept(ToamodModItems.FIERY_HEART.get());
				tabData.accept(ToamodModItems.SILVER_KEY.get());
				tabData.accept(ToamodModItems.GOLDEN_KEY.get());
				tabData.accept(ToamodModItems.COR.get());
				tabData.accept(ToamodModItems.MAGIC_DUST.get());
				tabData.accept(ToamodModItems.RUNE_COMMAN.get());
				tabData.accept(ToamodModItems.RUNE_UNCOMMAN.get());
				tabData.accept(ToamodModItems.RUNE_RARE.get());
				tabData.accept(ToamodModItems.RUNE_EPIC.get());
				tabData.accept(ToamodModItems.RUNE_LEGENDARY.get());
				tabData.accept(ToamodModItems.RUNE_MYTHIC.get());
				tabData.accept(ToamodModItems.RUNE_FRAGMENTS.get());
				tabData.accept(ToamodModItems.DWARFS_HYMN.get());
				tabData.accept(ToamodModItems.MYTHIC_RUNE_SCROLL.get());
				tabData.accept(ToamodModItems.GEMSTONE_RUBY.get());
				tabData.accept(ToamodModItems.GEMSTONE_AMETHYST.get());
				tabData.accept(ToamodModItems.GEMSTONE_TOPAZ.get());
				tabData.accept(ToamodModItems.GEMSTONE_AQUAMARINE.get());
				tabData.accept(ToamodModItems.GEMSTONE_AMBER.get());
				tabData.accept(ToamodModItems.GEMSTONE_TANZANITE.get());
				tabData.accept(ToamodModItems.GEMSTONE_EMERALD.get());
				tabData.accept(ToamodModItems.GEMSTONE_PEARL.get());
				tabData.accept(ToamodModItems.GEMSTONE_OPAL.get());
				tabData.accept(ToamodModItems.GEMSTONE_DIAMOND.get());
				tabData.accept(ToamodModItems.GEMSTONE_SAPHIRE.get());
				tabData.accept(ToamodModItems.ENCH_BOOK.get());
				tabData.accept(ToamodModItems.EMPTY_BOOK.get());
				tabData.accept(ToamodModItems.GOBLIN_EGG_SPICES.get());
				tabData.accept(ToamodModItems.BOSS_KEY_TIER_1.get());
				tabData.accept(ToamodModItems.BOSS_KEY_TIER_2.get());
				tabData.accept(ToamodModItems.BOSS_KEY_TIER_3.get());
				tabData.accept(ToamodModItems.SUPER_ENCHANTMENT_BOOK.get());
				tabData.accept(ToamodModItems.ENCHANTMENT_BOOK.get());
				tabData.accept(ToamodModItems.ROUGH_RUNE_FRAGMENT.get());
				tabData.accept(ToamodModItems.FLAWED_RUNE_FRAGMENT.get());
				tabData.accept(ToamodModItems.FINE_RUNE_FRAGMENT.get());
				tabData.accept(ToamodModItems.FLAWLESS_RUNE_FRAGMENT.get());
				tabData.accept(ToamodModItems.PRISTINE_RUNE_FRAGMENT.get());
				tabData.accept(ToamodModItems.EXQUISITE_RUNE_FRAGMENT.get());
				tabData.accept(ToamodModItems.NEAR_PERFECT_RUNE_FRAGMENT.get());
				tabData.accept(ToamodModItems.PERFECT_RUNE_FRAGMENT.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> TOA_MATERIALS = REGISTRY.register("toa_materials",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.toamod.toa_materials")).icon(() -> new ItemStack(ToamodModItems.COAL.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ToamodModItems.OBSIDIAN.get());
				tabData.accept(ToamodModItems.COAL.get());
				tabData.accept(ToamodModItems.JADE.get());
				tabData.accept(ToamodModItems.PURE_GOLD.get());
				tabData.accept(ToamodModItems.PURE_IRON.get());
				tabData.accept(ToamodModItems.RED_GOBLIN_SCALE.get());
				tabData.accept(ToamodModItems.PURE_CRYSTAL.get());
				tabData.accept(ToamodModItems.GOLD_BAR.get());
				tabData.accept(ToamodModItems.IRON_BAR.get());
				tabData.accept(ToamodModItems.JADE_BAR.get());
				tabData.accept(ToamodModItems.COAL_BAR.get());
				tabData.accept(ToamodModItems.CRYSTAL_SHARD.get());
				tabData.accept(ToamodModItems.CRYSTAL.get());
				tabData.accept(ToamodModItems.CRYSTAL_CLUSTER.get());
				tabData.accept(ToamodModItems.RED_CRYSTAL.get());
				tabData.accept(ToamodModItems.RED_CRYSTAL_CLUSTER.get());
				tabData.accept(ToamodModItems.MITHRIL.get());
				tabData.accept(ToamodModItems.MITHRIL_BAR.get());
				tabData.accept(ToamodModItems.RED_COPPER.get());
				tabData.accept(ToamodModItems.RED_COPPER_BAR.get());
				tabData.accept(ToamodModItems.BLUE_COPPER.get());
				tabData.accept(ToamodModItems.BLUE_COPPER_BAR.get());
				tabData.accept(ToamodModItems.TUSK.get());
				tabData.accept(ToamodModItems.REFINED_TUSK.get());
				tabData.accept(ToamodModItems.DROP_OF_BLOOD.get());
				tabData.accept(ToamodModItems.BURNING_SOUL.get());
				tabData.accept(ToamodModItems.MANA_STONE.get());
				tabData.accept(ToamodModBlocks.CONDENSED_IRON_BLOCK.get().asItem());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> MOBS = REGISTRY.register("mobs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.toamod.mobs")).icon(() -> new ItemStack(Items.PANDA_SPAWN_EGG)).displayItems((parameters, tabData) -> {
				tabData.accept(ToamodModItems.HORSE_CARE_TAKER_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.GOBLIN_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.GUI_ITEM_GHOST_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.GOBLIN_SCOUT_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.XEDRES_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.GOBLIN_HUNTER_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_BLACKSMITH_1_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_BLACKSMITH_2_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_BLACKSMITH_3_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_BLACKSMITH_4_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_DWARF_1_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_DWARF_2_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_DWARF_3_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_DWARF_4_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_DWARF_5_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_DWARF_6_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_DWARF_7_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_DWARF_8_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FAIRY_1_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FAIRY_2_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FAIRY_3_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FEMALE_1_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FEMALE_2_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FEMALE_3_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FEMALE_4_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FEMALE_5_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FEMALE_6_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FEMALE_7_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FEMALE_8_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_KNIGHT_1_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_KNIGHT_2_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_KNIGHT_3_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_KNIGHT_4_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_KNIGHT_5_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_KNIGHT_6_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MALE_1_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MALE_2_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MALE_3_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MALE_4_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MALE_5_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MALE_6_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MALE_7_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MALE_8_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MALE_9_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MINER_2_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MINER_3_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_ROYAL_COMMANDER_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_COPPER_MINER_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_DUNGEON_MASTER_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_FOREIGN_MERCHANT_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_GOLDEN_KNIGHT_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_HUNTER_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_IRON_GOLEM_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_JAEDUS_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_LUMBERJACK_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_LOST_ADVENTURER_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MAXOR_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MIST_MAGE_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MIST_MERCHANT_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_NECRON_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_NECROTIC_KNIGHT_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_PHANTOM_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_PRIATE_CAPTAIN_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_ROYAL_KNIGHT_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_SLEEPY_SCORPIUS_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_STORM_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_WARDEN_KNIGHT_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MERCHANT_SPAWN_EGG.get());
				tabData.accept(ToamodModItems.NPC_MINER_1_SPAWN_EGG.get());
			}).withSearchBar().build());
	public static final RegistryObject<CreativeModeTab> TOA_WEAPONS = REGISTRY.register("toa_weapons",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.toamod.toa_weapons")).icon(() -> new ItemStack(ToamodModItems.FLAME_SWORD.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ToamodModItems.CRISTAL_SWORD.get());
				tabData.accept(ToamodModItems.WOODEN_SWORD.get());
				tabData.accept(ToamodModItems.IRON_SWORD.get());
				tabData.accept(ToamodModItems.GOLDEN_SWORD.get());
				tabData.accept(ToamodModItems.DEATHS_DANCE.get());
				tabData.accept(ToamodModItems.DRAGON_SLAYER.get());
				tabData.accept(ToamodModItems.THE_DARK_BLADE.get());
				tabData.accept(ToamodModItems.ANCIENT_GUARDIAN_WARHAMMER.get());
				tabData.accept(ToamodModItems.FLAME_SWORD.get());
				tabData.accept(ToamodModItems.STARFALL_HYPERION.get());
				tabData.accept(ToamodModItems.SCALDRIS_HYPERION.get());
				tabData.accept(ToamodModItems.ILLFANGS_CUTLASS.get());
				tabData.accept(ToamodModItems.HARDENED_IRON_SWORD.get());
				tabData.accept(ToamodModItems.INFERNAL_HYPERION.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(ToamodModItems.BOSS_ILLFANG_SPAWN_EGG.get());
		}
	}
}
