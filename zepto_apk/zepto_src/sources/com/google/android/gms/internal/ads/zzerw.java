package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzerw implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30192a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdab f30193b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30194c;

    public zzerw(zzdab zzdabVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30192a = zzijfVar;
        this.f30193b = zzdabVar;
        this.f30194c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeru((Clock) this.f30192a.zzb(), this.f30193b.a(), ((Long) this.f30194c.zzb()).longValue());
    }
}
