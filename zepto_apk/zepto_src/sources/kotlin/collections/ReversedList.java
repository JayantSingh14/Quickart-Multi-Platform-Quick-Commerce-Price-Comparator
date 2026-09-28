package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

@Metadata
/* loaded from: classes3.dex */
final class ReversedList<T> extends AbstractMutableList<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f53617a;

    @Metadata
    /* renamed from: kotlin.collections.ReversedList$listIterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements ListIterator<Object>, KMutableListIterator {

        /* renamed from: a, reason: collision with root package name */
        public final ListIterator f53618a;

        public AnonymousClass1(int i2) {
            this.f53618a = ReversedList.this.f53617a.listIterator(CollectionsKt__ReversedViewsKt.e(i2, ReversedList.this));
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            ListIterator listIterator = this.f53618a;
            listIterator.add(obj);
            listIterator.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f53618a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f53618a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            return this.f53618a.previous();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return CollectionsKt.B(ReversedList.this) - this.f53618a.previousIndex();
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            return this.f53618a.next();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return CollectionsKt.B(ReversedList.this) - this.f53618a.nextIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            this.f53618a.remove();
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            this.f53618a.set(obj);
        }
    }

    public ReversedList(ArrayList delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f53617a = delegate;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        this.f53617a.add(CollectionsKt__ReversedViewsKt.e(i2, this), obj);
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int b() {
        return this.f53617a.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f53617a.clear();
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object d(int i2) {
        return this.f53617a.remove(CollectionsKt__ReversedViewsKt.d(i2, this));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return this.f53617a.get(CollectionsKt__ReversedViewsKt.d(i2, this));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new AnonymousClass1(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new AnonymousClass1(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        return this.f53617a.set(CollectionsKt__ReversedViewsKt.d(i2, this), obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        return new AnonymousClass1(i2);
    }
}
