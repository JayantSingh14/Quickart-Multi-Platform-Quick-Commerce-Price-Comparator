package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzt extends zzacq implements zzaea {
    private static final zzt zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzt zztVar = new zzt();
        zzb = zztVar;
        zzacq.zzaL(zzt.class, zztVar);
    }

    private zzt() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzt();
        }
        zzq zzqVar = null;
        if (i3 == 4) {
            return new zzs(zzqVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
