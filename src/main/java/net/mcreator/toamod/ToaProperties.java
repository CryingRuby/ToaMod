package net.mcreator.toamod;

import org.checkerframework.checker.units.qual.cd;

import net.minecraft.nbt.CompoundTag;

import java.util.function.Function;
import java.util.Map;

public class ToaProperties {
	public ToaRarity rarity;
	public String type, subType;
	
	/*stats for the weapon in format {flat, percentage}         ReforgyType uses {rarity=0, rarity=1, ...., rarity=6}*/
	public float[] STR, DEX, CON, INT, WIS, CR, CD, LIFESTEAL, HP, AR, MR, MF, MINF;
	public ToaElement ELEMENT;
	public float[] ELEMENTAL_DAMAGE;

	public ToaProperties(String type, ToaRarity rarity) {
		this.type = type;
		this.rarity = rarity;
	}

/*
	public ToaProperties(String type, ToaRarity rarity, String subType, float[] _str, float[] _dex, float[] _con, float[] _int, float[] _wis, float[] _cr, float[] _cd, ToaElement element, float[] elemental_damage, float lifesteal, float[] _hp) {
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
	}*/

	/**
	 * Adds ALL general information about the ToaProperty like rarity and type to the CompoundTag.
	 * @param The CompoundTag of the item the general information will be added to
	 */
	public void addBaseInfoToNbt(CompoundTag nbt) {
		nbt.putInt("rarity", rarity.ID);
		nbt.putString("type", type);
		if (!subType.trim().isEmpty())
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
