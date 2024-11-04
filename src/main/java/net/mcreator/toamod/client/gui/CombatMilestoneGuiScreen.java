package net.mcreator.toamod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.toamod.world.inventory.CombatMilestoneGuiMenu;
import net.mcreator.toamod.procedures.ChkMinMilestoneProgress14Procedure;
import net.mcreator.toamod.procedures.ChkMinMilestoneProgress12Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress9Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress8Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress7Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress6Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress5Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress4Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress3Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress2Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress1Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress15Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress13Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress11Procedure;
import net.mcreator.toamod.procedures.ChkComMilestoneProgress10Procedure;
import net.mcreator.toamod.procedures.CheckComMilestoneNextLvlProcedure;
import net.mcreator.toamod.procedures.CheckComMilestoneMaxLvlProcedure;
import net.mcreator.toamod.network.CombatMilestoneGuiButtonMessage;
import net.mcreator.toamod.ToamodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CombatMilestoneGuiScreen extends AbstractContainerScreen<CombatMilestoneGuiMenu> {
	private final static HashMap<String, Object> guistate = CombatMilestoneGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_claim;

	public CombatMilestoneGuiScreen(CombatMilestoneGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 212;
		this.imageHeight = 151;
	}

	private static final ResourceLocation texture = new ResourceLocation("toamod:textures/screens/combat_milestone_gui.png");

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
		if (ChkComMilestoneProgress1Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 45, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress15Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 129, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress7Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 81, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress13Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 117, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress2Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 51, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress5Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 69, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress10Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 99, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress6Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 75, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress11Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 105, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkMinMilestoneProgress12Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 111, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress9Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 93, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkMinMilestoneProgress14Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 123, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress8Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 87, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress3Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 57, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress4Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("toamod:textures/screens/progress_finished.png"), this.leftPos + 63, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.combat_milestone_gui.label_combat_milestone"), 61, 6, -3394816, false);
		if (CheckComMilestoneNextLvlProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.toamod.combat_milestone_gui.label_varintegercommilnextlvl"), 146, 34, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.combat_milestone_gui.label_varcombatmilestoneprogress"), 74, 47, -16738048, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.combat_milestone_gui.label_varintegercombatmilestonelvl"), 33, 34, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.combat_milestone_gui.label_claim_available_rewards"), 12, 119, -12829636, false);
		if (CheckComMilestoneMaxLvlProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.toamod.combat_milestone_gui.label_varintegercommilnextlvl_max"), 146, 34, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.combat_milestone_gui.label_total_mobs_killed_varinteger"), 11, 75, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_claim = Button.builder(Component.translatable("gui.toamod.combat_milestone_gui.button_claim"), e -> {
			if (true) {
				ToamodMod.PACKET_HANDLER.sendToServer(new CombatMilestoneGuiButtonMessage(0, x, y, z));
				CombatMilestoneGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 151, this.topPos + 114, 40, 20).build();
		guistate.put("button:button_claim", button_claim);
		this.addRenderableWidget(button_claim);
	}
}
