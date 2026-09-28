package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class DestroyUnmountedViewMountItem implements MountItem {
    private final int _surfaceId;
    private final int reactTag;

    public DestroyUnmountedViewMountItem(int i2, int i3) {
        this._surfaceId = i2;
        this.reactTag = i3;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(@NotNull MountingManager mountingManager) {
        Intrinsics.checkNotNullParameter(mountingManager, "mountingManager");
        SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(this._surfaceId);
        if (surfaceManager == null) {
            return;
        }
        surfaceManager.deleteView(this.reactTag);
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public int getSurfaceId() {
        return this._surfaceId;
    }
}
