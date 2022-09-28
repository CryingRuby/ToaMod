
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.toamod.client.renderer.HorseCareTakerRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ToamodModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ToamodModEntities.HORSE_CARE_TAKER.get(), HorseCareTakerRenderer::new);
	}
}
