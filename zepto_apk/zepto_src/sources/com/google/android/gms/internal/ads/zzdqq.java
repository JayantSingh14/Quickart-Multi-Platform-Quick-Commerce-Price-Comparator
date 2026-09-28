package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
final /* synthetic */ class zzdqq implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f28272a;

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) {
        return obj != null ? this.f28272a : zzgym.b(new zzemv(1, "Retrieve required value in native ad response failed."));
    }
}
