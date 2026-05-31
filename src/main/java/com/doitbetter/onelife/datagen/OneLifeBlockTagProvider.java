package com.doitbetter.onelife.datagen;

import com.doitbetter.onelife.tag.OneLifeBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class OneLifeBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public OneLifeBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        needsFlintTool();
        needsCopperTool();
        needsBronzeTool();
        needsIronTool();

        incorrectForWoodTool();
        incorrectForFlintTool();
        incorrectForCopperTool();
        incorrectForBronzeTool();
        incorrectForIronTool();
        incorrectForWroughtIronTool();
        incorrectForSteelTool();
        incorrectForDamascusTool();
        incorrectForTemperedSteelTool();
    }

    private void needsFlintTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.NEEDS_FLINT_TOOL)
                // Basic stone
                .add(Blocks.STONE)
                .add(Blocks.COBBLESTONE)
                .add(Blocks.MOSSY_COBBLESTONE)
                .add(Blocks.SMOOTH_STONE)
                .add(Blocks.SMOOTH_STONE_SLAB)
                .add(Blocks.STONE_SLAB)
                .add(Blocks.STONE_STAIRS)
                // Stone bricks
                .add(Blocks.STONE_BRICKS)
                .add(Blocks.CRACKED_STONE_BRICKS)
                .add(Blocks.MOSSY_STONE_BRICKS)
                .add(Blocks.CHISELED_STONE_BRICKS)
                .add(Blocks.STONE_BRICK_SLAB)
                .add(Blocks.STONE_BRICK_STAIRS)
                .add(Blocks.STONE_BRICK_WALL)
                .add(Blocks.MOSSY_STONE_BRICK_WALL)
                .add(Blocks.COBBLESTONE_WALL)
                .add(Blocks.MOSSY_COBBLESTONE_WALL)
                .add(Blocks.COBBLESTONE_SLAB)
                .add(Blocks.COBBLESTONE_STAIRS)
                // Andesite
                .add(Blocks.ANDESITE)
                .add(Blocks.POLISHED_ANDESITE)
                .add(Blocks.ANDESITE_SLAB)
                .add(Blocks.ANDESITE_STAIRS)
                .add(Blocks.ANDESITE_WALL)
                .add(Blocks.POLISHED_ANDESITE_SLAB)
                .add(Blocks.POLISHED_ANDESITE_STAIRS)
                // Diorite
                .add(Blocks.DIORITE)
                .add(Blocks.POLISHED_DIORITE)
                .add(Blocks.DIORITE_SLAB)
                .add(Blocks.DIORITE_STAIRS)
                .add(Blocks.DIORITE_WALL)
                .add(Blocks.POLISHED_DIORITE_SLAB)
                .add(Blocks.POLISHED_DIORITE_STAIRS)
                // Granite
                .add(Blocks.GRANITE)
                .add(Blocks.POLISHED_GRANITE)
                .add(Blocks.GRANITE_SLAB)
                .add(Blocks.GRANITE_STAIRS)
                .add(Blocks.GRANITE_WALL)
                .add(Blocks.POLISHED_GRANITE_SLAB)
                .add(Blocks.POLISHED_GRANITE_STAIRS)
                // Calcite, Tuff
                .add(Blocks.CALCITE)
                .add(Blocks.TUFF)
                .add(Blocks.TUFF_SLAB)
                .add(Blocks.TUFF_STAIRS)
                .add(Blocks.TUFF_WALL)
                .add(Blocks.POLISHED_TUFF)
                .add(Blocks.POLISHED_TUFF_SLAB)
                .add(Blocks.POLISHED_TUFF_STAIRS)
                .add(Blocks.POLISHED_TUFF_WALL)
                .add(Blocks.CHISELED_TUFF)
                .add(Blocks.TUFF_BRICKS)
                .add(Blocks.TUFF_BRICK_SLAB)
                .add(Blocks.TUFF_BRICK_STAIRS)
                .add(Blocks.TUFF_BRICK_WALL)
                .add(Blocks.CHISELED_TUFF_BRICKS)
                // Sandstone
                .add(Blocks.SANDSTONE)
                .add(Blocks.CHISELED_SANDSTONE)
                .add(Blocks.SMOOTH_SANDSTONE)
                .add(Blocks.CUT_SANDSTONE)
                .add(Blocks.SANDSTONE_SLAB)
                .add(Blocks.SANDSTONE_STAIRS)
                .add(Blocks.SANDSTONE_WALL)
                .add(Blocks.SMOOTH_SANDSTONE_SLAB)
                .add(Blocks.SMOOTH_SANDSTONE_STAIRS)
                .add(Blocks.RED_SANDSTONE)
                .add(Blocks.CHISELED_RED_SANDSTONE)
                .add(Blocks.SMOOTH_RED_SANDSTONE)
                .add(Blocks.CUT_RED_SANDSTONE)
                .add(Blocks.RED_SANDSTONE_SLAB)
                .add(Blocks.RED_SANDSTONE_STAIRS)
                .add(Blocks.RED_SANDSTONE_WALL)
                .add(Blocks.SMOOTH_RED_SANDSTONE_SLAB)
                .add(Blocks.SMOOTH_RED_SANDSTONE_STAIRS)

                .add(Blocks.COPPER_ORE);

                // TODO: Add OneLife ores once registered in Phase 2
                // .add(OneLifeBlocks.TIN_ORE)
                // .add(OneLifeBlocks.SULFUR_ORE)
    }

    private void needsCopperTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.NEEDS_COPPER_TOOL)
                // Vanilla iron
                .add(Blocks.IRON_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE)
                .add(Blocks.IRON_BLOCK)
                .add(Blocks.RAW_IRON_BLOCK)
                // Vanilla copper blocks
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.RAW_COPPER_BLOCK)
                .add(Blocks.CUT_COPPER)
                .add(Blocks.CUT_COPPER_SLAB)
                .add(Blocks.CUT_COPPER_STAIRS)
                .add(Blocks.CHISELED_COPPER)
                .add(Blocks.COPPER_GRATE)
                .add(Blocks.COPPER_BULB)
                .add(Blocks.COPPER_TRAPDOOR)
                .add(Blocks.EXPOSED_COPPER)
                .add(Blocks.EXPOSED_CUT_COPPER)
                .add(Blocks.EXPOSED_CUT_COPPER_SLAB)
                .add(Blocks.EXPOSED_CUT_COPPER_STAIRS)
                .add(Blocks.EXPOSED_CHISELED_COPPER)
                .add(Blocks.EXPOSED_COPPER_GRATE)
                .add(Blocks.EXPOSED_COPPER_BULB)
                .add(Blocks.EXPOSED_COPPER_TRAPDOOR)
                .add(Blocks.WEATHERED_COPPER)
                .add(Blocks.WEATHERED_CUT_COPPER)
                .add(Blocks.WEATHERED_CUT_COPPER_SLAB)
                .add(Blocks.WEATHERED_CUT_COPPER_STAIRS)
                .add(Blocks.WEATHERED_CHISELED_COPPER)
                .add(Blocks.WEATHERED_COPPER_GRATE)
                .add(Blocks.WEATHERED_COPPER_BULB)
                .add(Blocks.WEATHERED_COPPER_TRAPDOOR)
                .add(Blocks.OXIDIZED_COPPER)
                .add(Blocks.OXIDIZED_CUT_COPPER)
                .add(Blocks.OXIDIZED_CUT_COPPER_SLAB)
                .add(Blocks.OXIDIZED_CUT_COPPER_STAIRS)
                .add(Blocks.OXIDIZED_CHISELED_COPPER)
                .add(Blocks.OXIDIZED_COPPER_GRATE)
                .add(Blocks.OXIDIZED_COPPER_BULB)
                .add(Blocks.OXIDIZED_COPPER_TRAPDOOR)
                // Waxed copper variants
                .add(Blocks.WAXED_COPPER_BLOCK)
                .add(Blocks.WAXED_CUT_COPPER)
                .add(Blocks.WAXED_CUT_COPPER_SLAB)
                .add(Blocks.WAXED_CUT_COPPER_STAIRS)
                .add(Blocks.WAXED_CHISELED_COPPER)
                .add(Blocks.WAXED_COPPER_GRATE)
                .add(Blocks.WAXED_COPPER_BULB)
                .add(Blocks.WAXED_COPPER_TRAPDOOR)
                .add(Blocks.WAXED_EXPOSED_COPPER)
                .add(Blocks.WAXED_EXPOSED_CUT_COPPER)
                .add(Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB)
                .add(Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS)
                .add(Blocks.WAXED_EXPOSED_CHISELED_COPPER)
                .add(Blocks.WAXED_EXPOSED_COPPER_GRATE)
                .add(Blocks.WAXED_EXPOSED_COPPER_BULB)
                .add(Blocks.WAXED_EXPOSED_COPPER_TRAPDOOR)
                .add(Blocks.WAXED_WEATHERED_COPPER)
                .add(Blocks.WAXED_WEATHERED_CUT_COPPER)
                .add(Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB)
                .add(Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS)
                .add(Blocks.WAXED_WEATHERED_CHISELED_COPPER)
                .add(Blocks.WAXED_WEATHERED_COPPER_GRATE)
                .add(Blocks.WAXED_WEATHERED_COPPER_BULB)
                .add(Blocks.WAXED_WEATHERED_COPPER_TRAPDOOR)
                .add(Blocks.WAXED_OXIDIZED_COPPER)
                .add(Blocks.WAXED_OXIDIZED_CUT_COPPER)
                .add(Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB)
                .add(Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS)
                .add(Blocks.WAXED_OXIDIZED_CHISELED_COPPER)
                .add(Blocks.WAXED_OXIDIZED_COPPER_GRATE)
                .add(Blocks.WAXED_OXIDIZED_COPPER_BULB)
                .add(Blocks.WAXED_OXIDIZED_COPPER_TRAPDOOR)
                .add(Blocks.LIGHTNING_ROD);

                // TODO: Add OneLife ores once registered in Phase 2
                // .add(OneLifeBlocks.ZINC_ORE)
                // .add(OneLifeBlocks.LEAD_ORE)
                // .add(OneLifeBlocks.SILVER_ORE);
    }

    private void needsBronzeTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.NEEDS_BRONZE_TOOL)
                // Vanilla gold
                .add(Blocks.GOLD_ORE)
                .add(Blocks.DEEPSLATE_GOLD_ORE)
                .add(Blocks.GOLD_BLOCK)
                .add(Blocks.RAW_GOLD_BLOCK)
                .add(Blocks.GILDED_BLACKSTONE);

                // TODO: Add OneLife ores once registered in Phase 2
                // .add(OneLifeBlocks.NICKEL_ORE)
    }

    private void needsIronTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.NEEDS_IRON_TOOL)
                // Deepslate base
                .add(Blocks.DEEPSLATE)
                .add(Blocks.COBBLED_DEEPSLATE)
                .add(Blocks.COBBLED_DEEPSLATE_SLAB)
                .add(Blocks.COBBLED_DEEPSLATE_STAIRS)
                .add(Blocks.COBBLED_DEEPSLATE_WALL)
                .add(Blocks.POLISHED_DEEPSLATE)
                .add(Blocks.POLISHED_DEEPSLATE_SLAB)
                .add(Blocks.POLISHED_DEEPSLATE_STAIRS)
                .add(Blocks.POLISHED_DEEPSLATE_WALL)
                .add(Blocks.DEEPSLATE_BRICKS)
                .add(Blocks.DEEPSLATE_BRICK_SLAB)
                .add(Blocks.DEEPSLATE_BRICK_STAIRS)
                .add(Blocks.DEEPSLATE_BRICK_WALL)
                .add(Blocks.CRACKED_DEEPSLATE_BRICKS)
                .add(Blocks.DEEPSLATE_TILES)
                .add(Blocks.DEEPSLATE_TILE_SLAB)
                .add(Blocks.DEEPSLATE_TILE_STAIRS)
                .add(Blocks.DEEPSLATE_TILE_WALL)
                .add(Blocks.CRACKED_DEEPSLATE_TILES)
                .add(Blocks.CHISELED_DEEPSLATE)
                // Vanilla gem ores
                .add(Blocks.DIAMOND_ORE)
                .add(Blocks.DEEPSLATE_DIAMOND_ORE)
                .add(Blocks.EMERALD_ORE)
                .add(Blocks.DEEPSLATE_EMERALD_ORE)
                .add(Blocks.LAPIS_ORE)
                .add(Blocks.DEEPSLATE_LAPIS_ORE)
                .add(Blocks.REDSTONE_ORE)
                .add(Blocks.DEEPSLATE_REDSTONE_ORE)
                // Obsidian — iron tier feels right, hard but achievable
                .add(Blocks.OBSIDIAN)
                .add(Blocks.CRYING_OBSIDIAN);

                // TODO: Add OneLife ores once registered in Phase 2
                // .add(OneLifeBlocks.RUBY_ORE)
                // .add(OneLifeBlocks.SAPPHIRE_ORE)
                // .add(OneLifeBlocks.AMETHYST_ORE) -- or use vanilla amethyst?
                // .add(OneLifeBlocks.ONYX_ORE)
                // .add(OneLifeBlocks.PLATINUM_ORE)
    }

    private void incorrectForWoodTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.INCORRECT_FOR_WOOD_TOOL)
                .addTag(OneLifeBlockTags.NEEDS_FLINT_TOOL)
                .addTag(OneLifeBlockTags.NEEDS_COPPER_TOOL)
                .addTag(OneLifeBlockTags.NEEDS_BRONZE_TOOL)
                .addTag(OneLifeBlockTags.NEEDS_IRON_TOOL);
    }

    private void incorrectForFlintTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.INCORRECT_FOR_FLINT_TOOL)
                .addTag(OneLifeBlockTags.NEEDS_COPPER_TOOL)
                .addTag(OneLifeBlockTags.NEEDS_BRONZE_TOOL)
                .addTag(OneLifeBlockTags.NEEDS_IRON_TOOL);
    }

    private void incorrectForCopperTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.INCORRECT_FOR_COPPER_TOOL)
                .addTag(OneLifeBlockTags.NEEDS_BRONZE_TOOL)
                .addTag(OneLifeBlockTags.NEEDS_IRON_TOOL);
    }

    private void incorrectForBronzeTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.INCORRECT_FOR_BRONZE_TOOL)
                .addTag(OneLifeBlockTags.NEEDS_IRON_TOOL);
    }

    private void incorrectForIronTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.INCORRECT_FOR_IRON_TOOL);
    }

    private void incorrectForWroughtIronTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.INCORRECT_FOR_WROUGHT_IRON_TOOL);
    }

    private void incorrectForSteelTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.INCORRECT_FOR_STEEL_TOOL);
    }

    private void incorrectForDamascusTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.INCORRECT_FOR_DAMASCUS_TOOL);
    }

    private void incorrectForTemperedSteelTool() {
        getOrCreateTagBuilder(OneLifeBlockTags.INCORRECT_FOR_TEMPERED_STEEL_TOOL);
    }
}
