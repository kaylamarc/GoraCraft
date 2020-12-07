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

public class Oven extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0.09999999999999992, 0, 0, 16.1, 1, 16),
            Block.makeCuboidShape(1, 1, 1, 15, 8, 15),
            Block.makeCuboidShape(0, 8, 0, 16, 9, 16),
            Block.makeCuboidShape(1, 9, 1, 15, 10, 15),
            Block.makeCuboidShape(6, 9, 10, 10, 15, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0.09999999999999787, 0, 1.7763568394002505e-15, 16.099999999999998, 1, 16.000000000000004),
            Block.makeCuboidShape(1.0999999999999979, 1, 0.9000000000000021, 15.099999999999998, 8, 14.900000000000002),
            Block.makeCuboidShape(0.09999999999999787, 8, -0.09999999999999787, 16.099999999999998, 9, 15.900000000000002),
            Block.makeCuboidShape(1.0999999999999979, 9, 0.9000000000000021, 15.099999999999998, 10, 14.900000000000002),
            Block.makeCuboidShape(0.09999999999999787, 9, 5.900000000000002, 6.099999999999998, 15, 9.900000000000002)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0.09999999999999432, 0, 0, 16.099999999999994, 1, 16),
            Block.makeCuboidShape(1.1999999999999957, 1, 1, 15.199999999999996, 8, 15),
            Block.makeCuboidShape(0.19999999999999574, 8, 0, 16.199999999999996, 9, 16),
            Block.makeCuboidShape(1.1999999999999957, 9, 1, 15.199999999999996, 10, 15),
            Block.makeCuboidShape(6.199999999999996, 9, 0, 10.199999999999996, 15, 6)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0.09999999999999787, 0, -3.552713678800501e-15, 16.099999999999998, 1, 15.999999999999996),
            Block.makeCuboidShape(1.0999999999999979, 1, 1.0999999999999979, 15.099999999999998, 8, 15.099999999999998),
            Block.makeCuboidShape(0.09999999999999787, 8, 0.09999999999999787, 16.099999999999998, 9, 16.099999999999998),
            Block.makeCuboidShape(1.0999999999999979, 9, 1.0999999999999979, 15.099999999999998, 10, 15.099999999999998),
            Block.makeCuboidShape(10.099999999999998, 9, 6.099999999999998, 16.099999999999998, 15, 10.099999999999998)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Oven() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE)
        );
    }

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
