
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
import net.mcreator.toamod.enchantment.PowerfulEnchantment;
import net.mcreator.toamod.enchantment.ManaFlowEnchantment;
import net.mcreator.toamod.enchantment.MagicProtectionEnchantment;
import net.mcreator.toamod.enchantment.LifeSteelEnchantment;
import net.mcreator.toamod.enchantment.IgniteEnchantment;
import net.mcreator.toamod.enchantment.FortuneEnchantment;
import net.mcreator.toamod.enchantment.ExecutingEnchantment;
import net.mcreator.toamod.enchantment.BonusProjectileEnchantment;
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
	public static final RegistryObject<Enchantment> POWERFUL = REGISTRY.register("powerful", () -> new PowerfulEnchantment());
	public static final RegistryObject<Enchantment> FORTUNE = REGISTRY.register("fortune", () -> new FortuneEnchantment());
	public static final RegistryObject<Enchantment> MAGIC_PROTECTION = REGISTRY.register("magic_protection", () -> new MagicProtectionEnchantment());
	public static final RegistryObject<Enchantment> BONUS_PROJECTILE = REGISTRY.register("bonus_projectile", () -> new BonusProjectileEnchantment());
	public static final RegistryObject<Enchantment> MANA_FLOW = REGISTRY.register("mana_flow", () -> new ManaFlowEnchantment());
}
