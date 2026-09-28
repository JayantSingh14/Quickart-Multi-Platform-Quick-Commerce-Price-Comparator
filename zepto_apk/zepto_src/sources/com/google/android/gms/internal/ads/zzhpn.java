package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhpn extends zziar implements zzicd {
    private static final zzhpn zzc;
    private static volatile zzick zzd;
    private int zza;
    private zzibd zzb = zzicn.f34726e;

    static {
        zzhpn zzhpnVar = new zzhpn();
        zzc = zzhpnVar;
        zziar.x(zzhpn.class, zzhpnVar);
    }

    public static zzhpk C() {
        return (zzhpk) zzc.u();
    }

    public final /* synthetic */ void D(int i2) {
        this.zza = i2;
    }

    public final void E(zzhpm zzhpmVar) {
        zzibd zzibdVar = this.zzb;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zzb = zzibdVar.zzh(size + size);
        }
        this.zzb.add(zzhpmVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zza", "zzb", zzhpm.class});
        }
        if (iOrdinal == 3) {
            return new zzhpn();
        }
        if (iOrdinal == 4) {
            return new zzhpk(zzc);
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
        synchronized (zzhpn.class) {
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
