package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzgcs extends zziar implements zzicd {
    private static final zzgcs zze;
    private static volatile zzick zzf;
    private int zza;
    private int zzb = 0;
    private Object zzc;
    private int zzd;

    static {
        zzgcs zzgcsVar = new zzgcs();
        zze = zzgcsVar;
        zziar.x(zzgcs.class, zzgcsVar);
    }

    public static zzgcs F(zzhzl zzhzlVar) {
        zzgcs zzgcsVar = zze;
        zziab zziabVar = zziab.f34620b;
        int i2 = zzhyy.f34536a;
        zziar zziarVarQ = zziar.q(zzgcsVar, zzhzlVar, zziab.f34621c);
        zziar.B(zziarVarQ);
        return (zzgcs) zziarVarQ;
    }

    public static zzgcr G() {
        return (zzgcr) zze.u();
    }

    public static zzgcs H() {
        return zze;
    }

    public final zzbby C() {
        return this.zzb == 1 ? (zzbby) this.zzc : zzbby.K();
    }

    public final zzbbw D() {
        return this.zzb == 2 ? (zzbbw) this.zzc : zzbbw.F();
    }

    public final zzbbq E() {
        zzbbq zzbbqVarA = zzbbq.a(this.zzd);
        return zzbbqVarA == null ? zzbbq.UNSUPPORTED : zzbbqVarA;
    }

    public final /* synthetic */ void I(zzbby zzbbyVar) {
        zzbbyVar.getClass();
        this.zzc = zzbbyVar;
        this.zzb = 1;
    }

    public final /* synthetic */ void J(zzbbw zzbbwVar) {
        zzbbwVar.getClass();
        this.zzc = zzbbwVar;
        this.zzb = 2;
    }

    public final void K(zzbbq zzbbqVar) {
        this.zzd = zzbbqVar.f24687a;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zze, "\u0004\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003᠌\u0000", new Object[]{"zzc", "zzb", "zza", zzbby.class, zzbbw.class, "zzd", zzbbp.f24678a});
        }
        if (iOrdinal == 3) {
            return new zzgcs();
        }
        if (iOrdinal == 4) {
            return new zzgcr(zze);
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
        synchronized (zzgcs.class) {
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
