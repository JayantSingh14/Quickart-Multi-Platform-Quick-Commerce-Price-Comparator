package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public abstract class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f42195a;

    public t() {
        this.f42195a = null;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f42195a;
        if (taskCompletionSource != null) {
            taskCompletionSource.c(exc);
        }
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b();
        } catch (Exception e2) {
            a(e2);
        }
    }

    public t(TaskCompletionSource taskCompletionSource) {
        this.f42195a = taskCompletionSource;
    }
}
