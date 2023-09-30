package com.cvs0.mcs2.mixin;

import com.mojang.authlib.minecraft.BanDetails;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    /**
     * @author cvs0
     * @reason Prevents multiplayer bans.
     */
    @Overwrite
    public boolean isMultiplayerEnabled() {
        return true;
    }

    /**
     * @author cvs0
     * @reason Prevents realms bans
     */
    @Overwrite
    public boolean isRealmsEnabled() {
        return true;
    }

    /**
     * @author cvs0
     * @reason Prevents username bans
     */
    @Overwrite
    public boolean isUsernameBanned() {
        return false;
    }

    /**
     * @author cvs0
     * @reason Nullifies the response for grabbing the ban details.
     */
    @Overwrite
    @Nullable
    public BanDetails getMultiplayerBanDetails() {
        return null;
    }
}
