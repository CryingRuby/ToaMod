package net.mcreator.toamod.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.init.ToamodModBlocks;

import java.util.Random;

public class GetChestLootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack coritem = ItemStack.EMPTY;
		ItemStack mditem = ItemStack.EMPTY;
		double chestValue = 0;
		double corMin = 0;
		double corMax = 0;
		double mdMin = 0;
		double mdMax = 0;
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == ToamodModBlocks.CHEST_NORMAL.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
								_level.getServer(), null).withSuppressedOutput(),
						("data merge block ~ ~ ~ {LootTable:\"toamod:chests/chest_normal_" + ""
								+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).currentRegion)
								+ "\"}"));
			chestValue = 1;
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == ToamodModBlocks.CHEST_EPIC.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
								_level.getServer(), null).withSuppressedOutput(),
						("data merge block ~ ~ ~ {LootTable:\"toamod:chests/chest_epic_" + ""
								+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).currentRegion)
								+ "\"}"));
			chestValue = 2;
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == ToamodModBlocks.CHEST_LEGENDARY.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
								_level.getServer(), null).withSuppressedOutput(),
						("data merge block ~ ~ ~ {LootTable:\"toamod:chests/chest_legendary_" + ""
								+ (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).currentRegion
								+ "\"}"));
			chestValue = 3;
		}
		coritem = new ItemStack(ToamodModItems.COR.get());
		mditem = new ItemStack(ToamodModItems.MAGIC_DUST.get());
		corMin = Math.round((40
				* Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).currentRegion, chestValue)
				+ Math.pow(28, chestValue) + 23 * Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).currentRegion, 2)
				+ 361 * Math.pow(chestValue, 2)) - 300);
		corMax = Math.round(2.5 * corMin);
		mdMin = Math
				.round((0.3
						+ Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).currentRegion, chestValue)
						+ 5 + chestValue + Math.pow(5, chestValue)) - 6.5);
		mdMax = Math.round(2.5 * mdMin);
		coritem.getOrCreateTag().putDouble("amount", (Mth.nextInt(new Random(), (int) corMin, (int) corMax)));
		mditem.getOrCreateTag().putDouble("amount", (Mth.nextInt(new Random(), (int) mdMin, (int) mdMax)));
		(coritem).setHoverName(new TextComponent(("\u00A76Cor " + coritem.getOrCreateTag().getDouble("amount") + "\u00A7r")));
		(mditem).setHoverName(new TextComponent(("\u00A76Magic Dust " + mditem.getOrCreateTag().getDouble("amount") + "\u00A7r")));
		if (Math.random() < 0.3 * chestValue + 0.4) {
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				if (_ent != null) {
					final int _slotid = Mth.nextInt(new Random(), 0, (int) (2 + 6 * chestValue));
					final ItemStack _setstack = coritem;
					_setstack.setCount(1);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
		}
		if (Math.random() < 0.5 * chestValue - 0.5) {
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				if (_ent != null) {
					final int _slotid = Mth.nextInt(new Random(), 0, (int) (2 + 6 * chestValue));
					final ItemStack _setstack = mditem;
					_setstack.setCount(1);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
		}
	}
}
