package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhqg extends zziar implements zzicd {
    private static final zzhqg zzf;
    private static volatile zzick zzg;
    private int zza;
    private int zzb;
    private zzhqc zzc;
    private zzhzl zzd;
    private zzhzl zze;

    static {
        zzhqg zzhqgVar = new zzhqg();
        zzf = zzhqgVar;
        zziar.x(zzhqg.class, zzhqgVar);
    }

    public zzhqg() {
        zzhzl zzhzlVar = zzhzl.f34557b;
        this.zzd = zzhzlVar;
        this.zze = zzhzlVar;
    }

    public static zzhqg G(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhqg) zziar.q(zzf, zzhzlVar, zziabVar);
    }

    public static zzhqf H() {
        return (zzhqf) zzf.u();
    }

    public static zzhqg I() {
        return zzf;
    }

    public static zzick J() {
        return zzf.s();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhqc D() {
        zzhqc zzhqcVar = this.zzc;
        return zzhqcVar == null ? zzhqc.E() : zzhqcVar;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final zzhzl F() {
        return this.zze;
    }

    public final /* synthetic */ void K(zzhqc zzhqcVar) {
        this.zzc = zzhqcVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void L(zzhzl zzhzlVar) {
        this.zzd = zzhzlVar;
    }

    public final /* synthetic */ void M(zzhzl zzhzlVar) {
        this.zze = zzhzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzf, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzhqg();
        }
        if (iOrdinal == 4) {
            return new zzhqf(zzf);
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
        synchronized (zzhqg.class) {
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
