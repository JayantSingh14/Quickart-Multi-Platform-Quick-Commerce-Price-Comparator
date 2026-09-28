package com.google.android.gms.internal.pal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzaeu extends zzafe {
    @Override // com.google.android.gms.internal.pal.zzafe
    public final void a() {
        if (!this.f37485d) {
            for (int i2 = 0; i2 < this.f37483b.size(); i2++) {
                Map.Entry entry = (Map.Entry) this.f37483b.get(i2);
                if (((zzacq) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
            for (Map.Entry entry2 : this.f37484c.isEmpty() ? zzaex.f37472b : this.f37484c.entrySet()) {
                if (((zzacq) entry2.getKey()).zzc()) {
                    entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                }
            }
        }
        super.a();
    }
}
