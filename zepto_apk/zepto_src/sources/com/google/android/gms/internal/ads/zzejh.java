package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzejh implements zzejg {

    /* renamed from: a, reason: collision with root package name */
    public final zzejg f29460a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgpr f29461b;

    public zzejh(zzejg zzejgVar, zzgpr zzgprVar) {
        this.f29460a = zzejgVar;
        this.f29461b = zzgprVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final ListenableFuture a(zzfic zzficVar, zzfhr zzfhrVar) {
        return zzgym.i(this.f29460a.a(zzficVar, zzfhrVar), this.f29461b, zzcdo.f25982a);
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final boolean b(zzfic zzficVar, zzfhr zzfhrVar) {
        return this.f29460a.b(zzficVar, zzfhrVar);
    }
}
