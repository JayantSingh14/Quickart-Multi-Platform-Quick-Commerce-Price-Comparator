package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzvj extends zzacz implements zzaeg {
    private static final zzvj zzb;
    private int zze;
    private zzvd zzf;
    private zzaby zzg = zzaby.f37363b;

    static {
        zzvj zzvjVar = new zzvj();
        zzb = zzvjVar;
        zzacz.h(zzvj.class, zzvjVar);
    }

    public static zzvi r() {
        return (zzvi) zzb.k();
    }

    public static zzvj s() {
        return zzb;
    }

    public static zzvj t(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzvj) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    public static /* synthetic */ void w(zzvj zzvjVar, zzvd zzvdVar) {
        zzvdVar.getClass();
        zzvjVar.zzf = zzvdVar;
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
            return new zzvj();
        }
        if (i3 == 4) {
            return new zzvi(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzvd q() {
        zzvd zzvdVar = this.zzf;
        return zzvdVar == null ? zzvd.q() : zzvdVar;
    }

    public final zzaby u() {
        return this.zzg;
    }

    public final boolean y() {
        return this.zzf != null;
    }
}
