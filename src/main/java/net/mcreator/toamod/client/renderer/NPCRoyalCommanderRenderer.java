
package net.mcreator.toamod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.toamod.entity.NPCRoyalCommanderEntity;

public class NPCRoyalCommanderRenderer extends HumanoidMobRenderer<NPCRoyalCommanderEntity, HumanoidModel<NPCRoyalCommanderEntity>> {
	public NPCRoyalCommanderRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(NPCRoyalCommanderEntity entity) {
		return new ResourceLocation("toamod:textures/entities/npc_special_royal_commander.png");
	}
}
