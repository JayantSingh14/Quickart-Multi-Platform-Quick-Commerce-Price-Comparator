package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class zzse extends zzsf {
    final /* synthetic */ zzsg zza;
    private final Callable zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzse(zzsg zzsgVar, Callable callable, Executor executor) {
        super(zzsgVar, executor);
        this.zza = zzsgVar;
        this.zzc = callable;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsy
    public final Object zza() throws Exception {
        return this.zzc.call();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsy
    public final String zzb() {
        return this.zzc.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsf
    public final void zzc(Object obj) {
        this.zza.zzc(obj);
    }
}
