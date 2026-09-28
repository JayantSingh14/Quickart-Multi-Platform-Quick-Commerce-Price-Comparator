package com.facebook.react.internal.interop;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class InteropEventEmitter implements RCTEventEmitter {

    @Nullable
    private EventDispatcher eventDispatcherOverride;

    @NotNull
    private final ReactContext reactContext;

    public InteropEventEmitter(@NotNull ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @VisibleForTesting
    public final void overrideEventDispatcher(@Nullable EventDispatcher eventDispatcher) {
        this.eventDispatcherOverride = eventDispatcher;
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated
    public void receiveEvent(int i2, @NotNull String eventName, @Nullable WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventDispatcher eventDispatcherB = this.eventDispatcherOverride;
        if (eventDispatcherB == null) {
            eventDispatcherB = UIManagerHelper.b(this.reactContext, i2);
        }
        int iD = UIManagerHelper.d(this.reactContext);
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new InteropEvent(iD, i2, eventName, writableMap));
        }
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated
    public void receiveTouches(@NotNull String eventName, @NotNull WritableArray touches, @NotNull WritableArray changedIndices) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(touches, "touches");
        Intrinsics.checkNotNullParameter(changedIndices, "changedIndices");
        throw new UnsupportedOperationException("EventEmitter#receiveTouches is not supported by the Fabric Interop Layer");
    }
}
