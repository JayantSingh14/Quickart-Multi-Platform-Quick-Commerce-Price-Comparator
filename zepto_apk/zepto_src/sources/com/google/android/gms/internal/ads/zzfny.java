package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfny extends zziar implements zzicd {
    private static final zzfny zzb;
    private static volatile zzick zzc;
    private zzibd zza = zzicn.f34726e;

    static {
        zzfny zzfnyVar = new zzfny();
        zzb = zzfnyVar;
        zziar.x(zzfny.class, zzfnyVar);
    }

    public static zzfnv D() {
        return (zzfnv) zzb.u();
    }

    public final int C() {
        return this.zza.size();
    }

    public final void E(zzfnx zzfnxVar) {
        zzibd zzibdVar = this.zza;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zza = zzibdVar.zzh(size + size);
        }
        this.zza.add(zzfnxVar);
    }

    public final void F() {
        this.zza = zzicn.f34726e;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzfnx.class});
        }
        if (iOrdinal == 3) {
            return new zzfny();
        }
        if (iOrdinal == 4) {
            return new zzfnv(zzb);
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
        synchronized (zzfny.class) {
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
