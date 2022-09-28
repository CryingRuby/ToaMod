
package net.mcreator.toamod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.toamod.world.inventory.ForgerGuiMenu;
import net.mcreator.toamod.procedures.CheckForgerGuiRemoveUpgStoneProcedure;
import net.mcreator.toamod.procedures.CheckForgerGuiRemoveRuneProcedure;
import net.mcreator.toamod.network.ForgerGuiButtonMessage;
import net.mcreator.toamod.ToamodMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ForgerGuiScreen extends AbstractContainerScreen<ForgerGuiMenu> {
	private final static HashMap<String, Object> guistate = ForgerGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ForgerGuiScreen(ForgerGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 213;
		this.imageHeight = 191;
	}

	private static final ResourceLocation texture = new ResourceLocation("toamod:textures/screens/forger_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 100, this.topPos + 58, 98, 20, new TextComponent("Remove Upg. Stone"), e -> {
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (CheckForgerGuiRemoveUpgStoneProcedure.execute(world, entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 15, this.topPos + 58, 72, 20, new TextComponent("Remove Rune"), e -> {
			if (CheckForgerGuiRemoveRuneProcedure.execute(world, entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new ForgerGuiButtonMessage(1, x, y, z));
				ForgerGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (CheckForgerGuiRemoveRuneProcedure.execute(world, entity))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
