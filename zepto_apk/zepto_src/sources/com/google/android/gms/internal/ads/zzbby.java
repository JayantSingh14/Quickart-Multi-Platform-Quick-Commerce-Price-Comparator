package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbby extends zziar implements zzicd {
    private static final zzbby zzg;
    private static volatile zzick zzh;
    private int zza;
    private String zzb = "";
    private String zzc = "";
    private long zzd;
    private long zze;
    private long zzf;

    static {
        zzbby zzbbyVar = new zzbby();
        zzg = zzbbyVar;
        zziar.x(zzbby.class, zzbbyVar);
    }

    public static zzbby H(zzhzl zzhzlVar) {
        zzbby zzbbyVar = zzg;
        zziab zziabVar = zziab.f34620b;
        int i2 = zzhyy.f34536a;
        zziar zziarVarQ = zziar.q(zzbbyVar, zzhzlVar, zziab.f34621c);
        zziar.B(zziarVarQ);
        return (zzbby) zziarVarQ;
    }

    public static zzbby I(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzbby) zziar.q(zzg, zzhzlVar, zziabVar);
    }

    public static zzbbx J() {
        return (zzbbx) zzg.u();
    }

    public static zzbby K() {
        return zzg;
    }

    public final String C() {
        return this.zzb;
    }

    public final String D() {
        return this.zzc;
    }

    public final long E() {
        return this.zzd;
    }

    public final long F() {
        return this.zze;
    }

    public final long G() {
        return this.zzf;
    }

    public final /* synthetic */ void L(String str) {
        str.getClass();
        this.zza |= 1;
        this.zzb = str;
    }

    public final /* synthetic */ void M(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzc = str;
    }

    public final /* synthetic */ void N(long j2) {
        this.zza |= 4;
        this.zzd = j2;
    }

    public final /* synthetic */ void O(long j2) {
        this.zza |= 8;
        this.zze = j2;
    }

    public final /* synthetic */ void P(long j2) {
        this.zza |= 16;
        this.zzf = j2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzg, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzbby();
        }
        if (iOrdinal == 4) {
            return new zzbbx(zzg);
        }
        if (iOrdinal == 5) {
            return zzg;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzh;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzbby.class) {
            try {
                zziamVar = zzh;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzg);
                    zzh = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
