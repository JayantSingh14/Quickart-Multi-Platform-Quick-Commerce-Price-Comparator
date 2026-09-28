package com.google.android.play.core.review.internal;

/* loaded from: classes4.dex */
final class zzq extends zzj {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzs f41867b;

    public zzq(zzs zzsVar) {
        this.f41867b = zzsVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void a() {
        zzt zztVar = this.f41867b.f41868a;
        zztVar.f41870b.a("unlinkToDeath", new Object[0]);
        zztVar.f41881m.asBinder().unlinkToDeath(zztVar.f41878j, 0);
        zztVar.f41881m = null;
        zztVar.f41875g = false;
    }
}
