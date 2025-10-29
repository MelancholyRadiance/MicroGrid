package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerInventory;
import raz.razor.microgrid.block.entity.MGBlockEntity;

public class SpatialArrayScreenHandler extends MGScreenHandler {

    public SpatialArrayScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModScreenHandlers.SPATIAL_ARRAY_SCREEN_HANDLER, syncId,playerInventory,null);
    }

    public SpatialArrayScreenHandler(int syncId, PlayerInventory playerInventory, MGBlockEntity blockEntity) {
        super(ModScreenHandlers.SPATIAL_ARRAY_SCREEN_HANDLER, syncId,playerInventory,blockEntity);
    }

}
