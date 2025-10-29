package raz.razor.microgrid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import raz.razor.microgrid.block.ModBlocks;
import raz.razor.microgrid.block.entity.ModBlockEntities;
import raz.razor.microgrid.item.ModItems;
import raz.razor.microgrid.screen.ModScreenHandlers;

public class Microgrid implements ModInitializer {

    public static final String MOD_ID = "microgrid";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModItems.init();
        ModBlockEntities.init();
        ModScreenHandlers.init();

        ServerTickEvents.START_SERVER_TICK.register(HeatTransferManager::startTick);
        ServerTickEvents.END_SERVER_TICK.register(HeatTransferManager::endTick);
    }
}
