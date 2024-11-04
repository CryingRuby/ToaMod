package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;

public class GuiYourCorValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("msg.your_cor").getString() + "" + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).cor)
				+ "\u00A7r";
	}
}
