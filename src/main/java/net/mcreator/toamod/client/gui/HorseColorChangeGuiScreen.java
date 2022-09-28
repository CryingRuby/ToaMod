
package net.mcreator.toamod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.toamod.world.inventory.HorseColorChangeGuiMenu;
import net.mcreator.toamod.procedures.CheckWhiteProcedure;
import net.mcreator.toamod.procedures.CheckGrayProcedure;
import net.mcreator.toamod.procedures.CheckCreamyProcedure;
import net.mcreator.toamod.procedures.CheckChestnutProcedure;
import net.mcreator.toamod.procedures.CheckBrownProcedure;
import net.mcreator.toamod.procedures.CheckBlackProcedure;
import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.network.HorseColorChangeGuiButtonMessage;
import net.mcreator.toamod.ToamodMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class HorseColorChangeGuiScreen extends AbstractContainerScreen<HorseColorChangeGuiMenu> {
	private final static HashMap<String, Object> guistate = HorseColorChangeGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox white;
	Checkbox creamy;
	Checkbox chestnut;
	Checkbox brown;
	Checkbox black;
	Checkbox gray;
	Checkbox dark_brown;

	public HorseColorChangeGuiScreen(HorseColorChangeGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 260;
		this.imageHeight = 194;
	}

	private static final ResourceLocation texture = new ResourceLocation("toamod:textures/screens/horse_color_change_gui.png");

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
		this.font.draw(poseStack, "25k Cor", 187, 74, -10496);
		this.font.draw(poseStack, "(Your Cor: " + (int) ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).cor) + ")", 129, 177, -12829636);
		this.font.draw(poseStack, "Tick the box with the color you want", 40, 5, -16777216);
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
		white = new Checkbox(this.leftPos + 13, this.topPos + 17, 20, 20, new TextComponent("white main color"),

				CheckWhiteProcedure.execute(entity));
		guistate.put("checkbox:white", white);
		this.addRenderableWidget(white);
		creamy = new Checkbox(this.leftPos + 13, this.topPos + 40, 20, 20, new TextComponent("Creamy main color"),

				CheckCreamyProcedure.execute(entity));
		guistate.put("checkbox:creamy", creamy);
		this.addRenderableWidget(creamy);
		chestnut = new Checkbox(this.leftPos + 13, this.topPos + 63, 20, 20, new TextComponent("Chestnut main color"),

				CheckChestnutProcedure.execute(entity));
		guistate.put("checkbox:chestnut", chestnut);
		this.addRenderableWidget(chestnut);
		brown = new Checkbox(this.leftPos + 13, this.topPos + 86, 20, 20, new TextComponent("Brown main color"),

				CheckBrownProcedure.execute(entity));
		guistate.put("checkbox:brown", brown);
		this.addRenderableWidget(brown);
		black = new Checkbox(this.leftPos + 13, this.topPos + 109, 20, 20, new TextComponent("Black main color"),

				CheckBlackProcedure.execute(entity));
		guistate.put("checkbox:black", black);
		this.addRenderableWidget(black);
		gray = new Checkbox(this.leftPos + 13, this.topPos + 132, 20, 20, new TextComponent("Gray main color"),

				CheckGrayProcedure.execute(entity));
		guistate.put("checkbox:gray", gray);
		this.addRenderableWidget(gray);
		dark_brown = new Checkbox(this.leftPos + 13, this.topPos + 155, 20, 20, new TextComponent("Dark Brown main color"),

				CheckGrayProcedure.execute(entity));
		guistate.put("checkbox:dark_brown", dark_brown);
		this.addRenderableWidget(dark_brown);
		this.addRenderableWidget(new Button(this.leftPos + 187, this.topPos + 52, 35, 20, new TextComponent("Apply"), e -> {
			if (true) {
				ToamodMod.PACKET_HANDLER.sendToServer(new HorseColorChangeGuiButtonMessage(0, x, y, z));
				HorseColorChangeGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 185, this.topPos + 107, 40, 20, new TextComponent("Cancel"), e -> {
			if (true) {
				ToamodMod.PACKET_HANDLER.sendToServer(new HorseColorChangeGuiButtonMessage(1, x, y, z));
				HorseColorChangeGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
