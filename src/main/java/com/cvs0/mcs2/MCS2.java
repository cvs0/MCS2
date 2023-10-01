package com.cvs0.mcs2;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MCS2 implements ClientModInitializer {
    public MinecraftClient mc;
    public static Logger LOGGER = LogManager.getLogger("MCS2");
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initialized.");
        mc = MinecraftClient.getInstance();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(mc != null && mc.options != null) {
                if(mc.options.getAllowServerListing().getValue()) {
                    mc.options.getAllowServerListing().setValue(false);
                }

                if(!mc.options.getChatLinksPrompt().getValue()) {
                    mc.options.getChatLinksPrompt().setValue(true);
                }

                if(!mc.options.skipMultiplayerWarning) {
                    mc.options.skipMultiplayerWarning = true;
                }
            }
        });
    }
}
