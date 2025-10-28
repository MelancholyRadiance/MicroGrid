package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerInventory;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.blocks.entities.MBBlockEntity;

public class ItemInterfaceScreenHandler extends MGScreenHandler {

    public ItemInterfaceScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(Microgrid.BOX_SCREEN_HANDLER, syncId,playerInventory,null);
    }

    public ItemInterfaceScreenHandler(int syncId, PlayerInventory playerInventory, MBBlockEntity blockEntity) {
        super(Microgrid.BOX_SCREEN_HANDLER, syncId,playerInventory,blockEntity);
    }

}
