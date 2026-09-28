package com.google.android.gms.internal.ads;

import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes4.dex */
final class zzgya extends zzgxo {
    public zzgxy p;

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final void k() {
        zzgxy zzgxyVar = this.p;
        if (zzgxyVar != null) {
            zzgxyVar.g();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxo
    public final void s(int i2) {
        this.f33350l = null;
        if (i2 == 1) {
            this.p = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxo
    public final void x(int i2, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzgxo
    public final void y() {
        zzgxy zzgxyVar = this.p;
        if (zzgxyVar != null) {
            try {
                zzgxyVar.f33361c.execute(zzgxyVar);
            } catch (RejectedExecutionException e2) {
                zzgxyVar.f33362d.d(e2);
            }
        }
    }
}
