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

public class OnIllfangsRngDropsMenuTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean emptySlots = false;
		String trueOdds = "";
		String selectTxt = "";
		double i = 0;
		double trueOddsPerc = 0;
		for (int index0 = 0; index0 < 9; index0++) {
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
			trueOddsPerc = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGXp / GetIllfangRNGXpProcedure.execute(entity) + 1;
			if (trueOddsPerc > 2) {
				trueOddsPerc = 2;
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				if ((Component.translatable("item.toamod.goblin_egg_spices").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
					trueOdds = "\u00A78\u00A7m1% \u00A7r\u00A77" + new java.text.DecimalFormat("##.###").format(1 * trueOddsPerc) + "%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d" + ""
							+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGXp)
							+ " \u00A77/ \u00A7d100000 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.already_selected").getString() + "\"}'";
				} else {
					trueOdds = "1%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d100000 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + "" + Component.translatable("msg.click_select").getString() + "\"}'";
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:goblin_egg_spices\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7eI\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
										+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.rngesus").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}"));
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
				if ((Component.translatable("item.toamod.illfangs_cutlass").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
					trueOdds = "\u00A78\u00A7m3.08%\u00A7r \u00A77" + new java.text.DecimalFormat("##.###").format(3.08 * trueOddsPerc) + "%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d" + ""
							+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGXp)
							+ " \u00A77/ \u00A7d32500 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.already_selected").getString() + "\"}'";
				} else {
					trueOdds = "3.08%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d32500 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + "" + Component.translatable("msg.click_select").getString() + "\"}'";
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:illfangs_cutlass\",Count:1,tag:{HideFlags:2,deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7eI\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
										+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.extraordinary").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt
										+ "]}}}"));
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
				if ((Component.translatable("item.toamod.rune_rare").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
					trueOdds = "\u00A78\u00A7m8%\u00A7r \u00A77" + new java.text.DecimalFormat("##.###").format(8 * trueOddsPerc) + "%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d" + ""
							+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGXp)
							+ " \u00A77/ \u00A7d12500 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.already_selected").getString() + "\"}'";
				} else {
					trueOdds = "8%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d12500 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + "" + Component.translatable("msg.click_select").getString() + "\"}'";
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:rune_rare\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\"\u00A78Stat: ???\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7cII\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
										+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.very_rare").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}"));
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
				if ((Component.translatable("item.toamod.rune_uncomman").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
					trueOdds = "\u00A78\u00A7m11.111%\u00A7r \u00A77" + new java.text.DecimalFormat("##.###").format(11.111 * trueOddsPerc) + "%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d" + ""
							+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGXp)
							+ " \u00A77/ \u00A7d9000 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.already_selected").getString() + "\"}'";
				} else {
					trueOdds = "11.111%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d9000 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + "" + Component.translatable("msg.click_select").getString() + "\"}'";
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:rune_uncomman\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\"\u00A78Stat: ???\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7eI\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
										+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.rare").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}"));
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
				if ((Component.translatable("item.toamod.red_goblin_scale").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
					trueOdds = "\u00A78\u00A7m15%\u00A7r \u00A77" + new java.text.DecimalFormat("##.###").format(15 * trueOddsPerc) + "%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d" + ""
							+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGXp)
							+ " \u00A77/ \u00A7d6666 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.already_selected").getString() + "\"}'";
				} else {
					trueOdds = "15%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d6666 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + "" + Component.translatable("msg.click_select").getString() + "\"}'";
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:red_goblin_scale\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7eI\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
										+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.rare").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}"));
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
				if ((Component.translatable("item.toamod.boss_key_tier_3").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
					trueOdds = "\u00A78\u00A7m0.5%\u00A7r \u00A77" + new java.text.DecimalFormat("##.###").format(0.5 * trueOddsPerc) + "%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d" + ""
							+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGXp)
							+ " \u00A77/ \u00A7d200000 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.already_selected").getString() + "\"}'";
				} else {
					trueOdds = "0.5%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d200000 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + "" + Component.translatable("msg.click_select").getString() + "\"}'";
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:boss_key_tier_3\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A74III\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
										+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.rngesus").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt + "]}}}"));
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
				if ((Component.translatable("item.toamod.boss_key_tier_2").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
					trueOdds = "\u00A78\u00A7m1.428%\u00A7r \u00A77" + new java.text.DecimalFormat("##.###").format(1.428 * trueOddsPerc) + "%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d" + ""
							+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGXp)
							+ " \u00A77/ \u00A7d70000 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.already_selected").getString() + "\"}'";
				} else {
					trueOdds = "1.428%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d70000 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + "" + Component.translatable("msg.click_select").getString() + "\"}'";
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:boss_key_tier_2\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7cII\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
										+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.extraordinary").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt
										+ "]}}}"));
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
				if ((Component.translatable("item.toamod.boss_key_tier_1").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
					trueOdds = "\u00A78\u00A7m2.857%\u00A7r \u00A77" + new java.text.DecimalFormat("##.###").format(2.87 * trueOddsPerc) + "%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d" + ""
							+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGXp)
							+ " \u00A77/ \u00A7d35000 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + Component.translatable("msg.already_selected").getString() + "\"}'";
				} else {
					trueOdds = "2.857%";
					selectTxt = "'{\"text\":\"\u00A7dRNG-Meter\u00A77: \u00A7d35000 \u00A77XP\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"" + "" + Component.translatable("msg.click_select").getString() + "\"}'";
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"toamod:boss_key_tier_1\",Count:1,tag:{deleteItem:true,display:{Lore:['{\"text\":\" \"}','{\"text\":\"\u00A77Tier: \u00A7eI\u00A77+\u00A7r\"}','{\"text\":\" \"}','{\"text\":\"\u00A77"
										+ "" + Component.translatable("msg.odds").getString() + ": " + Component.translatable("drop.rarity.extraordinary").getString() + " \u00A77(" + trueOdds + ")\u00A7r\"}','{\"text\":\" \"}'," + selectTxt
										+ "]}}}"));
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
								"data modify entity @e[type=toamod:gui_item_ghost,limit=1,distance=..2] HandItems[0] set value {id:\"minecraft:arrow\",Count:1,tag:{display:{Name:'{\"text\":\"\u00A7b\u00A7lBack\u00A7r\"}'}}}");
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
