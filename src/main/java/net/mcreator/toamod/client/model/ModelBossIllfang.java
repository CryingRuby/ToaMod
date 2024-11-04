package net.mcreator.toamod.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelBossIllfang<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("toamod", "model_boss_illfang"), "main");
	public final ModelPart LeftLeg;
	public final ModelPart RightLeg;
	public final ModelPart LeftArm;
	public final ModelPart RightArm;
	public final ModelPart TorsoHead;

	public ModelBossIllfang(ModelPart root) {
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.TorsoHead = root.getChild("TorsoHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(4.0F, 5.0F, 0.0F));
		PartDefinition cube_r1 = LeftLeg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-6, -6).addBox(3.0F, -2.0F, -9.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 19.0F, 0.0F, 0.0F, -0.3054F, 0.0F));
		PartDefinition cube_r2 = LeftLeg.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(-8, -8).addBox(3.75F, -5.0F, -1.0F, 3.5F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(-9, -9).addBox(1.5F, -11.75F, 5.75F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 19.0F, 0.0F, 1.0908F, -0.3054F, 0.0F));
		PartDefinition cube_r3 = LeftLeg.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-5, -5).addBox(3.75F, -11.0F, -4.0F, 3.5F, 3.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 19.0F, 0.0F, 0.1309F, -0.0873F, 0.0F));
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-5.0F, 5.0F, 0.0F));
		PartDefinition cube_r4 = RightLeg.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(-9, -9).addBox(-5.5F, -11.75F, 5.75F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(-8, -8).addBox(-7.25F, -5.0F, -1.0F, 3.5F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 19.0F, 0.0F, 1.0908F, 0.3054F, 0.0F));
		PartDefinition cube_r5 = RightLeg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(-5, -5).addBox(-7.25F, -11.0F, -4.0F, 3.5F, 3.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 19.0F, 0.0F, 0.1309F, 0.0873F, 0.0F));
		PartDefinition cube_r6 = RightLeg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-6, -6).addBox(-8.0F, -2.0F, -9.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 19.0F, 0.0F, 0.0F, 0.3054F, 0.0F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(7.0F, -14.0F, -2.0F));
		PartDefinition cube_r7 = LeftArm.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(-2, -2).addBox(-1.58F, -1.25F, -2.0F, 4.25F, 13.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, -0.5236F));
		PartDefinition cube_r8 = LeftArm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-1, -1).addBox(3.42F, 8.75F, 4.0F, 3.25F, 13.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3828F, 0.05F, -0.1339F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-8.0F, -14.0F, -1.0F));
		PartDefinition cube_r9 = RightArm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-28, -28).addBox(41.0F, -23.0F, -36.0F, 0.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-51.0F, 38.0F, 1.0F, -0.3828F, 0.05F, 0.1339F));
		PartDefinition cube_r10 = RightArm.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(-2, -2).addBox(-14.58F, 5.75F, -2.0F, 4.25F, 13.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0F, 0.0F, -1.0F, 0.0873F, 0.0F, 0.5236F));
		PartDefinition cube_r11 = RightArm.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(-1, -1).addBox(-20.58F, 10.75F, 4.0F, 3.25F, 13.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0F, 0.0F, -1.0F, -0.3828F, 0.05F, 0.1339F));
		PartDefinition TorsoHead = partdefinition.addOrReplaceChild("TorsoHead", CubeListBuilder.create().texOffs(-8, -8).addBox(-3.58F, -26.75F, -16.75F, 7.25F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(-6, -6)
				.addBox(-3.58F, -28.75F, -11.75F, 7.25F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(2, 2).addBox(-3.0F, -1.0F, -4.25F, 6.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));
		PartDefinition cube_r12 = TorsoHead.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(2, 2).addBox(56.0F, -1.807F, 0.5F, 6.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-59.0F, 1.0F, 3.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r13 = TorsoHead.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(-5, -5).addBox(-5.75F, -28.75F, -4.0F, 11.5F, 5.0F, 6.5F, new CubeDeformation(0.0F)).texOffs(-7, -7).addBox(-3.0F, -26.0F, -5.0F, 6.0F, 1.75F, 8.5F, new CubeDeformation(0.0F)).texOffs(-9, -9)
						.addBox(-4.0F, -22.75F, -6.0F, 8.0F, 7.0F, 10.5F, new CubeDeformation(0.0F)).texOffs(-7, -7).addBox(-6.0F, -24.25F, -5.0F, 12.0F, 9.5F, 8.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, -0.0349F, 0.0F, 0.0F));
		PartDefinition cube_r14 = TorsoHead.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(-8, -8).addBox(-1.0F, -21.25F, 0.75F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(-8, -8).addBox(0.0F, -20.25F, 20.75F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(-8, -8)
						.addBox(-0.5F, -20.75F, 10.75F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(-8, -8).addBox(-1.5F, -21.75F, -9.25F, 5.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 19.0F, 0.0F, -0.5236F, 0.0F, 0.0F));
		PartDefinition cube_r15 = TorsoHead.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(-3, -3).addBox(-4.0F, -14.0F, -4.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(-5, -5).addBox(-5.0F, -15.0F, -5.0F, 10.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r16 = TorsoHead.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(-6, -6).addBox(-6.58F, -26.75F, 5.25F, 13.25F, 3.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r17 = TorsoHead.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(-7, -7).addBox(-3.25F, -38.5F, -5.75F, 6.5F, 2.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, 0.2618F, 0.0F, 0.0F));
		PartDefinition cube_r18 = TorsoHead.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(-1, -1).addBox(-5.58F, -7.75F, -1.75F, 1.25F, 1.0F, 2.25F, new CubeDeformation(0.0F)).texOffs(-1, -1).addBox(-6.58F, -6.75F, -1.75F, 2.25F, 4.0F, 2.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -30.0F, -5.0F, -0.2182F, 0.0F, -0.8727F));
		PartDefinition cube_r19 = TorsoHead.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(-1, -1).addBox(0.42F, -2.75F, -0.75F, 2.25F, 5.0F, 2.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -30.0F, -5.0F, -0.2182F, 0.0F, 0.8727F));
		PartDefinition cube_r20 = TorsoHead.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(-3, -3).addBox(-2.58F, -39.25F, 9.0F, 5.25F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(-7, -7).addBox(-7.58F, -34.25F, 7.0F, 15.25F, 9.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, 0.4363F, 0.0F, 0.0F));
		PartDefinition cube_r21 = TorsoHead.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(0.25F, -5.9115F, -4.4799F, 1.75F, 6.0F, 1.75F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, -33.0F, -4.0F, 0.8396F, -0.9605F, 1.5066F));
		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TorsoHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}
