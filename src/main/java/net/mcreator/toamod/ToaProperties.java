package net.mcreator.toamod;

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
	public String ELEMENT;
	public float[] ELEMENTAL_DAMAGE;
	public float LIFESTEAL;
	public float[] HP;

	ToaProperties(String type, ToaRarity rarity){
		this.type = type;
		this.rarity = rarity;
	}

	ToaProperties(String type, ToaRarity rarity, String subType, float[] _str, float[] _dex,float[] _con,float[] _int,float[] _wis, float _cr, float _cd, String element, float[] elemental_damage, float lifesteal, float[] _hp){
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

	public ToaProperties withSubType(String subType){
		this.subType = subType;
		return this;
	}

	public ToaProperties withStr(float[] _str){
		this.STR = _str;
		return this;
	}

	public ToaProperties withStr(float _str){
		this.STR = new float[] {_str, 0};
		return this;
	}

	public ToaProperties withDex(float[] _dex){
		this.DEX = _dex;
		return this;
	}

	public ToaProperties withDex(float _dex){
		this.DEX = new float[] {_dex, 0};
		return this;
	}
	
	public ToaProperties withCon(float[] _con){
		this.CON = _con;
		return this;
	}

	public ToaProperties withCon(float _con){
		this.CON = new float[] {_con, 0};
		return this;
	}

	public ToaProperties withInt(float[] _int){
		this.INT = _int;
		return this;
	}

	public ToaProperties withInt(float _int){
		this.INT = new float[] {_int, 0};
		return this;
	}

	public ToaProperties withWis(float[] _wis){
		this.WIS = _wis;
		return this;
	}

	public ToaProperties withWisdom(float _wis){
		this.WIS = new float[] {_wis, 0};;
		return this;
	}

	public ToaProperties withCr(float cr){
		this.CR = cr;
		return this;
	}

	public ToaProperties withCd(float cd){
		this.CD = cd;
		return this;
	}

	public ToaProperties withElement(String element, float[] elemental_damage){
		this.ELEMENT = element;
		this.ELEMENTAL_DAMAGE = elemental_damage;
		return this;
	}

	public ToaProperties withLifesteal(float lifesteal){
		this.LIFESTEAL = lifesteal;
		return this;
	}

	public ToaProperties withHP(float[] hp){
		this.HP = hp;
		return this;
	}

	public ToaProperties withHP(float hp){
		this.HP = new float[] {hp, 0};
		return this;
	}
}

