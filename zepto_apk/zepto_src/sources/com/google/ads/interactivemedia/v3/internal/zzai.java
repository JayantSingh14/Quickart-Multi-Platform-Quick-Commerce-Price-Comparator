package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzai extends zzacq implements zzaea {
    private static final zzai zzb;
    private int zzd;
    private int zze;

    static {
        zzai zzaiVar = new zzai();
        zzb = zzaiVar;
        zzacq.zzaL(zzai.class, zzaiVar);
    }

    private zzai() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzam.zza});
        }
        if (i3 == 3) {
            return new zzai();
        }
        zzae zzaeVar = null;
        if (i3 == 4) {
            return new zzah(zzaeVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
