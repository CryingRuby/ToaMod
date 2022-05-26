
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.toamod.enchantment.StickyFeetEnchantment;
import net.mcreator.toamod.enchantment.SpikesEnchantment;
import net.mcreator.toamod.enchantment.SharpnessEnchantment;
import net.mcreator.toamod.enchantment.ProtectionEnchantment;
import net.mcreator.toamod.enchantment.LifeSteelEnchantment;
import net.mcreator.toamod.enchantment.IgniteEnchantment;
import net.mcreator.toamod.enchantment.ExecutingEnchantment;
import net.mcreator.toamod.ToamodMod;

public class ToamodModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ToamodMod.MODID);
	public static final RegistryObject<Enchantment> EXECUTING = REGISTRY.register("executing", () -> new ExecutingEnchantment());
	public static final RegistryObject<Enchantment> LIFE_STEEL = REGISTRY.register("life_steel", () -> new LifeSteelEnchantment());
	public static final RegistryObject<Enchantment> SHARPNESS = REGISTRY.register("sharpness", () -> new SharpnessEnchantment());
	public static final RegistryObject<Enchantment> PROTECTION = REGISTRY.register("protection", () -> new ProtectionEnchantment());
	public static final RegistryObject<Enchantment> STICKY_FEET = REGISTRY.register("sticky_feet", () -> new StickyFeetEnchantment());
	public static final RegistryObject<Enchantment> SPIKES = REGISTRY.register("spikes", () -> new SpikesEnchantment());
	public static final RegistryObject<Enchantment> IGNITE = REGISTRY.register("ignite", () -> new IgniteEnchantment());
}
