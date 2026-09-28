package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzibj implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Map.Entry f34684a;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f34684a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zzibl) this.f34684a.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzicc)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        zzibl zziblVar = (zzibl) this.f34684a.getValue();
        zzicc zziccVar = zziblVar.f34686a;
        zziblVar.f34687b = null;
        zziblVar.f34686a = (zzicc) obj;
        return zziccVar;
    }
}
