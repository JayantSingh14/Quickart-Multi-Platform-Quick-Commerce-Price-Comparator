package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zztl extends zzacz implements zzaeg {
    private static final zztl zzb;
    private int zze;
    private zzaby zzf = zzaby.f37363b;

    static {
        zztl zztlVar = new zztl();
        zzb = zztlVar;
        zzacz.h(zztl.class, zztlVar);
    }

    public static zztk q() {
        return (zztk) zzb.k();
    }

    public static zztl r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zztl) zzacz.m(zzb, zzabyVar, zzacmVar);
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
            return new zztl();
        }
        if (i3 == 4) {
            return new zztk(zzb);
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
