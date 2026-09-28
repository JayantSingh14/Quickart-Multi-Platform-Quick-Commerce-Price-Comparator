package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzcxb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27337a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27338b;

    public zzcxb(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f27337a = zzijfVar;
        this.f27338b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcxa((Clock) this.f27337a.zzb(), (zzccu) this.f27338b.zzb());
    }
}
