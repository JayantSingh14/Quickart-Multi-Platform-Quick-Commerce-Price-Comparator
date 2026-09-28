package com.google.android.gms.internal.atv_ads_framework;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzfb extends zzfl {
    @Override // com.google.android.gms.internal.atv_ads_framework.zzfl
    public final void a() {
        if (!this.f36198d) {
            for (int i2 = 0; i2 < this.f36196b.size(); i2++) {
                Map.Entry entry = (Map.Entry) this.f36196b.get(i2);
                if (((zzdb) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
            for (Map.Entry entry2 : this.f36197c.isEmpty() ? zzfe.f36185b : this.f36197c.entrySet()) {
                if (((zzdb) entry2.getKey()).zzc()) {
                    entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                }
            }
        }
        super.a();
    }
}
