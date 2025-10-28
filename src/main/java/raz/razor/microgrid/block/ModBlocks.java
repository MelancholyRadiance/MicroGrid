package raz.razor.microgrid.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.base.Function;
import raz.razor.microgrid.Microgrid;

public class ModBlocks {
    public static final Block MG_ITEM_INTERFACE = register("item_interface", ItemInterfaceBlock::new, Block.Settings.create().strength(4.0f));
    public static final Block MG_MACHINE_INTERFACE = register("machine_interface", MachineInterfaceBlock::new, Block.Settings.create().strength(4.0f));
    public static final Block MG_SPATIAL_ARRAY = register("spatial_array", SpatialArrayBlock::new, Block.Settings.create().strength(4.0f));
    public static final Block MG_SPATIAL_BATTERY = register("spatial_battery", SpatialBatteryBlock::new, Block.Settings.create().strength(4.0f));
    public static final Block MG_WIRELESS_ADAPTER = register("wireless_adapter", WirelessAdapterBlock::new, Block.Settings.create().strength(4.0f));
    public static final Block MG_ENERGY_ENTRY_POINT = register("energy_entry_point", EnergyEntryPointBlock::new, Block.Settings.create().strength(4.0f));

    static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(Microgrid.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    public static void init() {
    }
}