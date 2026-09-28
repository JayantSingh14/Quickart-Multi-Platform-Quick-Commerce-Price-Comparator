package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzsk extends zzacz implements zzaeg {
    private static final zzsk zzb;
    private int zze;
    private zzsq zzf;
    private zzaby zzg = zzaby.f37363b;

    static {
        zzsk zzskVar = new zzsk();
        zzb = zzskVar;
        zzacz.h(zzsk.class, zzskVar);
    }

    public static zzsj q() {
        return (zzsj) zzb.k();
    }

    public static zzsk r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzsk) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    public static /* synthetic */ void v(zzsk zzskVar, zzsq zzsqVar) {
        zzsqVar.getClass();
        zzskVar.zzf = zzsqVar;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzsk();
        }
        if (i3 == 4) {
            return new zzsj(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzsq s() {
        zzsq zzsqVar = this.zzf;
        return zzsqVar == null ? zzsq.r() : zzsqVar;
    }

    public final zzaby t() {
        return this.zzg;
    }
}
