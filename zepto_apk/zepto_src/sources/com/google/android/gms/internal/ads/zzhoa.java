package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhoa extends zziar implements zzicd {
    private static final zzhoa zza;
    private static volatile zzick zzb;

    static {
        zzhoa zzhoaVar = new zzhoa();
        zza = zzhoaVar;
        zziar.x(zzhoa.class, zzhoaVar);
    }

    public static void C(zzhzl zzhzlVar, zziab zziabVar) {
    }

    public static zzhoa D() {
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zza, "\u0000\u0000", null);
        }
        if (iOrdinal == 3) {
            return new zzhoa();
        }
        if (iOrdinal == 4) {
            return new zzhnz(zza);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzb;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhoa.class) {
            try {
                zziamVar = zzb;
                if (zziamVar == null) {
                    zziamVar = new zziam(zza);
                    zzb = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
