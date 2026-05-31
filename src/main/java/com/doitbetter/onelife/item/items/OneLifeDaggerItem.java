package com.doitbetter.onelife.item.items;

import com.doitbetter.onelife.OneLife;
import com.doitbetter.onelife.component.WeaponFamily;
import com.doitbetter.onelife.item.FamilyItem;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OneLifeDaggerItem extends Item implements FamilyItem {

    public OneLifeDaggerItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(material.applySwordSettings(settings, attackDamage, attackSpeed)
                .attributeModifiers(
                        AttributeModifiersComponent.builder()
                                .add(EntityAttributes.ATTACK_DAMAGE,
                                        new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
                                                attackDamage + material.attackDamageBonus(), EntityAttributeModifier.Operation.ADD_VALUE),
                                        AttributeModifierSlot.MAINHAND)
                                .add(EntityAttributes.ATTACK_SPEED,
                                        new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID,
                                                attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                                        AttributeModifierSlot.MAINHAND)
                                .add(EntityAttributes.ENTITY_INTERACTION_RANGE,
                                        new EntityAttributeModifier(
                                                Identifier.of(OneLife.MOD_ID, "dagger_range"),
                                                -1.5, EntityAttributeModifier.Operation.ADD_VALUE),
                                        AttributeModifierSlot.MAINHAND)
                                .build()
                )
        );
    }

    @Override
    public WeaponFamily getWeaponFamily() {
        return WeaponFamily.BLADE_DAGGER;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }
}