package net.mcreator.toamod.procedures;

import org.checkerframework.checker.units.qual.cd;

import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.network.ToamodModVariables;

import java.util.concurrent.atomic.AtomicReference;

public class GetPlayerCDProcedure {
	public static double execute(Entity sourceentity) {
		if (sourceentity == null)
			return 0;
		double i = 0;
		double cd = 0;
		cd = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).critDmg + cd
				+ (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("cd") + cd
				+ (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("bonusCD");
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
			}.getItemStack((int) i, sourceentity)).getOrCreateTag().getString("runeType")).equals("CD")) {
				cd = cd + (new Object() {
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
		return cd;
	}
}
