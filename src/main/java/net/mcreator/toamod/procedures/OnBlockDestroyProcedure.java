package net.mcreator.toamod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnBlockDestroyProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double mineXp = 0;
		mineXp = 0;
		if (blockstate.getBlock() == ToamodModBlocks.COAL_ORE.get()) {
			mineXp = 1;
		} else if (blockstate.getBlock() == ToamodModBlocks.IRON_ORE.get()) {
			mineXp = 2;
		} else if (blockstate.getBlock() == ToamodModBlocks.GOLD_ORE.get()) {
			mineXp = 4;
		} else if (blockstate.getBlock() == ToamodModBlocks.JADE_ORE.get()) {
			mineXp = 7;
		} else if (blockstate.getBlock() == ToamodModBlocks.CRISTAL_ORE.get()) {
			mineXp = 8;
		} else if (blockstate.getBlock() == ToamodModBlocks.MAGMA.get()) {
			mineXp = 11;
		} else if (blockstate.getBlock() == ToamodModBlocks.CURSED_OBSIDIAN.get()) {
			mineXp = 24;
		} else if (blockstate.getBlock() == ToamodModBlocks.CURSED_OBSIDIAN.get()) {
			mineXp = 5;
		}
		if (mineXp > 0) {
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseXp + mineXp;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.skillDefenseXp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseLvl == 15) {
				{
					double _setval = 0;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillDefenseNeededXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("\u00A7a+" + mineXp + " Defenseskill Xp ("
						+ (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseXp
						+ "/" + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseNeededXp
						+ ")\u00A7r")), (true));
			while ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseXp >= (entity
							.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseNeededXp
					&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseLvl < 15) {
				{
					double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseXp
							- (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseNeededXp;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillDefenseXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseLvl + 1;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillDefenseLvl = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = Math.round(0.302
							* Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseLvl, 3)
							+ 1.533 * Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseLvl, 2)
							+ 14.958 + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseLvl
							+ 28.698);
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillDefenseNeededXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				OnDefenseSkillUpProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
