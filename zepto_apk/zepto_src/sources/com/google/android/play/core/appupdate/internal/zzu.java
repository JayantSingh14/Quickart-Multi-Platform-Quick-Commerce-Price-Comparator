package com.google.android.play.core.appupdate.internal;

/* loaded from: classes4.dex */
final class zzu extends zzn {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzw f41698b;

    public zzu(zzw zzwVar) {
        this.f41698b = zzwVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() {
        zzx zzxVar = this.f41698b.f41699a;
        zzxVar.f41701b.c("unlinkToDeath", new Object[0]);
        zzxVar.f41712m.asBinder().unlinkToDeath(zzxVar.f41709j, 0);
        zzxVar.f41712m = null;
        zzxVar.f41706g = false;
    }
}
