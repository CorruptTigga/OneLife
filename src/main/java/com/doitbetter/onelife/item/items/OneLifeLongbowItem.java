package com.doitbetter.onelife.item.items;

import com.doitbetter.onelife.component.WeaponFamily;
import com.doitbetter.onelife.item.FamilyItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;

public class OneLifeLongbowItem extends BowItem implements FamilyItem {

    public OneLifeLongbowItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public WeaponFamily getWeaponFamily() {
        return WeaponFamily.LONGBOW;
    }

    @Override
    public int getRange() {
        return 20; // Longer range than vanilla bow
    }
}