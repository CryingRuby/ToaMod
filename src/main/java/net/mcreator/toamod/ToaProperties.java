package net.mcreator.toamod;

import org.checkerframework.checker.units.qual.cd;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;

public class ToaProperties {
	public ToaRarity rarity;
	public String type, subType;
	/*stats for the weapon in format {flat, percentage}
	     ReforgyType uses {rarity=0, rarity=1, ...., rarity=6}*/
	public float[] STR, DEX, CON, INT, WIS, CR, CD, LIFESTEAL, HP, AR, MR, MF, MINF;
	public ToaElement ELEMENT;
	public float[] ELEMENTAL_DAMAGE;
	//these are the id's of the stats that are != 0 => this is just for code-efficiency (mostly in Lore-Setting) and is not a game feature (Elemental dmg is extra since is it only given to actual items and NOT upgrades)
	//ID's str = 0, dex = 1, con = 2, int = 3, wis = 4, cr = 5, cd = 6, lifesteal = 7, hp = 8, ar = 9, mr = 10, mf = 11, minf = 12
	private ArrayList<Byte> presentStats = new ArrayList<Byte>();

	public ToaProperties() {
	}

	public ToaProperties(String type, ToaRarity rarity) {
		this.type = type;
		this.rarity = rarity;
	}

	/*public ToaProperties(String type, ToaRarity rarity, String subType, float[] _str, float[] _dex, float[] _con, float[] _int, float[] _wis, float[] _cr, float[] _cd, ToaElement element, float[] elemental_damage, float lifesteal, float[] _hp,
			float[] _ar, float[] _mr, float[] mf, float[] minf) {
		this.type = type;
		this.rarity = rarity;
		this.subType = subType;
		this.STR = _str;
		this.DEX = _dex;
		this.CON = _con;
		this.INT = _int;
		this.WIS = _wis;
		this.CR = _cr;
		this.CD = _cd;
		this.ELEMENT = element;
		this.ELEMENTAL_DAMAGE = elemental_damage;
		this.LIFESTEAL = lifesteal;
		this.HP = _hp;
		this.AR = _ar;
		this.MR = _mr;
		this.MF = _mf;
		this.MINF = _minf;
	}
	*/
	
	/**
	 * Adds ALL general information about the ToaProperty like rarity and type to the CompoundTag.
	 * @param The CompoundTag of the item the general information will be added to
	 */
	public void addBaseInfoToNbt(CompoundTag nbt) {
		nbt.putInt("rarity", rarity.ID);
		nbt.putString("type", type);
		if (subType != null && subType.trim().isEmpty())
			nbt.putString("subtype", subType);
	}

	/**
	 * Collects all actual stats and combines them into an CompoundTag
	 * @return CompoundTag with ALL ACTUAL stats of the ToaProperty
	 */
	public CompoundTag statsToNbt() {
		CompoundTag nbt = new CompoundTag();
		if (STR != null) {
			if (STR[0] != 0)
				nbt.putFloat("str_f", STR[0]);
			if (STR[1] != 0)
				nbt.putFloat("str_p", STR[1]);
		}
		if (DEX != null) {
			if (DEX[0] != 0)
				nbt.putFloat("dex_f", DEX[0]);
			if (DEX[1] != 0)
				nbt.putFloat("dex_p", DEX[1]);
		}
		if (CON != null) {
			if (CON[0] != 0)
				nbt.putFloat("con_f", CON[0]);
			if (CON[1] != 0)
				nbt.putFloat("con_p", CON[1]);
		}
		if (INT != null) {
			if (STR[0] != 0)
				nbt.putFloat("int_f", INT[0]);
			if (STR[1] != 0)
				nbt.putFloat("int_p", INT[1]);
		}
		if (WIS != null) {
			if (WIS[0] != 0)
				nbt.putFloat("wis_f", WIS[0]);
			if (WIS[1] != 0)
				nbt.putFloat("wis_p", WIS[1]);
		}
		if (ELEMENT != null) {
			nbt.putString("element", ELEMENT.name);
			if (ELEMENTAL_DAMAGE[0] != 0)
				nbt.putFloat("elem_dmg_f", ELEMENTAL_DAMAGE[0]);
			if (ELEMENTAL_DAMAGE[1] != 0)
				nbt.putFloat("elem_dmg_p", ELEMENTAL_DAMAGE[1]);
		}
		if (HP != null) {
			if (HP[0] != 0)
				nbt.putFloat("hp_f", HP[0]);
			if (HP[1] != 0)
				nbt.putFloat("hp_p", HP[1]);
		}
		if (AR != null) {
			if (AR[0] != 0)
				nbt.putFloat("ar_f", AR[0]);
			if (AR[1] != 0)
				nbt.putFloat("ar_p", AR[1]);
		}
		if (MR != null) {
			if (MR[0] != 0)
				nbt.putFloat("mr_f", MR[0]);
			if (MR[1] != 0)
				nbt.putFloat("mr_p", MR[1]);
		}
		if (MF != null) {
			if (MF[0] != 0)
				nbt.putFloat("mf_f", MF[0]);
			if (MF[1] != 0)
				nbt.putFloat("mf_p", MF[1]);
		}
		if (MINF != null) {
			if (MINF[0] != 0)
				nbt.putFloat("minf_f", MINF[0]);
			if (MINF[1] != 0)
				nbt.putFloat("minf_p", MINF[1]);
		}
		if (LIFESTEAL != null && LIFESTEAL[0] != 0) {
			nbt.putFloat("lifesteal", LIFESTEAL[0]);
		}
		if (CR != null && CR[0] != 0) {
			nbt.putFloat("cr", CR[0]);
		}
		if (CD != null && CD[0] != 0) {
			nbt.putFloat("cd", CD[0]);
		}
		return nbt;
	}

