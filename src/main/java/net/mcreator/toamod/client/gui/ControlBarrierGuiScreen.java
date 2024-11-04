package net.mcreator.toamod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.toamod.world.inventory.ControlBarrierGuiMenu;
import net.mcreator.toamod.network.ControlBarrierGuiButtonMessage;
import net.mcreator.toamod.ToamodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ControlBarrierGuiScreen extends AbstractContainerScreen<ControlBarrierGuiMenu> {
	private final static HashMap<String, Object> guistate = ControlBarrierGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox inputBossesDef;
	EditBox inputAttackSLvl;
	EditBox inputDefenseSLvl;
	EditBox inputMagicSLvl;
	EditBox inputPlayerLvl;
	Button button_confirm;

	public ControlBarrierGuiScreen(ControlBarrierGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 425;
		this.imageHeight = 238;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		inputBossesDef.render(guiGraphics, mouseX, mouseY, partialTicks);
		inputAttackSLvl.render(guiGraphics, mouseX, mouseY, partialTicks);
		inputDefenseSLvl.render(guiGraphics, mouseX, mouseY, partialTicks);
		inputMagicSLvl.render(guiGraphics, mouseX, mouseY, partialTicks);
		inputPlayerLvl.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (inputBossesDef.isFocused())
			return inputBossesDef.keyPressed(key, b, c);
		if (inputAttackSLvl.isFocused())
			return inputAttackSLvl.keyPressed(key, b, c);
		if (inputDefenseSLvl.isFocused())
			return inputDefenseSLvl.keyPressed(key, b, c);
		if (inputMagicSLvl.isFocused())
			return inputMagicSLvl.keyPressed(key, b, c);
		if (inputPlayerLvl.isFocused())
			return inputPlayerLvl.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		inputBossesDef.tick();
		inputAttackSLvl.tick();
		inputDefenseSLvl.tick();
		inputMagicSLvl.tick();
		inputPlayerLvl.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String inputBossesDefValue = inputBossesDef.getValue();
		String inputAttackSLvlValue = inputAttackSLvl.getValue();
		String inputDefenseSLvlValue = inputDefenseSLvl.getValue();
		String inputMagicSLvlValue = inputMagicSLvl.getValue();
		String inputPlayerLvlValue = inputPlayerLvl.getValue();
		super.resize(minecraft, width, height);
		inputBossesDef.setValue(inputBossesDefValue);
		inputAttackSLvl.setValue(inputAttackSLvlValue);
		inputDefenseSLvl.setValue(inputDefenseSLvlValue);
		inputMagicSLvl.setValue(inputMagicSLvlValue);
		inputPlayerLvl.setValue(inputPlayerLvlValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.control_barrier_gui.label_required_bosses_defeated"), 140, 52, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.control_barrier_gui.label_required_player_level"), 156, 84, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.control_barrier_gui.label_required_attackskill_level"), 124, 116, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.control_barrier_gui.label_required_defenseskill_level"), 119, 146, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.control_barrier_gui.label_required_magicskill_level"), 130, 176, -1, false);
	}

	@Override
	public void init() {
		super.init();
		inputBossesDef = new EditBox(this.font, this.leftPos + 278, this.topPos + 49, 28, 18, Component.translatable("gui.toamod.control_barrier_gui.inputBossesDef")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputBossesDef").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputBossesDef").getString());
				else
					setSuggestion(null);
			}
		};
		inputBossesDef.setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputBossesDef").getString());
		inputBossesDef.setMaxLength(32767);
		guistate.put("text:inputBossesDef", inputBossesDef);
		this.addWidget(this.inputBossesDef);
		inputAttackSLvl = new EditBox(this.font, this.leftPos + 278, this.topPos + 111, 28, 18, Component.translatable("gui.toamod.control_barrier_gui.inputAttackSLvl")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputAttackSLvl").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputAttackSLvl").getString());
				else
					setSuggestion(null);
			}
		};
		inputAttackSLvl.setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputAttackSLvl").getString());
		inputAttackSLvl.setMaxLength(32767);
		guistate.put("text:inputAttackSLvl", inputAttackSLvl);
		this.addWidget(this.inputAttackSLvl);
		inputDefenseSLvl = new EditBox(this.font, this.leftPos + 278, this.topPos + 142, 28, 18, Component.translatable("gui.toamod.control_barrier_gui.inputDefenseSLvl")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputDefenseSLvl").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputDefenseSLvl").getString());
				else
					setSuggestion(null);
			}
		};
		inputDefenseSLvl.setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputDefenseSLvl").getString());
		inputDefenseSLvl.setMaxLength(32767);
		guistate.put("text:inputDefenseSLvl", inputDefenseSLvl);
		this.addWidget(this.inputDefenseSLvl);
		inputMagicSLvl = new EditBox(this.font, this.leftPos + 278, this.topPos + 172, 28, 18, Component.translatable("gui.toamod.control_barrier_gui.inputMagicSLvl")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputMagicSLvl").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputMagicSLvl").getString());
				else
					setSuggestion(null);
			}
		};
		inputMagicSLvl.setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputMagicSLvl").getString());
		inputMagicSLvl.setMaxLength(32767);
		guistate.put("text:inputMagicSLvl", inputMagicSLvl);
		this.addWidget(this.inputMagicSLvl);
		inputPlayerLvl = new EditBox(this.font, this.leftPos + 278, this.topPos + 80, 27, 18, Component.translatable("gui.toamod.control_barrier_gui.inputPlayerLvl")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputPlayerLvl").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputPlayerLvl").getString());
				else
					setSuggestion(null);
			}
		};
		inputPlayerLvl.setSuggestion(Component.translatable("gui.toamod.control_barrier_gui.inputPlayerLvl").getString());
		inputPlayerLvl.setMaxLength(32767);
		guistate.put("text:inputPlayerLvl", inputPlayerLvl);
		this.addWidget(this.inputPlayerLvl);
		button_confirm = Button.builder(Component.translatable("gui.toamod.control_barrier_gui.button_confirm"), e -> {
			if (true) {
				ToamodMod.PACKET_HANDLER.sendToServer(new ControlBarrierGuiButtonMessage(0, x, y, z));
				ControlBarrierGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 335, this.topPos + 191, 61, 20).build();
		guistate.put("button:button_confirm", button_confirm);
		this.addRenderableWidget(button_confirm);
	}
}
