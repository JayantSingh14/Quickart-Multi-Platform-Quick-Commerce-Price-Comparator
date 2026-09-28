package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhxg extends zziar implements zzicd {
    private static final zzhxg zzf;
    private static volatile zzick zzg;
    private int zza;
    private zzhzl zzb = zzhzl.f34557b;
    private String zzc = "";
    private zzibd zzd = zzicn.f34726e;
    private boolean zze;

    static {
        zzhxg zzhxgVar = new zzhxg();
        zzf = zzhxgVar;
        zziar.x(zzhxg.class, zzhxgVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ည\u0000\u0002\u001c\u0003ဇ\u0002\u0004ဈ\u0001", new Object[]{"zza", "zzb", "zzd", "zze", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhxg();
        }
        if (iOrdinal == 4) {
            return new zzhxf(zzf);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzg;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhxg.class) {
            try {
                zziamVar = zzg;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzf);
                    zzg = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
