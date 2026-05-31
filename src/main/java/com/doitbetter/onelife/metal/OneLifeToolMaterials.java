package com.doitbetter.onelife.metal;

import com.doitbetter.onelife.tag.OneLifeBlockTags;
import com.doitbetter.onelife.tag.OneLifeItemTags;
import net.minecraft.item.ToolMaterial;

public class OneLifeToolMaterials {

    public static final ToolMaterial WOOD = new ToolMaterial(
            OneLifeBlockTags.INCORRECT_FOR_WOOD_TOOL, 59, 2.0F, 0.0F, 0,
            OneLifeItemTags.REPAIRS_WOOD_TOOL
    );
    public static final ToolMaterial FLINT = new ToolMaterial(
            OneLifeBlockTags.INCORRECT_FOR_FLINT_TOOL, 131, 2.5F, 0.5F, 0,
            OneLifeItemTags.REPAIRS_FLINT_TOOL
    );
    public static final ToolMaterial COPPER = new ToolMaterial(
            OneLifeBlockTags.INCORRECT_FOR_COPPER_TOOL, 300, 3.5F, 0.5F, 0,
            OneLifeItemTags.REPAIRS_COPPER_TOOL
    );
    public static final ToolMaterial BRONZE = new ToolMaterial(
            OneLifeBlockTags.INCORRECT_FOR_BRONZE_TOOL, 500, 4.5F, 1.0F, 0,
            OneLifeItemTags.REPAIRS_BRONZE_TOOL
    );
    public static final ToolMaterial IRON = new ToolMaterial(
            OneLifeBlockTags.INCORRECT_FOR_IRON_TOOL, 750, 5.5F, 1.5F, 0,
            OneLifeItemTags.REPAIRS_IRON_TOOL
    );
    public static final ToolMaterial WROUGHT_IRON = new ToolMaterial(
            OneLifeBlockTags.INCORRECT_FOR_WROUGHT_IRON_TOOL, 1000, 6.5F, 2.0F, 0,
            OneLifeItemTags.REPAIRS_WROUGHT_IRON_TOOL
    );
    public static final ToolMaterial STEEL = new ToolMaterial(
            OneLifeBlockTags.INCORRECT_FOR_STEEL_TOOL, 1350, 7.5F, 2.5F, 0,
            OneLifeItemTags.REPAIRS_STEEL_TOOL
    );
    public static final ToolMaterial DAMASCUS = new ToolMaterial(
            OneLifeBlockTags.INCORRECT_FOR_DAMASCUS_TOOL, 1750, 9.0F, 4.0F, 0,
            OneLifeItemTags.REPAIRS_DAMASCUS_TOOL
    );
    public static final ToolMaterial TEMPERED_STEEL = new ToolMaterial(
            OneLifeBlockTags.INCORRECT_FOR_TEMPERED_STEEL_TOOL, 2100, 8.5F, 3.5F, 0,
            OneLifeItemTags.REPAIRS_TEMPERED_STEEL_TOOL
    );

    private OneLifeToolMaterials() {}
}