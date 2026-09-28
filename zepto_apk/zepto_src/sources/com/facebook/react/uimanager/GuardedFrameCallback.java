package com.facebook.react.uimanager;

import android.view.Choreographer;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public abstract class GuardedFrameCallback implements Choreographer.FrameCallback {

    @NotNull
    private final JSExceptionHandler exceptionHandler;

    public GuardedFrameCallback(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        JSExceptionHandler exceptionHandler = reactContext.getExceptionHandler();
        Intrinsics.checkNotNullExpressionValue(exceptionHandler, "getExceptionHandler(...)");
        Intrinsics.checkNotNullParameter(exceptionHandler, "exceptionHandler");
        this.exceptionHandler = exceptionHandler;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        try {
            doFrameGuarded(j2);
        } catch (RuntimeException e2) {
            this.exceptionHandler.handleException(e2);
        }
    }

    public abstract void doFrameGuarded(long j2);
}
