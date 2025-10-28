package raz.razor.microgrid;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import raz.razor.microgrid.blocks.ModBlocks;
import raz.razor.microgrid.blocks.entities.ModBlockEntities;
import raz.razor.microgrid.screen.ItemInterfaceScreenHandler;
import raz.razor.microgrid.screen.MGScreenHandler;

public class Microgrid implements ModInitializer {

    public static final String MOD_ID = "microgrid";
    public static final ScreenHandlerType<MGScreenHandler> BOX_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MOD_ID, "item_interface"), new ScreenHandlerType<>(ItemInterfaceScreenHandler::new, FeatureSet.empty()));

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModBlockEntities.init();
    }
}
