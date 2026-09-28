package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
final class zzcna implements zzfcv {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f26623a;

    public zzcna(zzcmv zzcmvVar, Context context, String str) {
        zzijh zzijhVarA = zzijh.a(context);
        zzijh zzijhVarA2 = zzijh.a(str);
        zzijf zzijfVar = zzcmvVar.M0;
        zzffl zzfflVar = new zzffl(zzijfVar, zzcmvVar.N0, zzijhVarA);
        zzijf zzijfVarA = zzijf.a(new zzfds(zzijfVar));
        int i2 = zzfil.f31226a;
        zzijf zzijfVar2 = zzcmvVar.f26579d;
        zzijh zzijhVar = zzcmvVar.H;
        zzcmg zzcmgVar = zzcmvVar.f26585j;
        this.f26623a = zzijf.a(new zzfea(zzijhVar, zzijhVarA, zzijhVarA2, zzijf.a(new zzfdu(zzijhVarA, zzijfVar2, zzijhVar, zzfflVar, zzijfVarA, zzcmgVar)), zzijfVarA, zzcmgVar, zzcmvVar.f26587l));
    }

    @Override // com.google.android.gms.internal.ads.zzfcv
    public final zzfdz zza() {
        return (zzfdz) this.f26623a.zzb();
    }
}
