package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzti extends zzacz implements zzaeg {
    private static final zzti zzb;
    private int zze;
    private int zzf;

    static {
        zzti zztiVar = new zzti();
        zzb = zztiVar;
        zzacz.h(zzti.class, zztiVar);
    }

    public static zzth q() {
        return (zzth) zzb.k();
    }

    public static zzti r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzti) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzti();
        }
        if (i3 == 4) {
            return new zzth(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }
}
