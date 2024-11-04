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

public class OnHorsePatternApplyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).cor >= 15000) {
			if (guistate.containsKey("checkbox:none") && ((Checkbox) guistate.get("checkbox:none")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horsePattern != 0) {
				{
					double _setval = 0;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horsePattern = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:white_stonkings") && ((Checkbox) guistate.get("checkbox:white_stonkings")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horsePattern != 256) {
				{
					double _setval = 256;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horsePattern = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:white_field") && ((Checkbox) guistate.get("checkbox:white_field")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horsePattern != 512) {
				{
					double _setval = 512;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horsePattern = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:white_dots") && ((Checkbox) guistate.get("checkbox:white_dots")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horsePattern != 768) {
				{
					double _setval = 768;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horsePattern = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (guistate.containsKey("checkbox:black_dots") && ((Checkbox) guistate.get("checkbox:black_dots")).selected()
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).horsePattern != 1024) {
				{
					double _setval = 1024;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.horsePattern = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).cor - 15000;
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
