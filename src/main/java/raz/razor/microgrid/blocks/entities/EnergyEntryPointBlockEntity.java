package raz.razor.microgrid.blocks.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import raz.razor.microgrid.screen.EnergyEntryPointScreenHandler;

public class EnergyEntryPointBlockEntity extends MBBlockEntity {
    public EnergyEntryPointBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MG_ENERGY_ENTRY_POINT, pos, state);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        // We provide *this* to the screenHandler as our class Implements Inventory
        // Only the Server has the Inventory at the start, this will be synced to the client in the ScreenHandler
        return new EnergyEntryPointScreenHandler(syncId, playerInventory, this);
    }

}
