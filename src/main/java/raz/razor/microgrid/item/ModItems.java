package raz.razor.microgrid.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.block.ModBlocks;

public class ModItems {
    public static final RegistryKey<ItemGroup> MICRO_GRID_ITEM_GROUP_KEY =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Microgrid.MOD_ID, "item_group"));

    public static final ItemGroup MICRO_GRID_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.REDSTONE_TORCH))
            .displayName(Text.translatable("itemGroup."+Microgrid.MOD_ID))
            .build();

    public static void init(){
        Registry.register(Registries.ITEM_GROUP, MICRO_GRID_ITEM_GROUP_KEY, MICRO_GRID_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(MICRO_GRID_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.MG_ENERGY_ENTRY_POINT.asItem());
            itemGroup.add(ModBlocks.MG_ITEM_INTERFACE.asItem());
            itemGroup.add(ModBlocks.MG_MACHINE_INTERFACE.asItem());
            itemGroup.add(ModBlocks.MG_SPATIAL_ARRAY.asItem());
            itemGroup.add(ModBlocks.MG_SPATIAL_BATTERY.asItem());
            itemGroup.add(ModBlocks.MG_WIRELESS_ADAPTER.asItem());
        });
    }
}