	/**
	 * Multiplies all Stats by f
	 * @return a new ToaProperties object with the multiplied flat-stats
	 */
	public ToaProperties multiplyAllFlat(float f) {
		ToaProperties newStats = (new ToaProperties(type, rarity)).subType(subType);
		if (STR != null)
			newStats.str(new float[]{STR[0] * f, STR[1]});
		if (DEX != null)
			newStats.dex(new float[]{DEX[0] * f, DEX[1]});
		if (CON != null)
			newStats.con(new float[]{CON[0] * f, CON[1]});
		if (INT != null)
			newStats._int(new float[]{INT[0] * f, INT[1]});
		if (WIS != null)
			newStats.wis(new float[]{WIS[0] * f, WIS[1]});
		if (CR != null)
			newStats.cr(new float[]{CR[0] * f, CR[1]});
		if (CD != null)
			newStats.cd(new float[]{CD[0] * f, CD[1]});
		if (ELEMENT != null)
			newStats.element(ELEMENT, new float[]{ELEMENTAL_DAMAGE[0] * f, ELEMENTAL_DAMAGE[1]});
		if (LIFESTEAL != null)
			newStats.lifesteal(new float[]{LIFESTEAL[0] * f, LIFESTEAL[1]});
		if (HP != null)
			newStats.hp(new float[]{HP[0] * f, HP[1]});
		if (AR != null)
			newStats.ar(new float[]{AR[0] * f, AR[1]});
		if (MR != null)
			newStats.mr(new float[]{MR[0] * f, MR[1]});
		if (MF != null)
			newStats.mf(new float[]{MF[0] * f, MF[1]});
		if (MINF != null)
			newStats.minf(new float[]{MINF[0] * f, MINF[1]});
		return newStats;
	}

