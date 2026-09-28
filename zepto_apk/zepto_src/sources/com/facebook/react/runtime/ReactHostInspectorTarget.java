package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.soloader.SoLoader;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@DoNotStripAny
@Metadata
/* loaded from: classes3.dex */
public final class ReactHostInspectorTarget implements Closeable, AutoCloseable {

    @NotNull
    private static final Companion Companion = new Companion();

    @NotNull
    private final HybridData mHybridData;

    @NotNull
    private final ReactHostImpl reactHostImpl;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class UIThreadConditionalSyncExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            if (UiThreadUtil.isOnUiThread()) {
                command.run();
            } else {
                UiThreadUtil.runOnUiThread(command);
            }
        }
    }

    static {
        SoLoader.m("rninstance");
    }

    public ReactHostInspectorTarget(@NotNull ReactHostImpl reactHostImpl) {
        Intrinsics.checkNotNullParameter(reactHostImpl, "reactHostImpl");
        this.reactHostImpl = reactHostImpl;
        this.mHybridData = initHybrid(reactHostImpl, new UIThreadConditionalSyncExecutor());
    }

    private static /* synthetic */ void getMHybridData$annotations() {
    }

    private final native HybridData initHybrid(ReactHostImpl reactHostImpl, Executor executor);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mHybridData.resetNative();
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    public final native void sendDebuggerResumeCommand();
}
