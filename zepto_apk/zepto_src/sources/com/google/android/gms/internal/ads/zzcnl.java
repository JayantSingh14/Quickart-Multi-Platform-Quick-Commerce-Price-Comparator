package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
final class zzcnl implements zzdyw {

    /* renamed from: a, reason: collision with root package name */
    public final Context f26699a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbon f26700b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcmv f26701c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcnl f26702d = this;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f26703e;

    public zzcnl(zzcmv zzcmvVar, Context context, zzbon zzbonVar) {
        this.f26701c = zzcmvVar;
        this.f26699a = context;
        this.f26700b = zzbonVar;
        this.f26703e = zzijf.a(new zzdyu(zzijh.a(this), new zzdys(zzijh.a(zzbonVar))));
    }

    @Override // com.google.android.gms.internal.ads.zzdyw
    public final zzdyt zzb() {
        return (zzdyt) this.f26703e.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzdyw
    public final zzdyo zzc() {
        return new zzcni(this.f26701c, this.f26702d);
    }
}
