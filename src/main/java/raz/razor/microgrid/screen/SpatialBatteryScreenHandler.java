package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerInventory;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.blocks.entities.MBBlockEntity;

public class SpatialBatteryScreenHandler extends MGScreenHandler {

    public SpatialBatteryScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(Microgrid.SPATIAL_BATTERY_SCREEN_HANDLER, syncId,playerInventory,null);
    }

    public SpatialBatteryScreenHandler(int syncId, PlayerInventory playerInventory, MBBlockEntity blockEntity) {
        super(Microgrid.SPATIAL_BATTERY_SCREEN_HANDLER, syncId,playerInventory,blockEntity);
    }

}
