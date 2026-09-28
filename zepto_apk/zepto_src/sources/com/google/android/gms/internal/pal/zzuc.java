package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzuc extends zzacz implements zzaeg {
    private static final zzuc zzb;
    private int zze;
    private zzuf zzf;
    private zzaby zzg = zzaby.f37363b;

    static {
        zzuc zzucVar = new zzuc();
        zzb = zzucVar;
        zzacz.h(zzuc.class, zzucVar);
    }

    public static zzub q() {
        return (zzub) zzb.k();
    }

    public static zzuc r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzuc) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzuc();
        }
        if (i3 == 4) {
            return new zzub(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzuf s() {
        zzuf zzufVar = this.zzf;
        return zzufVar == null ? zzuf.s() : zzufVar;
    }

    public final zzaby t() {
        return this.zzg;
    }
}
