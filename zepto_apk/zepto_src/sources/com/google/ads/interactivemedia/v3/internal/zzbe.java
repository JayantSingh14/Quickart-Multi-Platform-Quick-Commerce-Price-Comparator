package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzbe extends zzacq implements zzaea {
    private static final zzbe zzb;
    private int zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzacv zzh = zzacq.zzaE();
    private long zzi;

    static {
        zzbe zzbeVar = new zzbe();
        zzb = zzbeVar;
        zzacq.zzaL(zzbe.class, zzbeVar);
    }

    private zzbe() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i3 == 3) {
            return new zzbe();
        }
        zzae zzaeVar = null;
        if (i3 == 4) {
            return new zzbd(zzaeVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
