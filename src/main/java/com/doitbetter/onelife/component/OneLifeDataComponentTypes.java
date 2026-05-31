package com.doitbetter.onelife.component;

import com.doitbetter.onelife.OneLife;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class OneLifeDataComponentTypes {

    // =========================================================================
    // WEAPON COMPONENTS
    // =========================================================================
    public static final ComponentType<AttachedComponent> HANDLE = register("handle");
    public static final ComponentType<AttachedComponent> HILT = register("hilt");
    public static final ComponentType<AttachedComponent> POMMEL = register("pommel");
    public static final ComponentType<AttachedComponent> WRAP = register("wrap");
    public static final ComponentType<AttachedComponent> GEM = register("gem");

    // =========================================================================
    // BOW COMPONENTS
    // =========================================================================
    public static final ComponentType<AttachedComponent> STAVE = register("stave");
    public static final ComponentType<AttachedComponent> STRING = register("string");

    // =========================================================================
    // STAFF COMPONENTS
    // =========================================================================
    public static final ComponentType<AttachedComponent> TOP_CAP = register("top_cap");
    public static final ComponentType<AttachedComponent> BOTTOM_CAP = register("bottom_cap");

    // =========================================================================
    // REGISTRATION
    // =========================================================================
    private static ComponentType<AttachedComponent> register(String name) {
        return Registry.register(
                Registries.DATA_COMPONENT_TYPE,
                Identifier.of(OneLife.MOD_ID, name),
                ComponentType.<AttachedComponent>builder()
                        .codec(AttachedComponent.CODEC)
                        .build()
        );
    }

    public static void register() {}
}