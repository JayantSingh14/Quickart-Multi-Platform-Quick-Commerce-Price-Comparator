package com.google.ads.interactivemedia.v3.internal;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public final class zztj {

    @CheckForNull
    private String zza = null;

    public final zztj zza(String str) {
        Locale locale = Locale.ROOT;
        this.zza = "imasdk-%d";
        return this;
    }

    public final ThreadFactory zzb() {
        String str = this.zza;
        return new zzti(Executors.defaultThreadFactory(), str, str != null ? new AtomicLong(0L) : null, null, null, null);
    }
}
