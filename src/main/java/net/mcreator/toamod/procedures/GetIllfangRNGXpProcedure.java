package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;

public class GetIllfangRNGXpProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((Component.translatable("item.toamod.goblin_egg_spices").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
			return 100000;
		} else if ((Component.translatable("item.toamod.illfangs_cutlass").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
			return 32500;
		} else if ((Component.translatable("item.toamod.rune_rare").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
			return 12500;
		} else if ((Component.translatable("item.toamod.rune_uncomman").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
			return 9000;
		} else if ((Component.translatable("item.toamod.red_goblin_scale").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
			return 6666;
		} else if ((Component.translatable("item.toamod.boss_key_tier_1").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
			return 35000;
		} else if ((Component.translatable("item.toamod.boss_key_tier_2").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
			return 70000;
		} else if ((Component.translatable("item.toamod.boss_key_tier_3").getString()).equals((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).IllfangRNGSelected)) {
			return 200000;
		}
		return 1;
	}
}
