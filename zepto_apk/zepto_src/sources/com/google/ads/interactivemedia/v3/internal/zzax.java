package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzax extends zzacq implements zzaea {
    private static final zzax zzb;
    private int zzd;
    private long zze = -1;
    private int zzf = 1000;

    static {
        zzax zzaxVar = new zzax();
        zzb = zzaxVar;
        zzacq.zzaL(zzax.class, zzaxVar);
    }

    private zzax() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzbi.zza});
        }
        if (i3 == 3) {
            return new zzax();
        }
        zzae zzaeVar = null;
        if (i3 == 4) {
            return new zzaw(zzaeVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
