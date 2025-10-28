package raz.razor.microgrid.blocks.entities;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.blocks.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<MBBlockEntity> MG_ITEM_INTERFACE_BLOCK_ENTITY =
            register("item_interface", ItemInterfaceBlockEntity::new, ModBlocks.MG_ITEM_INTERFACE);

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        Identifier id = Identifier.of(Microgrid.MOD_ID, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void init(){}
}
