package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzaq extends zzacq implements zzaea {
    private static final zzaq zzb;
    private int zzd;
    private long zze = -1;

    static {
        zzaq zzaqVar = new zzaq();
        zzb = zzaqVar;
        zzacq.zzaL(zzaq.class, zzaqVar);
    }

    private zzaq() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဂ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i3 == 3) {
            return new zzaq();
        }
        zzae zzaeVar = null;
        if (i3 == 4) {
            return new zzap(zzaeVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
