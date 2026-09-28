package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.internal.zzrq;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
class zzsd extends zzrq.zzi {
    private static final zzrz zza;
    private static final zzsz zzd = new zzsz(zzsd.class);
    private volatile int remaining;

    @CheckForNull
    private volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable th;
        zzrz zzscVar;
        zzsb zzsbVar = null;
        try {
            zzscVar = new zzsa(AtomicReferenceFieldUpdater.newUpdater(zzsd.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzsd.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzscVar = new zzsc(zzsbVar);
        }
        zza = zzscVar;
        if (th != null) {
            zzd.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    public zzsd(int i2) {
        this.remaining = i2;
    }

    public final int zzt() {
        return zza.zza(this);
    }

    public final void zzv() {
        this.seenExceptions = null;
    }
}
