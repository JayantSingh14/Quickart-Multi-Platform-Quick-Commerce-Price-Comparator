package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzff extends zzme implements zznm {
    private static final zzff zzl;
    private int zzb;
    private int zzd;
    private String zze = "";
    private zzmn zzf = zznu.f37165e;
    private boolean zzg;
    private zzfl zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        zzff zzffVar = new zzff();
        zzl = zzffVar;
        zzme.p(zzff.class, zzffVar);
    }

    public static zzfe E() {
        return (zzfe) zzl.l();
    }

    public final boolean A() {
        return this.zzi;
    }

    public final boolean B() {
        return this.zzj;
    }

    public final boolean C() {
        return (this.zzb & 64) != 0;
    }

    public final boolean D() {
        return this.zzk;
    }

    public final /* synthetic */ void F(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    public final void G(int i2, zzfh zzfhVar) {
        zzmn zzmnVar = this.zzf;
        if (!zzmnVar.zza()) {
            int size = zzmnVar.size();
            this.zzf = zzmnVar.zzg(size + size);
        }
        this.zzf.set(i2, zzfhVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzl, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", zzfh.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i3 == 3) {
            return new zzff();
        }
        if (i3 == 4) {
            return new zzfe(zzl);
        }
        if (i3 == 5) {
            return zzl;
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

    public final List v() {
        return this.zzf;
    }

    public final int w() {
        return this.zzf.size();
    }

    public final zzfh x(int i2) {
        return (zzfh) this.zzf.get(i2);
    }

    public final boolean y() {
        return (this.zzb & 8) != 0;
    }

    public final zzfl z() {
        zzfl zzflVar = this.zzh;
        return zzflVar == null ? zzfl.B() : zzflVar;
    }
}
