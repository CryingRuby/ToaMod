package net.mcreator.toamod.procedures;

import net.minecraft.network.chat.Component;

public class OnIllfangsRngDropsMenuTickProcedure {
	public static void execute() {
		boolean emptySlots = false;
		double i = 0;
		double trueOddsPerc = 0;
		String trueOdds = "";
		String selectTxt = "";
		String outString = "";
		trueOdds = "<trueOdds>";
		selectTxt = "<selectedTxt>";
		outString = "data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:goblin_egg_spices\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7eI\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.rngesus").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:illfangs_cutlass\",Count:1,tag:{HideFlags:2,deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7eI\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.extraordinary").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:rune_rare\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\"\u00A78Stat: ???\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7cII\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.very_rare").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:rune_uncomman\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\"\u00A78Stat: ???\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7eI\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.rare").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:red_goblin_scale\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7eI\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.rare").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:boss_key_tier_3\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A74III\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.rngesus").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:boss_key_tier_2\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7cII\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.extraordinary").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}";
		System.out.println(outString);
		outString = "data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:boss_key_tier_1\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7eI\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
				+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.extraordinary").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}";
		System.out.println(outString);
	}
}
