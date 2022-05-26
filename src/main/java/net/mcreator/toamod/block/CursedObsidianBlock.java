
package net.mcreator.toamod.block;

import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.procedures.CursedObsidianDestroyedProcedure;

public class CursedObsidianBlock extends Block {
	public CursedObsidianBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(new ForgeSoundType(1.0f, 1.0f,
				() -> new SoundEvent(new ResourceLocation("block.basalt.break")), () -> new SoundEvent(new ResourceLocation("block.stone.step")),
				() -> new SoundEvent(new ResourceLocation("block.stone.place")), () -> new SoundEvent(new ResourceLocation("block.stone.hit")),
				() -> new SoundEvent(new ResourceLocation("block.stone.fall")))).strength(4.75f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		CursedObsidianDestroyedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}
