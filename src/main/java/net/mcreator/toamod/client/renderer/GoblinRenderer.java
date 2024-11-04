
package net.mcreator.toamod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.toamod.entity.GoblinEntity;
import net.mcreator.toamod.client.model.Modelgoblin;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GoblinRenderer extends MobRenderer<GoblinEntity, Modelgoblin<GoblinEntity>> {
	public GoblinRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgoblin(context.bakeLayer(Modelgoblin.LAYER_LOCATION)), 1f);
		this.addLayer(new RenderLayer<GoblinEntity, Modelgoblin<GoblinEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("toamod:textures/entities/goblin_lightmap.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GoblinEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GoblinEntity entity) {
		return new ResourceLocation("toamod:textures/entities/copper_goblin_texture.png");
	}
}
