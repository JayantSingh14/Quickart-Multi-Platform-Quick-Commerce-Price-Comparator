package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzcyy implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27437a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f27438b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdab f27439c;

    public zzcyy(zzijf zzijfVar, zzcmg zzcmgVar, zzdab zzdabVar) {
        this.f27437a = zzijfVar;
        this.f27438b = zzcmgVar;
        this.f27439c = zzdabVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.f27437a.zzb();
        final VersionInfoParcel versionInfoParcelA = this.f27438b.a();
        final zzfik zzfikVarA = this.f27439c.a();
        return new zzgpr() { // from class: com.google.android.gms.internal.ads.zzcyx
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final Object apply(Object obj) {
                zzfhr zzfhrVar = (zzfhr) obj;
                com.google.android.gms.ads.internal.util.zzat zzatVar = new com.google.android.gms.ads.internal.util.zzat(context);
                zzatVar.f21488c = zzfhrVar.B;
                zzatVar.f21491f = zzfhrVar.C.toString();
                zzatVar.f21490e = versionInfoParcelA.f21400a;
                zzatVar.f21489d = zzfikVarA.f31219g;
                return zzatVar;
            }
        };
    }
}
