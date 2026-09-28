package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
final class zztu extends zzuu {
    final /* synthetic */ zzuu zza;

    public zztu(zzuu zzuuVar) {
        this.zza = zzuuVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        return new AtomicLong(((Number) this.zza.read(zzaaqVar)).longValue());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        this.zza.write(zzaasVar, Long.valueOf(((AtomicLong) obj).get()));
    }
}
