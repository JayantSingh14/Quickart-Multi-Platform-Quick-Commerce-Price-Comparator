package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzxd extends zzacz implements zzaeg {
    private static final zzxd zzb;
    private int zze;

    static {
        zzxd zzxdVar = new zzxd();
        zzb = zzxdVar;
        zzacz.h(zzxd.class, zzxdVar);
    }

    public static zzxd p() {
        return zzb;
    }

    public static zzxd q(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzxd) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
        }
        if (i3 == 3) {
            return new zzxd();
        }
        if (i3 == 4) {
            return new zzxc(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
