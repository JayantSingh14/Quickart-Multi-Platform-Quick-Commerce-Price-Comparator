package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zziex extends zziar implements zzicd {
    private static final zziex zzc;
    private static volatile zzick zzd;
    private int zza;
    private String zzb = "";

    static {
        zziex zziexVar = new zziex();
        zzc = zziexVar;
        zziar.x(zziex.class, zziexVar);
    }

    public static zziew C() {
        return (zziew) zzc.u();
    }

    public final /* synthetic */ void D(String str) {
        this.zza |= 1;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zziex();
        }
        if (iOrdinal == 4) {
            return new zziew(zzc);
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
        synchronized (zziex.class) {
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
