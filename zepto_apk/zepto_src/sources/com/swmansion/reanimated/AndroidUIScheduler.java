package com.swmansion.reanimated;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class AndroidUIScheduler {
    private final ReactApplicationContext mContext;
    private final AtomicBoolean mActive = new AtomicBoolean(true);
    private final Runnable mUIThreadRunnable = new androidx.lifecycle.a(this, 8);

    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    public AndroidUIScheduler(ReactApplicationContext reactApplicationContext) {
        this.mContext = reactApplicationContext;
    }

    private native HybridData initHybrid();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        if (this.mActive.get()) {
            triggerUI();
        }
    }

    @DoNotStrip
    private void scheduleTriggerOnUI() {
        UiThreadUtil.runOnUiThread(new GuardedRunnable(this.mContext.getExceptionHandler()) { // from class: com.swmansion.reanimated.AndroidUIScheduler.1
            @Override // com.facebook.react.bridge.GuardedRunnable
            public void runGuarded() {
                AndroidUIScheduler.this.mUIThreadRunnable.run();
            }
        });
    }

    public void deactivate() {
        this.mActive.set(false);
    }

    public native void triggerUI();
}
