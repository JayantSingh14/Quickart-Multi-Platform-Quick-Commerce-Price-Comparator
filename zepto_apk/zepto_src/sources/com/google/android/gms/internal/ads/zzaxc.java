package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaxc extends zziar implements zzicd {
    private static final zzaxc zze;
    private static volatile zzick zzf;
    private int zza;
    private long zzb;
    private String zzc = "";
    private zzhzl zzd = zzhzl.f34557b;

    static {
        zzaxc zzaxcVar = new zzaxc();
        zze = zzaxcVar;
        zziar.x(zzaxc.class, zzaxcVar);
    }

    public static zzaxc G() {
        return zze;
    }

    public final boolean C() {
        return (this.zza & 1) != 0;
    }

    public final long D() {
        return this.zzb;
    }

    public final String E() {
        return this.zzc;
    }

    public final zzhzl F() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zze, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzaxc();
        }
        if (iOrdinal == 4) {
            return new zzaxb(zze);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzf;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzaxc.class) {
            try {
                zziamVar = zzf;
                if (zziamVar == null) {
                    zziamVar = new zziam(zze);
                    zzf = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
