package net.mcreator.toamod;

import org.checkerframework.checker.units.qual.cd;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

public class ToaProperties {
	public ToaRarity rarity;
	public String type, subType;
	/*stats for the weapon in format {flat, percentage}
	     ReforgyType uses {rarity=0, rarity=1, ...., rarity=6}*/
	public float[] STR, DEX, CON, INT, WIS, CR, CD, LIFESTEAL, HP, AR, MR, MF, MINF;
	public ToaElement ELEMENT;
	public float[] ELEMENTAL_DAMAGE;

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
		rune.getProperties().applyV2PropertiesToItem(item, item.getOrCreateTag().getInt("rarity"));
	}

	/**
	 * V2 Properties are the ToaProperties of Reforges or Runes which have longer float[] for the stat they grant based on a rarity
	 */
	private void applyV2PropertiesToItem(ItemStack item, int rarity) {
		if (!(item.getItem() instanceof ToaReforgeable))
			return;
		CompoundTag nbt = item.getOrCreateTag();
		CompoundTag itemStats = nbt.getCompound("Stats");
		if (STR != null)
			itemStats.putFloat("str_f", itemStats.getFloat("str_f") + STR[rarity]);
		if (DEX != null)
			itemStats.putFloat("dex_f", itemStats.getFloat("dex_f") + DEX[rarity]);
		if (CON != null)
			itemStats.putFloat("con_f", itemStats.getFloat("con_f") + CON[rarity]);
		if (INT != null)
			itemStats.putFloat("int_f", itemStats.getFloat("int_f") + INT[rarity]);
		if (WIS != null)
			itemStats.putFloat("wis_f", itemStats.getFloat("wis_f") + WIS[rarity]);
		if (CR != null)
			itemStats.putFloat("cr", itemStats.getFloat("cr") + CR[rarity]);
		if (CD != null)
			itemStats.putFloat("cd", itemStats.getFloat("cd") + CD[rarity]);
		if (LIFESTEAL != null)
			itemStats.putFloat("lifesteal", itemStats.getFloat("lifesteal") + LIFESTEAL[rarity]);
		if (HP != null)
			itemStats.putFloat("hp_f", itemStats.getFloat("hp_f") + HP[rarity]);
		if (AR != null)
			itemStats.putFloat("ar_f", itemStats.getFloat("ar_f") + AR[rarity]);
		if (MR != null)
			itemStats.putFloat("mr_f", itemStats.getFloat("mr_f") + MR[rarity]);
		if (MF != null)
			itemStats.putFloat("mf_f", itemStats.getFloat("mf_f") + MF[rarity]);
		if (MINF != null)
			itemStats.putFloat("minf_f", itemStats.getFloat("minf_f") + MINF[rarity]);
		nbt.put("Stats", itemStats);
	}

	public ToaProperties subType(String subType) {
		this.subType = subType;
		return this;
	}

	public ToaProperties str(float[] _str) {
		this.STR = _str;
		return this;
	}

	public ToaProperties str(float _str) {
		this.STR = new float[]{_str, 0};
		return this;
	}

	public ToaProperties dex(float[] _dex) {
		this.DEX = _dex;
		return this;
	}

	public ToaProperties dex(float _dex) {
		this.DEX = new float[]{_dex, 0};
		return this;
	}

	public ToaProperties con(float[] _con) {
		this.CON = _con;
		return this;
	}

	public ToaProperties con(float _con) {
		this.CON = new float[]{_con, 0};
		return this;
	}

	public ToaProperties _int(float[] _int) {
		this.INT = _int;
		return this;
	}

	public ToaProperties _int(float _int) {
		this.INT = new float[]{_int, 0};
		return this;
	}

	public ToaProperties wis(float[] _wis) {
		this.WIS = _wis;
		return this;
	}

	public ToaProperties wis(float _wis) {
		this.WIS = new float[]{_wis, 0};;
		return this;
	}

	public ToaProperties cr(float cr) {
		this.CR = new float[]{cr};
		return this;
	}

	/**
	 * ONLY used by ReforgeType-class
	 */
	public ToaProperties cr(float[] cr) {
		this.CR = cr;
		return this;
	}

	public ToaProperties cd(float cd) {
		this.CD = new float[]{cd};
		return this;
	}

	/**
	 * ONLY used by ReforgeType-class
	 */
	public ToaProperties cd(float[] cd) {
		this.CD = cd;
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
		this.LIFESTEAL = new float[]{lifesteal};
		return this;
	}

	/**
	 * ONLY used by ReforgeType-class
	 */
	public ToaProperties lifesteal(float[] lifesteal) {
		this.LIFESTEAL = lifesteal;
		return this;
	}

	public ToaProperties hp(float[] hp) {
		this.HP = hp;
		return this;
	}

	public ToaProperties hp(float hp) {
		this.HP = new float[]{hp, 0};
		return this;
	}

	public ToaProperties mf(float[] mf) {
		this.MF = mf;
		return this;
	}

	public ToaProperties mf(float mf) {
		this.MF = new float[]{mf, 0};
		return this;
	}

	public ToaProperties minf(float[] minf) {
		this.MINF = minf;
		return this;
	}

	public ToaProperties minf(float minf) {
		this.MINF = new float[]{minf, 0};
		return this;
	}

	public ToaProperties ar(float[] ar) {
		this.AR = ar;
		return this;
	}

	public ToaProperties ar(float ar) {
		this.AR = new float[]{ar, 0};
		return this;
	}

	public ToaProperties mr(float[] mr) {
		this.MR = mr;
		return this;
	}

	public ToaProperties mr(float mr) {
		this.MR = new float[]{mr, 0};
		return this;
	}
}
