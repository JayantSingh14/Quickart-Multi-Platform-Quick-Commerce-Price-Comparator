package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhnm extends zziar implements zzicd {
    private static final zzhnm zzd;
    private static volatile zzick zze;
    private int zza;
    private zzhno zzb;
    private int zzc;

    static {
        zzhnm zzhnmVar = new zzhnm();
        zzd = zzhnmVar;
        zziar.x(zzhnm.class, zzhnmVar);
    }

    public static zzhnm E(zzhzl zzhzlVar, zziab zziabVar) {
        return (zzhnm) zziar.q(zzd, zzhzlVar, zziabVar);
    }

    public static zzhnl F() {
        return (zzhnl) zzd.u();
    }

    public final zzhno C() {
        zzhno zzhnoVar = this.zzb;
        return zzhnoVar == null ? zzhno.E() : zzhnoVar;
    }

    public final int D() {
        return this.zzc;
    }

    public final /* synthetic */ void G(zzhno zzhnoVar) {
        this.zzb = zzhnoVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void H(int i2) {
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhnm();
        }
        if (iOrdinal == 4) {
            return new zzhnl(zzd);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zze;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhnm.class) {
            try {
                zziamVar = zze;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzd);
                    zze = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
