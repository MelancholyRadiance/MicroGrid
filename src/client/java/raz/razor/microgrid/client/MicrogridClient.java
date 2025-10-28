package raz.razor.microgrid.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.blocks.entities.ModBlockEntities;
import raz.razor.microgrid.client.renderers.MGBlockEntityRenderer;
import raz.razor.microgrid.client.screen.ItemInterfaceScreen;
import raz.razor.microgrid.client.screen.MachineInterfaceScreen;

public class MicrogridClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.MG_ITEM_INTERFACE, MGBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MG_MACHINE_INTERFACE, MGBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MG_ENERGY_ENTRY_POINT, MGBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MG_SPATIAL_ARRAY, MGBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MG_SPATIAL_BATTERY, MGBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MG_WIRELESS_ADAPTER, MGBlockEntityRenderer::new);

        HandledScreens.register(Microgrid.ITEM_INTERFACE_SCREEN_HANDLER, ItemInterfaceScreen::new);
        HandledScreens.register(Microgrid.MACHINE_INTERFACE_SCREEN_HANDLER, MachineInterfaceScreen::new);

        //Just testing...
        HandledScreens.register(Microgrid.ENERGY_ENTRY_POINT_SCREEN_HANDLER, MachineInterfaceScreen::new);
        HandledScreens.register(Microgrid.SPATIAL_ARRAY_SCREEN_HANDLER, MachineInterfaceScreen::new);
        HandledScreens.register(Microgrid.SPATIAL_BATTERY_SCREEN_HANDLER, MachineInterfaceScreen::new);
        HandledScreens.register(Microgrid.WIRELESS_ADAPTER_SCREEN_HANDLER, MachineInterfaceScreen::new);
    }
}
