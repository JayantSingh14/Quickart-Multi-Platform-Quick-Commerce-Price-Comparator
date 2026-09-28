package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgl extends zzgv {
    @Override // com.google.android.gms.internal.auth.zzgv
    public final void a() {
        if (!this.f36412d) {
            for (int i2 = 0; i2 < this.f36410b.size(); i2++) {
                Map.Entry entry = (Map.Entry) this.f36410b.get(i2);
                if (((zzep) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
            for (Map.Entry entry2 : this.f36411c.isEmpty() ? zzgo.f36399b : this.f36411c.entrySet()) {
                if (((zzep) entry2.getKey()).zzc()) {
                    entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                }
            }
        }
        super.a();
    }
}
