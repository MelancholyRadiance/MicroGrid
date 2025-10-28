package raz.razor.microgrid;

import net.fabricmc.api.ModInitializer;
import raz.razor.microgrid.block.ModBlocks;
import raz.razor.microgrid.block.entity.ModBlockEntities;
import raz.razor.microgrid.item.ModItems;
import raz.razor.microgrid.screen.ModScreenHandlers;

public class Microgrid implements ModInitializer {

    public static final String MOD_ID = "microgrid";

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModItems.init();
        ModBlockEntities.init();
        ModScreenHandlers.init();
    }
}
