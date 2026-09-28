package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zznz extends zzod {
    @Override // com.google.android.gms.internal.measurement.zzod
    public final void a() {
        if (!this.f37184d) {
            if (this.f37182b > 0) {
                ((zzlu) ((zzoa) b(0)).f37173a).zzd();
                throw null;
            }
            Iterator it = c().iterator();
            if (it.hasNext()) {
                ((zzlu) ((Map.Entry) it.next()).getKey()).zzd();
                throw null;
            }
        }
        super.a();
    }
}
