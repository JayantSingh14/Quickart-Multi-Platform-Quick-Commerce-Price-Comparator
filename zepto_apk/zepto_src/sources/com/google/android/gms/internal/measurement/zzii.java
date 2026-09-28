package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzii extends zzme implements zznm {
    private static final zzii zzg;
    private zzmm zzb = zzmz.d();
    private zzmm zzd = zzmz.d();
    private zzmn zze;
    private zzmn zzf;

    static {
        zzii zziiVar = new zzii();
        zzg = zziiVar;
        zzme.p(zzii.class, zziiVar);
    }

    public zzii() {
        zznu zznuVar = zznu.f37165e;
        this.zze = zznuVar;
        this.zzf = zznuVar;
    }

    public static zzih A() {
        return (zzih) zzg.l();
    }

    public static zzii B() {
        return zzg;
    }

    public final void C(List list) {
        zzmm zzmmVar = this.zzb;
        if (!zzmmVar.zza()) {
            int size = zzmmVar.size();
            this.zzb = zzmmVar.zzg(size + size);
        }
        zzkr.h(list, this.zzb);
    }

    public final void D() {
        this.zzb = zzmz.d();
    }

    public final void E(List list) {
        zzmm zzmmVar = this.zzd;
        if (!zzmmVar.zza()) {
            int size = zzmmVar.size();
            this.zzd = zzmmVar.zzg(size + size);
        }
        zzkr.h(list, this.zzd);
    }

    public final void F() {
        this.zzd = zzmz.d();
    }

    public final void G(ArrayList arrayList) {
        zzmn zzmnVar = this.zze;
        if (!zzmnVar.zza()) {
            int size = zzmnVar.size();
            this.zze = zzmnVar.zzg(size + size);
        }
        zzkr.h(arrayList, this.zze);
    }

    public final void H() {
        this.zze = zznu.f37165e;
    }

    public final void I(List list) {
        zzmn zzmnVar = this.zzf;
        if (!zzmnVar.zza()) {
            int size = zzmnVar.size();
            this.zzf = zzmnVar.zzg(size + size);
        }
        zzkr.h(list, this.zzf);
    }

    public final void J() {
        this.zzf = zznu.f37165e;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzg, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzb", "zzd", "zze", zzhq.class, "zzf", zzik.class});
        }
        if (i3 == 3) {
            return new zzii();
        }
        if (i3 == 4) {
            return new zzih();
        }
        if (i3 == 5) {
            return zzg;
        }
        throw null;
    }

    public final List s() {
        return this.zzb;
    }

    public final int t() {
        return this.zzb.size();
    }

    public final List u() {
        return this.zzd;
    }

    public final int v() {
        return this.zzd.size();
    }

    public final zzmn w() {
        return this.zze;
    }

    public final int x() {
        return this.zze.size();
    }

    public final List y() {
        return this.zzf;
    }

    public final int z() {
        return this.zzf.size();
    }
}
