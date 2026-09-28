package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzawr extends zziar implements zzicd {
    private static final zzawr zzl;
    private static volatile zzick zzm;
    private int zza;
    private long zzb;
    private int zzc;
    private boolean zzd;
    private long zzf;
    private boolean zzg;
    private long zzi;
    private long zzj;
    private long zzk;
    private zziaz zze = zzias.f34649e;
    private zzibd zzh = zzicn.f34726e;

    static {
        zzawr zzawrVar = new zzawr();
        zzl = zzawrVar;
        zziar.x(zzawr.class, zzawrVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzl, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0002\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003\u0006ဇ\u0004\u0007\u001b\bဂ\u0005\tဂ\u0006\nဂ\u0007", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzawv.class, "zzi", "zzj", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zzawr();
        }
        if (iOrdinal == 4) {
            return new zzawq(zzl);
        }
        if (iOrdinal == 5) {
            return zzl;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzm;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzawr.class) {
            try {
                zziamVar = zzm;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzl);
                    zzm = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
