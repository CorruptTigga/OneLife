package com.doitbetter.onelife.component;

import com.doitbetter.onelife.item.FamilyItem;
import net.minecraft.component.ComponentType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ComponentAttributeApplicator {

    /**
     * Reads all AttachedComponents from the stack, resolves their effects
     * against their quality, and writes the resulting enchantments onto the stack.
     * Called by any crafting station that assembles component-based items.
     */
    public static void apply(ItemStack stack, DynamicRegistryManager registryManager) {
        ComponentRegistry registry = ComponentRegistry.getInstance();

        applySlot(stack, OneLifeDataComponentTypes.HANDLE, registry::getHandle, registryManager);
        applySlot(stack, OneLifeDataComponentTypes.HILT, registry::getHilt, registryManager);
        applySlot(stack, OneLifeDataComponentTypes.POMMEL, registry::getPommel, registryManager);
        applySlot(stack, OneLifeDataComponentTypes.WRAP, registry::getWrap, registryManager);
        applySlot(stack, OneLifeDataComponentTypes.GEM, registry::getGem, registryManager);
        applySlot(stack, OneLifeDataComponentTypes.STAVE, registry::getStave, registryManager);
        applySlot(stack, OneLifeDataComponentTypes.STRING, registry::getString, registryManager);
        applySlot(stack, OneLifeDataComponentTypes.TOP_CAP, registry::getTopCap, registryManager);
        applySlot(stack, OneLifeDataComponentTypes.BOTTOM_CAP, registry::getBottomCap, registryManager);
    }

    private static <T extends WeaponComponent> void applySlot(
            ItemStack stack,
            ComponentType<AttachedComponent> slotType,
            java.util.function.Function<Identifier, Optional<T>> lookup,
            DynamicRegistryManager registryManager
    ) {
        AttachedComponent attached = stack.get(slotType);
        if (attached == null) return;

        lookup.apply(attached.componentId()).ifPresent(component -> {
            WeaponFamily family = getFamilyFromStack(stack);
            if (family == null || !component.supportsFamily(family)) return;

            for (ComponentEffect effect : component.effectsFor(family)) {
                int level = effect.resolveLevel(attached.quality());
                applyEnchantment(stack, effect.effect(), level, registryManager);
            }
        });
    }

    private static void applyEnchantment(ItemStack stack, Identifier effectId, int level, DynamicRegistryManager registryManager) {
        RegistryKey<Enchantment> key = RegistryKey.of(RegistryKeys.ENCHANTMENT, effectId);
        registryManager.getOrThrow(RegistryKeys.ENCHANTMENT)
                .getEntry(effectId)  // use Identifier overload directly
                .ifPresent(enchantment -> stack.addEnchantment(enchantment, level));
    }

    private static WeaponFamily getFamilyFromStack(ItemStack stack) {
        if (stack.getItem() instanceof FamilyItem familyItem) {
            return familyItem.getWeaponFamily();
        }

        return null;
    }
}