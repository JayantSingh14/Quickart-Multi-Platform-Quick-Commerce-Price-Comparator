package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzgck extends zziar implements zzicd {
    private static final zzgck zzd;
    private static volatile zzick zze;
    private int zza;
    private zzibd zzb = zzicn.f34726e;
    private zzied zzc;

    static {
        zzgck zzgckVar = new zzgck();
        zzd = zzgckVar;
        zziar.x(zzgck.class, zzgckVar);
    }

    public static zzgcj C() {
        return (zzgcj) zzd.u();
    }

    public final void D(zzgci zzgciVar) {
        zzibd zzibdVar = this.zzb;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zzb = zzibdVar.zzh(size + size);
        }
        this.zzb.add(zzgciVar);
    }

    public final /* synthetic */ void E(zzied zziedVar) {
        zziedVar.getClass();
        this.zzc = zziedVar;
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
            return new zzico(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zza", "zzb", zzgci.class, "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzgck();
        }
        if (iOrdinal == 4) {
            return new zzgcj(zzd);
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
        synchronized (zzgck.class) {
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
