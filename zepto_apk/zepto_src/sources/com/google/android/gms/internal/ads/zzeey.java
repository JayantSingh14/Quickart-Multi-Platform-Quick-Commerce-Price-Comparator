package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes4.dex */
final class zzeey implements zzedk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzefb f29199a;

    public zzeey(zzefb zzefbVar) {
        this.f29199a = zzefbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedk
    public final void a(RemoteException remoteException) {
        this.f29199a.a();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.lf)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("Preconnect Remote", remoteException);
        }
    }

    public final void b() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.kf)).booleanValue()) {
            zzdxd zzdxdVarA = this.f29199a.f29209f.a();
            zzdxdVarA.b("action", "ptard");
            zzdxdVarA.b("ptard", "r");
            zzdxdVarA.c();
        }
    }
}
