package classes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.ToaItems;

import java.util.ArrayList;

public class ToaItemTrees {
	private ToaItemTrees() { //static class
	}

	//reqItems:
	private static final ItemStack[] iron_sword = {new ItemStack(ToamodModItems.PURE_IRON.get(), 3)};
	private static final ItemStack[] hardened_iron_sword = {ToaItems.IRON_SWORD, new ItemStack(ToamodModItems.PURE_IRON.get(), 8)};
	private static final ItemStack[] gold_sword = {ToaItems.HARDENED_IRON_SWORD, new ItemStack(ToamodModItems.PURE_GOLD.get(), 12)};
	private static final ItemStack[] mithril_sword = {ToaItems.MITHRIL_SWORD, new ItemStack(ToamodModItems.MITHRIL.get(), 12), new ItemStack(ToamodModItems.PURE_GOLD.get(), 6)};
	//private static final ItemStack[] copper_1_sword = {ToaItems.MITHRIL_SWORD};
	//private static final ItemStack[] copper_2_sword = {ToaItems.COPPER_1_SWORD};
	//private static final ItemStack[] copper_claymore = {ToaItems.COPPER_2_SWORD};
	//private static final ItemStack[] orchal_claymore = {ToaItems.COPPER_CLAYMORE};
	//private static final ItemStack[] celestial_claymore = {ToaItems.ORCHAL_CLAYMORE};
	//private static final ItemStack[] frostbite_saber = {ToaItems.COPPER_2_SWORD};
	//private static final ItemStack[] froststeel_saber = {ToaItems.FROSTBITE_SABER};
	//private static final ItemStack[] winters_approch = {ToaItems.FORSTSTEEL_SABER};
	//private static final ItemStack[] eternal_winter = {ToaItems.WINTERS_APPROCH};
	//private static final ItemStack[] mana_infused_sword = {ToaItems.MITHRIL_SWORD};
	//private static final ItemStack[] manafused_sword = {ToaItems.MANA_INFUSED_SWORD};
	//private static final ItemStack[] sealed_hyperion = {ToaItems.MANAFUSED_SWORD};
	//private static final ItemStack[] starfall_hyperion = {ToaItems.SEALED_HYPERION};
	//private static final ItemStack[] starcaller_hyperion = {ToaItems.STARFALL_HYPERION};
	//private static final ItemStack[] scaldris_hyperion = {ToaItems.SEALED_HYPERION};
	//private static final ItemStack[] crimson_hyperion = {ToaItems.SEALED_HYPERION};
	//private static final ItemStack[] infernal_hyperion = {ToaItems.CRIMSON_HYPERION};
	//Tree-Points (no Upgrades)
	private static final ToaItemTrees.Entry IRON_SWORD = new Entry(ToaItems.IRON_SWORD, iron_sword, 100);
	private static final ToaItemTrees.Entry HARDENED_IRON_SWORD = new Entry(ToaItems.HARDENED_IRON_SWORD, iron_sword, 350);
	private static final ToaItemTrees.Entry GOLDEN_SWORD = new Entry(ToaItems.GOLDEN_SWORD, gold_sword, 1000);
	private static final ToaItemTrees.Entry MITHRIL_SWORD = new Entry(ToaItems.MITHRIL_SWORD, mithril_sword, 5000);
	//private static final ToaItemTrees.Entry COPPER_1_SWORD = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, copper_1_sword, 5000);
	//private static final ToaItemTrees.Entry COPPER_2_SWORD = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, copper_2_sword, 5000);
	//private static final ToaItemTrees.Entry COPPER_CLAYMORE = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, copper_claymore, 5000);
	//private static final ToaItemTrees.Entry ORCHAL_CLAYMORE = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, orchal_claymore, 5000);
	//private static final ToaItemTrees.Entry CELESTIAL_CLAYMORE = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, celestial_claymore, 5000);
	//private static final ToaItemTrees.Entry FROSTBITE_SABER = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, frostbite_saber, 5000);
	//private static final ToaItemTrees.Entry FROSTSTEEL_SABER = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, froststeel_blade, 5000);
	//private static final ToaItemTrees.Entry WINTERS_APPROCH = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, winters_approch, 5000);
	//private static final ToaItemTrees.Entry ETERNAL_WINTER = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, eternal_winter, 5000);
	//private static final ToaItemTrees.Entry MANA_INFUSED_SWORD = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, mana_infused_sword, 5000);
	//private static final ToaItemTrees.Entry MANAFUSED_SWORD = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, manafused_sword, 5000);
	//private static final ToaItemTrees.Entry SEALED_HYPERION = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, sealed_hyperion, 5000);
	//private static final ToaItemTrees.Entry STARFALL_HYPERION = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, starfall_hyperion, 5000);
	//private static final ToaItemTrees.Entry STARCALLER_HYPERION = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, starcaller_hyperion, 5000);
	//private static final ToaItemTrees.Entry SCALDRIS_HYPERION = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, scaldris_hyperion, 5000);
	//private static final ToaItemTrees.Entry CRIMSON_HYPERION = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, crimson_hyperion, 5000);
	//private static final ToaItemTrees.Entry INFERNAL_HYPERION = new ToaItemTrees.Entry(ToaItems.COPPER_1_SWORD, infernal_hyperion, 5000);
	//Bsp
	public static final ToaItemTrees.Entry WEAPON_TREE = createWeaponTree();

