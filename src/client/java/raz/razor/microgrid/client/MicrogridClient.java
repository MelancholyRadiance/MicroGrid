package raz.razor.microgrid.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.blocks.entities.ModBlockEntities;
import raz.razor.microgrid.client.renderers.ItemInterfaceBlockEntityRenderer;
import raz.razor.microgrid.client.screen.ItemInterfaceScreen;

public class MicrogridClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.MG_ITEM_INTERFACE_BLOCK_ENTITY, ItemInterfaceBlockEntityRenderer::new);

        HandledScreens.register(Microgrid.BOX_SCREEN_HANDLER, ItemInterfaceScreen::new);
    }
}
