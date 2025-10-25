package raz.razor.microgrid.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import raz.razor.microgrid.blocks.entities.ModBlockEntities;
import raz.razor.microgrid.client.renderers.ItemInterfaceBlockEntityRenderer;

public class MicrogridClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.MG_ITEM_INTERFACE_BLOCK_ENTITY, ItemInterfaceBlockEntityRenderer::new);
    }
}
