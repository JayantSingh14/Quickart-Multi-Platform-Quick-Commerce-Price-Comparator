package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f39784a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzl f39785b;

    public zzk(zzl zzlVar, Task task) {
        this.f39785b = zzlVar;
        this.f39784a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f39785b.f39787b) {
            try {
                OnFailureListener onFailureListener = this.f39785b.f39788c;
                if (onFailureListener != null) {
                    onFailureListener.onFailure((Exception) Preconditions.checkNotNull(this.f39784a.k()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
