package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzfd extends zzme implements zznm {
    private static final zzfd zzi;
    private int zzb;
    private int zzd;
    private zzmn zze;
    private zzmn zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        zzfd zzfdVar = new zzfd();
        zzi = zzfdVar;
        zzme.p(zzfd.class, zzfdVar);
    }

    public zzfd() {
        zznu zznuVar = zznu.f37165e;
        this.zze = zznuVar;
        this.zzf = zznuVar;
    }

    public final void A(int i2, zzfn zzfnVar) {
        zzmn zzmnVar = this.zze;
        if (!zzmnVar.zza()) {
            int size = zzmnVar.size();
            this.zze = zzmnVar.zzg(size + size);
        }
        this.zze.set(i2, zzfnVar);
    }

    public final void B(int i2, zzff zzffVar) {
        zzmn zzmnVar = this.zzf;
        if (!zzmnVar.zza()) {
            int size = zzmnVar.size();
            this.zzf = zzmnVar.zzg(size + size);
        }
        this.zzf.set(i2, zzffVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzb", "zzd", "zze", zzfn.class, "zzf", zzff.class, "zzg", "zzh"});
        }
        if (i3 == 3) {
            return new zzfd();
        }
        if (i3 == 4) {
            return new zzfc(zzi);
        }
        if (i3 == 5) {
            return zzi;
        }
        throw null;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final int t() {
        return this.zzd;
    }

    public final List u() {
        return this.zze;
    }

    public final int v() {
        return this.zze.size();
    }

    public final zzfn w(int i2) {
        return (zzfn) this.zze.get(i2);
    }

    public final zzmn x() {
        return this.zzf;
    }

    public final int y() {
        return this.zzf.size();
    }

    public final zzff z(int i2) {
        return (zzff) this.zzf.get(i2);
    }
}
