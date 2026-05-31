package com.doitbetter.onelife.datagen;

import com.doitbetter.onelife.tag.OneLifeItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class OneLifeItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public OneLifeItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        repairTags();
        materialTags();
    }

    private void repairTags() {
        getOrCreateTagBuilder(OneLifeItemTags.REPAIRS_WOOD_TOOL);

        getOrCreateTagBuilder(OneLifeItemTags.REPAIRS_FLINT_TOOL)
                .add(Items.FLINT);

        // TODO: Add OneLife ingots once registered in Phase 2
        // getOrCreateTagBuilder(OneLifeItemTags.REPAIRS_COPPER_TOOL).add(OneLifeItems.COPPER_INGOT);
        // getOrCreateTagBuilder(OneLifeItemTags.REPAIRS_BRONZE_TOOL).add(OneLifeItems.BRONZE_INGOT);
        // getOrCreateTagBuilder(OneLifeItemTags.REPAIRS_IRON_TOOL).add(OneLifeItems.IRON_INGOT);
        // getOrCreateTagBuilder(OneLifeItemTags.REPAIRS_WROUGHT_IRON_TOOL).add(OneLifeItems.WROUGHT_IRON_INGOT);
        // getOrCreateTagBuilder(OneLifeItemTags.REPAIRS_STEEL_TOOL).add(OneLifeItems.STEEL_INGOT);
        // getOrCreateTagBuilder(OneLifeItemTags.REPAIRS_DAMASCUS_TOOL).add(OneLifeItems.DAMASCUS_INGOT);
        // getOrCreateTagBuilder(OneLifeItemTags.REPAIRS_TEMPERED_STEEL_TOOL).add(OneLifeItems.TEMPERED_STEEL_INGOT);
    }

    private void materialTags() {
        // TODO: Add OneLife items once registered in Phase 2
        // Ingots, raw materials, gems, coins
    }
}