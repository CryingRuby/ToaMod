package net.mcreator.toamod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class OnGoblinScoutTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double lvl = 0;
		double mp = 0;
		double i = 0;
		double mobSpawned = 0;
		double newX = 0;
		double newZ = 0;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12, 12, 12), e -> true).isEmpty() && !entity.getPersistentData().getBoolean("called")) {
			entity.getPersistentData().putBoolean("called", true);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 10, false, false));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, (x + 1), (y + 1), (z + 1), 150, 1, 1, 1, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.angry")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.angry")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.angry")), SoundSource.HOSTILE, 1, (float) 0.75);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.angry")), SoundSource.HOSTILE, 1, (float) 0.75, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.angry")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.angry")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.angry")), SoundSource.HOSTILE, 1, (float) 0.75);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.angry")), SoundSource.HOSTILE, 1, (float) 0.75, false);
				}
			}
			lvl = entity.getPersistentData().getDouble("lvl");
			mp = entity.getPersistentData().getDouble("MP");
			i = 0;
			for (int index0 = 0; index0 < 3; index0++) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + i)), false);
				if (i == 1) {
					newX = x + 1;
					newZ = z + 2;
				} else if (i == 2) {
					newX = x + 2;
					newZ = z;
				} else {
					newX = x + 1;
					newZ = z - 2;
				}
				if (Math.abs(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) newX, (int) newZ) - y) <= 3
						&& world.getBlockState(BlockPos.containing(newX, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) newX, (int) newZ) - 1, newZ)).canOcclude()
						&& !world.getBlockState(BlockPos.containing(newX, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) newX, (int) newZ), newZ)).canOcclude()
						&& !world.getBlockState(BlockPos.containing(newX, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) newX, (int) newZ) + 1, newZ)).canOcclude()) {
					if (mobSpawned == 1) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3(newX, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) newX, (int) newZ)), newX), Vec2.ZERO, _level, 4, "", Component.literal(""),
											_level.getServer(), null).withSuppressedOutput(),
									("summon toamod:goblin_hunter " + newX + " " + world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) newX, (int) newZ) + " " + newZ + " {CustomNameVisible:1b,CustomName:'{\"text\":\"\u00A77[Lvl "
											+ new java.text.DecimalFormat("##").format(lvl + 1) + "] \u00A7c" + Component.translatable("mob.type.goblin_hunter").getString() + " \u00A77(\u00A7a"
											+ new java.text.DecimalFormat("##").format(7 * (lvl + 1)) + "\u00A7c\u2764\u00A77)\u00A7r\"}',ForgeData:{currentHealth:" + new java.text.DecimalFormat("##").format(7 * (lvl + 1)) + ",maxHealth:"
											+ new java.text.DecimalFormat("##").format(7 * (lvl + 1)) + ",AR:" + new java.text.DecimalFormat("##").format(9 * (lvl + 1)) + ",MR:" + new java.text.DecimalFormat("##").format(9 * (lvl + 1)) + ",AD:"
											+ new java.text.DecimalFormat("##").format(3 * (lvl + 1) + 0.35 * mp) + ",CR:" + new java.text.DecimalFormat("##").format(Math.round(1.5 * (lvl + 1))) + ",CD:"
											+ new java.text.DecimalFormat("##").format(Math.round(2.25 * (lvl + 1))) + "}}"));
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3(newX, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) newX, (int) newZ)), newX), Vec2.ZERO, _level, 4, "", Component.literal(""),
											_level.getServer(), null).withSuppressedOutput(),
									("summon toamod:goblin " + newX + " " + world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) newX, (int) newZ) + " " + newZ + " {CustomNameVisible:1b,CustomName:'{\"text\":\"\u00A77[Lvl "
											+ new java.text.DecimalFormat("##").format(lvl - 1) + "] \u00A7c" + Component.translatable("mob.type.goblin").getString() + " \u00A77(\u00A7a" + new java.text.DecimalFormat("##").format(13 * (lvl - 1))
											+ "\u00A7c\u2764\u00A77)\u00A7r\"}',ForgeData:{currentHealth:" + new java.text.DecimalFormat("##").format(13 * (lvl - 1)) + ",maxHealth:" + new java.text.DecimalFormat("##").format(13 * (lvl - 1)) + ",AR:"
											+ new java.text.DecimalFormat("##").format(10 * (lvl - 1)) + ",MR:" + new java.text.DecimalFormat("##").format(10 * (lvl - 1)) + ",AD:" + new java.text.DecimalFormat("##").format(3 * (lvl - 1) + 0.35 * mp)
											+ ",CR:" + new java.text.DecimalFormat("##").format(Math.round(1.25 * (lvl - 1))) + ",CD:" + new java.text.DecimalFormat("##").format(Math.round(1.75 * (lvl - 1))) + "}}"));
					}
					mobSpawned = mobSpawned + 1;
				}
				i = i + 1;
			}
		}
	}
}
