package com.facebook.react.runtime.internal.bolts;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class TaskCompletionSource<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Task f19340a = new Task();

    public final void a() {
        if (!this.f19340a.o()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public final void b(Exception exc) {
        Task task = this.f19340a;
        synchronized (task.f19317a) {
            try {
                if (task.f19318b) {
                    throw new IllegalStateException("Cannot set the error on a completed task.");
                }
                task.f19318b = true;
                task.f19321e = exc;
                task.f19317a.notifyAll();
                task.n();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Object obj) {
        if (!this.f19340a.p(obj)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }
}
