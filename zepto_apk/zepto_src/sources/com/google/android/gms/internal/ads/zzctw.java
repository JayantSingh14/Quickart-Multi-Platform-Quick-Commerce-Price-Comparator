package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzctw implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27137a;

    public zzctw(zzijf zzijfVar) {
        this.f27137a = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzdij((zzcuz) this.f27137a.zzb(), zzcdo.f25988g));
        zzijo.a(setSingleton);
        return setSingleton;
    }
}
