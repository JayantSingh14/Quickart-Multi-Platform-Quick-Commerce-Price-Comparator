package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhpa extends zziar implements zzicd {
    private static final zzhpa zzd;
    private static volatile zzick zze;
    private String zza = "";
    private zzhzl zzb = zzhzl.f34557b;
    private int zzc;

    static {
        zzhpa zzhpaVar = new zzhpa();
        zzd = zzhpaVar;
        zziar.x(zzhpa.class, zzhpaVar);
    }

    public static zzhoy F() {
        return (zzhoy) zzd.u();
    }

    public static zzhpa G() {
        return zzd;
    }

    public final String C() {
        return this.zza;
    }

    public final zzhzl D() {
        return this.zzb;
    }

    public final zzhoz E() {
        int i2 = this.zzc;
        zzhoz zzhozVar = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : zzhoz.REMOTE : zzhoz.ASYMMETRIC_PUBLIC : zzhoz.ASYMMETRIC_PRIVATE : zzhoz.SYMMETRIC : zzhoz.UNKNOWN_KEYMATERIAL;
        return zzhozVar == null ? zzhoz.UNRECOGNIZED : zzhozVar;
    }

    public final /* synthetic */ void H(String str) {
        str.getClass();
        this.zza = str;
    }

    public final /* synthetic */ void I(zzhzl zzhzlVar) {
        zzhzlVar.getClass();
        this.zzb = zzhzlVar;
    }

    public final /* synthetic */ void J(zzhoz zzhozVar) {
        this.zzc = zzhozVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhpa();
        }
        if (iOrdinal == 4) {
            return new zzhoy(zzd);
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
        synchronized (zzhpa.class) {
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
