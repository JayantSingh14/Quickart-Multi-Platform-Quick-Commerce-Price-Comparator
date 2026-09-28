package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzctt implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27134a;

    public zzctt(zzctj zzctjVar, zzijf zzijfVar) {
        this.f27134a = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Set setSingleton = Collections.singleton(new zzdij((zzcuz) this.f27134a.zzb(), zzcdo.f25988g));
        zzijo.a(setSingleton);
        return setSingleton;
    }
}
