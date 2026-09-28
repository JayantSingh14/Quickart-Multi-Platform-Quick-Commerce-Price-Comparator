package com.google.android.play.core.review.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public abstract class zzj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f41858a;

    public zzj() {
        this.f41858a = null;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e2) {
            TaskCompletionSource taskCompletionSource = this.f41858a;
            if (taskCompletionSource != null) {
                taskCompletionSource.c(e2);
            }
        }
    }

    public zzj(TaskCompletionSource taskCompletionSource) {
        this.f41858a = taskCompletionSource;
    }
}
