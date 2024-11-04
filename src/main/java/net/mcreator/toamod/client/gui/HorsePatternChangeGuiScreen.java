package net.mcreator.toamod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.toamod.world.inventory.HorsePatternChangeGuiMenu;
import net.mcreator.toamod.procedures.CheckWhiteStonkingsProcedure;
import net.mcreator.toamod.procedures.CheckWhiteFieldProcedure;
import net.mcreator.toamod.procedures.CheckWhiteDotsProcedure;
import net.mcreator.toamod.procedures.CheckNonePatternProcedure;
import net.mcreator.toamod.procedures.CheckBlackDotsProcedure;
import net.mcreator.toamod.network.HorsePatternChangeGuiButtonMessage;
import net.mcreator.toamod.ToamodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HorsePatternChangeGuiScreen extends AbstractContainerScreen<HorsePatternChangeGuiMenu> {
	private final static HashMap<String, Object> guistate = HorsePatternChangeGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox white_stonkings;
	Checkbox white_field;
	Checkbox white_dots;
	Checkbox black_dots;
	Checkbox none;
	Button button_cancel;
	Button button_apply;

	public HorsePatternChangeGuiScreen(HorsePatternChangeGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 224;
		this.imageHeight = 156;
	}

	private static final ResourceLocation texture = new ResourceLocation("toamod:textures/screens/horse_pattern_change_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.horse_pattern_change_gui.label_choose_a_pattern_and_press_apply"), 27, 6, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.toamod.horse_pattern_change_gui.label_15k_cor"), 154, 63, -10496, false);
	}

	@Override
	public void init() {
		super.init();
		button_cancel = Button.builder(Component.translatable("gui.toamod.horse_pattern_change_gui.button_cancel"), e -> {
			if (true) {
				ToamodMod.PACKET_HANDLER.sendToServer(new HorsePatternChangeGuiButtonMessage(0, x, y, z));
				HorsePatternChangeGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 152, this.topPos + 99, 40, 20).build();
		guistate.put("button:button_cancel", button_cancel);
		this.addRenderableWidget(button_cancel);
		button_apply = Button.builder(Component.translatable("gui.toamod.horse_pattern_change_gui.button_apply"), e -> {
			if (true) {
				ToamodMod.PACKET_HANDLER.sendToServer(new HorsePatternChangeGuiButtonMessage(1, x, y, z));
				HorsePatternChangeGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 154, this.topPos + 42, 35, 20).build();
		guistate.put("button:button_apply", button_apply);
		this.addRenderableWidget(button_apply);
		white_stonkings = new Checkbox(this.leftPos + 9, this.topPos + 47, 20, 20, Component.translatable("gui.toamod.horse_pattern_change_gui.white_stonkings"),

				CheckWhiteStonkingsProcedure.execute(entity));
		guistate.put("checkbox:white_stonkings", white_stonkings);
		this.addRenderableWidget(white_stonkings);
		white_field = new Checkbox(this.leftPos + 9, this.topPos + 74, 20, 20, Component.translatable("gui.toamod.horse_pattern_change_gui.white_field"),

				CheckWhiteFieldProcedure.execute(entity));
		guistate.put("checkbox:white_field", white_field);
		this.addRenderableWidget(white_field);
		white_dots = new Checkbox(this.leftPos + 9, this.topPos + 100, 20, 20, Component.translatable("gui.toamod.horse_pattern_change_gui.white_dots"),

				CheckWhiteDotsProcedure.execute(entity));
		guistate.put("checkbox:white_dots", white_dots);
		this.addRenderableWidget(white_dots);
		black_dots = new Checkbox(this.leftPos + 9, this.topPos + 126, 20, 20, Component.translatable("gui.toamod.horse_pattern_change_gui.black_dots"),

				CheckBlackDotsProcedure.execute(entity));
		guistate.put("checkbox:black_dots", black_dots);
		this.addRenderableWidget(black_dots);
		none = new Checkbox(this.leftPos + 9, this.topPos + 20, 20, 20, Component.translatable("gui.toamod.horse_pattern_change_gui.none"),

				CheckNonePatternProcedure.execute(entity));
		guistate.put("checkbox:none", none);
		this.addRenderableWidget(none);
	}
}
