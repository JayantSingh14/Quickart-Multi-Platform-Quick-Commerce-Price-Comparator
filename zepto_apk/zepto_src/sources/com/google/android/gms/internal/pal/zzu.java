package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzu extends zzacz implements zzaeg {
    private static final zzu zzb;
    private int zze;
    private int zzf;

    static {
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzacz.h(zzu.class, zzuVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zze", "zzf", zzw.f38096a});
        }
        if (i3 == 3) {
            return new zzu();
        }
        if (i3 == 4) {
            return new zzt(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
