package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multisets;
import java.util.Iterator;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {

    public class StandardElementSet extends Multisets.ElementSet<E> {
        @Override // com.google.common.collect.Multisets.ElementSet
        public final Multiset g() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            throw null;
        }
    }

    @Override // com.google.common.collect.ForwardingCollection
    /* renamed from: B */
    public abstract Multiset t();

    @Override // com.google.common.collect.Multiset
    public int O1(Object obj) {
        return t().O1(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int T(int i2, Object obj) {
        return t().T(i2, obj);
    }

    @Override // com.google.common.collect.Multiset
    public int add(int i2, Object obj) {
        return t().add(i2, obj);
    }

    public Set e() {
        return t().e();
    }

    public Set entrySet() {
        return t().entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final boolean equals(Object obj) {
        return obj == this || t().equals(obj);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final int hashCode() {
        return t().hashCode();
    }

    @Override // com.google.common.collect.Multiset
    public final int o1(Object obj) {
        return t().o1(obj);
    }

    @Override // com.google.common.collect.Multiset
    public boolean u0(int i2, Object obj) {
        return t().u0(i2, obj);
    }
}
