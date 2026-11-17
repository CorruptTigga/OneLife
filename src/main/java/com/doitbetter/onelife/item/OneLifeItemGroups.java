package com.doitbetter.onelife.item;

import com.doitbetter.onelife.OneLife;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class OneLifeItemGroups {

    public static final Identifier BUILDING_BLOCKS_GROUP_IDENTIFIER = Identifier.of(OneLife.MOD_ID, "building_blocks");
    public static final Identifier FUNCTIONAL_BLOCKS_GROUP_IDENTIFIER = Identifier.of(OneLife.MOD_ID, "functional_blocks");
    public static final Identifier TOOLS_GROUP_IDENTIFIER = Identifier.of(OneLife.MOD_ID, "tools_utilities");
    public static final Identifier COMBAT_GROUP_IDENTIFIER = Identifier.of(OneLife.MOD_ID, "combat");
    public static final Identifier FOOD_GROUP_IDENTIFIER = Identifier.of(OneLife.MOD_ID, "food_drink");
    public static final Identifier INGREDIENTS_GROUP_IDENTIFIER = Identifier.of(OneLife.MOD_ID, "ingredients");

    public static ItemGroup BUILDING_BLOCKS_GROUP = registerItemGroup(
            BUILDING_BLOCKS_GROUP_IDENTIFIER,
            () -> new ItemStack(OneLifeItems.OAK_STICK),
            ((displayContext, entries) -> {}));

    public static ItemGroup FUNCTIONAL_BLOCKS_GROUP = registerItemGroup(
            FUNCTIONAL_BLOCKS_GROUP_IDENTIFIER,
            () -> new ItemStack(OneLifeItems.OAK_STICK),
            ((displayContext, entries) -> {}));

    public static ItemGroup TOOLS_GROUP = registerItemGroup(
            TOOLS_GROUP_IDENTIFIER,
            () -> new ItemStack(OneLifeTools.TEMPERED_STEEL_PICKAXE),
            ((displayContext, entries) -> {
                entries.add(OneLifeTools.WOOD_HOE);
                entries.add(OneLifeTools.WOOD_PICKAXE);
                entries.add(OneLifeTools.WOOD_SHOVEL);
                entries.add(OneLifeTools.WOOD_AXE);

                entries.add(OneLifeTools.FLINT_HOE);
                entries.add(OneLifeTools.FLINT_PICKAXE);
                entries.add(OneLifeTools.FLINT_SHOVEL);
                entries.add(OneLifeTools.FLINT_AXE);

                entries.add(OneLifeTools.COPPER_HOE);
                entries.add(OneLifeTools.COPPER_PICKAXE);
                entries.add(OneLifeTools.COPPER_SHOVEL);
                entries.add(OneLifeTools.COPPER_AXE);

                entries.add(OneLifeTools.BRONZE_HOE);
                entries.add(OneLifeTools.BRONZE_PICKAXE);
                entries.add(OneLifeTools.BRONZE_SHOVEL);
                entries.add(OneLifeTools.BRONZE_AXE);

                entries.add(OneLifeTools.IRON_HOE);
                entries.add(OneLifeTools.IRON_PICKAXE);
                entries.add(OneLifeTools.IRON_SHOVEL);
                entries.add(OneLifeTools.IRON_AXE);

                entries.add(OneLifeTools.WROUGHT_IRON_HOE);
                entries.add(OneLifeTools.WROUGHT_IRON_PICKAXE);
                entries.add(OneLifeTools.WROUGHT_IRON_SHOVEL);
                entries.add(OneLifeTools.WROUGHT_IRON_AXE);

                entries.add(OneLifeTools.STEEL_HOE);
                entries.add(OneLifeTools.STEEL_PICKAXE);
                entries.add(OneLifeTools.STEEL_SHOVEL);
                entries.add(OneLifeTools.STEEL_AXE);

                entries.add(OneLifeTools.DAMASCUS_HOE);
                entries.add(OneLifeTools.DAMASCUS_PICKAXE);
                entries.add(OneLifeTools.DAMASCUS_SHOVEL);
                entries.add(OneLifeTools.DAMASCUS_AXE);

                entries.add(OneLifeTools.TEMPERED_STEEL_HOE);
                entries.add(OneLifeTools.TEMPERED_STEEL_PICKAXE);
                entries.add(OneLifeTools.TEMPERED_STEEL_SHOVEL);
                entries.add(OneLifeTools.TEMPERED_STEEL_AXE);
            }));

    public static ItemGroup COMBAT_GROUP = registerItemGroup(
            COMBAT_GROUP_IDENTIFIER,
            () -> new ItemStack(OneLifeWeapons.DAMASCUS_SWORD),
            ((displayContext, entries) -> {
                entries.add(OneLifeWeapons.WOOD_SWORD);
                entries.add(OneLifeWeapons.FLINT_SWORD);
                entries.add(OneLifeWeapons.COPPER_SWORD);
                entries.add(OneLifeWeapons.BRONZE_SWORD);
                entries.add(OneLifeWeapons.IRON_SWORD);
                entries.add(OneLifeWeapons.WROUGHT_IRON_SWORD);
                entries.add(OneLifeWeapons.STEEL_SWORD);
                entries.add(OneLifeWeapons.DAMASCUS_SWORD);
                entries.add(OneLifeWeapons.TEMPERED_STEEL_SWORD);

                entries.add(OneLifeWeapons.WOOD_DAGGER);
                entries.add(OneLifeWeapons.FLINT_DAGGER);
                entries.add(OneLifeWeapons.COPPER_DAGGER);
                entries.add(OneLifeWeapons.BRONZE_DAGGER);
                entries.add(OneLifeWeapons.IRON_DAGGER);
                entries.add(OneLifeWeapons.WROUGHT_IRON_DAGGER);
                entries.add(OneLifeWeapons.STEEL_DAGGER);
                entries.add(OneLifeWeapons.DAMASCUS_DAGGER);
                entries.add(OneLifeWeapons.TEMPERED_STEEL_DAGGER);

                entries.add(OneLifeWeapons.WOOD_WAR_AXE);
                entries.add(OneLifeWeapons.FLINT_WAR_AXE);
                entries.add(OneLifeWeapons.COPPER_WAR_AXE);
                entries.add(OneLifeWeapons.BRONZE_WAR_AXE);
                entries.add(OneLifeWeapons.IRON_WAR_AXE);
                entries.add(OneLifeWeapons.WROUGHT_IRON_WAR_AXE);
                entries.add(OneLifeWeapons.STEEL_WAR_AXE);
                entries.add(OneLifeWeapons.DAMASCUS_WAR_AXE);
                entries.add(OneLifeWeapons.TEMPERED_STEEL_WAR_AXE);

                entries.add(OneLifeWeapons.WOOD_POLEARM);
                entries.add(OneLifeWeapons.FLINT_POLEARM);
                entries.add(OneLifeWeapons.COPPER_POLEARM);
                entries.add(OneLifeWeapons.BRONZE_POLEARM);
                entries.add(OneLifeWeapons.IRON_POLEARM);
                entries.add(OneLifeWeapons.WROUGHT_IRON_POLEARM);
                entries.add(OneLifeWeapons.STEEL_POLEARM);
                entries.add(OneLifeWeapons.DAMASCUS_POLEARM);
                entries.add(OneLifeWeapons.TEMPERED_STEEL_POLEARM);

                entries.add(OneLifeWeapons.WOOD_BLUNT);
                entries.add(OneLifeWeapons.FLINT_BLUNT);
                entries.add(OneLifeWeapons.COPPER_BLUNT);
                entries.add(OneLifeWeapons.BRONZE_BLUNT);
                entries.add(OneLifeWeapons.IRON_BLUNT);
                entries.add(OneLifeWeapons.WROUGHT_IRON_BLUNT);
                entries.add(OneLifeWeapons.STEEL_BLUNT);
                entries.add(OneLifeWeapons.DAMASCUS_BLUNT);
                entries.add(OneLifeWeapons.TEMPERED_STEEL_BLUNT);

                entries.add(OneLifeWeapons.SHORTBOW);
                entries.add(OneLifeWeapons.LONGBOW);
                entries.add(OneLifeWeapons.STAFF);
            }));

    public static ItemGroup FOOD_GROUP = registerItemGroup(
            FOOD_GROUP_IDENTIFIER,
            () -> new ItemStack(OneLifeItems.OAK_STICK),
            ((displayContext, entries) -> {}));

    public static ItemGroup INGREDIENTS_GROUP = registerItemGroup(
            INGREDIENTS_GROUP_IDENTIFIER,
            () -> new ItemStack(OneLifeItems.OAK_STICK),
            ((displayContext, entries) -> {
                entries.add(OneLifeItems.ACACIA_STICK);
                entries.add(OneLifeItems.BAMBOO_STICK);
                entries.add(OneLifeItems.BIRCH_STICK);
                entries.add(OneLifeItems.CHERRY_STICK);
                entries.add(OneLifeItems.DARK_OAK_STICK);
                entries.add(OneLifeItems.JUNGLE_STICK);
                entries.add(OneLifeItems.MANGROVE_STICK);
                entries.add(OneLifeItems.OAK_STICK);
                entries.add(OneLifeItems.PALE_OAK_STICK);
                entries.add(OneLifeItems.SPRUCE_STICK);

                entries.add(OneLifeItems.BRASS_INGOT);
                entries.add(OneLifeItems.BRONZE_INGOT);
                entries.add(OneLifeItems.DAMASCUS_INGOT);
                entries.add(OneLifeItems.LEAD_INGOT);
                entries.add(OneLifeItems.NICKEL_INGOT);
                entries.add(OneLifeItems.PLATINUM_INGOT);
                entries.add(OneLifeItems.SILVER_INGOT);
                entries.add(OneLifeItems.STEEL_INGOT);
                entries.add(OneLifeItems.TEMPERED_STEEL_INGOT);
                entries.add(OneLifeItems.TIN_INGOT);
                entries.add(OneLifeItems.WROUGHT_IRON_INGOT);
                entries.add(OneLifeItems.ZINC_INGOT);
            }));

    /**
     * ItemGroups helper method
     * @param identifier The registry path name (e.g., "weapons_group")
     * @param iconSupplier A supplier providing the item stack for the tab's icon
     * @return The fully registered ItemGroup instance
     */
    private static ItemGroup registerItemGroup(Identifier identifier, Supplier<ItemStack> iconSupplier, ItemGroup.EntryCollector entries) {
        ItemGroup group = FabricItemGroup.builder()
                .icon(iconSupplier)
                .displayName(Text.translatable(identifier.toTranslationKey()))
                .entries(entries)
                .build();

        return Registry.register(Registries.ITEM_GROUP, identifier, group);
    }

    public static void register() {
        OneLife.LOGGER.info("Setting up Item Groups...");
    }
}
