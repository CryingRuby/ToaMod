package net.mcreator.toamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toamod.network.ToamodModVariables;

import java.util.List;
import java.util.Comparator;

public class OnIllfangPlayerCollisionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getBoolean("castAB3") + " | " + (entity.getPersistentData().getDouble("animTick") <= 300))), false);
		if (entity.getPersistentData().getBoolean("castAB3") && entity.getPersistentData().getDouble("animTick") <= 300) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Ability3 Collision"), false);
			{
				double _setval = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentHealth
						- Math.ceil((entity.getPersistentData().getDouble("AD") * 2.25) / (1 + 0 / 500));
				sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentHealth = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.001);
			sourceentity.setDeltaMovement(new Vec3((1.25 * (sourceentity.getX() - x)), 0.5, (1.25 * (sourceentity.getZ() - z))));
			entity.getPersistentData().putBoolean("setDashTarget", false);
			entity.getPersistentData().putDouble("ab3CD", (Mth.nextInt(RandomSource.create(), 220, 260)));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @e[type=toamod:gui_item_ghost,distance=..15] ~ ~-4 ~");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @e[type=toamod:gui_item_ghost,distance=..35]");
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						break;
					}
				}
			}
			entity.getPersistentData().putBoolean("castAB3", false);
		}
	}
}
