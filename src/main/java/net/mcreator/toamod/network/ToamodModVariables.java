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
import net.minecraft.world.item.ItemStack;
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
		ToamodMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		ToamodMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
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
			clone.skillCookingLvl = original.skillCookingLvl;
			clone.skillCookingXp = original.skillCookingXp;
			clone.skillCookingNeededXp = original.skillCookingNeededXp;
			clone.shieldAmountMax = original.shieldAmountMax;
			clone.outOfCombat = original.outOfCombat;
			clone.shieldLvl = original.shieldLvl;
			clone.skillPoints = original.skillPoints;
			clone.unlockedSkillTree = original.unlockedSkillTree;
			clone.currentRegion = original.currentRegion;
			clone.attackDamage = original.attackDamage;
			clone.armor = original.armor;
			clone.magicResistance = original.magicResistance;
			clone.critRate = original.critRate;
			clone.critDmg = original.critDmg;
			clone.maxMana = original.maxMana;
			clone.totalOresMined = original.totalOresMined;
			clone.horseLvl = original.horseLvl;
			clone.horseMSCorNeeded = original.horseMSCorNeeded;
			clone.horseMoveSpeed = original.horseMoveSpeed;
			clone.horseColor = original.horseColor;
			clone.horsePattern = original.horsePattern;
			clone.miningMilestoneLvl = original.miningMilestoneLvl;
			clone.miningMilestoneOresNeeded = original.miningMilestoneOresNeeded;
			clone.miningMilestoneProgress = original.miningMilestoneProgress;
			clone.minMilNextLvl = original.minMilNextLvl;
			clone.MinMilestoneRewardsClaimed = original.MinMilestoneRewardsClaimed;
			clone.totalMobsKilled = original.totalMobsKilled;
			clone.combatMilestoneLvl = original.combatMilestoneLvl;
			clone.combatMilestoneKillsNeeded = original.combatMilestoneKillsNeeded;
			clone.combatMilestoneProgress = original.combatMilestoneProgress;
			clone.comMilNextLvl = original.comMilNextLvl;
			clone.comMilestoneRewardsClaimed = original.comMilestoneRewardsClaimed;
			clone.guiBlockX = original.guiBlockX;
			clone.guiBlockY = original.guiBlockY;
			clone.guiBlockZ = original.guiBlockZ;
			clone.maxHealth = original.maxHealth;
			clone.currentHealth = original.currentHealth;
			clone.magicPower = original.magicPower;
			clone.bonusCor = original.bonusCor;
			clone.bonusMD = original.bonusMD;
			clone.bonusCombatXp = original.bonusCombatXp;
			clone.bonusMiningXp = original.bonusMiningXp;
			clone.bonusMagicXp = original.bonusMagicXp;
			clone.magicFind = original.magicFind;
			clone.miningFortune = original.miningFortune;
			clone.bonusCookingXp = original.bonusCookingXp;
			clone.IllfangRNGXp = original.IllfangRNGXp;
			clone.IllfangRNGSelected = original.IllfangRNGSelected;
			clone.artefacts = original.artefacts;
			clone.plyRecWeapons = original.plyRecWeapons;
			clone.plyRecArmor = original.plyRecArmor;
			clone.plyRecArtefacts = original.plyRecArtefacts;
			clone.plyRecEnchants = original.plyRecEnchants;
			clone.plyRecMaterials = original.plyRecMaterials;
			clone.paramItem = original.paramItem;
			clone.openRecGui = original.openRecGui;
			clone.Vitality = original.Vitality;
			clone.empheiasSoulFound = original.empheiasSoulFound;
			clone.merchSlotsUnlocked = original.merchSlotsUnlocked;
			clone.merchMythicRScrolls = original.merchMythicRScrolls;
			clone.lifeSteal = original.lifeSteal;
			clone.fraction = original.fraction;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					ToamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					ToamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					ToamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "toamod_worldvars";
		public double maxEmpheiasSoul = 15.0;
		public double difficulty = 0;
		public double gameStartStage = 0;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			maxEmpheiasSoul = nbt.getDouble("maxEmpheiasSoul");
			difficulty = nbt.getDouble("difficulty");
			gameStartStage = nbt.getDouble("gameStartStage");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("maxEmpheiasSoul", maxEmpheiasSoul);
			nbt.putDouble("difficulty", difficulty);
			nbt.putDouble("gameStartStage", gameStartStage);
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
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
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
		public double cor = 10000.0;
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
		public double skillMagicNeededXp = 0.0;
		public String playerRecipes = "\"\"";
		public double skillCookingLvl = 0;
		public double skillCookingXp = 0;
		public double skillCookingNeededXp = 0;
		public double shieldAmountMax = 0;
		public boolean outOfCombat = true;
		public double shieldLvl = 0;
		public double skillPoints = 0.0;
		public String unlockedSkillTree = "\"\"";
		public double currentRegion = 0;
		public double attackDamage = 0.0;
		public double armor = 18.0;
		public double magicResistance = 18.0;
		public double critRate = 5.0;
		public double critDmg = 50.0;
		public double maxMana = 100.0;
		public double totalOresMined = 0.0;
		public double horseLvl = 0.0;
		public double horseMSCorNeeded = 1.0;
		public double horseMoveSpeed = 0.202;
		public double horseColor = 0.0;
		public double horsePattern = 0;
		public double miningMilestoneLvl = 0.0;
		public double miningMilestoneOresNeeded = 20.0;
		public double miningMilestoneProgress = 0.0;
		public double minMilNextLvl = 1.0;
		public double MinMilestoneRewardsClaimed = 0;
		public double totalMobsKilled = 0;
		public double combatMilestoneLvl = 0.0;
		public double combatMilestoneKillsNeeded = 30.0;
		public double combatMilestoneProgress = 0.0;
		public double comMilNextLvl = 1.0;
		public double comMilestoneRewardsClaimed = 0.0;
		public double guiBlockX = 0;
		public double guiBlockY = 0;
		public double guiBlockZ = 0;
		public double maxHealth = 100.0;
		public double currentHealth = 100.0;
		public double magicPower = 0;
		public double bonusCor = 0;
		public double bonusMD = 0;
		public double bonusCombatXp = 0.0;
		public double bonusMiningXp = 0.0;
		public double bonusMagicXp = 0.0;
		public double magicFind = 0.0;
		public double miningFortune = 0.0;
		public double bonusCookingXp = 0.0;
		public double IllfangRNGXp = 0;
		public String IllfangRNGSelected = "\"\"";
		public ItemStack artefacts = ItemStack.EMPTY;
		public ItemStack plyRecWeapons = ItemStack.EMPTY;
		public ItemStack plyRecArmor = ItemStack.EMPTY;
		public ItemStack plyRecArtefacts = ItemStack.EMPTY;
		public ItemStack plyRecEnchants = ItemStack.EMPTY;
		public ItemStack plyRecMaterials = ItemStack.EMPTY;
		public ItemStack paramItem = ItemStack.EMPTY;
		public String openRecGui = "\"\"";
		public double Vitality = 0.0;
		public double empheiasSoulFound = 0.0;
		public double merchSlotsUnlocked = 6.0;
		public double merchMythicRScrolls = 0.0;
		public double lifeSteal = 0;
		public String fraction = "\"\"";

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
			nbt.putDouble("skillCookingLvl", skillCookingLvl);
			nbt.putDouble("skillCookingXp", skillCookingXp);
			nbt.putDouble("skillCookingNeededXp", skillCookingNeededXp);
			nbt.putDouble("shieldAmountMax", shieldAmountMax);
			nbt.putBoolean("outOfCombat", outOfCombat);
			nbt.putDouble("shieldLvl", shieldLvl);
			nbt.putDouble("skillPoints", skillPoints);
			nbt.putString("unlockedSkillTree", unlockedSkillTree);
			nbt.putDouble("currentRegion", currentRegion);
			nbt.putDouble("attackDamage", attackDamage);
			nbt.putDouble("armor", armor);
			nbt.putDouble("magicResistance", magicResistance);
			nbt.putDouble("critRate", critRate);
			nbt.putDouble("critDmg", critDmg);
			nbt.putDouble("maxMana", maxMana);
			nbt.putDouble("totalOresMined", totalOresMined);
			nbt.putDouble("horseLvl", horseLvl);
			nbt.putDouble("horseMSCorNeeded", horseMSCorNeeded);
			nbt.putDouble("horseMoveSpeed", horseMoveSpeed);
			nbt.putDouble("horseColor", horseColor);
			nbt.putDouble("horsePattern", horsePattern);
			nbt.putDouble("miningMilestoneLvl", miningMilestoneLvl);
			nbt.putDouble("miningMilestoneOresNeeded", miningMilestoneOresNeeded);
			nbt.putDouble("miningMilestoneProgress", miningMilestoneProgress);
			nbt.putDouble("minMilNextLvl", minMilNextLvl);
			nbt.putDouble("MinMilestoneRewardsClaimed", MinMilestoneRewardsClaimed);
			nbt.putDouble("totalMobsKilled", totalMobsKilled);
			nbt.putDouble("combatMilestoneLvl", combatMilestoneLvl);
			nbt.putDouble("combatMilestoneKillsNeeded", combatMilestoneKillsNeeded);
			nbt.putDouble("combatMilestoneProgress", combatMilestoneProgress);
			nbt.putDouble("comMilNextLvl", comMilNextLvl);
			nbt.putDouble("comMilestoneRewardsClaimed", comMilestoneRewardsClaimed);
			nbt.putDouble("guiBlockX", guiBlockX);
			nbt.putDouble("guiBlockY", guiBlockY);
			nbt.putDouble("guiBlockZ", guiBlockZ);
			nbt.putDouble("maxHealth", maxHealth);
			nbt.putDouble("currentHealth", currentHealth);
			nbt.putDouble("magicPower", magicPower);
			nbt.putDouble("bonusCor", bonusCor);
			nbt.putDouble("bonusMD", bonusMD);
			nbt.putDouble("bonusCombatXp", bonusCombatXp);
			nbt.putDouble("bonusMiningXp", bonusMiningXp);
			nbt.putDouble("bonusMagicXp", bonusMagicXp);
			nbt.putDouble("magicFind", magicFind);
			nbt.putDouble("miningFortune", miningFortune);
			nbt.putDouble("bonusCookingXp", bonusCookingXp);
			nbt.putDouble("IllfangRNGXp", IllfangRNGXp);
			nbt.putString("IllfangRNGSelected", IllfangRNGSelected);
			nbt.put("artefacts", artefacts.save(new CompoundTag()));
			nbt.put("plyRecWeapons", plyRecWeapons.save(new CompoundTag()));
			nbt.put("plyRecArmor", plyRecArmor.save(new CompoundTag()));
			nbt.put("plyRecArtefacts", plyRecArtefacts.save(new CompoundTag()));
			nbt.put("plyRecEnchants", plyRecEnchants.save(new CompoundTag()));
			nbt.put("plyRecMaterials", plyRecMaterials.save(new CompoundTag()));
			nbt.put("paramItem", paramItem.save(new CompoundTag()));
			nbt.putString("openRecGui", openRecGui);
			nbt.putDouble("Vitality", Vitality);
			nbt.putDouble("empheiasSoulFound", empheiasSoulFound);
			nbt.putDouble("merchSlotsUnlocked", merchSlotsUnlocked);
			nbt.putDouble("merchMythicRScrolls", merchMythicRScrolls);
			nbt.putDouble("lifeSteal", lifeSteal);
			nbt.putString("fraction", fraction);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
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
			skillCookingLvl = nbt.getDouble("skillCookingLvl");
			skillCookingXp = nbt.getDouble("skillCookingXp");
			skillCookingNeededXp = nbt.getDouble("skillCookingNeededXp");
			shieldAmountMax = nbt.getDouble("shieldAmountMax");
			outOfCombat = nbt.getBoolean("outOfCombat");
			shieldLvl = nbt.getDouble("shieldLvl");
			skillPoints = nbt.getDouble("skillPoints");
			unlockedSkillTree = nbt.getString("unlockedSkillTree");
			currentRegion = nbt.getDouble("currentRegion");
			attackDamage = nbt.getDouble("attackDamage");
			armor = nbt.getDouble("armor");
			magicResistance = nbt.getDouble("magicResistance");
			critRate = nbt.getDouble("critRate");
			critDmg = nbt.getDouble("critDmg");
			maxMana = nbt.getDouble("maxMana");
			totalOresMined = nbt.getDouble("totalOresMined");
			horseLvl = nbt.getDouble("horseLvl");
			horseMSCorNeeded = nbt.getDouble("horseMSCorNeeded");
			horseMoveSpeed = nbt.getDouble("horseMoveSpeed");
			horseColor = nbt.getDouble("horseColor");
			horsePattern = nbt.getDouble("horsePattern");
			miningMilestoneLvl = nbt.getDouble("miningMilestoneLvl");
			miningMilestoneOresNeeded = nbt.getDouble("miningMilestoneOresNeeded");
			miningMilestoneProgress = nbt.getDouble("miningMilestoneProgress");
			minMilNextLvl = nbt.getDouble("minMilNextLvl");
			MinMilestoneRewardsClaimed = nbt.getDouble("MinMilestoneRewardsClaimed");
			totalMobsKilled = nbt.getDouble("totalMobsKilled");
			combatMilestoneLvl = nbt.getDouble("combatMilestoneLvl");
			combatMilestoneKillsNeeded = nbt.getDouble("combatMilestoneKillsNeeded");
			combatMilestoneProgress = nbt.getDouble("combatMilestoneProgress");
			comMilNextLvl = nbt.getDouble("comMilNextLvl");
			comMilestoneRewardsClaimed = nbt.getDouble("comMilestoneRewardsClaimed");
			guiBlockX = nbt.getDouble("guiBlockX");
			guiBlockY = nbt.getDouble("guiBlockY");
			guiBlockZ = nbt.getDouble("guiBlockZ");
			maxHealth = nbt.getDouble("maxHealth");
			currentHealth = nbt.getDouble("currentHealth");
			magicPower = nbt.getDouble("magicPower");
			bonusCor = nbt.getDouble("bonusCor");
			bonusMD = nbt.getDouble("bonusMD");
			bonusCombatXp = nbt.getDouble("bonusCombatXp");
			bonusMiningXp = nbt.getDouble("bonusMiningXp");
			bonusMagicXp = nbt.getDouble("bonusMagicXp");
			magicFind = nbt.getDouble("magicFind");
			miningFortune = nbt.getDouble("miningFortune");
			bonusCookingXp = nbt.getDouble("bonusCookingXp");
			IllfangRNGXp = nbt.getDouble("IllfangRNGXp");
			IllfangRNGSelected = nbt.getString("IllfangRNGSelected");
			artefacts = ItemStack.of(nbt.getCompound("artefacts"));
			plyRecWeapons = ItemStack.of(nbt.getCompound("plyRecWeapons"));
			plyRecArmor = ItemStack.of(nbt.getCompound("plyRecArmor"));
			plyRecArtefacts = ItemStack.of(nbt.getCompound("plyRecArtefacts"));
			plyRecEnchants = ItemStack.of(nbt.getCompound("plyRecEnchants"));
			plyRecMaterials = ItemStack.of(nbt.getCompound("plyRecMaterials"));
			paramItem = ItemStack.of(nbt.getCompound("paramItem"));
			openRecGui = nbt.getString("openRecGui");
			Vitality = nbt.getDouble("Vitality");
			empheiasSoulFound = nbt.getDouble("empheiasSoulFound");
			merchSlotsUnlocked = nbt.getDouble("merchSlotsUnlocked");
			merchMythicRScrolls = nbt.getDouble("merchMythicRScrolls");
			lifeSteal = nbt.getDouble("lifeSteal");
			fraction = nbt.getString("fraction");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

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
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
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
					variables.skillCookingLvl = message.data.skillCookingLvl;
					variables.skillCookingXp = message.data.skillCookingXp;
					variables.skillCookingNeededXp = message.data.skillCookingNeededXp;
					variables.shieldAmountMax = message.data.shieldAmountMax;
					variables.outOfCombat = message.data.outOfCombat;
					variables.shieldLvl = message.data.shieldLvl;
					variables.skillPoints = message.data.skillPoints;
					variables.unlockedSkillTree = message.data.unlockedSkillTree;
					variables.currentRegion = message.data.currentRegion;
					variables.attackDamage = message.data.attackDamage;
					variables.armor = message.data.armor;
					variables.magicResistance = message.data.magicResistance;
					variables.critRate = message.data.critRate;
					variables.critDmg = message.data.critDmg;
					variables.maxMana = message.data.maxMana;
					variables.totalOresMined = message.data.totalOresMined;
					variables.horseLvl = message.data.horseLvl;
					variables.horseMSCorNeeded = message.data.horseMSCorNeeded;
					variables.horseMoveSpeed = message.data.horseMoveSpeed;
					variables.horseColor = message.data.horseColor;
					variables.horsePattern = message.data.horsePattern;
					variables.miningMilestoneLvl = message.data.miningMilestoneLvl;
					variables.miningMilestoneOresNeeded = message.data.miningMilestoneOresNeeded;
					variables.miningMilestoneProgress = message.data.miningMilestoneProgress;
					variables.minMilNextLvl = message.data.minMilNextLvl;
					variables.MinMilestoneRewardsClaimed = message.data.MinMilestoneRewardsClaimed;
					variables.totalMobsKilled = message.data.totalMobsKilled;
					variables.combatMilestoneLvl = message.data.combatMilestoneLvl;
					variables.combatMilestoneKillsNeeded = message.data.combatMilestoneKillsNeeded;
					variables.combatMilestoneProgress = message.data.combatMilestoneProgress;
					variables.comMilNextLvl = message.data.comMilNextLvl;
					variables.comMilestoneRewardsClaimed = message.data.comMilestoneRewardsClaimed;
					variables.guiBlockX = message.data.guiBlockX;
					variables.guiBlockY = message.data.guiBlockY;
					variables.guiBlockZ = message.data.guiBlockZ;
					variables.maxHealth = message.data.maxHealth;
					variables.currentHealth = message.data.currentHealth;
					variables.magicPower = message.data.magicPower;
					variables.bonusCor = message.data.bonusCor;
					variables.bonusMD = message.data.bonusMD;
					variables.bonusCombatXp = message.data.bonusCombatXp;
					variables.bonusMiningXp = message.data.bonusMiningXp;
					variables.bonusMagicXp = message.data.bonusMagicXp;
					variables.magicFind = message.data.magicFind;
					variables.miningFortune = message.data.miningFortune;
					variables.bonusCookingXp = message.data.bonusCookingXp;
					variables.IllfangRNGXp = message.data.IllfangRNGXp;
					variables.IllfangRNGSelected = message.data.IllfangRNGSelected;
					variables.artefacts = message.data.artefacts;
					variables.plyRecWeapons = message.data.plyRecWeapons;
					variables.plyRecArmor = message.data.plyRecArmor;
					variables.plyRecArtefacts = message.data.plyRecArtefacts;
					variables.plyRecEnchants = message.data.plyRecEnchants;
					variables.plyRecMaterials = message.data.plyRecMaterials;
					variables.paramItem = message.data.paramItem;
					variables.openRecGui = message.data.openRecGui;
					variables.Vitality = message.data.Vitality;
					variables.empheiasSoulFound = message.data.empheiasSoulFound;
					variables.merchSlotsUnlocked = message.data.merchSlotsUnlocked;
					variables.merchMythicRScrolls = message.data.merchMythicRScrolls;
					variables.lifeSteal = message.data.lifeSteal;
					variables.fraction = message.data.fraction;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
