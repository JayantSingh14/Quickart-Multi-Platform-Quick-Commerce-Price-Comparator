package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzbsr implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public final ListenableFuture f25533a;

    public zzbsr(ListenableFuture listenableFuture) {
        this.f25533a = listenableFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) {
        return zzgym.h(this.f25533a, new zzbsq(this, obj), zzcdo.f25988g);
    }
}
