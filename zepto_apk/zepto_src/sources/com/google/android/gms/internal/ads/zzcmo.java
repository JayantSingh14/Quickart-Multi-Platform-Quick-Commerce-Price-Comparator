package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzcmo implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f26543a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f26544b;

    public zzcmo(zzclp zzclpVar, zzijf zzijfVar) {
        this.f26543a = zzclpVar;
        this.f26544b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzbyw zzb() {
        Context contextA = this.f26543a.a();
        zzfnr zzfnrVar = (zzfnr) this.f26544b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        zzbsf zzbsfVarA = zztVar.r.a(contextA, VersionInfoParcel.b(), zzfnrVar);
        zzbrz zzbrzVar = zzbsc.f25504a;
        zzbsfVarA.getClass();
        return new zzbyw(contextA, zztVar.r.a(contextA, VersionInfoParcel.b(), zzfnrVar).a("google.afma.sdkConstants.getSdkConstants", zzbrzVar, zzbrzVar), VersionInfoParcel.b(), zzgywVar);
    }
}
