package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhop extends zziar implements zzicd {
    private static final zzhop zzc;
    private static volatile zzick zzd;
    private int zza;
    private zzhzl zzb = zzhzl.f34557b;

    static {
        zzhop zzhopVar = new zzhop();
        zzc = zzhopVar;
        zziar.x(zzhop.class, zzhopVar);
    }

    public static zzhop E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhop) zziar.q(zzc, zzhzlVar, zziabVar);
    }

    public static zzhoo F() {
        return (zzhoo) zzc.u();
    }

    public static zzhop G() {
        return zzc;
    }

    public static zzick H() {
        return zzc.s();
    }

    public final int C() {
        return this.zza;
    }

    public final zzhzl D() {
        return this.zzb;
    }

    public final /* synthetic */ void I(zzhzl zzhzlVar) {
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
            return new zzico(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzhop();
        }
        if (iOrdinal == 4) {
            return new zzhoo(zzc);
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
        synchronized (zzhop.class) {
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
