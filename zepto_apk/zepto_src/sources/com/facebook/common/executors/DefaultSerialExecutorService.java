package com.facebook.common.executors;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class DefaultSerialExecutorService extends ConstrainedExecutorService implements SerialExecutorService {
    @Override // com.facebook.common.executors.ConstrainedExecutorService, java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        super.execute(runnable);
        throw null;
    }
}
