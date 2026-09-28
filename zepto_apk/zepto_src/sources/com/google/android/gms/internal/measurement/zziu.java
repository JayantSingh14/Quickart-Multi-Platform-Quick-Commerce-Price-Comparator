package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zziu extends zzme implements zznm {
    private static final zziu zzj;
    private int zzb;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    static {
        zziu zziuVar = new zziu();
        zzj = zziuVar;
        zzme.p(zziu.class, zziuVar);
    }

    public static zzit D() {
        return (zzit) zzj.l();
    }

    public final float A() {
        return this.zzh;
    }

    public final boolean B() {
        return (this.zzb & 32) != 0;
    }

    public final double C() {
        return this.zzi;
    }

    public final /* synthetic */ void E(long j2) {
        this.zzb |= 1;
        this.zzd = j2;
    }

    public final /* synthetic */ void F(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void G(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzf = str;
    }

    public final /* synthetic */ void H() {
        this.zzb &= -5;
        this.zzf = zzj.zzf;
    }

    public final /* synthetic */ void I(long j2) {
        this.zzb |= 8;
        this.zzg = j2;
    }

    public final /* synthetic */ void J() {
        this.zzb &= -9;
        this.zzg = 0L;
    }

    public final /* synthetic */ void K(double d2) {
        this.zzb |= 32;
        this.zzi = d2;
    }

    public final /* synthetic */ void L() {
        this.zzb &= -33;
        this.zzi = 0.0d;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i3 == 3) {
            return new zziu();
        }
        if (i3 == 4) {
            return new zzit(zzj);
        }
        if (i3 == 5) {
            return zzj;
        }
        throw null;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final long t() {
        return this.zzd;
    }

    public final String u() {
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

    public final long y() {
        return this.zzg;
    }

    public final boolean z() {
        return (this.zzb & 16) != 0;
    }
}
