package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzcbq implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f25846a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f25847b;

    public zzcbq(zzijf zzijfVar, zzijh zzijhVar) {
        this.f25846a = zzijhVar;
        this.f25847b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzcbp((Clock) this.f25846a.f34899a, (zzcbn) this.f25847b.zzb());
    }
}
