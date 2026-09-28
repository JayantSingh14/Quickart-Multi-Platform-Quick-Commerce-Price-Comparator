package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Method;

/* loaded from: classes3.dex */
final class zzws extends zzww {
    final /* synthetic */ Method zza;
    final /* synthetic */ Object zzb;

    public zzws(Method method, Object obj) {
        this.zza = method;
        this.zzb = obj;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzww
    public final Object zza(Class cls) throws Exception {
        zzww.zzb(cls);
        return this.zza.invoke(this.zzb, cls);
    }
}
