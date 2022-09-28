package net.mcreator.toamod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.network.ToamodModVariables;

public class OnAttackSkillUpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 1) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A760 \u00A73-> \u00A76\u00A7lI\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7fIron Sword \u00A77recipe for Weapon Table\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				String _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).playerRecipes + " toamod:hardened_iron_sword ,";
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerRecipes = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 2) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76I \u00A73-> \u00A76\u00A7lII\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7fHardened Iron Sword \u00A77recipe for Weapon Table\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				String _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).playerRecipes + " toamod:hardened_iron_sword ,";
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerRecipes = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 3) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76II \u00A73-> \u00A76\u00A7lIII\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7aGold Sword \u00A77recipe for Weapon Table\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				String _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).playerRecipes + " toamod:gold_sword ,";
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerRecipes = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 4) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76III \u00A73-> \u00A76\u00A7lIV\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 5) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76IV \u00A73-> \u00A76\u00A7lV\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7bCristal Sword \u00A77recipe for Weapon Table\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				String _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).playerRecipes + " toamod:cristal_sword ,";
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerRecipes = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 6) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76V \u00A73-> \u00A76\u00A7lVI\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 7) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76VI \u00A73-> \u00A76\u00A7lVII\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7bJade Sword \u00A77recipe for Weapon Table\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				String _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).playerRecipes + " toamod:jade_sword ,";
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerRecipes = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 8) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76VII \u00A73-> \u00A76\u00A7lVIII\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A75Flame Sword \u00A77recipe for Weapon Table\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				String _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).playerRecipes + " toamod:flame_sword ,";
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerRecipes = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 9) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76VIII \u00A73-> \u00A76\u00A7lIX\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 10) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76IX \u00A73-> \u00A76\u00A7lX\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A75Death's Dance\u00A77recipe for Weapon Table\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				String _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).playerRecipes + " toamod:deaths_dance ,";
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerRecipes = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 11) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76X \u00A73-> \u00A76\u00A7lXI\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 12) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76XI \u00A73-> \u00A76\u00A7lXII\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76Dragon Slayer\u00A77recipe for Weapon Table\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				String _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).playerRecipes + " toamod:dragon_slayer ,";
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerRecipes = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 13) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76XII \u00A73-> \u00A76\u00A7lXIII\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76The Dark Blade \u00A77recipe for Weapon Table\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				String _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).playerRecipes + " toamod:the_dark_blade ,";
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerRecipes = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 14) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76XIII \u00A73-> \u00A76\u00A7lXIV\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl == 15) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Attack Skill:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76XIV \u00A73-> \u00A76\u00A7lXV\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73Rewards:\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7eAncient Guardian Warhammer\u00A77recipe for Weapon Table\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1% \uD83C\uDFF9 critical strike chance \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+10% \uD83D\uDDE1 critical strike damage \u00A77permanent\u00A7r"), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(" "), (false));
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A73-----------------------------------------------------\u00A7r"), (false));
			{
				String _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).playerRecipes + " toamod:ancient_guardian_axe ,";
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerRecipes = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 1;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).level + 10;
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
		if ((sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl < 15) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")),
							SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.death")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.death")),
							SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
