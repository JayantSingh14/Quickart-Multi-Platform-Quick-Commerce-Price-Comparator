package com.google.android.play.integrity.internal;

/* loaded from: classes4.dex */
final class ab extends t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ad f42154b;

    public ab(ad adVar) {
        this.f42154b = adVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        ae aeVar = this.f42154b.f42155a;
        aeVar.f42157b.b("unlinkToDeath", new Object[0]);
        aeVar.n.asBinder().unlinkToDeath(aeVar.f42166k, 0);
        aeVar.n = null;
        aeVar.f42162g = false;
    }
}
