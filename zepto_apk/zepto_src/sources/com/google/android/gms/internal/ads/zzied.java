package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzied extends zziar implements zzicd {
    private static final zzied zzd;
    private static volatile zzick zze;
    private int zza;
    private String zzb = "";
    private zziaz zzc = zzias.f34649e;

    static {
        zzied zziedVar = new zzied();
        zzd = zziedVar;
        zziar.x(zzied.class, zziedVar);
    }

    public static zziec C() {
        return (zziec) zzd.u();
    }

    public final /* synthetic */ void D(int i2) {
        this.zza = 15;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0004\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002Ȉ\u0003'", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzied();
        }
        if (iOrdinal == 4) {
            return new zziec(zzd);
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
        synchronized (zzied.class) {
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
