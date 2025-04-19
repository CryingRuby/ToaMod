package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;

public class OnSkillsMenuTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean slotsEmpty = false;
		double i = 0;
		String outString = "";
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:diamond_sword\",Count:1,tag:{HideFlags:2,display:{Name:'{\"text\":\"\u00A74\u00A7lCombat\u00A7r\"}',Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A74"
				+ "" + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl) + " \u00A78(\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackXp) + " \u00A78/\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackNeededXp)
				+ " XP\u00A78)\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.next_rewards").getString() + "\u00A7r\"}',"
				+ Component
						.translatable(
								("skill.combat.rewards." + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl + 1)))
						.getString()
				+ ",'{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:diamond_sword\",Count:1,tag:{HideFlags:2,display:{Name:'{\"text\":\"\u00A74\u00A7lCombat\u00A7r\"}',Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A74"
				+ "" + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl) + " \u00A78(\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackXp) + " \u00A78/\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillAttackNeededXp)
				+ " XP\u00A78)\u00A7r\"}','{\"text\":\" \"}','{\"text:\"\u00A7b\u00A7lMAX LEVEL\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:diamond_pickaxe\",Count:1,tag:{HideFlags:2,display:{Name:'{\"text\":\"\u00A73\u00A7lMining\u00A7r\"}',Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A73"
				+ "" + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillDefenseLvl) + " \u00A78(\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillDefenseXp) + " \u00A78/\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillDefenseNeededXp)
				+ " XP\u00A78)\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.next_rewards").getString() + "\u00A7r\"}',"
				+ Component
						.translatable(
								("skill.mining.rewards." + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillDefenseLvl + 1)))
						.getString()
				+ ",'{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:diamond_pickaxe\",Count:1,tag:{HideFlags:2,display:{Name:'{\"text\":\"\u00A73\u00A7lMining\u00A7r\"}',Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A73"
				+ "" + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillDefenseLvl) + " \u00A78(\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillDefenseXp) + " \u00A78/\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillDefenseNeededXp)
				+ " XP\u00A78)\u00A7r\"}','{\"text\":\" \"}','{\"text:\"\u00A7b\u00A7lMAX LEVEL\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:enchanted_book\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A75\u00A7lMagic\u00A7r\"}',Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A75"
				+ "" + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillMagicLvl) + " \u00A78(\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillMagicXp) + " \u00A78/\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillMagicNeededXp)
				+ " XP\u00A78)\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.next_rewards").getString() + "\u00A7r\"}',"
				+ Component
						.translatable(
								("skill.magic.rewards." + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillMagicLvl + 1)))
						.getString()
				+ ",'{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:enchanted_book\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A75\u00A7lMagic\u00A7r\"}',Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A75"
				+ "" + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillMagicLvl) + " \u00A78(\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillMagicXp) + " \u00A78/\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillMagicNeededXp)
				+ " XP\u00A78)\u00A7r\"}','{\"text\":\" \"}','{\"text:\"\u00A7b\u00A7lMAX LEVEL\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:cooking_skill_item\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A7a\u00A7lCooking\u00A7r\"}',Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A7a"
				+ "" + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillCookingLvl) + " \u00A78(\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillCookingXp) + " \u00A78/\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillCookingNeededXp)
				+ " XP\u00A78)\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.next_rewards").getString() + "\u00A7r\"}',"
				+ Component
						.translatable(
								("skill.cooking.rewards." + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillCookingLvl + 1)))
						.getString()
				+ ",'{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:cooking_skill_item\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A7a\u00A7lCooking\u00A7r\"}',Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Level: \u00A7a"
				+ "" + new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillCookingLvl) + " \u00A78(\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillCookingXp) + " \u00A78/\u00A77"
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).skillCookingNeededXp)
				+ " XP\u00A78)\u00A7r\"}','{\"text\":\" \"}','{\"text:\"\u00A7b\u00A7lMAX LEVEL\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.click_details").getString() + "\"}']}}}";
		System.out.println(outString);
	}
}
