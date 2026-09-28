package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcsf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27046a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27047b;

    public zzcsf(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f27046a = zzijfVar;
        this.f27047b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzcrx zzcrxVar = (zzcrx) this.f27046a.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        Set setSingleton = ((JSONObject) this.f27047b.zzb()) == null ? Collections.EMPTY_SET : Collections.singleton(new zzdij(zzcrxVar, zzgywVar));
        zzijo.a(setSingleton);
        return setSingleton;
    }
}
