package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zztf extends zzacz implements zzaeg {
    private static final zztf zzb;
    private int zze;
    private zzaby zzf = zzaby.f37363b;

    static {
        zztf zztfVar = new zztf();
        zzb = zztfVar;
        zzacz.h(zztf.class, zztfVar);
    }

    public static zzte q() {
        return (zzte) zzb.k();
    }

    public static zztf r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zztf) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zztf();
        }
        if (i3 == 4) {
            return new zzte(zzb);
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
