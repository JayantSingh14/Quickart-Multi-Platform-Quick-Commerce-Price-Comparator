package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzdag implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27559a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f27560b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcwb f27561c;

    public zzdag(zzijf zzijfVar, zzcmg zzcmgVar, zzcwb zzcwbVar) {
        this.f27559a = zzijfVar;
        this.f27560b = zzcmgVar;
        this.f27561c = zzcwbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context context = (Context) this.f27559a.zzb();
        VersionInfoParcel versionInfoParcelA = this.f27560b.a();
        zzfhr zzfhrVarA = this.f27561c.a();
        new zzcbg();
        zzcbh zzcbhVar = zzfhrVarA.A;
        if (zzcbhVar == null) {
            return null;
        }
        zzfhw zzfhwVar = zzfhrVarA.s;
        return new zzcbf(context, versionInfoParcelA, zzcbhVar, zzfhwVar != null ? zzfhwVar.f31180b : null);
    }
}
