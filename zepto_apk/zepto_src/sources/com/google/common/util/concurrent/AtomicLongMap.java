package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class AtomicLongMap<K> implements Serializable {

    /* renamed from: com.google.common.util.concurrent.AtomicLongMap$1, reason: invalid class name */
    class AnonymousClass1 implements Function<AtomicLong, Long> {
        @Override // com.google.common.base.Function
        public final Long apply(AtomicLong atomicLong) {
            return Long.valueOf(atomicLong.get());
        }
    }

    public final String toString() {
        throw null;
    }
}
