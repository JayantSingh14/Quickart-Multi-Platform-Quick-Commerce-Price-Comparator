package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzifp extends zziar implements zzicd {
    private static final zzifp zzi;
    private static volatile zzick zzj;
    private int zza;
    private zzifo zzb;
    private zzhzl zzd;
    private zzhzl zze;
    private int zzf;
    private zzhzl zzg;
    private byte zzh = 2;
    private zzibd zzc = zzicn.f34726e;

    static {
        zzifp zzifpVar = new zzifp();
        zzi = zzifpVar;
        zziar.x(zzifp.class, zzifpVar);
    }

    public zzifp() {
        zzhzl zzhzlVar = zzhzl.f34557b;
        this.zzd = zzhzlVar;
        this.zze = zzhzlVar;
        this.zzg = zzhzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        switch (zziaqVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzh);
            case 1:
                this.zzh = zziarVar == null ? (byte) 0 : (byte) 1;
                return null;
            case 2:
                return new zzico(zzi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zza", "zzb", "zzc", zzifh.class, "zzd", "zze", "zzf", "zzg"});
            case 3:
                return new zzifp();
            case 4:
                return new zzifm(zzi);
            case 5:
                return zzi;
            case 6:
                zzick zzickVar = zzj;
                if (zzickVar != null) {
                    return zzickVar;
                }
                synchronized (zzifp.class) {
                    try {
                        zziamVar = zzj;
                        if (zziamVar == null) {
                            zziamVar = new zziam(zzi);
                            zzj = zziamVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zziamVar;
            default:
                throw null;
        }
    }
}
