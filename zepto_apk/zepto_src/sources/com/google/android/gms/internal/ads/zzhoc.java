package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhoc extends zziar implements zzicd {
    private static final zzhoc zzd;
    private static volatile zzick zze;
    private int zza;
    private zzhoe zzb;
    private int zzc;

    static {
        zzhoc zzhocVar = new zzhoc();
        zzd = zzhocVar;
        zziar.x(zzhoc.class, zzhocVar);
    }

    public static zzhoc D(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhoc) zziar.q(zzd, zzhzlVar, zziabVar);
    }

    public static zzhob E() {
        return (zzhob) zzd.u();
    }

    public final zzhoe C() {
        zzhoe zzhoeVar = this.zzb;
        return zzhoeVar == null ? zzhoe.E() : zzhoeVar;
    }

    public final /* synthetic */ void F(zzhoe zzhoeVar) {
        this.zzb = zzhoeVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002ဉ\u0000\u0003\u000b", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhoc();
        }
        if (iOrdinal == 4) {
            return new zzhob(zzd);
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
        synchronized (zzhoc.class) {
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
