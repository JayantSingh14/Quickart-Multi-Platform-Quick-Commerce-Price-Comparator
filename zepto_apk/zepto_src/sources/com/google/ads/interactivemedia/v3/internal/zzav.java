package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzav extends zzacq implements zzaea {
    private static final zzav zzb;
    private int zzd;
    private int zze;
    private long zzf = -1;

    static {
        zzav zzavVar = new zzav();
        zzb = zzavVar;
        zzacq.zzaL(zzav.class, zzavVar);
    }

    private zzav() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", zzak.zza, "zzf"});
        }
        if (i3 == 3) {
            return new zzav();
        }
        zzae zzaeVar = null;
        if (i3 == 4) {
            return new zzau(zzaeVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
