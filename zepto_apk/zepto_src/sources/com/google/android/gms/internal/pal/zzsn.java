package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzsn extends zzacz implements zzaeg {
    private static final zzsn zzb;
    private zzsq zze;
    private int zzf;

    static {
        zzsn zzsnVar = new zzsn();
        zzb = zzsnVar;
        zzacz.h(zzsn.class, zzsnVar);
    }

    public static zzsm q() {
        return (zzsm) zzb.k();
    }

    public static zzsn r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzsn) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzsn();
        }
        if (i3 == 4) {
            return new zzsm(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zzf;
    }

    public final zzsq s() {
        zzsq zzsqVar = this.zze;
        return zzsqVar == null ? zzsq.r() : zzsqVar;
    }
}
