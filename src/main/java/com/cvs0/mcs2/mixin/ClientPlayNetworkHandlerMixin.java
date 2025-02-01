package com.cvs0.mcs2.mixin;

import com.cvs0.mcs2.mixin.accessors.IClientPlayNetworkHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    @Inject(method = "onGameJoin", at = @At("TAIL"))
    private void onJoinCheckSecureChat(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayNetworkHandler handler = (ClientPlayNetworkHandler) (Object) this;

        if (client != null && client.player != null) {
            IClientPlayNetworkHandler accessor = (IClientPlayNetworkHandler) handler;
            if (!accessor.invokeIsSecureChatEnforced()) {
                client.player.sendMessage(
                        Text.literal("Warning: Secure chat is not enforced on this server!")
                                .formatted(Formatting.YELLOW),
                        false
                );
            }
        }
    }
}
