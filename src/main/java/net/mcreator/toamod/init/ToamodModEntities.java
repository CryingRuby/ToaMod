
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.entity.XedresEntity;
import net.mcreator.toamod.entity.NPCWardenKnightEntity;
import net.mcreator.toamod.entity.NPCStormEntity;
import net.mcreator.toamod.entity.NPCSleepyScorpiusEntity;
import net.mcreator.toamod.entity.NPCRoyalKnightEntity;
import net.mcreator.toamod.entity.NPCRoyalCommanderEntity;
import net.mcreator.toamod.entity.NPCPriateCaptainEntity;
import net.mcreator.toamod.entity.NPCPhantomEntity;
import net.mcreator.toamod.entity.NPCNecroticKnightEntity;
import net.mcreator.toamod.entity.NPCNecronEntity;
import net.mcreator.toamod.entity.NPCMistMerchantEntity;
import net.mcreator.toamod.entity.NPCMistMageEntity;
import net.mcreator.toamod.entity.NPCMiner3Entity;
import net.mcreator.toamod.entity.NPCMiner2Entity;
import net.mcreator.toamod.entity.NPCMiner1Entity;
import net.mcreator.toamod.entity.NPCMerchantEntity;
import net.mcreator.toamod.entity.NPCMaxorEntity;
import net.mcreator.toamod.entity.NPCMale9Entity;
import net.mcreator.toamod.entity.NPCMale8Entity;
import net.mcreator.toamod.entity.NPCMale7Entity;
import net.mcreator.toamod.entity.NPCMale6Entity;
import net.mcreator.toamod.entity.NPCMale5Entity;
import net.mcreator.toamod.entity.NPCMale4Entity;
import net.mcreator.toamod.entity.NPCMale3Entity;
import net.mcreator.toamod.entity.NPCMale2Entity;
import net.mcreator.toamod.entity.NPCMale1Entity;
import net.mcreator.toamod.entity.NPCLumberjackEntity;
import net.mcreator.toamod.entity.NPCLostAdventurerEntity;
import net.mcreator.toamod.entity.NPCKnight6Entity;
import net.mcreator.toamod.entity.NPCKnight5Entity;
import net.mcreator.toamod.entity.NPCKnight4Entity;
import net.mcreator.toamod.entity.NPCKnight3Entity;
import net.mcreator.toamod.entity.NPCKnight2Entity;
import net.mcreator.toamod.entity.NPCKnight1Entity;
import net.mcreator.toamod.entity.NPCJaedusEntity;
import net.mcreator.toamod.entity.NPCIronGolemEntity;
import net.mcreator.toamod.entity.NPCHunterEntity;
import net.mcreator.toamod.entity.NPCGoldenKnightEntity;
import net.mcreator.toamod.entity.NPCForeignMerchantEntity;
import net.mcreator.toamod.entity.NPCFemale8Entity;
import net.mcreator.toamod.entity.NPCFemale7Entity;
import net.mcreator.toamod.entity.NPCFemale6Entity;
import net.mcreator.toamod.entity.NPCFemale5Entity;
import net.mcreator.toamod.entity.NPCFemale4Entity;
import net.mcreator.toamod.entity.NPCFemale3Entity;
import net.mcreator.toamod.entity.NPCFemale2Entity;
import net.mcreator.toamod.entity.NPCFemale1Entity;
import net.mcreator.toamod.entity.NPCFairy3Entity;
import net.mcreator.toamod.entity.NPCFairy2Entity;
import net.mcreator.toamod.entity.NPCFairy1Entity;
import net.mcreator.toamod.entity.NPCDwarf8Entity;
import net.mcreator.toamod.entity.NPCDwarf7Entity;
import net.mcreator.toamod.entity.NPCDwarf6Entity;
import net.mcreator.toamod.entity.NPCDwarf5Entity;
import net.mcreator.toamod.entity.NPCDwarf4Entity;
import net.mcreator.toamod.entity.NPCDwarf3Entity;
import net.mcreator.toamod.entity.NPCDwarf2Entity;
import net.mcreator.toamod.entity.NPCDwarf1Entity;
import net.mcreator.toamod.entity.NPCDungeonMasterEntity;
import net.mcreator.toamod.entity.NPCCopperMinerEntity;
import net.mcreator.toamod.entity.NPCBlacksmith4Entity;
import net.mcreator.toamod.entity.NPCBlacksmith3Entity;
import net.mcreator.toamod.entity.NPCBlacksmith2Entity;
import net.mcreator.toamod.entity.NPCBlacksmith1Entity;
import net.mcreator.toamod.entity.HorseCareTakerEntity;
import net.mcreator.toamod.entity.GuiItemGhostEntity;
import net.mcreator.toamod.entity.GoblinScoutEntity;
import net.mcreator.toamod.entity.GoblinHunterEntity;
import net.mcreator.toamod.entity.GoblinEntity;
import net.mcreator.toamod.entity.BossIllfangEntity;
import net.mcreator.toamod.ToamodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ToamodModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ToamodMod.MODID);
	public static final RegistryObject<EntityType<HorseCareTakerEntity>> HORSE_CARE_TAKER = register("horse_care_taker", EntityType.Builder.<HorseCareTakerEntity>of(HorseCareTakerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HorseCareTakerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GoblinEntity>> GOBLIN = register("goblin",
			EntityType.Builder.<GoblinEntity>of(GoblinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoblinEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<GuiItemGhostEntity>> GUI_ITEM_GHOST = register("gui_item_ghost",
			EntityType.Builder.<GuiItemGhostEntity>of(GuiItemGhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GuiItemGhostEntity::new)

					.sized(0f, 0f));
	public static final RegistryObject<EntityType<GoblinScoutEntity>> GOBLIN_SCOUT = register("goblin_scout", EntityType.Builder.<GoblinScoutEntity>of(GoblinScoutEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoblinScoutEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<XedresEntity>> XEDRES = register("xedres",
			EntityType.Builder.<XedresEntity>of(XedresEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(XedresEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<GoblinHunterEntity>> GOBLIN_HUNTER = register("goblin_hunter", EntityType.Builder.<GoblinHunterEntity>of(GoblinHunterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoblinHunterEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<NPCBlacksmith1Entity>> NPC_BLACKSMITH_1 = register("npc_blacksmith_1", EntityType.Builder.<NPCBlacksmith1Entity>of(NPCBlacksmith1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCBlacksmith1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCBlacksmith2Entity>> NPC_BLACKSMITH_2 = register("npc_blacksmith_2", EntityType.Builder.<NPCBlacksmith2Entity>of(NPCBlacksmith2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCBlacksmith2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCBlacksmith3Entity>> NPC_BLACKSMITH_3 = register("npc_blacksmith_3", EntityType.Builder.<NPCBlacksmith3Entity>of(NPCBlacksmith3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCBlacksmith3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCBlacksmith4Entity>> NPC_BLACKSMITH_4 = register("npc_blacksmith_4", EntityType.Builder.<NPCBlacksmith4Entity>of(NPCBlacksmith4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCBlacksmith4Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCDwarf1Entity>> NPC_DWARF_1 = register("npc_dwarf_1", EntityType.Builder.<NPCDwarf1Entity>of(NPCDwarf1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCDwarf1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCDwarf2Entity>> NPC_DWARF_2 = register("npc_dwarf_2", EntityType.Builder.<NPCDwarf2Entity>of(NPCDwarf2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCDwarf2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCDwarf3Entity>> NPC_DWARF_3 = register("npc_dwarf_3", EntityType.Builder.<NPCDwarf3Entity>of(NPCDwarf3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCDwarf3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCDwarf4Entity>> NPC_DWARF_4 = register("npc_dwarf_4", EntityType.Builder.<NPCDwarf4Entity>of(NPCDwarf4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCDwarf4Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCDwarf5Entity>> NPC_DWARF_5 = register("npc_dwarf_5", EntityType.Builder.<NPCDwarf5Entity>of(NPCDwarf5Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCDwarf5Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCDwarf6Entity>> NPC_DWARF_6 = register("npc_dwarf_6", EntityType.Builder.<NPCDwarf6Entity>of(NPCDwarf6Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCDwarf6Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCDwarf7Entity>> NPC_DWARF_7 = register("npc_dwarf_7", EntityType.Builder.<NPCDwarf7Entity>of(NPCDwarf7Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCDwarf7Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCDwarf8Entity>> NPC_DWARF_8 = register("npc_dwarf_8", EntityType.Builder.<NPCDwarf8Entity>of(NPCDwarf8Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCDwarf8Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCFairy1Entity>> NPC_FAIRY_1 = register("npc_fairy_1", EntityType.Builder.<NPCFairy1Entity>of(NPCFairy1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCFairy1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCFairy2Entity>> NPC_FAIRY_2 = register("npc_fairy_2", EntityType.Builder.<NPCFairy2Entity>of(NPCFairy2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCFairy2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCFairy3Entity>> NPC_FAIRY_3 = register("npc_fairy_3", EntityType.Builder.<NPCFairy3Entity>of(NPCFairy3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCFairy3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCFemale1Entity>> NPC_FEMALE_1 = register("npc_female_1", EntityType.Builder.<NPCFemale1Entity>of(NPCFemale1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCFemale1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCFemale2Entity>> NPC_FEMALE_2 = register("npc_female_2", EntityType.Builder.<NPCFemale2Entity>of(NPCFemale2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCFemale2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCFemale3Entity>> NPC_FEMALE_3 = register("npc_female_3", EntityType.Builder.<NPCFemale3Entity>of(NPCFemale3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCFemale3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCFemale4Entity>> NPC_FEMALE_4 = register("npc_female_4", EntityType.Builder.<NPCFemale4Entity>of(NPCFemale4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCFemale4Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCFemale5Entity>> NPC_FEMALE_5 = register("npc_female_5", EntityType.Builder.<NPCFemale5Entity>of(NPCFemale5Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCFemale5Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCFemale6Entity>> NPC_FEMALE_6 = register("npc_female_6", EntityType.Builder.<NPCFemale6Entity>of(NPCFemale6Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCFemale6Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCFemale7Entity>> NPC_FEMALE_7 = register("npc_female_7", EntityType.Builder.<NPCFemale7Entity>of(NPCFemale7Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCFemale7Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCFemale8Entity>> NPC_FEMALE_8 = register("npc_female_8", EntityType.Builder.<NPCFemale8Entity>of(NPCFemale8Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCFemale8Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCKnight1Entity>> NPC_KNIGHT_1 = register("npc_knight_1", EntityType.Builder.<NPCKnight1Entity>of(NPCKnight1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCKnight1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCKnight2Entity>> NPC_KNIGHT_2 = register("npc_knight_2", EntityType.Builder.<NPCKnight2Entity>of(NPCKnight2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCKnight2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCKnight3Entity>> NPC_KNIGHT_3 = register("npc_knight_3", EntityType.Builder.<NPCKnight3Entity>of(NPCKnight3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCKnight3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCKnight4Entity>> NPC_KNIGHT_4 = register("npc_knight_4", EntityType.Builder.<NPCKnight4Entity>of(NPCKnight4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCKnight4Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCKnight5Entity>> NPC_KNIGHT_5 = register("npc_knight_5", EntityType.Builder.<NPCKnight5Entity>of(NPCKnight5Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCKnight5Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCKnight6Entity>> NPC_KNIGHT_6 = register("npc_knight_6", EntityType.Builder.<NPCKnight6Entity>of(NPCKnight6Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCKnight6Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMale1Entity>> NPC_MALE_1 = register("npc_male_1",
			EntityType.Builder.<NPCMale1Entity>of(NPCMale1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMale1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMale2Entity>> NPC_MALE_2 = register("npc_male_2",
			EntityType.Builder.<NPCMale2Entity>of(NPCMale2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMale2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMale3Entity>> NPC_MALE_3 = register("npc_male_3",
			EntityType.Builder.<NPCMale3Entity>of(NPCMale3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMale3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMale4Entity>> NPC_MALE_4 = register("npc_male_4",
			EntityType.Builder.<NPCMale4Entity>of(NPCMale4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMale4Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMale5Entity>> NPC_MALE_5 = register("npc_male_5",
			EntityType.Builder.<NPCMale5Entity>of(NPCMale5Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMale5Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMale6Entity>> NPC_MALE_6 = register("npc_male_6",
			EntityType.Builder.<NPCMale6Entity>of(NPCMale6Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMale6Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMale7Entity>> NPC_MALE_7 = register("npc_male_7",
			EntityType.Builder.<NPCMale7Entity>of(NPCMale7Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMale7Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMale8Entity>> NPC_MALE_8 = register("npc_male_8",
			EntityType.Builder.<NPCMale8Entity>of(NPCMale8Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMale8Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMale9Entity>> NPC_MALE_9 = register("npc_male_9",
			EntityType.Builder.<NPCMale9Entity>of(NPCMale9Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMale9Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMiner2Entity>> NPC_MINER_2 = register("npc_miner_2", EntityType.Builder.<NPCMiner2Entity>of(NPCMiner2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCMiner2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMiner3Entity>> NPC_MINER_3 = register("npc_miner_3", EntityType.Builder.<NPCMiner3Entity>of(NPCMiner3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCMiner3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCRoyalCommanderEntity>> NPC_ROYAL_COMMANDER = register("npc_royal_commander", EntityType.Builder.<NPCRoyalCommanderEntity>of(NPCRoyalCommanderEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCRoyalCommanderEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCCopperMinerEntity>> NPC_COPPER_MINER = register("npc_copper_miner", EntityType.Builder.<NPCCopperMinerEntity>of(NPCCopperMinerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCCopperMinerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCDungeonMasterEntity>> NPC_DUNGEON_MASTER = register("npc_dungeon_master", EntityType.Builder.<NPCDungeonMasterEntity>of(NPCDungeonMasterEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCDungeonMasterEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCForeignMerchantEntity>> NPC_FOREIGN_MERCHANT = register("npc_foreign_merchant", EntityType.Builder.<NPCForeignMerchantEntity>of(NPCForeignMerchantEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCForeignMerchantEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCGoldenKnightEntity>> NPC_GOLDEN_KNIGHT = register("npc_golden_knight", EntityType.Builder.<NPCGoldenKnightEntity>of(NPCGoldenKnightEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCGoldenKnightEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCHunterEntity>> NPC_HUNTER = register("npc_hunter", EntityType.Builder.<NPCHunterEntity>of(NPCHunterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCHunterEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCIronGolemEntity>> NPC_IRON_GOLEM = register("npc_iron_golem", EntityType.Builder.<NPCIronGolemEntity>of(NPCIronGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCIronGolemEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCJaedusEntity>> NPC_JAEDUS = register("npc_jaedus", EntityType.Builder.<NPCJaedusEntity>of(NPCJaedusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCJaedusEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCLumberjackEntity>> NPC_LUMBERJACK = register("npc_lumberjack", EntityType.Builder.<NPCLumberjackEntity>of(NPCLumberjackEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCLumberjackEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCLostAdventurerEntity>> NPC_LOST_ADVENTURER = register("npc_lost_adventurer", EntityType.Builder.<NPCLostAdventurerEntity>of(NPCLostAdventurerEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCLostAdventurerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMaxorEntity>> NPC_MAXOR = register("npc_maxor",
			EntityType.Builder.<NPCMaxorEntity>of(NPCMaxorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMaxorEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMistMageEntity>> NPC_MIST_MAGE = register("npc_mist_mage", EntityType.Builder.<NPCMistMageEntity>of(NPCMistMageEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMistMageEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMistMerchantEntity>> NPC_MIST_MERCHANT = register("npc_mist_merchant", EntityType.Builder.<NPCMistMerchantEntity>of(NPCMistMerchantEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMistMerchantEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCNecronEntity>> NPC_NECRON = register("npc_necron", EntityType.Builder.<NPCNecronEntity>of(NPCNecronEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCNecronEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCNecroticKnightEntity>> NPC_NECROTIC_KNIGHT = register("npc_necrotic_knight", EntityType.Builder.<NPCNecroticKnightEntity>of(NPCNecroticKnightEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCNecroticKnightEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCPhantomEntity>> NPC_PHANTOM = register("npc_phantom", EntityType.Builder.<NPCPhantomEntity>of(NPCPhantomEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCPhantomEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCPriateCaptainEntity>> NPC_PRIATE_CAPTAIN = register("npc_priate_captain", EntityType.Builder.<NPCPriateCaptainEntity>of(NPCPriateCaptainEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCPriateCaptainEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCRoyalKnightEntity>> NPC_ROYAL_KNIGHT = register("npc_royal_knight", EntityType.Builder.<NPCRoyalKnightEntity>of(NPCRoyalKnightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCRoyalKnightEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCSleepyScorpiusEntity>> NPC_SLEEPY_SCORPIUS = register("npc_sleepy_scorpius", EntityType.Builder.<NPCSleepyScorpiusEntity>of(NPCSleepyScorpiusEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCSleepyScorpiusEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCStormEntity>> NPC_STORM = register("npc_storm",
			EntityType.Builder.<NPCStormEntity>of(NPCStormEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCStormEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCWardenKnightEntity>> NPC_WARDEN_KNIGHT = register("npc_warden_knight", EntityType.Builder.<NPCWardenKnightEntity>of(NPCWardenKnightEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCWardenKnightEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BossIllfangEntity>> BOSS_ILLFANG = register("boss_illfang",
			EntityType.Builder.<BossIllfangEntity>of(BossIllfangEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BossIllfangEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMerchantEntity>> NPC_MERCHANT = register("npc_merchant", EntityType.Builder.<NPCMerchantEntity>of(NPCMerchantEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NPCMerchantEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NPCMiner1Entity>> NPC_MINER_1 = register("npc_miner_1", EntityType.Builder.<NPCMiner1Entity>of(NPCMiner1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NPCMiner1Entity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			HorseCareTakerEntity.init();
			GoblinEntity.init();
			GuiItemGhostEntity.init();
			GoblinScoutEntity.init();
			XedresEntity.init();
			GoblinHunterEntity.init();
			NPCBlacksmith1Entity.init();
			NPCBlacksmith2Entity.init();
			NPCBlacksmith3Entity.init();
			NPCBlacksmith4Entity.init();
			NPCDwarf1Entity.init();
			NPCDwarf2Entity.init();
			NPCDwarf3Entity.init();
			NPCDwarf4Entity.init();
			NPCDwarf5Entity.init();
			NPCDwarf6Entity.init();
			NPCDwarf7Entity.init();
			NPCDwarf8Entity.init();
			NPCFairy1Entity.init();
			NPCFairy2Entity.init();
			NPCFairy3Entity.init();
			NPCFemale1Entity.init();
			NPCFemale2Entity.init();
			NPCFemale3Entity.init();
			NPCFemale4Entity.init();
			NPCFemale5Entity.init();
			NPCFemale6Entity.init();
			NPCFemale7Entity.init();
			NPCFemale8Entity.init();
			NPCKnight1Entity.init();
			NPCKnight2Entity.init();
			NPCKnight3Entity.init();
			NPCKnight4Entity.init();
			NPCKnight5Entity.init();
			NPCKnight6Entity.init();
			NPCMale1Entity.init();
			NPCMale2Entity.init();
			NPCMale3Entity.init();
			NPCMale4Entity.init();
			NPCMale5Entity.init();
			NPCMale6Entity.init();
			NPCMale7Entity.init();
			NPCMale8Entity.init();
			NPCMale9Entity.init();
			NPCMiner2Entity.init();
			NPCMiner3Entity.init();
			NPCRoyalCommanderEntity.init();
			NPCCopperMinerEntity.init();
			NPCDungeonMasterEntity.init();
			NPCForeignMerchantEntity.init();
			NPCGoldenKnightEntity.init();
			NPCHunterEntity.init();
			NPCIronGolemEntity.init();
			NPCJaedusEntity.init();
			NPCLumberjackEntity.init();
			NPCLostAdventurerEntity.init();
			NPCMaxorEntity.init();
			NPCMistMageEntity.init();
			NPCMistMerchantEntity.init();
			NPCNecronEntity.init();
			NPCNecroticKnightEntity.init();
			NPCPhantomEntity.init();
			NPCPriateCaptainEntity.init();
			NPCRoyalKnightEntity.init();
			NPCSleepyScorpiusEntity.init();
			NPCStormEntity.init();
			NPCWardenKnightEntity.init();
			BossIllfangEntity.init();
			NPCMerchantEntity.init();
			NPCMiner1Entity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(HORSE_CARE_TAKER.get(), HorseCareTakerEntity.createAttributes().build());
		event.put(GOBLIN.get(), GoblinEntity.createAttributes().build());
		event.put(GUI_ITEM_GHOST.get(), GuiItemGhostEntity.createAttributes().build());
		event.put(GOBLIN_SCOUT.get(), GoblinScoutEntity.createAttributes().build());
		event.put(XEDRES.get(), XedresEntity.createAttributes().build());
		event.put(GOBLIN_HUNTER.get(), GoblinHunterEntity.createAttributes().build());
		event.put(NPC_BLACKSMITH_1.get(), NPCBlacksmith1Entity.createAttributes().build());
		event.put(NPC_BLACKSMITH_2.get(), NPCBlacksmith2Entity.createAttributes().build());
		event.put(NPC_BLACKSMITH_3.get(), NPCBlacksmith3Entity.createAttributes().build());
		event.put(NPC_BLACKSMITH_4.get(), NPCBlacksmith4Entity.createAttributes().build());
		event.put(NPC_DWARF_1.get(), NPCDwarf1Entity.createAttributes().build());
		event.put(NPC_DWARF_2.get(), NPCDwarf2Entity.createAttributes().build());
		event.put(NPC_DWARF_3.get(), NPCDwarf3Entity.createAttributes().build());
		event.put(NPC_DWARF_4.get(), NPCDwarf4Entity.createAttributes().build());
		event.put(NPC_DWARF_5.get(), NPCDwarf5Entity.createAttributes().build());
		event.put(NPC_DWARF_6.get(), NPCDwarf6Entity.createAttributes().build());
		event.put(NPC_DWARF_7.get(), NPCDwarf7Entity.createAttributes().build());
		event.put(NPC_DWARF_8.get(), NPCDwarf8Entity.createAttributes().build());
		event.put(NPC_FAIRY_1.get(), NPCFairy1Entity.createAttributes().build());
		event.put(NPC_FAIRY_2.get(), NPCFairy2Entity.createAttributes().build());
		event.put(NPC_FAIRY_3.get(), NPCFairy3Entity.createAttributes().build());
		event.put(NPC_FEMALE_1.get(), NPCFemale1Entity.createAttributes().build());
		event.put(NPC_FEMALE_2.get(), NPCFemale2Entity.createAttributes().build());
		event.put(NPC_FEMALE_3.get(), NPCFemale3Entity.createAttributes().build());
		event.put(NPC_FEMALE_4.get(), NPCFemale4Entity.createAttributes().build());
		event.put(NPC_FEMALE_5.get(), NPCFemale5Entity.createAttributes().build());
		event.put(NPC_FEMALE_6.get(), NPCFemale6Entity.createAttributes().build());
		event.put(NPC_FEMALE_7.get(), NPCFemale7Entity.createAttributes().build());
		event.put(NPC_FEMALE_8.get(), NPCFemale8Entity.createAttributes().build());
		event.put(NPC_KNIGHT_1.get(), NPCKnight1Entity.createAttributes().build());
		event.put(NPC_KNIGHT_2.get(), NPCKnight2Entity.createAttributes().build());
		event.put(NPC_KNIGHT_3.get(), NPCKnight3Entity.createAttributes().build());
		event.put(NPC_KNIGHT_4.get(), NPCKnight4Entity.createAttributes().build());
		event.put(NPC_KNIGHT_5.get(), NPCKnight5Entity.createAttributes().build());
		event.put(NPC_KNIGHT_6.get(), NPCKnight6Entity.createAttributes().build());
		event.put(NPC_MALE_1.get(), NPCMale1Entity.createAttributes().build());
		event.put(NPC_MALE_2.get(), NPCMale2Entity.createAttributes().build());
		event.put(NPC_MALE_3.get(), NPCMale3Entity.createAttributes().build());
		event.put(NPC_MALE_4.get(), NPCMale4Entity.createAttributes().build());
		event.put(NPC_MALE_5.get(), NPCMale5Entity.createAttributes().build());
		event.put(NPC_MALE_6.get(), NPCMale6Entity.createAttributes().build());
		event.put(NPC_MALE_7.get(), NPCMale7Entity.createAttributes().build());
		event.put(NPC_MALE_8.get(), NPCMale8Entity.createAttributes().build());
		event.put(NPC_MALE_9.get(), NPCMale9Entity.createAttributes().build());
		event.put(NPC_MINER_2.get(), NPCMiner2Entity.createAttributes().build());
		event.put(NPC_MINER_3.get(), NPCMiner3Entity.createAttributes().build());
		event.put(NPC_ROYAL_COMMANDER.get(), NPCRoyalCommanderEntity.createAttributes().build());
		event.put(NPC_COPPER_MINER.get(), NPCCopperMinerEntity.createAttributes().build());
		event.put(NPC_DUNGEON_MASTER.get(), NPCDungeonMasterEntity.createAttributes().build());
		event.put(NPC_FOREIGN_MERCHANT.get(), NPCForeignMerchantEntity.createAttributes().build());
		event.put(NPC_GOLDEN_KNIGHT.get(), NPCGoldenKnightEntity.createAttributes().build());
		event.put(NPC_HUNTER.get(), NPCHunterEntity.createAttributes().build());
		event.put(NPC_IRON_GOLEM.get(), NPCIronGolemEntity.createAttributes().build());
		event.put(NPC_JAEDUS.get(), NPCJaedusEntity.createAttributes().build());
		event.put(NPC_LUMBERJACK.get(), NPCLumberjackEntity.createAttributes().build());
		event.put(NPC_LOST_ADVENTURER.get(), NPCLostAdventurerEntity.createAttributes().build());
		event.put(NPC_MAXOR.get(), NPCMaxorEntity.createAttributes().build());
		event.put(NPC_MIST_MAGE.get(), NPCMistMageEntity.createAttributes().build());
		event.put(NPC_MIST_MERCHANT.get(), NPCMistMerchantEntity.createAttributes().build());
		event.put(NPC_NECRON.get(), NPCNecronEntity.createAttributes().build());
		event.put(NPC_NECROTIC_KNIGHT.get(), NPCNecroticKnightEntity.createAttributes().build());
		event.put(NPC_PHANTOM.get(), NPCPhantomEntity.createAttributes().build());
		event.put(NPC_PRIATE_CAPTAIN.get(), NPCPriateCaptainEntity.createAttributes().build());
		event.put(NPC_ROYAL_KNIGHT.get(), NPCRoyalKnightEntity.createAttributes().build());
		event.put(NPC_SLEEPY_SCORPIUS.get(), NPCSleepyScorpiusEntity.createAttributes().build());
		event.put(NPC_STORM.get(), NPCStormEntity.createAttributes().build());
		event.put(NPC_WARDEN_KNIGHT.get(), NPCWardenKnightEntity.createAttributes().build());
		event.put(BOSS_ILLFANG.get(), BossIllfangEntity.createAttributes().build());
		event.put(NPC_MERCHANT.get(), NPCMerchantEntity.createAttributes().build());
		event.put(NPC_MINER_1.get(), NPCMiner1Entity.createAttributes().build());
	}
}
