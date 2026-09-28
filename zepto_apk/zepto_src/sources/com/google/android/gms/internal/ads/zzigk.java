package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzigk extends zziar implements zzicd {
    private static final zzigk zzl;
    private static volatile zzick zzm;
    private int zza;
    private int zzb;
    private zzifl zzd;
    private zzifp zze;
    private int zzf;
    private int zzi;
    private byte zzk = 2;
    private String zzc = "";
    private zziaz zzg = zzias.f34649e;
    private String zzh = "";
    private zzibd zzj = zzicn.f34726e;

    static {
        zzigk zzigkVar = new zzigk();
        zzl = zzigkVar;
        zziar.x(zzigk.class, zzigkVar);
    }

    public static zzigj E() {
        return (zzigj) zzl.u();
    }

    public final String C() {
        return this.zzc;
    }

    public final int D() {
        return this.zzj.size();
    }

    public final /* synthetic */ void F(int i2) {
        this.zza |= 1;
        this.zzb = i2;
    }

    public final /* synthetic */ void G(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzc = str;
    }

    public final /* synthetic */ void H(zzifl zziflVar) {
        this.zzd = zziflVar;
        this.zza |= 4;
    }

    public final void I(String str) {
        str.getClass();
        zzibd zzibdVar = this.zzj;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zzj = zzibdVar.zzh(size + size);
        }
        this.zzj.add(str);
    }

    public final /* synthetic */ void J(int i2) {
        this.zzi = i2 - 1;
        this.zza |= 64;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        switch (zziaqVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzk);
            case 1:
                this.zzk = zziarVar == null ? (byte) 0 : (byte) 1;
                return null;
            case 2:
                return new zzico(zzl, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\b᠌\u0006\t\u001a", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzigh.f34822a, "zzj"});
            case 3:
                return new zzigk();
            case 4:
                return new zzigj(zzl);
            case 5:
                return zzl;
            case 6:
                zzick zzickVar = zzm;
                if (zzickVar != null) {
                    return zzickVar;
                }
                synchronized (zzigk.class) {
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
            default:
                throw null;
        }
    }
}
