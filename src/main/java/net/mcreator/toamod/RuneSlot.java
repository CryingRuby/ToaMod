package net.mcreator.toamod;

import java.util.ArrayList;

public class RuneSlot {
	public ArrayList<RuneType> allowedRunes = new ArrayList<>();

	public RuneSlot(RuneType... allowedType) {
		ArrayList<RuneType> allowed = new ArrayList<>();
		for(RuneType type : allowedType){
			allowed.add(type);
		}
		this.allowedRunes = allowed;
	}

}