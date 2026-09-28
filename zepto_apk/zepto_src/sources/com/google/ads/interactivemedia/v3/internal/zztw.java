package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class zztw<T> extends zzyc<T> {
    private zzuu zza = null;

    private final zzuu zzc() {
        zzuu zzuuVar = this.zza;
        if (zzuuVar != null) {
            return zzuuVar;
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final T read(zzaaq zzaaqVar) throws IOException {
        return (T) zzc().read(zzaaqVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final void write(zzaas zzaasVar, T t) throws IOException {
        zzc().write(zzaasVar, t);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzyc
    public final zzuu zza() {
        return zzc();
    }

    public final void zzb(zzuu zzuuVar) {
        if (this.zza != null) {
            throw new AssertionError("Delegate is already set");
        }
        this.zza = zzuuVar;
    }
}
