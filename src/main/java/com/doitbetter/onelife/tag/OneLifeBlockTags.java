package com.doitbetter.onelife.tag;

import com.doitbetter.onelife.OneLife;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class OneLifeBlockTags {

    // Incorrect for tier — references needs_ tags above that tier's capability
    public static final TagKey<Block> INCORRECT_FOR_WOOD_TOOL = of("incorrect_for_wood_tool");
    public static final TagKey<Block> INCORRECT_FOR_FLINT_TOOL = of("incorrect_for_flint_tool");
    public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = of("incorrect_for_copper_tool");
    public static final TagKey<Block> INCORRECT_FOR_BRONZE_TOOL = of("incorrect_for_bronze_tool");
    public static final TagKey<Block> INCORRECT_FOR_IRON_TOOL = of("incorrect_for_iron_tool");
    public static final TagKey<Block> INCORRECT_FOR_WROUGHT_IRON_TOOL = of("incorrect_for_wrought_iron_tool");
    public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = of("incorrect_for_steel_tool");
    public static final TagKey<Block> INCORRECT_FOR_DAMASCUS_TOOL = of("incorrect_for_damascus_tool");
    public static final TagKey<Block> INCORRECT_FOR_TEMPERED_STEEL_TOOL = of("incorrect_for_tempered_steel_tool");

    // Needs tier — actual block assignments
    public static final TagKey<Block> NEEDS_FLINT_TOOL = of("needs_flint_tool");
    public static final TagKey<Block> NEEDS_COPPER_TOOL = of("needs_copper_tool");
    public static final TagKey<Block> NEEDS_BRONZE_TOOL = of("needs_bronze_tool");
    public static final TagKey<Block> NEEDS_IRON_TOOL = of("needs_iron_tool");
    public static final TagKey<Block> NEEDS_WROUGHT_IRON_TOOL = of("needs_wrought_iron_tool");
    public static final TagKey<Block> NEEDS_STEEL_TOOL = of("needs_steel_tool");
    public static final TagKey<Block> NEEDS_DAMASCUS_TOOL = of("needs_damascus_tool");
    public static final TagKey<Block> NEEDS_TEMPERED_STEEL_TOOL = of("needs_tempered_steel_tool");

    private static TagKey<Block> of(String path) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(OneLife.MOD_ID, path));
    }
}
