package net.mcreator.toamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.entity.GuiItemGhostEntity;

import java.util.function.Supplier;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class OnPlayerStatsMenuTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double i = 0;
		boolean emptySlots = false;
		for (int index0 = 0; index0 < 15; index0++) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				emptySlots = true;
			}
			i = i + 1;
		}
		if (emptySlots) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "summon toamod:gui_item_ghost ~ ~ ~");
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_hp\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A7cHealth\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.hp.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A7c" + Component.translatable("stat.max_hp").getString() + ": \u00A7f"
										+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).maxHealth) + "\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(0)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_mana\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A79Mana\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.mana.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A79" + Component.translatable("stat.max_mana").getString() + ": \u00A7f"
										+ new java.text.DecimalFormat("##").format(GetPlayerMANAEntityProcedure.execute(entity)) + "\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(1)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_ad\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A7cAttack Damage\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.ad.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A7c" + Component.translatable("stat.ad").getString() + ": \u00A7f"
										+ new java.text.DecimalFormat("##").format(GetPlayerADEntityProcedure.execute(entity)) + "\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(2)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_mp\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A75Magic Power\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.mp.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A75" + Component.translatable("stat.mp").getString() + ": \u00A7f"
										+ new java.text.DecimalFormat("##").format(GetPlayerMPEntityProcedure.execute(entity)) + "\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(3)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_ar\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A7eArmor\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.ar.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A7e" + Component.translatable("stat.ar").getString() + ": \u00A7f"
										+ new java.text.DecimalFormat("##").format(GetPlayerAREntityProcedure.execute(entity)) + "\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_mr\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A7bMagic Resistance\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.mr.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A7b" + Component.translatable("stat.mr").getString() + ": \u00A7f"
										+ new java.text.DecimalFormat("##").format(GetPlayerMREntityProcedure.execute(entity)) + "\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(5)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_crcd\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A74Critical Rate\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.cr.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A74" + Component.translatable("stat.cr").getString() + ": \u00A7f"
										+ new java.text.DecimalFormat("##.##").format(GetPlayerCREntityProcedure.execute(entity)) + "\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(6)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(7)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_crcd\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A74Critical Damage\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.cd.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A74" + Component.translatable("stat.cd").getString() + ": \u00A7f"
										+ new java.text.DecimalFormat("##.##").format(GetPlayerCDEntityProcedure.execute(entity)) + "\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(7)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_mf\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A7dMagic Find\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.mf.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.current_bonus").getString() + "\u00A7r\"}','{\"text\":\"\u00A7d+"
										+ new java.text.DecimalFormat("##").format(100 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).magicFind) + "\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(8)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(9)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningFortune >= 1) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_minf\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A76Mining Fortune\u00A7r\"}',Lore:['{\"text\":\" \"}',"
											+ "" + Component.translatable("stat.minf.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.current_bonus").getString()
											+ "\u00A7r\"}','{\"text\":\"\u00A76100% \u00A77-> "
											+ new java.text.DecimalFormat("##").format(Math.floor((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningFortune) + 1)
											+ "x drops\u00A7r\"}','{\"text\":\"\u00A76"
											+ new java.text.DecimalFormat("##").format(100 * ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningFortune
													- Math.floor((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningFortune)) + 1)
											+ "% \u00A77-> "
											+ new java.text.DecimalFormat("##").format(Math.floor((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningFortune) + 2)
											+ "x drops\u00A7r\"}']}}}"));
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_minf\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A76Mining Fortune\u00A7r\"}',Lore:['{\"text\":\" \"}',"
											+ "" + Component.translatable("stat.minf.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.current_bonus").getString()
											+ "\u00A7r\"}','{\"text\":\"\u00A76 "
											+ new java.text.DecimalFormat("##").format(100 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningFortune)
											+ "% \u00A77-> 2x drops\u00A7r\"}']}}}"));
						}
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(9)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(10)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_wis\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A73Combat Wisdom\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.com_wis.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.current_bonus").getString() + "\u00A7r\"}','{\"text\":\"\u00A73+"
										+ new java.text.DecimalFormat("##").format(100 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).bonusCombatXp)
										+ "%\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(10)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(11)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_wis\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A73Mining Wisdom\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.min_wis.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.current_bonus").getString() + "\u00A7r\"}','{\"text\":\"\u00A73+"
										+ new java.text.DecimalFormat("##").format(100 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).bonusMiningXp)
										+ "%\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(11)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(12)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_wis\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A73Magic Wisdom\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.mag_wis.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.current_bonus").getString() + "\u00A7r\"}','{\"text\":\"\u00A73+"
										+ new java.text.DecimalFormat("##").format(100 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).bonusMagicXp)
										+ "%\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(12)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(13)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"toamod:stat_icon_wis\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A73Cooking Wisdom\u00A7r\"}',Lore:['{\"text\":\" \"}',"
										+ "" + Component.translatable("stat.cook_wis.description").getString() + ",'{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.current_bonus").getString()
										+ "\u00A7r\"}','{\"text\":\"\u00A73+"
										+ new java.text.DecimalFormat("##").format(100 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).bonusCookingXp)
										+ "%\u00A7r\"}']}}}"));
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(13)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(14)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								"data modify entity @e[type=toamod:gui_item_ghost,distance=..2,limit=1] HandItems[0] set value {id:\"minecraft:arrow\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A7b\u00A7lBack\u00A7r\"}'}}}");
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GuiItemGhostEntity) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(14)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @e[type=toamod:gui_item_ghost,distance=..2] ~ ~-300 ~");
				}
			}
		}
	}
}
