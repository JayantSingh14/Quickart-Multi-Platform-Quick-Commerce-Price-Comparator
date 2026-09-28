package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.FluentIterable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
final class Absent<T> extends Optional<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final Absent f42226a = new Absent();

    @Override // com.google.common.base.Optional
    public final Object b() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public final boolean c() {
        return false;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.common.base.Optional
    public final Object f() {
        return null;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.common.base.Optional
    public final Object e(FluentIterable fluentIterable) {
        return fluentIterable;
    }
}
