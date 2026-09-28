package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzgc extends zzme implements zznm {
    private static final zzgc zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzgc zzgcVar = new zzgc();
        zzf = zzgcVar;
        zzme.p(zzgc.class, zzgcVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i3 == 3) {
            return new zzgc();
        }
        if (i3 == 4) {
            return new zzgb(zzf);
        }
        if (i3 == 5) {
            return zzf;
        }
        throw null;
    }

    public final String s() {
        return this.zzd;
    }
}
