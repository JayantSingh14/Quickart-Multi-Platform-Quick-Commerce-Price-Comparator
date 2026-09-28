package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzgcq extends zziar implements zzicd {
    private static final zzgcq zzf;
    private static volatile zzick zzg;
    private int zza;
    private zzgcs zzb;
    private zzhzl zzc;
    private zzhzl zzd;
    private int zze;

    static {
        zzgcq zzgcqVar = new zzgcq();
        zzf = zzgcqVar;
        zziar.x(zzgcq.class, zzgcqVar);
    }

    public zzgcq() {
        zzhzl zzhzlVar = zzhzl.f34557b;
        this.zzc = zzhzlVar;
        this.zzd = zzhzlVar;
    }

    public static zzgcp F() {
        return (zzgcp) zzf.u();
    }

    public final zzgcs C() {
        zzgcs zzgcsVar = this.zzb;
        return zzgcsVar == null ? zzgcs.H() : zzgcsVar;
    }

    public final zzhzl D() {
        return this.zzc;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final /* synthetic */ void G(zzgcs zzgcsVar) {
        this.zzb = zzgcsVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void H(zzhzl zzhzlVar) {
        zzhzlVar.getClass();
        this.zza |= 2;
        this.zzc = zzhzlVar;
    }

    public final /* synthetic */ void I(zzhzl zzhzlVar) {
        zzhzlVar.getClass();
        this.zza |= 4;
        this.zzd = zzhzlVar;
    }

    public final int J() {
        int iA = zzgdh.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    public final /* synthetic */ void K(int i2) {
        this.zze = i2 - 1;
        this.zza |= 8;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzf, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002\u0004᠌\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", zzgdg.f32313a});
        }
        if (iOrdinal == 3) {
            return new zzgcq();
        }
        if (iOrdinal == 4) {
            return new zzgcp(zzf);
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
        synchronized (zzgcq.class) {
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
