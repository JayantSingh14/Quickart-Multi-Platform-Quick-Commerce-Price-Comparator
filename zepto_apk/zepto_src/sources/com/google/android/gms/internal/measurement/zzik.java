package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzik extends zzme implements zznm {
    private static final zzik zzf;
    private int zzb;
    private int zzd;
    private zzmm zze = zzmz.d();

    static {
        zzik zzikVar = new zzik();
        zzf = zzikVar;
        zzme.p(zzik.class, zzikVar);
    }

    public static zzij x() {
        return (zzij) zzf.l();
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i3 == 3) {
            return new zzik();
        }
        if (i3 == 4) {
            return new zzij(zzf);
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

    public final List u() {
        return this.zze;
    }

    public final int v() {
        return this.zze.size();
    }

    public final long w(int i2) {
        return this.zze.l(i2);
    }

    public final /* synthetic */ void y(int i2) {
        this.zzb |= 1;
        this.zzd = i2;
    }

    public final void z(List list) {
        zzmm zzmmVar = this.zze;
        if (!zzmmVar.zza()) {
            int size = zzmmVar.size();
            this.zze = zzmmVar.zzg(size + size);
        }
        zzkr.h(list, this.zze);
    }
}
