package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SortedMultisets;
import com.google.common.collect.TreeMultiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class AbstractSortedMultiset<E> extends AbstractMultiset<E> implements SortedMultiset<E> {

    /* renamed from: c, reason: collision with root package name */
    public final Comparator f42518c;

    /* renamed from: d, reason: collision with root package name */
    public transient SortedMultiset f42519d;

    public AbstractSortedMultiset() {
        this(NaturalOrdering.f42971c);
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Set b() {
        return new SortedMultisets.NavigableElementSet(this);
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator comparator() {
        return this.f42518c;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry firstEntry() {
        Iterator itI = i();
        if (itI.hasNext()) {
            return (Multiset.Entry) itI.next();
        }
        return null;
    }

    public abstract Iterator j();

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset k0(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return ((TreeMultiset) ((TreeMultiset) this).s1(obj, boundType)).l1(obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry lastEntry() {
        TreeMultiset.AnonymousClass3 anonymousClass3 = (TreeMultiset.AnonymousClass3) j();
        if (anonymousClass3.hasNext()) {
            return anonymousClass3.next();
        }
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollFirstEntry() {
        Iterator itI = i();
        if (!itI.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) itI.next();
        Multisets.ImmutableEntry immutableEntry = new Multisets.ImmutableEntry(entry.a(), entry.getCount());
        itI.remove();
        return immutableEntry;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollLastEntry() {
        TreeMultiset.AnonymousClass3 anonymousClass3 = (TreeMultiset.AnonymousClass3) j();
        if (!anonymousClass3.hasNext()) {
            return null;
        }
        Multiset.Entry<Object> next = anonymousClass3.next();
        Multisets.ImmutableEntry immutableEntry = new Multisets.ImmutableEntry(next.a(), next.getCount());
        anonymousClass3.remove();
        return immutableEntry;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset t0() {
        SortedMultiset sortedMultiset = this.f42519d;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        DescendingMultiset<Object> descendingMultiset = new DescendingMultiset<Object>() { // from class: com.google.common.collect.AbstractSortedMultiset.1DescendingMultisetImpl
            @Override // com.google.common.collect.DescendingMultiset
            public final Iterator C() {
                return AbstractSortedMultiset.this.j();
            }

            @Override // com.google.common.collect.DescendingMultiset
            public final SortedMultiset E() {
                return AbstractSortedMultiset.this;
            }

            @Override // com.google.common.collect.DescendingMultiset, com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                return Multisets.b(AbstractSortedMultiset.this.t0());
            }
        };
        this.f42519d = descendingMultiset;
        return descendingMultiset;
    }

    public AbstractSortedMultiset(Comparator comparator) {
        comparator.getClass();
        this.f42518c = comparator;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public NavigableSet e() {
        return (NavigableSet) super.e();
    }
}
