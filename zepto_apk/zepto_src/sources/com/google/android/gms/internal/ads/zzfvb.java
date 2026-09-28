package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfvb extends zziar implements zzicd {
    private static final zzfvb zzf;
    private static volatile zzick zzg;
    private int zza;
    private int zzb;
    private String zzc = "";
    private String zzd = "";
    private zzfuy zze;

    static {
        zzfvb zzfvbVar = new zzfvb();
        zzf = zzfvbVar;
        zziar.x(zzfvb.class, zzfvbVar);
    }

    public static zzfuz C() {
        return (zzfuz) zzf.u();
    }

    public final /* synthetic */ void D(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzc = str;
    }

    public final /* synthetic */ void E(zzfuy zzfuyVar) {
        this.zze = zzfuyVar;
        this.zza |= 8;
    }

    public final /* synthetic */ void F(int i2) {
        this.zzb = 1;
        this.zza = 1 | this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zza", "zzb", zzfva.f31917a, "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzfvb();
        }
        if (iOrdinal == 4) {
            return new zzfuz(zzf);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzg;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzfvb.class) {
            try {
                zziamVar = zzg;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzf);
                    zzg = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
