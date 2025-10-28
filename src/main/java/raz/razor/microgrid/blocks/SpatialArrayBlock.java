package raz.razor.microgrid.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import raz.razor.microgrid.blocks.entities.MachineInterfaceBlockEntity;
import raz.razor.microgrid.blocks.entities.ModBlockEntities;
import raz.razor.microgrid.blocks.entities.SpatialArrayBlockEntity;

public class SpatialArrayBlock extends MGGuiBlock {

    protected SpatialArrayBlock(Settings settings) {
        super(settings);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.MG_SPATIAL_ARRAY, MachineInterfaceBlockEntity::tick);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(SpatialArrayBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SpatialArrayBlockEntity(pos,state);
    }
}
