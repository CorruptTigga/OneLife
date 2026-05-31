package com.doitbetter.onelife.item.items;

import com.doitbetter.onelife.component.WeaponFamily;
import com.doitbetter.onelife.item.FamilyItem;
import net.minecraft.item.BowItem;

public class OneLifeShortbowItem extends BowItem implements FamilyItem {

    public OneLifeShortbowItem(Settings settings) {
        super(settings);
    }

    @Override
    public WeaponFamily getWeaponFamily() {
        return WeaponFamily.SHORTBOW;
    }

    @Override
    public int getRange() {
        return 12;
    }
}
