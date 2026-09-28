package io.ktor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class DelegatingMutableSet<From, To> implements Set<To>, KMutableSet {

    /* renamed from: a, reason: collision with root package name */
    public final Set f50474a;

    /* renamed from: b, reason: collision with root package name */
    public final Lambda f50475b;

    /* renamed from: c, reason: collision with root package name */
    public final Lambda f50476c;

    /* renamed from: d, reason: collision with root package name */
    public final int f50477d;

    @Metadata
    /* renamed from: io.ktor.util.DelegatingMutableSet$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<Object>, KMutableIterator {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f50478a;

        public AnonymousClass1() {
            this.f50478a = DelegatingMutableSet.this.f50474a.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f50478a.hasNext();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
        @Override // java.util.Iterator
        public final Object next() {
            return DelegatingMutableSet.this.f50475b.invoke(this.f50478a.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f50478a.remove();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelegatingMutableSet(Set delegate, Function1 convertTo, Function1 convert) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(convertTo, "convertTo");
        Intrinsics.checkNotNullParameter(convert, "convert");
        this.f50474a = delegate;
        this.f50475b = (Lambda) convertTo;
        this.f50476c = (Lambda) convert;
        this.f50477d = delegate.size();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        return this.f50474a.add(this.f50476c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f50474a.addAll(b(elements));
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    public final ArrayList b(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection collection2 = collection;
        ArrayList arrayList = new ArrayList(kotlin.collections.CollectionsKt.r(collection2, 10));
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f50476c.invoke(it.next()));
        }
        return arrayList;
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f50474a.clear();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f50474a.contains(this.f50476c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f50474a.containsAll(b(elements));
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    public final ArrayList d(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection collection2 = collection;
        ArrayList arrayList = new ArrayList(kotlin.collections.CollectionsKt.r(collection2, 10));
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f50475b.invoke(it.next()));
        }
        return arrayList;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Set)) {
            return false;
        }
        ArrayList arrayListD = d(this.f50474a);
        return ((Set) obj).containsAll(arrayListD) && arrayListD.containsAll((Collection) obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return this.f50474a.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f50474a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new AnonymousClass1();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f50474a.remove(this.f50476c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f50474a.removeAll(b(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f50474a.retainAll(b(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f50477d;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public final String toString() {
        return d(this.f50474a).toString();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
