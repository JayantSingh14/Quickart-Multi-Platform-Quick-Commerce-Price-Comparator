package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzsz extends zzacz implements zzaeg {
    private static final zzsz zzb;
    private int zze;
    private zzaby zzf = zzaby.f37363b;

    static {
        zzsz zzszVar = new zzsz();
        zzb = zzszVar;
        zzacz.h(zzsz.class, zzszVar);
    }

    public static zzsy q() {
        return (zzsy) zzb.k();
    }

    public static zzsz r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzsz) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzsz();
        }
        if (i3 == 4) {
            return new zzsy(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzaby s() {
        return this.zzf;
    }
}
