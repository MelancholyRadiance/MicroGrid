package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerInventory;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.blocks.entities.MBBlockEntity;

public class SpatialArrayScreenHandler extends MGScreenHandler {

    public SpatialArrayScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(Microgrid.SPATIAL_ARRAY_SCREEN_HANDLER, syncId,playerInventory,null);
    }

    public SpatialArrayScreenHandler(int syncId, PlayerInventory playerInventory, MBBlockEntity blockEntity) {
        super(Microgrid.SPATIAL_ARRAY_SCREEN_HANDLER, syncId,playerInventory,blockEntity);
    }

}
