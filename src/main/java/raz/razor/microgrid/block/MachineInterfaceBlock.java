package raz.razor.microgrid.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import raz.razor.microgrid.block.entity.MachineInterfaceBlockEntity;
import raz.razor.microgrid.block.entity.ModBlockEntities;

public class MachineInterfaceBlock extends MGGuiBlock {

    protected MachineInterfaceBlock(Settings settings) {
        super(settings);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.MG_MACHINE_INTERFACE, MachineInterfaceBlockEntity::tick);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(MachineInterfaceBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MachineInterfaceBlockEntity(pos,state);
    }
}
