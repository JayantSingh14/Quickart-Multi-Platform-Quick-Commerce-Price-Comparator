package io.ktor.util;

import io.ktor.util.DelegatingMutableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@InternalAPI
@Metadata
/* loaded from: classes3.dex */
public final class CaseInsensitiveSet implements Set<String>, KMutableSet {

    /* renamed from: a, reason: collision with root package name */
    public final CaseInsensitiveMap f50443a = new CaseInsensitiveMap();

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        String element = (String) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        CaseInsensitiveMap caseInsensitiveMap = this.f50443a;
        if (caseInsensitiveMap.containsKey(element)) {
            return false;
        }
        caseInsensitiveMap.put(element, Boolean.TRUE);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String element = (String) it.next();
            Intrinsics.checkNotNullParameter(element, "element");
            CaseInsensitiveMap caseInsensitiveMap = this.f50443a;
            if (!caseInsensitiveMap.containsKey(element)) {
                caseInsensitiveMap.put(element, Boolean.TRUE);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f50443a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String element = (String) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return this.f50443a.containsKey(element);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ((DelegatingMutableSet) this.f50443a.keySet()).containsAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f50443a.f50438a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new DelegatingMutableSet.AnonymousClass1();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String element = (String) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return Intrinsics.b(this.f50443a.remove(element), Boolean.TRUE);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ((DelegatingMutableSet) this.f50443a.keySet()).removeAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ((DelegatingMutableSet) this.f50443a.keySet()).retainAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f50443a.f50438a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
