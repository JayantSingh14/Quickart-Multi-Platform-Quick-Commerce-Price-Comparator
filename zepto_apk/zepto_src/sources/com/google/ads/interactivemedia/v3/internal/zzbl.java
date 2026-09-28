package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzbl extends zzacq implements zzaea {
    private static final zzbl zzb;
    private int zzd;
    private long zze;
    private String zzf = "";
    private zzabn zzg = zzabn.zzb;

    static {
        zzbl zzblVar = new zzbl();
        zzb = zzblVar;
        zzacq.zzaL(zzbl.class, zzblVar);
    }

    private zzbl() {
    }

    public static zzbl zzc() {
        return zzb;
    }

    public final long zza() {
        return this.zze;
    }

    public final boolean zzd() {
        return (this.zzd & 1) != 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzbl();
        }
        zzae zzaeVar = null;
        if (i3 == 4) {
            return new zzbk(zzaeVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
