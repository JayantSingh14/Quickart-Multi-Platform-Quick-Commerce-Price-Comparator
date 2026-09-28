package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzgn extends zzme implements zznm {
    private static final zzgn zzd;
    private zzmn zzb = zznu.f37165e;

    static {
        zzgn zzgnVar = new zzgn();
        zzd = zzgnVar;
        zzme.p(zzgn.class, zzgnVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        }
        if (i3 == 3) {
            return new zzgn();
        }
        if (i3 == 4) {
            return new zzgm(zzd);
        }
        if (i3 == 5) {
            return zzd;
        }
        throw null;
    }
}
