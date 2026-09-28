package com.google.android.gms.internal.measurement;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzms implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Map.Entry f37125a;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f37125a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zzmu) this.f37125a.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zznl)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        zzmu zzmuVar = (zzmu) this.f37125a.getValue();
        zznl zznlVar = zzmuVar.f37127a;
        zzmuVar.f37128b = null;
        zzmuVar.f37127a = (zznl) obj;
        return zznlVar;
    }
}
