package com.doitbetter.onelife.item.items;

import com.doitbetter.onelife.component.WeaponFamily;
import com.doitbetter.onelife.item.FamilyItem;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class OneLifeWarAxeItem extends Item implements FamilyItem {

    public OneLifeWarAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(material.applyToolSettings(settings, BlockTags.AXE_MINEABLE, attackDamage, attackSpeed)
                .component(DataComponentTypes.TOOL, new ToolComponent(
                        List.of(
                                ToolComponent.Rule.ofNeverDropping(Registries.createEntryLookup(Registries.BLOCK)
                                        .getOrThrow(material.incorrectBlocksForDrops())),
                                ToolComponent.Rule.ofAlwaysDropping(Registries.createEntryLookup(Registries.BLOCK)
                                        .getOrThrow(BlockTags.AXE_MINEABLE), 0.5F) // 0.5x mining speed instead of full
                        ),
                        1.0F, 1
                ))
        );
    }

    @Override
    public WeaponFamily getWeaponFamily() {
        return WeaponFamily.WAR_AXE;
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