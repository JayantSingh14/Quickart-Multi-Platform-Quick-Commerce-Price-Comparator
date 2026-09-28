package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzxa extends zzacz implements zzaeg {
    private static final zzxa zzb;
    private int zze;
    private zzaby zzf = zzaby.f37363b;

    static {
        zzxa zzxaVar = new zzxa();
        zzb = zzxaVar;
        zzacz.h(zzxa.class, zzxaVar);
    }

    public static zzwz q() {
        return (zzwz) zzb.k();
    }

    public static zzxa r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzxa) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzxa();
        }
        if (i3 == 4) {
            return new zzwz(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzaby s() {
        return this.zzf;
    }
}
