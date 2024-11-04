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

public class OnDwarfsWayRewardsTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double i = 0;
		boolean emptySlots = false;
		String itemId = "";
		String progressTxt = "";
		for (int index0 = 0; index0 < 21; index0++) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				emptySlots = true;
				break;
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
								"data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"minecraft:gold_block\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A76\u00A7lStart\u00A7r\"}'}}}");
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
			i = 1;
			for (int index1 = 0; index1 < 20; index1++) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					if (i <= (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneLvl) {
						if (i % 5 == 0) {
							itemId = "minecraft:emerald_block";
							progressTxt = ",'{\"text\":\" \"}','{\"text\":\"\u00A7a" + "" + Component.translatable("msg.rewards_unlocked").getString() + "\u00A7r\"}'";
						} else {
							itemId = "minecraft:lime_dye";
							progressTxt = ",'{\"text\":\" \"}','{\"text\":\"\u00A7a" + "" + Component.translatable("msg.rewards_unlocked").getString() + "\u00A7r\"}'";
						}
					} else {
						if (i - 1 == (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneLvl) {
							progressTxt = ",'{\"text\":\" \"}','{\"text\":\"\u00A7a";
							for (int index2 = 0; index2 < (int) Math.floor(((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).totalOresMined
									/ (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneOresNeeded) * 10); index2++) {
								progressTxt = progressTxt + "-";
							}
							progressTxt = progressTxt + "\u00A77";
							for (int index3 = 0; index3 < (int) (10 - Math.floor(((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).totalOresMined
									/ (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneOresNeeded) * 10)); index3++) {
								progressTxt = progressTxt + "-";
							}
							progressTxt = progressTxt + " \u00A7e"
									+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).totalOresMined) + " \u00A77/ \u00A7e"
									+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneOresNeeded)
									+ " \u00A77(\u00A7e"
									+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneProgress)
									+ "%\u00A77)\u00A7r\"}'";
						} else {
							progressTxt = "";
						}
						if (i % 5 == 0) {
							itemId = "minecraft:redstone_block";
						} else {
							itemId = "toamod:dark_red_dye";
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"" + "" + itemId + "\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A7a\u00A7lLevel "
											+ new java.text.DecimalFormat("##").format(i) + "\u00A7r\"}',Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77" + Component.translatable("msg.rewards").getString() + "\u00A7r\"}',"
											+ Component.translatable(("milestone.dwarfs_way.rewards." + new java.text.DecimalFormat("##").format(i))).getString() + progressTxt + "]}}}"));
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
									((Slot) _slots.get((int) i)).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
				}
				i = i + 1;
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(21)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								"data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"minecraft:arrow\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A7bBack\u00A7r\"}'}}}");
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
								((Slot) _slots.get(21)).set(_setstack);
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
