package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzhl extends zzme implements zznm {
    private static final zzhl zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        zzhl zzhlVar = new zzhl();
        zzf = zzhlVar;
        zzme.p(zzhl.class, zzhlVar);
    }

    public static zzhk s() {
        return (zzhk) zzf.l();
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", zzhi.f36963a, "zze", zzhm.f36964a});
        }
        if (i3 == 3) {
            return new zzhl();
        }
        if (i3 == 4) {
            return new zzhk(zzf);
        }
        if (i3 == 5) {
            return zzf;
        }
        throw null;
    }

    public final int t() {
        int i2;
        int i3 = this.zzd;
        if (i3 != 0) {
            i2 = 2;
            if (i3 != 1) {
                if (i3 != 2) {
                    i2 = 4;
                    if (i3 != 3) {
                        i2 = i3 != 4 ? 0 : 5;
                    }
                } else {
                    i2 = 3;
                }
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

    public final /* synthetic */ void v(int i2) {
        this.zzd = i2 - 1;
        this.zzb |= 1;
    }

    public final /* synthetic */ void w(int i2) {
        this.zze = i2 - 1;
        this.zzb |= 2;
    }
}
