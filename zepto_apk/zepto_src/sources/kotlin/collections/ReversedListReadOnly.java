package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
class ReversedListReadOnly<T> extends AbstractList<T> {

    /* renamed from: b, reason: collision with root package name */
    public final List f53620b;

    @Metadata
    /* renamed from: kotlin.collections.ReversedListReadOnly$listIterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements ListIterator<Object>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public final ListIterator f53621a;

        public AnonymousClass1(int i2) {
            this.f53621a = ReversedListReadOnly.this.f53620b.listIterator(CollectionsKt__ReversedViewsKt.e(i2, ReversedListReadOnly.this));
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f53621a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f53621a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            return this.f53621a.previous();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return CollectionsKt.B(ReversedListReadOnly.this) - this.f53621a.previousIndex();
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            return this.f53621a.next();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return CollectionsKt.B(ReversedListReadOnly.this) - this.f53621a.nextIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public ReversedListReadOnly(List delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f53620b = delegate;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int b() {
        return this.f53620b.size();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int i2) {
        return this.f53620b.get(CollectionsKt__ReversedViewsKt.d(i2, this));
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new AnonymousClass1(0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new AnonymousClass1(0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        return new AnonymousClass1(i2);
    }
}
