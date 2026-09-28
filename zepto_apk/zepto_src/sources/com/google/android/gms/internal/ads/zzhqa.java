package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhqa extends zziar implements zzicd {
    private static final zzhqa zze;
    private static volatile zzick zzf;
    private int zza;
    private zzhqc zzb;
    private int zzc;
    private zzhzl zzd = zzhzl.f34557b;

    static {
        zzhqa zzhqaVar = new zzhqa();
        zze = zzhqaVar;
        zziar.x(zzhqa.class, zzhqaVar);
    }

    public static zzhqa F(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhqa) zziar.q(zze, zzhzlVar, zziabVar);
    }

    public static zzhpz G() {
        return (zzhpz) zze.u();
    }

    public final zzhqc C() {
        zzhqc zzhqcVar = this.zzb;
        return zzhqcVar == null ? zzhqc.E() : zzhqcVar;
    }

    public final int D() {
        return this.zzc;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final /* synthetic */ void H(zzhqc zzhqcVar) {
        this.zzb = zzhqcVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void I(int i2) {
        this.zzc = i2;
    }

    public final /* synthetic */ void J(zzhzl zzhzlVar) {
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
            return new zzico(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\n", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhqa();
        }
        if (iOrdinal == 4) {
            return new zzhpz(zze);
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
        synchronized (zzhqa.class) {
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
