package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
final class zzcnw implements zzfhl {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f26748a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f26749b;

    public zzcnw(zzcmv zzcmvVar, Context context, String str) {
        zzijh zzijhVarA = zzijh.a(context);
        zzijf zzijfVar = zzcmvVar.M0;
        zzffm zzffmVar = new zzffm(zzijfVar, zzcmvVar.N0, zzijhVarA);
        zzijf zzijfVarA = zzijf.a(new zzfgw(zzijfVar));
        zzijf zzijfVarA2 = zzijf.a(zzfih.f31199a);
        int i2 = zzfil.f31226a;
        zzijf zzijfVarA3 = zzijf.a(new zzfhf(zzijhVarA, zzcmvVar.f26579d, zzcmvVar.H, zzffmVar, zzijfVarA, zzijfVarA2));
        this.f26748a = zzijf.a(new zzfhp(zzijfVarA3, zzijfVarA, zzijfVarA2));
        this.f26749b = zzijf.a(new zzfhj(zzijh.b(str), zzijfVarA3, zzijhVarA, zzijfVarA, zzijfVarA2, zzcmvVar.f26585j, zzcmvVar.I, zzcmvVar.f26587l));
    }

    @Override // com.google.android.gms.internal.ads.zzfhl
    public final zzfho zza() {
        return (zzfho) this.f26748a.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzfhl
    public final zzfhi zzb() {
        return (zzfhi) this.f26749b.zzb();
    }
}
