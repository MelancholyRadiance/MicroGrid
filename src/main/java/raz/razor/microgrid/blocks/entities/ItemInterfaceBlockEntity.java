package raz.razor.microgrid.blocks.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemInterfaceBlockEntity extends BlockEntity {
    public ItemInterfaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MG_ITEM_INTERFACE_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, ItemInterfaceBlockEntity itemInterfaceBlockEntity) {
        world.getPlayers().forEach(x -> x.sendMessage(Text.literal("ESSA"),false));
    }

    @Override
    protected void writeData(WriteView writeView) {
        //writeView.putInt("clicks", clicks);

        super.writeData(writeView);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

}
