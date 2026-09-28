package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Method;

/* loaded from: classes3.dex */
final class zzwt extends zzww {
    final /* synthetic */ Method zza;
    final /* synthetic */ int zzb;

    public zzwt(Method method, int i2) {
        this.zza = method;
        this.zzb = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzww
    public final Object zza(Class cls) throws Exception {
        zzww.zzb(cls);
        return this.zza.invoke(null, cls, Integer.valueOf(this.zzb));
    }
}
