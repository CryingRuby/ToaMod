package net.mcreator.toamod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.toamod.world.inventory.ForgerGuiMenu;
import net.mcreator.toamod.procedures.GuiYourCorValueProcedure;
import net.mcreator.toamod.procedures.CheckForgerGuiRemoveRuneProcedure;
import net.mcreator.toamod.procedures.CheckForgerGuiRemoveGemstoneProcedure;
import net.mcreator.toamod.network.ForgerGuiButtonMessage;
import net.mcreator.toamod.ToamodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ForgerGuiScreen extends AbstractContainerScreen<ForgerGuiMenu> {
	private final static HashMap<String, Object> guistate = ForgerGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ssaremove_gemstonessr;
	Button button_ssaremove_runessr;

	public ForgerGuiScreen(ForgerGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 213;
		this.imageHeight = 193;
	}

	private static final ResourceLocation texture = new ResourceLocation("toamod:textures/screens/forger_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (CheckForgerGuiRemoveGemstoneProcedure.execute(world, entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.toamod.forger_gui.label_15k_cor"), 128, 81, -22016, false);
		if (CheckForgerGuiRemoveRuneProcedure.execute(world, entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.toamod.forger_gui.label_10k_cor"), 34, 81, -22016, false);
		guiGraphics.drawString(this.font,

				GuiYourCorValueProcedure.execute(entity), 45, 95, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.forger_gui.label_forger"), 85, 3, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_ssaremove_gemstonessr = Button.builder(Component.translatable("gui.toamod.forger_gui.button_ssaremove_gemstonessr"), e -> {
			if (CheckForgerGuiRemoveGemstoneProcedure.execute(world, entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new ForgerGuiButtonMessage(0, x, y, z));
				ForgerGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 100, this.topPos + 59, 98, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (CheckForgerGuiRemoveGemstoneProcedure.execute(world, entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_ssaremove_gemstonessr", button_ssaremove_gemstonessr);
		this.addRenderableWidget(button_ssaremove_gemstonessr);
		button_ssaremove_runessr = Button.builder(Component.translatable("gui.toamod.forger_gui.button_ssaremove_runessr"), e -> {
			if (CheckForgerGuiRemoveRuneProcedure.execute(world, entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new ForgerGuiButtonMessage(1, x, y, z));
				ForgerGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 15, this.topPos + 59, 72, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (CheckForgerGuiRemoveRuneProcedure.execute(world, entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_ssaremove_runessr", button_ssaremove_runessr);
		this.addRenderableWidget(button_ssaremove_runessr);
	}
}
