package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzfw extends zzme implements zznm {
    private static final zzfw zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        zzfw zzfwVar = new zzfw();
        zzf = zzfwVar;
        zzme.p(zzfw.class, zzfwVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            zzmj zzmjVar = zzfz.f36954a;
            return new zznv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", zzmjVar, "zze", zzmjVar});
        }
        if (i3 == 3) {
            return new zzfw();
        }
        if (i3 == 4) {
            return new zzfv(zzf);
        }
        if (i3 == 5) {
            return zzf;
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
        int iA = zzga.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
