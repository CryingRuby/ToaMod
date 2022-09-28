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

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
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
			clone.abilityPower = original.abilityPower;
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
			if (!event.isWasDeath()) {
			}
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
		public double skillMagicNeededXp = 0.0;
		public String playerRecipes = "\"\"";
		public double skillCookingLvl = 0;
		public double skillCookingXp = 0;
		public double skillCookingNeededXp = 0;
		public double shieldAmountMax = 0;
		public boolean outOfCombat = false;
		public double shieldLvl = 0;
		public double skillPoints = 0.0;
		public String unlockedSkillTree = "\"\"";
		public double currentRegion = 0;
		public double attackDamage = 0.0;
		public double abilityPower = 0;
		public double armor = 18.0;
		public double magicResistance = 18.0;
		public double critRate = 15.0;
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
			nbt.putDouble("abilityPower", abilityPower);
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
			abilityPower = nbt.getDouble("abilityPower");
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
					variables.abilityPower = message.data.abilityPower;
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
				}
			});
			context.setPacketHandled(true);
		}
	}
}
