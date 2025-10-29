package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerInventory;
import raz.razor.microgrid.block.entity.MGBlockEntity;

public class SpatialBatteryScreenHandler extends MGScreenHandler {

    public SpatialBatteryScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModScreenHandlers.SPATIAL_BATTERY_SCREEN_HANDLER, syncId,playerInventory,null);
    }

    public SpatialBatteryScreenHandler(int syncId, PlayerInventory playerInventory, MGBlockEntity blockEntity) {
        super(ModScreenHandlers.SPATIAL_BATTERY_SCREEN_HANDLER, syncId,playerInventory,blockEntity);
    }

}
