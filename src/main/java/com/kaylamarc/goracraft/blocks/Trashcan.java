package com.kaylamarc.goracraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Trashcan extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public Trashcan() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .sound(SoundType.METAL)
                .harvestLevel(0)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE)
        );
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(4, 0, 4, 12, 9, 12),
            Block.makeCuboidShape(3, 9, 3, 13, 10, 13),
            Block.makeCuboidShape(3, 10, 3, 13, 11, 4),
            Block.makeCuboidShape(3, 10, 4, 4, 11, 13),
            Block.makeCuboidShape(4, 10, 12, 13, 11, 13),
            Block.makeCuboidShape(12, 10, 4, 13, 11, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(4, 0, 4, 12, 9, 12),
            Block.makeCuboidShape(3, 9, 3, 13, 10, 13),
            Block.makeCuboidShape(3, 10, 3, 13, 11, 4),
            Block.makeCuboidShape(3, 10, 4, 4, 11, 13),
            Block.makeCuboidShape(4, 10, 12, 13, 11, 13),
            Block.makeCuboidShape(12, 10, 4, 13, 11, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(4, 0, 4, 12, 9, 12),
            Block.makeCuboidShape(3, 9, 3, 13, 10, 13),
            Block.makeCuboidShape(3, 10, 3, 13, 11, 4),
            Block.makeCuboidShape(3, 10, 4, 4, 11, 13),
            Block.makeCuboidShape(4, 10, 12, 13, 11, 13),
            Block.makeCuboidShape(12, 10, 4, 13, 11, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(4, 0, 4, 12, 9, 12),
            Block.makeCuboidShape(3, 9, 3, 13, 10, 13),
            Block.makeCuboidShape(3, 10, 3, 13, 11, 4),
            Block.makeCuboidShape(3, 10, 4, 4, 11, 13),
            Block.makeCuboidShape(4, 10, 12, 13, 11, 13),
            Block.makeCuboidShape(12, 10, 4, 13, 11, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    /**
     * configure direction of block
     * @param state
     * @param worldIn
     * @param pos
     * @param context
     * @return
     */
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /**
     * determine how strong shadow is
     * @param state
     * @param worldIn
     * @param pos
     * @return
     */
    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6f;
    }
}