	/**
	 * Adds the stat from this ToaProperties to stats in tag
	 * @param tag is the result of getOrCreateTag() method with all subTags
	 */
	public void addStatsToItem(ItemStack item) {
		CompoundTag nbt = item.getOrCreateTag().getCompound("Stats");
		if (STR != null) {
			nbt.putFloat("str_f", nbt.getFloat("str_f") + STR[0]);
			nbt.putFloat("str_p", nbt.getFloat("str_p") + STR[1]);
		}
		if (DEX != null) {
			nbt.putFloat("dex_f", nbt.getFloat("dex_f") + DEX[0]);
			nbt.putFloat("dex_p", nbt.getFloat("dex_p") + DEX[1]);
		}
		if (CON != null) {
			nbt.putFloat("con_f", nbt.getFloat("str_f") + CON[0]);
			nbt.putFloat("con_p", nbt.getFloat("con_p") + CON[1]);
		}
		if (INT != null) {
			nbt.putFloat("int_f", nbt.getFloat("int_f") + INT[0]);
			nbt.putFloat("int_p", nbt.getFloat("int_p") + INT[1]);
		}
		if (WIS != null) {
			nbt.putFloat("wis_f", nbt.getFloat("wis_f") + WIS[0]);
			nbt.putFloat("wis_p", nbt.getFloat("wis_p") + WIS[1]);
		}
		if (CR != null) {
			nbt.putFloat("cr", nbt.getFloat("cr") + CR[0]);
		}
		if (CD != null) {
			nbt.putFloat("cd", nbt.getFloat("cd") + CD[0]);
		}
		if (ELEMENT != null && ELEMENT == ToaElement.getByName(nbt.getString("element"))) {
			nbt.putFloat("elem_dmg_f", nbt.getFloat("elem_dmg_f") + ELEMENTAL_DAMAGE[0]);
			nbt.putFloat("elem_dmg_p", nbt.getFloat("elem_dmg_p") + ELEMENTAL_DAMAGE[1]);
		}
		if (LIFESTEAL != null) {
			nbt.putFloat("lifesteal", nbt.getFloat("lifesteal") + LIFESTEAL[0]);
		}
		if (HP != null) {
			nbt.putFloat("hp_f", nbt.getFloat("hp_f") + HP[0]);
			nbt.putFloat("hp_p", nbt.getFloat("hp_p") + HP[1]);
		}
		if (AR != null) {
			nbt.putFloat("ar_f", nbt.getFloat("ar_f") + AR[0]);
			nbt.putFloat("ar_p", nbt.getFloat("ar_p") + AR[1]);
		}
		if (MR != null) {
			nbt.putFloat("mr_f", nbt.getFloat("mr_f") + MR[0]);
			nbt.putFloat("mr_p", nbt.getFloat("mr_p") + MR[1]);
		}
		if (MF != null) {
			nbt.putFloat("mf_f", nbt.getFloat("mf_f") + MF[0]);
			nbt.putFloat("mf_p", nbt.getFloat("mf_p") + MF[1]);
		}
		if (MINF != null) {
			nbt.putFloat("minf_f", nbt.getFloat("minf_f") + MINF[0]);
			nbt.putFloat("minf_p", nbt.getFloat("minf_p") + MINF[1]);
		}
		item.getOrCreateTag().put("Stats", nbt);
	}

	/**
	 * Used ONLY to apply the stats of a reforge to an item
	 */
	public static void applyEnchantToItem(ToaEnchantment ench, ItemStack item, int level){
		ench.stats.applyV2PropertiesToItem(item, level);
	}

	/**
	 * Used ONLY to apply the stats of a reforge to an item
	 */
	public static void applyReforgeToItem(ReforgeType reforge, ItemStack item) {
		//V2 Properties are the ToaProperties of Reforges or Runes which have longer float[] for the stat they grant based on a rarity
		reforge.getProperties().applyV2PropertiesToItem(item, item.getOrCreateTag().getInt("rarity"));
	}

	/**
	 * Used ONLY to apply the stats of a rune to an item
	 * @param runeType of rune
	 * @param item to which the stats of the rune will be applied
	 * @param rarity of the rune
	 */
	public static void applyRuneToItem(RuneType rune, ItemStack item, int rarity) {
		//V2 Properties are the ToaProperties of Reforges or Runes which have longer float[] for the stat they grant based on a rarity
		rune.getProperties().applyV2PropertiesToItem(item, rarity);
	}

	/**
	 * V2 Properties are the ToaProperties of Reforges, Runes or Enchants which have longer float[] for the stat they grant based on a rarity
	 */
	private void applyV2PropertiesToItem(ItemStack item, int index) {
		if (!(item.getItem() instanceof ToaReforgeable))
			return;
		CompoundTag itemStats = item.getOrCreateTag().getCompound("Stats");
		if (STR != null)
			itemStats.putFloat("str_f", itemStats.getFloat("str_f") + STR[index]);
		if (DEX != null)
			itemStats.putFloat("dex_f", itemStats.getFloat("dex_f") + DEX[index]);
		if (CON != null)
			itemStats.putFloat("con_f", itemStats.getFloat("con_f") + CON[index]);
		if (INT != null)
			itemStats.putFloat("int_f", itemStats.getFloat("int_f") + INT[index]);
		if (WIS != null)
			itemStats.putFloat("wis_f", itemStats.getFloat("wis_f") + WIS[index]);
		if (CR != null)
			itemStats.putFloat("cr", itemStats.getFloat("cr") + CR[index]);
		if (CD != null)
			itemStats.putFloat("cd", itemStats.getFloat("cd") + CD[index]);
		if (LIFESTEAL != null)
			itemStats.putFloat("lifesteal", itemStats.getFloat("lifesteal") + LIFESTEAL[index]);
		if (HP != null)
			itemStats.putFloat("hp_f", itemStats.getFloat("hp_f") + HP[index]);
		if (AR != null)
			itemStats.putFloat("ar_f", itemStats.getFloat("ar_f") + AR[index]);
		if (MR != null)
			itemStats.putFloat("mr_f", itemStats.getFloat("mr_f") + MR[index]);
		if (MF != null)
			itemStats.putFloat("mf_f", itemStats.getFloat("mf_f") + MF[index]);
		if (MINF != null)
			itemStats.putFloat("minf_f", itemStats.getFloat("minf_f") + MINF[index]);
		item.getOrCreateTag().put("Stats", itemStats);
	}

