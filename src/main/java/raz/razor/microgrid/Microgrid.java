package raz.razor.microgrid;

import net.fabricmc.api.ModInitializer;
import raz.razor.microgrid.blocks.ModBlocks;

public class Microgrid implements ModInitializer {

    public static final String MOD_ID = "microgrid";

    @Override
    public void onInitialize() {
        ModBlocks.init();
    }
}
