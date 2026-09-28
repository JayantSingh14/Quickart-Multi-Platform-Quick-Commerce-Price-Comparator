package com.google.android.play.core.appupdate.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public abstract class zzn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f41688a;

    public zzn() {
        this.f41688a = null;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e2) {
            TaskCompletionSource taskCompletionSource = this.f41688a;
            if (taskCompletionSource != null) {
                taskCompletionSource.c(e2);
            }
        }
    }

    public zzn(TaskCompletionSource taskCompletionSource) {
        this.f41688a = taskCompletionSource;
    }
}
