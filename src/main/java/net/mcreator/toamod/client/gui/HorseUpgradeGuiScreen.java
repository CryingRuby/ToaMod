package net.mcreator.toamod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.toamod.world.inventory.HorseUpgradeGuiMenu;
import net.mcreator.toamod.network.HorseUpgradeGuiButtonMessage;
import net.mcreator.toamod.ToamodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HorseUpgradeGuiScreen extends AbstractContainerScreen<HorseUpgradeGuiMenu> {
	private final static HashMap<String, Object> guistate = HorseUpgradeGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_change_color;
	Button button_change_pattern;

	public HorseUpgradeGuiScreen(HorseUpgradeGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 251;
		this.imageHeight = 154;
	}

	private static final ResourceLocation texture = new ResourceLocation("toamod:textures/screens/horse_upgrade_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.horse_upgrade_gui.label_upgrade_speed_0002"), 50, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.horse_upgrade_gui.label_lvl_varintegerhorselvl_v"), 50, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.horse_upgrade_gui.label_varintegerhorsemscorneededk"), 189, 43, -10496, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.horse_upgrade_gui.label_your_cor_varintegercor"), 57, 132, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.toamod.horse_upgrade_gui.button_empty"), e -> {
			if (true) {
				ToamodMod.PACKET_HANDLER.sendToServer(new HorseUpgradeGuiButtonMessage(0, x, y, z));
				HorseUpgradeGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 44, 30, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_change_color = Button.builder(Component.translatable("gui.toamod.horse_upgrade_gui.button_change_color"), e -> {
			if (true) {
				ToamodMod.PACKET_HANDLER.sendToServer(new HorseUpgradeGuiButtonMessage(1, x, y, z));
				HorseUpgradeGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 22, this.topPos + 103, 87, 20).build();
		guistate.put("button:button_change_color", button_change_color);
		this.addRenderableWidget(button_change_color);
		button_change_pattern = Button.builder(Component.translatable("gui.toamod.horse_upgrade_gui.button_change_pattern"), e -> {
			if (true) {
				ToamodMod.PACKET_HANDLER.sendToServer(new HorseUpgradeGuiButtonMessage(2, x, y, z));
				HorseUpgradeGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 130, this.topPos + 103, 98, 20).build();
		guistate.put("button:button_change_pattern", button_change_pattern);
		this.addRenderableWidget(button_change_pattern);
	}
}
