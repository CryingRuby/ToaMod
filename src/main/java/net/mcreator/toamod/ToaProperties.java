package net.mcreator.toamod;

import org.checkerframework.checker.units.qual.cd;

public class ToaProperties {
	public ToaRarity rarity;
	public String type;
	public String subType;
	//stats for the weapon in format {flat, percentage}
	public float[] STR;
	public float[] DEX;
	public float[] CON;
	public float[] INT;
	public float[] WIS;
	public float CR;
	public float CD;
	public ToaElement ELEMENT;
	public float[] ELEMENTAL_DAMAGE;
	public float LIFESTEAL;
	public float[] HP;
	public float[] MF;
	public float[] MINF;

	public ToaProperties(String type, ToaRarity rarity) {
		this.type = type;
		this.rarity = rarity;
	}

	public ToaProperties(String type, ToaRarity rarity, String subType, float[] _str, float[] _dex, float[] _con, float[] _int, float[] _wis, float _cr, float _cd, ToaElement element, float[] elemental_damage, float lifesteal, float[] _hp) {
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
		this.CR = cr;
		return this;
	}

	public ToaProperties cd(float cd) {
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
}
