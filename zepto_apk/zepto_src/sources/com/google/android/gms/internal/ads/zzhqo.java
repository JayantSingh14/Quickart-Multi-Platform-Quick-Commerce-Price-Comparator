package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhqo extends zziar implements zzicd {
    private static final zzhqo zzf;
    private static volatile zzick zzg;
    private int zza;
    private int zzb;
    private zzhqk zzc;
    private zzhzl zzd;
    private zzhzl zze;

    static {
        zzhqo zzhqoVar = new zzhqo();
        zzf = zzhqoVar;
        zziar.x(zzhqo.class, zzhqoVar);
    }

    public zzhqo() {
        zzhzl zzhzlVar = zzhzl.f34557b;
        this.zzd = zzhzlVar;
        this.zze = zzhzlVar;
    }

    public static zzhqo G(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhqo) zziar.q(zzf, zzhzlVar, zziabVar);
    }

    public static zzhqn H() {
        return (zzhqn) zzf.u();
    }

    public static zzhqo I() {
        return zzf;
    }

    public static zzick J() {
        return zzf.s();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhqk D() {
        zzhqk zzhqkVar = this.zzc;
        return zzhqkVar == null ? zzhqk.G() : zzhqkVar;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final zzhzl F() {
        return this.zze;
    }

    public final /* synthetic */ void K(int i2) {
        this.zzb = 0;
    }

    public final /* synthetic */ void L(zzhqk zzhqkVar) {
        this.zzc = zzhqkVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void M(zzhzl zzhzlVar) {
        this.zzd = zzhzlVar;
    }

    public final /* synthetic */ void N(zzhzl zzhzlVar) {
        this.zze = zzhzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzf, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzhqo();
        }
        if (iOrdinal == 4) {
            return new zzhqn(zzf);
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
        synchronized (zzhqo.class) {
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
