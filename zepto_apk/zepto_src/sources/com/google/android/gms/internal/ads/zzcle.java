package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzcle implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f26500a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f26501b;

    public zzcle(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f26500a = zzijfVar;
        this.f26501b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcld((ScheduledExecutorService) this.f26501b.zzb());
    }
}
