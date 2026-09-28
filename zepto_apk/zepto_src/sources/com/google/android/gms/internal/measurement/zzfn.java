package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzfn extends zzme implements zznm {
    private static final zzfn zzj;
    private int zzb;
    private int zzd;
    private String zze = "";
    private zzfh zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    static {
        zzfn zzfnVar = new zzfn();
        zzj = zzfnVar;
        zzme.p(zzfn.class, zzfnVar);
    }

    public static zzfm A() {
        return (zzfm) zzj.l();
    }

    public final /* synthetic */ void B(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i3 == 3) {
            return new zzfn();
        }
        if (i3 == 4) {
            return new zzfm(zzj);
        }
        if (i3 == 5) {
            return zzj;
        }
        throw null;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final int t() {
        return this.zzd;
    }

    public final String u() {
        return this.zze;
    }

    public final zzfh v() {
        zzfh zzfhVar = this.zzf;
        return zzfhVar == null ? zzfh.A() : zzfhVar;
    }

    public final boolean w() {
        return this.zzg;
    }

    public final boolean x() {
        return this.zzh;
    }

    public final boolean y() {
        return (this.zzb & 32) != 0;
    }

    public final boolean z() {
        return this.zzi;
    }
}
