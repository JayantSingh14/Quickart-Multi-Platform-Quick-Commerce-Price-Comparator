package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzclp;
import com.google.android.gms.internal.ads.zzcmg;
import com.google.android.gms.internal.ads.zzijg;

/* loaded from: classes4.dex */
public final class zzg implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f21898a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f21899b;

    public zzg(zzclp zzclpVar, zzcmg zzcmgVar) {
        this.f21898a = zzclpVar;
        this.f21899b = zzcmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f21898a.a();
        new zzbfu();
        zzbgb zzbgbVar = zzbgk.f25011a;
        return new zzf(contextA, com.google.android.gms.ads.internal.client.zzbd.f21150e.f21151a.a(), this.f21899b.a());
    }
}
