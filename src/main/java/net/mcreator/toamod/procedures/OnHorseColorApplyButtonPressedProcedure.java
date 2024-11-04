package net.mcreator.toamod.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.Checkbox;

import net.mcreator.toamod.world.inventory.HorseUpgradeGuiMenu;
import net.mcreator.toamod.network.ToamodModVariables;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class OnHorseColorApplyButtonPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).cor >= 25000) {
			if (guistate.containsKey("checkbox:white") && ((Checkbox) guistate.get("checkbox:white")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horseColor != 0) {
				{
					double _setval = 0;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horseColor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:creamy") && ((Checkbox) guistate.get("checkbox:creamy")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horseColor != 1) {
				{
					double _setval = 1;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horseColor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:chestnut") && ((Checkbox) guistate.get("checkbox:chestnut")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horseColor != 2) {
				{
					double _setval = 2;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horseColor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:brown") && ((Checkbox) guistate.get("checkbox:brown")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horseColor != 3) {
				{
					double _setval = 3;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horseColor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:black") && ((Checkbox) guistate.get("checkbox:black")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horseColor != 4) {
				{
					double _setval = 4;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horseColor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:gray") && ((Checkbox) guistate.get("checkbox:gray")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horseColor != 5) {
				{
					double _setval = 5;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horseColor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:dark_brown") && ((Checkbox) guistate.get("checkbox:dark_brown")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horseColor != 6) {
				{
					double _setval = 6;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horseColor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).cor - 25000;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cor = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("HorseUpgradeGui");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new HorseUpgradeGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
