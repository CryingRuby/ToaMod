package net.mcreator.toamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.toamod.network.ToamodModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class OnModifyMaxSoulsCmdProcedure {
	public enum Operation {
		SET, ADD, REMOVE
	}

	public static void execute(LevelAccessor world, Operation op, CommandContext<CommandSourceStack> arguments) {
		ToamodModVariables.WorldVariables.get(world).maxEmpheiasSoul = ToamodModVariables.WorldVariables.get(world).maxEmpheiasSoul + DoubleArgumentType.getDouble(arguments, "value");
		ToamodModVariables.WorldVariables.get(world).syncData(world);

		switch (op) {
			case SET:
				ToamodModVariables.WorldVariables.get(world).maxEmpheiasSoul = DoubleArgumentType.getDouble(arguments, "value");
				break;
			case ADD:
				ToamodModVariables.WorldVariables.get(world).maxEmpheiasSoul += DoubleArgumentType.getDouble(arguments, "value");
			case REMOVE:
				ToamodModVariables.WorldVariables.get(world).maxEmpheiasSoul -= DoubleArgumentType.getDouble(arguments, "value");
				if (ToamodModVariables.WorldVariables.get(world).maxEmpheiasSoul < 0){
					ToamodModVariables.WorldVariables.get(world).maxEmpheiasSoul = 0;
				}


		}
	}
}
