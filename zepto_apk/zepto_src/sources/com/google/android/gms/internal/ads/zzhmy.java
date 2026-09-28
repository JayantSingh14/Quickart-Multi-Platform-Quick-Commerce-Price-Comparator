package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhmy extends zziar implements zzicd {
    private static final zzhmy zzb;
    private static volatile zzick zzc;
    private int zza;

    static {
        zzhmy zzhmyVar = new zzhmy();
        zzb = zzhmyVar;
        zziar.x(zzhmy.class, zzhmyVar);
    }

    public static zzhmx D() {
        return (zzhmx) zzb.u();
    }

    public static zzhmy E() {
        return zzb;
    }

    public final int C() {
        return this.zza;
    }

    public final /* synthetic */ void F(int i2) {
        this.zza = i2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhmy();
        }
        if (iOrdinal == 4) {
            return new zzhmx(zzb);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzc;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhmy.class) {
            try {
                zziamVar = zzc;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzb);
                    zzc = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
