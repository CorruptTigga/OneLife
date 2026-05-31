package com.doitbetter.onelife.datagen;

import com.doitbetter.onelife.OneLife;
import com.doitbetter.onelife.component.ComponentEffect;
import com.doitbetter.onelife.component.WeaponFamily;
import com.doitbetter.onelife.component.components.*;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class OneLifeComponentProvider implements DataProvider {

    private final DataOutput output;

    public OneLifeComponentProvider(FabricDataOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();

        futures.addAll(generateHandles(writer));
        futures.addAll(generateHilts(writer));
        futures.addAll(generatePommels(writer));
        futures.addAll(generateWraps(writer));
        futures.addAll(generateGems(writer));
        futures.addAll(generateStaves(writer));
        futures.addAll(generateStrings(writer));
        futures.addAll(generateTopCaps(writer));
        futures.addAll(generateBottomCaps(writer));

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    // =========================================================================
    // HANDLES — minecraft:unbreaking, all families
    // =========================================================================
    private List<CompletableFuture<?>> generateHandles(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        List<String> woodTypes = List.of(
                "oak", "spruce", "birch", "jungle", "acacia",
                "dark_oak", "mangrove", "cherry", "bamboo", "pale_oak"
        );

        ComponentEffect unbreaking = new ComponentEffect(
                Identifier.ofVanilla("unbreaking"), false
        );

        Map<WeaponFamily, List<ComponentEffect>> effects = Map.of(
                WeaponFamily.BLADE_SWORD, List.of(unbreaking),
                WeaponFamily.BLADE_DAGGER, List.of(unbreaking),
                WeaponFamily.WAR_AXE, List.of(unbreaking),
                WeaponFamily.TOOL_AXE, List.of(unbreaking),
                WeaponFamily.POLEARM, List.of(unbreaking),
                WeaponFamily.BLUNT, List.of(unbreaking),
                WeaponFamily.TOOL, List.of(unbreaking),
                WeaponFamily.SHORTBOW, List.of(unbreaking),
                WeaponFamily.LONGBOW, List.of(unbreaking),
                WeaponFamily.STAFF, List.of(unbreaking)
        );

        for (String wood : woodTypes) {
            String name = wood + "_handle";
            HandleComponent component = new HandleComponent(
                    Identifier.of(OneLife.MOD_ID, name),
                    effects,
                    0
            );
            futures.add(save(writer, HandleComponent.CODEC, component,
                    "onelife/components/handles/" + name));
        }

        // Bone handle
        String boneName = "bone_handle";
        HandleComponent bone = new HandleComponent(
                Identifier.of(OneLife.MOD_ID, boneName),
                effects,
                0
        );
        futures.add(save(writer, HandleComponent.CODEC, bone,
                "onelife/components/handles/" + boneName));

        return futures;
    }

    // =========================================================================
    // HILTS — minecraft:sharpness, blade/blunt/polearm families only
    // =========================================================================
    private List<CompletableFuture<?>> generateHilts(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        List<String> metals = List.of(
                "copper", "bronze", "iron", "wrought_iron",
                "silver", "steel", "damascus", "tempered_steel"
        );

        ComponentEffect sharpness = new ComponentEffect(
                Identifier.ofVanilla("sharpness"), false
        );

        Map<WeaponFamily, List<ComponentEffect>> effects = Map.of(
                WeaponFamily.BLADE_SWORD, List.of(sharpness),
                WeaponFamily.BLADE_DAGGER, List.of(sharpness),
                WeaponFamily.BLUNT, List.of(sharpness),
                WeaponFamily.POLEARM, List.of(sharpness)
        );

        for (String metal : metals) {
            String name = metal + "_hilt";
            HiltComponent component = new HiltComponent(
                    Identifier.of(OneLife.MOD_ID, name),
                    effects,
                    0
            );
            futures.add(save(writer, HiltComponent.CODEC, component,
                    "onelife/components/hilts/" + name));
        }

        return futures;
    }

    // =========================================================================
    // POMMELS — minecraft:knockback, sword/dagger/blunt families only
    // =========================================================================
    private List<CompletableFuture<?>> generatePommels(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        List<String> woodTypes = List.of(
                "oak", "spruce", "birch", "jungle", "acacia",
                "dark_oak", "mangrove", "cherry", "bamboo", "pale_oak"
        );
        List<String> metals = List.of(
                "copper", "bronze", "iron", "wrought_iron",
                "silver", "steel", "damascus", "tempered_steel"
        );

        ComponentEffect knockback = new ComponentEffect(
                Identifier.ofVanilla("knockback"), false
        );

        Map<WeaponFamily, List<ComponentEffect>> effects = Map.of(
                WeaponFamily.BLADE_SWORD, List.of(knockback),
                WeaponFamily.BLADE_DAGGER, List.of(knockback),
                WeaponFamily.BLUNT, List.of(knockback)
        );

        for (String wood : woodTypes) {
            String name = wood + "_pommel";
            PommelComponent component = new PommelComponent(
                    Identifier.of(OneLife.MOD_ID, name),
                    effects,
                    0
            );
            futures.add(save(writer, PommelComponent.CODEC, component,
                    "onelife/components/pommels/" + name));
        }

        for (String metal : metals) {
            String name = metal + "_pommel";
            PommelComponent component = new PommelComponent(
                    Identifier.of(OneLife.MOD_ID, name),
                    effects,
                    0
            );
            futures.add(save(writer, PommelComponent.CODEC, component,
                    "onelife/components/pommels/" + name));
        }

        return futures;
    }

    // =========================================================================
    // WRAPS — swift_strike for weapons/bows/staffs, efficiency for tools
    // =========================================================================
    private List<CompletableFuture<?>> generateWraps(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        List<String> materials = List.of("leather", "linen", "silk", "wool");

        ComponentEffect swiftStrike = new ComponentEffect(
                Identifier.of(OneLife.MOD_ID, "swift_strike"), false
        );
        ComponentEffect efficiency = new ComponentEffect(
                Identifier.ofVanilla("efficiency"), false
        );

        Map<WeaponFamily, List<ComponentEffect>> effects = Map.of(
                WeaponFamily.BLADE_SWORD, List.of(swiftStrike),
                WeaponFamily.BLADE_DAGGER, List.of(swiftStrike),
                WeaponFamily.WAR_AXE, List.of(swiftStrike),
                WeaponFamily.POLEARM, List.of(swiftStrike),
                WeaponFamily.BLUNT, List.of(swiftStrike),
                WeaponFamily.TOOL_AXE, List.of(efficiency),
                WeaponFamily.TOOL, List.of(efficiency),
                WeaponFamily.SHORTBOW, List.of(swiftStrike),
                WeaponFamily.LONGBOW, List.of(swiftStrike),
                WeaponFamily.STAFF, List.of(swiftStrike)
        );

        for (String material : materials) {
            String name = material + "_wrap";
            WrapComponent component = new WrapComponent(
                    Identifier.of(OneLife.MOD_ID, name),
                    effects,
                    0
            );
            futures.add(save(writer, WrapComponent.CODEC, component,
                    "onelife/components/wraps/" + name));
        }

        return futures;
    }

    // =========================================================================
    // GEMS — family specific effects
    // TODO: Update with custom enchantments once Phase 4 is complete
    // =========================================================================
    private List<CompletableFuture<?>> generateGems(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();

        // Ruby — fire aspect / flame
        futures.add(saveGem(writer, "ruby",
                Map.of(
                        WeaponFamily.BLADE_SWORD, List.of(new ComponentEffect(Identifier.ofVanilla("fire_aspect"), false)),
                        WeaponFamily.BLADE_DAGGER, List.of(new ComponentEffect(Identifier.ofVanilla("fire_aspect"), false)),
                        WeaponFamily.WAR_AXE, List.of(new ComponentEffect(Identifier.ofVanilla("fire_aspect"), false)),
                        WeaponFamily.BLUNT, List.of(new ComponentEffect(Identifier.ofVanilla("fire_aspect"), false)),
                        WeaponFamily.POLEARM, List.of(new ComponentEffect(Identifier.ofVanilla("fire_aspect"), false)),
                        WeaponFamily.SHORTBOW, List.of(new ComponentEffect(Identifier.ofVanilla("flame"), true)),
                        WeaponFamily.LONGBOW, List.of(new ComponentEffect(Identifier.ofVanilla("flame"), true)),
                        WeaponFamily.STAFF, List.of(new ComponentEffect(Identifier.ofVanilla("fire_aspect"), false)),
                        WeaponFamily.TOOL, List.of(new ComponentEffect(Identifier.ofVanilla("smelting"), true))
                )
        ));

        // Sapphire — TODO: custom enchantment
        futures.add(saveGem(writer, "sapphire",
                Map.of(
                        // TODO: assign once Phase 4 custom enchantments are registered
                )
        ));

        // Amethyst — knockback/punch
        futures.add(saveGem(writer, "amethyst",
                Map.of(
                        WeaponFamily.BLADE_SWORD, List.of(new ComponentEffect(Identifier.ofVanilla("knockback"), false)),
                        WeaponFamily.BLADE_DAGGER, List.of(new ComponentEffect(Identifier.ofVanilla("knockback"), false)),
                        WeaponFamily.WAR_AXE, List.of(new ComponentEffect(Identifier.ofVanilla("knockback"), false)),
                        WeaponFamily.BLUNT, List.of(new ComponentEffect(Identifier.ofVanilla("knockback"), false)),
                        WeaponFamily.POLEARM, List.of(new ComponentEffect(Identifier.ofVanilla("knockback"), false)),
                        WeaponFamily.SHORTBOW, List.of(new ComponentEffect(Identifier.ofVanilla("punch"), false)),
                        WeaponFamily.LONGBOW, List.of(new ComponentEffect(Identifier.ofVanilla("punch"), false)),
                        WeaponFamily.STAFF, List.of(new ComponentEffect(Identifier.ofVanilla("knockback"), false)),
                        WeaponFamily.TOOL, List.of(new ComponentEffect(Identifier.ofVanilla("fortune"), false))
                )
        ));

        // Onyx — looting/silk touch
        futures.add(saveGem(writer, "onyx",
                Map.of(
                        WeaponFamily.BLADE_SWORD, List.of(new ComponentEffect(Identifier.ofVanilla("looting"), false)),
                        WeaponFamily.BLADE_DAGGER, List.of(new ComponentEffect(Identifier.ofVanilla("looting"), false)),
                        WeaponFamily.WAR_AXE, List.of(new ComponentEffect(Identifier.ofVanilla("looting"), false)),
                        WeaponFamily.BLUNT, List.of(new ComponentEffect(Identifier.ofVanilla("looting"), false)),
                        WeaponFamily.POLEARM, List.of(new ComponentEffect(Identifier.ofVanilla("looting"), false)),
                        WeaponFamily.SHORTBOW, List.of(new ComponentEffect(Identifier.ofVanilla("infinity"), true)),
                        WeaponFamily.LONGBOW, List.of(new ComponentEffect(Identifier.ofVanilla("infinity"), true)),
                        WeaponFamily.STAFF, List.of(new ComponentEffect(Identifier.ofVanilla("looting"), false)),
                        WeaponFamily.TOOL, List.of(new ComponentEffect(Identifier.ofVanilla("silk_touch"), true))
                )
        ));

        // Diamond — TODO: custom enchantment
        futures.add(saveGem(writer, "diamond",
                Map.of(
                        // TODO: assign once Phase 4 custom enchantments are registered
                )
        ));

        // Emerald — TODO: custom enchantment
        futures.add(saveGem(writer, "emerald",
                Map.of(
                        // TODO: assign once Phase 4 custom enchantments are registered
                )
        ));

        // Quartz — smite/bane
        futures.add(saveGem(writer, "quartz",
                Map.of(
                        WeaponFamily.BLADE_SWORD, List.of(new ComponentEffect(Identifier.ofVanilla("smite"), false)),
                        WeaponFamily.BLADE_DAGGER, List.of(new ComponentEffect(Identifier.ofVanilla("smite"), false)),
                        WeaponFamily.WAR_AXE, List.of(new ComponentEffect(Identifier.ofVanilla("smite"), false)),
                        WeaponFamily.BLUNT, List.of(new ComponentEffect(Identifier.ofVanilla("smite"), false)),
                        WeaponFamily.POLEARM, List.of(new ComponentEffect(Identifier.ofVanilla("smite"), false)),
                        WeaponFamily.SHORTBOW, List.of(new ComponentEffect(Identifier.ofVanilla("power"), false)),
                        WeaponFamily.LONGBOW, List.of(new ComponentEffect(Identifier.ofVanilla("power"), false)),
                        WeaponFamily.STAFF, List.of(new ComponentEffect(Identifier.ofVanilla("smite"), false)),
                        WeaponFamily.TOOL, List.of(new ComponentEffect(Identifier.ofVanilla("efficiency"), false))
                )
        ));

        // Garnet — bane of arthropods
        futures.add(saveGem(writer, "garnet",
                Map.of(
                        WeaponFamily.BLADE_SWORD, List.of(new ComponentEffect(Identifier.ofVanilla("bane_of_arthropods"), false)),
                        WeaponFamily.BLADE_DAGGER, List.of(new ComponentEffect(Identifier.ofVanilla("bane_of_arthropods"), false)),
                        WeaponFamily.WAR_AXE, List.of(new ComponentEffect(Identifier.ofVanilla("bane_of_arthropods"), false)),
                        WeaponFamily.BLUNT, List.of(new ComponentEffect(Identifier.ofVanilla("bane_of_arthropods"), false)),
                        WeaponFamily.POLEARM, List.of(new ComponentEffect(Identifier.ofVanilla("bane_of_arthropods"), false)),
                        WeaponFamily.SHORTBOW, List.of(new ComponentEffect(Identifier.ofVanilla("power"), false)),
                        WeaponFamily.LONGBOW, List.of(new ComponentEffect(Identifier.ofVanilla("power"), false)),
                        WeaponFamily.STAFF, List.of(new ComponentEffect(Identifier.ofVanilla("bane_of_arthropods"), false)),
                        WeaponFamily.TOOL, List.of(new ComponentEffect(Identifier.ofVanilla("fortune"), false))
                )
        ));

        // Topaz — TODO: custom enchantment
        futures.add(saveGem(writer, "topaz",
                Map.of(
                        // TODO: assign once Phase 4 custom enchantments are registered
                )
        ));

        // Amber — TODO: custom enchantment
        futures.add(saveGem(writer, "amber",
                Map.of(
                        // TODO: assign once Phase 4 custom enchantments are registered
                )
        ));

        return futures;
    }

    // =========================================================================
    // STAVES — power for bows, crossbow gets its own TODO
    // =========================================================================
    private List<CompletableFuture<?>> generateStaves(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        List<String> woodTypes = List.of(
                "oak", "spruce", "birch", "jungle", "acacia",
                "dark_oak", "mangrove", "cherry", "bamboo", "pale_oak"
        );

        ComponentEffect power = new ComponentEffect(
                Identifier.ofVanilla("power"), false
        );

        Map<WeaponFamily, List<ComponentEffect>> effects = Map.of(
                WeaponFamily.SHORTBOW, List.of(power),
                WeaponFamily.LONGBOW, List.of(power)
        );

        for (String wood : woodTypes) {
            String name = wood + "_stave";
            StaveComponent component = new StaveComponent(
                    Identifier.of(OneLife.MOD_ID, name),
                    effects,
                    0
            );
            futures.add(save(writer, StaveComponent.CODEC, component,
                    "onelife/components/staves/" + name));
        }

        return futures;
    }

    // =========================================================================
    // STRINGS — punch for bows
    // =========================================================================
    private List<CompletableFuture<?>> generateStrings(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        List<String> materials = List.of("linen", "silk", "leather");

        ComponentEffect punch = new ComponentEffect(
                Identifier.ofVanilla("punch"), false
        );

        Map<WeaponFamily, List<ComponentEffect>> effects = Map.of(
                WeaponFamily.SHORTBOW, List.of(punch),
                WeaponFamily.LONGBOW, List.of(punch)
        );

        for (String material : materials) {
            String name = material + "_string";
            StringComponent component = new StringComponent(
                    Identifier.of(OneLife.MOD_ID, name),
                    effects,
                    0
            );
            futures.add(save(writer, StringComponent.CODEC, component,
                    "onelife/components/strings/" + name));
        }

        return futures;
    }

    // =========================================================================
    // TOP CAPS — sharpness for staffs
    // =========================================================================
    private List<CompletableFuture<?>> generateTopCaps(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        List<String> metals = List.of(
                "copper", "bronze", "iron", "wrought_iron",
                "silver", "steel", "damascus", "tempered_steel"
        );

        ComponentEffect sharpness = new ComponentEffect(
                Identifier.ofVanilla("sharpness"), false
        );

        Map<WeaponFamily, List<ComponentEffect>> effects = Map.of(
                WeaponFamily.STAFF, List.of(sharpness)
        );

        for (String metal : metals) {
            String name = metal + "_top_cap";
            TopCapComponent component = new TopCapComponent(
                    Identifier.of(OneLife.MOD_ID, name),
                    effects,
                    0
            );
            futures.add(save(writer, TopCapComponent.CODEC, component,
                    "onelife/components/top_caps/" + name));
        }

        return futures;
    }

    // =========================================================================
    // BOTTOM CAPS — knockback for staffs
    // =========================================================================
    private List<CompletableFuture<?>> generateBottomCaps(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        List<String> metals = List.of(
                "copper", "bronze", "iron", "wrought_iron",
                "silver", "steel", "damascus", "tempered_steel"
        );

        ComponentEffect knockback = new ComponentEffect(
                Identifier.ofVanilla("knockback"), false
        );

        Map<WeaponFamily, List<ComponentEffect>> effects = Map.of(
                WeaponFamily.STAFF, List.of(knockback)
        );

        for (String metal : metals) {
            String name = metal + "_bottom_cap";
            BottomCapComponent component = new BottomCapComponent(
                    Identifier.of(OneLife.MOD_ID, name),
                    effects,
                    0
            );
            futures.add(save(writer, BottomCapComponent.CODEC, component,
                    "onelife/components/bottom_caps/" + name));
        }

        return futures;
    }

    // =========================================================================
    // HELPERS
    // =========================================================================
    private CompletableFuture<?> saveGem(DataWriter writer, String name, Map<WeaponFamily, List<ComponentEffect>> effects) {
        GemComponent component = new GemComponent(
                Identifier.of(OneLife.MOD_ID, name + "_gem"),
                effects,
                0
        );
        return save(writer, GemComponent.CODEC, component, "onelife/components/gems/" + name + "_gem");
    }

    private <T> CompletableFuture<?> save(DataWriter writer, com.mojang.serialization.Codec<T> codec, T value, String path) {
        return codec.encodeStart(JsonOps.INSTANCE, value)
                .resultOrPartial(error -> OneLife.LOGGER.error("[OneLife - ComponentProvider] Failed to encode {}: {}", path, error))
                .map(JsonElement.class::cast)
                .map(json -> DataProvider.writeToPath(writer, json, output.getPath().resolve("data").resolve(path + ".json")))
                .orElse(CompletableFuture.completedFuture(null));
    }

    @Override
    public String getName() {
        return "OneLife Component Provider";
    }
}