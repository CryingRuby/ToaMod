package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CmdSetMobADExecutedProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		(new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "mob");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getPersistentData().putDouble("AD", (DoubleArgumentType.getDouble(arguments, "value")));
		(new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "mob");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getPersistentData().putDouble("currentHealth", (DoubleArgumentType.getDouble(arguments, "hpValue")));
		(new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "mob");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getPersistentData().putDouble("maxHealth", (DoubleArgumentType.getDouble(arguments, "hpValue")));
	}
}
