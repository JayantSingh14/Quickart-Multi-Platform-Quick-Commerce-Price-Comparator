package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@GwtCompatible
/* loaded from: classes4.dex */
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    public static final AnonymousClass1 t;
    public static final Queue u;

    /* renamed from: a, reason: collision with root package name */
    public final int f42341a;

    /* renamed from: b, reason: collision with root package name */
    public final int f42342b;

    /* renamed from: c, reason: collision with root package name */
    public final Segment[] f42343c;

    /* renamed from: d, reason: collision with root package name */
    public final int f42344d;

    /* renamed from: e, reason: collision with root package name */
    public final Equivalence f42345e;

    /* renamed from: f, reason: collision with root package name */
    public final Equivalence f42346f;

    /* renamed from: g, reason: collision with root package name */
    public final Strength f42347g;

    /* renamed from: h, reason: collision with root package name */
    public final Strength.AnonymousClass1 f42348h;

    /* renamed from: i, reason: collision with root package name */
    public final long f42349i;

    /* renamed from: j, reason: collision with root package name */
    public final Weigher f42350j;

    /* renamed from: k, reason: collision with root package name */
    public final Queue f42351k;

    /* renamed from: l, reason: collision with root package name */
    public final RemovalListener f42352l;

    /* renamed from: m, reason: collision with root package name */
    public final Ticker f42353m;
    public final EntryFactory n;
    public final AbstractCache.StatsCounter o;
    public final CacheLoader p;
    public Set q;
    public Collection r;
    public Set s;

    /* renamed from: com.google.common.cache.LocalCache$1, reason: invalid class name */
    public class AnonymousClass1 implements ValueReference<Object, Object> {
        @Override // com.google.common.cache.LocalCache.ValueReference
        public final boolean a() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final boolean b() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final ReferenceEntry c() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final void d(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final int e() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final ValueReference f(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final Object g() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final Object get() {
            return null;
        }
    }

    public abstract class AbstractCacheSet<T> extends AbstractSet<T> {
        public AbstractCacheSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return LocalCache.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray(Object[] objArr) {
            return LocalCache.a(this).toArray(objArr);
        }
    }

    public static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference a() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int b() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry c() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry d() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry e() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry g() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void h(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry i() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void l(ValueReference valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long n() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void p(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long q() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void r(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void s(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void t(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void u(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public final AnonymousClass1 f42355a;

        /* renamed from: com.google.common.cache.LocalCache$AccessQueue$1, reason: invalid class name */
        public class AnonymousClass1 extends AbstractReferenceEntry<K, V> {

            /* renamed from: a, reason: collision with root package name */
            public ReferenceEntry f42356a;

            /* renamed from: b, reason: collision with root package name */
            public ReferenceEntry f42357b;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final ReferenceEntry d() {
                return this.f42357b;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final ReferenceEntry g() {
                return this.f42356a;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final void h(ReferenceEntry referenceEntry) {
                this.f42357b = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final void p(long j2) {
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final long q() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final void s(ReferenceEntry referenceEntry) {
                this.f42356a = referenceEntry;
            }
        }

        public AccessQueue() {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            anonymousClass1.f42356a = anonymousClass1;
            anonymousClass1.f42357b = anonymousClass1;
            this.f42355a = anonymousClass1;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            AnonymousClass1 anonymousClass1 = this.f42355a;
            ReferenceEntry referenceEntry = anonymousClass1.f42356a;
            while (referenceEntry != anonymousClass1) {
                ReferenceEntry referenceEntryG = referenceEntry.g();
                AnonymousClass1 anonymousClass12 = LocalCache.t;
                NullEntry nullEntry = NullEntry.f42376a;
                referenceEntry.s(nullEntry);
                referenceEntry.h(nullEntry);
                referenceEntry = referenceEntryG;
            }
            anonymousClass1.f42356a = anonymousClass1;
            anonymousClass1.f42357b = anonymousClass1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return ((ReferenceEntry) obj).g() != NullEntry.f42376a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            AnonymousClass1 anonymousClass1 = this.f42355a;
            return anonymousClass1.f42356a == anonymousClass1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            AnonymousClass1 anonymousClass1 = this.f42355a;
            ReferenceEntry referenceEntry = anonymousClass1.f42356a;
            if (referenceEntry == anonymousClass1) {
                referenceEntry = null;
            }
            return new AbstractSequentialIterator<ReferenceEntry<Object, Object>>(referenceEntry) { // from class: com.google.common.cache.LocalCache.AccessQueue.2
                @Override // com.google.common.collect.AbstractSequentialIterator
                public final Object a(Object obj) {
                    ReferenceEntry referenceEntryG = ((ReferenceEntry) obj).g();
                    if (referenceEntryG == AccessQueue.this.f42355a) {
                        return null;
                    }
                    return referenceEntryG;
                }
            };
        }

        @Override // java.util.Queue
        public final boolean offer(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry referenceEntryD = referenceEntry.d();
            ReferenceEntry referenceEntryG = referenceEntry.g();
            AnonymousClass1 anonymousClass1 = LocalCache.t;
            referenceEntryD.s(referenceEntryG);
            referenceEntryG.h(referenceEntryD);
            AnonymousClass1 anonymousClass12 = this.f42355a;
            ReferenceEntry referenceEntry2 = anonymousClass12.f42357b;
            referenceEntry2.s(referenceEntry);
            referenceEntry.h(referenceEntry2);
            referenceEntry.s(anonymousClass12);
            anonymousClass12.f42357b = referenceEntry;
            return true;
        }

        @Override // java.util.Queue
        public final Object peek() {
            AnonymousClass1 anonymousClass1 = this.f42355a;
            ReferenceEntry referenceEntry = anonymousClass1.f42356a;
            if (referenceEntry == anonymousClass1) {
                return null;
            }
            return referenceEntry;
        }

        @Override // java.util.Queue
        public final Object poll() {
            AnonymousClass1 anonymousClass1 = this.f42355a;
            ReferenceEntry referenceEntry = anonymousClass1.f42356a;
            if (referenceEntry == anonymousClass1) {
                return null;
            }
            remove(referenceEntry);
            return referenceEntry;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry referenceEntryD = referenceEntry.d();
            ReferenceEntry referenceEntryG = referenceEntry.g();
            AnonymousClass1 anonymousClass1 = LocalCache.t;
            referenceEntryD.s(referenceEntryG);
            referenceEntryG.h(referenceEntryD);
            NullEntry nullEntry = NullEntry.f42376a;
            referenceEntry.s(nullEntry);
            referenceEntry.h(nullEntry);
            return referenceEntryG != nullEntry;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            AnonymousClass1 anonymousClass1 = this.f42355a;
            int i2 = 0;
            for (ReferenceEntry referenceEntryG = anonymousClass1.f42356a; referenceEntryG != anonymousClass1; referenceEntryG = referenceEntryG.g()) {
                i2++;
            }
            return i2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class EntryFactory {

        /* renamed from: a, reason: collision with root package name */
        public static final EntryFactory[] f42359a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EntryFactory[] f42360b;

        /* JADX INFO: Fake field, exist only in values array */
        EntryFactory EF9;

        static {
            EntryFactory entryFactory = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.1
                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry d(Segment segment, Object obj, int i2, ReferenceEntry referenceEntry) {
                    return new StrongEntry(obj, i2, referenceEntry);
                }
            };
            EntryFactory entryFactory2 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.2
                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry b(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                    ReferenceEntry referenceEntryB = super.b(segment, referenceEntry, referenceEntry2, obj);
                    EntryFactory.a(referenceEntry, referenceEntryB);
                    return referenceEntryB;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry d(Segment segment, Object obj, int i2, ReferenceEntry referenceEntry) {
                    StrongAccessEntry strongAccessEntry = new StrongAccessEntry(obj, i2, referenceEntry);
                    strongAccessEntry.f42395e = Long.MAX_VALUE;
                    AnonymousClass1 anonymousClass1 = LocalCache.t;
                    NullEntry nullEntry = NullEntry.f42376a;
                    strongAccessEntry.f42396f = nullEntry;
                    strongAccessEntry.f42397g = nullEntry;
                    return strongAccessEntry;
                }
            };
            EntryFactory entryFactory3 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.3
                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry b(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                    ReferenceEntry referenceEntryB = super.b(segment, referenceEntry, referenceEntry2, obj);
                    EntryFactory.c(referenceEntry, referenceEntryB);
                    return referenceEntryB;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry d(Segment segment, Object obj, int i2, ReferenceEntry referenceEntry) {
                    StrongWriteEntry strongWriteEntry = new StrongWriteEntry(obj, i2, referenceEntry);
                    strongWriteEntry.f42409e = Long.MAX_VALUE;
                    AnonymousClass1 anonymousClass1 = LocalCache.t;
                    NullEntry nullEntry = NullEntry.f42376a;
                    strongWriteEntry.f42410f = nullEntry;
                    strongWriteEntry.f42411g = nullEntry;
                    return strongWriteEntry;
                }
            };
            EntryFactory entryFactory4 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.4
                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry b(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                    ReferenceEntry referenceEntryB = super.b(segment, referenceEntry, referenceEntry2, obj);
                    EntryFactory.a(referenceEntry, referenceEntryB);
                    EntryFactory.c(referenceEntry, referenceEntryB);
                    return referenceEntryB;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry d(Segment segment, Object obj, int i2, ReferenceEntry referenceEntry) {
                    StrongAccessWriteEntry strongAccessWriteEntry = new StrongAccessWriteEntry(obj, i2, referenceEntry);
                    strongAccessWriteEntry.f42398e = Long.MAX_VALUE;
                    AnonymousClass1 anonymousClass1 = LocalCache.t;
                    NullEntry nullEntry = NullEntry.f42376a;
                    strongAccessWriteEntry.f42399f = nullEntry;
                    strongAccessWriteEntry.f42400g = nullEntry;
                    strongAccessWriteEntry.f42401h = Long.MAX_VALUE;
                    strongAccessWriteEntry.f42402i = nullEntry;
                    strongAccessWriteEntry.f42403j = nullEntry;
                    return strongAccessWriteEntry;
                }
            };
            EntryFactory entryFactory5 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.5
                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry d(Segment segment, Object obj, int i2, ReferenceEntry referenceEntry) {
                    return new WeakEntry(segment.f42385h, obj, i2, referenceEntry);
                }
            };
            EntryFactory entryFactory6 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.6
                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry b(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                    ReferenceEntry referenceEntryB = super.b(segment, referenceEntry, referenceEntry2, obj);
                    EntryFactory.a(referenceEntry, referenceEntryB);
                    return referenceEntryB;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry d(Segment segment, Object obj, int i2, ReferenceEntry referenceEntry) {
                    WeakAccessEntry weakAccessEntry = new WeakAccessEntry(segment.f42385h, obj, i2, referenceEntry);
                    weakAccessEntry.f42413d = Long.MAX_VALUE;
                    AnonymousClass1 anonymousClass1 = LocalCache.t;
                    NullEntry nullEntry = NullEntry.f42376a;
                    weakAccessEntry.f42414e = nullEntry;
                    weakAccessEntry.f42415f = nullEntry;
                    return weakAccessEntry;
                }
            };
            EntryFactory entryFactory7 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.7
                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry b(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                    ReferenceEntry referenceEntryB = super.b(segment, referenceEntry, referenceEntry2, obj);
                    EntryFactory.c(referenceEntry, referenceEntryB);
                    return referenceEntryB;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry d(Segment segment, Object obj, int i2, ReferenceEntry referenceEntry) {
                    WeakWriteEntry weakWriteEntry = new WeakWriteEntry(segment.f42385h, obj, i2, referenceEntry);
                    weakWriteEntry.f42426d = Long.MAX_VALUE;
                    AnonymousClass1 anonymousClass1 = LocalCache.t;
                    NullEntry nullEntry = NullEntry.f42376a;
                    weakWriteEntry.f42427e = nullEntry;
                    weakWriteEntry.f42428f = nullEntry;
                    return weakWriteEntry;
                }
            };
            EntryFactory entryFactory8 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.8
                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry b(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                    ReferenceEntry referenceEntryB = super.b(segment, referenceEntry, referenceEntry2, obj);
                    EntryFactory.a(referenceEntry, referenceEntryB);
                    EntryFactory.c(referenceEntry, referenceEntryB);
                    return referenceEntryB;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public final ReferenceEntry d(Segment segment, Object obj, int i2, ReferenceEntry referenceEntry) {
                    WeakAccessWriteEntry weakAccessWriteEntry = new WeakAccessWriteEntry(segment.f42385h, obj, i2, referenceEntry);
                    weakAccessWriteEntry.f42416d = Long.MAX_VALUE;
                    AnonymousClass1 anonymousClass1 = LocalCache.t;
                    NullEntry nullEntry = NullEntry.f42376a;
                    weakAccessWriteEntry.f42417e = nullEntry;
                    weakAccessWriteEntry.f42418f = nullEntry;
                    weakAccessWriteEntry.f42419g = Long.MAX_VALUE;
                    weakAccessWriteEntry.f42420h = nullEntry;
                    weakAccessWriteEntry.f42421i = nullEntry;
                    return weakAccessWriteEntry;
                }
            };
            f42360b = new EntryFactory[]{entryFactory, entryFactory2, entryFactory3, entryFactory4, entryFactory5, entryFactory6, entryFactory7, entryFactory8};
            f42359a = new EntryFactory[]{entryFactory, entryFactory2, entryFactory3, entryFactory4, entryFactory5, entryFactory6, entryFactory7, entryFactory8};
        }

        public static void a(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            referenceEntry2.p(referenceEntry.q());
            ReferenceEntry referenceEntryD = referenceEntry.d();
            AnonymousClass1 anonymousClass1 = LocalCache.t;
            referenceEntryD.s(referenceEntry2);
            referenceEntry2.h(referenceEntryD);
            ReferenceEntry referenceEntryG = referenceEntry.g();
            referenceEntry2.s(referenceEntryG);
            referenceEntryG.h(referenceEntry2);
            NullEntry nullEntry = NullEntry.f42376a;
            referenceEntry.s(nullEntry);
            referenceEntry.h(nullEntry);
        }

        public static void c(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            referenceEntry2.r(referenceEntry.n());
            ReferenceEntry referenceEntryI = referenceEntry.i();
            AnonymousClass1 anonymousClass1 = LocalCache.t;
            referenceEntryI.t(referenceEntry2);
            referenceEntry2.u(referenceEntryI);
            ReferenceEntry referenceEntryE = referenceEntry.e();
            referenceEntry2.t(referenceEntryE);
            referenceEntryE.u(referenceEntry2);
            NullEntry nullEntry = NullEntry.f42376a;
            referenceEntry.t(nullEntry);
            referenceEntry.u(nullEntry);
        }

        public static EntryFactory valueOf(String str) {
            return (EntryFactory) Enum.valueOf(EntryFactory.class, str);
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) f42360b.clone();
        }

        public ReferenceEntry b(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
            return d(segment, obj, referenceEntry.b(), referenceEntry2);
        }

        public abstract ReferenceEntry d(Segment segment, Object obj, int i2, ReferenceEntry referenceEntry);
    }

    public final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
    }

    public final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        public EntrySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            LocalCache localCache;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = (localCache = LocalCache.this).get(key)) != null && localCache.f42346f.d(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    public abstract class HashIterator<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public int f42362a;

        /* renamed from: b, reason: collision with root package name */
        public int f42363b = -1;

        /* renamed from: c, reason: collision with root package name */
        public Segment f42364c;

        /* renamed from: d, reason: collision with root package name */
        public AtomicReferenceArray f42365d;

        /* renamed from: e, reason: collision with root package name */
        public ReferenceEntry f42366e;

        /* renamed from: f, reason: collision with root package name */
        public WriteThroughEntry f42367f;

        /* renamed from: g, reason: collision with root package name */
        public WriteThroughEntry f42368g;

        public HashIterator() {
            this.f42362a = LocalCache.this.f42343c.length - 1;
            a();
        }

        public final void a() {
            this.f42367f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i2 = this.f42362a;
                if (i2 < 0) {
                    return;
                }
                Segment[] segmentArr = LocalCache.this.f42343c;
                this.f42362a = i2 - 1;
                Segment segment = segmentArr[i2];
                this.f42364c = segment;
                if (segment.f42379b != 0) {
                    this.f42365d = this.f42364c.f42383f;
                    this.f42363b = r0.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public final boolean b(ReferenceEntry referenceEntry) {
            Object obj;
            LocalCache localCache = LocalCache.this;
            try {
                localCache.f42353m.a();
                Object key = referenceEntry.getKey();
                Object obj2 = null;
                if (referenceEntry.getKey() != null && (obj = referenceEntry.a().get()) != null) {
                    obj2 = obj;
                }
                if (obj2 == null) {
                    this.f42364c.k();
                    return false;
                }
                this.f42367f = new WriteThroughEntry(key, obj2);
                this.f42364c.k();
                return true;
            } catch (Throwable th) {
                this.f42364c.k();
                throw th;
            }
        }

        public final WriteThroughEntry c() {
            WriteThroughEntry writeThroughEntry = this.f42367f;
            if (writeThroughEntry == null) {
                throw new NoSuchElementException();
            }
            this.f42368g = writeThroughEntry;
            a();
            return this.f42368g;
        }

        public final boolean d() {
            ReferenceEntry referenceEntry = this.f42366e;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.f42366e = referenceEntry.c();
                ReferenceEntry referenceEntry2 = this.f42366e;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (b(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.f42366e;
            }
        }

        public final boolean e() {
            while (true) {
                int i2 = this.f42363b;
                if (i2 < 0) {
                    return false;
                }
                AtomicReferenceArray atomicReferenceArray = this.f42365d;
                this.f42363b = i2 - 1;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i2);
                this.f42366e = referenceEntry;
                if (referenceEntry != null && (b(referenceEntry) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f42367f != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            return c();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Preconditions.n(this.f42368g != null);
            LocalCache.this.remove(this.f42368g.f42432a);
            this.f42368g = null;
        }
    }

    public final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public final Object next() {
            return c().f42432a;
        }
    }

    public final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        public KeySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return LocalCache.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            return LocalCache.this.remove(obj) != null;
        }
    }

    public static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            throw null;
        }
    }

    public static class LoadingValueReference<K, V> implements ValueReference<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public volatile ValueReference f42371a;

        /* renamed from: b, reason: collision with root package name */
        public final SettableFuture f42372b;

        /* renamed from: c, reason: collision with root package name */
        public final Stopwatch f42373c;

        /* renamed from: d, reason: collision with root package name */
        public final Thread f42374d;

        public LoadingValueReference() {
            AnonymousClass1 anonymousClass1 = LocalCache.t;
            this.f42372b = new SettableFuture();
            this.f42373c = new Stopwatch();
            this.f42371a = anonymousClass1;
            this.f42374d = Thread.currentThread();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final boolean a() {
            return this.f42371a.a();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final boolean b() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final ReferenceEntry c() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final void d(Object obj) {
            if (obj != null) {
                this.f42372b.n(obj);
            } else {
                this.f42371a = LocalCache.t;
            }
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final int e() {
            return this.f42371a.e();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final ValueReference f(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final Object g() {
            return Uninterruptibles.a(this.f42372b);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final Object get() {
            return this.f42371a.get();
        }

        /* JADX WARN: Type inference failed for: r6v6, types: [com.google.common.cache.a] */
        public final ListenableFuture h(Object obj, CacheLoader cacheLoader) {
            try {
                Stopwatch stopwatch = this.f42373c;
                Preconditions.m("This stopwatch is already running.", !stopwatch.f42311a);
                stopwatch.f42311a = true;
                stopwatch.f42312b = System.nanoTime();
                Object obj2 = this.f42371a.get();
                if (obj2 == null) {
                    Object objA = cacheLoader.a(obj);
                    return this.f42372b.n(objA) ? this.f42372b : Futures.d(objA);
                }
                ListenableFuture listenableFutureB = cacheLoader.b(obj, obj2);
                return listenableFutureB == null ? Futures.d(null) : Futures.f(listenableFutureB, new Function() { // from class: com.google.common.cache.a
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj3) {
                        this.f42453a.f42372b.n(obj3);
                        return obj3;
                    }
                });
            } catch (Throwable th) {
                ListenableFuture listenableFutureC = this.f42372b.o(th) ? this.f42372b : Futures.c(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return listenableFutureC;
            }
        }
    }

    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            try {
                return get(obj);
            } catch (ExecutionException e2) {
                throw new UncheckedExecutionException(e2.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public final Object get(Object obj) {
            ReferenceEntry referenceEntryH;
            LocalCache localCache = this.f42375a;
            CacheLoader cacheLoader = localCache.p;
            obj.getClass();
            int iC = localCache.c(obj);
            Segment segmentD = localCache.d(iC);
            segmentD.getClass();
            cacheLoader.getClass();
            try {
                try {
                    if (segmentD.f42379b != 0 && (referenceEntryH = segmentD.h(iC, obj)) != null) {
                        long jA = segmentD.f42378a.f42353m.a();
                        Object objI = segmentD.i(referenceEntryH, jA);
                        if (objI != null) {
                            segmentD.n(referenceEntryH, jA);
                            segmentD.n.e();
                            segmentD.f42378a.getClass();
                            return objI;
                        }
                        ValueReference valueReferenceA = referenceEntryH.a();
                        if (valueReferenceA.b()) {
                            return segmentD.x(referenceEntryH, obj, valueReferenceA);
                        }
                    }
                    return segmentD.j(obj, iC, cacheLoader);
                } catch (ExecutionException e2) {
                    Throwable cause = e2.getCause();
                    if (cause instanceof Error) {
                        throw new ExecutionError((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new UncheckedExecutionException(cause);
                    }
                    throw e2;
                }
            } finally {
                segmentD.k();
            }
        }
    }

    public static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final LocalCache f42375a;

        /* renamed from: com.google.common.cache.LocalCache$LocalManualCache$1, reason: invalid class name */
        class AnonymousClass1 extends CacheLoader<Object, Object> {
            @Override // com.google.common.cache.CacheLoader
            public final Object a(Object obj) {
                throw null;
            }
        }

        public LocalManualCache(LocalCache localCache) {
            this.f42375a = localCache;
        }
    }

    public static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public final /* bridge */ /* synthetic */ Object t() {
            return null;
        }

        @Override // com.google.common.cache.ForwardingCache
        /* renamed from: u */
        public final Cache t() {
            return null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class NullEntry implements ReferenceEntry<Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final NullEntry f42376a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ NullEntry[] f42377b;

        static {
            NullEntry nullEntry = new NullEntry("INSTANCE", 0);
            f42376a = nullEntry;
            f42377b = new NullEntry[]{nullEntry};
        }

        public static NullEntry valueOf(String str) {
            return (NullEntry) Enum.valueOf(NullEntry.class, str);
        }

        public static NullEntry[] values() {
            return (NullEntry[]) f42377b.clone();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final ValueReference a() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final int b() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final ReferenceEntry c() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final ReferenceEntry d() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final ReferenceEntry e() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final ReferenceEntry g() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final void h(ReferenceEntry referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final ReferenceEntry i() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final void l(ValueReference valueReference) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final long n() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final void p(long j2) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final long q() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final void r(long j2) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final void s(ReferenceEntry referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final void t(ReferenceEntry referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final void u(ReferenceEntry referenceEntry) {
        }
    }

    public static class Segment<K, V> extends ReentrantLock {

        /* renamed from: a, reason: collision with root package name */
        public final LocalCache f42378a;

        /* renamed from: b, reason: collision with root package name */
        public volatile int f42379b;

        /* renamed from: c, reason: collision with root package name */
        public long f42380c;

        /* renamed from: d, reason: collision with root package name */
        public int f42381d;

        /* renamed from: e, reason: collision with root package name */
        public int f42382e;

        /* renamed from: f, reason: collision with root package name */
        public volatile AtomicReferenceArray f42383f;

        /* renamed from: g, reason: collision with root package name */
        public final long f42384g;

        /* renamed from: h, reason: collision with root package name */
        public final ReferenceQueue f42385h;

        /* renamed from: i, reason: collision with root package name */
        public final ReferenceQueue f42386i;

        /* renamed from: j, reason: collision with root package name */
        public final AbstractQueue f42387j;

        /* renamed from: k, reason: collision with root package name */
        public final AtomicInteger f42388k = new AtomicInteger();

        /* renamed from: l, reason: collision with root package name */
        public final AbstractQueue f42389l;

        /* renamed from: m, reason: collision with root package name */
        public final AbstractQueue f42390m;
        public final AbstractCache.StatsCounter n;

        public Segment(LocalCache localCache, int i2, long j2, AbstractCache.StatsCounter statsCounter) {
            this.f42378a = localCache;
            this.f42384g = j2;
            statsCounter.getClass();
            this.n = statsCounter;
            AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i2);
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.f42382e = length;
            if (localCache.f42350j == CacheBuilder.OneWeigher.f42338a && length == j2) {
                this.f42382e = length + 1;
            }
            this.f42383f = atomicReferenceArray;
            Strength.AnonymousClass1 anonymousClass1 = Strength.f42392a;
            this.f42385h = localCache.f42347g != anonymousClass1 ? new ReferenceQueue() : null;
            this.f42386i = localCache.f42348h != anonymousClass1 ? new ReferenceQueue() : null;
            this.f42387j = (AbstractQueue) (localCache.b() ? new ConcurrentLinkedQueue() : LocalCache.u);
            Collection collection = LocalCache.u;
            this.f42389l = (AbstractQueue) collection;
            this.f42390m = (AbstractQueue) (localCache.b() ? new AccessQueue() : collection);
        }

        public final ReferenceEntry a(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            Object key = referenceEntry.getKey();
            if (key == null) {
                return null;
            }
            ValueReference valueReferenceA = referenceEntry.a();
            Object obj = valueReferenceA.get();
            if (obj == null && valueReferenceA.a()) {
                return null;
            }
            ReferenceEntry referenceEntryB = this.f42378a.n.b(this, referenceEntry, referenceEntry2, key);
            referenceEntryB.l(valueReferenceA.f(this.f42386i, obj, referenceEntryB));
            return referenceEntryB;
        }

        public final void b() {
            while (true) {
                ReferenceEntry referenceEntry = (ReferenceEntry) this.f42387j.poll();
                if (referenceEntry == null) {
                    return;
                }
                AbstractQueue abstractQueue = this.f42390m;
                if (abstractQueue.contains(referenceEntry)) {
                    abstractQueue.add(referenceEntry);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        
            r4.f42381d++;
            r5 = r4.r(r6, r6, r6.getKey(), r6.a().get(), r6.a(), r10);
            r6 = r4.f42379b - 1;
            r12.set(r13, r5);
            r4.f42379b = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00f8, code lost:
        
            r4.t();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 300
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.c():void");
        }

        public final void d(Object obj, Object obj2, int i2, RemovalCause removalCause) {
            this.f42380c -= i2;
            if (removalCause.a()) {
                this.n.b();
            }
            LocalCache localCache = this.f42378a;
            if (localCache.f42351k != LocalCache.u) {
                new RemovalNotification(obj, obj2);
                localCache.f42351k.getClass();
            }
        }

        public final void e(ReferenceEntry referenceEntry) {
            if (this.f42378a.b()) {
                b();
                long jE = referenceEntry.a().e();
                long j2 = this.f42384g;
                RemovalCause removalCause = RemovalCause.f42439d;
                if (jE > j2 && !p(referenceEntry, referenceEntry.b(), removalCause)) {
                    throw new AssertionError();
                }
                while (this.f42380c > j2) {
                    for (ReferenceEntry referenceEntry2 : this.f42390m) {
                        if (referenceEntry2.a().e() > 0) {
                            if (!p(referenceEntry2, referenceEntry2.b(), removalCause)) {
                                throw new AssertionError();
                            }
                        }
                    }
                    throw new AssertionError();
                }
            }
        }

        public final void f() {
            AtomicReferenceArray atomicReferenceArray = this.f42383f;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i2 = this.f42379b;
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(length << 1);
            this.f42382e = (atomicReferenceArray2.length() * 3) / 4;
            int length2 = atomicReferenceArray2.length() - 1;
            for (int i3 = 0; i3 < length; i3++) {
                ReferenceEntry referenceEntryC = (ReferenceEntry) atomicReferenceArray.get(i3);
                if (referenceEntryC != null) {
                    ReferenceEntry referenceEntryC2 = referenceEntryC.c();
                    int iB = referenceEntryC.b() & length2;
                    if (referenceEntryC2 == null) {
                        atomicReferenceArray2.set(iB, referenceEntryC);
                    } else {
                        ReferenceEntry referenceEntry = referenceEntryC;
                        while (referenceEntryC2 != null) {
                            int iB2 = referenceEntryC2.b() & length2;
                            if (iB2 != iB) {
                                referenceEntry = referenceEntryC2;
                                iB = iB2;
                            }
                            referenceEntryC2 = referenceEntryC2.c();
                        }
                        atomicReferenceArray2.set(iB, referenceEntry);
                        while (referenceEntryC != referenceEntry) {
                            int iB3 = referenceEntryC.b() & length2;
                            ReferenceEntry referenceEntryA = a(referenceEntryC, (ReferenceEntry) atomicReferenceArray2.get(iB3));
                            if (referenceEntryA != null) {
                                atomicReferenceArray2.set(iB3, referenceEntryA);
                            } else {
                                o(referenceEntryC);
                                i2--;
                            }
                            referenceEntryC = referenceEntryC.c();
                        }
                    }
                }
            }
            this.f42383f = atomicReferenceArray2;
            this.f42379b = i2;
        }

        public final Object g(Object obj, int i2, LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) throws Throwable {
            Object objA;
            AbstractCache.StatsCounter statsCounter = this.n;
            try {
                objA = Uninterruptibles.a(listenableFuture);
            } catch (Throwable th) {
                th = th;
                objA = null;
            }
            try {
                if (objA == null) {
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + obj + CLConstants.DOT_SALT_DELIMETER);
                }
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                Stopwatch stopwatch = loadingValueReference.f42373c;
                statsCounter.d(timeUnit.convert(stopwatch.f42311a ? System.nanoTime() - stopwatch.f42312b : 0L, timeUnit));
                v(obj, i2, loadingValueReference, objA);
                return objA;
            } catch (Throwable th2) {
                th = th2;
                if (objA == null) {
                    TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                    Stopwatch stopwatch2 = loadingValueReference.f42373c;
                    statsCounter.c(timeUnit2.convert(stopwatch2.f42311a ? System.nanoTime() - stopwatch2.f42312b : 0L, timeUnit2));
                    lock();
                    try {
                        AtomicReferenceArray atomicReferenceArray = this.f42383f;
                        int length = (atomicReferenceArray.length() - 1) & i2;
                        ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                        ReferenceEntry referenceEntryC = referenceEntry;
                        while (true) {
                            if (referenceEntryC == null) {
                                break;
                            }
                            Object key = referenceEntryC.getKey();
                            if (referenceEntryC.b() != i2 || key == null || !this.f42378a.f42345e.d(obj, key)) {
                                referenceEntryC = referenceEntryC.c();
                            } else if (referenceEntryC.a() == loadingValueReference) {
                                if (loadingValueReference.f42371a.a()) {
                                    referenceEntryC.l(loadingValueReference.f42371a);
                                } else {
                                    atomicReferenceArray.set(length, q(referenceEntry, referenceEntryC));
                                }
                            }
                        }
                        unlock();
                        t();
                    } catch (Throwable th3) {
                        unlock();
                        t();
                        throw th3;
                    }
                }
                throw th;
            }
        }

        public final ReferenceEntry h(int i2, Object obj) {
            for (ReferenceEntry referenceEntryC = (ReferenceEntry) this.f42383f.get((r0.length() - 1) & i2); referenceEntryC != null; referenceEntryC = referenceEntryC.c()) {
                if (referenceEntryC.b() == i2) {
                    Object key = referenceEntryC.getKey();
                    if (key == null) {
                        w();
                    } else if (this.f42378a.f42345e.d(obj, key)) {
                        return referenceEntryC;
                    }
                }
            }
            return null;
        }

        public final Object i(ReferenceEntry referenceEntry, long j2) {
            if (referenceEntry.getKey() == null) {
                w();
                return null;
            }
            Object obj = referenceEntry.a().get();
            if (obj == null) {
                w();
                return null;
            }
            this.f42378a.getClass();
            return obj;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
        
            if (r3 == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
        
            r8 = new com.google.common.cache.LocalCache.LoadingValueReference();
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0085, code lost:
        
            if (r7 != null) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0087, code lost:
        
            r0 = r12.f42378a.n;
            r13.getClass();
            r7 = r0.d(r12, r13, r14, r6);
            r7.l(r8);
            r4.set(r5, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0099, code lost:
        
            r7.l(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x009c, code lost:
        
            unlock();
            t();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a2, code lost:
        
            if (r3 == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00b1, code lost:
        
            return g(r13, r14, r8, r8.h(r13, r15));
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
        
            r13 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00b3, code lost:
        
            r12.n.a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
        
            throw r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00bd, code lost:
        
            return x(r7, r13, r10);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object j(java.lang.Object r13, int r14, com.google.common.cache.CacheLoader r15) {
            /*
                r12 = this;
                r12.lock()
                com.google.common.cache.LocalCache r0 = r12.f42378a     // Catch: java.lang.Throwable -> L62
                com.google.common.base.Ticker r0 = r0.f42353m     // Catch: java.lang.Throwable -> L62
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L62
                r12.s(r0)     // Catch: java.lang.Throwable -> L62
                int r2 = r12.f42379b     // Catch: java.lang.Throwable -> L62
                r3 = 1
                int r2 = r2 - r3
                java.util.concurrent.atomic.AtomicReferenceArray r4 = r12.f42383f     // Catch: java.lang.Throwable -> L62
                int r5 = r4.length()     // Catch: java.lang.Throwable -> L62
                int r5 = r5 - r3
                r5 = r5 & r14
                java.lang.Object r6 = r4.get(r5)     // Catch: java.lang.Throwable -> L62
                com.google.common.cache.ReferenceEntry r6 = (com.google.common.cache.ReferenceEntry) r6     // Catch: java.lang.Throwable -> L62
                r7 = r6
            L21:
                r8 = 0
                if (r7 == 0) goto L7d
                java.lang.Object r9 = r7.getKey()     // Catch: java.lang.Throwable -> L62
                int r10 = r7.b()     // Catch: java.lang.Throwable -> L62
                if (r10 != r14) goto L78
                if (r9 == 0) goto L78
                com.google.common.cache.LocalCache r10 = r12.f42378a     // Catch: java.lang.Throwable -> L62
                com.google.common.base.Equivalence r10 = r10.f42345e     // Catch: java.lang.Throwable -> L62
                boolean r10 = r10.d(r13, r9)     // Catch: java.lang.Throwable -> L62
                if (r10 == 0) goto L78
                com.google.common.cache.LocalCache$ValueReference r10 = r7.a()     // Catch: java.lang.Throwable -> L62
                boolean r11 = r10.b()     // Catch: java.lang.Throwable -> L62
                if (r11 == 0) goto L46
                r3 = 0
                goto L7e
            L46:
                java.lang.Object r11 = r10.get()     // Catch: java.lang.Throwable -> L62
                if (r11 != 0) goto L64
                int r0 = r10.e()     // Catch: java.lang.Throwable -> L62
                com.google.common.cache.RemovalCause r1 = com.google.common.cache.RemovalCause.f42438c     // Catch: java.lang.Throwable -> L62
                r12.d(r9, r11, r0, r1)     // Catch: java.lang.Throwable -> L62
                java.util.AbstractQueue r0 = r12.f42389l     // Catch: java.lang.Throwable -> L62
                r0.remove(r7)     // Catch: java.lang.Throwable -> L62
                java.util.AbstractQueue r0 = r12.f42390m     // Catch: java.lang.Throwable -> L62
                r0.remove(r7)     // Catch: java.lang.Throwable -> L62
                r12.f42379b = r2     // Catch: java.lang.Throwable -> L62
                goto L7e
            L62:
                r13 = move-exception
                goto Lbe
            L64:
                com.google.common.cache.LocalCache r13 = r12.f42378a     // Catch: java.lang.Throwable -> L62
                r13.getClass()     // Catch: java.lang.Throwable -> L62
                r12.m(r7, r0)     // Catch: java.lang.Throwable -> L62
                com.google.common.cache.AbstractCache$StatsCounter r13 = r12.n     // Catch: java.lang.Throwable -> L62
                r13.e()     // Catch: java.lang.Throwable -> L62
                r12.unlock()
                r12.t()
                return r11
            L78:
                com.google.common.cache.ReferenceEntry r7 = r7.c()     // Catch: java.lang.Throwable -> L62
                goto L21
            L7d:
                r10 = r8
            L7e:
                if (r3 == 0) goto L9c
                com.google.common.cache.LocalCache$LoadingValueReference r8 = new com.google.common.cache.LocalCache$LoadingValueReference     // Catch: java.lang.Throwable -> L62
                r8.<init>()     // Catch: java.lang.Throwable -> L62
                if (r7 != 0) goto L99
                com.google.common.cache.LocalCache r0 = r12.f42378a     // Catch: java.lang.Throwable -> L62
                com.google.common.cache.LocalCache$EntryFactory r0 = r0.n     // Catch: java.lang.Throwable -> L62
                r13.getClass()     // Catch: java.lang.Throwable -> L62
                com.google.common.cache.ReferenceEntry r7 = r0.d(r12, r13, r14, r6)     // Catch: java.lang.Throwable -> L62
                r7.l(r8)     // Catch: java.lang.Throwable -> L62
                r4.set(r5, r7)     // Catch: java.lang.Throwable -> L62
                goto L9c
            L99:
                r7.l(r8)     // Catch: java.lang.Throwable -> L62
            L9c:
                r12.unlock()
                r12.t()
                if (r3 == 0) goto Lb9
                com.google.common.util.concurrent.ListenableFuture r15 = r8.h(r13, r15)     // Catch: java.lang.Throwable -> Lb2
                java.lang.Object r13 = r12.g(r13, r14, r8, r15)     // Catch: java.lang.Throwable -> Lb2
                com.google.common.cache.AbstractCache$StatsCounter r14 = r12.n
                r14.a()
                return r13
            Lb2:
                r13 = move-exception
                com.google.common.cache.AbstractCache$StatsCounter r14 = r12.n
                r14.a()
                throw r13
            Lb9:
                java.lang.Object r13 = r12.x(r7, r13, r10)
                return r13
            Lbe:
                r12.unlock()
                r12.t()
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.j(java.lang.Object, int, com.google.common.cache.CacheLoader):java.lang.Object");
        }

        public final void k() {
            if ((this.f42388k.incrementAndGet() & 63) == 0) {
                s(this.f42378a.f42353m.a());
                t();
            }
        }

        public final Object l(Object obj, int i2, Object obj2, boolean z) {
            int i3;
            lock();
            try {
                long jA = this.f42378a.f42353m.a();
                s(jA);
                if (this.f42379b + 1 > this.f42382e) {
                    f();
                }
                AtomicReferenceArray atomicReferenceArray = this.f42383f;
                int length = (atomicReferenceArray.length() - 1) & i2;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntryC = referenceEntry; referenceEntryC != null; referenceEntryC = referenceEntryC.c()) {
                    Object key = referenceEntryC.getKey();
                    if (referenceEntryC.b() == i2 && key != null && this.f42378a.f42345e.d(obj, key)) {
                        ValueReference valueReferenceA = referenceEntryC.a();
                        Object obj3 = valueReferenceA.get();
                        if (obj3 == null) {
                            this.f42381d++;
                            if (valueReferenceA.a()) {
                                d(obj, obj3, valueReferenceA.e(), RemovalCause.f42438c);
                                u(referenceEntryC, obj2, jA);
                                i3 = this.f42379b;
                            } else {
                                u(referenceEntryC, obj2, jA);
                                i3 = this.f42379b + 1;
                            }
                            this.f42379b = i3;
                            e(referenceEntryC);
                            unlock();
                            t();
                            return null;
                        }
                        if (z) {
                            m(referenceEntryC, jA);
                            unlock();
                            t();
                            return obj3;
                        }
                        this.f42381d++;
                        d(obj, obj3, valueReferenceA.e(), RemovalCause.f42437b);
                        u(referenceEntryC, obj2, jA);
                        e(referenceEntryC);
                        unlock();
                        t();
                        return obj3;
                    }
                }
                this.f42381d++;
                ReferenceEntry referenceEntryD = this.f42378a.n.d(this, obj, i2, referenceEntry);
                u(referenceEntryD, obj2, jA);
                atomicReferenceArray.set(length, referenceEntryD);
                this.f42379b++;
                e(referenceEntryD);
                unlock();
                t();
                return null;
            } catch (Throwable th) {
                unlock();
                t();
                throw th;
            }
        }

        public final void m(ReferenceEntry referenceEntry, long j2) {
            this.f42378a.getClass();
            this.f42390m.add(referenceEntry);
        }

        public final void n(ReferenceEntry referenceEntry, long j2) {
            this.f42378a.getClass();
            this.f42387j.add(referenceEntry);
        }

        public final void o(ReferenceEntry referenceEntry) {
            Object key = referenceEntry.getKey();
            referenceEntry.b();
            d(key, referenceEntry.a().get(), referenceEntry.a().e(), RemovalCause.f42438c);
            this.f42389l.remove(referenceEntry);
            this.f42390m.remove(referenceEntry);
        }

        public final boolean p(ReferenceEntry referenceEntry, int i2, RemovalCause removalCause) {
            AtomicReferenceArray atomicReferenceArray = this.f42383f;
            int length = i2 & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntryC = referenceEntry2; referenceEntryC != null; referenceEntryC = referenceEntryC.c()) {
                if (referenceEntryC == referenceEntry) {
                    this.f42381d++;
                    ReferenceEntry referenceEntryR = r(referenceEntry2, referenceEntryC, referenceEntryC.getKey(), referenceEntryC.a().get(), referenceEntryC.a(), removalCause);
                    int i3 = this.f42379b - 1;
                    atomicReferenceArray.set(length, referenceEntryR);
                    this.f42379b = i3;
                    return true;
                }
            }
            return false;
        }

        public final ReferenceEntry q(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            int i2 = this.f42379b;
            ReferenceEntry referenceEntryC = referenceEntry2.c();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry referenceEntryA = a(referenceEntry, referenceEntryC);
                if (referenceEntryA != null) {
                    referenceEntryC = referenceEntryA;
                } else {
                    o(referenceEntry);
                    i2--;
                }
                referenceEntry = referenceEntry.c();
            }
            this.f42379b = i2;
            return referenceEntryC;
        }

        public final ReferenceEntry r(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj, Object obj2, ValueReference valueReference, RemovalCause removalCause) {
            d(obj, obj2, valueReference.e(), removalCause);
            this.f42389l.remove(referenceEntry2);
            this.f42390m.remove(referenceEntry2);
            if (!valueReference.b()) {
                return q(referenceEntry, referenceEntry2);
            }
            valueReference.d(null);
            return referenceEntry;
        }

        public final void s(long j2) {
            if (tryLock()) {
                try {
                    c();
                    b();
                    ReferenceEntry referenceEntry = (ReferenceEntry) this.f42389l.peek();
                    LocalCache localCache = this.f42378a;
                    if (referenceEntry != null) {
                        localCache.getClass();
                    }
                    if (((ReferenceEntry) this.f42390m.peek()) != null) {
                        localCache.getClass();
                    }
                    this.f42388k.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public final void t() {
            if (isHeldByCurrentThread()) {
                return;
            }
            ((AnonymousClass2) this.f42378a.f42351k).getClass();
        }

        public final void u(ReferenceEntry referenceEntry, Object obj, long j2) {
            ValueReference valueReferenceA = referenceEntry.a();
            LocalCache localCache = this.f42378a;
            ((CacheBuilder.OneWeigher) localCache.f42350j).getClass();
            localCache.f42348h.getClass();
            referenceEntry.l(new StrongValueReference(obj));
            b();
            this.f42380c++;
            this.f42390m.add(referenceEntry);
            this.f42389l.add(referenceEntry);
            valueReferenceA.d(obj);
        }

        public final void v(Object obj, int i2, LoadingValueReference loadingValueReference, Object obj2) {
            lock();
            try {
                long jA = this.f42378a.f42353m.a();
                s(jA);
                int i3 = this.f42379b + 1;
                if (i3 > this.f42382e) {
                    f();
                    i3 = this.f42379b + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.f42383f;
                int length = (atomicReferenceArray.length() - 1) & i2;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntryC = referenceEntry; referenceEntryC != null; referenceEntryC = referenceEntryC.c()) {
                    Object key = referenceEntryC.getKey();
                    if (referenceEntryC.b() == i2 && key != null && this.f42378a.f42345e.d(obj, key)) {
                        ValueReference valueReferenceA = referenceEntryC.a();
                        Object obj3 = valueReferenceA.get();
                        RemovalCause removalCause = RemovalCause.f42437b;
                        if (loadingValueReference != valueReferenceA && (obj3 != null || valueReferenceA == LocalCache.t)) {
                            d(obj, obj2, 0, removalCause);
                            unlock();
                            t();
                            return;
                        }
                        this.f42381d++;
                        if (loadingValueReference.f42371a.a()) {
                            if (obj3 == null) {
                                removalCause = RemovalCause.f42438c;
                            }
                            d(obj, obj3, loadingValueReference.f42371a.e(), removalCause);
                            i3--;
                        }
                        u(referenceEntryC, obj2, jA);
                        this.f42379b = i3;
                        e(referenceEntryC);
                        unlock();
                        t();
                        return;
                    }
                }
                this.f42381d++;
                EntryFactory entryFactory = this.f42378a.n;
                obj.getClass();
                ReferenceEntry referenceEntryD = entryFactory.d(this, obj, i2, referenceEntry);
                u(referenceEntryD, obj2, jA);
                atomicReferenceArray.set(length, referenceEntryD);
                this.f42379b = i3;
                e(referenceEntryD);
                unlock();
                t();
            } catch (Throwable th) {
                unlock();
                t();
                throw th;
            }
        }

        public final void w() {
            if (tryLock()) {
                try {
                    c();
                } finally {
                    unlock();
                }
            }
        }

        public final Object x(ReferenceEntry referenceEntry, Object obj, ValueReference valueReference) {
            AbstractCache.StatsCounter statsCounter = this.n;
            if (!valueReference.b()) {
                throw new AssertionError();
            }
            if (valueReference instanceof LoadingValueReference) {
                Preconditions.o(((LoadingValueReference) valueReference).f42374d != Thread.currentThread(), "Recursive load of: %s", obj);
            }
            try {
                Object objG = valueReference.g();
                if (objG != null) {
                    n(referenceEntry, this.f42378a.f42353m.a());
                    return objG;
                }
                throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + obj + CLConstants.DOT_SALT_DELIMETER);
            } finally {
                statsCounter.a();
            }
        }
    }

    public static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final ReferenceEntry f42391a;

        public SoftValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.f42391a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final boolean a() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final boolean b() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final ReferenceEntry c() {
            return this.f42391a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final void d(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int e() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference f(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new SoftValueReference(referenceQueue, obj, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final Object g() {
            return get();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class Strength {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f42392a;

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass3 f42393b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Strength[] f42394c;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.cache.LocalCache$Strength$1] */
        /* JADX WARN: Type inference failed for: r2v0, types: [com.google.common.cache.LocalCache$Strength$3] */
        static {
            ?? r0 = new Strength() { // from class: com.google.common.cache.LocalCache.Strength.1
                @Override // com.google.common.cache.LocalCache.Strength
                public final Equivalence a() {
                    return Equivalence.c();
                }
            };
            f42392a = r0;
            Strength strength = new Strength() { // from class: com.google.common.cache.LocalCache.Strength.2
                @Override // com.google.common.cache.LocalCache.Strength
                public final Equivalence a() {
                    return Equivalence.e();
                }
            };
            ?? r2 = new Strength() { // from class: com.google.common.cache.LocalCache.Strength.3
                @Override // com.google.common.cache.LocalCache.Strength
                public final Equivalence a() {
                    return Equivalence.e();
                }
            };
            f42393b = r2;
            f42394c = new Strength[]{r0, strength, r2};
        }

        public static Strength valueOf(String str) {
            return (Strength) Enum.valueOf(Strength.class, str);
        }

        public static Strength[] values() {
            return (Strength[]) f42394c.clone();
        }

        public abstract Equivalence a();
    }

    public static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {

        /* renamed from: e, reason: collision with root package name */
        public volatile long f42395e;

        /* renamed from: f, reason: collision with root package name */
        public ReferenceEntry f42396f;

        /* renamed from: g, reason: collision with root package name */
        public ReferenceEntry f42397g;

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry d() {
            return this.f42397g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry g() {
            return this.f42396f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void h(ReferenceEntry referenceEntry) {
            this.f42397g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void p(long j2) {
            this.f42395e = j2;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final long q() {
            return this.f42395e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void s(ReferenceEntry referenceEntry) {
            this.f42396f = referenceEntry;
        }
    }

    public static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {

        /* renamed from: e, reason: collision with root package name */
        public volatile long f42398e;

        /* renamed from: f, reason: collision with root package name */
        public ReferenceEntry f42399f;

        /* renamed from: g, reason: collision with root package name */
        public ReferenceEntry f42400g;

        /* renamed from: h, reason: collision with root package name */
        public volatile long f42401h;

        /* renamed from: i, reason: collision with root package name */
        public ReferenceEntry f42402i;

        /* renamed from: j, reason: collision with root package name */
        public ReferenceEntry f42403j;

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry d() {
            return this.f42400g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry e() {
            return this.f42402i;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry g() {
            return this.f42399f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void h(ReferenceEntry referenceEntry) {
            this.f42400g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry i() {
            return this.f42403j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final long n() {
            return this.f42401h;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void p(long j2) {
            this.f42398e = j2;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final long q() {
            return this.f42398e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void r(long j2) {
            this.f42401h = j2;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void s(ReferenceEntry referenceEntry) {
            this.f42399f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void t(ReferenceEntry referenceEntry) {
            this.f42402i = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void u(ReferenceEntry referenceEntry) {
            this.f42403j = referenceEntry;
        }
    }

    public static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42404a;

        /* renamed from: b, reason: collision with root package name */
        public final int f42405b;

        /* renamed from: c, reason: collision with root package name */
        public final ReferenceEntry f42406c;

        /* renamed from: d, reason: collision with root package name */
        public volatile ValueReference f42407d = LocalCache.t;

        public StrongEntry(Object obj, int i2, ReferenceEntry referenceEntry) {
            this.f42404a = obj;
            this.f42405b = i2;
            this.f42406c = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final ValueReference a() {
            return this.f42407d;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final int b() {
            return this.f42405b;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry c() {
            return this.f42406c;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final Object getKey() {
            return this.f42404a;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void l(ValueReference valueReference) {
            this.f42407d = valueReference;
        }
    }

    public static class StrongValueReference<K, V> implements ValueReference<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42408a;

        public StrongValueReference(Object obj) {
            this.f42408a = obj;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final boolean a() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final boolean b() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final ReferenceEntry c() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final void d(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int e() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final ValueReference f(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final Object g() {
            return this.f42408a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final Object get() {
            return this.f42408a;
        }
    }

    public static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {

        /* renamed from: e, reason: collision with root package name */
        public volatile long f42409e;

        /* renamed from: f, reason: collision with root package name */
        public ReferenceEntry f42410f;

        /* renamed from: g, reason: collision with root package name */
        public ReferenceEntry f42411g;

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry e() {
            return this.f42410f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry i() {
            return this.f42411g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final long n() {
            return this.f42409e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void r(long j2) {
            this.f42409e = j2;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void t(ReferenceEntry referenceEntry) {
            this.f42410f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public final void u(ReferenceEntry referenceEntry) {
            this.f42411g = referenceEntry;
        }
    }

    public final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public final Object next() {
            return c().f42433b;
        }
    }

    public interface ValueReference<K, V> {
        boolean a();

        boolean b();

        ReferenceEntry c();

        void d(Object obj);

        int e();

        ValueReference f(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry);

        Object g();

        Object get();
    }

    public final class Values extends AbstractCollection<V> {
        public Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return LocalCache.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray() {
            return LocalCache.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            return LocalCache.a(this).toArray(objArr);
        }
    }

    public static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {

        /* renamed from: d, reason: collision with root package name */
        public volatile long f42413d;

        /* renamed from: e, reason: collision with root package name */
        public ReferenceEntry f42414e;

        /* renamed from: f, reason: collision with root package name */
        public ReferenceEntry f42415f;

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry d() {
            return this.f42415f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry g() {
            return this.f42414e;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void h(ReferenceEntry referenceEntry) {
            this.f42415f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void p(long j2) {
            this.f42413d = j2;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final long q() {
            return this.f42413d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void s(ReferenceEntry referenceEntry) {
            this.f42414e = referenceEntry;
        }
    }

    public static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {

        /* renamed from: d, reason: collision with root package name */
        public volatile long f42416d;

        /* renamed from: e, reason: collision with root package name */
        public ReferenceEntry f42417e;

        /* renamed from: f, reason: collision with root package name */
        public ReferenceEntry f42418f;

        /* renamed from: g, reason: collision with root package name */
        public volatile long f42419g;

        /* renamed from: h, reason: collision with root package name */
        public ReferenceEntry f42420h;

        /* renamed from: i, reason: collision with root package name */
        public ReferenceEntry f42421i;

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry d() {
            return this.f42418f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry e() {
            return this.f42420h;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry g() {
            return this.f42417e;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void h(ReferenceEntry referenceEntry) {
            this.f42418f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry i() {
            return this.f42421i;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final long n() {
            return this.f42419g;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void p(long j2) {
            this.f42416d = j2;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final long q() {
            return this.f42416d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void r(long j2) {
            this.f42419g = j2;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void s(ReferenceEntry referenceEntry) {
            this.f42417e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void t(ReferenceEntry referenceEntry) {
            this.f42420h = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void u(ReferenceEntry referenceEntry) {
            this.f42421i = referenceEntry;
        }
    }

    public static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final int f42422a;

        /* renamed from: b, reason: collision with root package name */
        public final ReferenceEntry f42423b;

        /* renamed from: c, reason: collision with root package name */
        public volatile ValueReference f42424c;

        public WeakEntry(ReferenceQueue referenceQueue, Object obj, int i2, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.f42424c = LocalCache.t;
            this.f42422a = i2;
            this.f42423b = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final ValueReference a() {
            return this.f42424c;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final int b() {
            return this.f42422a;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final ReferenceEntry c() {
            return this.f42423b;
        }

        public ReferenceEntry d() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry e() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry g() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final Object getKey() {
            return get();
        }

        public void h(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry i() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public final void l(ValueReference valueReference) {
            this.f42424c = valueReference;
        }

        public long n() {
            throw new UnsupportedOperationException();
        }

        public void p(long j2) {
            throw new UnsupportedOperationException();
        }

        public long q() {
            throw new UnsupportedOperationException();
        }

        public void r(long j2) {
            throw new UnsupportedOperationException();
        }

        public void s(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void t(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void u(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    public static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final ReferenceEntry f42425a;

        public WeakValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.f42425a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final boolean a() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final boolean b() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final ReferenceEntry c() {
            return this.f42425a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final void d(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int e() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference f(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeakValueReference(referenceQueue, obj, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public final Object g() {
            return get();
        }
    }

    public static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {

        /* renamed from: d, reason: collision with root package name */
        public volatile long f42426d;

        /* renamed from: e, reason: collision with root package name */
        public ReferenceEntry f42427e;

        /* renamed from: f, reason: collision with root package name */
        public ReferenceEntry f42428f;

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry e() {
            return this.f42427e;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final ReferenceEntry i() {
            return this.f42428f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final long n() {
            return this.f42426d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void r(long j2) {
            this.f42426d = j2;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void t(ReferenceEntry referenceEntry) {
            this.f42427e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public final void u(ReferenceEntry referenceEntry) {
            this.f42428f = referenceEntry;
        }
    }

    public static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public final int e() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public final ValueReference f(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeightedSoftValueReference(referenceQueue, obj, referenceEntry);
        }
    }

    public static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
        @Override // com.google.common.cache.LocalCache.StrongValueReference, com.google.common.cache.LocalCache.ValueReference
        public final int e() {
            throw null;
        }
    }

    public static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public final int e() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public final ValueReference f(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeightedWeakValueReference(referenceQueue, obj, referenceEntry);
        }
    }

    public static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* renamed from: com.google.common.cache.LocalCache$WriteQueue$1, reason: invalid class name */
        public class AnonymousClass1 extends AbstractReferenceEntry<K, V> {

            /* renamed from: a, reason: collision with root package name */
            public ReferenceEntry f42429a;

            /* renamed from: b, reason: collision with root package name */
            public ReferenceEntry f42430b;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final ReferenceEntry e() {
                return this.f42429a;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final ReferenceEntry i() {
                return this.f42430b;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final long n() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final void r(long j2) {
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final void t(ReferenceEntry referenceEntry) {
                this.f42429a = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public final void u(ReferenceEntry referenceEntry) {
                this.f42430b = referenceEntry;
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$WriteQueue$2, reason: invalid class name */
        class AnonymousClass2 extends AbstractSequentialIterator<ReferenceEntry<Object, Object>> {
            public AnonymousClass2(ReferenceEntry referenceEntry) {
                super(referenceEntry);
            }

            @Override // com.google.common.collect.AbstractSequentialIterator
            public final Object a(Object obj) {
                ReferenceEntry referenceEntryE = ((ReferenceEntry) obj).e();
                if (referenceEntryE == null) {
                    return null;
                }
                return referenceEntryE;
            }
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return ((ReferenceEntry) obj).e() != NullEntry.f42376a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }

        @Override // java.util.Queue
        public final boolean offer(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry referenceEntryI = referenceEntry.i();
            ReferenceEntry referenceEntryE = referenceEntry.e();
            AnonymousClass1 anonymousClass1 = LocalCache.t;
            referenceEntryI.t(referenceEntryE);
            referenceEntryE.u(referenceEntryI);
            throw null;
        }

        @Override // java.util.Queue
        public final Object peek() {
            throw null;
        }

        @Override // java.util.Queue
        public final Object poll() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry referenceEntryI = referenceEntry.i();
            ReferenceEntry referenceEntryE = referenceEntry.e();
            AnonymousClass1 anonymousClass1 = LocalCache.t;
            referenceEntryI.t(referenceEntryE);
            referenceEntryE.u(referenceEntryI);
            NullEntry nullEntry = NullEntry.f42376a;
            referenceEntry.t(nullEntry);
            referenceEntry.u(nullEntry);
            return referenceEntryE != nullEntry;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            throw null;
        }
    }

    public final class WriteThroughEntry implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42432a;

        /* renamed from: b, reason: collision with root package name */
        public Object f42433b;

        public WriteThroughEntry(Object obj, Object obj2) {
            this.f42432a = obj;
            this.f42433b = obj2;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (this.f42432a.equals(entry.getKey()) && this.f42433b.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f42432a;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.f42433b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.f42432a.hashCode() ^ this.f42433b.hashCode();
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            Object objPut = LocalCache.this.put(this.f42432a, obj);
            this.f42433b = obj;
            return objPut;
        }

        public final String toString() {
            return this.f42432a + "=" + this.f42433b;
        }
    }

    static {
        Logger.getLogger(LocalCache.class.getName());
        t = new AnonymousClass1();
        u = new AbstractQueue<Object>() { // from class: com.google.common.cache.LocalCache.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public final Iterator iterator() {
                return ImmutableSet.s().iterator();
            }

            @Override // java.util.Queue
            public final boolean offer(Object obj) {
                return true;
            }

            @Override // java.util.Queue
            public final Object peek() {
                return null;
            }

            @Override // java.util.Queue
            public final Object poll() {
                return null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public final int size() {
                return 0;
            }
        };
    }

    public LocalCache(CacheBuilder cacheBuilder, CacheLoader cacheLoader) {
        cacheBuilder.getClass();
        this.f42344d = Math.min(4, 65536);
        Strength.AnonymousClass3 anonymousClass3 = cacheBuilder.f42334a;
        Strength.AnonymousClass1 anonymousClass1 = Strength.f42392a;
        Strength strength = (Strength) MoreObjects.a(anonymousClass3, anonymousClass1);
        this.f42347g = strength;
        this.f42348h = anonymousClass1;
        this.f42345e = ((Strength) MoreObjects.a(cacheBuilder.f42334a, anonymousClass1)).a();
        this.f42346f = Equivalence.c();
        this.f42349i = -1L;
        this.f42350j = CacheBuilder.OneWeigher.f42338a;
        this.f42352l = CacheBuilder.NullListener.f42336a;
        this.f42351k = u;
        this.f42353m = CacheBuilder.f42333d;
        int i2 = 0;
        this.n = EntryFactory.f42359a[(strength != Strength.f42393b ? 0 : 4) | (b() ? 1 : 0)];
        Supplier supplier = cacheBuilder.f42335b;
        this.o = (AbstractCache.StatsCounter) supplier.get();
        this.p = cacheLoader;
        int iMin = Math.min(16, 1073741824);
        iMin = b() ? (int) Math.min(iMin, -1L) : iMin;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.f42344d && (!b() || i4 * 20 <= this.f42349i)) {
            i5++;
            i4 <<= 1;
        }
        this.f42342b = 32 - i5;
        this.f42341a = i4 - 1;
        this.f42343c = new Segment[i4];
        int i6 = iMin / i4;
        while (i3 < (i6 * i4 < iMin ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        if (b()) {
            long j2 = this.f42349i;
            long j3 = i4;
            long j4 = (j2 / j3) + 1;
            long j5 = j2 % j3;
            while (true) {
                Segment[] segmentArr = this.f42343c;
                if (i2 >= segmentArr.length) {
                    return;
                }
                if (i2 == j5) {
                    j4--;
                }
                long j6 = j4;
                segmentArr[i2] = new Segment(this, i3, j6, (AbstractCache.StatsCounter) supplier.get());
                i2++;
                j4 = j6;
            }
        } else {
            while (true) {
                Segment[] segmentArr2 = this.f42343c;
                if (i2 >= segmentArr2.length) {
                    return;
                }
                segmentArr2[i2] = new Segment(this, i3, -1L, (AbstractCache.StatsCounter) supplier.get());
                i2++;
            }
        }
    }

    public static ArrayList a(AbstractCollection abstractCollection) {
        ArrayList arrayList = new ArrayList(abstractCollection.size());
        Iterators.a(arrayList, abstractCollection.iterator());
        return arrayList;
    }

    public final boolean b() {
        return this.f42349i >= 0;
    }

    public final int c(Object obj) {
        int iB;
        Equivalence equivalence = this.f42345e;
        if (obj == null) {
            equivalence.getClass();
            iB = 0;
        } else {
            iB = equivalence.b(obj);
        }
        int i2 = iB + ((iB << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = (i5 << 2) + (i5 << 14) + i5;
        return (i6 >>> 16) ^ i6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        for (Segment segment : this.f42343c) {
            if (segment.f42379b != 0) {
                segment.lock();
                try {
                    segment.s(segment.f42378a.f42353m.a());
                    AtomicReferenceArray atomicReferenceArray = segment.f42383f;
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        for (ReferenceEntry referenceEntryC = (ReferenceEntry) atomicReferenceArray.get(i2); referenceEntryC != null; referenceEntryC = referenceEntryC.c()) {
                            if (referenceEntryC.a().a()) {
                                Object key = referenceEntryC.getKey();
                                Object obj = referenceEntryC.a().get();
                                RemovalCause removalCause = (key == null || obj == null) ? RemovalCause.f42438c : RemovalCause.f42436a;
                                referenceEntryC.b();
                                segment.d(key, obj, referenceEntryC.a().e(), removalCause);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                        atomicReferenceArray.set(i3, null);
                    }
                    LocalCache localCache = segment.f42378a;
                    Strength.AnonymousClass1 anonymousClass1 = Strength.f42392a;
                    if (localCache.f42347g != anonymousClass1) {
                        while (segment.f42385h.poll() != null) {
                        }
                    }
                    if (localCache.f42348h != anonymousClass1) {
                        while (segment.f42386i.poll() != null) {
                        }
                    }
                    segment.f42389l.clear();
                    segment.f42390m.clear();
                    segment.f42388k.set(0);
                    segment.f42381d++;
                    segment.f42379b = 0;
                    segment.unlock();
                    segment.t();
                } catch (Throwable th) {
                    segment.unlock();
                    segment.t();
                    throw th;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iC = c(obj);
        Segment segmentD = d(iC);
        segmentD.getClass();
        try {
            if (segmentD.f42379b == 0) {
                return false;
            }
            segmentD.f42378a.f42353m.a();
            ReferenceEntry referenceEntryH = segmentD.h(iC, obj);
            if (referenceEntryH == null) {
                referenceEntryH = null;
            } else {
                segmentD.f42378a.getClass();
            }
            if (referenceEntryH == null) {
                return false;
            }
            return referenceEntryH.a().get() != null;
        } finally {
            segmentD.k();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.util.concurrent.atomic.AtomicReferenceArray] */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        long jA = this.f42353m.a();
        Segment[] segmentArr = this.f42343c;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            int length = segmentArr.length;
            long j3 = 0;
            for (?? r12 = z; r12 < length; r12++) {
                Segment segment = segmentArr[r12];
                int i3 = segment.f42379b;
                ?? r14 = segment.f42383f;
                boolean z2 = z;
                for (?? r15 = z2; r15 < r14.length(); r15++) {
                    ReferenceEntry referenceEntryC = (ReferenceEntry) r14.get(r15);
                    while (referenceEntryC != null) {
                        Segment[] segmentArr2 = segmentArr;
                        Object objI = segment.i(referenceEntryC, jA);
                        ReferenceEntry referenceEntry = referenceEntryC;
                        if (objI != null && this.f42346f.d(obj, objI)) {
                            return true;
                        }
                        referenceEntryC = referenceEntry.c();
                        segmentArr = segmentArr2;
                    }
                }
                j3 += segment.f42381d;
                z = z2;
            }
            boolean z3 = z;
            Segment[] segmentArr3 = segmentArr;
            if (j3 == j2) {
                return z3;
            }
            i2++;
            j2 = j3;
            z = z3;
            segmentArr = segmentArr3;
        }
        return z;
    }

    public final Segment d(int i2) {
        return this.f42343c[(i2 >>> this.f42342b) & this.f42341a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.s;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.s = entrySet;
        return entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iC = c(obj);
        Segment segmentD = d(iC);
        segmentD.getClass();
        try {
            if (segmentD.f42379b != 0) {
                long jA = segmentD.f42378a.f42353m.a();
                ReferenceEntry referenceEntryH = segmentD.h(iC, obj);
                if (referenceEntryH == null) {
                    referenceEntryH = null;
                } else {
                    segmentD.f42378a.getClass();
                }
                if (referenceEntryH == null) {
                    return null;
                }
                Object obj2 = referenceEntryH.a().get();
                if (obj2 != null) {
                    segmentD.n(referenceEntryH, jA);
                    referenceEntryH.getKey();
                    LocalCache localCache = segmentD.f42378a;
                    CacheLoader cacheLoader = localCache.p;
                    localCache.getClass();
                    return obj2;
                }
                segmentD.w();
            }
            return null;
        } finally {
            segmentD.k();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        Segment[] segmentArr = this.f42343c;
        long j2 = 0;
        for (Segment segment : segmentArr) {
            if (segment.f42379b != 0) {
                return false;
            }
            j2 += r8.f42381d;
        }
        if (j2 == 0) {
            return true;
        }
        for (Segment segment2 : segmentArr) {
            if (segment2.f42379b != 0) {
                return false;
            }
            j2 -= r9.f42381d;
        }
        return j2 == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.q;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.q = keySet;
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iC = c(obj);
        return d(iC).l(obj, iC, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object putIfAbsent(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iC = c(obj);
        return d(iC).l(obj, iC, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        RemovalCause removalCause;
        if (obj == null) {
            return null;
        }
        int iC = c(obj);
        Segment segmentD = d(iC);
        segmentD.lock();
        try {
            segmentD.s(segmentD.f42378a.f42353m.a());
            AtomicReferenceArray atomicReferenceArray = segmentD.f42383f;
            int length = iC & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntryC = referenceEntry; referenceEntryC != null; referenceEntryC = referenceEntryC.c()) {
                Object key = referenceEntryC.getKey();
                if (referenceEntryC.b() == iC && key != null && segmentD.f42378a.f42345e.d(obj, key)) {
                    ValueReference valueReferenceA = referenceEntryC.a();
                    Object obj2 = valueReferenceA.get();
                    if (obj2 != null) {
                        removalCause = RemovalCause.f42436a;
                    } else {
                        if (!valueReferenceA.a()) {
                            segmentD.unlock();
                            segmentD.t();
                            return null;
                        }
                        removalCause = RemovalCause.f42438c;
                    }
                    RemovalCause removalCause2 = removalCause;
                    segmentD.f42381d++;
                    ReferenceEntry referenceEntryR = segmentD.r(referenceEntry, referenceEntryC, key, obj2, valueReferenceA, removalCause2);
                    int i2 = segmentD.f42379b - 1;
                    atomicReferenceArray.set(length, referenceEntryR);
                    segmentD.f42379b = i2;
                    segmentD.unlock();
                    segmentD.t();
                    return obj2;
                }
            }
            segmentD.unlock();
            segmentD.t();
            return null;
        } catch (Throwable th) {
            segmentD.unlock();
            segmentD.t();
            throw th;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object replace(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iC = c(obj);
        Segment segmentD = d(iC);
        segmentD.lock();
        try {
            long jA = segmentD.f42378a.f42353m.a();
            segmentD.s(jA);
            AtomicReferenceArray atomicReferenceArray = segmentD.f42383f;
            int length = iC & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            long j2 = jA;
            ReferenceEntry referenceEntryC = referenceEntry;
            while (referenceEntryC != null) {
                ReferenceEntry referenceEntry2 = referenceEntry;
                Object key = referenceEntryC.getKey();
                if (referenceEntryC.b() == iC && key != null && segmentD.f42378a.f42345e.d(obj, key)) {
                    long j3 = j2;
                    ValueReference valueReferenceA = referenceEntryC.a();
                    Object obj3 = valueReferenceA.get();
                    if (obj3 != null) {
                        segmentD.f42381d++;
                        segmentD.d(obj, obj3, valueReferenceA.e(), RemovalCause.f42437b);
                        segmentD.u(referenceEntryC, obj2, j3);
                        segmentD.e(referenceEntryC);
                        segmentD.unlock();
                        segmentD.t();
                        return obj3;
                    }
                    if (valueReferenceA.a()) {
                        segmentD.f42381d++;
                        ReferenceEntry referenceEntryR = segmentD.r(referenceEntry2, referenceEntryC, key, obj3, valueReferenceA, RemovalCause.f42438c);
                        int i2 = segmentD.f42379b - 1;
                        atomicReferenceArray.set(length, referenceEntryR);
                        segmentD.f42379b = i2;
                    }
                    segmentD.unlock();
                    segmentD.t();
                    return null;
                }
                long j4 = j2;
                referenceEntryC = referenceEntryC.c();
                referenceEntry = referenceEntry2;
                j2 = j4;
            }
            return null;
        } finally {
            segmentD.unlock();
            segmentD.t();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        long jMax = 0;
        for (int i2 = 0; i2 < this.f42343c.length; i2++) {
            jMax += Math.max(0, r0[i2].f42379b);
        }
        return Ints.f(jMax);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.r;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.r = values;
        return values;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(Object obj, Object obj2) {
        RemovalCause removalCause;
        if (obj == null || obj2 == null) {
            return false;
        }
        int iC = c(obj);
        Segment segmentD = d(iC);
        segmentD.lock();
        try {
            segmentD.s(segmentD.f42378a.f42353m.a());
            AtomicReferenceArray atomicReferenceArray = segmentD.f42383f;
            int length = iC & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntryC = referenceEntry; referenceEntryC != null; referenceEntryC = referenceEntryC.c()) {
                Object key = referenceEntryC.getKey();
                if (referenceEntryC.b() == iC && key != null && segmentD.f42378a.f42345e.d(obj, key)) {
                    ValueReference valueReferenceA = referenceEntryC.a();
                    Object obj3 = valueReferenceA.get();
                    boolean zD = segmentD.f42378a.f42346f.d(obj2, obj3);
                    RemovalCause removalCause2 = RemovalCause.f42436a;
                    if (zD) {
                        removalCause = removalCause2;
                    } else if (obj3 == null && valueReferenceA.a()) {
                        removalCause = RemovalCause.f42438c;
                    } else {
                        segmentD.unlock();
                        segmentD.t();
                        return false;
                    }
                    segmentD.f42381d++;
                    ReferenceEntry referenceEntryR = segmentD.r(referenceEntry, referenceEntryC, key, obj3, valueReferenceA, removalCause);
                    int i2 = segmentD.f42379b - 1;
                    atomicReferenceArray.set(length, referenceEntryR);
                    segmentD.f42379b = i2;
                    return removalCause == removalCause2;
                }
            }
            segmentD.unlock();
            segmentD.t();
            return false;
        } finally {
            segmentD.unlock();
            segmentD.t();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        obj.getClass();
        obj3.getClass();
        boolean z = false;
        if (obj2 == null) {
            return false;
        }
        int iC = c(obj);
        Segment segmentD = d(iC);
        segmentD.lock();
        try {
            long jA = segmentD.f42378a.f42353m.a();
            segmentD.s(jA);
            AtomicReferenceArray atomicReferenceArray = segmentD.f42383f;
            int length = iC & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            long j2 = jA;
            ReferenceEntry referenceEntryC = referenceEntry;
            while (referenceEntryC != null) {
                ReferenceEntry referenceEntry2 = referenceEntry;
                Object key = referenceEntryC.getKey();
                if (referenceEntryC.b() == iC && key != null && segmentD.f42378a.f42345e.d(obj, key)) {
                    boolean z2 = z;
                    long j3 = j2;
                    ValueReference valueReferenceA = referenceEntryC.a();
                    Object obj4 = valueReferenceA.get();
                    if (obj4 == null) {
                        if (valueReferenceA.a()) {
                            segmentD.f42381d++;
                            ReferenceEntry referenceEntryR = segmentD.r(referenceEntry2, referenceEntryC, key, obj4, valueReferenceA, RemovalCause.f42438c);
                            int i2 = segmentD.f42379b - 1;
                            atomicReferenceArray.set(length, referenceEntryR);
                            segmentD.f42379b = i2;
                        }
                        return z2;
                    }
                    if (segmentD.f42378a.f42346f.d(obj2, obj4)) {
                        segmentD.f42381d++;
                        segmentD.d(obj, obj4, valueReferenceA.e(), RemovalCause.f42437b);
                        segmentD.u(referenceEntryC, obj3, j3);
                        segmentD.e(referenceEntryC);
                        return true;
                    }
                    segmentD.m(referenceEntryC, j3);
                    return z2;
                }
                boolean z3 = z;
                referenceEntry = referenceEntry2;
                long j4 = j2;
                int i3 = iC;
                referenceEntryC = referenceEntryC.c();
                iC = i3;
                j2 = j4;
                z = z3;
            }
            return z;
        } finally {
            segmentD.unlock();
            segmentD.t();
        }
    }
}
