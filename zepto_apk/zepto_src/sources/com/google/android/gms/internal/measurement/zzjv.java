package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzjv extends ContentObserver {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjv(zzjx zzjxVar) {
        super(null);
        Objects.requireNonNull(zzjxVar);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzkl.f37033h.incrementAndGet();
    }
}
