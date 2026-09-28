package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class AttributeKey<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f50418a;

    public AttributeKey(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f50418a = name;
        if (name.length() == 0) {
            throw new IllegalStateException("Name can't be blank");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && AttributeKey.class == obj.getClass() && Intrinsics.b(this.f50418a, ((AttributeKey) obj).f50418a);
    }

    public final int hashCode() {
        return this.f50418a.hashCode();
    }

    public final String toString() {
        return "AttributeKey: " + this.f50418a;
    }
}
