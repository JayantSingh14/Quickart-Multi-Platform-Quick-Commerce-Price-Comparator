package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes4.dex */
abstract class zzgxx extends zzgxo {
    public List p;

    @Override // com.google.android.gms.internal.ads.zzgxo
    public final void s(int i2) {
        this.f33350l = null;
        this.p = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgxo
    public final void x(int i2, Object obj) {
        List list = this.p;
        if (list != null) {
            list.set(i2, new zzgxw(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxo
    public final void y() {
        List list = this.p;
        if (list != null) {
            c(z(list));
        }
    }

    public abstract List z(List list);
}
