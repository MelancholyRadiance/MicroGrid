package raz.razor.microgrid.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import raz.razor.microgrid.block.entity.MBBlockEntity;

public class MGScreenHandler extends ScreenHandler {
    protected final PlayerInventory playerInventory;
    protected final MBBlockEntity blockEntity;

    public MGScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, MBBlockEntity blockEntity) {
        super(type, syncId);
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
