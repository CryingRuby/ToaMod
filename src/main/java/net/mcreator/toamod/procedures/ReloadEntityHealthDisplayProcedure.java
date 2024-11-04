package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class ReloadEntityHealthDisplayProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String hpTxt = "";
		String hpPref = "";
		double hp = 0;
		double i = 0;
		hp = entity.getPersistentData().getDouble("currentHealth");
		hpTxt = new java.text.DecimalFormat("##").format(hp);
		if (hp / 10000 >= 1) {
			hpTxt = new java.text.DecimalFormat("##").format(hp / 1000) + "K";
		}
		if (hp / 1000000 >= 1) {
			hpTxt = new java.text.DecimalFormat("##").format(hp / 1000000) + "M";
		}
		if (entity.getPersistentData().getDouble("currentHealth") / entity.getPersistentData().getDouble("maxHealth") <= 0.15) {
			hpPref = "\u00A74";
		} else if (entity.getPersistentData().getDouble("currentHealth") / entity.getPersistentData().getDouble("maxHealth") <= 0.5) {
			hpPref = "\u00A7e";
		} else {
			hpPref = "\u00A7a";
		}
		while (i < (entity.getDisplayName().getString()).length() && !((entity.getDisplayName().getString()).substring(0, (int) i)).endsWith("(")) {
			i = i + 1;
		}
		if (i != 0) {
			entity.setCustomName(Component.literal(((entity.getDisplayName().getString()).substring(0, (int) i) + "" + hpPref + hpTxt + "\u00A7c\u2764\u00A77)\u00A7r")));
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {CustomNameVisible:1b}");
				}
			}
		}
	}
}
