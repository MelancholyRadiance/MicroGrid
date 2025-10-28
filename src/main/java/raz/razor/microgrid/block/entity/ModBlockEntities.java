package raz.razor.microgrid.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.block.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<MBBlockEntity> MG_ITEM_INTERFACE =
            register("item_interface", ItemInterfaceBlockEntity::new, ModBlocks.MG_ITEM_INTERFACE);

    public static final BlockEntityType<MBBlockEntity> MG_MACHINE_INTERFACE =
            register("machine_interface", MachineInterfaceBlockEntity::new,ModBlocks.MG_MACHINE_INTERFACE);

    public static final BlockEntityType<MBBlockEntity> MG_ENERGY_ENTRY_POINT =
            register("energy_entry_point", EnergyEntryPointBlockEntity::new,ModBlocks.MG_ENERGY_ENTRY_POINT);

    public static final BlockEntityType<MBBlockEntity> MG_SPATIAL_ARRAY =
            register("spatial_array", SpatialArrayBlockEntity::new,ModBlocks.MG_SPATIAL_ARRAY);

    public static final BlockEntityType<MBBlockEntity> MG_SPATIAL_BATTERY =
            register("spatial_battery", SpatialBatteryBlockEntity::new,ModBlocks.MG_SPATIAL_BATTERY);

    public static final BlockEntityType<MBBlockEntity> MG_WIRELESS_ADAPTER =
            register("wireless_adapter", WirelessAdapterBlockEntity::new,ModBlocks.MG_WIRELESS_ADAPTER);

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
