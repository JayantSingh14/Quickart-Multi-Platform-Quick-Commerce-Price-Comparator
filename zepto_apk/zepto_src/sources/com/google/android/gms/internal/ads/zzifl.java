package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzifl extends zziar implements zzicd {
    private static final zzifl zzh;
    private static volatile zzick zzi;
    private int zza;
    private zzifk zzb;
    private zzhzl zzd;
    private zzhzl zze;
    private int zzf;
    private byte zzg = 2;
    private zzibd zzc = zzicn.f34726e;

    static {
        zzifl zziflVar = new zzifl();
        zzh = zziflVar;
        zziar.x(zzifl.class, zziflVar);
    }

    public zzifl() {
        zzhzl zzhzlVar = zzhzl.f34557b;
        this.zzd = zzhzlVar;
        this.zze = zzhzlVar;
    }

    public static zzifi C() {
        return (zzifi) zzh.u();
    }

    public final void D(zzifh zzifhVar) {
        zzibd zzibdVar = this.zzc;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zzc = zzibdVar.zzh(size + size);
        }
        this.zzc.add(zzifhVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        switch (zziaqVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzg);
            case 1:
                this.zzg = zziarVar == null ? (byte) 0 : (byte) 1;
                return null;
            case 2:
                return new zzico(zzh, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zza", "zzb", "zzc", zzifh.class, "zzd", "zze", "zzf"});
            case 3:
                return new zzifl();
            case 4:
                return new zzifi(zzh);
            case 5:
                return zzh;
            case 6:
                zzick zzickVar = zzi;
                if (zzickVar != null) {
                    return zzickVar;
                }
                synchronized (zzifl.class) {
                    try {
                        zziamVar = zzi;
                        if (zziamVar == null) {
                            zziamVar = new zziam(zzh);
                            zzi = zziamVar;
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
