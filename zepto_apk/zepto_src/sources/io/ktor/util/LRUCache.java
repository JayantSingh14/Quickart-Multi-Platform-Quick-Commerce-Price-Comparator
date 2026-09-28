package io.ktor.util;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class LRUCache<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f50485a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f50486b;

    /* renamed from: c, reason: collision with root package name */
    public final int f50487c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LRUCache(Function1 supplier, Function1 close, int i2) {
        super(10, 0.75f, true);
        Intrinsics.checkNotNullParameter(supplier, "supplier");
        Intrinsics.checkNotNullParameter(close, "close");
        this.f50485a = supplier;
        this.f50486b = close;
        this.f50487c = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (this.f50487c == 0) {
            return this.f50485a.invoke(obj);
        }
        synchronized (this) {
            Object obj2 = super.get(obj);
            if (obj2 != null) {
                return obj2;
            }
            Object objInvoke = this.f50485a.invoke(obj);
            put(obj, objInvoke);
            return objInvoke;
        }
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry eldest) {
        Intrinsics.checkNotNullParameter(eldest, "eldest");
        boolean z = super.size() > this.f50487c;
        if (z) {
            this.f50486b.invoke(eldest.getValue());
        }
        return z;
    }
}
