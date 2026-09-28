package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhnu extends zziar implements zzicd {
    private static final zzhnu zzc;
    private static volatile zzick zzd;
    private int zza;
    private zzhzl zzb = zzhzl.f34557b;

    static {
        zzhnu zzhnuVar = new zzhnu();
        zzc = zzhnuVar;
        zziar.x(zzhnu.class, zzhnuVar);
    }

    public static zzhnu E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhnu) zziar.q(zzc, zzhzlVar, zziabVar);
    }

    public static zzhnt F() {
        return (zzhnt) zzc.u();
    }

    public static zzick G() {
        return zzc.s();
    }

    public final int C() {
        return this.zza;
    }

    public final zzhzl D() {
        return this.zzb;
    }

    public final /* synthetic */ void H(zzhzl zzhzlVar) {
        this.zzb = zzhzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzhnu();
        }
        if (iOrdinal == 4) {
            return new zzhnt(zzc);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzd;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhnu.class) {
            try {
                zziamVar = zzd;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzc);
                    zzd = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
