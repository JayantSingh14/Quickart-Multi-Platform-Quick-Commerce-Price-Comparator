package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f43139f = 0;

    /* renamed from: e, reason: collision with root package name */
    public final transient GeneralRange f43140e;

    /* renamed from: com.google.common.collect.TreeMultiset$1, reason: invalid class name */
    class AnonymousClass1 extends Multisets.AbstractEntry<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AvlNode f43141a;

        public AnonymousClass1(AvlNode avlNode) {
            this.f43141a = avlNode;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final Object a() {
            this.f43141a.getClass();
            return null;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            this.f43141a.getClass();
            TreeMultiset.this.getClass();
            try {
                throw null;
            } catch (NullPointerException unused) {
                return 0;
            }
        }
    }

    /* renamed from: com.google.common.collect.TreeMultiset$2, reason: invalid class name */
    class AnonymousClass2 implements Iterator<Multiset.Entry<Object>> {

        /* renamed from: a, reason: collision with root package name */
        public AvlNode f43143a;

        /* renamed from: b, reason: collision with root package name */
        public Multiset.Entry f43144b;

        public AnonymousClass2() {
            TreeMultiset.this.getClass();
            throw null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f43143a == null) {
                return false;
            }
            if (!TreeMultiset.this.f43140e.c(null)) {
                return true;
            }
            this.f43143a = null;
            return false;
        }

        @Override // java.util.Iterator
        public final Multiset.Entry<Object> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AvlNode avlNode = this.f43143a;
            Objects.requireNonNull(avlNode);
            int i2 = TreeMultiset.f43139f;
            TreeMultiset treeMultiset = TreeMultiset.this;
            treeMultiset.getClass();
            this.f43144b = new AnonymousClass1(avlNode);
            this.f43143a.getClass();
            Objects.requireNonNull(null);
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Preconditions.m("no calls to next() since the last call to remove()", this.f43144b != null);
            ((AnonymousClass1) this.f43144b).f43141a.getClass();
            TreeMultiset.this.O1(null);
            this.f43144b = null;
        }
    }

    /* renamed from: com.google.common.collect.TreeMultiset$3, reason: invalid class name */
    class AnonymousClass3 implements Iterator<Multiset.Entry<Object>> {

        /* renamed from: a, reason: collision with root package name */
        public AvlNode f43146a;

        /* renamed from: b, reason: collision with root package name */
        public Multiset.Entry f43147b;

        public AnonymousClass3() {
            TreeMultiset.this.getClass();
            throw null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f43146a == null) {
                return false;
            }
            if (!TreeMultiset.this.f43140e.d(null)) {
                return true;
            }
            this.f43146a = null;
            return false;
        }

        @Override // java.util.Iterator
        public final Multiset.Entry<Object> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Objects.requireNonNull(this.f43146a);
            AvlNode avlNode = this.f43146a;
            int i2 = TreeMultiset.f43139f;
            TreeMultiset treeMultiset = TreeMultiset.this;
            treeMultiset.getClass();
            this.f43147b = new AnonymousClass1(avlNode);
            this.f43146a.getClass();
            Objects.requireNonNull(null);
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Preconditions.m("no calls to next() since the last call to remove()", this.f43147b != null);
            ((AnonymousClass1) this.f43147b).f43141a.getClass();
            TreeMultiset.this.O1(null);
            this.f43147b = null;
        }
    }

    /* renamed from: com.google.common.collect.TreeMultiset$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43149a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f43149a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43149a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class Aggregate {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Aggregate[] f43150a = {new Aggregate() { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
        }, new Aggregate() { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
        }};

        /* JADX INFO: Fake field, exist only in values array */
        Aggregate EF2;

        public static Aggregate valueOf(String str) {
            return (Aggregate) Enum.valueOf(Aggregate.class, str);
        }

        public static Aggregate[] values() {
            return (Aggregate[]) f43150a.clone();
        }
    }

    public static final class AvlNode<E> {
        public final String toString() {
            return new Multisets.ImmutableEntry(null, 0).toString();
        }
    }

    public static final class Reference<T> {
    }

    public TreeMultiset(GeneralRange generalRange) {
        super(generalRange.f42619a);
        this.f43140e = generalRange;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int O1(Object obj) {
        CollectPreconditions.b(0, "count");
        if (this.f43140e.a(obj)) {
            throw null;
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int T(int i2, Object obj) {
        CollectPreconditions.b(i2, "occurrences");
        if (i2 != 0) {
            throw null;
        }
        try {
            throw null;
        } catch (NullPointerException unused) {
            return 0;
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int add(int i2, Object obj) {
        CollectPreconditions.b(i2, "occurrences");
        if (i2 == 0) {
            try {
                throw null;
            } catch (NullPointerException unused) {
                return 0;
            }
        }
        Preconditions.f(this.f43140e.a(obj));
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        GeneralRange generalRange = this.f43140e;
        if (!generalRange.f42620b && !generalRange.f42623e) {
            throw null;
        }
        new AnonymousClass2();
        throw null;
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final Comparator comparator() {
        return this.f42518c;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final int f() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator g() {
        new AnonymousClass2();
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator i() {
        new AnonymousClass2();
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return Multisets.b(this);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset
    public final Iterator j() {
        new AnonymousClass3();
        throw null;
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public final SortedMultiset k0(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return ((TreeMultiset) s1(obj, boundType)).l1(obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset l1(Object obj, BoundType boundType) {
        return new TreeMultiset(this.f43140e.b(new GeneralRange(this.f42518c, false, null, BoundType.f42528a, true, obj, boundType)));
    }

    @Override // com.google.common.collect.Multiset
    public final int o1(Object obj) {
        try {
            throw null;
        } catch (NullPointerException unused) {
            return 0;
        }
    }

    @Override // com.google.common.collect.SortedMultiset
    public final SortedMultiset s1(Object obj, BoundType boundType) {
        return new TreeMultiset(this.f43140e.b(new GeneralRange(this.f42518c, true, obj, boundType, false, null, BoundType.f42528a)));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean u0(int i2, Object obj) {
        CollectPreconditions.b(0, "newCount");
        CollectPreconditions.b(i2, "oldCount");
        Preconditions.f(this.f43140e.a(obj));
        throw null;
    }
}
