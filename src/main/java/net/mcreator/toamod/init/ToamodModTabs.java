
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class ToamodModTabs {
	public static CreativeModeTab TAB_TOA_MOD_TAB;
	public static CreativeModeTab TAB_DECORATION;
	public static CreativeModeTab TAB_MOBS;

	public static void load() {
		TAB_TOA_MOD_TAB = new CreativeModeTab("tabtoa_mod_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ToamodModItems.MAGIC_DUST.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_DECORATION = new CreativeModeTab("tabdecoration") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ToamodModBlocks.DEC_CRAFTING_TABLE.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_MOBS = new CreativeModeTab("tabmobs") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.PANDA_SPAWN_EGG);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
