package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class MapBuilderEntries<K, V> extends AbstractMapBuilderEntrySet<Map.Entry<K, V>, K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final MapBuilder f53665a;

    public MapBuilderEntries(MapBuilder backing) {
        Intrinsics.checkNotNullParameter(backing, "backing");
        this.f53665a = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        Map.Entry element = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int b() {
        return this.f53665a.f53653i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f53665a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f53665a.e(elements);
    }

    @Override // kotlin.collections.builders.AbstractMapBuilderEntrySet
    public final boolean d(Map.Entry element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.f53665a.f(element);
    }

    @Override // kotlin.collections.builders.AbstractMapBuilderEntrySet
    public final boolean f(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "element");
        MapBuilder mapBuilder = this.f53665a;
        mapBuilder.getClass();
        Intrinsics.checkNotNullParameter(entry, "entry");
        mapBuilder.c();
        int iH = mapBuilder.h(entry.getKey());
        if (iH < 0) {
            return false;
        }
        Object[] objArr = mapBuilder.f53646b;
        Intrinsics.c(objArr);
        if (!Intrinsics.b(objArr[iH], entry.getValue())) {
            return false;
        }
        mapBuilder.l(iH);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f53665a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        MapBuilder map = this.f53665a;
        map.getClass();
        Intrinsics.checkNotNullParameter(map, "map");
        return new MapBuilder.EntriesItr(map);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.f53665a.c();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.f53665a.c();
        return super.retainAll(elements);
    }
}
