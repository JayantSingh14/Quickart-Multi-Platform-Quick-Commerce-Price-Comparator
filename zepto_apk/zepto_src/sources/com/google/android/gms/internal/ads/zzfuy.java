package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfuy extends zziar implements zzicd {
    private static final zzfuy zzf;
    private static volatile zzick zzg;
    private int zza;
    private zziaz zzb = zzias.f34649e;
    private String zzc = "";
    private String zzd = "";
    private String zze = "";

    static {
        zzfuy zzfuyVar = new zzfuy();
        zzf = zzfuyVar;
        zziar.x(zzfuy.class, zzfuyVar);
    }

    public static zzfux C() {
        return (zzfux) zzf.u();
    }

    public final /* synthetic */ void D(String str) {
        str.getClass();
        this.zza |= 1;
        this.zzc = str;
    }

    public final void E(int i2) {
        zziaz zziazVar = this.zzb;
        if (!zziazVar.zza()) {
            int size = zziazVar.size();
            this.zzb = zziazVar.zzh(size + size);
        }
        this.zzb.zzi(2);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ࠞ\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zza", "zzb", zzfuw.f31915a, "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzfuy();
        }
        if (iOrdinal == 4) {
            return new zzfux(zzf);
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
        synchronized (zzfuy.class) {
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
