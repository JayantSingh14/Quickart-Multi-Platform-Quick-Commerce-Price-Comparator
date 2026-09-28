package com.google.android.play.integrity.internal;

/* loaded from: classes4.dex */
final class x extends t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ae f42202b;

    public x(ae aeVar) {
        this.f42202b = aeVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        synchronized (this.f42202b.f42161f) {
            try {
                if (this.f42202b.f42167l.get() > 0 && this.f42202b.f42167l.decrementAndGet() > 0) {
                    this.f42202b.f42157b.b("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                ae aeVar = this.f42202b;
                if (aeVar.n != null) {
                    aeVar.f42157b.b("Unbind from service.", new Object[0]);
                    ae aeVar2 = this.f42202b;
                    aeVar2.f42156a.unbindService(aeVar2.f42168m);
                    ae aeVar3 = this.f42202b;
                    aeVar3.f42162g = false;
                    aeVar3.n = null;
                    aeVar3.f42168m = null;
                }
                this.f42202b.e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
