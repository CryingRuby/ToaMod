
package net.mcreator.toamod;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.Util;
import net.minecraft.ChatFormatting;

import com.mojang.blaze3d.systems.RenderSystem;

public abstract class ToaAbstractContainerScreen<T extends AbstractContainerMenu> extends AbstractContainerScreen<T> {
	protected final int nonHighlightedSlot; //All Slots except the last one won't be highlighted

	public ToaAbstractContainerScreen(T menu, Inventory inv, Component title, int nonHighlightedSlot) {
		super(menu, inv, title);
		this.nonHighlightedSlot = nonHighlightedSlot;
	}

	//Ansatz um die SlotHighlights beim hovern nicht zu rendern 
	
/*
	@Override
	public void render(GuiGraphics p_283479_, int p_283661_, int p_281248_, float p_281886_) {
		int i = super.leftPos;
		int j = super.topPos;
		super.renderBg(p_283479_, p_281886_, p_283661_, p_281248_);
		net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.ContainerScreenEvent.Render.Background(this, p_283479_, p_283661_, p_281248_));
		RenderSystem.disableDepthTest();
		super.render(p_283479_, p_283661_, p_281248_, p_281886_);
		p_283479_.pose().pushPose();
		p_283479_.pose().translate((float) i, (float) j, 0.0F);
		super.hoveredSlot = null;
		for (int k = 0; k < super.menu.slots.size(); ++k) {
			Slot slot = super.menu.slots.get(k);
			if (slot.isActive()) {
				super.renderSlot(p_283479_, slot);
			}
			//ONLY the next line is edited
			if (super.isHovering(slot, (double) p_283661_, (double) p_281248_) && slot.isActive() && (slot.index < nonHighlightedSlot || slot.index == this.menu.slots.size() - 1)) {
				super.hoveredSlot = slot;
				int l = slot.x;
				int i1 = slot.y;
				if (super.hoveredSlot.isHighlightable()) {
					renderSlotHighlight(p_283479_, l, i1, 0, getSlotColor(k));
				}
			}
		}
		super.renderLabels(p_283479_, p_283661_, p_281248_);
		net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.ContainerScreenEvent.Render.Foreground(this, p_283479_, p_283661_, p_281248_));
		ItemStack itemstack = super.draggingItem.isEmpty() ? super.menu.getCarried() : super.draggingItem;
		if (!itemstack.isEmpty()) {
			int l1 = 8;
			int i2 = super.draggingItem.isEmpty() ? 8 : 16;
			String s = null;
			if (!super.draggingItem.isEmpty() && super.isSplittingStack) {
				itemstack = itemstack.copyWithCount(Mth.ceil((float) itemstack.getCount() / 2.0F));
			} else if (super.isQuickCrafting && super.quickCraftSlots.size() > 1) {
				itemstack = itemstack.copyWithCount(super.quickCraftingRemainder);
				if (itemstack.isEmpty()) {
					s = ChatFormatting.YELLOW + "0";
				}
			}
			super.renderFloatingItem(p_283479_, itemstack, p_283661_ - i - 8, p_281248_ - j - i2, s);
		}
		if (!super.snapbackItem.isEmpty()) {
			float f = (float) (Util.getMillis() - super.snapbackTime) / 100.0F;
			if (f >= 1.0F) {
				f = 1.0F;
				super.snapbackItem = ItemStack.EMPTY;
			}
			int j2 = super.snapbackEnd.x - super.snapbackStartX;
			int k2 = super.snapbackEnd.y - super.snapbackStartY;
			int j1 = super.snapbackStartX + (int) ((float) j2 * f);
			int k1 = super.snapbackStartY + (int) ((float) k2 * f);
			super.renderFloatingItem(p_283479_, super.snapbackItem, j1, k1, (String) null);
		}
		p_283479_.pose().popPose();
		RenderSystem.enableDepthTest();
	}*/
}
