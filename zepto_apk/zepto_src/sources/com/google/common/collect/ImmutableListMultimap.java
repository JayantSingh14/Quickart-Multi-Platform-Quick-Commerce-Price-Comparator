package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        public final ImmutableListMultimap a() {
            Collection collectionEntrySet = ((CompactHashMap) this.f42693a).entrySet();
            if (((AbstractCollection) collectionEntrySet).isEmpty()) {
                return EmptyImmutableListMultimap.f42604g;
            }
            CompactHashMap.EntrySetView entrySetView = (CompactHashMap.EntrySetView) collectionEntrySet;
            ImmutableMap.Builder builder = new ImmutableMap.Builder(CompactHashMap.this.size());
            Iterator it = entrySetView.iterator();
            int size = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ImmutableList immutableListO = ImmutableList.o((Collection) entry.getValue());
                if (!immutableListO.isEmpty()) {
                    builder.c(key, immutableListO);
                    size = immutableListO.size() + size;
                }
            }
            return new ImmutableListMultimap(builder.a(true), size);
        }

        public final void b(String str, String str2) {
            CollectPreconditions.a(str, str2);
            CompactHashMap compactHashMap = (CompactHashMap) this.f42693a;
            Collection arrayList = (Collection) compactHashMap.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                compactHashMap.put(str, arrayList);
            }
            arrayList.add(str2);
        }
    }

    public static ImmutableListMultimap o() {
        return EmptyImmutableListMultimap.f42604g;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public final Collection b(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public final ImmutableCollection m() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    /* renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final ImmutableList l(Object obj) {
        ImmutableList immutableList = (ImmutableList) this.f42686e.get(obj);
        if (immutableList != null) {
            return immutableList;
        }
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        return RegularImmutableList.f43010e;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public final List b(Object obj) {
        throw new UnsupportedOperationException();
    }
}
