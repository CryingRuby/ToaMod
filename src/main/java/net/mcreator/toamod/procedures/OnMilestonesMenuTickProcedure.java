package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;

public class OnMilestonesMenuTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double i = 0;
		boolean slotsEmpty = false;
		String emptySlots = "";
		String outString = "";
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:netherite_sword\",Count:1,tag:{HideFlags:2,display:{Name:'{\"text\":\"\u00A7r\u00A7c\u00A7lFighter\u00A7r\"}',Lore:['{\"text\":\" \"}',"
				+ "" + Component.translatable("item.toamod.milestones_combat_item.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A7c\u00A7l"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl)
				+ "\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).totalMobsKilled) + " \u00A78/ \u00A77"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneKillsNeeded)
				+ " Kills\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.next_rewards").getString() + "\u00A7r\"}',"
				+ Component.translatable(
						("milestone.fighter.rewards." + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl + 1)))
						.getString()
				+ ",'{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:netherite_sword\",Count:1,tag:{HideFlags:2,display:{Name:'{\"text\":\"\u00A7r\u00A7c\u00A7lFighter\u00A7r\"}',Lore:['{\"text\":\" \"}',"
				+ "" + Component.translatable("item.toamod.milestones_combat_item.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A7c\u00A7l"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl)
				+ "\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).totalMobsKilled) + " \u00A78/ \u00A77"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneKillsNeeded)
				+ " Kills\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A7b\u00A7lMAX LEVEL\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:netherite_pickaxe\",Count:1,tag:{HideFlags:2,display:{Name:'{\"text\":\"\u00A7r\u00A7b\u00A7lDwarfs Way\u00A7r\"}',Lore:['{\"text\":\" \"}',"
				+ "" + Component.translatable("item.toamod.milestones_mining_item.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A7b\u00A7l"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneLvl)
				+ "\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).totalOresMined) + " \u00A78/ \u00A77"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneOresNeeded)
				+ " Ores\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.next_rewards").getString() + "\u00A7r\"}',"
				+ Component.translatable(("milestone.dwarfs_way.rewards."
						+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneLvl + 1))).getString()
				+ ",'{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:netherite_pickaxe\",Count:1,tag:{HideFlags:2,display:{Name:'{\"text\":\"\u00A7r\u00A7b\u00A7lDwarfs Way\u00A7r\"}',Lore:['{\"text\":\" \"}',"
				+ "" + Component.translatable("item.toamod.milestones_mining_item.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A7b\u00A7l"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneLvl)
				+ "\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).totalOresMined) + " \u00A78/ \u00A77"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneOresNeeded)
				+ " Ores\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A7b\u00A7lMAX LEVEL\u00A7\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
		outString = "+3x COOMING SOON";
		System.out.println(outString);
	}
}
