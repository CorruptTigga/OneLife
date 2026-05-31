package com.doitbetter.onelife.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;

public class SulfurCrystalBlock extends Block {
    public static final MapCodec<SulfurCrystalBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.FLOAT.fieldOf("height").forGetter(block -> block.height),
                    Codec.FLOAT.fieldOf("aabb_offset").forGetter(block -> block.xzOffset),
                    createSettingsCodec()
            ).apply(instance, SulfurCrystalBlock::new)
    );

    public static final EnumProperty<Direction> FACING = Properties.FACING;

    private final float height;
    private final float xzOffset;
    protected final VoxelShape northShape;
    protected final VoxelShape southShape;
    protected final VoxelShape eastShape;
    protected final VoxelShape westShape;
    protected final VoxelShape upShape;
    protected final VoxelShape downShape;

    @Override
    public MapCodec<SulfurCrystalBlock> getCodec() {
        return CODEC;
    }

    public SulfurCrystalBlock(float height, float xzOffset, AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.UP));
        this.height = height;
        this.xzOffset = xzOffset;
        this.upShape    = Block.createCuboidShape(xzOffset, 0.0, xzOffset, 16.0F - xzOffset, height, 16.0F - xzOffset);
        this.downShape  = Block.createCuboidShape(xzOffset, 16.0F - height, xzOffset, 16.0F - xzOffset, 16.0, 16.0F - xzOffset);
        this.northShape = Block.createCuboidShape(xzOffset, xzOffset, 16.0F - height, 16.0F - xzOffset, 16.0F - xzOffset, 16.0);
        this.southShape = Block.createCuboidShape(xzOffset, xzOffset, 0.0, 16.0F - xzOffset, 16.0F - xzOffset, height);
        this.eastShape  = Block.createCuboidShape(0.0, xzOffset, xzOffset, height, 16.0F - xzOffset, 16.0F - xzOffset);
        this.westShape  = Block.createCuboidShape(16.0F - height, xzOffset, xzOffset, 16.0, 16.0F - xzOffset, 16.0F - xzOffset);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> this.northShape;
            case SOUTH -> this.southShape;
            case EAST  -> this.eastShape;
            case WEST  -> this.westShape;
            case DOWN  -> this.downShape;
            default    -> this.upShape;
        };
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        return world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, direction);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random
    ) {
        return direction == state.get(FACING).getOpposite() && !state.canPlaceAt(world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getSide());
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}