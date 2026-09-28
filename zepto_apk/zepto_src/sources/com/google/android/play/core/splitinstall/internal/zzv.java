package com.google.android.play.core.splitinstall.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public abstract class zzv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f41999a;

    public zzv() {
        this.f41999a = null;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e2) {
            TaskCompletionSource taskCompletionSource = this.f41999a;
            if (taskCompletionSource != null) {
                taskCompletionSource.c(e2);
            }
        }
    }

    public zzv(TaskCompletionSource taskCompletionSource) {
        this.f41999a = taskCompletionSource;
    }
}
