
package net.mcreator.toamod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.toamod.entity.XedresEntity;
import net.mcreator.toamod.client.model.Modelgoblin;

public class XedresRenderer extends MobRenderer<XedresEntity, Modelgoblin<XedresEntity>> {
	public XedresRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgoblin(context.bakeLayer(Modelgoblin.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(XedresEntity entity) {
		return new ResourceLocation("toamod:textures/entities/copper_goblin_texture.png");
	}
}
