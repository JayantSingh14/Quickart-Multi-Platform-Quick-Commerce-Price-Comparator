package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zziic extends zziar implements zzicd {
    private static final zziic zzl;
    private static volatile zzick zzm;
    private int zza;
    private zzhzl zzb = zzhzl.f34557b;
    private zziaz zzc;
    private long zzd;
    private zziaz zze;
    private zzibd zzf;
    private String zzg;
    private zzibd zzh;
    private zziie zzi;
    private zziig zzj;
    private zzhxg zzk;

    static {
        zziic zziicVar = new zziic();
        zzl = zziicVar;
        zziar.x(zziic.class, zziicVar);
    }

    public zziic() {
        zzias zziasVar = zzias.f34649e;
        this.zzc = zziasVar;
        this.zze = zziasVar;
        zzicn zzicnVar = zzicn.f34726e;
        this.zzf = zzicnVar;
        this.zzg = "";
        this.zzh = zzicnVar;
    }

    public static zziic C(byte[] bArr, zziab zziabVar) {
        zziar zziarVarA = zziar.A(zzl, bArr, bArr.length, zziabVar);
        zziar.B(zziarVarA);
        return (zziic) zziarVarA;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzl, "\u0001\n\u0000\u0001\u0001\u000f\n\u0000\u0004\u0000\u0001'\u0002ဂ\u0001\u0003'\u0004\u001b\u0005ဉ\u0003\u0007ဈ\u0002\tဉ\u0004\n\u001a\rည\u0000\u000fဉ\u0005", new Object[]{"zza", "zzc", "zzd", "zze", "zzh", zzihr.class, "zzi", "zzg", "zzj", "zzf", "zzb", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zziic();
        }
        if (iOrdinal == 4) {
            return new zziib(zzl);
        }
        if (iOrdinal == 5) {
            return zzl;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzm;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zziic.class) {
            try {
                zziamVar = zzm;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzl);
                    zzm = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
