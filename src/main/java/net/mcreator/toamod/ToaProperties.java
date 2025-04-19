package net.mcreator.toamod;

import org.checkerframework.checker.units.qual.cd;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;

public class ToaProperties {
	public static final int statCount = 13; //Amount of different modifiable stats
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
	 * Sets all stats to the difference of the values at to different indexes as followed:  [firstIndex] - [secIndex]
	 * Mostly used to calc the stat increase of enchantments with levels, reforges with rarity or runes with rarity, etc...
	 * 
	 * @return Collects the difference and puts them into index 0. Now to add stats to an item just use addStatsToItem().
	 */
	/*public ToaProperties difference(int firstIndex, int secIndex){
		ToaProperties props = new ToaProperties();
		if(STR != null)
			props.STR[0] = STR[firstIndex] - STR[secIndex]; 
		if(DEX != null)
			props.DEX[0] = DEX[firstIndex] - DEX[secIndex]; 
		if(CON != null)
			props.CON[0] = CON[firstIndex] - CON[secIndex]; 
		if(INT != null)
			props.INT[0] = INT[firstIndex] - INT[secIndex]; 
		if(WIS != null)
			props.WIS[0] = WIS[firstIndex] - WIS[secIndex]; 
		if(ELEMENT != null)
			props.ELEMENTAL_DAMAGE[0] = ELEMENTAL_DAMAGE[firstIndex] - ELEMENTAL_DAMAGE[secIndex]; 
		if(HP != null)
			props.HP[0] = HP[firstIndex] - HP[secIndex]; 
		if(AR != null)
			props.AR[0] = AR[firstIndex] - AR[secIndex]; 
		if(MR != null)
			props.MR[0] = MR[firstIndex] - MR[secIndex]; 
		if(MF != null)
			props.MF[0] = MF[firstIndex] - MF[secIndex]; 
		if(MINF != null)
			props.MINF[0] = MINF[firstIndex] - MINF[secIndex]; 
		if(LIFESTEAL != null)
			props.LIFESTEAL[0] = LIFESTEAL[firstIndex] - LIFESTEAL[secIndex]; 
		if(CR != null)
			props.CR[0] = CR[firstIndex] - CR[secIndex]; 
		if(CD != null)
			props.CD[0] = CD[firstIndex] - CD[secIndex]; 
	}*/

