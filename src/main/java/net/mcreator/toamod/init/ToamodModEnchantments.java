
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.toamod.enchantment.VampirismEnchantment;
import net.mcreator.toamod.enchantment.StickyfeetEnchantment;
import net.mcreator.toamod.enchantment.SpikesEnchantment;
import net.mcreator.toamod.enchantment.ShinyEnchantment;
import net.mcreator.toamod.enchantment.SharpnessEnchantment;
import net.mcreator.toamod.enchantment.ScavengerEnchantment;
import net.mcreator.toamod.enchantment.ProtectionEnchantment;
import net.mcreator.toamod.enchantment.PowerfulEnchantment;
import net.mcreator.toamod.enchantment.ManaflowEnchantment;
import net.mcreator.toamod.enchantment.MagicshieldEnchantment;
import net.mcreator.toamod.enchantment.LifestealEnchantment;
import net.mcreator.toamod.enchantment.IgniteEnchantment;
import net.mcreator.toamod.enchantment.GrowthEnchantment;
import net.mcreator.toamod.enchantment.FortuneEnchantment;
import net.mcreator.toamod.enchantment.FocusEnchantment;
import net.mcreator.toamod.enchantment.ExecutingEnchantment;
import net.mcreator.toamod.enchantment.DivineGiftEnchantment;
import net.mcreator.toamod.enchantment.CriticalEnchantment;
import net.mcreator.toamod.ToamodMod;

public class ToamodModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ToamodMod.MODID);
	public static final RegistryObject<Enchantment> EXECUTING = REGISTRY.register("executing", () -> new ExecutingEnchantment());
	public static final RegistryObject<Enchantment> SHARPNESS = REGISTRY.register("sharpness", () -> new SharpnessEnchantment());
	public static final RegistryObject<Enchantment> PROTECTION = REGISTRY.register("protection", () -> new ProtectionEnchantment());
	public static final RegistryObject<Enchantment> SPIKES = REGISTRY.register("spikes", () -> new SpikesEnchantment());
	public static final RegistryObject<Enchantment> IGNITE = REGISTRY.register("ignite", () -> new IgniteEnchantment());
	public static final RegistryObject<Enchantment> POWERFUL = REGISTRY.register("powerful", () -> new PowerfulEnchantment());
	public static final RegistryObject<Enchantment> FORTUNE = REGISTRY.register("fortune", () -> new FortuneEnchantment());
	public static final RegistryObject<Enchantment> CRITICAL = REGISTRY.register("critical", () -> new CriticalEnchantment());
	public static final RegistryObject<Enchantment> SCAVENGER = REGISTRY.register("scavenger", () -> new ScavengerEnchantment());
	public static final RegistryObject<Enchantment> LIFESTEAL = REGISTRY.register("lifesteal", () -> new LifestealEnchantment());
	public static final RegistryObject<Enchantment> STICKYFEET = REGISTRY.register("stickyfeet", () -> new StickyfeetEnchantment());
	public static final RegistryObject<Enchantment> MANAFLOW = REGISTRY.register("manaflow", () -> new ManaflowEnchantment());
	public static final RegistryObject<Enchantment> MAGICSHIELD = REGISTRY.register("magicshield", () -> new MagicshieldEnchantment());
	public static final RegistryObject<Enchantment> FOCUS = REGISTRY.register("focus", () -> new FocusEnchantment());
	public static final RegistryObject<Enchantment> DIVINE_GIFT = REGISTRY.register("divine_gift", () -> new DivineGiftEnchantment());
	public static final RegistryObject<Enchantment> GROWTH = REGISTRY.register("growth", () -> new GrowthEnchantment());
	public static final RegistryObject<Enchantment> SHINY = REGISTRY.register("shiny", () -> new ShinyEnchantment());
	public static final RegistryObject<Enchantment> VAMPIRISM = REGISTRY.register("vampirism", () -> new VampirismEnchantment());
}
