package com.doitbetter.onelife.component;

import java.util.List;

public interface WeaponComponent {

    /**
     * Returns the effects this component provides for the given weapon family.
     * An empty list means this component provides no effects for that family.
     */
    List<ComponentEffect> effectsFor(WeaponFamily family);

    /**
     * Returns whether this component can be socketed into the given weapon family.
     */
    boolean supportsFamily(WeaponFamily family);

    /**
     * Returns the durability contribution of this component.
     * Added to the base tool material durability at item creation.
     */
    int getComponentDurability();

    /**
     * Returns the unique identifier for this component definition.
     */
    net.minecraft.util.Identifier getId();
}