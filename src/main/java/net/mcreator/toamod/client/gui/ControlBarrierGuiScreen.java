
package net.mcreator.toamod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.toamod.world.inventory.ControlBarrierGuiMenu;
import net.mcreator.toamod.procedures.ControlbarrierAtSkillProcedure;
import net.mcreator.toamod.procedures.ControlBarrierChkPlaLvlProcedure;
import net.mcreator.toamod.procedures.ControlBarrierChkMaSkillProcedure;
import net.mcreator.toamod.procedures.ControlBarrierChkDeSkillProcedure;
import net.mcreator.toamod.procedures.ControlBarrierChkBoDefProcedure;
import net.mcreator.toamod.network.ControlBarrierGuiButtonMessage;
import net.mcreator.toamod.ToamodMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ControlBarrierGuiScreen extends AbstractContainerScreen<ControlBarrierGuiMenu> {
	private final static HashMap<String, Object> guistate = ControlBarrierGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox chkBossesDef;
	EditBox inputBossesDef;
	Checkbox chkAttackSkill;
	Checkbox chkDefenseSkill;
	Checkbox chkMagicSkill;
	EditBox inputAttackSLvl;
	EditBox inputDefenseSLvl;
	EditBox inputMagicSLvl;
	Checkbox chkPlayerLvl;
	EditBox inputPlayerLvl;

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
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		inputBossesDef.render(ms, mouseX, mouseY, partialTicks);
		inputAttackSLvl.render(ms, mouseX, mouseY, partialTicks);
		inputDefenseSLvl.render(ms, mouseX, mouseY, partialTicks);
		inputMagicSLvl.render(ms, mouseX, mouseY, partialTicks);
		inputPlayerLvl.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
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
		chkBossesDef = new Checkbox(this.leftPos + 99, this.topPos + 48, 150, 20, new TextComponent("Bound to Bosses defeated"),

				ControlBarrierChkBoDefProcedure.execute(world, x, y, z));
		guistate.put("checkbox:chkBossesDef", chkBossesDef);
		this.addRenderableWidget(chkBossesDef);
		inputBossesDef = new EditBox(this.font, this.leftPos + 277, this.topPos + 48, 30, 20, new TextComponent("1")) {
			{
				setSuggestion("1");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:inputBossesDef", inputBossesDef);
		inputBossesDef.setMaxLength(32767);
		this.addWidget(this.inputBossesDef);
		chkAttackSkill = new Checkbox(this.leftPos + 99, this.topPos + 110, 150, 20, new TextComponent("Bound to Attack-Skill"),

				ControlbarrierAtSkillProcedure.execute(world, x, y, z));
		guistate.put("checkbox:chkAttackSkill", chkAttackSkill);
		this.addRenderableWidget(chkAttackSkill);
		chkDefenseSkill = new Checkbox(this.leftPos + 99, this.topPos + 141, 150, 20, new TextComponent("Bound to Defense-Skill"),

				ControlBarrierChkDeSkillProcedure.execute(world, x, y, z));
		guistate.put("checkbox:chkDefenseSkill", chkDefenseSkill);
		this.addRenderableWidget(chkDefenseSkill);
		chkMagicSkill = new Checkbox(this.leftPos + 99, this.topPos + 171, 150, 20, new TextComponent("Bound to Magic-Skill"),

				ControlBarrierChkMaSkillProcedure.execute(world, x, y, z));
		guistate.put("checkbox:chkMagicSkill", chkMagicSkill);
		this.addRenderableWidget(chkMagicSkill);
		inputAttackSLvl = new EditBox(this.font, this.leftPos + 277, this.topPos + 110, 30, 20, new TextComponent("1")) {
			{
				setSuggestion("1");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:inputAttackSLvl", inputAttackSLvl);
		inputAttackSLvl.setMaxLength(32767);
		this.addWidget(this.inputAttackSLvl);
		inputDefenseSLvl = new EditBox(this.font, this.leftPos + 277, this.topPos + 141, 30, 20, new TextComponent("1")) {
			{
				setSuggestion("1");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:inputDefenseSLvl", inputDefenseSLvl);
		inputDefenseSLvl.setMaxLength(32767);
		this.addWidget(this.inputDefenseSLvl);
		inputMagicSLvl = new EditBox(this.font, this.leftPos + 277, this.topPos + 171, 30, 20, new TextComponent("1")) {
			{
				setSuggestion("1");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:inputMagicSLvl", inputMagicSLvl);
		inputMagicSLvl.setMaxLength(32767);
		this.addWidget(this.inputMagicSLvl);
		chkPlayerLvl = new Checkbox(this.leftPos + 99, this.topPos + 79, 150, 20, new TextComponent("Bound to Player Level"),

				ControlBarrierChkPlaLvlProcedure.execute(world, x, y, z));
		guistate.put("checkbox:chkPlayerLvl", chkPlayerLvl);
		this.addRenderableWidget(chkPlayerLvl);
		inputPlayerLvl = new EditBox(this.font, this.leftPos + 277, this.topPos + 79, 29, 20, new TextComponent("1")) {
			{
				setSuggestion("1");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("1");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:inputPlayerLvl", inputPlayerLvl);
		inputPlayerLvl.setMaxLength(32767);
		this.addWidget(this.inputPlayerLvl);
		this.addRenderableWidget(new Button(this.leftPos + 335, this.topPos + 191, 61, 20, new TextComponent("Confirm"), e -> {
			if (true) {
				ToamodMod.PACKET_HANDLER.sendToServer(new ControlBarrierGuiButtonMessage(0, x, y, z));
				ControlBarrierGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
