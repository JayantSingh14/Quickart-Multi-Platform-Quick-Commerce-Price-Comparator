package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhpd extends zziar implements zzicd {
    private static final zzhpd zzd;
    private static volatile zzick zze;
    private String zza = "";
    private zzhzl zzb = zzhzl.f34557b;
    private int zzc;

    static {
        zzhpd zzhpdVar = new zzhpd();
        zzd = zzhpdVar;
        zziar.x(zzhpd.class, zzhpdVar);
    }

    public static zzhpd F(byte[] bArr, zziab zziabVar) {
        zziar zziarVarA = zziar.A(zzd, bArr, bArr.length, zziabVar);
        zziar.B(zziarVarA);
        return (zzhpd) zziarVarA;
    }

    public static zzhpc G() {
        return (zzhpc) zzd.u();
    }

    public static zzhpc H(zzhpd zzhpdVar) {
        zzial zzialVarU = zzd.u();
        zzialVarU.m(zzhpdVar);
        return (zzhpc) zzialVarU;
    }

    public static zzhpd I() {
        return zzd;
    }

    public final String C() {
        return this.zza;
    }

    public final zzhzl D() {
        return this.zzb;
    }

    public final zzhpw E() {
        zzhpw zzhpwVarA = zzhpw.a(this.zzc);
        return zzhpwVarA == null ? zzhpw.UNRECOGNIZED : zzhpwVarA;
    }

    public final /* synthetic */ void J(String str) {
        str.getClass();
        this.zza = str;
    }

    public final /* synthetic */ void K(zzhzl zzhzlVar) {
        zzhzlVar.getClass();
        this.zzb = zzhzlVar;
    }

    public final /* synthetic */ void L(zzhpw zzhpwVar) {
        this.zzc = zzhpwVar.zza();
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
            return new zzhpd();
        }
        if (iOrdinal == 4) {
            return new zzhpc(zzd);
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
        synchronized (zzhpd.class) {
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
