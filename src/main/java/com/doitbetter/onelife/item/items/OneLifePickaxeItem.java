package com.doitbetter.onelife.item.items;

import com.doitbetter.onelife.component.WeaponFamily;
import com.doitbetter.onelife.item.FamilyItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class OneLifePickaxeItem extends PickaxeItem implements FamilyItem {

    public OneLifePickaxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public WeaponFamily getWeaponFamily() {
        return WeaponFamily.TOOL;
    }
}