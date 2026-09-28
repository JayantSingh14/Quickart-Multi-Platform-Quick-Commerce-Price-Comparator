package org.shadow.apache.commons.lang3.builder;

import org.shadow.apache.commons.lang3.tuple.Pair;

/* loaded from: classes5.dex */
public abstract class Diff<T> extends Pair<T, T> {
    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("Cannot alter Diff object.");
    }

    @Override // org.shadow.apache.commons.lang3.tuple.Pair
    public final String toString() {
        return String.format("[%s: %s, %s]", null, a(), b());
    }
}
