package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerInventory;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.blocks.entities.MBBlockEntity;

public class WirelessAdapterScreenHandler extends MGScreenHandler {

    public WirelessAdapterScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(Microgrid.WIRELESS_ADAPTER_SCREEN_HANDLER, syncId,playerInventory,null);
    }

    public WirelessAdapterScreenHandler(int syncId, PlayerInventory playerInventory, MBBlockEntity blockEntity) {
        super(Microgrid.WIRELESS_ADAPTER_SCREEN_HANDLER, syncId,playerInventory,blockEntity);
    }

}
