package net.mcreator.toamod.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.network.ToamodModVariables;

import java.util.concurrent.atomic.AtomicReference;

public class GetPlayerMRProcedure {
	public static double execute(Entity sourceentity) {
		if (sourceentity == null)
			return 0;
		double i = 0;
		double mr = 0;
		mr = (sourceentity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).magicResistance + mr
				+ (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MR");
		i = 0;
		for (int index0 = 0; index0 < 9; index0++) {
			if (((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) i, sourceentity)).getOrCreateTag().getString("runeType")).equals("MR") && !((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) i, sourceentity)).getItem() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem())) {
				mr = mr + (new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) i, sourceentity)).getOrCreateTag().getDouble("runeValue");
			}
			i = i + 1;
		}
		i = 0;
		for (int index1 = 0; index1 < 4; index1++) {
			mr = mr + (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int) i)) : ItemStack.EMPTY).getOrCreateTag().getDouble("MR");
			i = i + 1;
		}
		return mr;
	}
}