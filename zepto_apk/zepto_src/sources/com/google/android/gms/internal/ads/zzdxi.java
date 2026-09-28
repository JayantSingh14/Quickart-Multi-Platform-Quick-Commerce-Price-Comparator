package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzdxi implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f28739a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijs f28740b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f28741c;

    public zzdxi(zzijf zzijfVar, zzijs zzijsVar, zzijf zzijfVar2) {
        this.f28739a = zzijfVar;
        this.f28740b = zzijsVar;
        this.f28741c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdxh((zzdwy) this.f28739a.zzb(), this.f28740b.zzb(), (Clock) this.f28741c.zzb());
    }
}
