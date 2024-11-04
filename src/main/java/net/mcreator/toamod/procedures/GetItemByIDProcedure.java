package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.toamod.network.ToamodModVariables;

import com.mojang.brigadier.context.CommandContext;

public class GetItemByIDProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		ItemStack item = ItemStack.EMPTY;
		boolean itemFound = false;
		String tempDescriptionTxt = "";
		String statsTxt = "";
		double i = 0;
		{
			ItemStack _setval = (ItemArgument.getItem(arguments, "id").getItem().getDefaultInstance());
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.paramItem = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
