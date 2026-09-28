package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzho extends zzme implements zznm {
    private static final zzho zzd;
    private zzmn zzb = zznu.f37165e;

    static {
        zzho zzhoVar = new zzho();
        zzd = zzhoVar;
        zzme.p(zzho.class, zzhoVar);
    }

    public static zzhh t() {
        return (zzhh) zzd.l();
    }

    public static zzho u() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzhl.class});
        }
        if (i3 == 3) {
            return new zzho();
        }
        if (i3 == 4) {
            return new zzhh();
        }
        if (i3 == 5) {
            return zzd;
        }
        throw null;
    }

    public final List s() {
        return this.zzb;
    }

    public final void v(ArrayList arrayList) {
        zzmn zzmnVar = this.zzb;
        if (!zzmnVar.zza()) {
            int size = zzmnVar.size();
            this.zzb = zzmnVar.zzg(size + size);
        }
        zzkr.h(arrayList, this.zzb);
    }
}
