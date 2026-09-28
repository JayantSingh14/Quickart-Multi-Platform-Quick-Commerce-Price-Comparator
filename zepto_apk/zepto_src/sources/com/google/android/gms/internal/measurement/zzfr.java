package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzfr extends zzme implements zznm {
    private static final zzfr zzh;
    private int zzb;
    private int zzd;
    private boolean zzf;
    private String zze = "";
    private zzmn zzg = zznu.f37165e;

    static {
        zzfr zzfrVar = new zzfr();
        zzh = zzfrVar;
        zzme.p(zzfr.class, zzfrVar);
    }

    public static zzfr z() {
        return zzh;
    }

    public final int A() {
        int i2;
        switch (this.zzd) {
            case 0:
                i2 = 1;
                break;
            case 1:
                i2 = 2;
                break;
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
                i2 = 5;
                break;
            case 5:
                i2 = 6;
                break;
            case 6:
                i2 = 7;
                break;
            default:
                i2 = 0;
                break;
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
            return new zznv(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzb", "zzd", zzfp.f36952a, "zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzfr();
        }
        if (i3 == 4) {
            return new zzfo(zzh);
        }
        if (i3 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final boolean t() {
        return (this.zzb & 2) != 0;
    }

    public final String u() {
        return this.zze;
    }

    public final boolean v() {
        return (this.zzb & 4) != 0;
    }

    public final boolean w() {
        return this.zzf;
    }

    public final zzmn x() {
        return this.zzg;
    }

    public final int y() {
        return this.zzg.size();
    }
}
