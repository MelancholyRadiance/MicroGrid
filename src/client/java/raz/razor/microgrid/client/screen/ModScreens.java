package raz.razor.microgrid.client.screen;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import raz.razor.microgrid.Microgrid;

public class ModScreens {
    public static void init(){
        HandledScreens.register(Microgrid.ENERGY_ENTRY_POINT_SCREEN_HANDLER, MGHandledScreen::new);
        HandledScreens.register(Microgrid.ITEM_INTERFACE_SCREEN_HANDLER, MGHandledScreen::new);
        HandledScreens.register(Microgrid.MACHINE_INTERFACE_SCREEN_HANDLER, MGHandledScreen::new);
        HandledScreens.register(Microgrid.SPATIAL_ARRAY_SCREEN_HANDLER, MGHandledScreen::new);
        HandledScreens.register(Microgrid.SPATIAL_BATTERY_SCREEN_HANDLER, MGHandledScreen::new);
        HandledScreens.register(Microgrid.WIRELESS_ADAPTER_SCREEN_HANDLER, MGHandledScreen::new);
    }
}
