package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhot extends zziar implements zzicd {
    private static final zzhot zze;
    private static volatile zzick zzf;
    private int zza;
    private int zzb;
    private zzhox zzc;
    private zzhzl zzd = zzhzl.f34557b;

    static {
        zzhot zzhotVar = new zzhot();
        zze = zzhotVar;
        zziar.x(zzhot.class, zzhotVar);
    }

    public static zzhot F(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhot) zziar.q(zze, zzhzlVar, zziabVar);
    }

    public static zzhos G() {
        return (zzhos) zze.u();
    }

    public static zzhot H() {
        return zze;
    }

    public static zzick I() {
        return zze.s();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhox D() {
        zzhox zzhoxVar = this.zzc;
        return zzhoxVar == null ? zzhox.F() : zzhoxVar;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final /* synthetic */ void J(zzhox zzhoxVar) {
        this.zzc = zzhoxVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void K(zzhzl zzhzlVar) {
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
            return new zzhot();
        }
        if (iOrdinal == 4) {
            return new zzhos(zze);
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
        synchronized (zzhot.class) {
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
