package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaxg extends zziar implements zzicd {
    private static final zzaxg zzf;
    private static volatile zzick zzg;
    private int zza;
    private zzibd zzb = zzicn.f34726e;
    private zzhzl zzc = zzhzl.f34557b;
    private int zzd = 1;
    private int zze = 1;

    static {
        zzaxg zzaxgVar = new zzaxg();
        zzf = zzaxgVar;
        zziar.x(zzaxg.class, zzaxgVar);
    }

    public static zzaxf C() {
        return (zzaxf) zzf.u();
    }

    public final void D(zzhzl zzhzlVar) {
        zzibd zzibdVar = this.zzb;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zzb = zzibdVar.zzh(size + size);
        }
        this.zzb.add(zzhzlVar);
    }

    public final /* synthetic */ void E(zzhzl zzhzlVar) {
        this.zza |= 1;
        this.zzc = zzhzlVar;
    }

    public final /* synthetic */ void F(int i2) {
        this.zzd = 4;
        this.zza |= 2;
    }

    public final /* synthetic */ void G(int i2) {
        this.zze = i2 - 1;
        this.zza |= 4;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zza", "zzb", "zzc", "zzd", zzaxa.f24429a, "zze", zzaww.f24426a});
        }
        if (iOrdinal == 3) {
            return new zzaxg();
        }
        if (iOrdinal == 4) {
            return new zzaxf(zzf);
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
        synchronized (zzaxg.class) {
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
