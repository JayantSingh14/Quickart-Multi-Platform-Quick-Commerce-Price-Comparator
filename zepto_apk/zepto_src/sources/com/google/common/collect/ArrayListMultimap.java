package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ArrayList;
import java.util.List;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class ArrayListMultimap<K, V> extends ArrayListMultimapGwtSerializationDependencies<K, V> {

    /* renamed from: g, reason: collision with root package name */
    public final transient int f42525g;

    public ArrayListMultimap() {
        super(new CompactHashMap(12));
        CollectPreconditions.b(3, "expectedValuesPerKey");
        this.f42525g = 3;
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public final boolean containsKey(Object obj) {
        return this.f42464e.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: r */
    public final List h() {
        return new ArrayList(this.f42525g);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public final int size() {
        return this.f42465f;
    }

    public final boolean t(String str, ArrayList arrayList) {
        return !arrayList.isEmpty() && l((Object) str).addAll(arrayList);
    }
}
