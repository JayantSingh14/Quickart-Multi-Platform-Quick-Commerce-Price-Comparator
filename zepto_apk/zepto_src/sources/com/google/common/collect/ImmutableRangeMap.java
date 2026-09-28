package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Map;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {

    /* renamed from: com.google.common.collect.ImmutableRangeMap$1, reason: invalid class name */
    class AnonymousClass1 extends ImmutableList<Range<Comparable<?>>> {
        @Override // java.util.List
        public final Object get(int i2) {
            Preconditions.i(i2, 0);
            if (i2 == 0 || i2 == -1) {
                throw null;
            }
            throw null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return 0;
        }
    }

    /* renamed from: com.google.common.collect.ImmutableRangeMap$2, reason: invalid class name */
    class AnonymousClass2 extends ImmutableRangeMap<Comparable<?>, Object> {
        @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
        public final /* bridge */ /* synthetic */ Map a() {
            return a();
        }
    }

    @DoNotMock
    public static final class Builder<K extends Comparable<?>, V> {
        public Builder() {
            new ArrayList();
        }
    }

    public static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
    }

    static {
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList immutableList = RegularImmutableList.f43010e;
    }

    @Override // com.google.common.collect.RangeMap
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final ImmutableMap a() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof RangeMap) {
            return a().equals(((RangeMap) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return Maps.i(a());
    }
}
