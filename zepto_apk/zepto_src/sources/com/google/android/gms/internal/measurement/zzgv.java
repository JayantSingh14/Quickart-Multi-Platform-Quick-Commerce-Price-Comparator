package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzgv extends zzme implements zznm {
    private static final zzgv zzi;
    private int zzb;
    private int zzg;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzh = "";

    static {
        zzgv zzgvVar = new zzgv();
        zzi = zzgvVar;
        zzme.p(zzgv.class, zzgvVar);
    }

    public static zzgv u() {
        return zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i3 == 3) {
            return new zzgv();
        }
        if (i3 == 4) {
            return new zzgu(zzi);
        }
        if (i3 == 5) {
            return zzi;
        }
        throw null;
    }

    public final int s() {
        return this.zzg;
    }

    public final String t() {
        return this.zzh;
    }
}
