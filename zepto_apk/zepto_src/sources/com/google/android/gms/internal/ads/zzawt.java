package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzawt extends zziar implements zzicd {
    private static final zzawt zzf;
    private static volatile zzick zzg;
    private int zza;
    private zzhzl zzb;
    private zzhzl zzc;
    private zzhzl zzd;
    private zzhzl zze;

    static {
        zzawt zzawtVar = new zzawt();
        zzf = zzawtVar;
        zziar.x(zzawt.class, zzawtVar);
    }

    public zzawt() {
        zzhzl zzhzlVar = zzhzl.f34557b;
        this.zzb = zzhzlVar;
        this.zzc = zzhzlVar;
        this.zzd = zzhzlVar;
        this.zze = zzhzlVar;
    }

    public static zzawt G(byte[] bArr, zziab zziabVar) {
        zziar zziarVarA = zziar.A(zzf, bArr, bArr.length, zziabVar);
        zziar.B(zziarVarA);
        return (zzawt) zziarVarA;
    }

    public static zzaws H() {
        return (zzaws) zzf.u();
    }

    public final zzhzl C() {
        return this.zzb;
    }

    public final zzhzl D() {
        return this.zzc;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final zzhzl F() {
        return this.zze;
    }

    public final /* synthetic */ void I(zzhzl zzhzlVar) {
        this.zza |= 1;
        this.zzb = zzhzlVar;
    }

    public final /* synthetic */ void J(zzhzl zzhzlVar) {
        this.zza |= 2;
        this.zzc = zzhzlVar;
    }

    public final /* synthetic */ void K(zzhzl zzhzlVar) {
        this.zza |= 4;
        this.zzd = zzhzlVar;
    }

    public final /* synthetic */ void L(zzhzl zzhzlVar) {
        this.zza |= 8;
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
            return new zzico(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzawt();
        }
        if (iOrdinal == 4) {
            return new zzaws(zzf);
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
        synchronized (zzawt.class) {
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
