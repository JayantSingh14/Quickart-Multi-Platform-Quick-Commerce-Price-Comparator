package com.google.android.play.core.appupdate.internal;

/* loaded from: classes4.dex */
final class zzr extends zzn {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzx f41695b;

    public zzr(zzx zzxVar) {
        this.f41695b = zzxVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() {
        synchronized (this.f41695b.f41705f) {
            try {
                if (this.f41695b.f41710k.get() > 0 && this.f41695b.f41710k.decrementAndGet() > 0) {
                    this.f41695b.f41701b.c("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                zzx zzxVar = this.f41695b;
                if (zzxVar.f41712m != null) {
                    zzxVar.f41701b.c("Unbind from service.", new Object[0]);
                    zzx zzxVar2 = this.f41695b;
                    zzxVar2.f41700a.unbindService(zzxVar2.f41711l);
                    zzx zzxVar3 = this.f41695b;
                    zzxVar3.f41706g = false;
                    zzxVar3.f41712m = null;
                    zzxVar3.f41711l = null;
                }
                this.f41695b.e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
