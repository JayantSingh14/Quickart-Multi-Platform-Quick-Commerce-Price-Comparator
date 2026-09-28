package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhng extends zziar implements zzicd {
    private static final zzhng zzd;
    private static volatile zzick zze;
    private int zza;
    private zzhni zzb;
    private int zzc;

    static {
        zzhng zzhngVar = new zzhng();
        zzd = zzhngVar;
        zziar.x(zzhng.class, zzhngVar);
    }

    public static zzhnf E() {
        return (zzhnf) zzd.u();
    }

    public static zzhng F() {
        return zzd;
    }

    public final zzhni C() {
        zzhni zzhniVar = this.zzb;
        return zzhniVar == null ? zzhni.E() : zzhniVar;
    }

    public final int D() {
        return this.zzc;
    }

    public final /* synthetic */ void G(zzhni zzhniVar) {
        this.zzb = zzhniVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void H(int i2) {
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhng();
        }
        if (iOrdinal == 4) {
            return new zzhnf(zzd);
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
        synchronized (zzhng.class) {
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
