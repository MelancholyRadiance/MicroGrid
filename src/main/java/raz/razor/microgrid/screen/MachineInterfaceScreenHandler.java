package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerInventory;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.blocks.entities.MBBlockEntity;

public class MachineInterfaceScreenHandler extends MGScreenHandler {

    public MachineInterfaceScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(Microgrid.MACHINE_INTERFACE_SCREEN_HANDLER, syncId,playerInventory,null);
    }

    public MachineInterfaceScreenHandler(int syncId, PlayerInventory playerInventory, MBBlockEntity blockEntity) {
        super(Microgrid.MACHINE_INTERFACE_SCREEN_HANDLER, syncId,playerInventory,blockEntity);
    }

}
