package net.mcreator.toamod;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.toamod.init.ToamodModEnchantments;

import java.util.ArrayList;

public final class ToaEnchantmentHandler {
	private ToaEnchantmentHandler() {
	}

	//IMPORTANT: All Arrays, Lists, etc. must be alphabetically ordered!
	

	public static ToaEnchantment getEnchantByName(String name) {
		Enchantment ench = switch (name) {
			case "sharpness" -> ToamodModEnchantments.SHARPNESS.get();
			case "executing" -> ToamodModEnchantments.EXECUTING.get();
			case "protection" -> ToamodModEnchantments.PROTECTION.get();
			case "spikes" -> ToamodModEnchantments.SPIKES.get();
			case "ignite" -> ToamodModEnchantments.IGNITE.get();
			case "powerful" -> ToamodModEnchantments.POWERFUL.get();
			case "fortune" -> ToamodModEnchantments.FORTUNE.get();
			case "critical" -> ToamodModEnchantments.CRITICAL.get();
			case "scavenger" -> ToamodModEnchantments.SCAVENGER.get();
			case "stickyfeet" -> ToamodModEnchantments.STICKYFEET.get();
			case "manaflow" -> ToamodModEnchantments.MANAFLOW.get();
			case "focus" -> ToamodModEnchantments.FOCUS.get();
			case "divine_gift" -> ToamodModEnchantments.DIVINE_GIFT.get();
			case "growth" -> ToamodModEnchantments.GROWTH.get();
			case "shiny" -> ToamodModEnchantments.SHINY.get();
			case "vampirism" -> ToamodModEnchantments.VAMPIRISM.get();
			case "magic_protection" -> ToamodModEnchantments.MAGIC_PROTECTION.get();
			case "chimera" -> ToamodModEnchantments.CHIMERA.get();
			default -> null;
		};
		return (ToaEnchantment) ench;
	}

	public static ToaEnchantment[] getSuperiorEnchants() {
		return new ToaEnchantment[]{
			(ToaEnchantment) ToamodModEnchantments.CHIMERA.get()};
	}

	/**
	 * Collects possible superior enchants for a specific item type
	 */
	public static ToaEnchantment[] getSuperiorEnchants(ToaItemType type) {
		return switch (type) {
			case SWORD -> new ToaEnchantment[]{
				(ToaEnchantment) ToamodModEnchantments.CHIMERA.get()};
			//TO-DO when superior enchantment update (maybe together with pets)
			case ARMOR -> null;
			case PICKAXE -> null;
			case EQUIPMENT -> null;
			default -> null; //ARTEFACTS wont have superior enchants
		};
	}

	/**
	 * Collects all enchantments that can be applied to an item with a specific item type
	 * 
	 * @param the item type the returning enchants can be applied to
	 * 
	 */
	public static ToaEnchantment[] getEnchantsByType(ToaItemType type) {
		return switch (type) {
			case SWORD -> new ToaEnchantment[]{
				(ToaEnchantment) ToamodModEnchantments.CRITICAL.get(),
				(ToaEnchantment) ToamodModEnchantments.DIVINE_GIFT.get(),
				(ToaEnchantment) ToamodModEnchantments.EXECUTING.get(),
				(ToaEnchantment) ToamodModEnchantments.FOCUS.get(),
				(ToaEnchantment) ToamodModEnchantments.IGNITE.get(),
				(ToaEnchantment) ToamodModEnchantments.MANAFLOW.get(),
				(ToaEnchantment) ToamodModEnchantments.POWERFUL.get(),
				(ToaEnchantment) ToamodModEnchantments.SCAVENGER.get(), 
				(ToaEnchantment) ToamodModEnchantments.SHARPNESS.get(), 
				(ToaEnchantment) ToamodModEnchantments.VAMPIRISM.get()};
			case ARMOR -> new ToaEnchantment[]{
				(ToaEnchantment) ToamodModEnchantments.GROWTH.get(),
				(ToaEnchantment) ToamodModEnchantments.MAGIC_PROTECTION.get(),
				(ToaEnchantment) ToamodModEnchantments.PROTECTION.get(),
				(ToaEnchantment) ToamodModEnchantments.SPIKES.get()};
			case PICKAXE -> new ToaEnchantment[]{
				(ToaEnchantment) ToamodModEnchantments.FORTUNE.get(), 
				/*(ToaEnchantment) ToamodModEnchantments.RUNIC.get(),*/
				(ToaEnchantment) ToamodModEnchantments.SHINY.get()};
			default -> null; //EQUIPMENT, ARTEFACT dont have enchantments (yet, idk if there will be any)
		};
	}

	/**
	 * 
	 * @param the enchant nbt list tag of the item. format:  [{id:"toamod;XX",lvl:XX}]
	 * 
	 * @return is alphabetically sorted since tag is as well
	 */
	public static ArrayList<ToaEnchantment> getEnchantsByNBT(ListTag enchantTag) {
		ArrayList<ToaEnchantment> enchants = new ArrayList<>();
		for (int i = 0; i < enchantTag.size(); i++) {
			CompoundTag ench = enchantTag.getCompound(i);
			if (ench.contains("id"))
				enchants.add(getEnchantByName(ench.getString("id").replace("toamod:", "")));
		}
		return enchants;
	}

	/**
	 * Enchants an item with a custom enchantment from Toamod with specific level.
	 * And sets new enchantment in the correct alphabetic order
	 */
	public static void enchantItem(ItemStack item, ToaEnchantment enchant, int level) {
		ListTag enchantments = item.getEnchantmentTags();
		String enchName = enchant.getDescriptionId().replace("enchantment.toamod.", "");
		int setIndex = enchantments.size();
		

		for (int i = 0; i < enchantments.size(); i++) {
			CompoundTag enchTag = enchantments.getCompound(i);
			String enchTagName = enchTag.getString("id").replace("toamod:", "");

			//enchantment is already on item, only the level is different -> change level, no sorting
			if (enchTagName.equals(enchName)) {
				enchTag.putInt("lvl", level);
				return;
			}
		}
		CompoundTag setEnch = new CompoundTag();
		setEnch.putString("id", "toamod:" + enchant.getDescriptionId().replace("enchantment.toamod.", ""));
		setEnch.putInt("lvl", level);
		enchantments.add(setEnch);
		//order enchant list
		sortEnchantTag(enchantments);
		
		//put list bag in case of the item having no enchantment tag to place the new tag
		item.getOrCreateTag().put("Enchantments", enchantments);
	}

	/**
	 * Orders the ListTag alphabtically.
	 * @param enchant-ListTag that will be ordered. MUST be ordered except the last one added. (requirement will be fulfilled because this method is called every time an enchant gets added). Size will always be >= 1
	 */
	private static void sortEnchantTag(ListTag enchants){
		System.out.println("Enchant List before Sort:  " +enchants);
		if(enchants.size() == 1)
			return;
		String enchName = enchants.getCompound(enchants.size()-1).getString("id").replace("toamod:", "");
		for(int i = 0; i < enchants.size()-1; i++){
			String tempName = enchants.getCompound(i).getString("id").replace("toamod:", "");
			int comp = tempName.compareTo(enchName);
			//every thing that should be on the right of the new added ench now is at the right with this if -> return
			if(comp == 0){
				System.out.println("Enchant List after Sort:  " +enchants);
				return;
			}
			if(comp > 0){
				enchants.add(enchants.getCompound(i));
				enchants.remove(i);
				i--;
			}
		}
		System.out.println("Enchant List after Sort:  " +enchants);
	}
}
