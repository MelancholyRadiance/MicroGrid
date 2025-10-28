package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import raz.razor.microgrid.Microgrid;
import raz.razor.microgrid.blocks.entities.MBBlockEntity;

public class ItemInterfaceScreenHandler extends ScreenHandler {

    private final PlayerInventory playerInventory;
    private final MBBlockEntity blockEntity;

    public ItemInterfaceScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(Microgrid.BOX_SCREEN_HANDLER, syncId);
        this.playerInventory = playerInventory;
        this.blockEntity = null;
    }
    public ItemInterfaceScreenHandler(int syncId, PlayerInventory playerInventory, MBBlockEntity blockEntity) {
        super(Microgrid.BOX_SCREEN_HANDLER, syncId);
        this.playerInventory = playerInventory;
        this.blockEntity = blockEntity;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
