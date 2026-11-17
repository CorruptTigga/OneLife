package com.doitbetter.onelife.item;

import com.doitbetter.onelife.OneLife;
import com.doitbetter.onelife.item.items.*;
import com.doitbetter.onelife.metal.OneLifeToolMaterials;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class OneLifeTools {

    // =========================================================================
    // PICKAXES — 9 tiers
    // =========================================================================
    public static final Item WOOD_PICKAXE = register("wood_pickaxe", s -> new OneLifePickaxeItem(OneLifeToolMaterials.WOOD, 1.0f, -2.8f, s));
    public static final Item FLINT_PICKAXE = register("flint_pickaxe", s -> new OneLifePickaxeItem(OneLifeToolMaterials.FLINT, 1.0f, -2.8f, s));
    public static final Item COPPER_PICKAXE = register("copper_pickaxe", s -> new OneLifePickaxeItem(OneLifeToolMaterials.COPPER, 1.0f, -2.8f, s));
    public static final Item BRONZE_PICKAXE = register("bronze_pickaxe", s -> new OneLifePickaxeItem(OneLifeToolMaterials.BRONZE, 1.0f, -2.8f, s));
    public static final Item IRON_PICKAXE = register("iron_pickaxe", s -> new OneLifePickaxeItem(OneLifeToolMaterials.IRON, 1.0f, -2.8f, s));
    public static final Item WROUGHT_IRON_PICKAXE = register("wrought_iron_pickaxe", s -> new OneLifePickaxeItem(OneLifeToolMaterials.WROUGHT_IRON, 1.0f, -2.8f, s));
    public static final Item STEEL_PICKAXE = register("steel_pickaxe", s -> new OneLifePickaxeItem(OneLifeToolMaterials.STEEL, 1.0f, -2.8f, s));
    public static final Item DAMASCUS_PICKAXE = register("damascus_pickaxe", s -> new OneLifePickaxeItem(OneLifeToolMaterials.DAMASCUS, 1.0f, -2.8f, s));
    public static final Item TEMPERED_STEEL_PICKAXE = register("tempered_steel_pickaxe", s -> new OneLifePickaxeItem(OneLifeToolMaterials.TEMPERED_STEEL, 1.0f, -2.8f, s));

    // =========================================================================
    // SHOVELS — 9 tiers
    // =========================================================================
    public static final Item WOOD_SHOVEL = register("wood_shovel", s -> new OneLifeShovelItem(OneLifeToolMaterials.WOOD, 1.5f, -3.0f, s));
    public static final Item FLINT_SHOVEL = register("flint_shovel", s -> new OneLifeShovelItem(OneLifeToolMaterials.FLINT, 1.5f, -3.0f, s));
    public static final Item COPPER_SHOVEL = register("copper_shovel", s -> new OneLifeShovelItem(OneLifeToolMaterials.COPPER, 1.5f, -3.0f, s));
    public static final Item BRONZE_SHOVEL = register("bronze_shovel", s -> new OneLifeShovelItem(OneLifeToolMaterials.BRONZE, 1.5f, -3.0f, s));
    public static final Item IRON_SHOVEL = register("iron_shovel", s -> new OneLifeShovelItem(OneLifeToolMaterials.IRON, 1.5f, -3.0f, s));
    public static final Item WROUGHT_IRON_SHOVEL = register("wrought_iron_shovel", s -> new OneLifeShovelItem(OneLifeToolMaterials.WROUGHT_IRON, 1.5f, -3.0f, s));
    public static final Item STEEL_SHOVEL = register("steel_shovel", s -> new OneLifeShovelItem(OneLifeToolMaterials.STEEL, 1.5f, -3.0f, s));
    public static final Item DAMASCUS_SHOVEL = register("damascus_shovel", s -> new OneLifeShovelItem(OneLifeToolMaterials.DAMASCUS, 1.5f, -3.0f, s));
    public static final Item TEMPERED_STEEL_SHOVEL = register("tempered_steel_shovel", s -> new OneLifeShovelItem(OneLifeToolMaterials.TEMPERED_STEEL, 1.5f, -3.0f, s));

    // =========================================================================
    // HOES — 9 tiers
    // =========================================================================
    public static final Item WOOD_HOE = register("wood_hoe", s -> new OneLifeHoeItem(OneLifeToolMaterials.WOOD, 0.0f, -3.0f, s));
    public static final Item FLINT_HOE = register("flint_hoe", s -> new OneLifeHoeItem(OneLifeToolMaterials.FLINT, 0.0f, -3.0f, s));
    public static final Item COPPER_HOE = register("copper_hoe", s -> new OneLifeHoeItem(OneLifeToolMaterials.COPPER, 0.0f, -3.0f, s));
    public static final Item BRONZE_HOE = register("bronze_hoe", s -> new OneLifeHoeItem(OneLifeToolMaterials.BRONZE, 0.0f, -3.0f, s));
    public static final Item IRON_HOE = register("iron_hoe", s -> new OneLifeHoeItem(OneLifeToolMaterials.IRON, 0.0f, -3.0f, s));
    public static final Item WROUGHT_IRON_HOE = register("wrought_iron_hoe", s -> new OneLifeHoeItem(OneLifeToolMaterials.WROUGHT_IRON, 0.0f, -3.0f, s));
    public static final Item STEEL_HOE = register("steel_hoe", s -> new OneLifeHoeItem(OneLifeToolMaterials.STEEL, 0.0f, -3.0f, s));
    public static final Item DAMASCUS_HOE = register("damascus_hoe", s -> new OneLifeHoeItem(OneLifeToolMaterials.DAMASCUS, 0.0f, -3.0f, s));
    public static final Item TEMPERED_STEEL_HOE = register("tempered_steel_hoe", s -> new OneLifeHoeItem(OneLifeToolMaterials.TEMPERED_STEEL, 0.0f, -3.0f, s));

    // =========================================================================
    // TOOL AXES — 9 tiers
    // =========================================================================
    public static final Item WOOD_AXE = register("wood_axe", s -> new OneLifeAxeItem(OneLifeToolMaterials.WOOD, 6.0f, -3.2f, s));
    public static final Item FLINT_AXE = register("flint_axe", s -> new OneLifeAxeItem(OneLifeToolMaterials.FLINT, 6.0f, -3.2f, s));
    public static final Item COPPER_AXE = register("copper_axe", s -> new OneLifeAxeItem(OneLifeToolMaterials.COPPER, 6.0f, -3.2f, s));
    public static final Item BRONZE_AXE = register("bronze_axe", s -> new OneLifeAxeItem(OneLifeToolMaterials.BRONZE, 6.0f, -3.2f, s));
    public static final Item IRON_AXE = register("iron_axe", s -> new OneLifeAxeItem(OneLifeToolMaterials.IRON, 6.0f, -3.2f, s));
    public static final Item WROUGHT_IRON_AXE = register("wrought_iron_axe", s -> new OneLifeAxeItem(OneLifeToolMaterials.WROUGHT_IRON, 6.0f, -3.2f, s));
    public static final Item STEEL_AXE = register("steel_axe", s -> new OneLifeAxeItem(OneLifeToolMaterials.STEEL, 6.0f, -3.2f, s));
    public static final Item DAMASCUS_AXE = register("damascus_axe", s -> new OneLifeAxeItem(OneLifeToolMaterials.DAMASCUS, 6.0f, -3.2f, s));
    public static final Item TEMPERED_STEEL_AXE = register("tempered_steel_axe", s -> new OneLifeAxeItem(OneLifeToolMaterials.TEMPERED_STEEL, 6.0f, -3.2f, s));

    // =========================================================================
    // REGISTRATION
    // =========================================================================
    private static Item register(String name, Function<Item.Settings, Item> factory) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(OneLife.MOD_ID, name));
        Item item = factory.apply(new Item.Settings().registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void register() {}
}