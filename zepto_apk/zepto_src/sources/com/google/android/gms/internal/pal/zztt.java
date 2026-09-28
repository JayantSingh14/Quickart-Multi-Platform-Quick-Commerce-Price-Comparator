package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zztt extends zzacz implements zzaeg {
    private static final zztt zzb;
    private zzvt zze;

    static {
        zztt zzttVar = new zztt();
        zzb = zzttVar;
        zzacz.h(zztt.class, zzttVar);
    }

    public static zzts p() {
        return (zzts) zzb.k();
    }

    public static zztt q() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zze"});
        }
        if (i3 == 3) {
            return new zztt();
        }
        if (i3 == 4) {
            return new zzts(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzvt r() {
        zzvt zzvtVar = this.zze;
        return zzvtVar == null ? zzvt.q() : zzvtVar;
    }
}
