
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.toamod.potion.VulnerableMobEffect;
import net.mcreator.toamod.potion.SwampFoulnessMobEffect;
import net.mcreator.toamod.potion.StrengthMobEffect;
import net.mcreator.toamod.potion.SpellImmunityMobEffect;
import net.mcreator.toamod.potion.LightningStrikeMobEffect;
import net.mcreator.toamod.potion.InvincibleMobEffect;
import net.mcreator.toamod.potion.FreezingColdMobEffect;
import net.mcreator.toamod.potion.ColdEmbraceMobEffect;
import net.mcreator.toamod.ToamodMod;

public class ToamodModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ToamodMod.MODID);
	public static final RegistryObject<MobEffect> VULNERABLE = REGISTRY.register("vulnerable", () -> new VulnerableMobEffect());
	public static final RegistryObject<MobEffect> COLD_EMBRACE = REGISTRY.register("cold_embrace", () -> new ColdEmbraceMobEffect());
	public static final RegistryObject<MobEffect> FREEZING_COLD = REGISTRY.register("freezing_cold", () -> new FreezingColdMobEffect());
	public static final RegistryObject<MobEffect> SPELL_IMMUNITY = REGISTRY.register("spell_immunity", () -> new SpellImmunityMobEffect());
	public static final RegistryObject<MobEffect> LIGHTNING_STRIKE = REGISTRY.register("lightning_strike", () -> new LightningStrikeMobEffect());
	public static final RegistryObject<MobEffect> STRENGTH = REGISTRY.register("strength", () -> new StrengthMobEffect());
	public static final RegistryObject<MobEffect> SWAMP_FOULNESS = REGISTRY.register("swamp_foulness", () -> new SwampFoulnessMobEffect());
	public static final RegistryObject<MobEffect> INVINCIBLE = REGISTRY.register("invincible", () -> new InvincibleMobEffect());
}
