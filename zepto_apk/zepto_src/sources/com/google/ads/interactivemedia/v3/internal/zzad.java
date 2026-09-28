package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzad extends zzacq implements zzaea {
    private static final zzad zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    static {
        zzad zzadVar = new zzad();
        zzb = zzadVar;
        zzacq.zzaL(zzad.class, zzadVar);
    }

    private zzad() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i3 == 3) {
            return new zzad();
        }
        zzw zzwVar = null;
        if (i3 == 4) {
            return new zzac(zzwVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
