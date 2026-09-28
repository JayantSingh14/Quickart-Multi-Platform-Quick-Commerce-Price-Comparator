package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzigp extends zziar implements zzicd {
    private static final zzigp zzf;
    private static volatile zzick zzg;
    private int zza;
    private String zzb = "";
    private zzibd zzc;
    private zzibd zzd;
    private String zze;

    static {
        zzigp zzigpVar = new zzigp();
        zzf = zzigpVar;
        zziar.x(zzigp.class, zzigpVar);
    }

    public zzigp() {
        zzicn zzicnVar = zzicn.f34726e;
        this.zzc = zzicnVar;
        this.zzd = zzicnVar;
        this.zze = "";
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001a\u0003\u001a\u0004ဈ\u0001", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzigp();
        }
        if (iOrdinal == 4) {
            return new zzigo(zzf);
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
        synchronized (zzigp.class) {
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
