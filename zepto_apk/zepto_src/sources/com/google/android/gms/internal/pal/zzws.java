package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzws extends zzacz implements zzaeg {
    private static final zzws zzb;
    private String zze = "";
    private zzvt zzf;

    static {
        zzws zzwsVar = new zzws();
        zzb = zzwsVar;
        zzacz.h(zzws.class, zzwsVar);
    }

    public static zzws q() {
        return zzb;
    }

    public static zzws r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzws) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzws();
        }
        if (i3 == 4) {
            return new zzwr(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzvt p() {
        zzvt zzvtVar = this.zzf;
        return zzvtVar == null ? zzvt.q() : zzvtVar;
    }

    public final String s() {
        return this.zze;
    }

    public final boolean t() {
        return this.zzf != null;
    }
}
