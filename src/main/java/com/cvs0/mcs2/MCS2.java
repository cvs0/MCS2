package com.cvs0.mcs2;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MCS2 implements ClientModInitializer {
    public static MinecraftClient mc;
    public static SecurityContainer sc;
    public static Logger LOGGER = LogManager.getLogger("MCS2");
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initialized.");
        mc = MinecraftClient.getInstance();
        sc = new SecurityContainer();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            sc.secure(mc);
        });
    }
}
