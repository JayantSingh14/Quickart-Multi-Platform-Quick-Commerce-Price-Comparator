package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzihd extends zziar implements zzicd {
    private static final zzihd zzh;
    private static volatile zzick zzi;
    private int zza;
    private int zzb;
    private int zze;
    private String zzc = "";
    private zziaz zzd = zzias.f34649e;
    private zzibd zzf = zzicn.f34726e;
    private zzhzl zzg = zzhzl.f34557b;

    static {
        zzihd zzihdVar = new zzihd();
        zzh = zzihdVar;
        zziar.x(zzihd.class, zzihdVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzh, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", zzihb.class, "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzihd();
        }
        if (iOrdinal == 4) {
            return new zzihc(zzh);
        }
        if (iOrdinal == 5) {
            return zzh;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzi;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzihd.class) {
            try {
                zziamVar = zzi;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzh);
                    zzi = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
