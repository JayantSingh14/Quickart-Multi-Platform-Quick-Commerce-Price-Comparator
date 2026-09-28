package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zztc extends zzacz implements zzaeg {
    private static final zztc zzb;
    private int zze;
    private int zzf;

    static {
        zztc zztcVar = new zztc();
        zzb = zztcVar;
        zzacz.h(zztc.class, zztcVar);
    }

    public static zztb q() {
        return (zztb) zzb.k();
    }

    public static zztc r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zztc) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzf", "zze"});
        }
        if (i3 == 3) {
            return new zztc();
        }
        if (i3 == 4) {
            return new zztb(zzb);
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
