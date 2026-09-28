package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzhg extends zzme implements zznm {
    private static final zzhg zzh;
    private int zzb;
    private int zzd;
    private zzii zze;
    private zzii zzf;
    private boolean zzg;

    static {
        zzhg zzhgVar = new zzhg();
        zzh = zzhgVar;
        zzme.p(zzhg.class, zzhgVar);
    }

    public static zzhf z() {
        return (zzhf) zzh.l();
    }

    public final /* synthetic */ void A(int i2) {
        this.zzb |= 1;
        this.zzd = i2;
    }

    public final /* synthetic */ void B(zzii zziiVar) {
        this.zze = zziiVar;
        this.zzb |= 2;
    }

    public final /* synthetic */ void C(zzii zziiVar) {
        this.zzf = zziiVar;
        this.zzb |= 4;
    }

    public final /* synthetic */ void D(boolean z) {
        this.zzb |= 8;
        this.zzg = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzhg();
        }
        if (i3 == 4) {
            return new zzhf();
        }
        if (i3 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final int t() {
        return this.zzd;
    }

    public final zzii u() {
        zzii zziiVar = this.zze;
        return zziiVar == null ? zzii.B() : zziiVar;
    }

    public final boolean v() {
        return (this.zzb & 4) != 0;
    }

    public final zzii w() {
        zzii zziiVar = this.zzf;
        return zziiVar == null ? zzii.B() : zziiVar;
    }

    public final boolean x() {
        return (this.zzb & 8) != 0;
    }

    public final boolean y() {
        return this.zzg;
    }
}
