package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes3.dex */
final class zzyh<T> extends zzuu<T> {
    private final zztx zza;
    private final zzuu zzb;
    private final Type zzc;

    public zzyh(zztx zztxVar, zzuu zzuuVar, Type type) {
        this.zza = zztxVar;
        this.zzb = zzuuVar;
        this.zzc = type;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final T read(zzaaq zzaaqVar) throws IOException {
        return (T) this.zzb.read(zzaaqVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.reflect.Type] */
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final void write(zzaas zzaasVar, T t) throws IOException {
        zzuu zzuuVarZza;
        ?? r0 = this.zzc;
        Class<?> cls = (t == null || !((r0 instanceof Class) || (r0 instanceof TypeVariable))) ? r0 : t.getClass();
        zzuu zzuuVarZza2 = this.zzb;
        if (cls != r0) {
            zzuuVarZza2 = this.zza.zza(zzaao.zzb(cls));
            if (zzuuVarZza2 instanceof zzxw) {
                zzuu zzuuVar = this.zzb;
                while ((zzuuVar instanceof zzyc) && (zzuuVarZza = ((zzyc) zzuuVar).zza()) != zzuuVar) {
                    zzuuVar = zzuuVarZza;
                }
                if (!(zzuuVar instanceof zzxw)) {
                    zzuuVarZza2 = this.zzb;
                }
            }
        }
        zzuuVarZza2.write(zzaasVar, t);
    }
}
