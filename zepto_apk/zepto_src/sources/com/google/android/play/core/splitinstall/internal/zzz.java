package com.google.android.play.core.splitinstall.internal;

/* loaded from: classes4.dex */
final class zzz extends zzv {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzaf f42006b;

    public zzz(zzaf zzafVar) {
        this.f42006b = zzafVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzv
    public final void a() {
        synchronized (this.f42006b.f41945f) {
            try {
                if (this.f42006b.f41950k.get() > 0 && this.f42006b.f41950k.decrementAndGet() > 0) {
                    this.f42006b.f41941b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                zzaf zzafVar = this.f42006b;
                if (zzafVar.f41952m != null) {
                    zzafVar.f41941b.d("Unbind from service.", new Object[0]);
                    zzaf zzafVar2 = this.f42006b;
                    zzafVar2.f41940a.unbindService(zzafVar2.f41951l);
                    zzaf zzafVar3 = this.f42006b;
                    zzafVar3.f41946g = false;
                    zzafVar3.f41952m = null;
                    zzafVar3.f41951l = null;
                }
                this.f42006b.e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
