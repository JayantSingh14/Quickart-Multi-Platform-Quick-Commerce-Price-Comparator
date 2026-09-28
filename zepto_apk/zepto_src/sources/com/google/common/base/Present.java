package com.google.common.base;

import android.support.v4.media.b;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.FluentIterable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
final class Present<T> extends Optional<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f42294a;

    public Present(Object obj) {
        this.f42294a = obj;
    }

    @Override // com.google.common.base.Optional
    public final Object b() {
        return this.f42294a;
    }

    @Override // com.google.common.base.Optional
    public final boolean c() {
        return true;
    }

    @Override // com.google.common.base.Optional
    public final Object e(FluentIterable fluentIterable) {
        return this.f42294a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.f42294a.equals(((Present) obj).f42294a);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public final Object f() {
        return this.f42294a;
    }

    public final int hashCode() {
        return this.f42294a.hashCode() + 1502476572;
    }

    public final String toString() {
        return b.q(new StringBuilder("Optional.of("), this.f42294a, ")");
    }
}
