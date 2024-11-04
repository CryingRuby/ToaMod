package net.mcreator.toamod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SetEntityDisplayNameProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String hpTxt = "";
		hpTxt = new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("currentHealth"));
		if (entity.getPersistentData().getDouble("currentHealth") / 10000 >= 1) {
			hpTxt = new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("currentHealth") / 10000) + "K";
		}
		if (entity.getPersistentData().getDouble("currentHealth") / 1000000 >= 1) {
			hpTxt = new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("currentHealth") / 1000000) + "M";
		}
		entity.setCustomName(Component.literal(("\u00A77[Lvl " + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("lvl")) + "] \u00A7c"
				+ Component.translatable(("mob.type." + (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).replace("toamod:", ""))).getString() + " \u00A77(\u00A7a" + hpTxt + "\u00A7c\u2764\u00A77)\u00A7r")));
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {CustomNameVisible:1b}");
			}
		}
	}
}
