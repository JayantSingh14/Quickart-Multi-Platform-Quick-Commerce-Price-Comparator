package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzaa extends zzacz implements zzaeg {
    private static final zzaa zzb;
    private int zze;
    private long zzf = -1;
    private int zzg = 1000;

    static {
        zzaa zzaaVar = new zzaa();
        zzb = zzaaVar;
        zzacz.h(zzaa.class, zzaaVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", "zzg", zzan.f37523a});
        }
        if (i3 == 3) {
            return new zzaa();
        }
        if (i3 == 4) {
            return new zzz(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
