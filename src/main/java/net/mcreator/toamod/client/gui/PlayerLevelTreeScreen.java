
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

import net.mcreator.toamod.world.inventory.PlayerLevelTreeMenu;
import net.mcreator.toamod.procedures.SkillTreeBtn9ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn8ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn7ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn6ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn5ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn4ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn3ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn2ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn24ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn23ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn22ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn21ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn20ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn1ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn19ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn18ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn17ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn16ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn15ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn14ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn13ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn12ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn11ConditionProcedure;
import net.mcreator.toamod.procedures.SkillTreeBtn10ConditionProcedure;
import net.mcreator.toamod.network.PlayerLevelTreeButtonMessage;
import net.mcreator.toamod.ToamodMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PlayerLevelTreeScreen extends AbstractContainerScreen<PlayerLevelTreeMenu> {
	private final static HashMap<String, Object> guistate = PlayerLevelTreeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PlayerLevelTreeScreen(PlayerLevelTreeMenu container, Inventory inventory, Component text) {
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
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 222, this.topPos + 109, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 175, this.topPos + 109, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 133, this.topPos + 123, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 133, this.topPos + 135, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 133, this.topPos + 93, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 133, this.topPos + 39, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 140, this.topPos + 34, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 127, this.topPos + 34, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 66, this.topPos + 34, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 102, this.topPos + 108, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 69, this.topPos + 92, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 104, this.topPos + 66, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 133, this.topPos + 147, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 133, this.topPos + 159, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 133, this.topPos + 167, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 65, this.topPos + 143, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 65, this.topPos + 173, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 59, this.topPos + 148, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 59, this.topPos + 167, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 59, this.topPos + 157, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 264, this.topPos + 94, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 296, this.topPos + 141, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 308, this.topPos + 141, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 314, this.topPos + 141, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 320, this.topPos + 146, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 234, this.topPos + 141, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 222, this.topPos + 141, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 215, this.topPos + 146, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 336, this.topPos + 156, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 343, this.topPos + 151, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 355, this.topPos + 151, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 367, this.topPos + 151, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 384, this.topPos + 157, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 234, this.topPos + 72, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 264, this.topPos + 56, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 296, this.topPos + 32, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 339, this.topPos + 47, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 379, this.topPos + 151, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_req_up.png"));
		this.blit(ms, this.leftPos + 349, this.topPos + 114, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_req_down.png"));
		this.blit(ms, this.leftPos + 339, this.topPos + 82, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_req_right.png"));
		this.blit(ms, this.leftPos + 157, this.topPos + 201, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_req_up.png"));
		this.blit(ms, this.leftPos + 69, this.topPos + 81, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_req_left.png"));
		this.blit(ms, this.leftPos + 102, this.topPos + 66, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_right.png"));
		this.blit(ms, this.leftPos + 233, this.topPos + 109, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_left.png"));
		this.blit(ms, this.leftPos + 164, this.topPos + 109, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_up.png"));
		this.blit(ms, this.leftPos + 133, this.topPos + 82, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_left.png"));
		this.blit(ms, this.leftPos + 124, this.topPos + 34, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_right.png"));
		this.blit(ms, this.leftPos + 152, this.topPos + 34, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 147, this.topPos + 34, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_left.png"));
		this.blit(ms, this.leftPos + 61, this.topPos + 34, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_left.png"));
		this.blit(ms, this.leftPos + 93, this.topPos + 108, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_left.png"));
		this.blit(ms, this.leftPos + 127, this.topPos + 173, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 128, this.topPos + 173, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_left.png"));
		this.blit(ms, this.leftPos + 127, this.topPos + 143, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_up.png"));
		this.blit(ms, this.leftPos + 190, this.topPos + 156, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_down.png"));
		this.blit(ms, this.leftPos + 215, this.topPos + 155, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_down.png"));
		this.blit(ms, this.leftPos + 264, this.topPos + 125, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_down.png"));
		this.blit(ms, this.leftPos + 264, this.topPos + 155, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_down.png"));
		this.blit(ms, this.leftPos + 320, this.topPos + 155, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_right.png"));
		this.blit(ms, this.leftPos + 359, this.topPos + 171, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_right.png"));
		this.blit(ms, this.leftPos + 308, this.topPos + 32, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 301, this.topPos + 32, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_down.png"));
		this.blit(ms, this.leftPos + 339, this.topPos + 50, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_up.png"));
		this.blit(ms, this.leftPos + 264, this.topPos + 48, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_up.png"));
		this.blit(ms, this.leftPos + 264, this.topPos + 88, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_arrow_left.png"));
		this.blit(ms, this.leftPos + 226, this.topPos + 72, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_req_left.png"));
		this.blit(ms, this.leftPos + 54, this.topPos + 158, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_req_up.png"));
		this.blit(ms, this.leftPos + 359, this.topPos + 145, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_vertical.png"));
		this.blit(ms, this.leftPos + 133, this.topPos + 51, 0, 0, 12, 12, 12, 12);

		RenderSystem.setShaderTexture(0, new ResourceLocation("toamod:textures/symbol_line_horizontal.png"));
		this.blit(ms, this.leftPos + 356, this.topPos + 171, 0, 0, 12, 12, 12, 12);

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
		this.font.draw(poseStack, "Start", 191, 109, -13261);
		this.font.draw(poseStack, "Offense", 384, 109, -65485);
		this.font.draw(poseStack, "Defense", 6, 109, -16724992);
		this.font.draw(poseStack, "+1 HP", 22, 35, -16724992);
		this.font.draw(poseStack, "+1 HP", 176, 35, -16724992);
		this.font.draw(poseStack, "+1 HP", 63, 66, -16724992);
		this.font.draw(poseStack, "+1 HP", 125, 109, -16724992);
		this.font.draw(poseStack, "+1 HP", 88, 144, -16724992);
		this.font.draw(poseStack, "+2% DR", 124, 67, -13408513);
		this.font.draw(poseStack, "+2% DR", 58, 109, -13408513);
		this.font.draw(poseStack, "+3% DR", 86, 35, -13408513);
		this.font.draw(poseStack, "CR = Crit Rate", 307, 225, -6710887);
		this.font.draw(poseStack, "CD = Crit Damage", 307, 213, -6710887);
		this.font.draw(poseStack, "+3% DR", 86, 173, -13408513);
		this.font.draw(poseStack, "+5% DR", 16, 159, -13408513);
		this.font.draw(poseStack, "+2% CR", 255, 110, -6750208);
		this.font.draw(poseStack, "+2% CR", 185, 73, -6750208);
		this.font.draw(poseStack, "+5% CD", 255, 73, -3586276);
		this.font.draw(poseStack, "+5% AP", 255, 33, -6750055);
		this.font.draw(poseStack, "+4% CR", 330, 33, -6750208);
		this.font.draw(poseStack, "+15% CD", 327, 67, -3914980);
		this.font.draw(poseStack, "+10% CR", 330, 99, -6750208);
		this.font.draw(poseStack, "+2% CR", 255, 142, -6750208);
		this.font.draw(poseStack, "+15% CD", 345, 130, -3914980);
		this.font.draw(poseStack, "+5% CR", 381, 172, -6750208);
		this.font.draw(poseStack, "+3% AP", 315, 172, -6750055);
		this.font.draw(poseStack, "+5% CR", 255, 172, -6750208);
		this.font.draw(poseStack, "+10% CD", 191, 172, -3914980);
		this.font.draw(poseStack, "+7% AP", 173, 141, -6750055);
		this.font.draw(poseStack, "AP = Ability Power", 308, 202, -6710887);
		this.font.draw(poseStack, "= Requires Mutiple", 174, 202, -6710887);
		this.font.draw(poseStack, "DR = Damage Reduction", 3, 225, -6710887);
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
		this.addRenderableWidget(new Button(this.leftPos + 245, this.topPos + 105, 51, 20, new TextComponent("+2% CR"), e -> {
			if (SkillTreeBtn11ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(0, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn11ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 113, this.topPos + 104, 51, 20, new TextComponent("+1 HP"), e -> {
			if (SkillTreeBtn1ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(1, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn1ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 76, this.topPos + 139, 51, 20, new TextComponent("+1 HP"), e -> {
			if (SkillTreeBtn2ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(2, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn2ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 51, this.topPos + 61, 51, 20, new TextComponent("+1 HP"), e -> {
			if (SkillTreeBtn7ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(3, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn7ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 30, 51, 20, new TextComponent("+1 HP"), e -> {
			if (SkillTreeBtn10ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(4, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn10ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 164, this.topPos + 30, 51, 20, new TextComponent("+1 HP"), e -> {
			if (SkillTreeBtn8ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(5, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn8ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 245, this.topPos + 137, 51, 20, new TextComponent("+2% CR"), e -> {
			if (SkillTreeBtn12ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(6, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn12ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 320, this.topPos + 28, 51, 20, new TextComponent("+4% CR"), e -> {
			if (SkillTreeBtn22ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(7, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn22ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 175, this.topPos + 68, 51, 20, new TextComponent("+2% CR"), e -> {
			if (SkillTreeBtn20ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(8, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn20ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 371, this.topPos + 167, 51, 20, new TextComponent("+5% CR"), e -> {
			if (SkillTreeBtn17ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(9, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn17ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 245, this.topPos + 167, 51, 20, new TextComponent("+5% CR"), e -> {
			if (SkillTreeBtn15ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(10, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn15ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 323, this.topPos + 94, 51, 20, new TextComponent("+10% CR"), e -> {
			if (SkillTreeBtn24ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(11, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn24ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 245, this.topPos + 68, 51, 20, new TextComponent("+5% CD"), e -> {
			if (SkillTreeBtn19ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(12, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn19ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 184, this.topPos + 167, 51, 20, new TextComponent("+10% CD"), e -> {
			if (SkillTreeBtn13ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(13, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn13ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 338, this.topPos + 125, 51, 20, new TextComponent("+15% CD"), e -> {
			if (SkillTreeBtn18ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(14, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 14, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn18ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 320, this.topPos + 62, 51, 20, new TextComponent("+15% CD"), e -> {
			if (SkillTreeBtn23ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(15, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn23ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 305, this.topPos + 167, 51, 20, new TextComponent("+3% AP"), e -> {
			if (SkillTreeBtn16ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(16, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn16ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 163, this.topPos + 136, 51, 20, new TextComponent("+7% AP"), e -> {
			if (SkillTreeBtn14ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(17, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn14ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 245, this.topPos + 28, 51, 20, new TextComponent("+5% AP"), e -> {
			if (SkillTreeBtn21ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(18, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn21ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 53, this.topPos + 104, 40, 20, new TextComponent("+2% DR"), e -> {
			if (SkillTreeBtn5ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(19, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 19, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn5ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 76, this.topPos + 168, 51, 20, new TextComponent("+3% DR"), e -> {
			if (SkillTreeBtn3ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(20, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 20, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn3ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 116, this.topPos + 62, 46, 20, new TextComponent("+2% DR"), e -> {
			if (SkillTreeBtn6ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(21, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 21, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn6ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 78, this.topPos + 30, 46, 20, new TextComponent("+3% DR"), e -> {
			if (SkillTreeBtn9ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(22, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 22, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn9ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 8, this.topPos + 154, 46, 20, new TextComponent("+5% DR"), e -> {
			if (SkillTreeBtn4ConditionProcedure.execute(entity)) {
				ToamodMod.PACKET_HANDLER.sendToServer(new PlayerLevelTreeButtonMessage(23, x, y, z));
				PlayerLevelTreeButtonMessage.handleButtonAction(entity, 23, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SkillTreeBtn4ConditionProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
