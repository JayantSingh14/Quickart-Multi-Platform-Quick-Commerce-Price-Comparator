package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzja extends zzme implements zznm {
    private static final zzja zzf;
    private int zzb;
    private zzmn zzd = zznu.f37165e;
    private zziw zze;

    static {
        zzja zzjaVar = new zzja();
        zzf = zzjaVar;
        zzme.p(zzja.class, zzjaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zzd", zzje.class, "zze"});
        }
        if (i3 == 3) {
            return new zzja();
        }
        if (i3 == 4) {
            return new zziz(zzf);
        }
        if (i3 == 5) {
            return zzf;
        }
        throw null;
    }

    public final List s() {
        return this.zzd;
    }

    public final zziw t() {
        zziw zziwVar = this.zze;
        return zziwVar == null ? zziw.u() : zziwVar;
    }
}
