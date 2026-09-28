package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzgr extends zzme implements zznm {
    private static final zzgr zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzgr zzgrVar = new zzgr();
        zzf = zzgrVar;
        zzme.p(zzgr.class, zzgrVar);
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
            return new zzgr();
        }
        if (i3 == 4) {
            return new zzgq(zzf);
        }
        if (i3 == 5) {
            return zzf;
        }
        throw null;
    }
}
