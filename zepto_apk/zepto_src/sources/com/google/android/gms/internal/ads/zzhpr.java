package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhpr extends zziar implements zzicd {
    private static final zzhpr zzb;
    private static volatile zzick zzc;
    private String zza = "";

    static {
        zzhpr zzhprVar = new zzhpr();
        zzb = zzhprVar;
        zziar.x(zzhpr.class, zzhprVar);
    }

    public static zzhpr D(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhpr) zziar.q(zzb, zzhzlVar, zziabVar);
    }

    public static zzhpq E() {
        return (zzhpq) zzb.u();
    }

    public static zzhpr F() {
        return zzb;
    }

    public final String C() {
        return this.zza;
    }

    public final /* synthetic */ void G(String str) {
        str.getClass();
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhpr();
        }
        if (iOrdinal == 4) {
            return new zzhpq(zzb);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzc;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhpr.class) {
            try {
                zziamVar = zzc;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzb);
                    zzc = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
