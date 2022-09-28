
package net.mcreator.toamod.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.mcreator.toamod.procedures.CmdSetWeaponADExecutedProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class SetWeaponADCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("setweaponad")

				.then(Commands.argument("value", DoubleArgumentType.doubleArg(0))
						.then(Commands.argument("dmgType", StringArgumentType.word()).then(Commands.argument("armor", DoubleArgumentType.doubleArg(0))
								.then(Commands.argument("targetAR", EntityArgument.entity()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									CmdSetWeaponADExecutedProcedure.execute(arguments, entity);
									return 0;
								}))))));
	}
}
