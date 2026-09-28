package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzdij;
import com.google.android.gms.internal.ads.zzgyw;
import com.google.android.gms.internal.ads.zzijf;
import com.google.android.gms.internal.ads.zzijg;
import com.google.android.gms.internal.ads.zzijo;

/* loaded from: classes4.dex */
public final class zzbe implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f21836a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f21837b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f21838c;

    public zzbe(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f21836a = zzijfVar;
        this.f21837b = zzijfVar2;
        this.f21838c = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Object obj = (zzw) this.f21836a.zzb();
        Object obj2 = (zzbl) this.f21837b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        if (((Integer) this.f21838c.zzb()).intValue() == 2) {
            obj = obj2;
        }
        return new zzdij(obj, zzgywVar);
    }
}
