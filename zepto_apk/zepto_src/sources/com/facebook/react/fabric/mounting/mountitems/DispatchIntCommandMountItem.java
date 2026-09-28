package com.facebook.react.fabric.mounting.mountitems;

import android.support.v4.media.b;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.fabric.mounting.MountingManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class DispatchIntCommandMountItem extends DispatchCommandMountItem {

    @Nullable
    private final ReadableArray commandArgs;
    private final int commandId;
    private final int reactTag;
    private final int surfaceId;

    public DispatchIntCommandMountItem(int i2, int i3, int i4, @Nullable ReadableArray readableArray) {
        this.surfaceId = i2;
        this.reactTag = i3;
        this.commandId = i4;
        this.commandArgs = readableArray;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(@NotNull MountingManager mountingManager) {
        Intrinsics.checkNotNullParameter(mountingManager, "mountingManager");
        mountingManager.receiveCommand(this.surfaceId, this.reactTag, this.commandId, this.commandArgs);
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public int getSurfaceId() {
        return this.surfaceId;
    }

    @NotNull
    public String toString() {
        return b.d(this.reactTag, this.commandId, "DispatchIntCommandMountItem [", "] ");
    }
}
