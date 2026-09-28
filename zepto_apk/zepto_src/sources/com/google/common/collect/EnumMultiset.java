package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;

@GwtCompatible
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f42605e = 0;

    /* renamed from: c, reason: collision with root package name */
    public transient int f42606c;

    /* renamed from: d, reason: collision with root package name */
    public transient long f42607d;

    /* renamed from: com.google.common.collect.EnumMultiset$1, reason: invalid class name */
    class AnonymousClass1 extends EnumMultiset<Enum<Object>>.Itr<Enum<Object>> {
    }

    /* renamed from: com.google.common.collect.EnumMultiset$2, reason: invalid class name */
    class AnonymousClass2 extends EnumMultiset<Enum<Object>>.Itr<Multiset.Entry<Enum<Object>>> {

        /* renamed from: com.google.common.collect.EnumMultiset$2$1, reason: invalid class name */
        class AnonymousClass1 extends Multisets.AbstractEntry<Enum<Object>> {
            @Override // com.google.common.collect.Multiset.Entry
            public final Object a() {
                throw null;
            }

            @Override // com.google.common.collect.Multiset.Entry
            public final int getCount() {
                throw null;
            }
        }
    }

    public abstract class Itr<T> implements Iterator<T> {
        public Itr() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i2 = EnumMultiset.f42605e;
            EnumMultiset.this.getClass();
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            hasNext();
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            CollectPreconditions.d(false);
            int i2 = EnumMultiset.f42605e;
            EnumMultiset.this.getClass();
            throw null;
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int O1(Object obj) {
        Enum r1 = (Enum) obj;
        r1.getClass();
        r1.ordinal();
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int T(int i2, Object obj) {
        if (obj == null || !(obj instanceof Enum)) {
            return 0;
        }
        ((Enum) obj).ordinal();
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int add(int i2, Object obj) {
        Enum r2 = (Enum) obj;
        r2.getClass();
        r2.ordinal();
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        Arrays.fill((int[]) null, 0);
        this.f42607d = 0L;
        this.f42606c = 0;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final int f() {
        return this.f42606c;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator g() {
        return new AnonymousClass1();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator i() {
        return new AnonymousClass2();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return Multisets.b(this);
    }

    @Override // com.google.common.collect.Multiset
    public final int o1(Object obj) {
        if (obj == null || !(obj instanceof Enum)) {
            return 0;
        }
        ((Enum) obj).ordinal();
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return Ints.f(this.f42607d);
    }
}
