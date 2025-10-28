package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerInventory;
import raz.razor.microgrid.block.entity.MBBlockEntity;

public class WirelessAdapterScreenHandler extends MGScreenHandler {

    public WirelessAdapterScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModScreenHandlers.WIRELESS_ADAPTER_SCREEN_HANDLER, syncId,playerInventory,null);
    }

    public WirelessAdapterScreenHandler(int syncId, PlayerInventory playerInventory, MBBlockEntity blockEntity) {
        super(ModScreenHandlers.WIRELESS_ADAPTER_SCREEN_HANDLER, syncId,playerInventory,blockEntity);
    }

}
