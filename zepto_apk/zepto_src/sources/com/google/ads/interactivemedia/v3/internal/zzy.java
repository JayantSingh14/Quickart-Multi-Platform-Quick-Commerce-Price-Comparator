package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzy extends zzacq implements zzaea {
    private static final zzy zzb;
    private int zzd;
    private zzaa zze;
    private zzad zzf;

    static {
        zzy zzyVar = new zzy();
        zzb = zzyVar;
        zzacq.zzaL(zzy.class, zzyVar);
    }

    private zzy() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzy();
        }
        zzw zzwVar = null;
        if (i3 == 4) {
            return new zzx(zzwVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
