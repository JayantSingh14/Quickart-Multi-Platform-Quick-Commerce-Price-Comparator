package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzwm extends zzacz implements zzaeg {
    private static final zzwm zzb;
    private String zze = "";

    static {
        zzwm zzwmVar = new zzwm();
        zzb = zzwmVar;
        zzacz.h(zzwm.class, zzwmVar);
    }

    public static zzwm p() {
        return zzb;
    }

    public static zzwm q(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzwm) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
        }
        if (i3 == 3) {
            return new zzwm();
        }
        if (i3 == 4) {
            return new zzwl(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final String r() {
        return this.zze;
    }
}
