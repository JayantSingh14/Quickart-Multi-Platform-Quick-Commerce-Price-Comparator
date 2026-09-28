package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzavr extends zziar implements zzicd {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f24419a = 0;
    private static final zzavr zzg;
    private static volatile zzick zzh;
    private int zza;
    private boolean zzc;
    private boolean zzd;
    private long zzb = 100;
    private long zze = 300;
    private long zzf = 1000;

    static {
        zzavr zzavrVar = new zzavr();
        zzg = zzavrVar;
        zziar.x(zzavr.class, zzavrVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzg, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005ဂ\u0004", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzavr();
        }
        if (iOrdinal == 4) {
            return new zzavq(zzg);
        }
        if (iOrdinal == 5) {
            return zzg;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzh;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzavr.class) {
            try {
                zziamVar = zzh;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzg);
                    zzh = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
