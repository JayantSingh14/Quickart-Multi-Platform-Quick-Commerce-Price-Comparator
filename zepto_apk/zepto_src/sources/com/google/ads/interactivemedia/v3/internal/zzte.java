package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import com.google.ads.interactivemedia.v3.internal.zzrq;

/* loaded from: classes3.dex */
final class zzte extends zzrq.zzi implements Runnable {
    private final Runnable zza;

    public zzte(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzd(th);
            throw th;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrq
    public final String zza() {
        return b.D("task=[", this.zza.toString(), "]");
    }
}
