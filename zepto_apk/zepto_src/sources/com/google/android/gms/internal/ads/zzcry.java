package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzcry implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27021a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27022b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f27023c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f27024d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f27025e;

    public zzcry(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijf zzijfVar5) {
        this.f27021a = zzijfVar;
        this.f27022b = zzijfVar2;
        this.f27023c = zzijfVar3;
        this.f27024d = zzijfVar4;
        this.f27025e = zzijfVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcrx((zzbso) this.f27021a.zzb(), (zzcrt) this.f27022b.zzb(), (Executor) this.f27023c.zzb(), (zzcrs) this.f27024d.zzb(), (Clock) this.f27025e.zzb());
    }
}
