package net.mcreator.toamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toamod.network.ToamodModVariables;

public class CmdSpawnHorseExecutedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performCommand(
					new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(),
							null).withSuppressedOutput(),
					("summon horse ~ ~ ~ {Tame:1,SaddleItem:{id:saddle,Count:1},Variant:"
							+ ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new ToamodModVariables.PlayerVariables())).horsePattern
									+ (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new ToamodModVariables.PlayerVariables())).horseColor)
							+ ",Invulnerable:1,Attributes:[{Name:\"generic.movement_speed\",Base:"
							+ (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new ToamodModVariables.PlayerVariables())).horseMoveSpeed
							+ "f},{Name:\"minecraft.horse.jump_strength\",Base:0.4}]}"));
	}
}
