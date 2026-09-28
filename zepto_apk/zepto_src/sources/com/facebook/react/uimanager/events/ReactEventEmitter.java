package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.common.ViewUtil;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ReactEventEmitter implements RCTModernEventEmitter {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String TAG = "ReactEventEmitter";

    @Nullable
    private RCTEventEmitter defaultEventEmitter;

    @Nullable
    private RCTModernEventEmitter fabricEventEmitter;

    @NotNull
    private final ReactApplicationContext reactContext;

    @Metadata
    public static final class Companion {
    }

    public ReactEventEmitter(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    private final RCTEventEmitter ensureDefaultEventEmitter() {
        if (this.defaultEventEmitter == null) {
            if (this.reactContext.hasActiveReactInstance()) {
                this.defaultEventEmitter = (RCTEventEmitter) this.reactContext.getJSModule(RCTEventEmitter.class);
            } else {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get RCTEventEmitter from Context, no active Catalyst instance!"));
            }
        }
        return this.defaultEventEmitter;
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
        RCTEventEmitter rCTEventEmitterEnsureDefaultEventEmitter;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(touches, "touches");
        Intrinsics.checkNotNullParameter(changedIndices, "changedIndices");
        if (touches.size() <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        ReadableMap map = touches.getMap(0);
        if (ViewUtil.a(map != null ? map.getInt("target") : 0) != 1 || (rCTEventEmitterEnsureDefaultEventEmitter = ensureDefaultEventEmitter()) == null) {
            return;
        }
        rCTEventEmitterEnsureDefaultEventEmitter.receiveTouches(eventName, touches, changedIndices);
    }

    public final void register(int i2, @Nullable RCTModernEventEmitter rCTModernEventEmitter) {
        if (i2 != 2) {
            throw new IllegalStateException("Check failed.");
        }
        this.fabricEventEmitter = rCTModernEventEmitter;
    }

    public final void unregister(int i2) {
        if (i2 == 1) {
            this.defaultEventEmitter = null;
        } else {
            this.fabricEventEmitter = null;
        }
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i2, int i3, @NotNull String eventName, @Nullable WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(i2, i3, eventName, false, 0, writableMap, 2);
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i2, int i3, @NotNull String eventName, boolean z, int i4, @Nullable WritableMap writableMap, int i5) {
        RCTModernEventEmitter rCTModernEventEmitter;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        char c2 = i2 == -1 ? (char) 1 : (char) 2;
        if (c2 == 1 && i3 % 10 != 1 && i3 % 2 == 0) {
            c2 = 2;
        }
        if (c2 != 1) {
            if (c2 == 2 && (rCTModernEventEmitter = this.fabricEventEmitter) != null) {
                rCTModernEventEmitter.receiveEvent(i2, i3, eventName, z, i4, writableMap, i5);
                return;
            }
            return;
        }
        RCTEventEmitter rCTEventEmitterEnsureDefaultEventEmitter = ensureDefaultEventEmitter();
        if (rCTEventEmitterEnsureDefaultEventEmitter != null) {
            rCTEventEmitterEnsureDefaultEventEmitter.receiveEvent(i3, eventName, writableMap);
        }
    }

    public final void register(int i2, @Nullable RCTEventEmitter rCTEventEmitter) {
        if (i2 == 1) {
            this.defaultEventEmitter = rCTEventEmitter;
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    @Deprecated
    public void receiveTouches(@NotNull TouchEvent event) {
        RCTModernEventEmitter rCTModernEventEmitter;
        Intrinsics.checkNotNullParameter(event, "event");
        int viewTag = event.getViewTag();
        char c2 = event.getSurfaceId() == -1 ? (char) 1 : (char) 2;
        if (c2 == 1 && viewTag % 10 != 1 && viewTag % 2 == 0) {
            c2 = 2;
        }
        if (c2 != 1) {
            if (c2 == 2 && (rCTModernEventEmitter = this.fabricEventEmitter) != null) {
                TouchesHelper.c(rCTModernEventEmitter, event);
                return;
            }
            return;
        }
        RCTEventEmitter rCTEventEmitterEnsureDefaultEventEmitter = ensureDefaultEventEmitter();
        if (rCTEventEmitterEnsureDefaultEventEmitter != null) {
            TouchesHelper.d(rCTEventEmitterEnsureDefaultEventEmitter, event);
        }
    }
}
