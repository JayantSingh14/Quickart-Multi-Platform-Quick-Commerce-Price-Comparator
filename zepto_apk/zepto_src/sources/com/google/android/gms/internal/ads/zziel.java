package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zziel extends zziar implements zzicd {
    private static final zziel zzb;
    private static volatile zzick zzc;
    private zzibd zza = zzicn.f34726e;

    static {
        zziel zzielVar = new zziel();
        zzb = zzielVar;
        zziar.x(zziel.class, zzielVar);
    }

    public static zziek C() {
        return (zziek) zzb.u();
    }

    public final void D(zziej zziejVar) {
        zzibd zzibdVar = this.zza;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zza = zzibdVar.zzh(size + size);
        }
        this.zza.add(zziejVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zziej.class});
        }
        if (iOrdinal == 3) {
            return new zziel();
        }
        if (iOrdinal == 4) {
            return new zziek(zzb);
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
        synchronized (zziel.class) {
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
