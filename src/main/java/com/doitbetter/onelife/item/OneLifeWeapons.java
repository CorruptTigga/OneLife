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

public class OneLifeWeapons {

    // =========================================================================
    // SWORDS — 9 tiers
    // =========================================================================
    public static final Item WOOD_SWORD = register("wood_sword", s -> new OneLifeSwordItem(OneLifeToolMaterials.WOOD, 3.0f, -2.4f, s));
    public static final Item FLINT_SWORD = register("flint_sword", s -> new OneLifeSwordItem(OneLifeToolMaterials.FLINT, 3.0f, -2.4f, s));
    public static final Item COPPER_SWORD = register("copper_sword", s -> new OneLifeSwordItem(OneLifeToolMaterials.COPPER, 3.0f, -2.4f, s));
    public static final Item BRONZE_SWORD = register("bronze_sword", s -> new OneLifeSwordItem(OneLifeToolMaterials.BRONZE, 3.0f, -2.4f, s));
    public static final Item IRON_SWORD = register("iron_sword", s -> new OneLifeSwordItem(OneLifeToolMaterials.IRON, 3.0f, -2.4f, s));
    public static final Item WROUGHT_IRON_SWORD = register("wrought_iron_sword", s -> new OneLifeSwordItem(OneLifeToolMaterials.WROUGHT_IRON, 3.0f, -2.4f, s));
    public static final Item STEEL_SWORD = register("steel_sword", s -> new OneLifeSwordItem(OneLifeToolMaterials.STEEL, 3.0f, -2.4f, s));
    public static final Item DAMASCUS_SWORD = register("damascus_sword", s -> new OneLifeSwordItem(OneLifeToolMaterials.DAMASCUS, 3.0f, -2.4f, s));
    public static final Item TEMPERED_STEEL_SWORD = register("tempered_steel_sword", s -> new OneLifeSwordItem(OneLifeToolMaterials.TEMPERED_STEEL, 3.0f, -2.4f, s));

    // =========================================================================
    // DAGGERS — 9 tiers
    // =========================================================================
    public static final Item WOOD_DAGGER = register("wood_dagger", s -> new OneLifeDaggerItem(OneLifeToolMaterials.WOOD, 2.0f, -1.6f, s));
    public static final Item FLINT_DAGGER = register("flint_dagger", s -> new OneLifeDaggerItem(OneLifeToolMaterials.FLINT, 2.0f, -1.6f, s));
    public static final Item COPPER_DAGGER = register("copper_dagger", s -> new OneLifeDaggerItem(OneLifeToolMaterials.COPPER, 2.0f, -1.6f, s));
    public static final Item BRONZE_DAGGER = register("bronze_dagger", s -> new OneLifeDaggerItem(OneLifeToolMaterials.BRONZE, 2.0f, -1.6f, s));
    public static final Item IRON_DAGGER = register("iron_dagger", s -> new OneLifeDaggerItem(OneLifeToolMaterials.IRON, 2.0f, -1.6f, s));
    public static final Item WROUGHT_IRON_DAGGER = register("wrought_iron_dagger", s -> new OneLifeDaggerItem(OneLifeToolMaterials.WROUGHT_IRON, 2.0f, -1.6f, s));
    public static final Item STEEL_DAGGER = register("steel_dagger", s -> new OneLifeDaggerItem(OneLifeToolMaterials.STEEL, 2.0f, -1.6f, s));
    public static final Item DAMASCUS_DAGGER = register("damascus_dagger", s -> new OneLifeDaggerItem(OneLifeToolMaterials.DAMASCUS, 2.0f, -1.6f, s));
    public static final Item TEMPERED_STEEL_DAGGER = register("tempered_steel_dagger", s -> new OneLifeDaggerItem(OneLifeToolMaterials.TEMPERED_STEEL, 2.0f, -1.6f, s));

    // =========================================================================
    // WAR AXES — 9 tiers
    // =========================================================================
    public static final Item WOOD_WAR_AXE = register("wood_war_axe", s -> new OneLifeWarAxeItem(OneLifeToolMaterials.WOOD, 5.0f, -3.2f, s));
    public static final Item FLINT_WAR_AXE = register("flint_war_axe", s -> new OneLifeWarAxeItem(OneLifeToolMaterials.FLINT, 5.0f, -3.2f, s));
    public static final Item COPPER_WAR_AXE = register("copper_war_axe", s -> new OneLifeWarAxeItem(OneLifeToolMaterials.COPPER, 5.0f, -3.2f, s));
    public static final Item BRONZE_WAR_AXE = register("bronze_war_axe", s -> new OneLifeWarAxeItem(OneLifeToolMaterials.BRONZE, 5.0f, -3.2f, s));
    public static final Item IRON_WAR_AXE = register("iron_war_axe", s -> new OneLifeWarAxeItem(OneLifeToolMaterials.IRON, 5.0f, -3.2f, s));
    public static final Item WROUGHT_IRON_WAR_AXE = register("wrought_iron_war_axe", s -> new OneLifeWarAxeItem(OneLifeToolMaterials.WROUGHT_IRON, 5.0f, -3.2f, s));
    public static final Item STEEL_WAR_AXE = register("steel_war_axe", s -> new OneLifeWarAxeItem(OneLifeToolMaterials.STEEL, 5.0f, -3.2f, s));
    public static final Item DAMASCUS_WAR_AXE = register("damascus_war_axe", s -> new OneLifeWarAxeItem(OneLifeToolMaterials.DAMASCUS, 5.0f, -3.2f, s));
    public static final Item TEMPERED_STEEL_WAR_AXE = register("tempered_steel_war_axe", s -> new OneLifeWarAxeItem(OneLifeToolMaterials.TEMPERED_STEEL, 5.0f, -3.2f, s));

