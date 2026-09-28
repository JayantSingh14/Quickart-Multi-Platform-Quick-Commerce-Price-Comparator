package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {

    @VisibleForTesting
    public static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements ValueSetLink<K, V> {

        /* renamed from: c, reason: collision with root package name */
        public final int f42772c;

        /* renamed from: d, reason: collision with root package name */
        public ValueEntry f42773d;

        /* renamed from: e, reason: collision with root package name */
        public ValueSetLink f42774e;

        /* renamed from: f, reason: collision with root package name */
        public ValueSetLink f42775f;

        /* renamed from: g, reason: collision with root package name */
        public ValueEntry f42776g;

        /* renamed from: h, reason: collision with root package name */
        public ValueEntry f42777h;

        public ValueEntry(Object obj, Object obj2, int i2, ValueEntry valueEntry) {
            super(obj, obj2);
            this.f42772c = i2;
            this.f42773d = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public final ValueSetLink b() {
            ValueSetLink valueSetLink = this.f42775f;
            Objects.requireNonNull(valueSetLink);
            return valueSetLink;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public final void d(ValueSetLink valueSetLink) {
            this.f42775f = valueSetLink;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public final void f(ValueSetLink valueSetLink) {
            this.f42774e = valueSetLink;
        }
    }

    @VisibleForTesting
    public final class ValueSet extends Sets.ImprovedAbstractSet<V> implements ValueSetLink<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42778a;

        /* renamed from: c, reason: collision with root package name */
        public int f42780c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f42781d = 0;

        /* renamed from: e, reason: collision with root package name */
        public ValueSetLink f42782e = this;

        /* renamed from: f, reason: collision with root package name */
        public ValueSetLink f42783f = this;

        /* renamed from: b, reason: collision with root package name */
        public final ValueEntry[] f42779b = new ValueEntry[Hashing.a(0, 1.0d)];

        public ValueSet(Object obj) {
            this.f42778a = obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            int iC = Hashing.c(obj);
            ValueEntry valueEntry = this.f42779b[(r1.length - 1) & iC];
            for (ValueEntry valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.f42773d) {
                if (valueEntry2.f42772c == iC && com.google.common.base.Objects.a(valueEntry2.f42661b, obj)) {
                    return false;
                }
            }
            ValueEntry valueEntry3 = new ValueEntry(this.f42778a, obj, iC, valueEntry);
            ValueSetLink valueSetLink = this.f42783f;
            valueSetLink.d(valueEntry3);
            valueEntry3.f(valueSetLink);
            valueEntry3.d(this);
            f(valueEntry3);
            LinkedHashMultimap.this.getClass();
            throw null;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public final ValueSetLink b() {
            return this.f42782e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            Arrays.fill(this.f42779b, (Object) null);
            this.f42780c = 0;
            for (ValueSetLink valueSetLinkB = this.f42782e; valueSetLinkB != this; valueSetLinkB = valueSetLinkB.b()) {
                ValueEntry valueEntry = (ValueEntry) valueSetLinkB;
                ValueEntry valueEntry2 = valueEntry.f42776g;
                Objects.requireNonNull(valueEntry2);
                ValueEntry valueEntry3 = valueEntry.f42777h;
                Objects.requireNonNull(valueEntry3);
                valueEntry2.f42777h = valueEntry3;
                valueEntry3.f42776g = valueEntry2;
            }
            d(this);
            f(this);
            this.f42781d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            int iC = Hashing.c(obj);
            ValueEntry[] valueEntryArr = this.f42779b;
            for (ValueEntry valueEntry = valueEntryArr[(valueEntryArr.length - 1) & iC]; valueEntry != null; valueEntry = valueEntry.f42773d) {
                if (valueEntry.f42772c == iC && com.google.common.base.Objects.a(valueEntry.f42661b, obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public final void d(ValueSetLink valueSetLink) {
            this.f42782e = valueSetLink;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public final void f(ValueSetLink valueSetLink) {
            this.f42783f = valueSetLink;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new Iterator<Object>() { // from class: com.google.common.collect.LinkedHashMultimap.ValueSet.1

                /* renamed from: a, reason: collision with root package name */
                public ValueSetLink f42785a;

                /* renamed from: b, reason: collision with root package name */
                public ValueEntry f42786b;

                /* renamed from: c, reason: collision with root package name */
                public int f42787c;

                {
                    this.f42785a = ValueSet.this.f42782e;
                    this.f42787c = ValueSet.this.f42781d;
                }

                @Override // java.util.Iterator
                public final boolean hasNext() {
                    ValueSet valueSet = ValueSet.this;
                    if (valueSet.f42781d == this.f42787c) {
                        return this.f42785a != valueSet;
                    }
                    throw new ConcurrentModificationException();
                }

                @Override // java.util.Iterator
                public final Object next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    ValueEntry valueEntry = (ValueEntry) this.f42785a;
                    Object obj = valueEntry.f42661b;
                    this.f42786b = valueEntry;
                    this.f42785a = valueEntry.b();
                    return obj;
                }

                @Override // java.util.Iterator
                public final void remove() {
                    ValueSet valueSet = ValueSet.this;
                    if (valueSet.f42781d != this.f42787c) {
                        throw new ConcurrentModificationException();
                    }
                    Preconditions.m("no calls to next() since the last call to remove()", this.f42786b != null);
                    valueSet.remove(this.f42786b.f42661b);
                    this.f42787c = valueSet.f42781d;
                    this.f42786b = null;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            int iC = Hashing.c(obj);
            ValueEntry[] valueEntryArr = this.f42779b;
            int length = (valueEntryArr.length - 1) & iC;
            ValueEntry valueEntry = null;
            for (ValueEntry valueEntry2 = valueEntryArr[length]; valueEntry2 != null; valueEntry2 = valueEntry2.f42773d) {
                if (valueEntry2.f42772c == iC && com.google.common.base.Objects.a(valueEntry2.f42661b, obj)) {
                    if (valueEntry == null) {
                        this.f42779b[length] = valueEntry2.f42773d;
                    } else {
                        valueEntry.f42773d = valueEntry2.f42773d;
                    }
                    ValueSetLink valueSetLink = valueEntry2.f42774e;
                    Objects.requireNonNull(valueSetLink);
                    ValueSetLink valueSetLinkB = valueEntry2.b();
                    valueSetLink.d(valueSetLinkB);
                    valueSetLinkB.f(valueSetLink);
                    ValueEntry valueEntry3 = valueEntry2.f42776g;
                    Objects.requireNonNull(valueEntry3);
                    ValueEntry valueEntry4 = valueEntry2.f42777h;
                    Objects.requireNonNull(valueEntry4);
                    valueEntry3.f42777h = valueEntry4;
                    valueEntry4.f42776g = valueEntry3;
                    this.f42780c--;
                    this.f42781d++;
                    return true;
                }
                valueEntry = valueEntry2;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f42780c;
        }
    }

    public interface ValueSetLink<K, V> {
        ValueSetLink b();

        void d(ValueSetLink valueSetLink);

        void f(ValueSetLink valueSetLink);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public final void clear() {
        super.clear();
        throw null;
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public final boolean containsKey(Object obj) {
        return this.f42464e.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Collection d() {
        return super.d();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    public final Iterator g() {
        new Iterator<Map.Entry<Object, Object>>() { // from class: com.google.common.collect.LinkedHashMultimap.1

            /* renamed from: a, reason: collision with root package name */
            public ValueEntry f42769a;

            /* renamed from: b, reason: collision with root package name */
            public ValueEntry f42770b;

            {
                LinkedHashMultimap.this.getClass();
                throw null;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                ValueEntry valueEntry = this.f42769a;
                LinkedHashMultimap.this.getClass();
                return valueEntry != null;
            }

            @Override // java.util.Iterator
            public final Map.Entry<Object, Object> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                ValueEntry valueEntry = this.f42769a;
                this.f42770b = valueEntry;
                ValueEntry valueEntry2 = valueEntry.f42777h;
                Objects.requireNonNull(valueEntry2);
                this.f42769a = valueEntry2;
                return valueEntry;
            }

            @Override // java.util.Iterator
            public final void remove() {
                Preconditions.m("no calls to next() since the last call to remove()", this.f42770b != null);
                ValueEntry valueEntry = this.f42770b;
                LinkedHashMultimap.this.remove(valueEntry.f42660a, valueEntry.f42661b);
                this.f42770b = null;
            }
        };
        throw null;
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public final Collection j(Object obj) {
        return new ValueSet(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public final Iterator o() {
        g();
        throw null;
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: r */
    public final Set h() {
        return new CompactLinkedHashSet(0);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public final int size() {
        return this.f42465f;
    }
}
