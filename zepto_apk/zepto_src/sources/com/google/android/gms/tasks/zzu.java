package com.google.android.gms.tasks;

import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzu implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.tasks.zza f39803a = new com.google.android.gms.internal.tasks.zza(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f39803a.post(runnable);
    }
}
