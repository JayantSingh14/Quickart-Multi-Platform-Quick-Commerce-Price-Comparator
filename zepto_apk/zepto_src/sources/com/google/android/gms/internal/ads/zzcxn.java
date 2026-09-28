package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzcxn implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27355a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27356b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdab f27357c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f27358d;

    public zzcxn(zzijf zzijfVar, zzijf zzijfVar2, zzdab zzdabVar, zzijf zzijfVar3) {
        this.f27355a = zzijfVar;
        this.f27356b = zzijfVar2;
        this.f27357c = zzdabVar;
        this.f27358d = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcxm((Clock) this.f27355a.zzb(), (zzcxo) this.f27356b.zzb(), this.f27357c.a(), (String) this.f27358d.zzb());
    }
}
