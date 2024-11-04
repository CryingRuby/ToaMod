
package net.mcreator.toamod.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.world.inventory.SkillsMenuMenu;
import net.mcreator.toamod.procedures.OnPlayerProfileBackButtonClickedProcedure;
import net.mcreator.toamod.procedures.OnMinSkillButtonClickedProcedure;
import net.mcreator.toamod.procedures.OnMagSkillButtonClickedProcedure;
import net.mcreator.toamod.procedures.OnCookSkillButtonClickedProcedure;
import net.mcreator.toamod.procedures.OnComSkillButtonClickedProcedure;
import net.mcreator.toamod.ToamodMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkillsMenuSlotMessage {
	private final int slotID, x, y, z, changeType, meta;

	public SkillsMenuSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public SkillsMenuSlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(SkillsMenuSlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(SkillsMenuSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int slotID = message.slotID;
			int changeType = message.changeType;
			int meta = message.meta;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleSlotAction(entity, slotID, changeType, meta, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = SkillsMenuMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 1) {

			OnComSkillButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 0 && changeType == 2) {
			int amount = meta;

			OnComSkillButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 1) {

			OnMinSkillButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 2) {
			int amount = meta;

			OnMinSkillButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 2 && changeType == 1) {

			OnMagSkillButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 2 && changeType == 2) {
			int amount = meta;

			OnMagSkillButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 3 && changeType == 1) {

			OnCookSkillButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 3 && changeType == 2) {
			int amount = meta;

			OnCookSkillButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 4 && changeType == 1) {

			OnPlayerProfileBackButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 4 && changeType == 2) {
			int amount = meta;

			OnPlayerProfileBackButtonClickedProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ToamodMod.addNetworkMessage(SkillsMenuSlotMessage.class, SkillsMenuSlotMessage::buffer, SkillsMenuSlotMessage::new, SkillsMenuSlotMessage::handler);
	}
}
