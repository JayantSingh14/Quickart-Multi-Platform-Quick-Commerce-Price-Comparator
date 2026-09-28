package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzvo extends zzacz implements zzaeg {
    private static final zzvo zzb;
    private String zze = "";
    private zzaby zzf = zzaby.f37363b;
    private int zzg;

    static {
        zzvo zzvoVar = new zzvo();
        zzb = zzvoVar;
        zzacz.h(zzvo.class, zzvoVar);
    }

    public static zzvl p() {
        return (zzvl) zzb.k();
    }

    public static zzvo r() {
        return zzb;
    }

    public static /* synthetic */ void u(zzvo zzvoVar, String str) {
        str.getClass();
        zzvoVar.zze = str;
    }

    public static void w(zzvo zzvoVar, zzvn zzvnVar) {
        if (zzvnVar != zzvn.UNRECOGNIZED) {
            zzvoVar.zzg = zzvnVar.f38092a;
        } else {
            zzvnVar.getClass();
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzvo();
        }
        if (i3 == 4) {
            return new zzvl(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzvn q() {
        int i2 = this.zzg;
        zzvn zzvnVar = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : zzvn.REMOTE : zzvn.ASYMMETRIC_PUBLIC : zzvn.ASYMMETRIC_PRIVATE : zzvn.SYMMETRIC : zzvn.UNKNOWN_KEYMATERIAL;
        return zzvnVar == null ? zzvn.UNRECOGNIZED : zzvnVar;
    }

    public final zzaby s() {
        return this.zzf;
    }

    public final String t() {
        return this.zze;
    }
}
