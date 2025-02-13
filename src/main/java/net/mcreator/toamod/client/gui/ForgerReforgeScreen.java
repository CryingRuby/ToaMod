package net.mcreator.toamod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.toamod.world.inventory.ForgerReforgeMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ForgerReforgeScreen extends AbstractContainerScreen<ForgerReforgeMenu> {
	private final static HashMap<String, Object> guistate = ForgerReforgeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final int sizeReforges;

	public ForgerReforgeScreen(ForgerReforgeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
		this.sizeReforges = container.getSizeReforges();
	}

	private static final ResourceLocation texture = new ResourceLocation("toamod:textures/screens/forger_reforge.png");

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
		System.out.println("	Screen - sizeReforges: "+sizeReforges);
		outer : 
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 4; j++){
				if(i*4+j+1 > sizeReforges) {
					break outer;
				} 
				guiGraphics.blit(new ResourceLocation("toamod:textures/screens/slot.png"), this.leftPos + 88 + 18 * j, this.topPos + 18 + 18 * i, 0, 0, 18, 18, 18, 18);
			}
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
	}

	@Override
	public void init() {
		super.init();
	}
}
