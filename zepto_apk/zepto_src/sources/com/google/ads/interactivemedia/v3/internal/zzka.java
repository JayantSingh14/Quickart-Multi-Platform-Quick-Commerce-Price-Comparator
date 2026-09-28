package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzka extends zzacq implements zzaea {
    private static final zzka zzb;
    private int zzd;
    private zzkd zze;
    private zzabn zzf;
    private zzabn zzg;

    static {
        zzka zzkaVar = new zzka();
        zzb = zzkaVar;
        zzacq.zzaL(zzka.class, zzkaVar);
    }

    private zzka() {
        zzabn zzabnVar = zzabn.zzb;
        this.zzf = zzabnVar;
        this.zzg = zzabnVar;
    }

    public static zzka zzb(zzabn zzabnVar, zzacb zzacbVar) throws zzacz {
        return (zzka) zzacq.zzaC(zzb, zzabnVar, zzacbVar);
    }

    public final zzkd zzc() {
        zzkd zzkdVar = this.zze;
        return zzkdVar == null ? zzkd.zzf() : zzkdVar;
    }

    public final zzabn zzd() {
        return this.zzg;
    }

    public final zzabn zze() {
        return this.zzf;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzka();
        }
        zzjy zzjyVar = null;
        if (i3 == 4) {
            return new zzjz(zzjyVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
