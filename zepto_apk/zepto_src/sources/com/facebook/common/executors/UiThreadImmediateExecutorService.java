package com.facebook.common.executors;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {

    /* renamed from: b, reason: collision with root package name */
    public static UiThreadImmediateExecutorService f17074b;

    @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Thread.currentThread() == this.f17071a.getLooper().getThread()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
