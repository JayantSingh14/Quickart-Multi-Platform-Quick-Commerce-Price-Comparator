package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhne extends zziar implements zzicd {
    private static final zzhne zze;
    private static volatile zzick zzf;
    private int zza;
    private int zzb;
    private zzhni zzc;
    private zzhzl zzd = zzhzl.f34557b;

    static {
        zzhne zzhneVar = new zzhne();
        zze = zzhneVar;
        zziar.x(zzhne.class, zzhneVar);
    }

    public static zzhnd F() {
        return (zzhnd) zze.u();
    }

    public static zzhne G() {
        return zze;
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhni D() {
        zzhni zzhniVar = this.zzc;
        return zzhniVar == null ? zzhni.E() : zzhniVar;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final /* synthetic */ void H(zzhni zzhniVar) {
        this.zzc = zzhniVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void I(zzhzl zzhzlVar) {
        this.zzd = zzhzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhne();
        }
        if (iOrdinal == 4) {
            return new zzhnd(zze);
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
        synchronized (zzhne.class) {
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
