package net.mcreator.toamod.block.entity;

import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.world.inventory.BlacksmithTableGuiMenu;
import net.mcreator.toamod.jei_recipes.BlacksmithTableTypeRecipe;
import net.mcreator.toamod.init.ToamodModBlockEntities;
import net.mcreator.toamod.CustomNbtHandler;

import javax.annotation.Nullable;

import java.util.stream.IntStream;
import java.util.Optional;

import io.netty.buffer.Unpooled;

public class BlacksmithTableBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(10, ItemStack.EMPTY);
	private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

	public BlacksmithTableBlockEntity(BlockPos position, BlockState state) {
		super(ToamodModBlockEntities.BLACKSMITH_TABLE.get(), position, state);
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks);
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.stacks);
		}
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
	public Component getDefaultName() {
		return Component.literal("blacksmith_table");
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new BlacksmithTableGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
	}

	@Override
	public Component getDisplayName() {
		return Component.literal("Blacksmith Table");
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
		if (index == 1)
			return false;
		if (index == 2)
			return false;
		if (index == 3)
			return false;
		if (index == 4)
			return false;
		if (index == 5)
			return false;
		if (index == 6)
			return false;
		if (index == 7)
			return false;
		if (index == 8)
			return false;
		if (index == 9)
			return false;
		return true;
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
		if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER)
			return handlers[facing.ordinal()].cast();
		return super.getCapability(capability, facing);
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		for (LazyOptional<? extends IItemHandler> handler : handlers)
			handler.invalidate();
	}

	public void refreshRecipe() {
		if(this.level.isClientSide())
			return;
		System.out.println("BT-BlockEntity - refreshRecipe called");
		Optional<BlacksmithTableTypeRecipe> recipe = getCurrentRecipe();
		if (!hasRecipe(recipe))
{
			System.out.println("BT-BlockEntity - has no valid recipe");
			if(!this.stacks.get(0).isEmpty())
				this.stacks.set(0, ItemStack.EMPTY);
			return;
		}
		System.out.println("Valid recipe found -> set Item in output slot");
		ItemStack result = recipe.get().getResultItem();
		if(recipe.get().getHasNbt()){
			System.out.println("Recipe has Nbt -> call methods");
			CustomNbtHandler.applyItemBaseStats(result);
			if(recipe.get().getCopyNbtFromSlot() > 0){
				System.out.println("Recipe has NbtCopy -> call copyUpgrades");
				CustomNbtHandler.copyUpgrades(this.stacks.get(recipe.get().getCopyNbtFromSlot()), result);
			}
			CustomNbtHandler.setLoreOfItem(result);
		}
		this.stacks.set(0, result);
	}

	public boolean hasRecipe() {
		Optional<BlacksmithTableTypeRecipe> recipe = getCurrentRecipe();
		return !recipe.isEmpty();
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