	public ArrayList<Byte> getPresentIDs(){
		return this.presentStats;
	}

	public float[] getValueByID(byte id){
		return switch(id){
			case 0 -> this.STR;
			case 1 -> this.DEX;
			case 2 -> this.CON;
			case 3 -> this.INT;
			case 4 -> this.WIS;
			case 5 -> this.CR;
			case 6 -> this.CD;
			case 7 -> this.LIFESTEAL;
			case 8 -> this.HP;
			case 9 -> this.AR;
			case 10 -> this.MR;
			case 11 -> this.MF;
			case 12 -> this.MINF;
			default -> null;
		};
	}

	public ToaProperties subType(String subType) {
		this.subType = subType;
		return this;
	}

	public ToaProperties str(float[] _str) {
		this.STR = _str;
		this.presentStats.add((byte) 0);
		return this;
	}

	public ToaProperties str(float _str) {
		return str(new float[]{_str, 0});
	}

	public ToaProperties dex(float[] _dex) {
		this.DEX = _dex;
		this.presentStats.add((byte) 1);
		return this;
	}

	public ToaProperties dex(float _dex) {
		return dex(new float[]{_dex, 0});
	}

	public ToaProperties con(float[] _con) {
		this.CON = _con;
		this.presentStats.add((byte) 2);
		return this;
	}

	public ToaProperties con(float _con) {
		return con(new float[]{_con, 0});
	}

	public ToaProperties _int(float[] _int) {
		this.INT = _int;
		this.presentStats.add((byte) 3);
		return this;
	}

	public ToaProperties _int(float _int) {
		return _int(new float[]{_int, 0});
	}

	public ToaProperties wis(float[] _wis) {
		this.WIS = _wis;
		this.presentStats.add((byte) 4);
		return this;
	}

	public ToaProperties wis(float _wis) {
		return wis(new float[]{_wis, 0});
	}

	public ToaProperties cr(float cr) {
		return cr(new float[]{cr});
	}

	/**
	 * ONLY used by ReforgeType-class
	 */
	public ToaProperties cr(float[] cr) {
		this.CR = cr;
		this.presentStats.add((byte) 5);
		return this;
	}

	public ToaProperties cd(float cd) {
		return cd(new float[]{cd});
	}

	/**
	 * ONLY used by ReforgeType-class
	 */
	public ToaProperties cd(float[] cd) {
		this.CD = cd;
		this.presentStats.add((byte) 6);
		return this;
	}

	public ToaProperties element(ToaElement element, float[] elemental_damage) {
		this.ELEMENT = element;
		this.ELEMENTAL_DAMAGE = elemental_damage;
		return this;
	}

	public ToaProperties element(ToaElement element, float elemental_damage) {
		this.ELEMENT = element;
		this.ELEMENTAL_DAMAGE = new float[]{elemental_damage, 0};
		return this;
	}

	public ToaProperties lifesteal(float lifesteal) {
		return lifesteal(new float[]{lifesteal});
	}

	/**
	 * ONLY used by ReforgeType-class
	 */
	public ToaProperties lifesteal(float[] lifesteal) {
		this.LIFESTEAL = lifesteal;
		this.presentStats.add((byte) 7);
		return this;
	}

	public ToaProperties hp(float[] hp) {
		this.HP = hp;
		this.presentStats.add((byte) 8);
		return this;
	}

	public ToaProperties hp(float hp) {
		return hp(new float[]{hp, 0});
	}

	public ToaProperties ar(float[] ar) {
		this.AR = ar;
		this.presentStats.add((byte) 9);
		return this;
	}

	public ToaProperties ar(float ar) {
		return ar(new float[]{ar, 0});
	}

	public ToaProperties mr(float[] mr) {
		this.MR = mr;
		this.presentStats.add((byte) 10);
		return this;
	}

	public ToaProperties mr(float mr) {
		return mr(new float[]{mr, 0});
	}


	public ToaProperties mf(float[] mf) {
		this.MF = mf;
		this.presentStats.add((byte) 11);
		return this;
	}

	public ToaProperties mf(float mf) {
		return mf(new float[]{mf, 0});
	}

	public ToaProperties minf(float[] minf) {
		this.MINF = minf;
		this.presentStats.add((byte) 12);
		return this;
	}

	public ToaProperties minf(float minf) {
		return minf(new float[]{minf, 0});
	}

}
