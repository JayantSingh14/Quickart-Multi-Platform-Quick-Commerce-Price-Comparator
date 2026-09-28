package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.ObjectCountHashMap;
import com.google.common.primitives.Ints;
import java.io.Serializable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {

    /* renamed from: g, reason: collision with root package name */
    public static final RegularImmutableMultiset f43027g;

    /* renamed from: d, reason: collision with root package name */
    public final transient ObjectCountHashMap f43028d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f43029e;

    /* renamed from: f, reason: collision with root package name */
    public transient ImmutableSet f43030f;

    public final class ElementSet extends IndexedImmutableSet<E> {
        public ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public final Object get(int i2) {
            return RegularImmutableMultiset.this.f43028d.e(i2);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return RegularImmutableMultiset.this.f43028d.f42978c;
        }
    }

    @GwtIncompatible
    public static class SerializedForm implements Serializable {
    }

    static {
        ObjectCountHashMap objectCountHashMap = new ObjectCountHashMap();
        objectCountHashMap.h(3);
        f43027g = new RegularImmutableMultiset(objectCountHashMap);
    }

    public RegularImmutableMultiset(ObjectCountHashMap objectCountHashMap) {
        this.f43028d = objectCountHashMap;
        long jF = 0;
        for (int i2 = 0; i2 < objectCountHashMap.f42978c; i2++) {
            jF += objectCountHashMap.f(i2);
        }
        this.f43029e = Ints.f(jF);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    /* renamed from: n */
    public final ImmutableSet e() {
        ImmutableSet immutableSet = this.f43030f;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet = new ElementSet();
        this.f43030f = elementSet;
        return elementSet;
    }

    @Override // com.google.common.collect.Multiset
    public final int o1(Object obj) {
        return this.f43028d.d(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public final Multiset.Entry p(int i2) {
        ObjectCountHashMap objectCountHashMap = this.f43028d;
        Preconditions.i(i2, objectCountHashMap.f42978c);
        return new ObjectCountHashMap.MapEntry(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f43029e;
    }
}
