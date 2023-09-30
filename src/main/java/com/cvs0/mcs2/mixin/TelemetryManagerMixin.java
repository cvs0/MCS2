package com.cvs0.mcs2.mixin;

import com.cvs0.mcs2.MCS2;
import net.minecraft.SharedConstants;
import net.minecraft.client.session.telemetry.PropertyMap;
import net.minecraft.client.session.telemetry.TelemetryEventType;
import net.minecraft.client.session.telemetry.TelemetryManager;
import net.minecraft.client.session.telemetry.TelemetrySender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;


@Mixin(TelemetryManager.class)
public class TelemetryManagerMixin {
    @Overwrite
    private TelemetrySender computeSender() {
        return TelemetrySender.NOOP;
    }
}