package net.mcreator.toamod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.toamod.network.ToamodModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnEntityKilledProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(),
					event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double attackXp = 0;
		double comProgBefore = 0;
		if (sourceentity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent((sourceentity.getDisplayName().getString())), (false));
		if (entity instanceof WitherSkeleton) {
			attackXp = 45;
		}
		if (attackXp > 0) {
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).skillAttackXp + attackXp;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.skillAttackXp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).totalMobsKilled + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.totalMobsKilled = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).totalMobsKilled >= (sourceentity
							.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneKillsNeeded
					&& (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl < 20) {
				{
					double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl + 1;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.combatMilestoneLvl = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (sourceentity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("\u00A77Combat Milestone Level Up (You have \u00A76"
							+ new java.text.DecimalFormat("##")
									.format((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl
											- (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed)
							+ "\u00A77 unclaimed rewards, speak to \u00A7bThe Bartender\u00A77 to collect)\u00A7r")), (false));
				{
					double _setval = 10
							* Math.ceil(
									(35 * ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl + 1) * Math
													.pow(1.0755,
															(sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl + 1))
											/ 10)
							- 10;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.combatMilestoneKillsNeeded = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl == 20) {
					{
						double _setval = 0;
						sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.combatMilestoneKillsNeeded = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else {
					{
						double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).comMilNextLvl + 1;
						sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.comMilNextLvl = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
			if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl < 20) {
				if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl == 0) {
					comProgBefore = 0;
				} else {
					comProgBefore = 10
							* Math.ceil(
									(35 * (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl * Math
													.pow(1.0755,
															(sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl))
											/ 10)
							- 10;
				}
				{
					double _setval = Math.round(10 * ((100 * ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).totalMobsKilled - comProgBefore))
							/ ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneKillsNeeded - comProgBefore)));
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.combatMilestoneProgress = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				{
					double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneProgress / 10;
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
			if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 15) {
				{
					double _setval = 0;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillAttackNeededXp = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("\u00A7c+" + attackXp + " Attack Skill Xp ("
						+ (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).skillAttackXp
						+ "/" + (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).skillAttackNeededXp
						+ ")\u00A7r")), (true));
			if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).skillAttackXp >= (sourceentity
							.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).skillAttackNeededXp
					&& (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl < 15) {
				{
					double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl + 1;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillAttackLvl = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				{
					double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).skillAttackXp
							- (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new ToamodModVariables.PlayerVariables())).skillAttackNeededXp;
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillAttackXp = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				{
					double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).skillAttackNeededXp
							+ Math.round(1.25 * (0.302
									* Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl, 3)
									+ 1.533 * Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl, 2)
									+ 14.958 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl
									+ 28.698));
					sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.skillAttackNeededXp = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				OnAttackSkillUpProcedure.execute(world, x, y, z, sourceentity);
			}
		}
	}
}
