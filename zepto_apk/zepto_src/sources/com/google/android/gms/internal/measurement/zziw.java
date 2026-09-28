package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes4.dex */
public final class zziw extends zzme implements zznm {
    private static final zziw zzd;
    private zzmn zzb = zznu.f37165e;

    static {
        zziw zziwVar = new zziw();
        zzd = zziwVar;
        zzme.p(zziw.class, zziwVar);
    }

    public static zziw u() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zziy.class});
        }
        if (i3 == 3) {
            return new zziw();
        }
        if (i3 == 4) {
            return new zziv(zzd);
        }
        if (i3 == 5) {
            return zzd;
        }
        throw null;
    }

    public final List s() {
        return this.zzb;
    }

    public final int t() {
        return this.zzb.size();
    }
}
