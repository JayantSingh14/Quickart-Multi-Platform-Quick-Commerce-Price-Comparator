package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzry extends zzacz implements zzaeg {
    private static final zzry zzb;
    private zzse zze;
    private zzus zzf;

    static {
        zzry zzryVar = new zzry();
        zzb = zzryVar;
        zzacz.h(zzry.class, zzryVar);
    }

    public static zzrx p() {
        return (zzrx) zzb.k();
    }

    public static zzry q(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzry) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzry();
        }
        if (i3 == 4) {
            return new zzrx(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzse r() {
        zzse zzseVar = this.zze;
        return zzseVar == null ? zzse.r() : zzseVar;
    }

    public final zzus s() {
        zzus zzusVar = this.zzf;
        return zzusVar == null ? zzus.r() : zzusVar;
    }
}
