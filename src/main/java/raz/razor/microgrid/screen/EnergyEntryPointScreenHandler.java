package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerInventory;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.block.entity.MBBlockEntity;

public class EnergyEntryPointScreenHandler extends MGScreenHandler {

    public EnergyEntryPointScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(Microgrid.ENERGY_ENTRY_POINT_SCREEN_HANDLER, syncId,playerInventory,null);
    }

    public EnergyEntryPointScreenHandler(int syncId, PlayerInventory playerInventory, MBBlockEntity blockEntity) {
        super(Microgrid.ENERGY_ENTRY_POINT_SCREEN_HANDLER, syncId,playerInventory,blockEntity);
    }

}
