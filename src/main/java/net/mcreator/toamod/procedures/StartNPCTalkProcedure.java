package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;

import classes.ToaQuestTexts;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;


public class StartNPCTalkProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.getPersistentData().getBoolean("txtStarted")) {
			entity.getPersistentData().putBoolean("txtStarted", true);
			entity.getPersistentData().putDouble("txtDelay", 0);
			entity.getPersistentData().putDouble("txtIndex", 0);
			if (!entity.getPersistentData().getString("questKey").isEmpty()) {
				entity.getPersistentData().putInt("qTxtAmount", ToaQuestTexts.getQuestTextLength(entity.getPersistentData().getString("QuestKey"), "1"));
			}
		}
	}
}
