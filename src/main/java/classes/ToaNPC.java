package classes;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.EntityType;

public abstract class ToaNPC extends PathfinderMob {
	public Player TalkTo;

	protected ToaNPC(EntityType<? extends ToaNPC> type, Level level) {
		super(type, level);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		TalkTo = null;
	}
}
