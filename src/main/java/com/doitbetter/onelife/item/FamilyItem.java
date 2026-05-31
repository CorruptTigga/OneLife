package com.doitbetter.onelife.item;

import com.doitbetter.onelife.component.WeaponFamily;

public interface FamilyItem {

    /**
     * Returns the weapon family this item belongs to.
     * Used by ComponentAttributeApplicator and the renderer
     * to resolve component effects and model layers correctly.
     */
    WeaponFamily getWeaponFamily();
}
