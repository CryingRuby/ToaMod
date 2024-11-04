package net.mcreator.toamod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.toamod.entity.BossIllfangEntity;

public class BossIllfangModel extends GeoModel<BossIllfangEntity> {
	@Override
	public ResourceLocation getAnimationResource(BossIllfangEntity entity) {
		return new ResourceLocation("toamod", "animations/bossillfang.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BossIllfangEntity entity) {
		return new ResourceLocation("toamod", "geo/bossillfang.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BossIllfangEntity entity) {
		return new ResourceLocation("toamod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
