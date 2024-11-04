package net.mcreator.toamod.block.entity;

import org.jetbrains.annotations.NotNull;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.Containers;
import net.minecraft.world.ContainerHelper;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.world.inventory.BlacksmithTableGuiMenu;
import net.mcreator.toamod.jei_recipes.BlacksmithTableTypeRecipe;
import net.mcreator.toamod.init.ToamodModBlockEntities;

import javax.annotation.Nullable;

import java.util.stream.IntStream;
import java.util.Optional;

public class BlacksmithTableBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(10, ItemStack.EMPTY);
	//private ItemStackHandler itemHandler = new ItemStackHandler(10);
	private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
	private byte tickCount = 0;

	public BlacksmithTableBlockEntity(BlockPos position, BlockState state) {
		super(ToamodModBlockEntities.BLACKSMITH_TABLE.get(), position, state);
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == ForgeCapabilities.ITEM_HANDLER)
			return lazyItemHandler.cast();
		return super.getCapability(cap, side);
	}

	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		lazyItemHandler.invalidate();
	}

	public void drops() {
		SimpleContainer inventory = new SimpleContainer(stacks.size());
		for (int i = 1; i < stacks.size(); i++) {
			inventory.setItem(i, stacks.get(i));
		}
		Containers.dropContents(this.level, this.worldPosition, inventory);
	}

	@Override
	public Component getDisplayName() {
		return Component.literal("Blacksmith Table");
	}

	@Override
	public Component getDefaultName() {
		return Component.literal("Blacksmith Table");
	}


	@Override
	protected void saveAdditional(CompoundTag pTag) {
		System.out.println("Save additional - try saving stacks");
		ContainerHelper.saveAllItems(pTag, this.stacks);
		
		super.saveAdditional(pTag);
	}

	@Override
	public void load(CompoundTag pTag) {
		super.load(pTag);
		this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(pTag, this.stacks);
	}


	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithFullMetadata();
	}

	@Override
	public int getContainerSize() {
		return stacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stacks)
			if (!itemstack.isEmpty())
				return false;
		return true;
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		if (index == 0)
			return false;
		return true;
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
		return this.canPlaceItem(index, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		return true;
	}

	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory) {
		return new BlacksmithTableGuiMenu(pContainerId, pPlayerInventory, this);
	}

	public void tick() {
		tickCount++;
		System.out.println("tick");
		if (tickCount == 2) {
			Optional<BlacksmithTableTypeRecipe> recipe = getCurrentRecipe();
			System.out.println("test for has recipe");
			if (hasRecipe(recipe)) {
				if (stacks.get(0) == ItemStack.EMPTY) {
					ItemStack result = recipe.get().getResultItem(null);
					System.out.print("set result in output");
					this.stacks.set(0, new ItemStack(result.getItem(), result.getCount()));
				}
			} else
				this.stacks.set(0, ItemStack.EMPTY);
			tickCount = 0;
		}
	}

	public boolean hasRecipe() {
		Optional<BlacksmithTableTypeRecipe> recipe = getCurrentRecipe();
		return recipe.isEmpty();
	}

	public boolean hasRecipe(Optional<BlacksmithTableTypeRecipe> recipe) {
		return !recipe.isEmpty();
	}

	private Optional<BlacksmithTableTypeRecipe> getCurrentRecipe() {
		SimpleContainer inventory = new SimpleContainer(this.stacks.size());
		for (int i = 1; i < stacks.size(); i++) {
			System.out.println("	found Item in slot: " + i + " : " + stacks.get(i).getItem());
			inventory.setItem(i, stacks.get(i));
		}
		return this.level.getRecipeManager().getRecipeFor(BlacksmithTableTypeRecipe.Type.INSTANCE, inventory, level);
	}

	public void extractItemsFromCrafting() {
		for (int i = 1; i < stacks.size(); i++) {
			this.stacks.get(i).shrink(1);
		}
	}
}
