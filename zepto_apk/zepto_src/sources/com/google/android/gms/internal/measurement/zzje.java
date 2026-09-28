package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzje extends zzme implements zznm {
    private static final zzje zzj;
    private int zzb;
    private int zzd;
    private zzmn zze = zznu.f37165e;
    private String zzf = "";
    private String zzg = "";
    private boolean zzh;
    private double zzi;

    static {
        zzje zzjeVar = new zzje();
        zzj = zzjeVar;
        zzme.p(zzje.class, zzjeVar);
    }

    public final int A() {
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
            return new zznv(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zzb", "zzd", zzjc.f36984a, "zze", zzje.class, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i3 == 3) {
            return new zzje();
        }
        if (i3 == 4) {
            return new zzjb(zzj);
        }
        if (i3 == 5) {
            return zzj;
        }
        throw null;
    }

    public final List s() {
        return this.zze;
    }

    public final String t() {
        return this.zzf;
    }

    public final boolean u() {
        return (this.zzb & 4) != 0;
    }

    public final String v() {
        return this.zzg;
    }

    public final boolean w() {
        return (this.zzb & 8) != 0;
    }

    public final boolean x() {
        return this.zzh;
    }

    public final boolean y() {
        return (this.zzb & 16) != 0;
    }

    public final double z() {
        return this.zzi;
    }
}
