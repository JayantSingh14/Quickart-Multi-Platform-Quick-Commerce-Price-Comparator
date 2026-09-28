package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class zzi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f39779a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzj f39780b;

    public zzi(zzj zzjVar, Task task) {
        this.f39780b = zzjVar;
        this.f39779a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f39780b.f39782b) {
            try {
                OnCompleteListener onCompleteListener = this.f39780b.f39783c;
                if (onCompleteListener != null) {
                    onCompleteListener.onComplete(this.f39779a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
