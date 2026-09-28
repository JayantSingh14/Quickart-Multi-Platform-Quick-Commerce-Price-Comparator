package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzdxe {

    /* renamed from: a, reason: collision with root package name */
    public final zzdxj f28729a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f28730b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f28731c;

    public zzdxe(zzdxj zzdxjVar, zzgyw zzgywVar) {
        this.f28729a = zzdxjVar;
        zzdxjVar.getClass();
        this.f28731c = new HashMap(zzdxjVar.f28748a);
        this.f28730b = zzgywVar;
    }

    public final zzdxd a() {
        zzdxd zzdxdVar = new zzdxd(this);
        zzdxdVar.f28727a.putAll(zzdxdVar.f28728b.f28731c);
        return zzdxdVar;
    }

    public final void b() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Kc)).booleanValue()) {
            zzdxd zzdxdVarA = a();
            zzdxdVarA.b("action", "pecr");
            zzdxdVarA.c();
        }
    }
}
