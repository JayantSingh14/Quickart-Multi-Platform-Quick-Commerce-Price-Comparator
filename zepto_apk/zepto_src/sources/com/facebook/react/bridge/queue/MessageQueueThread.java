package com.facebook.react.bridge.queue;

import androidx.annotation.Nullable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@DoNotStrip
/* loaded from: classes.dex */
public interface MessageQueueThread {
    @DoNotStrip
    void assertIsOnThread();

    @DoNotStrip
    void assertIsOnThread(String str);

    @DoNotStrip
    <T> Future<T> callOnQueue(Callable<T> callable);

    @Nullable
    @DoNotStrip
    MessageQueueThreadPerfStats getPerfStats();

    @DoNotStrip
    boolean isIdle();

    @DoNotStrip
    boolean isOnThread();

    @DoNotStrip
    void quitSynchronous();

    @DoNotStrip
    void resetPerfStats();

    @DoNotStrip
    boolean runOnQueue(Runnable runnable);
}
