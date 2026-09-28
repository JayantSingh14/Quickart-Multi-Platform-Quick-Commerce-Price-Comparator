package com.google.android.datatransport.runtime.synchronization;

import androidx.annotation.WorkerThread;

@WorkerThread
/* loaded from: classes.dex */
public interface SynchronizationGuard {

    public interface CriticalSection<T> {
        Object d();
    }

    Object b(CriticalSection criticalSection);
}
