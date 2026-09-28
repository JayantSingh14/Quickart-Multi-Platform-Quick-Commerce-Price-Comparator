package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzdos implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdmn f28131a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f28132b;

    public zzdos(zzdmn zzdmnVar, zzijf zzijfVar) {
        this.f28131a = zzdmnVar;
        this.f28132b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdsp zzdspVar = this.f28131a.f27971a.f27964b;
        zzijo.a(zzdspVar);
        return new zzdor(zzdspVar, (Clock) this.f28132b.zzb());
    }
}
