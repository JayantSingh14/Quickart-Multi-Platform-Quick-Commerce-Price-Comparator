package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzesf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30212a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30213b;

    public zzesf(zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30212a = zzijfVar;
        this.f30213b = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        ListenableFuture listenableFuture = (ListenableFuture) this.f30212a.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzesd(listenableFuture, zzgywVar, (ScheduledExecutorService) this.f30213b.zzb());
    }
}
