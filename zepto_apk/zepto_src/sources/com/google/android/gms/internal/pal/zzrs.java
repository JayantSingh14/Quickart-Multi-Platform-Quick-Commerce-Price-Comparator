package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzrs extends zzacz implements zzaeg {
    private static final zzrs zzb;
    private int zze;

    static {
        zzrs zzrsVar = new zzrs();
        zzb = zzrsVar;
        zzacz.h(zzrs.class, zzrsVar);
    }

    public static zzrr q() {
        return (zzrr) zzb.k();
    }

    public static zzrs r() {
        return zzb;
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
            return new zzrs();
        }
        if (i3 == 4) {
            return new zzrr(zzb);
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
