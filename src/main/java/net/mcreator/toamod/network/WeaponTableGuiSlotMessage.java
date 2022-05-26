
package net.mcreator.toamod.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.world.inventory.WeaponTableGuiMenu;
import net.mcreator.toamod.procedures.WeaponTableGuiRightTakenProcedure;
import net.mcreator.toamod.procedures.WeaponTableGuiLeftTakenProcedure;
import net.mcreator.toamod.ToamodMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WeaponTableGuiSlotMessage {
	private final int slotID, x, y, z, changeType, meta;

	public WeaponTableGuiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public WeaponTableGuiSlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(WeaponTableGuiSlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(WeaponTableGuiSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

	public static void handleSlotAction(Player entity, int slotID, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = WeaponTableGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slotID == 9 && changeType == 1) {

			WeaponTableGuiLeftTakenProcedure.execute(entity);
		}
		if (slotID == 9 && changeType == 2) {
			int amount = meta;

			WeaponTableGuiLeftTakenProcedure.execute(entity);
		}
		if (slotID == 13 && changeType == 1) {

			WeaponTableGuiRightTakenProcedure.execute(entity);
		}
		if (slotID == 13 && changeType == 2) {
			int amount = meta;

			WeaponTableGuiRightTakenProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ToamodMod.addNetworkMessage(WeaponTableGuiSlotMessage.class, WeaponTableGuiSlotMessage::buffer, WeaponTableGuiSlotMessage::new,
				WeaponTableGuiSlotMessage::handler);
	}
}
