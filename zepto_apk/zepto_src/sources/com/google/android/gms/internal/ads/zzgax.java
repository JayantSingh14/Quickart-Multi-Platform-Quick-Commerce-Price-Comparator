package com.google.android.gms.internal.ads;

import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public final class zzgax extends zziar implements zzicd {
    private static final zzgax zzl;
    private static volatile zzick zzm;
    private int zza;
    private boolean zzc;
    private boolean zzd;
    private long zzh;
    private boolean zzi;
    private boolean zzb = true;
    private long zze = 600000;
    private long zzf = DateUtils.MILLIS_PER_HOUR;
    private String zzg = "https://pagead2.googlesyndication.com/mads/asp";
    private long zzj = 5;
    private long zzk = DateUtils.MILLIS_PER_MINUTE;

    static {
        zzgax zzgaxVar = new zzgax();
        zzl = zzgaxVar;
        zziar.x(zzgax.class, zzgaxVar);
    }

    public static zzgaw J() {
        return (zzgaw) zzl.u();
    }

    public static zzgax K() {
        return zzl;
    }

    public final boolean C() {
        return this.zzd;
    }

    public final long D() {
        return this.zzf;
    }

    public final String E() {
        return this.zzg;
    }

    public final long F() {
        return this.zzh;
    }

    public final boolean G() {
        return this.zzi;
    }

    public final long H() {
        return this.zzj;
    }

    public final long I() {
        return this.zzk;
    }

    public final /* synthetic */ void L(boolean z) {
        this.zza |= 4;
        this.zzd = z;
    }

    public final /* synthetic */ void M(long j2) {
        this.zza |= 64;
        this.zzh = j2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzl, "\u0004\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဈ\u0005\u0007ဂ\u0006\bဇ\u0007\tဂ\b\nဂ\t", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zzgax();
        }
        if (iOrdinal == 4) {
            return new zzgaw(zzl);
        }
        if (iOrdinal == 5) {
            return zzl;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzm;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzgax.class) {
            try {
                zziamVar = zzm;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzl);
                    zzm = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
