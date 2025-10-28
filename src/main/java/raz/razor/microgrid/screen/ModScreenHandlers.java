package raz.razor.microgrid.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import raz.razor.microgrid.Microgrid;

public class ModScreenHandlers {
    public static final ScreenHandlerType<MGScreenHandler> ITEM_INTERFACE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Microgrid.MOD_ID, "item_interface"), new ScreenHandlerType<>(ItemInterfaceScreenHandler::new, FeatureSet.empty()));
    public static final ScreenHandlerType<MGScreenHandler> MACHINE_INTERFACE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Microgrid.MOD_ID, "machine_interface"), new ScreenHandlerType<>(MachineInterfaceScreenHandler::new, FeatureSet.empty()));
    public static final ScreenHandlerType<MGScreenHandler> ENERGY_ENTRY_POINT_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Microgrid.MOD_ID, "energy_entry_point"), new ScreenHandlerType<>(EnergyEntryPointScreenHandler::new, FeatureSet.empty()));
    public static final ScreenHandlerType<MGScreenHandler> SPATIAL_ARRAY_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Microgrid.MOD_ID, "spatial_array"), new ScreenHandlerType<>(SpatialArrayScreenHandler::new, FeatureSet.empty()));
    public static final ScreenHandlerType<MGScreenHandler> SPATIAL_BATTERY_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Microgrid.MOD_ID, "spatial_battery"), new ScreenHandlerType<>(SpatialBatteryScreenHandler::new, FeatureSet.empty()));
    public static final ScreenHandlerType<MGScreenHandler> WIRELESS_ADAPTER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Microgrid.MOD_ID, "wireless_adapter"), new ScreenHandlerType<>(WirelessAdapterScreenHandler::new, FeatureSet.empty()));

    public static void init(){

    }
}
