package com.doitbetter.onelife.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SulfurBlock extends Block {
    public static final MapCodec<SulfurBlock> CODEC = createCodec(SulfurBlock::new);

    @Override
    public MapCodec<? extends SulfurBlock> getCodec() {
        return CODEC;
    }

    public SulfurBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient) {
            BlockPos blockPos = hit.getBlockPos();
            // TODO: Replace with onelife:block.sulfur.chime once sounds are added
            world.playSound(null, blockPos, net.minecraft.sound.SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1.0F, 0.5F + world.random.nextFloat() * 1.2F);
        }
    }
}