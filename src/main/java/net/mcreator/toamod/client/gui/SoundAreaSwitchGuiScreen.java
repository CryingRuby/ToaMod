
package net.mcreator.toamod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;

import net.mcreator.toamod.world.inventory.SoundAreaSwitchGuiMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class SoundAreaSwitchGuiScreen extends AbstractContainerScreen<SoundAreaSwitchGuiMenu> {
	private final static HashMap<String, Object> guistate = SoundAreaSwitchGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox entranceTo;
	EditBox backTo;

	public SoundAreaSwitchGuiScreen(SoundAreaSwitchGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("toamod:textures/screens/sound_area_switch_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		entranceTo.render(ms, mouseX, mouseY, partialTicks);
		backTo.render(ms, mouseX, mouseY, partialTicks);
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
		if (entranceTo.isFocused())
			return entranceTo.keyPressed(key, b, c);
		if (backTo.isFocused())
			return backTo.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		entranceTo.tick();
		backTo.tick();
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
		entranceTo = new EditBox(this.font, this.leftPos + 30, this.topPos + 37, 120, 20, new TextComponent("GoToArea")) {
			{
				setSuggestion("GoToArea");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("GoToArea");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("GoToArea");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:entranceTo", entranceTo);
		entranceTo.setMaxLength(32767);
		this.addWidget(this.entranceTo);
		backTo = new EditBox(this.font, this.leftPos + 31, this.topPos + 89, 120, 20, new TextComponent("AreaCameFrom")) {
			{
				setSuggestion("AreaCameFrom");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("AreaCameFrom");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("AreaCameFrom");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:backTo", backTo);
		backTo.setMaxLength(32767);
		this.addWidget(this.backTo);
	}
}
