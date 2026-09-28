package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzgf extends zzme implements zznm {
    private static final zzgf zzi;
    private int zzb;
    private zzmn zzd;
    private zzmn zze;
    private zzmn zzf;
    private boolean zzg;
    private zzmn zzh;

    static {
        zzgf zzgfVar = new zzgf();
        zzi = zzgfVar;
        zzme.p(zzgf.class, zzgfVar);
    }

    public zzgf() {
        zznu zznuVar = zznu.f37165e;
        this.zzd = zznuVar;
        this.zze = zznuVar;
        this.zzf = zznuVar;
        this.zzh = zznuVar;
    }

    public static zzgf y() {
        return zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zzb", "zzd", zzfu.class, "zze", zzfw.class, "zzf", zzgc.class, "zzg", "zzh", zzfu.class});
        }
        if (i3 == 3) {
            return new zzgf();
        }
        if (i3 == 4) {
            return new zzfs(zzi);
        }
        if (i3 == 5) {
            return zzi;
        }
        throw null;
    }

    public final List s() {
        return this.zzd;
    }

    public final List t() {
        return this.zze;
    }

    public final List u() {
        return this.zzf;
    }

    public final boolean v() {
        return (this.zzb & 1) != 0;
    }

    public final boolean w() {
        return this.zzg;
    }

    public final zzmn x() {
        return this.zzh;
    }
}
