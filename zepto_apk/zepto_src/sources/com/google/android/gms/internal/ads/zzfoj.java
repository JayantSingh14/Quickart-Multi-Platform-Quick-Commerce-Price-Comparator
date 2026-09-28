package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfoj extends zziar implements zzicd {
    private static final zzfoj zzc;
    private static volatile zzick zzd;
    private zzibd zza = zzicn.f34726e;
    private long zzb;

    static {
        zzfoj zzfojVar = new zzfoj();
        zzc = zzfojVar;
        zziar.x(zzfoj.class, zzfojVar);
    }

    public static zzfoi C() {
        return (zzfoi) zzc.u();
    }

    public final void D(zzfnd zzfndVar) {
        zzibd zzibdVar = this.zza;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zza = zzibdVar.zzh(size + size);
        }
        this.zza.add(zzfndVar);
    }

    public final /* synthetic */ void E(long j2) {
        this.zzb = j2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0002", new Object[]{"zza", zzfnd.class, "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzfoj();
        }
        if (iOrdinal == 4) {
            return new zzfoi(zzc);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzd;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzfoj.class) {
            try {
                zziamVar = zzd;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzc);
                    zzd = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
