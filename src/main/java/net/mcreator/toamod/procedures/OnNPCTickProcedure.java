package net.mcreator.toamod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class OnNPCTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double i = 0;
		if (entity.getPersistentData().getDouble("refreshTimer") > 0) {
			entity.getPersistentData().putDouble("refreshTimer", (entity.getPersistentData().getDouble("refreshTimer") - 1));
		}
		if (entity.getPersistentData().getBoolean("txtStarted") && entity.getPersistentData().getDouble("txtDelay") == 0) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.trade")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.trade")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity.getPersistentData().getBoolean("hasQuests")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("questsText"), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal(("[" + entity.getDisplayName().getString() + "\u00A77]: " + entity.getPersistentData().getString(("msg" + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("txtIndex")))))),
							false);
			}
			entity.getPersistentData().putDouble("txtIndex", (entity.getPersistentData().getDouble("txtIndex") + 1));
			entity.getPersistentData().putDouble("txtDelay", 30);
			if (entity.getPersistentData().getDouble("txtIndex") == entity.getPersistentData().getDouble("txtAmount")) {
				entity.getPersistentData().putBoolean("txtStarted", false);
				if ((entity.getPersistentData().getString("specialNPC")).equals("merchant")) {
				}
			}
		}
	}
}
