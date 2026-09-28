package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhqs extends zziar implements zzicd {
    private static final zzhqs zzd;
    private static volatile zzick zze;
    private int zza;
    private int zzb;
    private zzhqu zzc;

    static {
        zzhqs zzhqsVar = new zzhqs();
        zzd = zzhqsVar;
        zziar.x(zzhqs.class, zzhqsVar);
    }

    public static zzhqs E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhqs) zziar.q(zzd, zzhzlVar, zziabVar);
    }

    public static zzhqr F() {
        return (zzhqr) zzd.u();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhqu D() {
        zzhqu zzhquVar = this.zzc;
        return zzhquVar == null ? zzhqu.E() : zzhquVar;
    }

    public final /* synthetic */ void G(zzhqu zzhquVar) {
        this.zzc = zzhquVar;
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
            return new zzico(zzd, "\u0000\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhqs();
        }
        if (iOrdinal == 4) {
            return new zzhqr(zzd);
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
        synchronized (zzhqs.class) {
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
