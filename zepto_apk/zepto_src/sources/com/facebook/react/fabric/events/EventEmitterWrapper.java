package com.facebook.react.fabric.events;

import android.annotation.SuppressLint;
import com.facebook.jni.HybridClassBase;
import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.FabricSoLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStripAny
@Metadata
@SuppressLint({"MissingNativeLoadLibrary"})
/* loaded from: classes3.dex */
public final class EventEmitterWrapper extends HybridClassBase {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        FabricSoLoader.staticInit();
    }

    private EventEmitterWrapper() {
    }

    private final native void dispatchEvent(String str, NativeMap nativeMap, int i2);

    private final native void dispatchEventSynchronously(String str, NativeMap nativeMap);

    private final native void dispatchUniqueEvent(String str, NativeMap nativeMap);

    public final synchronized void destroy() {
        if (isValid()) {
            resetNative();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void dispatch(@NotNull String eventName, @Nullable WritableMap writableMap, int i2) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (isValid()) {
            dispatchEvent(eventName, (NativeMap) writableMap, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void dispatchEventSynchronously(@NotNull String eventName, @Nullable WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (isValid()) {
            dispatchEventSynchronously(eventName, (NativeMap) writableMap);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void dispatchUnique(@NotNull String eventName, @Nullable WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (isValid()) {
            dispatchUniqueEvent(eventName, (NativeMap) writableMap);
        }
    }
}
