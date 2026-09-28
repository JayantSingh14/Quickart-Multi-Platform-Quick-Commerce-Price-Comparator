package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzihu extends zziar implements zzicd {
    private static final zzihu zzd;
    private static volatile zzick zze;
    private int zza;
    private String zzb = "";
    private int zzc;

    static {
        zzihu zzihuVar = new zzihu();
        zzd = zzihuVar;
        zziar.x(zzihu.class, zzihuVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001", new Object[]{"zza", "zzb", "zzc", zziih.f34841a});
        }
        if (iOrdinal == 3) {
            return new zzihu();
        }
        if (iOrdinal == 4) {
            return new zziht(zzd);
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
        synchronized (zzihu.class) {
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
