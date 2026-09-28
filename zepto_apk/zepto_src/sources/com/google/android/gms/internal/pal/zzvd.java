package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzvd extends zzacz implements zzaeg {
    private static final zzvd zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzvd zzvdVar = new zzvd();
        zzb = zzvdVar;
        zzacz.h(zzvd.class, zzvdVar);
    }

    public static zzvc p() {
        return (zzvc) zzb.k();
    }

    public static zzvd q() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzvd();
        }
        if (i3 == 4) {
            return new zzvc(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int r() {
        int i2 = this.zzg;
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? 0 : 5 : 4 : 3 : 2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public final int s() {
        int i2 = this.zzf;
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? 0 : 5 : 4 : 3 : 2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public final int t() {
        int i2 = this.zze;
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? 0 : 6 : 5 : 4 : 3 : 2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }
}
