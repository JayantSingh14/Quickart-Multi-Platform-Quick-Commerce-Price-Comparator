package com.facebook.react.bridge;

import com.facebook.infer.annotation.Nullsafe;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.devsupport.inspector.InspectorNetworkRequestListener;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

@DoNotStripAny
@Nullsafe
/* loaded from: classes.dex */
public class ReactInstanceManagerInspectorTarget implements AutoCloseable {
    private final HybridData mHybridData;

    @DoNotStripAny
    /* loaded from: classes3.dex */
    public interface TargetDelegate {
        Map<String, String> getMetadata();

        void loadNetworkResource(String str, InspectorNetworkRequestListener inspectorNetworkRequestListener);

        void onReload();

        void onSetPausedInDebuggerMessage(@Nullable String str);
    }

    static {
        ReactBridge.staticInit();
    }

    public ReactInstanceManagerInspectorTarget(TargetDelegate targetDelegate) {
        this.mHybridData = initHybrid(new Executor() { // from class: com.facebook.react.bridge.ReactInstanceManagerInspectorTarget.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                if (UiThreadUtil.isOnUiThread()) {
                    runnable.run();
                } else {
                    UiThreadUtil.runOnUiThread(runnable);
                }
            }
        }, targetDelegate);
    }

    private native HybridData initHybrid(Executor executor, TargetDelegate targetDelegate);

    @Override // java.lang.AutoCloseable
    public void close() {
        this.mHybridData.resetNative();
    }

    public boolean isValid() {
        return this.mHybridData.isValid();
    }

    public native void sendDebuggerResumeCommand();
}
