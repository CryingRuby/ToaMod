package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;

public class OnBossCollectionMenuTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean emptySlots = false;
		double i = 0;
		double progPerc = 0;
		String rngTxt = "";
		String progTxt = "";
		String outString = "";
		rngTxt = "<RngTxt>";
		progTxt = "<ProgressTxt>";
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:player_head\",Count:1,tag:{deleteItem:true,display:{Name:'{\"text\":\"\u00A7cBoss 1 - Illfang\u00A7r\"}',Lore:['{\"text\":\" \"}',"
				+ "" + Component.translatable("boss.illfang.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A77(\u00A7d"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGXp) + progTxt
				+ "\u00A77)\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A7d" + rngTxt + " \u00A77(\u00A7d"
				+ new java.text.DecimalFormat("##.##")
						.format(Math.floor(((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGXp / GetIllfangRNGXpProcedure.execute(entity)) * 1000) / 10)
				+ "%\u00A77)\u00A7r\"}','{\"text\":\"\u00A7a" + Component.translatable("msg.selec_drop").getString() + ": \u00A7f"
				+ (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected + "\u00A7r\"}','{\"text\":\" \"}','{\"text\":\""
				+ Component.translatable("msg.click_switch").getString()
				+ "\"}']},SkullOwner:{Id:[I;-1680701883,822624555,-1428439464,1567539291],Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTI3NTE3ZWU4MWUxNGQzYmI5ZmQxZmM2YzllYmIyYmIwMmZlODZhYTAwMmMwZDUyNmI0MzM1N2NiMGQ2YWZkMCJ9fX0=\"}]}}}}";
		System.out.println(outString);
		outString = "Alle anderen (8x) COMING SOON";
		System.out.println(outString);
	}
}
