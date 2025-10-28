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
import raz.razor.microgrid.blocks.entities.WirelessAdapterBlockEntity;

public class WirelessAdapterBlock extends MGGuiBlock {

    protected WirelessAdapterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.MG_WIRELESS_ADAPTER, MachineInterfaceBlockEntity::tick);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(WirelessAdapterBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WirelessAdapterBlockEntity(pos,state);
    }
}
