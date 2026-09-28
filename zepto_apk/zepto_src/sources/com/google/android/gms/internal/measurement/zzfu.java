package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzfu extends zzme implements zznm {
    private static final zzfu zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzfu zzfuVar = new zzfu();
        zzg = zzfuVar;
        zzme.p(zzfu.class, zzfuVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", zzfz.f36954a, "zze", zzfx.f36953a, "zzf", zzgd.f36959a});
        }
        if (i3 == 3) {
            return new zzfu();
        }
        if (i3 == 4) {
            return new zzft(zzg);
        }
        if (i3 == 5) {
            return zzg;
        }
        throw null;
    }

    public final int s() {
        int iA = zzga.a(this.zzd);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    public final int t() {
        int i2;
        int i3 = this.zze;
        if (i3 != 0) {
            i2 = 2;
            if (i3 != 1) {
                i2 = i3 != 2 ? 0 : 3;
            }
        } else {
            i2 = 1;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    public final int u() {
        int i2;
        int i3 = this.zzf;
        if (i3 != 0) {
            i2 = 2;
            if (i3 != 1) {
                i2 = i3 != 2 ? 0 : 3;
            }
        } else {
            i2 = 1;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
