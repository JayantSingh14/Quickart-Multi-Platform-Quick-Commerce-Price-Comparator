package com.google.android.gms.internal.ads;

import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public final class zzgav extends zziar implements zzicd {
    private static final zzgav zzf;
    private static volatile zzick zzg;
    private int zza;
    private float zzc;
    private String zzb = "https://pagead2.googlesyndication.com/pagead/ping?e=2&f=1";
    private long zzd = 1000;
    private long zze = DateUtils.MILLIS_PER_MINUTE;

    static {
        zzgav zzgavVar = new zzgav();
        zzf = zzgavVar;
        zziar.x(zzgav.class, zzgavVar);
    }

    public static zzgau G() {
        return (zzgau) zzf.u();
    }

    public static zzgav H() {
        return zzf;
    }

    public final String C() {
        return this.zzb;
    }

    public final float D() {
        return this.zzc;
    }

    public final long E() {
        return this.zzd;
    }

    public final long F() {
        return this.zze;
    }

    public final /* synthetic */ void I(float f2) {
        this.zza |= 2;
        this.zzc = f2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzf, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ခ\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgav();
        }
        if (iOrdinal == 4) {
            return new zzgau(zzf);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzg;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzgav.class) {
            try {
                zziamVar = zzg;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzf);
                    zzg = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
