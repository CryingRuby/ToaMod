
package net.mcreator.toamod.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.world.inventory.PlayerLevelTreeMenu;
import net.mcreator.toamod.procedures.SkillTreeBtn9PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn8PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn7PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn6PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn5PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn4PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn3PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn2PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn24PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn23PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn22PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn21PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn20PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn1PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn19PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn18PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn17PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn16PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn15PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn14PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn13PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn12PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn11PressedProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn10PressedProcedure;
import net.mcreator.toamod.ToamodMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlayerLevelTreeButtonMessage {
	private final int buttonID, x, y, z;

	public PlayerLevelTreeButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PlayerLevelTreeButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PlayerLevelTreeButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PlayerLevelTreeButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = PlayerLevelTreeMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SkillTreeBtn11PressedProcedure.execute(entity);
		}
		if (buttonID == 1) {

			SkillTreeBtn1PressedProcedure.execute(entity);
		}
		if (buttonID == 2) {

			SkillTreeBtn2PressedProcedure.execute(entity);
		}
		if (buttonID == 3) {

			SkillTreeBtn7PressedProcedure.execute(entity);
		}
		if (buttonID == 4) {

			SkillTreeBtn10PressedProcedure.execute(entity);
		}
		if (buttonID == 5) {

			SkillTreeBtn8PressedProcedure.execute(entity);
		}
		if (buttonID == 6) {

			SkillTreeBtn12PressedProcedure.execute(entity);
		}
		if (buttonID == 7) {

			SkillTreeBtn22PressedProcedure.execute(entity);
		}
		if (buttonID == 8) {

			SkillTreeBtn20PressedProcedure.execute(entity);
		}
		if (buttonID == 9) {

			SkillTreeBtn17PressedProcedure.execute(entity);
		}
		if (buttonID == 10) {

			SkillTreeBtn15PressedProcedure.execute(entity);
		}
		if (buttonID == 11) {

			SkillTreeBtn24PressedProcedure.execute(entity);
		}
		if (buttonID == 12) {

			SkillTreeBtn19PressedProcedure.execute(entity);
		}
		if (buttonID == 13) {

			SkillTreeBtn13PressedProcedure.execute(entity);
		}
		if (buttonID == 14) {

			SkillTreeBtn18PressedProcedure.execute(entity);
		}
		if (buttonID == 15) {

			SkillTreeBtn23PressedProcedure.execute(entity);
		}
		if (buttonID == 16) {

			SkillTreeBtn16PressedProcedure.execute(entity);
		}
		if (buttonID == 17) {

			SkillTreeBtn14PressedProcedure.execute(entity);
		}
		if (buttonID == 18) {

			SkillTreeBtn21PressedProcedure.execute(entity);
		}
		if (buttonID == 19) {

			SkillTreeBtn5PressedProcedure.execute(entity);
		}
		if (buttonID == 20) {

			SkillTreeBtn3PressedProcedure.execute(entity);
		}
		if (buttonID == 21) {

			SkillTreeBtn6PressedProcedure.execute(entity);
		}
		if (buttonID == 22) {

			SkillTreeBtn9PressedProcedure.execute(entity);
		}
		if (buttonID == 23) {

			SkillTreeBtn4PressedProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ToamodMod.addNetworkMessage(PlayerLevelTreeButtonMessage.class, PlayerLevelTreeButtonMessage::buffer, PlayerLevelTreeButtonMessage::new,
				PlayerLevelTreeButtonMessage::handler);
	}
}
