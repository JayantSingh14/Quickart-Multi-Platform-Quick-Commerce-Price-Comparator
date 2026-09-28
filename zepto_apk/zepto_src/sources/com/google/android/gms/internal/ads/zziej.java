package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zziej extends zziar implements zzicd {
    private static final zziej zzd;
    private static volatile zzick zze;
    private int zza;
    private long zzb;
    private long zzc;

    static {
        zziej zziejVar = new zziej();
        zzd = zziejVar;
        zziar.x(zziej.class, zziejVar);
    }

    public static zziei C() {
        return (zziei) zzd.u();
    }

    public final /* synthetic */ void D(int i2) {
        this.zza = i2;
    }

    public final /* synthetic */ void E(long j2) {
        this.zzb = j2;
    }

    public final /* synthetic */ void F(long j2) {
        this.zzc = j2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zziej();
        }
        if (iOrdinal == 4) {
            return new zziei(zzd);
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
        synchronized (zziej.class) {
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
