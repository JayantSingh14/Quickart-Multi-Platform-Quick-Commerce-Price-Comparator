package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhmw extends zziar implements zzicd {
    private static final zzhmw zzd;
    private static volatile zzick zze;
    private int zza;
    private int zzb;
    private zzhmy zzc;

    static {
        zzhmw zzhmwVar = new zzhmw();
        zzd = zzhmwVar;
        zziar.x(zzhmw.class, zzhmwVar);
    }

    public static zzhmw E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhmw) zziar.q(zzd, zzhzlVar, zziabVar);
    }

    public static zzhmv F() {
        return (zzhmv) zzd.u();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhmy D() {
        zzhmy zzhmyVar = this.zzc;
        return zzhmyVar == null ? zzhmy.E() : zzhmyVar;
    }

    public final /* synthetic */ void G(int i2) {
        this.zzb = i2;
    }

    public final /* synthetic */ void H(zzhmy zzhmyVar) {
        this.zzc = zzhmyVar;
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
            return new zzico(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhmw();
        }
        if (iOrdinal == 4) {
            return new zzhmv(zzd);
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
        synchronized (zzhmw.class) {
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
