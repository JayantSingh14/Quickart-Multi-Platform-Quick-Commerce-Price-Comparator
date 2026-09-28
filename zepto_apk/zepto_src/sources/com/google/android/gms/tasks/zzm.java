package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class zzm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f39789a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f39790b;

    public zzm(zzn zznVar, Task task) {
        this.f39790b = zznVar;
        this.f39789a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f39790b.f39792b) {
            try {
                OnSuccessListener onSuccessListener = this.f39790b.f39793c;
                if (onSuccessListener != null) {
                    onSuccessListener.onSuccess(this.f39789a.l());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
