package raz.razor.microgrid.client.screen;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import raz.razor.microgrid.screen.ModScreenHandlers;

public class ModScreens {
    public static void init(){
        HandledScreens.register(ModScreenHandlers.ENERGY_ENTRY_POINT_SCREEN_HANDLER, MGHandledScreen::new);
        HandledScreens.register(ModScreenHandlers.ITEM_INTERFACE_SCREEN_HANDLER, MGHandledScreen::new);
        HandledScreens.register(ModScreenHandlers.MACHINE_INTERFACE_SCREEN_HANDLER, MGHandledScreen::new);
        HandledScreens.register(ModScreenHandlers.SPATIAL_ARRAY_SCREEN_HANDLER, MGHandledScreen::new);
        HandledScreens.register(ModScreenHandlers.SPATIAL_BATTERY_SCREEN_HANDLER, MGHandledScreen::new);
        HandledScreens.register(ModScreenHandlers.WIRELESS_ADAPTER_SCREEN_HANDLER, MGHandledScreen::new);
    }
}
