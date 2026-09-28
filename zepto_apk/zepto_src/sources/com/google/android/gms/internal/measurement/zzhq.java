package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzhq extends zzme implements zznm {
    private static final zzhq zzf;
    private int zzb;
    private int zzd;
    private long zze;

    static {
        zzhq zzhqVar = new zzhq();
        zzf = zzhqVar;
        zzme.p(zzhq.class, zzhqVar);
    }

    public static zzhp w() {
        return (zzhp) zzf.l();
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i3 == 3) {
            return new zzhq();
        }
        if (i3 == 4) {
            return new zzhp(zzf);
        }
        if (i3 == 5) {
            return zzf;
        }
        throw null;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final int t() {
        return this.zzd;
    }

    public final boolean u() {
        return (this.zzb & 2) != 0;
    }

    public final long v() {
        return this.zze;
    }

    public final /* synthetic */ void x(int i2) {
        this.zzb |= 1;
        this.zzd = i2;
    }

    public final /* synthetic */ void y(long j2) {
        this.zzb |= 2;
        this.zze = j2;
    }
}
