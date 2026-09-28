package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzgt extends zzme implements zznm {
    private static final zzgt zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzgt zzgtVar = new zzgt();
        zzf = zzgtVar;
        zzme.p(zzgt.class, zzgtVar);
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
            return new zzgt();
        }
        if (i3 == 4) {
            return new zzgs(zzf);
        }
        if (i3 == 5) {
            return zzf;
        }
        throw null;
    }

    public final String s() {
        return this.zzd;
    }

    public final String t() {
        return this.zze;
    }
}
