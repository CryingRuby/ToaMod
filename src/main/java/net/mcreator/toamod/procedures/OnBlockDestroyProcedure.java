package net.mcreator.toamod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.ToaSkillHandler;
import net.mcreator.toamod.ToaMineable;
import net.mcreator.toamod.ToaMilestoneHandler;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnBlockDestroyProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Player player) {
		execute(null, world, x, y, z, player);
	}

	private static void execute(@Nullable BlockEvent.BreakEvent event, LevelAccessor world, double x, double y, double z, Player player) {
		if (player == null || player.level().isClientSide())
			return;
		double mineXp = 0;
		if (event.getState().getBlock() instanceof ToaMineable ore) {
			mineXp = ore.getMineXp();
		}
		if (mineXp <= 0)
			return;
		ToaSkillHandler.addSkillXP(player, mineXp, ToaSkillHandler.SkillType.MINING);
		ToaMilestoneHandler.addStatToMile(player, 1, ToaMilestoneHandler.MilestoneType.DWARFS_WAY);
		ToamodModVariables.PlayerVariables capability = player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables());
		int skillNeededXp = (capability.skillDefenseLvl < ToaSkillHandler.MaxSkillLevel) ? ToaSkillHandler.XpForLevelUp[ ((int) capability.skillDefenseLvl) + 1] : 0;
		player.displayClientMessage(Component.literal(("\u00A7a+" + mineXp + " Defense Skill Xp (" + capability.skillDefenseXp + "/" + skillNeededXp + ")\u00A7r")), true);
	}
}
