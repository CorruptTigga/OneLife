package com.doitbetter.onelife.tag;

import com.doitbetter.onelife.OneLife;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class OneLifeItemTags {

    // Metals
    public static final TagKey<Item> INGOTS = of("ingots");

    // Raw ores
    public static final TagKey<Item> RAW_MATERIALS = of("raw_materials");

    // Gems
    public static final TagKey<Item> GEMS = of("gems");
    public static final TagKey<Item> GEMS_CUT = of("gems/cut");

    // Coins
    public static final TagKey<Item> COINS = of("coins");

    // Repair ingredients per tier
    public static final TagKey<Item> REPAIRS_WOOD_TOOL = of("repairs_wood_tool");
    public static final TagKey<Item> REPAIRS_FLINT_TOOL = of("repairs_flint_tool");
    public static final TagKey<Item> REPAIRS_COPPER_TOOL = of("repairs_copper_tool");
    public static final TagKey<Item> REPAIRS_BRONZE_TOOL = of("repairs_bronze_tool");
    public static final TagKey<Item> REPAIRS_IRON_TOOL = of("repairs_iron_tool");
    public static final TagKey<Item> REPAIRS_WROUGHT_IRON_TOOL = of("repairs_wrought_iron_tool");
    public static final TagKey<Item> REPAIRS_STEEL_TOOL = of("repairs_steel_tool");
    public static final TagKey<Item> REPAIRS_DAMASCUS_TOOL = of("repairs_damascus_tool");
    public static final TagKey<Item> REPAIRS_TEMPERED_STEEL_TOOL = of("repairs_tempered_steel_tool");

    private static TagKey<Item> of(String path) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(OneLife.MOD_ID, path));
    }
}
