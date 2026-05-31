package com.doitbetter.onelife.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class BuddingSulfurBlock extends SulfurBlock {
    public static final MapCodec<BuddingSulfurBlock> CODEC = createCodec(BuddingSulfurBlock::new);
    public static final int GROW_CHANCE = 4;
    private static final Direction[] DIRECTIONS = Direction.values();

    @Override
    public MapCodec<BuddingSulfurBlock> getCodec() {
        return CODEC;
    }

    public BuddingSulfurBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    private static boolean hasAdjacentLava(ServerWorld world, BlockPos pos) {
        for (Direction direction : DIRECTIONS) {
            if (world.getFluidState(pos.offset(direction)).isOf(Fluids.LAVA)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canGrowIn(BlockState state) {
        return state.isAir();
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(GROW_CHANCE) == 0 && hasAdjacentLava(world, pos)) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;

            if (canGrowIn(blockState)) {
                block = OneLifeBlocks.SMALL_SULFUR_CRYSTAL;
            } else if (blockState.isOf(OneLifeBlocks.SMALL_SULFUR_CRYSTAL) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = OneLifeBlocks.MEDIUM_SULFUR_CRYSTAL;
            } else if (blockState.isOf(OneLifeBlocks.MEDIUM_SULFUR_CRYSTAL) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = OneLifeBlocks.LARGE_SULFUR_CRYSTAL;
            } else if (blockState.isOf(OneLifeBlocks.LARGE_SULFUR_CRYSTAL) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = OneLifeBlocks.SULFUR_CRYSTAL_CLUSTER;
            }

            if (block != null) {
                world.setBlockState(blockPos, block.getDefaultState().with(SulfurCrystalBlock.FACING, direction));
            }
        }
    }
}