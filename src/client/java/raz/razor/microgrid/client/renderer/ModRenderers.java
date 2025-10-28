package raz.razor.microgrid.client.renderer;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import raz.razor.microgrid.blocks.entities.ModBlockEntities;

public class ModRenderers {
    public static void init(){
        BlockEntityRendererFactories.register(ModBlockEntities.MG_ENERGY_ENTRY_POINT, MGBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MG_ITEM_INTERFACE, MGBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MG_MACHINE_INTERFACE, MGBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MG_SPATIAL_ARRAY, MGBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MG_SPATIAL_BATTERY, MGBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MG_WIRELESS_ADAPTER, MGBlockEntityRenderer::new);
    }
}
