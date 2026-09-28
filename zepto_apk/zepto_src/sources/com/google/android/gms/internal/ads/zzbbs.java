package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbbs extends zziar implements zzicd {
    private static final zzbbs zze;
    private static volatile zzick zzf;
    private int zza;
    private zzbby zzb;
    private zzhzl zzc;
    private zzhzl zzd;

    static {
        zzbbs zzbbsVar = new zzbbs();
        zze = zzbbsVar;
        zziar.x(zzbbs.class, zzbbsVar);
    }

    public zzbbs() {
        zzhzl zzhzlVar = zzhzl.f34557b;
        this.zzc = zzhzlVar;
        this.zzd = zzhzlVar;
    }

    public static zzbbs F(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzbbs) zziar.q(zze, zzhzlVar, zziabVar);
    }

    public static zzbbs G(byte[] bArr, zziab zziabVar) {
        zziar zziarVarA = zziar.A(zze, bArr, bArr.length, zziabVar);
        zziar.B(zziarVarA);
        return (zzbbs) zziarVarA;
    }

    public final zzbby C() {
        zzbby zzbbyVar = this.zzb;
        return zzbbyVar == null ? zzbby.K() : zzbbyVar;
    }

    public final zzhzl D() {
        return this.zzc;
    }

    public final zzhzl E() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zze, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzbbs();
        }
        if (iOrdinal == 4) {
            return new zzbbr(zze);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzf;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzbbs.class) {
            try {
                zziamVar = zzf;
                if (zziamVar == null) {
                    zziamVar = new zziam(zze);
                    zzf = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
