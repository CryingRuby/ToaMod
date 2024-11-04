package classes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.entity.NPCMerchantEntity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class ToaGameResetData {
	private ToaGameResetData() { //static class
	}

	public static class Pos {
		public final int x;
		public final int y;
		public final int z;

		public Pos(int _x, int _y, int _z) {
			this.x = _x;
			this.y = _y;
			this.z = _z;
		}
	}

	public static final Pos[] ChestPositions = {
			//Normal-Chests
			new Pos(1064, 80, -1512), new Pos(1028, 68, -1538), new Pos(1018, 68, -1512), new Pos(1039, 60, -1496), new Pos(1176, 69, -1419), new Pos(1203, 69, -1424), //replace in actual ToaWorld -> might change pos here
			new Pos(1181, 78, -1432), new Pos(1339, 65, -1572), new Pos(1021, 68, -1403), new Pos(1571, 126, -1689), new Pos(1666, 67, -1414), new Pos(1640, 70, -1335), new Pos(1640, 55, -1313), new Pos(1466, 68, -1415), new Pos(1386, 68, -1439),
			new Pos(1614, 99, -1141), new Pos(1717, 110, -944), new Pos(1481, 109, -905), new Pos(1404, 88, -906), new Pos(1436, 99, -932), new Pos(1412, 83, -833), new Pos(1385, 78, -885), new Pos(1400, 71, -938), new Pos(1351, 73, -951),
			new Pos(1353, 67, -949), new Pos(1436, 48, -866),
			//Epic-Chests
			new Pos(1026, 64, -1510), new Pos(1604, 69, -1498), new Pos(1603, 73, -1317), new Pos(1205, 127, -827), new Pos(1091, 67, -1111), new Pos(1411, 39, -927), new Pos(1409, 48, -867),
			//Legendary-Chests
			new Pos(1418, 57, -867)};
	public static final Pos[] ArtefactPositions = { //Artefacts + Souls
			//Artefacts
			new Pos(1423, 114, -930), new Pos(1359, 71, -952),
			//Souls
	};
	public static final Pos[] NPCPositions = {
			//new Pos(3, 12, 54),
	};

	public static void resetGameData(LevelAccessor world) {
		//Chests
		for (int i = 0; i < ChestPositions.length; i++) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(ChestPositions[i].x, ChestPositions[i].y, ChestPositions[i].z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("locked", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		//Artefacts+Souls
		for (int i = 0; i < ArtefactPositions.length; i++) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(ArtefactPositions[i].x, ArtefactPositions[i].y, ArtefactPositions[i].z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("collected", false);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		//NPCs

	}
}
