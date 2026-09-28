package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzse extends zzacz implements zzaeg {
    private static final zzse zzb;
    private zzsh zze;
    private int zzf;

    static {
        zzse zzseVar = new zzse();
        zzb = zzseVar;
        zzacz.h(zzse.class, zzseVar);
    }

    public static zzsd q() {
        return (zzsd) zzb.k();
    }

    public static zzse r() {
        return zzb;
    }

    public static zzse s(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzse) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzse();
        }
        if (i3 == 4) {
            return new zzsd(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zzf;
    }

    public final zzsh t() {
        zzsh zzshVar = this.zze;
        return zzshVar == null ? zzsh.r() : zzshVar;
    }
}
