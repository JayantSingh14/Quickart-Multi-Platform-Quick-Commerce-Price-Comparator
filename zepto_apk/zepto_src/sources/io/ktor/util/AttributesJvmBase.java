package io.ktor.util;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
abstract class AttributesJvmBase implements Attributes {
    @Override // io.ktor.util.Attributes
    public final Object a(AttributeKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object objF = f(key);
        if (objF != null) {
            return objF;
        }
        throw new IllegalStateException("No instance for key " + key);
    }

    @Override // io.ktor.util.Attributes
    public final void b(AttributeKey key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        h().put(key, value);
    }

    @Override // io.ktor.util.Attributes
    public final List c() {
        return kotlin.collections.CollectionsKt.e0(h().keySet());
    }

    @Override // io.ktor.util.Attributes
    public final void d(AttributeKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        h().remove(key);
    }

    @Override // io.ktor.util.Attributes
    public final boolean e(AttributeKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return h().containsKey(key);
    }

    @Override // io.ktor.util.Attributes
    public final Object f(AttributeKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return h().get(key);
    }

    public abstract Map h();
}
