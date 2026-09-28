package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzclp;
import com.google.android.gms.internal.ads.zzdxj;
import com.google.android.gms.internal.ads.zzgyw;
import com.google.android.gms.internal.ads.zzijf;
import com.google.android.gms.internal.ads.zzijg;
import com.google.android.gms.internal.ads.zzijo;

/* loaded from: classes4.dex */
public final class zzr implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f21933a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f21934b;

    public zzr(zzclp zzclpVar, zzijf zzijfVar) {
        this.f21933a = zzclpVar;
        this.f21934b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f21933a.a();
        zzdxj zzdxjVar = (zzdxj) this.f21934b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzo(contextA, zzdxjVar, zzgywVar);
    }
}
