package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhns extends zziar implements zzicd {
    private static final zzhns zzc;
    private static volatile zzick zzd;
    private int zza;
    private int zzb;

    static {
        zzhns zzhnsVar = new zzhns();
        zzc = zzhnsVar;
        zziar.x(zzhns.class, zzhnsVar);
    }

    public static zzhns E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhns) zziar.q(zzc, zzhzlVar, zziabVar);
    }

    public static zzhnr F() {
        return (zzhnr) zzc.u();
    }

    public final int C() {
        return this.zza;
    }

    public final int D() {
        return this.zzb;
    }

    public final /* synthetic */ void G(int i2) {
        this.zza = i2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzhns();
        }
        if (iOrdinal == 4) {
            return new zzhnr(zzc);
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
        synchronized (zzhns.class) {
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
