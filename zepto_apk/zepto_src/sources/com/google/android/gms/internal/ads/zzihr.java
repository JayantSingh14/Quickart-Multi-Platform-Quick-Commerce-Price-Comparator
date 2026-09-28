package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzihr extends zziar implements zzicd {
    private static final zzihr zzn;
    private static volatile zzick zzo;
    private int zza;
    private int zzd;
    private boolean zzf;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private zzihw zzk;
    private zzihq zzm;
    private String zzb = "";
    private String zzc = "";
    private int zze = 1;
    private String zzg = "";
    private String zzl = "";

    static {
        zzihr zzihrVar = new zzihr();
        zzn = zzihrVar;
        zziar.x(zzihr.class, zzihrVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzn, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005ဇ\u0004\u0006ဈ\u0005\u0007ဇ\u0006\bင\u0007\t᠌\b\nဉ\t\u000bဈ\n\fဉ\u000b", new Object[]{"zza", "zzb", "zzc", "zzd", zziia.f34840a, "zze", zzihz.f34837a, "zzf", "zzg", "zzh", "zzi", "zzj", zzihs.f34836a, "zzk", "zzl", "zzm"});
        }
        if (iOrdinal == 3) {
            return new zzihr();
        }
        if (iOrdinal == 4) {
            return new zziho(zzn);
        }
        if (iOrdinal == 5) {
            return zzn;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzo;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzihr.class) {
            try {
                zziamVar = zzo;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzn);
                    zzo = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