	/**
	 * Collects all actual stats and combines them into an CompoundTag
	 * @return CompoundTag with ALL ACTUAL stats of the ToaProperty
	 */
	public CompoundTag statsToNbt() {
		CompoundTag nbt = new CompoundTag();
		if (STR != null) {
			if (STR[0] != 0)
				nbt.putFloat("str", STR[0]);
		}
		if (DEX != null) {
			if (DEX[0] != 0)
				nbt.putFloat("dex", DEX[0]);
		}
		if (CON != null) {
			if (CON[0] != 0)
				nbt.putFloat("con", CON[0]);
		}
		if (INT != null) {
			if (STR[0] != 0)
				nbt.putFloat("int", INT[0]);
		}
		if (WIS != null) {
			if (WIS[0] != 0)
				nbt.putFloat("wis", WIS[0]);
		}
		if (ELEMENT != null) {
			nbt.putString("element", ELEMENT.name);
			if (ELEMENTAL_DAMAGE[0] != 0)
				nbt.putFloat("elem_dmg", ELEMENTAL_DAMAGE[0]);
		}
		if (HP != null) {
			if (HP[0] != 0)
				nbt.putFloat("hp", HP[0]);
		}
		if (AR != null) {
			if (AR[0] != 0)
				nbt.putFloat("ar", AR[0]);
		}
		if (MR != null) {
			if (MR[0] != 0)
				nbt.putFloat("mr", MR[0]);
		}
		if (MF != null) {
			if (MF[0] != 0)
				nbt.putFloat("mf", MF[0]);
		}
		if (MINF != null) {
			if (MINF[0] != 0)
				nbt.putFloat("minf", MINF[0]);
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
	. The Properties should only have 1 array-entry per stat
	 * @return a new ToaProperties object with the multiplied flat-stats
	
	 */
	public ToaProperties multiplyAllFlat(float f) {
		ToaProperties newStats = (new ToaProperties(type, rarity)).subType(subType);
		if (STR != null)
			newStats.str(new float[]{STR[0] * f});
		if (DEX != null)
			newStats.dex(new float[]{DEX[0] * f});
		if (CON != null)
			newStats.con(new float[]{CON[0] * f});
		if (INT != null)
			newStats._int(new float[]{INT[0] * f});
		if (WIS != null)
			newStats.wis(new float[]{WIS[0] * f});
		if (CR != null)
			newStats.cr(new float[]{CR[0] * f});
		if (CD != null)
			newStats.cd(new float[]{CD[0] * f});
		if (ELEMENT != null)
			newStats.element(ELEMENT, new float[]{ELEMENTAL_DAMAGE[0] * f});
		if (LIFESTEAL != null)
			newStats.lifesteal(new float[]{LIFESTEAL[0] * f});
		if (HP != null)
			newStats.hp(new float[]{HP[0] * f});
		if (AR != null)
			newStats.ar(new float[]{AR[0] * f});
		if (MR != null)
			newStats.mr(new float[]{MR[0] * f});
		if (MF != null)
			newStats.mf(new float[]{MF[0] * f});
		if (MINF != null)
			newStats.minf(new float[]{MINF[0] * f});
		return newStats;
	}

	/**
	 * Adds the stat from this ToaProperties to stats in tag
	 * @param tag is the result of getOrCreateTag() method with all subTags
	 */
	public void addStatsToItem(ItemStack item) {
		CompoundTag nbt = item.getOrCreateTag().getCompound("Stats");
		if (STR != null) {
			nbt.putFloat("str", nbt.getFloat("str") + STR[0]);
		}
		if (DEX != null) {
			nbt.putFloat("dex", nbt.getFloat("dex") + DEX[0]);
		}
		if (CON != null) {
			nbt.putFloat("con", nbt.getFloat("str") + CON[0]);
		}
		if (INT != null) {
			nbt.putFloat("int", nbt.getFloat("int") + INT[0]);
		}
		if (WIS != null) {
			nbt.putFloat("wis", nbt.getFloat("wis") + WIS[0]);
		}
		if (CR != null) {
			nbt.putFloat("cr", nbt.getFloat("cr") + CR[0]);
		}
		if (CD != null) {
			nbt.putFloat("cd", nbt.getFloat("cd") + CD[0]);
		}
		if (ELEMENT != null && ELEMENT == ToaElement.getByName(nbt.getString("element"))) {
			nbt.putFloat("elem_dmg", nbt.getFloat("elem_dmg") + ELEMENTAL_DAMAGE[0]);
		}
		if (LIFESTEAL != null) {
			nbt.putFloat("lifesteal", nbt.getFloat("lifesteal") + LIFESTEAL[0]);
		}
		if (HP != null) {
			nbt.putFloat("hp", nbt.getFloat("hp") + HP[0]);
		}
		if (AR != null) {
			nbt.putFloat("ar", nbt.getFloat("ar") + AR[0]);
		}
		if (MR != null) {
			nbt.putFloat("mr", nbt.getFloat("mr") + MR[0]);
		}
		if (MF != null) {
			nbt.putFloat("mf", nbt.getFloat("mf") + MF[0]);
		}
		if (MINF != null) {
			nbt.putFloat("minf", nbt.getFloat("minf") + MINF[0]);
		}
		item.getOrCreateTag().put("Stats", nbt);
	}

	/**
	 * Used ONLY to apply the stats of a reforge to an item
	 */
	public static void applyEnchantToItem(ToaEnchantment ench, ItemStack item, int level, int f) {
		ench.stats.applyV2PropertiesToItem(item, level, f);
	}

	/**
	 * Used ONLY to apply the stats of a reforge to an item
	 */
	public static void applyReforgeToItem(ReforgeType reforge, ItemStack item, int f) {
		//V2 Properties are the ToaProperties of Reforges or Runes which have longer float[] for the stat they grant based on a rarity
		reforge.getProperties().applyV2PropertiesToItem(item, item.getOrCreateTag().getInt("rarity"), f);
	}

	/**
	 * Used ONLY to apply the stats of a rune to an item
	 * @param runeType of rune
	 * @param item to which the stats of the rune will be applied
	 * @param rarity of the rune
	 * @param 1: add ; -1 subtract
	 */
	public static void applyRuneToItem(RuneType rune, ItemStack item, int rarity, int f) {
		//V2 Properties are the ToaProperties of Reforges or Runes which have longer float[] for the stat they grant based on a rarity
		rune.getProperties().applyV2PropertiesToItem(item, rarity, f);
	}

	/**
	 * V2 Properties are the ToaProperties of Reforges, Runes or Enchants which have longer float[] for the stat they grant based on a rarity
	 * @param item the stats get applied to
	 * @param index of stat array of the stats
	 * @param factor applied stats get multiplied with -> 1: add ; -1: substract
	 */
	private void applyV2PropertiesToItem(ItemStack item, int index, int f) {
		if (!(item.getItem() instanceof ToaReforgeable))
			return;
		CompoundTag itemStats = item.getOrCreateTag().getCompound("Stats");
		if (STR != null)
			itemStats.putFloat("str", itemStats.getFloat("str") + STR[index] * f);
		if (DEX != null)
			itemStats.putFloat("dex", itemStats.getFloat("dex") + DEX[index] * f);
		if (CON != null)
			itemStats.putFloat("con", itemStats.getFloat("con") + CON[index] * f);
		if (INT != null)
			itemStats.putFloat("int", itemStats.getFloat("int") + INT[index] * f);
		if (WIS != null)
			itemStats.putFloat("wis", itemStats.getFloat("wis") + WIS[index] * f);
		if (CR != null)
			itemStats.putFloat("cr", itemStats.getFloat("cr") + CR[index] * f);
		if (CD != null)
			itemStats.putFloat("cd", itemStats.getFloat("cd") + CD[index] * f);
		if (LIFESTEAL != null)
			itemStats.putFloat("lifesteal", itemStats.getFloat("lifesteal") + LIFESTEAL[index] * f);
		if (HP != null)
			itemStats.putFloat("hp", itemStats.getFloat("hp") + HP[index] * f);
		if (AR != null)
			itemStats.putFloat("ar", itemStats.getFloat("ar") + AR[index] * f);
		if (MR != null)
			itemStats.putFloat("mr", itemStats.getFloat("mr") + MR[index] * f);
		if (MF != null)
			itemStats.putFloat("mf", itemStats.getFloat("mf") + MF[index] * f);
		if (MINF != null)
			itemStats.putFloat("minf", itemStats.getFloat("minf") + MINF[index] * f);
		item.getOrCreateTag().put("Stats", itemStats);
	}

	/**
	 * Makes copy of the present Ids so that an item's base stats won't get modified
	 */
	public ArrayList<Byte> getPresentIDs() {
		ArrayList<Byte> ids = new ArrayList<>();
		for (Byte b : this.presentStats) {
			ids.add(b);
		}
		return ids;
	}

	public float[] getValueByID(byte id) {
		return switch (id) {
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

	public static String getStatNameByID(byte id) {
		return switch (id) {
			case 0 -> "Strength";
			case 1 -> "Dexterity";
			case 2 -> "Consitution";
			case 3 -> "Intelligence";
			case 4 -> "Wisdom";
			case 5 -> "Crit Rate";
			case 6 -> "Crit Dmg";
			case 7 -> "Lifesteal";
			case 8 -> "Health";
			case 9 -> "Armor";
			case 10 -> "Magic Res";
			case 11 -> "Magic Find";
			case 12 -> "Mining Fortune";
			default -> null;
		};
	}

	public static String getStatTagNameByID(byte id) {
		return switch (id) {
			case 0 -> "str";
			case 1 -> "dex";
			case 2 -> "con";
			case 3 -> "int";
			case 4 -> "wis";
			case 5 -> "cr";
			case 6 -> "cd";
			case 7 -> "lifesteal";
			case 8 -> "hp";
			case 9 -> "ar";
			case 10 -> "mr";
			case 11 -> "mf";
			case 12 -> "minf";
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
		return str(new float[]{_str});
	}

	public ToaProperties dex(float[] _dex) {
		this.DEX = _dex;
		this.presentStats.add((byte) 1);
		return this;
	}

	public ToaProperties dex(float _dex) {
		return dex(new float[]{_dex});
	}

	public ToaProperties con(float[] _con) {
		this.CON = _con;
		this.presentStats.add((byte) 2);
		return this;
	}

	public ToaProperties con(float _con) {
		return con(new float[]{_con});
	}

	public ToaProperties _int(float[] _int) {
		this.INT = _int;
		this.presentStats.add((byte) 3);
		return this;
	}

	public ToaProperties _int(float _int) {
		return _int(new float[]{_int});
	}

	public ToaProperties wis(float[] _wis) {
		this.WIS = _wis;
		this.presentStats.add((byte) 4);
		return this;
	}

	public ToaProperties wis(float _wis) {
		return wis(new float[]{_wis});
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
		this.ELEMENTAL_DAMAGE = new float[]{elemental_damage};
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
		return hp(new float[]{hp});
	}

	public ToaProperties ar(float[] ar) {
		this.AR = ar;
		this.presentStats.add((byte) 9);
		return this;
	}

	public ToaProperties ar(float ar) {
		return ar(new float[]{ar});
	}

	public ToaProperties mr(float[] mr) {
		this.MR = mr;
		this.presentStats.add((byte) 10);
		return this;
	}

	public ToaProperties mr(float mr) {
		return mr(new float[]{mr});
	}

	public ToaProperties mf(float[] mf) {
		this.MF = mf;
		this.presentStats.add((byte) 11);
		return this;
	}

	public ToaProperties mf(float mf) {
		return mf(new float[]{mf});
	}

	public ToaProperties minf(float[] minf) {
		this.MINF = minf;
		this.presentStats.add((byte) 12);
		return this;
	}

	public ToaProperties minf(float minf) {
		return minf(new float[]{minf});
	}
}
