package net.mcreator.toamod.procedures;

import net.minecraftforge.common.MinecraftForge;

import net.mcreator.toamod.BlockResetEvent;

public class OnResetBlocksCmdProcedure {
	public static void execute() {

		BlockResetEvent blockResetEvent = new BlockResetEvent();
		System.out.println("post BlockResetEvent");

		boolean isCanceled = MinecraftForge.EVENT_BUS.post(blockResetEvent);

		if (!isCanceled) {
			//player.sendSystemMessage(net.minecraft.network.chat.Component.literal(customEvent.getMessage()));
		}
	}
}
