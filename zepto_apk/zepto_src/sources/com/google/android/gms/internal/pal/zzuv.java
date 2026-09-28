package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzuv extends zzacz implements zzaeg {
    private static final zzuv zzb;
    private int zze;
    private int zzf;

    static {
        zzuv zzuvVar = new zzuv();
        zzb = zzuvVar;
        zzacz.h(zzuv.class, zzuvVar);
    }

    public static zzuu q() {
        return (zzuu) zzb.k();
    }

    public static zzuv r() {
        return zzb;
    }

    public static void u(zzuv zzuvVar, int i2) {
        if (i2 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzuvVar.zze = i2 - 2;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzuv();
        }
        if (i3 == 4) {
            return new zzuu(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zzf;
    }

    public final int t() {
        int iA = zzum.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
