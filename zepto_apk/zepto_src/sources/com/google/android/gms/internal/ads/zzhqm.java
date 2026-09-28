package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhqm extends zziar implements zzicd {
    private static final zzhqm zzj;
    private static volatile zzick zzk;
    private int zza;
    private int zzb;
    private zzhqo zzc;
    private zzhzl zzd;
    private zzhzl zze;
    private zzhzl zzf;
    private zzhzl zzg;
    private zzhzl zzh;
    private zzhzl zzi;

    static {
        zzhqm zzhqmVar = new zzhqm();
        zzj = zzhqmVar;
        zziar.x(zzhqm.class, zzhqmVar);
    }

    public zzhqm() {
        zzhzl zzhzlVar = zzhzl.f34557b;
        this.zzd = zzhzlVar;
        this.zze = zzhzlVar;
        this.zzf = zzhzlVar;
        this.zzg = zzhzlVar;
        this.zzh = zzhzlVar;
        this.zzi = zzhzlVar;
    }

    public static zzhqm K(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhqm) zziar.q(zzj, zzhzlVar, zziabVar);
    }

    public static zzhql L() {
        return (zzhql) zzj.u();
    }

    public static zzick M() {
        return zzj.s();
    }

    public final int C() {
        return this.zzb;
    }

    public final zzhqo D() {
        zzhqo zzhqoVar = this.zzc;
        return zzhqoVar == null ? zzhqo.I() : zzhqoVar;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    public final zzhzl F() {
        return this.zze;
    }

    public final zzhzl G() {
        return this.zzf;
    }

    public final zzhzl H() {
        return this.zzg;
    }

    public final zzhzl I() {
        return this.zzh;
    }

    public final zzhzl J() {
        return this.zzi;
    }

    public final /* synthetic */ void N() {
        this.zzb = 0;
    }

    public final /* synthetic */ void O(zzhqo zzhqoVar) {
        this.zzc = zzhqoVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void P(zzhzl zzhzlVar) {
        this.zzd = zzhzlVar;
    }

    public final /* synthetic */ void Q(zzhzl zzhzlVar) {
        this.zze = zzhzlVar;
    }

    public final /* synthetic */ void R(zzhzl zzhzlVar) {
        this.zzf = zzhzlVar;
    }

    public final /* synthetic */ void S(zzhzl zzhzlVar) {
        this.zzg = zzhzlVar;
    }

    public final /* synthetic */ void T(zzhzl zzhzlVar) {
        this.zzh = zzhzlVar;
    }

    public final /* synthetic */ void U(zzhzl zzhzlVar) {
        this.zzi = zzhzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzj, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzhqm();
        }
        if (iOrdinal == 4) {
            return new zzhql(zzj);
        }
        if (iOrdinal == 5) {
            return zzj;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzk;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhqm.class) {
            try {
                zziamVar = zzk;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzj);
                    zzk = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
