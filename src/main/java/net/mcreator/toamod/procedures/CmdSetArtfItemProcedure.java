package net.mcreator.toamod.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;

public class CmdSetArtfItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double i = 0;
		ItemStack item = ItemStack.EMPTY;
		{
			ItemStack _setval = new ItemStack(ToamodModItems.ARTEFACTS_ITEM.get());
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.artefacts = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		for (int index0 = 0; index0 < 27; index0++) {
			item = new ItemStack(Blocks.GRAY_STAINED_GLASS_PANE);
			item.setHoverName(Component.literal("\u00A7c\u00A7l???\u00A7r"));
			{
				ItemStack _isc = ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).artefacts);
				final ItemStack _setstack = item.copy();
				final int _sltid = (int) i;
				_setstack.setCount(1);
				_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
						itemHandlerModifiable.setStackInSlot(_sltid, _setstack);
					}
				});
			}
			i = i + 1;
		}
	}
}
