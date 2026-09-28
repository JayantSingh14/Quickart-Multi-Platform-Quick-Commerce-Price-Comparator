package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class zzlo {
    private static final AtomicReference zzb = new AtomicReference();
    private static final AtomicReference zzc = new AtomicReference();
    static final AtomicBoolean zza = new AtomicBoolean();

    public static zzlm zza() {
        return (zzlm) zzb.get();
    }

    public static zzln zzb() {
        return (zzln) zzc.get();
    }

    public static void zzc(zzlm zzlmVar) {
        zzb.set(zzlmVar);
    }
}
