package com.doitbetter.onelife.datagen;

import com.doitbetter.onelife.item.OneLifeItems;
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
        registerItem(itemModelGenerator, OneLifeItems.OAK_STICK, "sticks", Models.GENERATED);
        registerItem(itemModelGenerator, OneLifeItems.ACACIA_STICK, "sticks", Models.GENERATED);

        registerItem(itemModelGenerator, OneLifeItems.SULFUR, "component", Models.GENERATED);

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
    }

    private void registerItem(ItemModelGenerator gen, Item item, String subfolder, Model model) {
        Identifier id = Identifier.of("onelife", "item/" + subfolder + "/" + item.toString().split(":")[1]);
        Identifier uploaded = model.upload(id, TextureMap.layer0(id), gen.modelCollector);
        gen.output.accept(item, ItemModels.basic(uploaded));
    }


}
