package raz.razor.microgrid.client.renderer;

import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import raz.razor.microgrid.block.entity.MBBlockEntity;
import raz.razor.microgrid.client.renderer.states.MGBlockEntityRenderState;

public class MGBlockEntityRenderer implements BlockEntityRenderer<MBBlockEntity, MGBlockEntityRenderState> {

    public MGBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public MGBlockEntityRenderState createRenderState() {
        return new MGBlockEntityRenderState();
    }

    @Override
    public void render(MGBlockEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {

    }
}
