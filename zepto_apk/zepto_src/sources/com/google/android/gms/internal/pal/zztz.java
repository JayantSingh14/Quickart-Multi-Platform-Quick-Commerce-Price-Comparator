package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zztz extends zzacz implements zzaeg {
    private static final zztz zzb;
    private zzui zze;
    private zztt zzf;
    private int zzg;

    static {
        zztz zztzVar = new zztz();
        zzb = zztzVar;
        zzacz.h(zztz.class, zztzVar);
    }

    public static zzty q() {
        return (zzty) zzb.k();
    }

    public static zztz r() {
        return zzb;
    }

    public static void w(zztz zztzVar, int i2) {
        if (i2 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zztzVar.zzg = i2 - 2;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zztz();
        }
        if (i3 == 4) {
            return new zzty(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zztt p() {
        zztt zzttVar = this.zzf;
        return zzttVar == null ? zztt.q() : zzttVar;
    }

    public final zzui s() {
        zzui zzuiVar = this.zze;
        return zzuiVar == null ? zzui.q() : zzuiVar;
    }

    public final int v() {
        int i2 = this.zzg;
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? 0 : 5 : 4 : 3 : 2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }
}
