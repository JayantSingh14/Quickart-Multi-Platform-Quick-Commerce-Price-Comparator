package com.google.ads.interactivemedia.v3.internal;

import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes3.dex */
public final class zzgy {

    @VisibleForTesting
    protected volatile Boolean zzb;
    private final zzih zze;
    private static final ConditionVariable zzc = new ConditionVariable();

    @VisibleForTesting
    protected static volatile zzoe zza = null;
    private static volatile Random zzd = null;

    public zzgy(zzih zzihVar) {
        this.zze = zzihVar;
        zzihVar.zzk().execute(new zzgx(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            return zze().nextInt();
        }
    }

    private static Random zze() {
        if (zzd == null) {
            synchronized (zzgy.class) {
                try {
                    if (zzd == null) {
                        zzd = new Random();
                    }
                } finally {
                }
            }
        }
        return zzd;
    }

    public final void zzc(int i2, int i3, long j2, String str, Exception exc) {
        try {
            zzc.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzr zzrVarZza = zzv.zza();
            zzrVarZza.zza(this.zze.zza.getPackageName());
            zzrVarZza.zze(j2);
            if (str != null) {
                zzrVarZza.zzb(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zzrVarZza.zzf(stringWriter.toString());
                zzrVarZza.zzd(exc.getClass().getName());
            }
            zzod zzodVarZza = zza.zza(((zzv) zzrVarZza.zzan()).zzav());
            zzodVarZza.zza(i2);
            if (i3 != -1) {
                zzodVarZza.zzb(i3);
            }
            zzodVarZza.zzc();
        } catch (Exception unused) {
        }
    }
}
