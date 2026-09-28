package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzvg extends zzacz implements zzaeg {
    private static final zzvg zzb;
    private int zze;
    private zzvj zzf;
    private zzaby zzg = zzaby.f37363b;

    static {
        zzvg zzvgVar = new zzvg();
        zzb = zzvgVar;
        zzacz.h(zzvg.class, zzvgVar);
    }

    public static zzvf q() {
        return (zzvf) zzb.k();
    }

    public static zzvg r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzvg) zzacz.m(zzb, zzabyVar, zzacmVar);
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
            return new zzvg();
        }
        if (i3 == 4) {
            return new zzvf(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzvj s() {
        zzvj zzvjVar = this.zzf;
        return zzvjVar == null ? zzvj.s() : zzvjVar;
    }

    public final zzaby t() {
        return this.zzg;
    }

    public final boolean x() {
        return this.zzf != null;
    }
}
