package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzui extends zzacz implements zzaeg {
    private static final zzui zzb;
    private int zze;
    private int zzf;
    private zzaby zzg = zzaby.f37363b;

    static {
        zzui zzuiVar = new zzui();
        zzb = zzuiVar;
        zzacz.h(zzui.class, zzuiVar);
    }

    public static zzuh p() {
        return (zzuh) zzb.k();
    }

    public static zzui q() {
        return zzb;
    }

    public static void v(zzui zzuiVar) {
        zzuiVar.zze = 2;
    }

    public static void w(zzui zzuiVar) {
        zzuiVar.zzf = 3;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzui();
        }
        if (i3 == 4) {
            return new zzuh(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzaby r() {
        return this.zzg;
    }

    public final int t() {
        int i2 = this.zze;
        int i3 = i2 != 0 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? 0 : 7 : 6 : 5 : 4 : 2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public final int u() {
        int iA = zzum.a(this.zzf);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
