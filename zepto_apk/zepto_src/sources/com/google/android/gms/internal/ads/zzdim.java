package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzdim implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27790a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijs f27791b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcwb f27792c;

    public zzdim(zzijf zzijfVar, zzijs zzijsVar, zzcwb zzcwbVar) {
        this.f27790a = zzijfVar;
        this.f27791b = zzijsVar;
        this.f27792c = zzcwbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdil((Context) this.f27790a.zzb(), this.f27791b.zzb(), this.f27792c.a());
    }
}
