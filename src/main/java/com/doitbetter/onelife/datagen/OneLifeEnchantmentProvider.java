package com.doitbetter.onelife.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class OneLifeEnchantmentProvider implements DataProvider {

    private final DataOutput output;

    public OneLifeEnchantmentProvider(FabricDataOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();

        // =========================================================================
        // WEAPON ENCHANTMENTS
        // =========================================================================
        futures.add(save(writer, "swift_strike", buildSwiftStrike()));
        futures.add(save(writer, "stagger", buildStagger()));
        futures.add(save(writer, "precision", buildPrecision()));
        futures.add(save(writer, "cleave", buildCleave()));
        futures.add(save(writer, "bleed", buildBleed()));
        futures.add(save(writer, "penetrate", buildPenetrate()));
        futures.add(save(writer, "cripple", buildCripple()));
        futures.add(save(writer, "stun", buildStun()));

        // =========================================================================
        // TOOL ENCHANTMENTS
        // =========================================================================
        futures.add(save(writer, "temper", buildTemper()));
        futures.add(save(writer, "hone", buildHone()));

        // =========================================================================
        // UNIVERSAL ENCHANTMENTS
        // =========================================================================
        futures.add(save(writer, "warding", buildWarding()));
        futures.add(save(writer, "tracking", buildTracking()));
        futures.add(save(writer, "resonance", buildResonance()));

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    // =========================================================================
    // WEAPON ENCHANTMENT BUILDERS
    // =========================================================================

    private JsonObject buildSwiftStrike() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.swift_strike",
                "#onelife:enchantable/weapons",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonObject attribute = new JsonObject();
        attribute.addProperty("type", "minecraft:attribute");
        attribute.addProperty("attribute", "minecraft:attack_speed");
        attribute.addProperty("operation", "add_value");
        JsonObject amount = new JsonObject();
        amount.addProperty("type", "minecraft:linear");
        amount.addProperty("base", 0.5);
        amount.addProperty("per_level_above_first", 0.5);
        attribute.add("amount", amount);
        attribute.addProperty("id", "onelife:swift_strike");
        JsonArray attributeArray = new JsonArray();
        attributeArray.add(attribute);
        effects.add("minecraft:attributes", attributeArray);
        json.add("effects", effects);
        return json;
    }

    private JsonObject buildStagger() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.stagger",
                "#onelife:enchantable/weapons",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonArray postAttack = new JsonArray();
        JsonObject entry = postAttackEntry("victim", "attacker");
        JsonObject effect = new JsonObject();
        effect.addProperty("type", "minecraft:apply_mob_effect");
        JsonArray toApply = new JsonArray();
        toApply.add("minecraft:mining_fatigue");
        effect.add("to_apply", toApply);
        effect.add("min_duration", linear(1.0, 0.5));
        effect.add("max_duration", linear(2.0, 0.5));
        addConstant(effect, "min_amplifier", 0);
        addConstant(effect, "max_amplifier", 0);
        entry.add("effect", effect);
        entry.add("requirements", randomChance(0.15));
        postAttack.add(entry);
        effects.add("minecraft:post_attack", postAttack);
        json.add("effects", effects);
        return json;
    }

    private JsonObject buildPrecision() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.precision",
                "#onelife:enchantable/weapons",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonArray damage = new JsonArray();
        JsonObject entry = new JsonObject();
        JsonObject effect = new JsonObject();
        effect.addProperty("type", "minecraft:add");
        effect.add("value", linear(0.5, 0.5));
        entry.add("effect", effect);
        damage.add(entry);
        effects.add("minecraft:damage", damage);
        json.add("effects", effects);
        return json;
    }

    private JsonObject buildCleave() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.cleave",
                "#onelife:enchantable/weapons",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonArray postAttack = new JsonArray();
        JsonObject entry = postAttackEntry("victim", "attacker");
        JsonObject effect = new JsonObject();
        effect.addProperty("type", "minecraft:explode");
        effect.addProperty("attribute_to_user", true);
        effect.add("radius", linear(1.5, 0.5));
        effect.addProperty("block_interaction", "none");
        effect.addProperty("create_fire", false);
        JsonObject smallParticle = new JsonObject();
        smallParticle.addProperty("type", "minecraft:sweep_attack");
        JsonObject largeParticle = new JsonObject();
        largeParticle.addProperty("type", "minecraft:sweep_attack");
        effect.add("small_particle", smallParticle);
        effect.add("large_particle", largeParticle);
        effect.addProperty("sound", "minecraft:enchant.thorns.hit");
        entry.add("effect", effect);
        postAttack.add(entry);
        effects.add("minecraft:post_attack", postAttack);
        json.add("effects", effects);
        return json;
    }

    private JsonObject buildBleed() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.bleed",
                "#onelife:enchantable/weapons",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonArray postAttack = new JsonArray();
        JsonObject entry = postAttackEntry("victim", "attacker");
        JsonObject effect = new JsonObject();
        effect.addProperty("type", "minecraft:apply_mob_effect");
        JsonArray toApply = new JsonArray();
        toApply.add("minecraft:poison");
        effect.add("to_apply", toApply);
        effect.add("min_duration", linear(2.0, 1.0));
        effect.add("max_duration", linear(3.0, 1.0));
        addConstant(effect, "min_amplifier", 0.0);
        addConstant(effect, "max_amplifier", 1.0);
        entry.add("effect", effect);
        postAttack.add(entry);
        effects.add("minecraft:post_attack", postAttack);
        json.add("effects", effects);
        return json;
    }

    private JsonObject buildPenetrate() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.penetrate",
                "#onelife:enchantable/weapons",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonArray armorArray = new JsonArray();  // wrap in array
        JsonObject entry = new JsonObject();
        JsonObject effect = new JsonObject();
        effect.addProperty("type", "minecraft:add");
        effect.add("value", linear(-0.1, -0.1));
        entry.add("effect", effect);
        armorArray.add(entry);
        effects.add("minecraft:armor_effectiveness", armorArray);  // array not object
        json.add("effects", effects);
        return json;
    }

    private JsonObject buildCripple() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.cripple",
                "#onelife:enchantable/weapons",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonArray postAttack = new JsonArray();
        JsonObject entry = postAttackEntry("victim", "attacker");
        JsonObject effect = new JsonObject();
        effect.addProperty("type", "minecraft:apply_mob_effect");
        JsonArray toApply = new JsonArray();
        toApply.add("minecraft:slowness");
        effect.add("to_apply", toApply);
        effect.add("min_duration", linear(2.0, 1.0));
        effect.add("max_duration", linear(3.0, 1.0));
        addConstant(effect, "min_amplifier", 0);
        addConstant(effect, "max_amplifier", 1.0);
        entry.add("effect", effect);
        entry.add("requirements", randomChance(0.2));
        postAttack.add(entry);
        effects.add("minecraft:post_attack", postAttack);
        json.add("effects", effects);
        return json;
    }

    private JsonObject buildStun() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.stun",
                "#onelife:enchantable/weapons",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonArray postAttack = new JsonArray();
        JsonObject entry = postAttackEntry("victim", "attacker");
        JsonObject effect = new JsonObject();
        effect.addProperty("type", "minecraft:apply_mob_effect");
        JsonArray toApply = new JsonArray();
        toApply.add("minecraft:slowness");
        toApply.add("minecraft:mining_fatigue");
        effect.add("to_apply", toApply);
        effect.add("min_duration", linear(1.0, 0.5));
        effect.add("max_duration", linear(2.0, 0.5));
        addConstant(effect, "min_amplifier", 4);
        addConstant(effect, "max_amplifier", 4);
        entry.add("effect", effect);
        entry.add("requirements", randomChance(0.1));
        postAttack.add(entry);
        effects.add("minecraft:post_attack", postAttack);
        json.add("effects", effects);
        return json;
    }

    // =========================================================================
    // TOOL ENCHANTMENT BUILDERS
    // =========================================================================

    private JsonObject buildTemper() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.temper",
                "#onelife:enchantable/tools",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonArray damageArray = new JsonArray();  // wrap in array
        JsonObject entry = new JsonObject();
        JsonObject effect = new JsonObject();
        effect.addProperty("type", "minecraft:add");
        effect.add("value", linear(-0.1, -0.1));
        entry.add("effect", effect);
        damageArray.add(entry);
        effects.add("minecraft:item_damage", damageArray);  // array not object
        json.add("effects", effects);
        return json;
    }

    private JsonObject buildHone() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.hone",
                "#onelife:enchantable/tools",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonObject attribute = new JsonObject();
        attribute.addProperty("type", "minecraft:attribute");
        attribute.addProperty("attribute", "minecraft:block_break_speed");
        attribute.addProperty("operation", "add_value");
        attribute.add("amount", linear(0.5, 0.5));
        attribute.addProperty("id", "onelife:hone");
        JsonArray attributeArray = new JsonArray();
        attributeArray.add(attribute);
        effects.add("minecraft:attributes", attributeArray);
        json.add("effects", effects);
        return json;
    }

    // =========================================================================
    // UNIVERSAL ENCHANTMENT BUILDERS
    // =========================================================================

    private JsonObject buildWarding() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.warding",
                "#onelife:enchantable/armor",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonArray protection = new JsonArray();
        JsonObject entry = new JsonObject();
        JsonObject effect = new JsonObject();
        effect.addProperty("type", "minecraft:add");
        effect.add("value", linear(1.0, 1.0));
        entry.add("effect", effect);
        protection.add(entry);
        effects.add("minecraft:damage_protection", protection);
        json.add("effects", effects);
        return json;
    }

    private JsonObject buildTracking() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.tracking",
                "#onelife:enchantable/bows",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonArray postAttack = new JsonArray();
        JsonObject entry = postAttackEntry("victim", "attacker");
        JsonObject effect = new JsonObject();
        effect.addProperty("type", "minecraft:apply_mob_effect");
        JsonArray toApply = new JsonArray();
        toApply.add("minecraft:glowing");
        effect.add("to_apply", toApply);
        effect.add("min_duration", linear(5.0, 3.0));
        effect.add("max_duration", linear(8.0, 3.0));
        addConstant(effect, "min_amplifier", 0);
        addConstant(effect, "max_amplifier", 0);
        entry.add("effect", effect);
        postAttack.add(entry);
        effects.add("minecraft:post_attack", postAttack);
        json.add("effects", effects);
        return json;
    }

    private JsonObject buildResonance() {
        JsonObject json = baseEnchantment(
                "enchantment.onelife.resonance",
                "#onelife:enchantable/staffs",
                5, 999, 9999
        );
        JsonObject effects = new JsonObject();
        JsonArray postAttack = new JsonArray();
        JsonObject entry = postAttackEntry("victim", "attacker");
        JsonObject effect = new JsonObject();
        effect.addProperty("type", "minecraft:explode");
        effect.addProperty("attribute_to_user", true);
        effect.add("radius", linear(2.0, 1.0));
        effect.addProperty("block_interaction", "none");
        effect.addProperty("create_fire", false);
        JsonObject smallParticle = new JsonObject();
        smallParticle.addProperty("type", "minecraft:enchanted_hit");
        JsonObject largeParticle = new JsonObject();
        largeParticle.addProperty("type", "minecraft:enchanted_hit");
        effect.add("small_particle", smallParticle);
        effect.add("large_particle", largeParticle);
        effect.addProperty("sound", "minecraft:block.amethyst_block.chime");
        entry.add("effect", effect);
        postAttack.add(entry);
        effects.add("minecraft:post_attack", postAttack);
        json.add("effects", effects);
        return json;
    }

    // =========================================================================
    // HELPERS
    // =========================================================================

    private JsonObject baseEnchantment(String descriptionKey, String supportedItems, int maxLevel, int minCostBase, int maxCostBase) {
        JsonObject json = new JsonObject();
        json.addProperty("anvil_cost", 999);
        JsonObject description = new JsonObject();
        description.addProperty("translate", descriptionKey);
        json.add("description", description);
        json.addProperty("max_level", maxLevel);
        JsonObject minCost = new JsonObject();
        minCost.addProperty("base", minCostBase);
        minCost.addProperty("per_level_above_first", 0);
        json.add("min_cost", minCost);
        JsonObject maxCost = new JsonObject();
        maxCost.addProperty("base", maxCostBase);
        maxCost.addProperty("per_level_above_first", 0);
        json.add("max_cost", maxCost);
        json.addProperty("supported_items", supportedItems);
        json.addProperty("weight", 1);
        JsonArray slots = new JsonArray();
        slots.add("mainhand");
        json.add("slots", slots);
        return json;
    }

    private JsonObject postAttackEntry(String affected, String enchanted) {
        JsonObject entry = new JsonObject();
        entry.addProperty("affected", affected);
        entry.addProperty("enchanted", enchanted);
        return entry;
    }

    private JsonObject linear(double base, double perLevelAboveFirst) {
        JsonObject obj = new JsonObject();
        obj.addProperty("type", "minecraft:linear");
        obj.addProperty("base", base);
        obj.addProperty("per_level_above_first", perLevelAboveFirst);
        return obj;
    }

    private void addConstant(JsonObject parent, String key, double value) {
        parent.addProperty(key, value);
    }

    private JsonObject randomChance(double chance) {
        JsonObject obj = new JsonObject();
        obj.addProperty("condition", "minecraft:random_chance");
        obj.addProperty("chance", chance);
        return obj;
    }

    private CompletableFuture<?> save(DataWriter writer, String name, JsonObject json) {
        return DataProvider.writeToPath(
                writer,
                json,
                output.getPath().resolve("data/onelife/enchantment/" + name + ".json")
        );
    }

    @Override
    public String getName() {
        return "OneLife Enchantment Provider";
    }
}