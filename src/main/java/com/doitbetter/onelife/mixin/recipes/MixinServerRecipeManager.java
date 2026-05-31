package com.doitbetter.onelife.mixin.recipes;

import net.minecraft.recipe.PreparedRecipes;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Set;

@Mixin(ServerRecipeManager.class)
public class MixinServerRecipeManager {

    @Unique
    private static final Set<Identifier> REMOVED_RECIPES = Set.of(
            // === SWORDS ===
            Identifier.ofVanilla("wooden_sword"),
            Identifier.ofVanilla("stone_sword"),
            Identifier.ofVanilla("iron_sword"),
            Identifier.ofVanilla("golden_sword"),
            Identifier.ofVanilla("diamond_sword"),
            Identifier.ofVanilla("netherite_sword_smithing"),

            // === PICKAXES ===
            Identifier.ofVanilla("wooden_pickaxe"),
            Identifier.ofVanilla("stone_pickaxe"),
            Identifier.ofVanilla("iron_pickaxe"),
            Identifier.ofVanilla("golden_pickaxe"),
            Identifier.ofVanilla("diamond_pickaxe"),
            Identifier.ofVanilla("netherite_pickaxe_smithing"),

            // === AXES ===
            Identifier.ofVanilla("wooden_axe"),
            Identifier.ofVanilla("stone_axe"),
            Identifier.ofVanilla("iron_axe"),
            Identifier.ofVanilla("golden_axe"),
            Identifier.ofVanilla("diamond_axe"),
            Identifier.ofVanilla("netherite_axe_smithing"),

            // === SHOVELS ===
            Identifier.ofVanilla("wooden_shovel"),
            Identifier.ofVanilla("stone_shovel"),
            Identifier.ofVanilla("iron_shovel"),
            Identifier.ofVanilla("golden_shovel"),
            Identifier.ofVanilla("diamond_shovel"),
            Identifier.ofVanilla("netherite_shovel_smithing"),

            // === HOES ===
            Identifier.ofVanilla("wooden_hoe"),
            Identifier.ofVanilla("stone_hoe"),
            Identifier.ofVanilla("iron_hoe"),
            Identifier.ofVanilla("golden_hoe"),
            Identifier.ofVanilla("diamond_hoe"),
            Identifier.ofVanilla("netherite_hoe_smithing"),

            // === ARMOR ===
            Identifier.ofVanilla("leather_helmet"),
            Identifier.ofVanilla("leather_chestplate"),
            Identifier.ofVanilla("leather_leggings"),
            Identifier.ofVanilla("leather_boots"),
            Identifier.ofVanilla("chainmail_helmet"),
            Identifier.ofVanilla("chainmail_chestplate"),
            Identifier.ofVanilla("chainmail_leggings"),
            Identifier.ofVanilla("chainmail_boots"),
            Identifier.ofVanilla("iron_helmet"),
            Identifier.ofVanilla("iron_chestplate"),
            Identifier.ofVanilla("iron_leggings"),
            Identifier.ofVanilla("iron_boots"),
            Identifier.ofVanilla("golden_helmet"),
            Identifier.ofVanilla("golden_chestplate"),
            Identifier.ofVanilla("golden_leggings"),
            Identifier.ofVanilla("golden_boots"),
            Identifier.ofVanilla("diamond_helmet"),
            Identifier.ofVanilla("diamond_chestplate"),
            Identifier.ofVanilla("diamond_leggings"),
            Identifier.ofVanilla("diamond_boots"),
            Identifier.ofVanilla("netherite_helmet_smithing"),
            Identifier.ofVanilla("netherite_chestplate_smithing"),
            Identifier.ofVanilla("netherite_leggings_smithing"),
            Identifier.ofVanilla("netherite_boots_smithing"),

            // === ENCHANTING & ANVIL ===
            Identifier.ofVanilla("enchanting_table"),
            Identifier.ofVanilla("anvil"),

            // === SMITHING ===
            Identifier.ofVanilla("netherite_upgrade_smithing_template"),

            // === STICKS ===
            Identifier.ofVanilla("stick"),

            // === SHIELD ===
            Identifier.ofVanilla("shield")
    );

    @Inject(method = "prepare(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)Lnet/minecraft/recipe/PreparedRecipes;", at = @At("TAIL"), cancellable = true)
    private void onelife$removeVanillaRecipes(ResourceManager resourceManager, Profiler profiler, CallbackInfoReturnable<PreparedRecipes> cir) {
        PreparedRecipes current = cir.getReturnValue();
        List<RecipeEntry<?>> filtered = current.recipes()
                .stream()
                .filter(entry -> !REMOVED_RECIPES.contains(entry.id().getValue()))
                .toList();
        cir.setReturnValue(PreparedRecipes.of(filtered));
    }
}
