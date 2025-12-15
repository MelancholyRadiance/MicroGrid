package raz.razor.microgrid.client.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.BufferAllocator;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Items;
import net.minecraft.util.Colors;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.*;
import org.jetbrains.annotations.Nullable;
import raz.razor.microgrid.Util;
import raz.razor.microgrid.block.entity.MGBlockEntity;
import raz.razor.microgrid.client.renderer.states.MGBlockEntityRenderState;

import java.util.Optional;

public class MGBlockEntityRenderer implements BlockEntityRenderer<MGBlockEntity, MGBlockEntityRenderState> {
    private static final VertexConsumerProvider.Immediate immediate = VertexConsumerProvider.immediate(new BufferAllocator(786432));

    public MGBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void updateRenderState(MGBlockEntity blockEntity, MGBlockEntityRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        state.temp = blockEntity.getTemp();
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);
    }

    @Override
    public MGBlockEntityRenderState createRenderState() {
        return new MGBlockEntityRenderState();
    }

    private static Optional<Boolean> shouldRenderTempGlobal = Optional.empty();

    @Override
    public void render(MGBlockEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        float Kelvins = state.temp.Kelvins;
        float[] color = Util.BlackBodyColor.kelvinToRGB(Kelvins);

        drawBox(matrices,
                immediate.getBuffer(RenderLayer.getDebugFilledBox()),
                new Box(BlockPos.ORIGIN),
                color,
                1.f);

        boolean isTarget = false;
        if(MinecraftClient.getInstance().crosshairTarget instanceof BlockHitResult blockHitResult){
            double diff = blockHitResult.getBlockPos().toCenterPos().distanceTo(state.pos.toCenterPos());
            isTarget = diff == 0;
        }

        //if(shouldRenderTempGlobal.isEmpty()){
        //    shouldRenderTempGlobal = Optional.of(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.MAINHAND).getItem() != Items.IRON_HELMET);
        //}

        //if(shouldRenderTempGlobal.get()&&!isTarget) {
        //    return;
        //}

        matrices.push();
        matrices.translate(1,1,0);
        matrices.scale(0.02F,0.02F,0);
        // Mirror the text
        matrices.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(180.f));
        // Translate to top-left
        matrices.translate(1,1,0);

        MinecraftClient.getInstance().textRenderer.draw(String.valueOf(Math.round(Kelvins * 100.f) / 100.f),
                0.F,
                0.F,
                isTarget ? Colors.YELLOW : Colors.WHITE,
                false,
                matrices.peek().getPositionMatrix(),
                immediate,
                TextRenderer.TextLayerType.SEE_THROUGH,
                Colors.BLACK,
                15);
        immediate.draw();
        // Mandatory call after GL calls
        matrices.pop();
    }

    private static void drawBox(MatrixStack matrices,VertexConsumer buffer,Box boundingBox, float[] color, float alpha) {
        VertexRendering.drawFilledBox(matrices,
                buffer,
                boundingBox.minX,
                boundingBox.minY,
                boundingBox.minZ,
                boundingBox.maxX,
                boundingBox.maxY,
                boundingBox.maxZ,
                color[0],
                color[1],
                color[2],
                alpha);
    }
}
