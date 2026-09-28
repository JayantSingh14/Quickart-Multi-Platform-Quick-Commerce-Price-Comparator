package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzig extends zzme implements zznm {
    private static final zzig zzf;
    private int zzb;
    private int zzd = 1;
    private zzmn zze = zznu.f37165e;

    static {
        zzig zzigVar = new zzig();
        zzf = zzigVar;
        zzme.p(zzig.class, zzigVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzb", "zzd", zzif.f36966a, "zze", zzhu.class});
        }
        if (i3 == 3) {
            return new zzig();
        }
        if (i3 == 4) {
            return new zzie();
        }
        if (i3 == 5) {
            return zzf;
        }
        throw null;
    }
}
