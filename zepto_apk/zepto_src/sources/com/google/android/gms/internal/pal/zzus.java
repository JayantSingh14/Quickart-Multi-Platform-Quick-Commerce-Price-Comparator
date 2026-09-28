package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzus extends zzacz implements zzaeg {
    private static final zzus zzb;
    private zzuv zze;
    private int zzf;
    private int zzg;

    static {
        zzus zzusVar = new zzus();
        zzb = zzusVar;
        zzacz.h(zzus.class, zzusVar);
    }

    public static zzur q() {
        return (zzur) zzb.k();
    }

    public static zzus r() {
        return zzb;
    }

    public static zzus s(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzus) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzus();
        }
        if (i3 == 4) {
            return new zzur(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zzf;
    }

    public final zzuv t() {
        zzuv zzuvVar = this.zze;
        return zzuvVar == null ? zzuv.r() : zzuvVar;
    }
}
