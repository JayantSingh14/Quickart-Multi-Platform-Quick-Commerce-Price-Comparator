package com.facebook.react.fabric.mounting.mountitems;

import android.support.v4.media.b;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.fabric.mounting.MountingManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class SendAccessibilityEventMountItem implements MountItem {

    @NotNull
    private final String TAG = "Fabric.SendAccessibilityEvent";
    private final int _surfaceId;
    private final int eventType;
    private final int reactTag;

    public SendAccessibilityEventMountItem(int i2, int i3, int i4) {
        this._surfaceId = i2;
        this.reactTag = i3;
        this.eventType = i4;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(@NotNull MountingManager mountingManager) {
        Intrinsics.checkNotNullParameter(mountingManager, "mountingManager");
        try {
            mountingManager.sendAccessibilityEvent(this._surfaceId, this.reactTag, this.eventType);
        } catch (RetryableMountingLayerException e2) {
            ReactSoftExceptionLogger.logSoftException(this.TAG, e2);
        }
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public int getSurfaceId() {
        return this._surfaceId;
    }

    @NotNull
    public String toString() {
        return b.d(this.reactTag, this.eventType, "SendAccessibilityEventMountItem [", "] ");
    }
}
