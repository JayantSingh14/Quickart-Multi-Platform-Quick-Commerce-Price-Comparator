package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzao extends zzacq implements zzaea {
    private static final zzao zzb;
    private int zzd;
    private long zze = -1;
    private int zzf = 1000;
    private int zzg = 1000;

    static {
        zzao zzaoVar = new zzao();
        zzb = zzaoVar;
        zzacq.zzaL(zzao.class, zzaoVar);
    }

    private zzao() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            zzacu zzacuVar = zzbi.zza;
            return zzacq.zzaI(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", zzacuVar, "zzg", zzacuVar});
        }
        if (i3 == 3) {
            return new zzao();
        }
        zzae zzaeVar = null;
        if (i3 == 4) {
            return new zzan(zzaeVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
