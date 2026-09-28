package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzwa extends zzacz implements zzaeg {
    private static final zzwa zzb;
    private zzvo zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzwa zzwaVar = new zzwa();
        zzb = zzwaVar;
        zzacz.h(zzwa.class, zzwaVar);
    }

    public static zzvz r() {
        return (zzvz) zzb.k();
    }

    public static void y(zzwa zzwaVar, int i2) {
        if (i2 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzwaVar.zzf = i2 - 2;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i3 == 3) {
            return new zzwa();
        }
        if (i3 == 4) {
            return new zzvz(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zzg;
    }

    public final zzvo q() {
        zzvo zzvoVar = this.zze;
        return zzvoVar == null ? zzvo.r() : zzvoVar;
    }

    public final boolean u() {
        return this.zze != null;
    }

    public final int v() {
        int i2 = this.zzf;
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? 0 : 5 : 4 : 3 : 2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public final int w() {
        int i2 = this.zzh;
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? 0 : 6 : 5 : 4 : 3 : 2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }
}
