package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.jni.annotations.DoNotStripAny;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.modules.core.JavaScriptTimerExecutor;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@DoNotStripAny
@Metadata
/* loaded from: classes3.dex */
public final class JSTimerExecutor implements JavaScriptTimerExecutor {

    @NotNull
    private static final Companion Companion = new Companion();

    @NotNull
    private final HybridData mHybridData;

    @Metadata
    public static final class Companion {
    }

    static {
        SoLoader.m("rninstance");
    }

    public JSTimerExecutor(@NotNull HybridData mHybridData) {
        Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
        this.mHybridData = mHybridData;
    }

    private final native void callTimers(WritableNativeArray writableNativeArray);

    @Override // com.facebook.react.modules.core.JavaScriptTimerExecutor
    public void callIdleCallbacks(double d2) {
    }

    @Override // com.facebook.react.modules.core.JavaScriptTimerExecutor
    public void callTimers(@NotNull WritableArray timerIDs) {
        Intrinsics.checkNotNullParameter(timerIDs, "timerIDs");
        callTimers((WritableNativeArray) timerIDs);
    }

    @Override // com.facebook.react.modules.core.JavaScriptTimerExecutor
    public void emitTimeDriftWarning(@NotNull String warningMessage) {
        Intrinsics.checkNotNullParameter(warningMessage, "warningMessage");
    }
}
