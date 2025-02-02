package com.cvs0.mcs2;

import net.minecraft.client.MinecraftClient;

public class SecurityContainer {
    public void secure(MinecraftClient mc) {
        if(mc != null && mc.options != null) {

            if(mc.options.getAllowServerListing().getValue()) {
                mc.options.getAllowServerListing().setValue(false);
            }

            if(!mc.options.getChatLinksPrompt().getValue()) {
                mc.options.getChatLinksPrompt().setValue(true);
            }

            if(!mc.options.skipMultiplayerWarning) mc.options.skipMultiplayerWarning = true;

            if(!mc.options.advancedItemTooltips) mc.options.advancedItemTooltips = true;
        }
    }
}
