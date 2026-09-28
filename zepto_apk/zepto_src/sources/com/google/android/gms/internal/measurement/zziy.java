package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes4.dex */
public final class zziy extends zzme implements zznm {
    private static final zziy zzf;
    private int zzb;
    private String zzd = "";
    private zzmn zze = zznu.f37165e;

    static {
        zziy zziyVar = new zziy();
        zzf = zziyVar;
        zzme.p(zziy.class, zziyVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zzd", "zze", zzje.class});
        }
        if (i3 == 3) {
            return new zziy();
        }
        if (i3 == 4) {
            return new zzix(zzf);
        }
        if (i3 == 5) {
            return zzf;
        }
        throw null;
    }

    public final String s() {
        return this.zzd;
    }

    public final List t() {
        return this.zze;
    }
}
