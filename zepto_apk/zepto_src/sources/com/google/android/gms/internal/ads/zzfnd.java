package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfnd extends zziar implements zzicd {
    private static final zzfnd zzc;
    private static volatile zzick zzd;
    private int zza;
    private long zzb;

    static {
        zzfnd zzfndVar = new zzfnd();
        zzc = zzfndVar;
        zziar.x(zzfnd.class, zzfndVar);
    }

    public static zzfnc C() {
        return (zzfnc) zzc.u();
    }

    public final /* synthetic */ void D(long j2) {
        this.zzb = j2;
    }

    public final /* synthetic */ void E(int i2) {
        this.zza = i2 - 2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u0002", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzfnd();
        }
        if (iOrdinal == 4) {
            return new zzfnc(zzc);
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
        synchronized (zzfnd.class) {
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
