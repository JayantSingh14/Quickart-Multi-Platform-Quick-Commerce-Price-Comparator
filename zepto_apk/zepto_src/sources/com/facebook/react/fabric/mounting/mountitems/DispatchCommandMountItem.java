package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.UiThread;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public abstract class DispatchCommandMountItem implements MountItem {
    private int numRetries;

    @UiThread
    public final int getRetries() {
        return this.numRetries;
    }

    @UiThread
    public final void incrementRetries() {
        this.numRetries++;
    }
}
