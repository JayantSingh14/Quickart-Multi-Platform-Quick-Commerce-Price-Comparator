package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhqq extends zziar implements zzicd {
    private static final zzhqq zze;
    private static volatile zzick zzf;
    private int zza;
    private int zzb;
    private zzhqu zzc;
    private zzhzl zzd = zzhzl.f34557b;

    static {
        zzhqq zzhqqVar = new zzhqq();
        zze = zzhqqVar;
        zziar.x(zzhqq.class, zzhqqVar);
    }

    public static zzhqq F(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhqq) zziar.q(zze, zzhzlVar, zziabVar);
    }

    public static zzhqp G() {
        return (zzhqp) zze.u();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhqu D() {
        zzhqu zzhquVar = this.zzc;
        return zzhquVar == null ? zzhqu.E() : zzhquVar;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final /* synthetic */ void H(zzhqu zzhquVar) {
        this.zzc = zzhquVar;
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
            return new zzhqq();
        }
        if (iOrdinal == 4) {
            return new zzhqp(zze);
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
        synchronized (zzhqq.class) {
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