    // =========================================================================
    // POLEARMS — 9 tiers
    // =========================================================================
    public static final Item WOOD_POLEARM = register("wood_polearm", s -> new OneLifePolearmItem(OneLifeToolMaterials.WOOD, 4.0f, -2.8f, s));
    public static final Item FLINT_POLEARM = register("flint_polearm", s -> new OneLifePolearmItem(OneLifeToolMaterials.FLINT, 4.0f, -2.8f, s));
    public static final Item COPPER_POLEARM = register("copper_polearm", s -> new OneLifePolearmItem(OneLifeToolMaterials.COPPER, 4.0f, -2.8f, s));
    public static final Item BRONZE_POLEARM = register("bronze_polearm", s -> new OneLifePolearmItem(OneLifeToolMaterials.BRONZE, 4.0f, -2.8f, s));
    public static final Item IRON_POLEARM = register("iron_polearm", s -> new OneLifePolearmItem(OneLifeToolMaterials.IRON, 4.0f, -2.8f, s));
    public static final Item WROUGHT_IRON_POLEARM = register("wrought_iron_polearm", s -> new OneLifePolearmItem(OneLifeToolMaterials.WROUGHT_IRON, 4.0f, -2.8f, s));
    public static final Item STEEL_POLEARM = register("steel_polearm", s -> new OneLifePolearmItem(OneLifeToolMaterials.STEEL, 4.0f, -2.8f, s));
    public static final Item DAMASCUS_POLEARM = register("damascus_polearm", s -> new OneLifePolearmItem(OneLifeToolMaterials.DAMASCUS, 4.0f, -2.8f, s));
    public static final Item TEMPERED_STEEL_POLEARM = register("tempered_steel_polearm", s -> new OneLifePolearmItem(OneLifeToolMaterials.TEMPERED_STEEL, 4.0f, -2.8f, s));

    // =========================================================================
    // BLUNT — 9 tiers
    // =========================================================================
    public static final Item WOOD_BLUNT = register("wood_blunt", s -> new OneLifeBluntItem(OneLifeToolMaterials.WOOD, 4.5f, -3.0f, s));
    public static final Item FLINT_BLUNT = register("flint_blunt", s -> new OneLifeBluntItem(OneLifeToolMaterials.FLINT, 4.5f, -3.0f, s));
    public static final Item COPPER_BLUNT = register("copper_blunt", s -> new OneLifeBluntItem(OneLifeToolMaterials.COPPER, 4.5f, -3.0f, s));
    public static final Item BRONZE_BLUNT = register("bronze_blunt", s -> new OneLifeBluntItem(OneLifeToolMaterials.BRONZE, 4.5f, -3.0f, s));
    public static final Item IRON_BLUNT = register("iron_blunt", s -> new OneLifeBluntItem(OneLifeToolMaterials.IRON, 4.5f, -3.0f, s));
    public static final Item WROUGHT_IRON_BLUNT = register("wrought_iron_blunt", s -> new OneLifeBluntItem(OneLifeToolMaterials.WROUGHT_IRON, 4.5f, -3.0f, s));
    public static final Item STEEL_BLUNT = register("steel_blunt", s -> new OneLifeBluntItem(OneLifeToolMaterials.STEEL, 4.5f, -3.0f, s));
    public static final Item DAMASCUS_BLUNT = register("damascus_blunt", s -> new OneLifeBluntItem(OneLifeToolMaterials.DAMASCUS, 4.5f, -3.0f, s));
    public static final Item TEMPERED_STEEL_BLUNT = register("tempered_steel_blunt", s -> new OneLifeBluntItem(OneLifeToolMaterials.TEMPERED_STEEL, 4.5f, -3.0f, s));

    // =========================================================================
    // SHORTBOW — single item
    // =========================================================================
    public static final Item SHORTBOW = register("shortbow", s -> new OneLifeShortbowItem(s.maxDamage(384)));

    // =========================================================================
    // LONGBOW — single item
    // =========================================================================
    public static final Item LONGBOW = register("longbow", s -> new OneLifeLongbowItem(s.maxDamage(500)));

    // =========================================================================
    // STAFF — single item, WOOD material, top cap drives tier
    // =========================================================================
    public static final Item STAFF = register("staff", s -> new OneLifeStaffItem(OneLifeToolMaterials.WOOD, 2.0f, -2.0f, s));

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