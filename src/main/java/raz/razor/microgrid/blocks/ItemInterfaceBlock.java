package raz.razor.microgrid.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import raz.razor.microgrid.blocks.entities.ItemInterfaceBlockEntity;

public class ItemInterfaceBlock extends BlockWithEntity {

    protected ItemInterfaceBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(ItemInterfaceBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ItemInterfaceBlockEntity(pos,state);
    }
}
