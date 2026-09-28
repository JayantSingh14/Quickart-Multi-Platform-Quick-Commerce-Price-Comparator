package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzy extends zzacz implements zzaeg {
    private static final zzy zzb;
    private int zze;
    private int zzf;
    private long zzg = -1;

    static {
        zzy zzyVar = new zzy();
        zzb = zzyVar;
        zzacz.h(zzy.class, zzyVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", zzv.f38080a, "zzg"});
        }
        if (i3 == 3) {
            return new zzy();
        }
        if (i3 == 4) {
            return new zzx(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
