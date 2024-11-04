package net.mcreator.toamod.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

import net.mcreator.toamod.jei_recipes.MagicCrafterTypeRecipe;
import net.mcreator.toamod.jei_recipes.BlacksmithTableTypeRecipe;
import net.mcreator.toamod.ToamodMod;

@Mod.EventBusSubscriber(modid = ToamodMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ToamodModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "toamod");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("blacksmith_table_type", () -> BlacksmithTableTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("magic_crafter_type", () -> MagicCrafterTypeRecipe.Serializer.INSTANCE);
		});
	}
}
