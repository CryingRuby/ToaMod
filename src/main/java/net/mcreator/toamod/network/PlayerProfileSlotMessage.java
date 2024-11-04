
package net.mcreator.toamod.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.world.inventory.PlayerProfileMenu;
import net.mcreator.toamod.procedures.OnSkillsButtonClickedProcedure;
import net.mcreator.toamod.procedures.OnPlayerStatsButtonClickedProcedure;
import net.mcreator.toamod.procedures.OnMilestonesButtonClickedProcedure;
import net.mcreator.toamod.procedures.OnBossCollectionsButtonClickedProcedure;
import net.mcreator.toamod.procedures.OnArtefactsButtonClickedProcedure;
import net.mcreator.toamod.ToamodMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlayerProfileSlotMessage {
	private final int slotID, x, y, z, changeType, meta;

	public PlayerProfileSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public PlayerProfileSlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(PlayerProfileSlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(PlayerProfileSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = PlayerProfileMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 1) {

			OnSkillsButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 0 && changeType == 2) {
			int amount = meta;

			OnSkillsButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 1) {

			OnMilestonesButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 2) {
			int amount = meta;

			OnMilestonesButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 3 && changeType == 1) {

			OnPlayerStatsButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 3 && changeType == 2) {
			int amount = meta;

			OnPlayerStatsButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 4 && changeType == 1) {

			OnBossCollectionsButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 4 && changeType == 2) {
			int amount = meta;

			OnBossCollectionsButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 6 && changeType == 1) {

			OnArtefactsButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 6 && changeType == 2) {
			int amount = meta;

			OnArtefactsButtonClickedProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ToamodMod.addNetworkMessage(PlayerProfileSlotMessage.class, PlayerProfileSlotMessage::buffer, PlayerProfileSlotMessage::new, PlayerProfileSlotMessage::handler);
	}
}
