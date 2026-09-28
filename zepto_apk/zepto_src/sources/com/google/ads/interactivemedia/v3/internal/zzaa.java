package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzaa extends zzacq implements zzaea {
    private static final zzaa zzb;
    private int zzd;
    private int zze = 2;

    static {
        zzaa zzaaVar = new zzaa();
        zzb = zzaaVar;
        zzacq.zzaL(zzaa.class, zzaaVar);
    }

    private zzaa() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b᠌\u0000", new Object[]{"zzd", "zze", zzab.zza});
        }
        if (i3 == 3) {
            return new zzaa();
        }
        zzw zzwVar = null;
        if (i3 == 4) {
            return new zzz(zzwVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
