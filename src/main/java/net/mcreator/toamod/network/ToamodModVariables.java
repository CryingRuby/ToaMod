package net.mcreator.toamod.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.toamod.ToamodMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ToamodModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ToamodMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new,
				SavedDataSyncMessage::handler);
		ToamodMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.level = original.level;
			clone.xp = original.xp;
			clone.neededxp = original.neededxp;
			clone.shieldAmount = original.shieldAmount;
			clone.cor = original.cor;
			clone.magicdust = original.magicdust;
			clone.bossesDefeated = original.bossesDefeated;
			clone.gamemaster = original.gamemaster;
			clone.skillAttackLvl = original.skillAttackLvl;
			clone.skillAttackXp = original.skillAttackXp;
			clone.skillAttackNeededXp = original.skillAttackNeededXp;
			clone.skillDefenseLvl = original.skillDefenseLvl;
			clone.skillDefenseXp = original.skillDefenseXp;
			clone.skillDefenseNeededXp = original.skillDefenseNeededXp;
			clone.skillMagicLvl = original.skillMagicLvl;
			clone.skillMagicXp = original.skillMagicXp;
			clone.skillMagicNeededXp = original.skillMagicNeededXp;
			clone.playerRecipes = original.playerRecipes;
			clone.bonusAbilityPower = original.bonusAbilityPower;
			clone.skillCookingLvl = original.skillCookingLvl;
			clone.skillCookingXp = original.skillCookingXp;
			clone.skillCookingNeededXp = original.skillCookingNeededXp;
			clone.kritChance = original.kritChance;
			clone.kritDamage = original.kritDamage;
			clone.shieldAmountMax = original.shieldAmountMax;
			clone.outOfCombat = original.outOfCombat;
			clone.shieldLvl = original.shieldLvl;
			clone.skillPoints = original.skillPoints;
			clone.unlockedSkillTree = original.unlockedSkillTree;
			clone.damageReduction = original.damageReduction;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getPlayer().level);
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (mapdata != null)
					ToamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()),
							new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					ToamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (worlddata != null)
					ToamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "toamod_worldvars";
		public boolean vanillaCrit = false;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			vanillaCrit = nbt.getBoolean("vanillaCrit");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("vanillaCrit", vanillaCrit);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				ToamodMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "toamod_mapvars";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				ToamodMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e),
						MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("toamod", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double level = 0.0;
		public double xp = 0.0;
		public double neededxp = 0.0;
		public double shieldAmount = 0.0;
		public double cor = 1000.0;
		public double magicdust = 15.0;
		public double bossesDefeated = 0.0;
		public boolean gamemaster = false;
		public double skillAttackLvl = 0.0;
		public double skillAttackXp = 0.0;
		public double skillAttackNeededXp = 25.0;
		public double skillDefenseLvl = 0.0;
		public double skillDefenseXp = 0.0;
		public double skillDefenseNeededXp = 25.0;
		public double skillMagicLvl = 0.0;
		public double skillMagicXp = 0.0;
		public double skillMagicNeededXp = 50.0;
		public String playerRecipes = "\"\"";
		public double bonusAbilityPower = 0;
		public double skillCookingLvl = 0;
		public double skillCookingXp = 0;
		public double skillCookingNeededXp = 0;
		public double kritChance = 15.0;
		public double kritDamage = 50.0;
		public double shieldAmountMax = 0;
		public boolean outOfCombat = false;
		public double shieldLvl = 0;
		public double skillPoints = 0.0;
		public String unlockedSkillTree = "\"\"";
		public double damageReduction = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				ToamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("level", level);
			nbt.putDouble("xp", xp);
			nbt.putDouble("neededxp", neededxp);
			nbt.putDouble("shieldAmount", shieldAmount);
			nbt.putDouble("cor", cor);
			nbt.putDouble("magicdust", magicdust);
			nbt.putDouble("bossesDefeated", bossesDefeated);
			nbt.putBoolean("gamemaster", gamemaster);
			nbt.putDouble("skillAttackLvl", skillAttackLvl);
			nbt.putDouble("skillAttackXp", skillAttackXp);
			nbt.putDouble("skillAttackNeededXp", skillAttackNeededXp);
			nbt.putDouble("skillDefenseLvl", skillDefenseLvl);
			nbt.putDouble("skillDefenseXp", skillDefenseXp);
			nbt.putDouble("skillDefenseNeededXp", skillDefenseNeededXp);
			nbt.putDouble("skillMagicLvl", skillMagicLvl);
			nbt.putDouble("skillMagicXp", skillMagicXp);
			nbt.putDouble("skillMagicNeededXp", skillMagicNeededXp);
			nbt.putString("playerRecipes", playerRecipes);
			nbt.putDouble("bonusAbilityPower", bonusAbilityPower);
			nbt.putDouble("skillCookingLvl", skillCookingLvl);
			nbt.putDouble("skillCookingXp", skillCookingXp);
			nbt.putDouble("skillCookingNeededXp", skillCookingNeededXp);
			nbt.putDouble("kritChance", kritChance);
			nbt.putDouble("kritDamage", kritDamage);
			nbt.putDouble("shieldAmountMax", shieldAmountMax);
			nbt.putBoolean("outOfCombat", outOfCombat);
			nbt.putDouble("shieldLvl", shieldLvl);
			nbt.putDouble("skillPoints", skillPoints);
			nbt.putString("unlockedSkillTree", unlockedSkillTree);
			nbt.putDouble("damageReduction", damageReduction);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			level = nbt.getDouble("level");
			xp = nbt.getDouble("xp");
			neededxp = nbt.getDouble("neededxp");
			shieldAmount = nbt.getDouble("shieldAmount");
			cor = nbt.getDouble("cor");
			magicdust = nbt.getDouble("magicdust");
			bossesDefeated = nbt.getDouble("bossesDefeated");
			gamemaster = nbt.getBoolean("gamemaster");
			skillAttackLvl = nbt.getDouble("skillAttackLvl");
			skillAttackXp = nbt.getDouble("skillAttackXp");
			skillAttackNeededXp = nbt.getDouble("skillAttackNeededXp");
			skillDefenseLvl = nbt.getDouble("skillDefenseLvl");
			skillDefenseXp = nbt.getDouble("skillDefenseXp");
			skillDefenseNeededXp = nbt.getDouble("skillDefenseNeededXp");
			skillMagicLvl = nbt.getDouble("skillMagicLvl");
			skillMagicXp = nbt.getDouble("skillMagicXp");
			skillMagicNeededXp = nbt.getDouble("skillMagicNeededXp");
			playerRecipes = nbt.getString("playerRecipes");
			bonusAbilityPower = nbt.getDouble("bonusAbilityPower");
			skillCookingLvl = nbt.getDouble("skillCookingLvl");
			skillCookingXp = nbt.getDouble("skillCookingXp");
			skillCookingNeededXp = nbt.getDouble("skillCookingNeededXp");
			kritChance = nbt.getDouble("kritChance");
			kritDamage = nbt.getDouble("kritDamage");
			shieldAmountMax = nbt.getDouble("shieldAmountMax");
			outOfCombat = nbt.getBoolean("outOfCombat");
			shieldLvl = nbt.getDouble("shieldLvl");
			skillPoints = nbt.getDouble("skillPoints");
			unlockedSkillTree = nbt.getString("unlockedSkillTree");
			damageReduction = nbt.getDouble("damageReduction");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.level = message.data.level;
					variables.xp = message.data.xp;
					variables.neededxp = message.data.neededxp;
					variables.shieldAmount = message.data.shieldAmount;
					variables.cor = message.data.cor;
					variables.magicdust = message.data.magicdust;
					variables.bossesDefeated = message.data.bossesDefeated;
					variables.gamemaster = message.data.gamemaster;
					variables.skillAttackLvl = message.data.skillAttackLvl;
					variables.skillAttackXp = message.data.skillAttackXp;
					variables.skillAttackNeededXp = message.data.skillAttackNeededXp;
					variables.skillDefenseLvl = message.data.skillDefenseLvl;
					variables.skillDefenseXp = message.data.skillDefenseXp;
					variables.skillDefenseNeededXp = message.data.skillDefenseNeededXp;
					variables.skillMagicLvl = message.data.skillMagicLvl;
					variables.skillMagicXp = message.data.skillMagicXp;
					variables.skillMagicNeededXp = message.data.skillMagicNeededXp;
					variables.playerRecipes = message.data.playerRecipes;
					variables.bonusAbilityPower = message.data.bonusAbilityPower;
					variables.skillCookingLvl = message.data.skillCookingLvl;
					variables.skillCookingXp = message.data.skillCookingXp;
					variables.skillCookingNeededXp = message.data.skillCookingNeededXp;
					variables.kritChance = message.data.kritChance;
					variables.kritDamage = message.data.kritDamage;
					variables.shieldAmountMax = message.data.shieldAmountMax;
					variables.outOfCombat = message.data.outOfCombat;
					variables.shieldLvl = message.data.shieldLvl;
					variables.skillPoints = message.data.skillPoints;
					variables.unlockedSkillTree = message.data.unlockedSkillTree;
					variables.damageReduction = message.data.damageReduction;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
