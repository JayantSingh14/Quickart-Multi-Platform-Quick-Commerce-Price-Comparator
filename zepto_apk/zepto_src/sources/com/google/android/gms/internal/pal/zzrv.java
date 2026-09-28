package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzrv extends zzacz implements zzaeg {
    private static final zzrv zzb;
    private int zze;
    private zzsb zzf;
    private zzup zzg;

    static {
        zzrv zzrvVar = new zzrv();
        zzb = zzrvVar;
        zzacz.h(zzrv.class, zzrvVar);
    }

    public static zzru q() {
        return (zzru) zzb.k();
    }

    public static zzrv r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzrv) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    public static /* synthetic */ void w(zzrv zzrvVar, zzup zzupVar) {
        zzupVar.getClass();
        zzrvVar.zzg = zzupVar;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzrv();
        }
        if (i3 == 4) {
            return new zzru(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzsb s() {
        zzsb zzsbVar = this.zzf;
        return zzsbVar == null ? zzsb.r() : zzsbVar;
    }

    public final zzup t() {
        zzup zzupVar = this.zzg;
        return zzupVar == null ? zzup.r() : zzupVar;
    }
}
