package raz.razor.microgrid.blocks.entities;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.base.Function;
import raz.razor.microgrid.Microgrid;

public class NewBlocksTest {
    public static final Block MG_ItemInterface = register("item_interface", Block::new, Block.Settings.create().strength(4.0f));
    public static final Block MG_MachineInterface = register("machine_interface", Block::new, Block.Settings.create().strength(4.0f));
    public static final Block MG_SpatialArray = register("spatial_array", Block::new, Block.Settings.create().strength(4.0f));
    public static final Block MG_SpatialBattery = register("spatial_battery", Block::new, Block.Settings.create().strength(4.0f));
    public static final Block MG_WirelessAdapter = register("wireless_adapter", Block::new, Block.Settings.create().strength(4.0f));
    public static final Block MG_EnergyEntryPoint = register("energy_entry_point", Block::new, Block.Settings.create().strength(4.0f));

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