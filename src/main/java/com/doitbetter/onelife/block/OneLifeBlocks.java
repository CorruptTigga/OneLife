package com.doitbetter.onelife.block;

import com.doitbetter.onelife.OneLife;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class OneLifeBlocks {

    // =========================================================================
    // SULFUR CRYSTAL SYSTEM
    // =========================================================================

    public static final Block BUDING_SULFUR = register("buding_sulfur", BuddingSulfurBlock::new,
            AbstractBlock.Settings.create()
                    .strength(1.5F)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .ticksRandomly()
                    .dropsNothing(), false);

    public static final Block SMALL_SULFUR_CRYSTAL = register("small_sulfur_crystal",
            settings -> new SulfurCrystalBlock(3.0F, 4.0F, settings),
            AbstractBlock.Settings.create()
                    .strength(1.5F)
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                    .nonOpaque(), true);

    public static final Block MEDIUM_SULFUR_CRYSTAL = register("medium_sulfur_crystal",
            settings -> new SulfurCrystalBlock(4.0F, 3.0F, settings),
            AbstractBlock.Settings.create()
                    .strength(1.5F)
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                    .nonOpaque(), true);

    public static final Block LARGE_SULFUR_CRYSTAL = register("large_sulfur_crystal",
            settings -> new SulfurCrystalBlock(5.0F, 2.0F, settings),
            AbstractBlock.Settings.create()
                    .strength(1.5F)
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                    .nonOpaque(), true);

    public static final Block SULFUR_CRYSTAL_CLUSTER = register("sulfur_crystal_cluster",
            settings -> new SulfurCrystalBlock(7.0F, 1.0F, settings),
            AbstractBlock.Settings.create()
                    .strength(1.5F)
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                    .nonOpaque(), true);

    // =========================================================================
    // TIN
    // =========================================================================
    public static final Block TIN_ORE = registerOreBlock("tin_ore");
    public static final Block DEEPSLATE_TIN_ORE = registerDeepslateOreBlock("deepslate_tin_ore");
    public static final Block RAW_TIN_BLOCK = registerRawStorageBlock("raw_tin_block");
    public static final Block TIN_BLOCK = registerStorageBlock("tin_block");

    // =========================================================================
    // SILVER
    // =========================================================================
    public static final Block SILVER_ORE = registerOreBlock("silver_ore");
    public static final Block DEEPSLATE_SILVER_ORE = registerDeepslateOreBlock("deepslate_silver_ore");
    public static final Block RAW_SILVER_BLOCK = registerRawStorageBlock("raw_silver_block");
    public static final Block SILVER_BLOCK = registerStorageBlock("silver_block");

    // =========================================================================
    // ZINC
    // =========================================================================
    public static final Block ZINC_ORE = registerOreBlock("zinc_ore");
    public static final Block DEEPSLATE_ZINC_ORE = registerDeepslateOreBlock("deepslate_zinc_ore");
    public static final Block RAW_ZINC_BLOCK = registerRawStorageBlock("raw_zinc_block");
    public static final Block ZINC_BLOCK = registerStorageBlock("zinc_block");

    // =========================================================================
    // LEAD
    // =========================================================================
    public static final Block LEAD_ORE = registerOreBlock("lead_ore");
    public static final Block DEEPSLATE_LEAD_ORE = registerDeepslateOreBlock("deepslate_lead_ore");
    public static final Block RAW_LEAD_BLOCK = registerRawStorageBlock("raw_lead_block");
    public static final Block LEAD_BLOCK = registerStorageBlock("lead_block");

    // =========================================================================
    // NICKEL
    // =========================================================================
    public static final Block NICKEL_ORE = registerOreBlock("nickel_ore");
    public static final Block DEEPSLATE_NICKEL_ORE = registerDeepslateOreBlock("deepslate_nickel_ore");
    public static final Block RAW_NICKEL_BLOCK = registerRawStorageBlock("raw_nickel_block");
    public static final Block NICKEL_BLOCK = registerStorageBlock("nickel_block");

    // =========================================================================
    // PLATINUM
    // =========================================================================
    public static final Block PLATINUM_ORE = registerOreBlock("platinum_ore");
    public static final Block DEEPSLATE_PLATINUM_ORE = registerDeepslateOreBlock("deepslate_platinum_ore");
    public static final Block RAW_PLATINUM_BLOCK = registerRawStorageBlock("raw_platinum_block");
    public static final Block PLATINUM_BLOCK = registerStorageBlock("platinum_block");

    // =========================================================================
    // ALLOY STORAGE BLOCKS
    // =========================================================================
    public static final Block BRONZE_BLOCK = registerStorageBlock("bronze_block");
    public static final Block BRASS_BLOCK = registerStorageBlock("brass_block");
    public static final Block WROUGHT_IRON_BLOCK = registerStorageBlock("wrought_iron_block");
    public static final Block STEEL_BLOCK = registerStorageBlock("steel_block");
    public static final Block DAMASCUS_BLOCK = registerStorageBlock("damascus_block");
    public static final Block TEMPERED_STEEL_BLOCK = registerStorageBlock("tempered_steel_block");

    // =========================================================================
    // GEM ORES
    // =========================================================================
    public static final Block RUBY_ORE = registerOreBlock("ruby_ore");
    public static final Block DEEPSLATE_RUBY_ORE = registerDeepslateOreBlock("deepslate_ruby_ore");
    public static final Block SAPPHIRE_ORE = registerOreBlock("sapphire_ore");
    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerDeepslateOreBlock("deepslate_sapphire_ore");
    public static final Block ONYX_ORE = registerOreBlock("onyx_ore");
    public static final Block DEEPSLATE_ONYX_ORE = registerDeepslateOreBlock("deepslate_onyx_ore");
    public static final Block GARNET_ORE = registerOreBlock("garnet_ore");
    public static final Block DEEPSLATE_GARNET_ORE = registerDeepslateOreBlock("deepslate_garnet_ore");
    public static final Block TOPAZ_ORE = registerOreBlock("topaz_ore");
    public static final Block DEEPSLATE_TOPAZ_ORE = registerDeepslateOreBlock("deepslate_topaz_ore");
    public static final Block QUARTZ_ORE = registerOreBlock("quartz_ore");

    // =========================================================================
    // GEM STORAGE BLOCKS
    // =========================================================================
    public static final Block RUBY_BLOCK = registerGemStorageBlock("ruby_block");
    public static final Block SAPPHIRE_BLOCK = registerGemStorageBlock("sapphire_block");
    public static final Block ONYX_BLOCK = registerGemStorageBlock("onyx_block");
    public static final Block GARNET_BLOCK = registerGemStorageBlock("garnet_block");
    public static final Block TOPAZ_BLOCK = registerGemStorageBlock("topaz_block");
    public static final Block AMBER_BLOCK = registerGemStorageBlock("amber_block");

    // =========================================================================
    // GEM RAW STORAGE BLOCKS
    // =========================================================================
    public static final Block RAW_RUBY_BLOCK = registerRawStorageBlock("raw_ruby_block");
    public static final Block RAW_SAPPHIRE_BLOCK = registerRawStorageBlock("raw_sapphire_block");
    public static final Block RAW_ONYX_BLOCK = registerRawStorageBlock("raw_onyx_block");
    public static final Block RAW_GARNET_BLOCK = registerRawStorageBlock("raw_garnet_block");
    public static final Block RAW_TOPAZ_BLOCK = registerRawStorageBlock("raw_topaz_block");
    public static final Block RAW_QUARTZ_BLOCK = registerRawStorageBlock("raw_quartz_block");
    public static final Block POLISHED_AMBER_BLOCK = registerGemStorageBlock("polished_amber_block");
    public static final Block RAW_DIAMOND_BLOCK = registerRawStorageBlock("raw_diamond_block");
    public static final Block RAW_EMERALD_BLOCK = registerRawStorageBlock("raw_emerald_block");

    // =========================================================================
    // REGISTRATION
    // =========================================================================

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean registerItem) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(OneLife.MOD_ID, name));
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (registerItem) {
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(OneLife.MOD_ID, name));
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static Block registerOreBlock(String name) {
        return register(name, Block::new, AbstractBlock.Settings.create()
                .strength(3.0F, 3.0F)
                .sounds(BlockSoundGroup.STONE)
                .requiresTool(), true);
    }

    private static Block registerDeepslateOreBlock(String name) {
        return register(name, Block::new, AbstractBlock.Settings.create()
                .strength(4.5F, 3.0F)
                .sounds(BlockSoundGroup.DEEPSLATE)
                .requiresTool(), true);
    }

    private static Block registerRawStorageBlock(String name) {
        return register(name, Block::new, AbstractBlock.Settings.create()
                .strength(5.0F, 6.0F)
                .sounds(BlockSoundGroup.STONE)
                .requiresTool(), true);
    }

    private static Block registerStorageBlock(String name) {
        return register(name, Block::new, AbstractBlock.Settings.create()
                .strength(5.0F, 6.0F)
                .sounds(BlockSoundGroup.METAL)
                .requiresTool(), true);
    }

    private static Block registerGemStorageBlock(String name) {
        return register(name, Block::new, AbstractBlock.Settings.create()
                .strength(5.0F, 6.0F)
                .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                .requiresTool(), true);
    }

    public static void register() {}
}