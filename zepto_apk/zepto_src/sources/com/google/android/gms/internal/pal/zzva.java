package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzva extends zzacz implements zzaeg {
    private static final zzva zzb;
    private zzvd zze;

    static {
        zzva zzvaVar = new zzva();
        zzb = zzvaVar;
        zzacz.h(zzva.class, zzvaVar);
    }

    public static zzuz p() {
        return (zzuz) zzb.k();
    }

    public static zzva q(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzva) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zze"});
        }
        if (i3 == 3) {
            return new zzva();
        }
        if (i3 == 4) {
            return new zzuz(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzvd r() {
        zzvd zzvdVar = this.zze;
        return zzvdVar == null ? zzvd.q() : zzvdVar;
    }
}
