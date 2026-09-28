package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzgh extends zzme implements zznm {
    private static final zzgh zzg;
    private int zzb;
    private String zzd = "";
    private zzmn zze = zznu.f37165e;
    private boolean zzf;

    static {
        zzgh zzghVar = new zzgh();
        zzg = zzghVar;
        zzme.p(zzgh.class, zzghVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzb", "zzd", "zze", zzgr.class, "zzf"});
        }
        if (i3 == 3) {
            return new zzgh();
        }
        if (i3 == 4) {
            return new zzgg(zzg);
        }
        if (i3 == 5) {
            return zzg;
        }
        throw null;
    }

    public final String s() {
        return this.zzd;
    }
}
