
package net.mcreator.toamod.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.world.inventory.IllfangRngDropsMenuMenu;
import net.mcreator.toamod.procedures.OnUncommanRuneIllfangDropSelectedProcedure;
import net.mcreator.toamod.procedures.OnRedGoblinScaleIllfangDropSelectedProcedure;
import net.mcreator.toamod.procedures.OnRareRuneIllfangDropSelectedProcedure;
import net.mcreator.toamod.procedures.OnIllfangsCutlassIllfangDropSelectedProcedure;
import net.mcreator.toamod.procedures.OnGoblinEggSpicesIllfangDropSelectedProcedure;
import net.mcreator.toamod.procedures.OnBossKeyTier3IllfangDropProcedure;
import net.mcreator.toamod.procedures.OnBossKeyTier2IllfangDropSelectedProcedure;
import net.mcreator.toamod.procedures.OnBossKeyTier1IllfangDropSelectedProcedure;
import net.mcreator.toamod.procedures.OnBossCollectionBackButtonClickedProcedure;
import net.mcreator.toamod.ToamodMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IllfangRngDropsMenuSlotMessage {
	private final int slotID, x, y, z, changeType, meta;

	public IllfangRngDropsMenuSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public IllfangRngDropsMenuSlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(IllfangRngDropsMenuSlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(IllfangRngDropsMenuSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = IllfangRngDropsMenuMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 1) {

			OnGoblinEggSpicesIllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 0 && changeType == 2) {
			int amount = meta;

			OnGoblinEggSpicesIllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 1 && changeType == 1) {

			OnIllfangsCutlassIllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 1 && changeType == 2) {
			int amount = meta;

			OnIllfangsCutlassIllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 2 && changeType == 1) {

			OnRareRuneIllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 2 && changeType == 2) {
			int amount = meta;

			OnRareRuneIllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 3 && changeType == 1) {

			OnUncommanRuneIllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 3 && changeType == 2) {
			int amount = meta;

			OnUncommanRuneIllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 4 && changeType == 1) {

			OnRedGoblinScaleIllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 4 && changeType == 2) {
			int amount = meta;

			OnRedGoblinScaleIllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 5 && changeType == 1) {

			OnBossKeyTier3IllfangDropProcedure.execute(entity);
		}
		if (slot == 5 && changeType == 2) {
			int amount = meta;

			OnBossKeyTier3IllfangDropProcedure.execute(entity);
		}
		if (slot == 6 && changeType == 1) {

			OnBossKeyTier2IllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 6 && changeType == 2) {
			int amount = meta;

			OnBossKeyTier2IllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 7 && changeType == 1) {

			OnBossKeyTier1IllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 7 && changeType == 2) {
			int amount = meta;

			OnBossKeyTier1IllfangDropSelectedProcedure.execute(entity);
		}
		if (slot == 8 && changeType == 1) {

			OnBossCollectionBackButtonClickedProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 8 && changeType == 2) {
			int amount = meta;

			OnBossCollectionBackButtonClickedProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ToamodMod.addNetworkMessage(IllfangRngDropsMenuSlotMessage.class, IllfangRngDropsMenuSlotMessage::buffer, IllfangRngDropsMenuSlotMessage::new, IllfangRngDropsMenuSlotMessage::handler);
	}
}
