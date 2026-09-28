package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzwj extends zzacz implements zzaeg {
    private static final zzwj zzb;
    private int zze;
    private zzwm zzf;

    static {
        zzwj zzwjVar = new zzwj();
        zzb = zzwjVar;
        zzacz.h(zzwj.class, zzwjVar);
    }

    public static zzwi q() {
        return (zzwi) zzb.k();
    }

    public static zzwj r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzwj) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    public static /* synthetic */ void u(zzwj zzwjVar, zzwm zzwmVar) {
        zzwmVar.getClass();
        zzwjVar.zzf = zzwmVar;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzwj();
        }
        if (i3 == 4) {
            return new zzwi(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzwm s() {
        zzwm zzwmVar = this.zzf;
        return zzwmVar == null ? zzwm.p() : zzwmVar;
    }
}
