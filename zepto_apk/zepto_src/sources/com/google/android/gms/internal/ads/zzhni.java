package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhni extends zziar implements zzicd {
    private static final zzhni zzb;
    private static volatile zzick zzc;
    private int zza;

    static {
        zzhni zzhniVar = new zzhni();
        zzb = zzhniVar;
        zziar.x(zzhni.class, zzhniVar);
    }

    public static zzhnh D() {
        return (zzhnh) zzb.u();
    }

    public static zzhni E() {
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
            return new zzhni();
        }
        if (iOrdinal == 4) {
            return new zzhnh(zzb);
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
        synchronized (zzhni.class) {
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
