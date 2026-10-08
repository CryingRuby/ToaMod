package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.ToaSkillHandler;
import net.mcreator.toamod.ToaMob;
import net.mcreator.toamod.ToaMilestoneHandler;

public class OnEntityKilledProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double attackXp = 0;
		double corReward = 0;
		double mdReward = 0;
		if (entity instanceof ToaMob mob) {
			attackXp = mob.getCorReward();
			corReward = mob.getComXpReward();
			mdReward = mob.getMdReward();
		}
		if (attackXp <= 0 || !(sourceentity instanceof Player))
			return;

		ToaSkillHandler.addSkillXP((Player) sourceentity, attackXp, ToaSkillHandler.SkillType.COMBAT);
			
		String msgToPlayer = "";
		ToamodModVariables.PlayerVariables playerVars = sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables());
		ToaMilestoneHandler.addStatToMile((Player) sourceentity, 1, ToaMilestoneHandler.MilestoneType.PATH_OF_THE_REAPER);


		int skillNeededXp = (playerVars.skillAttackLvl < ToaSkillHandler.MaxSkillLevel) ? ToaSkillHandler.XpForLevelUp[(int) playerVars.skillAttackLvl + 1] : 0;

		//BUILD msg txt with skillxp,etc
		msgToPlayer = "\u00A7c+" + attackXp + " Combat Skill Xp (" + playerVars.skillAttackXp + "/"
				+ skillNeededXp + ")\u00A7r";
		msgToPlayer += " \u00A76+" + new java.text.DecimalFormat("##").format(corReward) + " Cor\u00A7r";
		if (mdReward > 0) {
			msgToPlayer += " \u00A7b+" + new java.text.DecimalFormat("##").format(mdReward) + " MD\u00A7r";
		}
		if (sourceentity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(msgToPlayer), true);
	}
}
