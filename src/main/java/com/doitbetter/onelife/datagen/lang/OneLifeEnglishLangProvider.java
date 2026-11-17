package com.doitbetter.onelife.datagen.lang;

import com.doitbetter.onelife.OneLife;
import com.doitbetter.onelife.item.OneLifeItemGroups;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class OneLifeEnglishLangProvider extends FabricLanguageProvider {

    public OneLifeEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        // We pass the string prefix ("item" or "block") to generate clean translation keys
        translationBuilder.add(OneLifeItemGroups.BUILDING_BLOCKS_GROUP_IDENTIFIER, "Building Blocks");
        translationBuilder.add(OneLifeItemGroups.FUNCTIONAL_BLOCKS_GROUP_IDENTIFIER, "Functional Blocks");
        translationBuilder.add(OneLifeItemGroups.TOOLS_GROUP_IDENTIFIER, "Tools & Utilities");
        translationBuilder.add(OneLifeItemGroups.COMBAT_GROUP_IDENTIFIER, "Combat");
        translationBuilder.add(OneLifeItemGroups.FOOD_GROUP_IDENTIFIER, "Food & Drink");
        translationBuilder.add(OneLifeItemGroups.INGREDIENTS_GROUP_IDENTIFIER, "Ingredients");

        autoTranslate(registryLookup, translationBuilder, RegistryKeys.ITEM, "item");
        autoTranslate(registryLookup, translationBuilder, RegistryKeys.BLOCK, "block");
    }

    private <T> void autoTranslate(RegistryWrapper.WrapperLookup registryLookup,
                                   TranslationBuilder translationBuilder,
                                   RegistryKey<Registry<T>> registryKey,
                                   String prefix) {
        registryLookup.getOrThrow(registryKey)
                .streamEntries()
                .filter(e -> e.registryKey().getValue().getNamespace().equals(OneLife.MOD_ID))
                .forEach(e -> {
                    net.minecraft.util.Identifier id = e.registryKey().getValue();

                    // Using Minecraft's native helper method to cleanly generate "prefix.namespace.path"
                    String translationKey = net.minecraft.util.Util.createTranslationKey(prefix, id);

                    translationBuilder.add(translationKey, toTitleCase(id.getPath()));
                });
    }

    private String toTitleCase(String path) {
        // Edge-case check for empty paths or issues splitting strings
        if (path == null || path.isEmpty()) return "";

        return Arrays.stream(path.split("_"))
                .filter(word -> !word.isEmpty())
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }
}