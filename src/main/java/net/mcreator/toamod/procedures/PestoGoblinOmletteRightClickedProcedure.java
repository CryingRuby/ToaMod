package net.mcreator.toamod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;

import java.util.concurrent.atomic.AtomicReference;

public class PestoGoblinOmletteRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean hasGobOml = false;
		double gobEggCount = 0;
		double runeValue = 0;
		double runeRarity = 0;
		String runeType = "";
		String runeStatLoreTxt = "";
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "collected")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("msg.artefact.already_found").getString())), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		} else {
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (itemstackiterator.getItem() == ToamodModItems.GOBLIN_EGG.get()) {
							gobEggCount = gobEggCount + itemstackiterator.getCount();
						}
						if (itemstackiterator.getItem() == Blocks.PLAYER_WALL_HEAD.asItem() && ("goblin_omlette").equals(itemstackiterator.getOrCreateTag().getString("id"))) {
							runeValue = itemstackiterator.getOrCreateTag().getDouble("runeValue");
							runeRarity = itemstackiterator.getOrCreateTag().getDouble("runeRarity");
							runeType = itemstackiterator.getOrCreateTag().getString("runeType");
							hasGobOml = true;
							if (!("-").equals(runeType)) {
								if ("CR,CD".contains(runeType)) {
									runeStatLoreTxt = "'{\"text\":\"\u00A77" + "" + Component.translatable(("stat." + (runeType).toLowerCase())).getString() + ": \u00A7c+" + new java.text.DecimalFormat("##.##").format(runeValue) + "% \u00A7d("
											+ new java.text.DecimalFormat("##.##").format(runeValue) + ")\u00A7r\"}','{\"text\":\"\"}',";
								} else {
									runeStatLoreTxt = "'{\"text\":\"\u00A77" + "" + Component.translatable(("stat." + (runeType).toLowerCase())).getString() + ": \u00A7c+" + new java.text.DecimalFormat("##.##").format(runeValue) + " \u00A7d("
											+ new java.text.DecimalFormat("##.##").format(runeValue) + ")\u00A7r\"}','{\"text\":\"\"}',";
								}
							}
						}
					}
				}
			}
			if (hasGobOml && gobEggCount >= 4 && (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).cor >= 5000) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("give @s minecraft:player_head{forgeable:true,runeType:\"" + "" + runeType + "\"," + runeType + ":" + runeValue + ",runeRarity:" + new java.text.DecimalFormat("##").format(runeRarity) + ",runeValue:"
										+ new java.text.DecimalFormat("##").format(runeValue) + ",description:\"" + Component.translatable("item.artefact.pesto_goblin_omlette.description").getString()
										+ "\",rarity:1,type:\"Artefact\",id:\"pesto_goblin_omlette\",display:{Name:'{\"text\":\"\u00A7aPesto Goblin Omlette\u00A7r\"}',Lore:['{\"text\":\"\u00A77[Rune: "
										+ Component.translatable(("rarity.prefix." + new java.text.DecimalFormat("##").format(runeRarity))).getString() + runeType + "\u00A77]\u00A7r\"}','{\"text\":\"\"}'," + runeStatLoreTxt + "'{\"text\":\""
										+ Component.translatable("item.artefact.pesto_goblin_omlette.description").getString()
										+ "\"}','{\"text\":\"\"}','{\"text\":\"\u00A77Type: \u00A79Artefact\u00A7r\"}','{\"text\":\"\u00A77Rarity: \u00A7aUNCOMMAN\u00A7r\"}']},SkullOwner:{Id:[I;-2031468998,1730759421,-1623168604,2035669544],Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDRkMzY5ZTk4ZjlkYzY1YWU1M2VlN2NiNzgwYTc3YmU4NjU1MDUzOTAyNGUzYmY5ZTIwNjczZGRmZjU2MjgxNiJ9fX0=\"}]}}} 1"));
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "clear @s minecraft:player_head{id:\"goblin_omlette\"} 1");
					}
				}
				{
					double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).cor - 5000;
					entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.cor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(ToamodModItems.GOBLIN_EGG.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 4, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("msg.artefact.pesto_goblin_omlette.found").getString())), false);
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("collected", true);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("msg.artefact.missingReq").getString())), false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("\u00A78- \u00A771x \u00A7fGoblin Omlette\u00A7r").getString())), false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("\u00A78- \u00A774x \u00A7fGoblin Egg\u00A7r").getString())), false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("\u00A78- \u00A765000 Cor\u00A7r").getString())), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
	}
}
