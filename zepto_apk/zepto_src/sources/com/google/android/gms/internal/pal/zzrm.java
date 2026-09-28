package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzrm extends zzacz implements zzaeg {
    private static final zzrm zzb;
    private int zze;
    private zzaby zzf = zzaby.f37363b;
    private zzrs zzg;

    static {
        zzrm zzrmVar = new zzrm();
        zzb = zzrmVar;
        zzacz.h(zzrm.class, zzrmVar);
    }

    public static zzrl q() {
        return (zzrl) zzb.k();
    }

    public static zzrm r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzrm) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    public static /* synthetic */ void w(zzrm zzrmVar, zzrs zzrsVar) {
        zzrsVar.getClass();
        zzrmVar.zzg = zzrsVar;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzrm();
        }
        if (i3 == 4) {
            return new zzrl(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzrs s() {
        zzrs zzrsVar = this.zzg;
        return zzrsVar == null ? zzrs.r() : zzrsVar;
    }

    public final zzaby t() {
        return this.zzf;
    }
}
