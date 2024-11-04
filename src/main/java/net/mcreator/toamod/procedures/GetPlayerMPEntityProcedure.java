package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.network.ToamodModVariables;

public class GetPlayerMPEntityProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double i = 0;
		double mp = 0;
		mp = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).magicPower
				+ (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MP");
		for (int index0 = 0; index0 < 4; index0++) {
			mp = mp + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int) i)) : ItemStack.EMPTY).getOrCreateTag().getDouble("MP");
			i = i + 1;
		}
		return mp;
	}
}
