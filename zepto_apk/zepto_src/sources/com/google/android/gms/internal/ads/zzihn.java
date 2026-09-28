package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzihn extends zziar implements zzicd {
    private static final zzihn zzb;
    private static volatile zzick zzc;
    private zzibd zza = zzicn.f34726e;

    static {
        zzihn zzihnVar = new zzihn();
        zzb = zzihnVar;
        zziar.x(zzihn.class, zzihnVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzihl.class});
        }
        if (iOrdinal == 3) {
            return new zzihn();
        }
        if (iOrdinal == 4) {
            return new zzihm(zzb);
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
        synchronized (zzihn.class) {
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
