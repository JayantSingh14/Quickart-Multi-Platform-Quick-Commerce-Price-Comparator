package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzfl extends zzme implements zznm {
    private static final zzfl zzi;
    private int zzb;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        zzfl zzflVar = new zzfl();
        zzi = zzflVar;
        zzme.p(zzfl.class, zzflVar);
    }

    public static zzfl B() {
        return zzi;
    }

    public final String A() {
        return this.zzh;
    }

    public final int C() {
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

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", zzfj.f36951a, "zze", "zzf", "zzg", "zzh"});
        }
        if (i3 == 3) {
            return new zzfl();
        }
        if (i3 == 4) {
            return new zzfi(zzi);
        }
        if (i3 == 5) {
            return zzi;
        }
        throw null;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final boolean t() {
        return (this.zzb & 2) != 0;
    }

    public final boolean u() {
        return this.zze;
    }

    public final boolean v() {
        return (this.zzb & 4) != 0;
    }

    public final String w() {
        return this.zzf;
    }

    public final boolean x() {
        return (this.zzb & 8) != 0;
    }

    public final String y() {
        return this.zzg;
    }

    public final boolean z() {
        return (this.zzb & 16) != 0;
    }
}
