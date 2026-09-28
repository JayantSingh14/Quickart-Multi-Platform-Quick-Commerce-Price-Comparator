package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzicx extends zzidb {
    @Override // com.google.android.gms.internal.ads.zzidb
    public final void a() {
        if (!this.f34757d) {
            for (int i2 = 0; i2 < this.f34755b; i2++) {
                ((zziaf) ((zzicy) b(i2)).f34744a).getClass();
            }
            Iterator it = c().iterator();
            while (it.hasNext()) {
                ((zziaf) ((Map.Entry) it.next()).getKey()).getClass();
            }
        }
        super.a();
    }
}
