package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbbu extends zziar implements zzicd {
    private static final zzbbu zzd;
    private static volatile zzick zze;
    private int zza;
    private zzbbw zzb;
    private zzhzl zzc = zzhzl.f34557b;

    static {
        zzbbu zzbbuVar = new zzbbu();
        zzd = zzbbuVar;
        zziar.x(zzbbu.class, zzbbuVar);
    }

    public static zzbbu G() {
        return zzd;
    }

    public final boolean C() {
        return (this.zza & 1) != 0;
    }

    public final zzbbw D() {
        zzbbw zzbbwVar = this.zzb;
        return zzbbwVar == null ? zzbbw.F() : zzbbwVar;
    }

    public final boolean E() {
        return (this.zza & 2) != 0;
    }

    public final zzhzl F() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzbbu();
        }
        if (iOrdinal == 4) {
            return new zzbbt(zzd);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zze;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzbbu.class) {
            try {
                zziamVar = zze;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzd);
                    zze = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
