package raz.razor.microgrid.blocks.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class ItemInterfaceBlockEntity extends BlockEntity {
    public ItemInterfaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MG_ITEM_INTERFACE_BLOCK_ENTITY, pos, state);
    }
}
