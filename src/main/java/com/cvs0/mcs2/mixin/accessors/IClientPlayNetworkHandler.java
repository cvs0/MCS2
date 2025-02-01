package com.cvs0.mcs2.mixin.accessors;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ClientPlayNetworkHandler.class)
public interface IClientPlayNetworkHandler {
    @Invoker("isSecureChatEnforced")
    boolean invokeIsSecureChatEnforced();
}