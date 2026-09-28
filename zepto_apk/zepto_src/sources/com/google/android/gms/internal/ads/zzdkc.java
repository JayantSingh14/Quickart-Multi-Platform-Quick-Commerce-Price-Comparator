package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzdkc implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27841a;

    public zzdkc(zzijf zzijfVar) {
        this.f27841a = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzdij((zzczb) this.f27841a.zzb(), zzcdo.f25988g));
        zzijo.a(setSingleton);
        return setSingleton;
    }
}
