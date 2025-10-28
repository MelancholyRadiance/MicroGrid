package raz.razor.microgrid.client.renderers;

import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import raz.razor.microgrid.blocks.entities.MBBlockEntity;
import raz.razor.microgrid.client.renderers.states.ItemInterfaceBlockEntityRenderState;

public class ItemInterfaceBlockEntityRenderer implements BlockEntityRenderer<MBBlockEntity, ItemInterfaceBlockEntityRenderState> {

    public ItemInterfaceBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public ItemInterfaceBlockEntityRenderState createRenderState() {
        return new ItemInterfaceBlockEntityRenderState();
    }

    @Override
    public void render(ItemInterfaceBlockEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {

    }
}
