package net.mcreator.toamod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.world.inventory.ChestNormalGuiMenu;
import net.mcreator.toamod.world.inventory.ChestLegendaryGuiMenu;
import net.mcreator.toamod.world.inventory.ChestEpicGuiMenu;
import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.init.ToamodModBlocks;

import java.util.concurrent.atomic.AtomicReference;

import io.netty.buffer.Unpooled;

public class ChestRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(x, y, z), "locked")) {
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (blockstate.getBlock() == ToamodModBlocks.CHEST_NORMAL.get()
								&& itemstackiterator.getItem() == ToamodModItems.WOODEN_KEY.get()) {
							if (!world.isClientSide()) {
								BlockPos _bp = new BlockPos(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getTileData().putBoolean("locked", (false));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(ToamodModItems.WOODEN_KEY.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
										_player.inventoryMenu.getCraftSlots());
							}
							break;
						}
						if (blockstate.getBlock() == ToamodModBlocks.CHEST_EPIC.get()
								&& itemstackiterator.getItem() == ToamodModItems.SILVER_KEY.get()) {
							if (!world.isClientSide()) {
								BlockPos _bp = new BlockPos(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getTileData().putBoolean("locked", (false));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(ToamodModItems.SILVER_KEY.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
										_player.inventoryMenu.getCraftSlots());
							}
							break;
						}
						if (blockstate.getBlock() == ToamodModBlocks.CHEST_LEGENDARY.get()
								&& itemstackiterator.getItem() == ToamodModItems.GOLDEN_KEY.get()) {
							if (!world.isClientSide()) {
								BlockPos _bp = new BlockPos(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getTileData().putBoolean("locked", (false));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(ToamodModItems.GOLDEN_KEY.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
										_player.inventoryMenu.getCraftSlots());
							}
							break;
						}
					}
				}
			}
		}
		if (!(new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(x, y, z), "locked"))) {
			if (blockstate.getBlock() == ToamodModBlocks.CHEST_NORMAL.get()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.open")),
								SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.open")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = new BlockPos(x, y, z);
						NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return new TextComponent("ChestNormalGui");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new ChestNormalGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
			if (blockstate.getBlock() == ToamodModBlocks.CHEST_EPIC.get()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.open")),
								SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.open")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = new BlockPos(x, y, z);
						NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return new TextComponent("ChestEpicGui");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new ChestEpicGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
			if (blockstate.getBlock() == ToamodModBlocks.CHEST_LEGENDARY.get()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.open")),
								SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.open")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = new BlockPos(x, y, z);
						NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return new TextComponent("ChestLegendaryGui");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new ChestLegendaryGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		}
	}
}
