package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzto extends zzacz implements zzaeg {
    private static final zzto zzb;

    static {
        zzto zztoVar = new zzto();
        zzb = zztoVar;
        zzacz.h(zzto.class, zztoVar);
    }

    public static zzto p() {
        return zzb;
    }

    public static zzto q(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzto) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0000", null);
        }
        if (i3 == 3) {
            return new zzto();
        }
        if (i3 == 4) {
            return new zztn(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
