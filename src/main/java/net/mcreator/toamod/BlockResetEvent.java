package net.mcreator.toamod;

import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;
import net.minecraft.world.entity.player.Player;

@Cancelable
public class BlockResetEvent extends Event {
    //private final Player player;

    public BlockResetEvent(/*Player player*/) {
        //this.player = player;
    }

	/*
    public Player getPlayer() {
        return player;
    }
	*/
}