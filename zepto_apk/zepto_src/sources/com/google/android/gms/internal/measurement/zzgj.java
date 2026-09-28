package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzgj extends zzme implements zznm {
    private static final zzgj zzh;
    private int zzb;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        zzgj zzgjVar = new zzgj();
        zzh = zzgjVar;
        zzme.p(zzgj.class, zzgjVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzgj();
        }
        if (i3 == 4) {
            return new zzgi(zzh);
        }
        if (i3 == 5) {
            return zzh;
        }
        throw null;
    }

    public final String s() {
        return this.zzd;
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

    public final boolean w() {
        return this.zzf;
    }

    public final boolean x() {
        return (this.zzb & 8) != 0;
    }

    public final int y() {
        return this.zzg;
    }

    public final /* synthetic */ void z(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }
}
