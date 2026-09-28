package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzsq extends zzacz implements zzaeg {
    private static final zzsq zzb;
    private int zze;

    static {
        zzsq zzsqVar = new zzsq();
        zzb = zzsqVar;
        zzacz.h(zzsq.class, zzsqVar);
    }

    public static zzsp q() {
        return (zzsp) zzb.k();
    }

    public static zzsq r() {
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
            return new zzsq();
        }
        if (i3 == 4) {
            return new zzsp(zzb);
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
