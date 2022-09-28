
package net.mcreator.toamod.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.init.ToamodModTabs;

import java.util.List;

public abstract class CristalArmorItem extends ArmorItem {
	public CristalArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 0;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{3, 4, 5, 3}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 1;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_diamond"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}

			@Override
			public String getName() {
				return "cristal_armor";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends CristalArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(ToamodModTabs.TAB_TOA_MOD_TAB));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("\u00A77Rarity: \u00A7bRare\u00A7r"));
			list.add(new TextComponent("\u00A77Type: \u00A79Armor\u00A7r"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "toamod:textures/models/armor/cristal__layer_1.png";
		}
	}

	public static class Chestplate extends CristalArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(ToamodModTabs.TAB_TOA_MOD_TAB));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("\u00A77Rarity: \u00A7bRare\u00A7r"));
			list.add(new TextComponent("\u00A77Type: \u00A79Armor\u00A7r"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "toamod:textures/models/armor/cristal__layer_1.png";
		}
	}

	public static class Leggings extends CristalArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(ToamodModTabs.TAB_TOA_MOD_TAB));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("\u00A77Rarity: \u00A7bRare\u00A7r"));
			list.add(new TextComponent("\u00A77Type: \u00A79Armor\u00A7r"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "toamod:textures/models/armor/cristal__layer_2.png";
		}
	}

	public static class Boots extends CristalArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(ToamodModTabs.TAB_TOA_MOD_TAB));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("\u00A77Rarity: \u00A7bRare\u00A7r"));
			list.add(new TextComponent("\u00A77Type: \u00A79Armor\u00A7r"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "toamod:textures/models/armor/cristal__layer_1.png";
		}
	}
}
