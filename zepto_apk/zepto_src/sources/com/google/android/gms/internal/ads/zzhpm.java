package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhpm extends zziar implements zzicd {
    private static final zzhpm zze;
    private static volatile zzick zzf;
    private String zza = "";
    private int zzb;
    private int zzc;
    private int zzd;

    static {
        zzhpm zzhpmVar = new zzhpm();
        zze = zzhpmVar;
        zziar.x(zzhpm.class, zzhpmVar);
    }

    public static zzhpl C() {
        return (zzhpl) zze.u();
    }

    public final /* synthetic */ void D(String str) {
        str.getClass();
        this.zza = str;
    }

    public final /* synthetic */ void E(int i2) {
        this.zzc = i2;
    }

    public final /* synthetic */ void F(zzhpw zzhpwVar) {
        this.zzd = zzhpwVar.zza();
    }

    public final void G(int i2) {
        if (i2 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        this.zzb = i2 - 2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zze, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhpm();
        }
        if (iOrdinal == 4) {
            return new zzhpl(zze);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzf;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhpm.class) {
            try {
                zziamVar = zzf;
                if (zziamVar == null) {
                    zziamVar = new zziam(zze);
                    zzf = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
