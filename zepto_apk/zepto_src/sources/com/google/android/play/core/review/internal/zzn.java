package com.google.android.play.core.review.internal;

/* loaded from: classes4.dex */
final class zzn extends zzj {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzt f41864b;

    public zzn(zzt zztVar) {
        this.f41864b = zztVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void a() {
        zzt zztVar = this.f41864b;
        if (zztVar.f41881m != null) {
            zztVar.f41870b.a("Unbind from service.", new Object[0]);
            zztVar.f41869a.unbindService(zztVar.f41880l);
            zztVar.f41875g = false;
            zztVar.f41881m = null;
            zztVar.f41880l = null;
        }
        zztVar.d();
    }
}
