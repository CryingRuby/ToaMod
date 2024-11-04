package net.mcreator.toamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.entity.GoblinScoutEntity;
import net.mcreator.toamod.entity.GoblinHunterEntity;
import net.mcreator.toamod.entity.GoblinEntity;

public class OnEntityKilledProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double attackXp = 0;
		double comProgBefore = 0;
		double corReward = 0;
		double mdReward = 0;
		String msgToPlayer = "";
		if (entity instanceof GoblinEntity) {
			attackXp = 5;
			corReward = Mth.nextInt(RandomSource.create(), 3, 10);
		}
		if (entity instanceof GoblinScoutEntity) {
			attackXp = 7;
			corReward = Mth.nextInt(RandomSource.create(), 6, 16);
		}
		if (entity instanceof GoblinHunterEntity) {
			attackXp = 9;
			corReward = Mth.nextInt(RandomSource.create(), 8, 18);
			mdReward = 1;
		}
		if (attackXp > 0) {
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackXp + attackXp;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.skillAttackXp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).totalMobsKilled + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.totalMobsKilled = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).totalMobsKilled >= (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneKillsNeeded
					&& (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl < 20) {
				{
					double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl + 1;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.combatMilestoneLvl = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl <= 10) {
					{
						double _setval = attackXp + 10;
						entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.xp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					{
						double _setval = attackXp + 20;
						entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.xp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				ChkPlayerLvlLevelUpProcedure.execute(entity);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A77Combat Milestone Level Up (You have \u00A76"
							+ new java.text.DecimalFormat("##").format((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl
									- (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed)
							+ "\u00A77 unclaimed rewards, speak to \u00A7bThe Bartender\u00A77 to collect)\u00A7r")), false);
				{
					double _setval = 10 * Math.ceil((35 * ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl + 1)
							* Math.pow(1.0755, (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl + 1)) / 10) - 10;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.combatMilestoneKillsNeeded = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl == 20) {
					{
						double _setval = 0;
						sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.combatMilestoneKillsNeeded = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else {
					{
						double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).comMilNextLvl + 1;
						sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.comMilNextLvl = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
			if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl < 20) {
				if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl == 0) {
					comProgBefore = 0;
				} else {
					comProgBefore = 10 * Math.ceil((35 * (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl
							* Math.pow(1.0755, (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl)) / 10) - 10;
				}
				{
					double _setval = Math.round(10 * ((100 * ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).totalMobsKilled - comProgBefore))
							/ ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneKillsNeeded - comProgBefore)));
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.combatMilestoneProgress = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				{
					double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneProgress / 10;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.combatMilestoneProgress = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			} else {
				{
					double _setval = 100;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.combatMilestoneProgress = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
			if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 15) {
				{
					double _setval = 0;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillAttackNeededXp = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
			msgToPlayer = "\u00A7c+" + attackXp + " Attack Skill Xp (" + (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackXp + "/"
					+ (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackNeededXp + ")\u00A7r";
			if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackXp >= (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).skillAttackNeededXp && (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl < 25) {
				{
					double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl + 1;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillAttackLvl = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				{
					double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackXp
							- (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackNeededXp;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillAttackXp = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				{
					double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackNeededXp
							+ Math.round(1.25 * (0.302 * Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl, 3)
									+ 1.533 * Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl, 2)
									+ 14.958 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl + 28.698));
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillAttackNeededXp = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				OnAttackSkillUpProcedure.execute(world, x, y, z, entity, sourceentity);
				if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl <= 10) {
					{
						double _setval = attackXp + 10;
						entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.xp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl <= 20) {
					{
						double _setval = attackXp + 20;
						entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.xp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					{
						double _setval = attackXp + 30;
						entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.xp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				ChkPlayerLvlLevelUpProcedure.execute(entity);
			}
			msgToPlayer = msgToPlayer + " \u00A76+" + new java.text.DecimalFormat("##").format(corReward) + " Cor\u00A7r";
			if (mdReward > 0) {
				msgToPlayer = msgToPlayer + " \u00A7b+" + new java.text.DecimalFormat("##").format(mdReward) + " MD\u00A7r";
			}
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(msgToPlayer), true);
		}
	}
}
