
package net.mcreator.toamod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.toamod.entity.NPCNecroticKnightEntity;

public class NPCNecroticKnightRenderer extends HumanoidMobRenderer<NPCNecroticKnightEntity, HumanoidModel<NPCNecroticKnightEntity>> {
	public NPCNecroticKnightRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(NPCNecroticKnightEntity entity) {
		return new ResourceLocation("toamod:textures/entities/npc_special_necrotic_knight.png");
	}
}
