package com.doitbetter.onelife.datagen;

import com.doitbetter.onelife.item.OneLifeItems;
import com.doitbetter.onelife.item.OneLifeTools;
import com.doitbetter.onelife.item.OneLifeWeapons;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class OneLifeModelProvider extends FabricModelProvider {
    public OneLifeModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        registerItem(itemModelGenerator, OneLifeItems.ACACIA_STICK, "sticks", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.BAMBOO_STICK, "sticks", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.BIRCH_STICK, "sticks", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.CHERRY_STICK, "sticks", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.DARK_OAK_STICK, "sticks", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.JUNGLE_STICK, "sticks", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.MANGROVE_STICK, "sticks", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.OAK_STICK, "sticks", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.PALE_OAK_STICK, "sticks", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.SPRUCE_STICK, "sticks", Models.GENERATED);

        registerItem(itemModelGenerator, OneLifeItems.SULFUR, "reagents", Models.GENERATED);

        registerItem(itemModelGenerator, OneLifeItems.RAW_TIN, "raw-ores", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_SILVER, "raw-ores", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_ZINC, "raw-ores", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_LEAD, "raw-ores", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_NICKEL, "raw-ores", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_PLATINUM, "raw-ores", Models.GENERATED);

        registerItem(itemModelGenerator, OneLifeItems.TIN_INGOT, "ingots", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.SILVER_INGOT, "ingots", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.ZINC_INGOT, "ingots", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.LEAD_INGOT, "ingots", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.NICKEL_INGOT, "ingots", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.PLATINUM_INGOT, "ingots", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.BRONZE_INGOT, "ingots", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.BRASS_INGOT, "ingots", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.WROUGHT_IRON_INGOT, "ingots", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.STEEL_INGOT, "ingots", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.DAMASCUS_INGOT, "ingots", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.TEMPERED_STEEL_INGOT, "ingots", Models.GENERATED);

        registerItem(itemModelGenerator, OneLifeItems.COPPER_COIN, "coins", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.SILVER_COIN, "coins", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.GOLD_COIN, "coins", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.PLATINUM_COIN, "coins", Models.GENERATED);

        registerItem(itemModelGenerator, OneLifeItems.RAW_RUBY, "raw-gemstones", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_SAPPHIRE, "raw-gemstones", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_ONYX, "raw-gemstones", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_DIAMOND, "raw-gemstones", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_EMERALD, "raw-gemstones", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_QUARTZ, "raw-gemstones", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_GARNET, "raw-gemstones", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.RAW_TOPAZ, "raw-gemstones", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.AMBER, "raw-gemstones", Models.GENERATED);

        registerItem(itemModelGenerator, OneLifeItems.RUBY, "gemstones-cut", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.SAPPHIRE, "gemstones-cut", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.AMETHYST, "gemstones-cut", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.ONYX, "gemstones-cut", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.CUT_QUARTZ, "gemstones-cut", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.GARNET, "gemstones-cut", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.TOPAZ, "gemstones-cut", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.POLISHED_AMBER, "gemstones-cut", Models.GENERATED);

        registerItem(itemModelGenerator, OneLifeWeapons.WOOD_SWORD, "swords", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.FLINT_SWORD, "swords", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.COPPER_SWORD, "swords", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.BRONZE_SWORD, "swords", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.IRON_SWORD, "swords", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.WROUGHT_IRON_SWORD, "swords", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.STEEL_SWORD, "swords", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.DAMASCUS_SWORD, "swords", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.TEMPERED_STEEL_SWORD, "swords", Models.HANDHELD);

        registerItem(itemModelGenerator, OneLifeWeapons.WOOD_DAGGER, "daggers", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.FLINT_DAGGER, "daggers", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.COPPER_DAGGER, "daggers", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.BRONZE_DAGGER, "daggers", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.IRON_DAGGER, "daggers", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.WROUGHT_IRON_DAGGER, "daggers", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.STEEL_DAGGER, "daggers", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.DAMASCUS_DAGGER, "daggers", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.TEMPERED_STEEL_DAGGER, "daggers", Models.HANDHELD);

        registerItem(itemModelGenerator, OneLifeWeapons.WOOD_WAR_AXE, "war_axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.FLINT_WAR_AXE, "war_axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.COPPER_WAR_AXE, "war_axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.BRONZE_WAR_AXE, "war_axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.IRON_WAR_AXE, "war_axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.WROUGHT_IRON_WAR_AXE, "war_axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.STEEL_WAR_AXE, "war_axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.DAMASCUS_WAR_AXE, "war_axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.TEMPERED_STEEL_WAR_AXE, "war_axes", Models.HANDHELD);

        registerItem(itemModelGenerator, OneLifeWeapons.WOOD_POLEARM, "polearms", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.FLINT_POLEARM, "polearms", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.COPPER_POLEARM, "polearms", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.BRONZE_POLEARM, "polearms", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.IRON_POLEARM, "polearms", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.WROUGHT_IRON_POLEARM, "polearms", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.STEEL_POLEARM, "polearms", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.DAMASCUS_POLEARM, "polearms", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.TEMPERED_STEEL_POLEARM, "polearms", Models.HANDHELD);

        registerItem(itemModelGenerator, OneLifeWeapons.WOOD_BLUNT, "blunts", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.FLINT_BLUNT, "blunts", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.COPPER_BLUNT, "blunts", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.BRONZE_BLUNT, "blunts", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.IRON_BLUNT, "blunts", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.WROUGHT_IRON_BLUNT, "blunts", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.STEEL_BLUNT, "blunts", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.DAMASCUS_BLUNT, "blunts", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.TEMPERED_STEEL_BLUNT, "blunts", Models.HANDHELD);

        registerItem(itemModelGenerator, OneLifeWeapons.SHORTBOW, "bows", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.LONGBOW, "bows", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeWeapons.STAFF, "staffs", Models.HANDHELD);

        registerItem(itemModelGenerator, OneLifeTools.WOOD_PICKAXE, "pickaxes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.FLINT_PICKAXE, "pickaxes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.COPPER_PICKAXE, "pickaxes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.BRONZE_PICKAXE, "pickaxes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.IRON_PICKAXE, "pickaxes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.WROUGHT_IRON_PICKAXE, "pickaxes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.STEEL_PICKAXE, "pickaxes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.DAMASCUS_PICKAXE, "pickaxes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.TEMPERED_STEEL_PICKAXE, "pickaxes", Models.HANDHELD);

        registerItem(itemModelGenerator, OneLifeTools.WOOD_SHOVEL, "shovels", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.FLINT_SHOVEL, "shovels", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.COPPER_SHOVEL, "shovels", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.BRONZE_SHOVEL, "shovels", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.IRON_SHOVEL, "shovels", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.WROUGHT_IRON_SHOVEL, "shovels", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.STEEL_SHOVEL, "shovels", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.DAMASCUS_SHOVEL, "shovels", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.TEMPERED_STEEL_SHOVEL, "shovels", Models.HANDHELD);

        registerItem(itemModelGenerator, OneLifeTools.WOOD_HOE, "hoes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.FLINT_HOE, "hoes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.COPPER_HOE, "hoes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.BRONZE_HOE, "hoes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.IRON_HOE, "hoes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.WROUGHT_IRON_HOE, "hoes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.STEEL_HOE, "hoes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.DAMASCUS_HOE, "hoes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.TEMPERED_STEEL_HOE, "hoes", Models.HANDHELD);

        registerItem(itemModelGenerator, OneLifeTools.WOOD_AXE, "axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.FLINT_AXE, "axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.COPPER_AXE, "axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.BRONZE_AXE, "axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.IRON_AXE, "axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.WROUGHT_IRON_AXE, "axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.STEEL_AXE, "axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.DAMASCUS_AXE, "axes", Models.HANDHELD);
        registerItem(itemModelGenerator, OneLifeTools.TEMPERED_STEEL_AXE, "axes", Models.HANDHELD);
    }

    private void registerItem(ItemModelGenerator gen, Item item, String subfolder, Model model) {
        Identifier id = Identifier.of("onelife", "item/" + subfolder + "/" + item.toString().split(":")[1]);
        Identifier uploaded = model.upload(id, TextureMap.layer0(id), gen.modelCollector);
        gen.output.accept(item, ItemModels.basic(uploaded));
    }


}
