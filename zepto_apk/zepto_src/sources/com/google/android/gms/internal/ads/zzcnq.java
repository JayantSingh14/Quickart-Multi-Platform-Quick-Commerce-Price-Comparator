package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
final class zzcnq implements zzffy {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f26740a;

    public zzcnq(zzcmv zzcmvVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzijh zzijhVarA = zzijh.a(context);
        zzijh zzijhVarA2 = zzijh.a(zzrVar);
        zzijh zzijhVarA3 = zzijh.a(str);
        zzijf zzijfVar = zzcmvVar.f26587l;
        zzijf zzijfVarA = zzijf.a(new zzeqq(zzijfVar));
        zzijf zzijfVarA2 = zzijf.a(new zzfgw(zzcmvVar.M0));
        int i2 = zzfil.f31226a;
        this.f26740a = zzijf.a(new zzeqy(zzijhVarA, zzijhVarA2, zzijhVarA3, zzijf.a(new zzffw(zzcmvVar.f26579d, zzijfVarA, zzijfVarA2, zzijhVarA, zzcmvVar.H)), zzijfVarA, zzijfVarA2, zzcmvVar.f26585j, zzcmvVar.I, zzijfVar));
    }

    @Override // com.google.android.gms.internal.ads.zzffy
    public final zzeqx zza() {
        return (zzeqx) this.f26740a.zzb();
    }
}
