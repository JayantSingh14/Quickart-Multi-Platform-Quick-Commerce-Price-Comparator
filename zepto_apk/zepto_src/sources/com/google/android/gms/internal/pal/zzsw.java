package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzsw extends zzacz implements zzaeg {
    private static final zzsw zzb;
    private int zze;
    private int zzf;

    static {
        zzsw zzswVar = new zzsw();
        zzb = zzswVar;
        zzacz.h(zzsw.class, zzswVar);
    }

    public static zzsv q() {
        return (zzsv) zzb.k();
    }

    public static zzsw r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzsw) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzsw();
        }
        if (i3 == 4) {
            return new zzsv(zzb);
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
