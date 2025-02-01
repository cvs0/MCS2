package com.cvs0.mcs2.mixin;

import com.mojang.authlib.minecraft.BanDetails;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.util.Util;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Inject(method = "isOptionalTelemetryEnabled", at = @At("HEAD"), cancellable = true)
    private void overrideIsOptionalTelemetryEnabled(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "isOptionalTelemetryEnabledByApi", at = @At("HEAD"), cancellable = true)
    private void overrideIsOptionalTelemetryEnabledByApi(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "isTelemetryEnabledByApi", at = @At("HEAD"), cancellable = true)
    private void overrideIsTelemetryEnabledByApi(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "isMultiplayerEnabled", at = @At("HEAD"), cancellable = true)
    private void overrideIsMultiplayerEnabled(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(method = "isUsernameBanned", at = @At("HEAD"), cancellable = true)
    private void overrideIsUsernameBanned(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "getMultiplayerBanDetails", at = @At("HEAD"), cancellable = true)
    private void overrideMultiplayerBanDetails(CallbackInfoReturnable<BanDetails> cir) {
        cir.setReturnValue(null);
    }

    @Inject(method = "shouldBlockMessages", at = @At("HEAD"), cancellable = true)
    private void overrideShouldBlockMessages(UUID sender, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "getChatRestriction", at = @At("HEAD"), cancellable = true)
    private void overrideChatRestriction(CallbackInfoReturnable<MinecraftClient.ChatRestriction> cir) {
        cir.setReturnValue(MinecraftClient.ChatRestriction.ENABLED);
    }
}