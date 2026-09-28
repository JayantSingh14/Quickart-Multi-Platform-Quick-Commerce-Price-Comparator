package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzdlw implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdlt f27914a;

    public zzdlw(zzdlt zzdltVar) {
        this.f27914a = zzdltVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdnw zzdnwVar = this.f27914a.f27913a.f27909a;
        zzijo.a(zzdnwVar);
        Set setSingleton = zzdnwVar.f28061d != null ? Collections.singleton("banner") : Collections.EMPTY_SET;
        zzijo.a(setSingleton);
        return setSingleton;
    }
}
