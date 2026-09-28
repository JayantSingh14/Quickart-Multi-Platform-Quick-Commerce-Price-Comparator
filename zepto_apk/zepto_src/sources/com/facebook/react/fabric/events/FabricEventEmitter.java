package com.facebook.react.fabric.events;

import android.os.Trace;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.systrace.Systrace;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class FabricEventEmitter implements RCTModernEventEmitter {

    @NotNull
    private final FabricUIManager uiManager;

    public FabricEventEmitter(@NotNull FabricUIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        this.uiManager = uiManager;
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated
    public void receiveEvent(int i2, @NotNull String eventName, @Nullable WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(-1, i2, eventName, writableMap);
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated
    public void receiveTouches(@NotNull String eventName, @NotNull WritableArray touches, @NotNull WritableArray changedIndices) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(touches, "touches");
        Intrinsics.checkNotNullParameter(changedIndices, "changedIndices");
        throw new UnsupportedOperationException("EventEmitter#receiveTouches is not supported by Fabric");
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i2, int i3, @NotNull String eventName, @Nullable WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(i2, i3, eventName, false, 0, writableMap, 2);
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    @Deprecated
    public void receiveTouches(@NotNull TouchEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw new UnsupportedOperationException("EventEmitter#receiveTouches is not supported by Fabric");
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i2, int i3, @NotNull String eventName, boolean z, int i4, @Nullable WritableMap writableMap, int i5) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Systrace.a("FabricEventEmitter.receiveEvent('" + eventName + "')");
        try {
            this.uiManager.receiveEvent(i2, i3, eventName, z, writableMap, i5);
        } finally {
            Trace.endSection();
        }
    }
}
