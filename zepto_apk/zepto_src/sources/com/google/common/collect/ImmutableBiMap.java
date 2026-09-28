package com.google.common.collect;

import androidx.media3.common.TrackGroup;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ImmutableMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        @Override // com.google.common.collect.ImmutableMap.Builder
        public final ImmutableMap.Builder c(Object obj, Object obj2) {
            super.c(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public final ImmutableMap.Builder d(Iterable iterable) {
            super.d(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public final ImmutableMap.Builder e(Map map) {
            d(((ImmutableMap) map).entrySet());
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final ImmutableBiMap b() {
            return this.f42676b == 0 ? RegularImmutableBiMap.f43004i : new RegularImmutableBiMap(this.f42675a, this.f42676b);
        }

        public final void g(TrackGroup trackGroup, String str) {
            super.c(trackGroup, str);
        }
    }

    @J2ktIncompatible
    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
    }

    public static ImmutableBiMap p() {
        return RegularImmutableBiMap.f43004i;
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableCollection d() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: n */
    public final ImmutableCollection values() {
        return o().keySet();
    }

    public abstract ImmutableBiMap o();

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public final Collection values() {
        return o().keySet();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public final Set values() {
        return o().keySet();
    }
}
