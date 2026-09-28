package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcba implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f25807a;

    public zzcba(zzcbf zzcbfVar, ListenableFuture listenableFuture) {
        this.f25807a = listenableFuture;
        Objects.requireNonNull(zzcbfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzcbf.f25813l.remove(this.f25807a);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* synthetic */ void zzb(Object obj) {
        zzcbf.f25813l.remove(this.f25807a);
    }
}
