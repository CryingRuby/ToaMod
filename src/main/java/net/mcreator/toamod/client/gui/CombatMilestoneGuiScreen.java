
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
import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.network.CombatMilestoneGuiButtonMessage;
import net.mcreator.toamod.ToamodMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CombatMilestoneGuiScreen extends AbstractContainerScreen<CombatMilestoneGuiMenu> {
	private final static HashMap<String, Object> guistate = CombatMilestoneGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

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
		if (ChkComMilestoneProgress1Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 45, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress15Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 129, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress7Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 81, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress13Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 117, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress2Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 51, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress5Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 69, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress10Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 99, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress6Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 75, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress11Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkMinMilestoneProgress12Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 111, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress9Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 93, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkMinMilestoneProgress14Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 123, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress8Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 87, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress3Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 57, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (ChkComMilestoneProgress4Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/screens/progress_finished.png"));
			this.blit(ms, this.leftPos + 63, this.topPos + 30, 0, 0, 16, 16, 16, 16);
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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Combat Milestone", 61, 6, -3394816);
		if (CheckComMilestoneNextLvlProcedure.execute(entity))
			this.font.draw(poseStack, "" + (int) ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).comMilNextLvl) + "", 146, 34, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneProgress) + " %", 74, 47, -16738048);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl) + "", 33, 34, -12829636);
		this.font.draw(poseStack, "Claim available rewards:", 12, 119, -12829636);
		if (CheckComMilestoneMaxLvlProcedure.execute(entity))
			this.font.draw(poseStack, "" + (int) ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).comMilNextLvl) + " (max)", 146, 34, -12829636);
		this.font.draw(poseStack,
				"Total mobs killed: "
						+ (int) ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).totalMobsKilled)
						+ " / " + (int) ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneKillsNeeded)
						+ "",
				11, 75, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 151, this.topPos + 114, 40, 20, new TextComponent("Claim"), e -> {
			if (true) {
				ToamodMod.PACKET_HANDLER.sendToServer(new CombatMilestoneGuiButtonMessage(0, x, y, z));
				CombatMilestoneGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
