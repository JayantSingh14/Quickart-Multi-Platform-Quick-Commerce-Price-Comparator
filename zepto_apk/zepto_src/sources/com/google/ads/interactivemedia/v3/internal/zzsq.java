package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class zzsq {
    private final zzqf zza;

    public /* synthetic */ zzsq(boolean z, zzqf zzqfVar, zzsp zzspVar) {
        this.zza = zzqfVar;
    }

    public final zzta zza(Callable callable, Executor executor) {
        return new zzsg(this.zza, false, executor, callable);
    }
}
