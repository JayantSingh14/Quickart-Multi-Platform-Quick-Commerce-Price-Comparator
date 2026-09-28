package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhno extends zziar implements zzicd {
    private static final zzhno zzb;
    private static volatile zzick zzc;
    private int zza;

    static {
        zzhno zzhnoVar = new zzhno();
        zzb = zzhnoVar;
        zziar.x(zzhno.class, zzhnoVar);
    }

    public static zzhnn D() {
        return (zzhnn) zzb.u();
    }

    public static zzhno E() {
        return zzb;
    }

    public final int C() {
        return this.zza;
    }

    public final /* synthetic */ void F(int i2) {
        this.zza = i2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhno();
        }
        if (iOrdinal == 4) {
            return new zzhnn(zzb);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzc;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhno.class) {
            try {
                zziamVar = zzc;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzb);
                    zzc = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
