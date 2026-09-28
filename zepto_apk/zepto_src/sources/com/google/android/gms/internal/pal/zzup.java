package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzup extends zzacz implements zzaeg {
    private static final zzup zzb;
    private int zze;
    private zzuv zzf;
    private zzaby zzg = zzaby.f37363b;

    static {
        zzup zzupVar = new zzup();
        zzb = zzupVar;
        zzacz.h(zzup.class, zzupVar);
    }

    public static zzuo q() {
        return (zzuo) zzb.k();
    }

    public static zzup r() {
        return zzb;
    }

    public static zzup s(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzup) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    public static /* synthetic */ void w(zzup zzupVar, zzuv zzuvVar) {
        zzuvVar.getClass();
        zzupVar.zzf = zzuvVar;
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
            return new zzup();
        }
        if (i3 == 4) {
            return new zzuo(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzuv t() {
        zzuv zzuvVar = this.zzf;
        return zzuvVar == null ? zzuv.r() : zzuvVar;
    }

    public final zzaby u() {
        return this.zzg;
    }
}
