package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhoi extends zziar implements zzicd {
    private static final zzhoi zzf;
    private static volatile zzick zzg;
    private int zza;
    private int zzb;
    private zzhoe zzc;
    private zzhzl zzd;
    private zzhzl zze;

    static {
        zzhoi zzhoiVar = new zzhoi();
        zzf = zzhoiVar;
        zziar.x(zzhoi.class, zzhoiVar);
    }

    public zzhoi() {
        zzhzl zzhzlVar = zzhzl.f34557b;
        this.zzd = zzhzlVar;
        this.zze = zzhzlVar;
    }

    public static zzhoi G(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhoi) zziar.q(zzf, zzhzlVar, zziabVar);
    }

    public static zzhoh H() {
        return (zzhoh) zzf.u();
    }

    public static zzhoi I() {
        return zzf;
    }

    public static zzick J() {
        return zzf.s();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhoe D() {
        zzhoe zzhoeVar = this.zzc;
        return zzhoeVar == null ? zzhoe.E() : zzhoeVar;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final zzhzl F() {
        return this.zze;
    }

    public final /* synthetic */ void K(zzhoe zzhoeVar) {
        this.zzc = zzhoeVar;
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
            return new zzhoi();
        }
        if (iOrdinal == 4) {
            return new zzhoh(zzf);
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
        synchronized (zzhoi.class) {
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
