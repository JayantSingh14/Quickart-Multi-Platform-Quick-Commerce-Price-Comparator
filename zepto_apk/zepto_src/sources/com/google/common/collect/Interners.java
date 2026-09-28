package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Interners {

    public static class InternerBuilder {
    }

    public static class InternerFunction<E> implements Function<E, E> {
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            throw null;
        }

        @Override // com.google.common.base.Function
        public final boolean equals(Object obj) {
            if (!(obj instanceof InternerFunction)) {
                return false;
            }
            ((InternerFunction) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }
    }

    @VisibleForTesting
    public static final class InternerImpl<E> implements Interner<E> {
    }
}
