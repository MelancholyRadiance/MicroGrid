package raz.razor.microgrid.client;

import net.fabricmc.api.ClientModInitializer;
import raz.razor.microgrid.client.renderer.ModRenderers;
import raz.razor.microgrid.client.screen.ModScreens;

public class MicrogridClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModRenderers.init();

        ModScreens.init();
    }
}
