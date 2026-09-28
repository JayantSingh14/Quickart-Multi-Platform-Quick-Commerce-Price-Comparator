package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzclx implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f26527a;

    public zzclx(zzijf zzijfVar) {
        this.f26527a = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdzr zzdzrVar = (zzdzr) this.f26527a.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Y1)).booleanValue() ? Collections.singleton(new zzdij(zzdzrVar, zzgywVar)) : Collections.EMPTY_SET;
        zzijo.a(setSingleton);
        return setSingleton;
    }
}
