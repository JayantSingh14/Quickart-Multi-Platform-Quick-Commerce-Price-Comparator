package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzrp extends zzacz implements zzaeg {
    private static final zzrp zzb;
    private int zze;
    private zzrs zzf;

    static {
        zzrp zzrpVar = new zzrp();
        zzb = zzrpVar;
        zzacz.h(zzrp.class, zzrpVar);
    }

    public static zzro q() {
        return (zzro) zzb.k();
    }

    public static zzrp r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzrp) zzacz.m(zzb, zzabyVar, zzacmVar);
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
            return new zzrp();
        }
        if (i3 == 4) {
            return new zzro(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzrs s() {
        zzrs zzrsVar = this.zzf;
        return zzrsVar == null ? zzrs.r() : zzrsVar;
    }
}
