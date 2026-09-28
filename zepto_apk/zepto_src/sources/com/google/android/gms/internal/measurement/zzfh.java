package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzfh extends zzme implements zznm {
    private static final zzfh zzh;
    private int zzb;
    private zzfr zzd;
    private zzfl zze;
    private boolean zzf;
    private String zzg = "";

    static {
        zzfh zzfhVar = new zzfh();
        zzh = zzfhVar;
        zzme.p(zzfh.class, zzfhVar);
    }

    public static zzfh A() {
        return zzh;
    }

    public final /* synthetic */ void B(String str) {
        this.zzb |= 8;
        this.zzg = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzfh();
        }
        if (i3 == 4) {
            return new zzfg(zzh);
        }
        if (i3 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final zzfr t() {
        zzfr zzfrVar = this.zzd;
        return zzfrVar == null ? zzfr.z() : zzfrVar;
    }

    public final boolean u() {
        return (this.zzb & 2) != 0;
    }

    public final zzfl v() {
        zzfl zzflVar = this.zze;
        return zzflVar == null ? zzfl.B() : zzflVar;
    }

    public final boolean w() {
        return (this.zzb & 4) != 0;
    }

    public final boolean x() {
        return this.zzf;
    }

    public final boolean y() {
        return (this.zzb & 8) != 0;
    }

    public final String z() {
        return this.zzg;
    }
}
