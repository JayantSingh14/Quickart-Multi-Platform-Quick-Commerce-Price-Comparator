package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzuf extends zzacz implements zzaeg {
    private static final zzuf zzb;
    private int zze;
    private zztz zzf;
    private zzaby zzg;
    private zzaby zzh;

    static {
        zzuf zzufVar = new zzuf();
        zzb = zzufVar;
        zzacz.h(zzuf.class, zzufVar);
    }

    public zzuf() {
        zzaby zzabyVar = zzaby.f37363b;
        this.zzg = zzabyVar;
        this.zzh = zzabyVar;
    }

    public static zzue r() {
        return (zzue) zzb.k();
    }

    public static zzuf s() {
        return zzb;
    }

    public static zzuf t(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzuf) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    public static /* synthetic */ void x(zzuf zzufVar, zztz zztzVar) {
        zztzVar.getClass();
        zzufVar.zzf = zztzVar;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i3 == 3) {
            return new zzuf();
        }
        if (i3 == 4) {
            return new zzue(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zztz q() {
        zztz zztzVar = this.zzf;
        return zztzVar == null ? zztz.r() : zztzVar;
    }

    public final zzaby u() {
        return this.zzg;
    }

    public final zzaby v() {
        return this.zzh;
    }
}
