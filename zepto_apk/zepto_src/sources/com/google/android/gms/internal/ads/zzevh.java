package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzevh implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30406a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30407b;

    public zzevh(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30406a = zzijfVar;
        this.f30407b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfhq((Clock) this.f30406a.zzb(), (zzdxe) this.f30407b.zzb());
    }
}