	//public static final ToaItemTrees.Entry ARMOR_TREE = new ToaItemTrees.Entry();
	// idk if i want a armor upgrade-tree -> probably NO
	public static class Entry {
		private ItemStack Item;
		private ItemStack[] ReqItems;
		private int ReqCor;
		private ArrayList<Entry> Upgrades;

		public Entry(ItemStack item, ItemStack[] reqItems, int reqCor, ArrayList<Entry> upgrades) {
			this.Item = item;
			this.ReqItems = reqItems;
			this.ReqCor = reqCor;
			this.Upgrades = upgrades;
		}

		//when item costs no cor to be upgraded to
		public Entry(ItemStack item, ItemStack[] reqItems, ArrayList<Entry> upgrades) {
			this(item, reqItems, 0, upgrades);
		}

		//when item is at the end of a path (has no further upgrades)
		public Entry(ItemStack item, ItemStack[] reqItems, int reqCor) {
			this(item, reqItems, reqCor, new ArrayList<Entry>());
		}

		//when item has no further upgrades and costs no cor to be upgraded to
		public Entry(ItemStack item, ItemStack[] reqItems) {
			this(item, reqItems, 0, new ArrayList<Entry>());
		}

		public ItemStack getItem() {
			return this.Item;
		}

		public ItemStack[] getReqItems() {
			return this.ReqItems;
		}

		public int getReqCor() {
			return this.ReqCor;
		}

		public ArrayList<Entry> getUpgrades() {
			return this.Upgrades;
		}

		public boolean isLeaf() {
			return this.Upgrades == null;
		}

		public void addUpgrade(Entry entry) {
			this.Upgrades.add(entry);
		}
	}

	private static ToaItemTrees.Entry createWeaponTree() {
		ToaItemTrees.Entry tree = IRON_SWORD;
		//Tree-Pattern
		IRON_SWORD.addUpgrade(HARDENED_IRON_SWORD);
		HARDENED_IRON_SWORD.addUpgrade(GOLDEN_SWORD);
		GOLDEN_SWORD.addUpgrade(MITHRIL_SWORD);
		//MITHRIL_SWORD.addUpgrade(COPPER_1_SWORD);
		//COPPER_1_SWORD.addUpgrade(COPPER_2_SWORD);
		//COPPER_2_SWORD.addUpgrade(COPPER_CLAYMORE);
		//COPPER_CLAYMORE.addUpgrade(ORCHAL_CLAYMORE);
		//ORCHAL_CLAYMORE.addUpgrade(CELESTIAL_CLAYMORE);
		//COPPER_2_SWORD.addUpgrade(FROSTBITE_SABER);
		//FROSTBITE_SABER.addUpgrade(FROSTSTEEL_SABER);
		//FROSTSTEEL_SABER.addUpgrade(WINTERS_APPROCH);
		//WINTERS_APPROCH.addUpgrade(ETERNAL_WINTER);
		//MITHRIL_SWORD.addUpgrade(MANA_INFUSED_SWORD);
		//MANA_INFUSED_SWORD.addUpgrade(MANAFUSED_SWORD);
		//MANAFUSED_SWORD.addUpgrade(SEALED_HYPERION);
		//SEALED_HYPERION.addUpgrade(STARFALL_HYPERION);
		//STARFALL_HYPERION.addUpgrade(STARCALLER_HYPERION);
		//SEALED_HYPERION.addUpgrade(SCALDRIS_HYPERION);
		//SEALED_HYPERION.addUpgrade(CRIMSON_HYPERION);
		//CRIMSON_HYPERION.addUpgrade(INFERNAL_HYPERION);
		//GOLDEN_SWORD.addUpgrade(CRYSTAL_1_SWORD);
		//CRYSTAL_1_SWORD.addUpgrade(CRYSTAL_2_SWORD);
		//CRYSTAL_2_SWORD.addUpgrade(AMBER_1_BLADE);
		//ABMBER_1_BLADE.addUpgrade(AMBER_2_BLADE);
		//ABMBER_2_BLADE.addUpgrade(DRAGONVEIN_BLADE);
		//DRAGONVEIN_BLADE.addUpgrade(ELDERVEIN_BLADE);
		//ELDERVEIN_BLADE.addUpgrade(ELDERVEIN_RUNEBLADE);
		//ABMBER_1_BLADE.addUpgrade(VOIDSTEEL_BLADE);
		//VOIDSTEEL_BLADE.addUpgrade(WHISPER_OF_THE_VOID);
		//WHISPER_OF_THE_VOID.addUpgrade(ETERNAL_ECLIPSE);
		return tree;
	}
}
