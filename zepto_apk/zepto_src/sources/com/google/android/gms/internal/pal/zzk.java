package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzk extends zzacz implements zzaeg {
    private static final zzk zzb;
    private int zze;
    private int zzf = 2;

    static {
        zzk zzkVar = new zzk();
        zzb = zzkVar;
        zzacz.h(zzk.class, zzkVar);
    }

    public static zzk p() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001bဌ\u0000", new Object[]{"zze", "zzf", zzm.f37924a});
        }
        if (i3 == 3) {
            return new zzk();
        }
        if (i3 == 4) {
            return new zzj(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int q() {
        int i2 = this.zzf;
        int i3 = 1;
        if (i2 != 0) {
            if (i2 == 1) {
                i3 = 2;
            } else if (i2 != 2) {
                i3 = 4;
                if (i2 != 3) {
                    i3 = i2 != 4 ? 0 : 5;
                }
            } else {
                i3 = 3;
            }
        }
        if (i3 == 0) {
            return 3;
        }
        return i3;
    }
}
