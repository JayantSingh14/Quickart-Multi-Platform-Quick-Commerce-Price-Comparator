package com.google.android.gms.tasks;

/* loaded from: classes4.dex */
final class zzg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzh f39775a;

    public zzg(zzh zzhVar) {
        this.f39775a = zzhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f39775a.f39777b) {
            try {
                OnCanceledListener onCanceledListener = this.f39775a.f39778c;
                if (onCanceledListener != null) {
                    onCanceledListener.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
