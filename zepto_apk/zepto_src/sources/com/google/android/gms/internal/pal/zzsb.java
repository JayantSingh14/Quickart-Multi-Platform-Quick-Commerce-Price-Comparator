package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzsb extends zzacz implements zzaeg {
    private static final zzsb zzb;
    private int zze;
    private zzsh zzf;
    private zzaby zzg = zzaby.f37363b;

    static {
        zzsb zzsbVar = new zzsb();
        zzb = zzsbVar;
        zzacz.h(zzsb.class, zzsbVar);
    }

    public static zzsa q() {
        return (zzsa) zzb.k();
    }

    public static zzsb r() {
        return zzb;
    }

    public static zzsb s(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzsb) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    public static /* synthetic */ void w(zzsb zzsbVar, zzsh zzshVar) {
        zzshVar.getClass();
        zzsbVar.zzf = zzshVar;
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
            return new zzsb();
        }
        if (i3 == 4) {
            return new zzsa(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzsh t() {
        zzsh zzshVar = this.zzf;
        return zzshVar == null ? zzsh.r() : zzshVar;
    }

    public final zzaby u() {
        return this.zzg;
    }
}
