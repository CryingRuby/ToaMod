package net.mcreator.toamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;

public class GetUpgStoneByTypeProcedure {
	public static ItemStack execute() {
		ItemStack upgStone = ItemStack.EMPTY;
		upgStone = new ItemStack(Blocks.AIR);
		return upgStone;
	}
}
