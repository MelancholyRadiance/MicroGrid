package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerInventory;
import raz.razor.microgrid.block.entity.MGBlockEntity;

public class ItemInterfaceScreenHandler extends MGScreenHandler {

    public ItemInterfaceScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModScreenHandlers.ITEM_INTERFACE_SCREEN_HANDLER, syncId,playerInventory,null);
    }

    public ItemInterfaceScreenHandler(int syncId, PlayerInventory playerInventory, MGBlockEntity blockEntity) {
        super(ModScreenHandlers.ITEM_INTERFACE_SCREEN_HANDLER, syncId,playerInventory,blockEntity);
    }

}
