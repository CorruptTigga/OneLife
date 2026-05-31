package com.doitbetter.onelife.item;

import com.doitbetter.onelife.OneLife;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class OneLifeItems {

    public static final Item ACACIA_STICK = registerItem("acacia_stick", Item::new, new Item.Settings());
    public static final Item OAK_STICK = registerItem("oak_stick", Item::new, new Item.Settings());

    // =========================================================================
    // SULFUR
    // =========================================================================
    public static final Item SULFUR = registerItem("sulfur", Item::new, new Item.Settings());

    // =========================================================================
    // RAW ORES
    // =========================================================================
    public static final Item RAW_TIN = registerItem("raw_tin", Item::new, new Item.Settings());
    public static final Item RAW_SILVER = registerItem("raw_silver", Item::new, new Item.Settings());
    public static final Item RAW_ZINC = registerItem("raw_zinc", Item::new, new Item.Settings());
    public static final Item RAW_LEAD = registerItem("raw_lead", Item::new, new Item.Settings());
    public static final Item RAW_NICKEL = registerItem("raw_nickel", Item::new, new Item.Settings());
    public static final Item RAW_PLATINUM = registerItem("raw_platinum", Item::new, new Item.Settings());

    // =========================================================================
    // INGOTS
    // =========================================================================
    public static final Item TIN_INGOT = registerItem("tin_ingot", Item::new, new Item.Settings());
    public static final Item SILVER_INGOT = registerItem("silver_ingot", Item::new, new Item.Settings());
    public static final Item ZINC_INGOT = registerItem("zinc_ingot", Item::new, new Item.Settings());
    public static final Item LEAD_INGOT = registerItem("lead_ingot", Item::new, new Item.Settings());
    public static final Item NICKEL_INGOT = registerItem("nickel_ingot", Item::new, new Item.Settings());
    public static final Item PLATINUM_INGOT = registerItem("platinum_ingot", Item::new, new Item.Settings());
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", Item::new, new Item.Settings());
    public static final Item BRASS_INGOT = registerItem("brass_ingot", Item::new, new Item.Settings());
    public static final Item WROUGHT_IRON_INGOT = registerItem("wrought_iron_ingot", Item::new, new Item.Settings());
    public static final Item STEEL_INGOT = registerItem("steel_ingot", Item::new, new Item.Settings());
    public static final Item DAMASCUS_INGOT = registerItem("damascus_ingot", Item::new, new Item.Settings());
    public static final Item TEMPERED_STEEL_INGOT = registerItem("tempered_steel_ingot", Item::new, new Item.Settings());

    // =========================================================================
    // COINS
    // =========================================================================
    public static final Item COPPER_COIN = registerItem("copper_coin", Item::new, new Item.Settings());
    public static final Item SILVER_COIN = registerItem("silver_coin", Item::new, new Item.Settings());
    public static final Item GOLD_COIN = registerItem("gold_coin", Item::new, new Item.Settings());
    public static final Item PLATINUM_COIN = registerItem("platinum_coin", Item::new, new Item.Settings());

    // =========================================================================
    // GEMS — RAW
    // =========================================================================
    public static final Item RAW_RUBY = registerItem("raw_ruby", Item::new, new Item.Settings());
    public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", Item::new, new Item.Settings());
    public static final Item RAW_ONYX = registerItem("raw_onyx", Item::new, new Item.Settings());
    public static final Item RAW_DIAMOND = registerItem("raw_diamond", Item::new, new Item.Settings());
    public static final Item RAW_EMERALD = registerItem("raw_emerald", Item::new, new Item.Settings());
    public static final Item RAW_QUARTZ = registerItem("raw_quartz", Item::new, new Item.Settings());
    public static final Item RAW_GARNET = registerItem("raw_garnet", Item::new, new Item.Settings());
    public static final Item RAW_TOPAZ = registerItem("raw_topaz", Item::new, new Item.Settings());
    public static final Item AMBER = registerItem("amber", Item::new, new Item.Settings());

    // =========================================================================
    // GEMS — CUT
    // =========================================================================
    public static final Item RUBY = registerItem("ruby", Item::new, new Item.Settings());
    public static final Item SAPPHIRE = registerItem("sapphire", Item::new, new Item.Settings());
    public static final Item AMETHYST = registerItem("amethyst", Item::new, new Item.Settings());
    public static final Item ONYX = registerItem("onyx", Item::new, new Item.Settings());
    public static final Item CUT_QUARTZ = registerItem("cut_quartz", Item::new, new Item.Settings());
    public static final Item GARNET = registerItem("garnet", Item::new, new Item.Settings());
    public static final Item TOPAZ = registerItem("topaz", Item::new, new Item.Settings());
    public static final Item POLISHED_AMBER = registerItem("polished_amber", Item::new, new Item.Settings());

    private static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(OneLife.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void register() {
        OneLife.LOGGER.info("Registering Items...");
    }
}
