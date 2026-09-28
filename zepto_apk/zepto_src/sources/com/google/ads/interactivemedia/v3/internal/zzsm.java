package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public abstract class zzsm extends zzsk implements zzta {
    @Override // com.google.ads.interactivemedia.v3.internal.zzsk
    public /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    public abstract zzta zzc();

    @Override // com.google.ads.interactivemedia.v3.internal.zzta
    public final void zzm(Runnable runnable, Executor executor) {
        zzc().zzm(runnable, executor);
    }
}
