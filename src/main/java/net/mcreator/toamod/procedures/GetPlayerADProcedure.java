package net.mcreator.toamod.procedures;

import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.network.ToamodModVariables;

import java.util.concurrent.atomic.AtomicReference;

public class GetPlayerADProcedure {
	public static double execute(Entity sourceentity) {
		if (sourceentity == null)
			return 0;
		double ad = 0;
		double i = 0;
		ad = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).attackDamage + ad
				+ (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("ad") + ad
				+ (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("bonusAD");
		i = 0;
		for (int index0 = 0; index0 < (int) (9); index0++) {
			if (((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) i, sourceentity)).getOrCreateTag().getString("runeType")).equals("AD")) {
				ad = ad + (new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) i, sourceentity)).getOrCreateTag().getDouble("runeValue");
			}
			i = i + 1;
		}
		return ad;
	}
}
