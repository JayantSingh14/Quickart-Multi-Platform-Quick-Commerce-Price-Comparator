package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhnq extends zziar implements zzicd {
    private static final zzhnq zzc;
    private static volatile zzick zzd;
    private int zza;
    private zzhzl zzb = zzhzl.f34557b;

    static {
        zzhnq zzhnqVar = new zzhnq();
        zzc = zzhnqVar;
        zziar.x(zzhnq.class, zzhnqVar);
    }

    public static zzhnq E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhnq) zziar.q(zzc, zzhzlVar, zziabVar);
    }

    public static zzhnp F() {
        return (zzhnp) zzc.u();
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
            return new zzhnq();
        }
        if (iOrdinal == 4) {
            return new zzhnp(zzc);
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
        synchronized (zzhnq.class) {
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
