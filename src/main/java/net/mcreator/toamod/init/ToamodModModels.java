
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.toamod.client.model.Modelgoblin_scout;
import net.mcreator.toamod.client.model.Modelgoblin_hunter;
import net.mcreator.toamod.client.model.Modelgoblin;
import net.mcreator.toamod.client.model.ModelBossIllfang;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ToamodModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelgoblin_scout.LAYER_LOCATION, Modelgoblin_scout::createBodyLayer);
		event.registerLayerDefinition(ModelBossIllfang.LAYER_LOCATION, ModelBossIllfang::createBodyLayer);
		event.registerLayerDefinition(Modelgoblin.LAYER_LOCATION, Modelgoblin::createBodyLayer);
		event.registerLayerDefinition(Modelgoblin_hunter.LAYER_LOCATION, Modelgoblin_hunter::createBodyLayer);
	}
}
