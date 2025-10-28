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
import raz.razor.microgrid.blocks.entities.SpatialBatteryBlockEntity;

public class SpatialBatteryBlock extends MGGuiBlock {

    protected SpatialBatteryBlock(Settings settings) {
        super(settings);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.MG_SPATIAL_BATTERY, SpatialBatteryBlockEntity::tick);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(SpatialBatteryBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SpatialBatteryBlockEntity(pos,state);
    }
}
