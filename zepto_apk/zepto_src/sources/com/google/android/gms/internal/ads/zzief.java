package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzief extends zziar implements zzicd {
    private static final zzief zzc;
    private static volatile zzick zzd;
    private zziaz zza;
    private zziaz zzb;

    static {
        zzief zziefVar = new zzief();
        zzc = zziefVar;
        zziar.x(zzief.class, zziefVar);
    }

    public zzief() {
        zzias zziasVar = zzias.f34649e;
        this.zza = zziasVar;
        this.zzb = zziasVar;
    }

    public static zzief C(byte[] bArr, zziab zziabVar) {
        return (zzief) zziar.r(zzc, bArr, zziabVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0004\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0002\u0000\u0001\u0016\u0003\u0016", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzief();
        }
        if (iOrdinal == 4) {
            return new zziee(zzc);
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
        synchronized (zzief.class) {
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
