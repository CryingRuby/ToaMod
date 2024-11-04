
package net.mcreator.toamod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.toamod.entity.GoblinScoutEntity;
import net.mcreator.toamod.client.model.Modelgoblin_scout;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GoblinScoutRenderer extends MobRenderer<GoblinScoutEntity, Modelgoblin_scout<GoblinScoutEntity>> {
	public GoblinScoutRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgoblin_scout(context.bakeLayer(Modelgoblin_scout.LAYER_LOCATION)), 1f);
		this.addLayer(new RenderLayer<GoblinScoutEntity, Modelgoblin_scout<GoblinScoutEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("toamod:textures/entities/goblin_lightmap.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GoblinScoutEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GoblinScoutEntity entity) {
		return new ResourceLocation("toamod:textures/entities/goblin_scout_texture.png");
	}
}
