package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {

    /* renamed from: j, reason: collision with root package name */
    public static final AnonymousClass1 f42828j = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final transient int f42829a;

    /* renamed from: b, reason: collision with root package name */
    public final transient int f42830b;

    /* renamed from: c, reason: collision with root package name */
    public final transient Segment[] f42831c;

    /* renamed from: d, reason: collision with root package name */
    public final int f42832d;

    /* renamed from: e, reason: collision with root package name */
    public final Equivalence f42833e;

    /* renamed from: f, reason: collision with root package name */
    public final transient InternalEntryHelper f42834f;

    /* renamed from: g, reason: collision with root package name */
    public transient Set f42835g;

    /* renamed from: h, reason: collision with root package name */
    public transient Collection f42836h;

    /* renamed from: i, reason: collision with root package name */
    public transient Set f42837i;

    /* renamed from: com.google.common.collect.MapMakerInternalMap$1, reason: invalid class name */
    public class AnonymousClass1 implements WeakValueReference<Object, Object, DummyInternalEntry> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final WeakValueReference a(ReferenceQueue referenceQueue, WeakValueEntry weakValueEntry) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final /* bridge */ /* synthetic */ InternalEntry c() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final Object get() {
            return null;
        }
    }

    public static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public final /* bridge */ /* synthetic */ Object t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap
        /* renamed from: u */
        public final /* bridge */ /* synthetic */ Map t() {
            return null;
        }
    }

    public static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42838a;

        /* renamed from: b, reason: collision with root package name */
        public final int f42839b;

        public AbstractStrongKeyEntry(Object obj, int i2) {
            this.f42838a = obj;
            this.f42839b = i2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final int b() {
            return this.f42839b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public InternalEntry c() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getKey() {
            return this.f42838a;
        }
    }

    public static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {

        /* renamed from: a, reason: collision with root package name */
        public final int f42840a;

        public AbstractWeakKeyEntry(ReferenceQueue referenceQueue, Object obj, int i2) {
            super(obj, referenceQueue);
            this.f42840a = i2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final int b() {
            return this.f42840a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public InternalEntry c() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getKey() {
            return get();
        }
    }

    public static final class CleanupMapTask implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public static final class DummyInternalEntry implements InternalEntry<Object, Object, DummyInternalEntry> {
        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final int b() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final InternalEntry c() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getValue() {
            throw new AssertionError();
        }
    }

    public final class EntryIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<Map.Entry<K, V>> {
    }

    public final class EntrySet extends SafeToArraySet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            MapMakerInternalMap mapMakerInternalMap;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = (mapMakerInternalMap = MapMakerInternalMap.this).get(key)) != null && mapMakerInternalMap.f42834f.c().a().d(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    public abstract class HashIterator<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public int f42842a;

        /* renamed from: b, reason: collision with root package name */
        public int f42843b = -1;

        /* renamed from: c, reason: collision with root package name */
        public Segment f42844c;

        /* renamed from: d, reason: collision with root package name */
        public AtomicReferenceArray f42845d;

        /* renamed from: e, reason: collision with root package name */
        public InternalEntry f42846e;

        /* renamed from: f, reason: collision with root package name */
        public WriteThroughEntry f42847f;

        /* renamed from: g, reason: collision with root package name */
        public WriteThroughEntry f42848g;

        public HashIterator() {
            this.f42842a = MapMakerInternalMap.this.f42831c.length - 1;
            a();
        }

        public final void a() {
            this.f42847f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i2 = this.f42842a;
                if (i2 < 0) {
                    return;
                }
                Segment[] segmentArr = MapMakerInternalMap.this.f42831c;
                this.f42842a = i2 - 1;
                Segment segment = segmentArr[i2];
                this.f42844c = segment;
                if (segment.f42853b != 0) {
                    this.f42845d = this.f42844c.f42856e;
                    this.f42843b = r0.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public final boolean b(InternalEntry internalEntry) {
            MapMakerInternalMap mapMakerInternalMap = MapMakerInternalMap.this;
            try {
                Object key = internalEntry.getKey();
                Object value = internalEntry.getKey() == null ? null : internalEntry.getValue();
                if (value == null) {
                    this.f42844c.g();
                    return false;
                }
                this.f42847f = new WriteThroughEntry(key, value);
                this.f42844c.g();
                return true;
            } catch (Throwable th) {
                this.f42844c.g();
                throw th;
            }
        }

        public final WriteThroughEntry c() {
            WriteThroughEntry writeThroughEntry = this.f42847f;
            if (writeThroughEntry == null) {
                throw new NoSuchElementException();
            }
            this.f42848g = writeThroughEntry;
            a();
            return this.f42848g;
        }

        public final boolean d() {
            InternalEntry internalEntry = this.f42846e;
            if (internalEntry == null) {
                return false;
            }
            while (true) {
                this.f42846e = internalEntry.c();
                InternalEntry internalEntry2 = this.f42846e;
                if (internalEntry2 == null) {
                    return false;
                }
                if (b(internalEntry2)) {
                    return true;
                }
                internalEntry = this.f42846e;
            }
        }

        public final boolean e() {
            while (true) {
                int i2 = this.f42843b;
                if (i2 < 0) {
                    return false;
                }
                AtomicReferenceArray atomicReferenceArray = this.f42845d;
                this.f42843b = i2 - 1;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(i2);
                this.f42846e = internalEntry;
                if (internalEntry != null && (b(internalEntry) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f42847f != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            return c();
        }

        @Override // java.util.Iterator
        public final void remove() {
            CollectPreconditions.d(this.f42848g != null);
            MapMakerInternalMap.this.remove(this.f42848g.f42880a);
            this.f42848g = null;
        }
    }

    public interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        int b();

        InternalEntry c();

        Object getKey();

        Object getValue();
    }

    public interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        Segment a(MapMakerInternalMap mapMakerInternalMap, int i2);

        InternalEntry b(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2);

        Strength c();

        void d(Segment segment, InternalEntry internalEntry, Object obj);

        InternalEntry e(Segment segment, Object obj, int i2, InternalEntry internalEntry);
    }

    public final class KeyIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<K> {
        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public final Object next() {
            return c().f42880a;
        }
    }

    public final class KeySet extends SafeToArraySet<K> {
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    public static abstract class SafeToArraySet<E> extends AbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final Object[] toArray(Object[] objArr) {
            return MapMakerInternalMap.a(this).toArray(objArr);
        }
    }

    public static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f42851g = 0;

        /* renamed from: a, reason: collision with root package name */
        public final MapMakerInternalMap f42852a;

        /* renamed from: b, reason: collision with root package name */
        public volatile int f42853b;

        /* renamed from: c, reason: collision with root package name */
        public int f42854c;

        /* renamed from: d, reason: collision with root package name */
        public int f42855d;

        /* renamed from: e, reason: collision with root package name */
        public volatile AtomicReferenceArray f42856e;

        /* renamed from: f, reason: collision with root package name */
        public final AtomicInteger f42857f = new AtomicInteger();

        public Segment(MapMakerInternalMap mapMakerInternalMap, int i2) {
            this.f42852a = mapMakerInternalMap;
            AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i2);
            this.f42855d = (atomicReferenceArray.length() * 3) / 4;
            this.f42856e = atomicReferenceArray;
        }

        public final void a(ReferenceQueue referenceQueue) {
            int i2 = 0;
            do {
                Object objPoll = referenceQueue.poll();
                if (objPoll == null) {
                    return;
                }
                InternalEntry internalEntry = (InternalEntry) objPoll;
                MapMakerInternalMap mapMakerInternalMap = this.f42852a;
                mapMakerInternalMap.getClass();
                int iB = internalEntry.b();
                Segment segmentC = mapMakerInternalMap.c(iB);
                segmentC.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = segmentC.f42856e;
                    int length = iB & (atomicReferenceArray.length() - 1);
                    InternalEntry internalEntry2 = (InternalEntry) atomicReferenceArray.get(length);
                    InternalEntry internalEntryC = internalEntry2;
                    while (true) {
                        if (internalEntryC == null) {
                            break;
                        }
                        if (internalEntryC == internalEntry) {
                            segmentC.f42854c++;
                            InternalEntry internalEntryI = segmentC.i(internalEntry2, internalEntryC);
                            int i3 = segmentC.f42853b - 1;
                            atomicReferenceArray.set(length, internalEntryI);
                            segmentC.f42853b = i3;
                            break;
                        }
                        internalEntryC = internalEntryC.c();
                    }
                    i2++;
                } finally {
                    segmentC.unlock();
                }
            } while (i2 != 16);
        }

        public final void b(ReferenceQueue referenceQueue) {
            int i2 = 0;
            do {
                Object objPoll = referenceQueue.poll();
                if (objPoll == null) {
                    return;
                }
                WeakValueReference weakValueReference = (WeakValueReference) objPoll;
                MapMakerInternalMap mapMakerInternalMap = this.f42852a;
                mapMakerInternalMap.getClass();
                InternalEntry internalEntryC = weakValueReference.c();
                int iB = internalEntryC.b();
                Segment segmentC = mapMakerInternalMap.c(iB);
                Object key = internalEntryC.getKey();
                segmentC.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = segmentC.f42856e;
                    int length = (atomicReferenceArray.length() - 1) & iB;
                    InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                    InternalEntry internalEntryC2 = internalEntry;
                    while (true) {
                        if (internalEntryC2 == null) {
                            break;
                        }
                        Object key2 = internalEntryC2.getKey();
                        if (internalEntryC2.b() != iB || key2 == null || !segmentC.f42852a.f42833e.d(key, key2)) {
                            internalEntryC2 = internalEntryC2.c();
                        } else if (((WeakValueEntry) internalEntryC2).a() == weakValueReference) {
                            segmentC.f42854c++;
                            InternalEntry internalEntryI = segmentC.i(internalEntry, internalEntryC2);
                            int i3 = segmentC.f42853b - 1;
                            atomicReferenceArray.set(length, internalEntryI);
                            segmentC.f42853b = i3;
                        }
                    }
                    i2++;
                } finally {
                    segmentC.unlock();
                }
            } while (i2 != 16);
        }

        public final void c() {
            AtomicReferenceArray atomicReferenceArray = this.f42856e;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i2 = this.f42853b;
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(length << 1);
            this.f42855d = (atomicReferenceArray2.length() * 3) / 4;
            int length2 = atomicReferenceArray2.length() - 1;
            for (int i3 = 0; i3 < length; i3++) {
                InternalEntry internalEntryC = (InternalEntry) atomicReferenceArray.get(i3);
                if (internalEntryC != null) {
                    InternalEntry internalEntryC2 = internalEntryC.c();
                    int iB = internalEntryC.b() & length2;
                    if (internalEntryC2 == null) {
                        atomicReferenceArray2.set(iB, internalEntryC);
                    } else {
                        InternalEntry internalEntry = internalEntryC;
                        while (internalEntryC2 != null) {
                            int iB2 = internalEntryC2.b() & length2;
                            if (iB2 != iB) {
                                internalEntry = internalEntryC2;
                                iB = iB2;
                            }
                            internalEntryC2 = internalEntryC2.c();
                        }
                        atomicReferenceArray2.set(iB, internalEntry);
                        while (internalEntryC != internalEntry) {
                            int iB3 = internalEntryC.b() & length2;
                            InternalEntry internalEntryB = this.f42852a.f42834f.b(k(), internalEntryC, (InternalEntry) atomicReferenceArray2.get(iB3));
                            if (internalEntryB != null) {
                                atomicReferenceArray2.set(iB3, internalEntryB);
                            } else {
                                i2--;
                            }
                            internalEntryC = internalEntryC.c();
                        }
                    }
                }
            }
            this.f42856e = atomicReferenceArray2;
            this.f42853b = i2;
        }

        public final InternalEntry d(int i2, Object obj) {
            if (this.f42853b == 0) {
                return null;
            }
            for (InternalEntry internalEntryC = (InternalEntry) this.f42856e.get((r0.length() - 1) & i2); internalEntryC != null; internalEntryC = internalEntryC.c()) {
                if (internalEntryC.b() == i2) {
                    Object key = internalEntryC.getKey();
                    if (key == null) {
                        m();
                    } else if (this.f42852a.f42833e.d(obj, key)) {
                        return internalEntryC;
                    }
                }
            }
            return null;
        }

        public void e() {
        }

        public void f() {
        }

        public final void g() {
            if ((this.f42857f.incrementAndGet() & 63) == 0) {
                j();
            }
        }

        public final Object h(Object obj, int i2, Object obj2, boolean z) {
            lock();
            try {
                j();
                int i3 = this.f42853b + 1;
                if (i3 > this.f42855d) {
                    c();
                    i3 = this.f42853b + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.f42856e;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntryC = internalEntry; internalEntryC != null; internalEntryC = internalEntryC.c()) {
                    Object key = internalEntryC.getKey();
                    if (internalEntryC.b() == i2 && key != null && this.f42852a.f42833e.d(obj, key)) {
                        Object value = internalEntryC.getValue();
                        if (value == null) {
                            this.f42854c++;
                            l(internalEntryC, obj2);
                            this.f42853b = this.f42853b;
                            unlock();
                            return null;
                        }
                        if (z) {
                            unlock();
                            return value;
                        }
                        this.f42854c++;
                        l(internalEntryC, obj2);
                        unlock();
                        return value;
                    }
                }
                this.f42854c++;
                InternalEntry internalEntryE = this.f42852a.f42834f.e(k(), obj, i2, internalEntry);
                l(internalEntryE, obj2);
                atomicReferenceArray.set(length, internalEntryE);
                this.f42853b = i3;
                unlock();
                return null;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }

        public final InternalEntry i(InternalEntry internalEntry, InternalEntry internalEntry2) {
            int i2 = this.f42853b;
            InternalEntry internalEntryC = internalEntry2.c();
            while (internalEntry != internalEntry2) {
                InternalEntry internalEntryB = this.f42852a.f42834f.b(k(), internalEntry, internalEntryC);
                if (internalEntryB != null) {
                    internalEntryC = internalEntryB;
                } else {
                    i2--;
                }
                internalEntry = internalEntry.c();
            }
            this.f42853b = i2;
            return internalEntryC;
        }

        public final void j() {
            if (tryLock()) {
                try {
                    f();
                    this.f42857f.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract Segment k();

        public final void l(InternalEntry internalEntry, Object obj) {
            this.f42852a.f42834f.d(k(), internalEntry, obj);
        }

        public final void m() {
            if (tryLock()) {
                try {
                    f();
                } finally {
                    unlock();
                }
            }
        }
    }

    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class Strength {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f42858a;

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass2 f42859b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Strength[] f42860c;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.MapMakerInternalMap$Strength$1] */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.collect.MapMakerInternalMap$Strength$2] */
        static {
            ?? r0 = new Strength() { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
                @Override // com.google.common.collect.MapMakerInternalMap.Strength
                public final Equivalence a() {
                    return Equivalence.c();
                }
            };
            f42858a = r0;
            ?? r1 = new Strength() { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
                @Override // com.google.common.collect.MapMakerInternalMap.Strength
                public final Equivalence a() {
                    return Equivalence.e();
                }
            };
            f42859b = r1;
            f42860c = new Strength[]{r0, r1};
        }

        public static Strength valueOf(String str) {
            return (Strength) Enum.valueOf(Strength.class, str);
        }

        public static Strength[] values() {
            return (Strength[]) f42860c.clone();
        }

        public abstract Equivalence a();
    }

    public static class StrongKeyDummyValueEntry<K> extends AbstractStrongKeyEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> {

        public static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Segment a(MapMakerInternalMap mapMakerInternalMap, int i2) {
                return new StrongKeyDummyValueSegment(mapMakerInternalMap, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry b(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                StrongKeyDummyValueEntry strongKeyDummyValueEntry = (StrongKeyDummyValueEntry) internalEntry;
                StrongKeyDummyValueEntry strongKeyDummyValueEntry2 = (StrongKeyDummyValueEntry) internalEntry2;
                Object obj = strongKeyDummyValueEntry.f42838a;
                int i2 = strongKeyDummyValueEntry.f42839b;
                return strongKeyDummyValueEntry2 == null ? new StrongKeyDummyValueEntry(obj, i2) : new LinkedStrongKeyDummyValueEntry(obj, i2, strongKeyDummyValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Strength c() {
                return Strength.f42858a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final /* bridge */ /* synthetic */ void d(Segment segment, InternalEntry internalEntry, Object obj) {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry e(Segment segment, Object obj, int i2, InternalEntry internalEntry) {
                StrongKeyDummyValueEntry strongKeyDummyValueEntry = (StrongKeyDummyValueEntry) internalEntry;
                return strongKeyDummyValueEntry == null ? new StrongKeyDummyValueEntry(obj, i2) : new LinkedStrongKeyDummyValueEntry(obj, i2, strongKeyDummyValueEntry);
            }
        }

        public static final class LinkedStrongKeyDummyValueEntry<K> extends StrongKeyDummyValueEntry<K> {

            /* renamed from: c, reason: collision with root package name */
            public final StrongKeyDummyValueEntry f42861c;

            public LinkedStrongKeyDummyValueEntry(Object obj, int i2, StrongKeyDummyValueEntry strongKeyDummyValueEntry) {
                super(obj, i2);
                this.f42861c = strongKeyDummyValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public final InternalEntry c() {
                return this.f42861c;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public final /* bridge */ /* synthetic */ Object getValue() {
                return MapMaker.Dummy.f42826a;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public /* bridge */ /* synthetic */ Object getValue() {
            return MapMaker.Dummy.f42826a;
        }
    }

    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment k() {
            return this;
        }
    }

    public static class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, StrongKeyStrongValueEntry<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        public volatile Object f42862c;

        public static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final Helper f42863a = new Helper();

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Segment a(MapMakerInternalMap mapMakerInternalMap, int i2) {
                return new StrongKeyStrongValueSegment(mapMakerInternalMap, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry b(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                StrongKeyStrongValueEntry strongKeyStrongValueEntry = (StrongKeyStrongValueEntry) internalEntry;
                StrongKeyStrongValueEntry strongKeyStrongValueEntry2 = (StrongKeyStrongValueEntry) internalEntry2;
                Object obj = strongKeyStrongValueEntry.f42838a;
                int i2 = strongKeyStrongValueEntry.f42839b;
                StrongKeyStrongValueEntry strongKeyStrongValueEntry3 = strongKeyStrongValueEntry2 == null ? new StrongKeyStrongValueEntry(obj, i2) : new LinkedStrongKeyStrongValueEntry(obj, i2, strongKeyStrongValueEntry2);
                strongKeyStrongValueEntry3.f42862c = strongKeyStrongValueEntry.f42862c;
                return strongKeyStrongValueEntry3;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Strength c() {
                return Strength.f42858a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final void d(Segment segment, InternalEntry internalEntry, Object obj) {
                ((StrongKeyStrongValueEntry) internalEntry).f42862c = obj;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry e(Segment segment, Object obj, int i2, InternalEntry internalEntry) {
                StrongKeyStrongValueEntry strongKeyStrongValueEntry = (StrongKeyStrongValueEntry) internalEntry;
                return strongKeyStrongValueEntry == null ? new StrongKeyStrongValueEntry(obj, i2) : new LinkedStrongKeyStrongValueEntry(obj, i2, strongKeyStrongValueEntry);
            }
        }

        public static final class LinkedStrongKeyStrongValueEntry<K, V> extends StrongKeyStrongValueEntry<K, V> {

            /* renamed from: d, reason: collision with root package name */
            public final StrongKeyStrongValueEntry f42864d;

            public LinkedStrongKeyStrongValueEntry(Object obj, int i2, StrongKeyStrongValueEntry strongKeyStrongValueEntry) {
                super(obj, i2);
                this.f42864d = strongKeyStrongValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public final InternalEntry c() {
                return this.f42864d;
            }
        }

        public StrongKeyStrongValueEntry(Object obj, int i2) {
            super(obj, i2);
            this.f42862c = null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getValue() {
            return this.f42862c;
        }
    }

    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment k() {
            return this;
        }
    }

    public static class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        public volatile WeakValueReference f42865c;

        public static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Segment a(MapMakerInternalMap mapMakerInternalMap, int i2) {
                return new StrongKeyWeakValueSegment(mapMakerInternalMap, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry b(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                StrongKeyWeakValueSegment strongKeyWeakValueSegment = (StrongKeyWeakValueSegment) segment;
                StrongKeyWeakValueEntry strongKeyWeakValueEntry = (StrongKeyWeakValueEntry) internalEntry;
                StrongKeyWeakValueEntry strongKeyWeakValueEntry2 = (StrongKeyWeakValueEntry) internalEntry2;
                int i2 = Segment.f42851g;
                if (strongKeyWeakValueEntry.getValue() == null) {
                    return null;
                }
                Object obj = strongKeyWeakValueEntry.f42838a;
                int i3 = strongKeyWeakValueEntry.f42839b;
                StrongKeyWeakValueEntry strongKeyWeakValueEntry3 = strongKeyWeakValueEntry2 == null ? new StrongKeyWeakValueEntry(obj, i3) : new LinkedStrongKeyWeakValueEntry(obj, i3, strongKeyWeakValueEntry2);
                strongKeyWeakValueEntry3.f42865c = strongKeyWeakValueEntry.f42865c.a(strongKeyWeakValueSegment.f42867h, strongKeyWeakValueEntry3);
                return strongKeyWeakValueEntry3;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Strength c() {
                return Strength.f42859b;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final void d(Segment segment, InternalEntry internalEntry, Object obj) {
                StrongKeyWeakValueEntry strongKeyWeakValueEntry = (StrongKeyWeakValueEntry) internalEntry;
                WeakValueReference weakValueReference = strongKeyWeakValueEntry.f42865c;
                strongKeyWeakValueEntry.f42865c = new WeakValueReferenceImpl(((StrongKeyWeakValueSegment) segment).f42867h, obj, strongKeyWeakValueEntry);
                weakValueReference.clear();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry e(Segment segment, Object obj, int i2, InternalEntry internalEntry) {
                StrongKeyWeakValueEntry strongKeyWeakValueEntry = (StrongKeyWeakValueEntry) internalEntry;
                return strongKeyWeakValueEntry == null ? new StrongKeyWeakValueEntry(obj, i2) : new LinkedStrongKeyWeakValueEntry(obj, i2, strongKeyWeakValueEntry);
            }
        }

        public static final class LinkedStrongKeyWeakValueEntry<K, V> extends StrongKeyWeakValueEntry<K, V> {

            /* renamed from: d, reason: collision with root package name */
            public final StrongKeyWeakValueEntry f42866d;

            public LinkedStrongKeyWeakValueEntry(Object obj, int i2, StrongKeyWeakValueEntry strongKeyWeakValueEntry) {
                super(obj, i2);
                this.f42866d = strongKeyWeakValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public final InternalEntry c() {
                return this.f42866d;
            }
        }

        public StrongKeyWeakValueEntry(Object obj, int i2) {
            super(obj, i2);
            this.f42865c = MapMakerInternalMap.f42828j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public final WeakValueReference a() {
            return this.f42865c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getValue() {
            return this.f42865c.get();
        }
    }

    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {

        /* renamed from: h, reason: collision with root package name */
        public final ReferenceQueue f42867h;

        public StrongKeyWeakValueSegment(MapMakerInternalMap mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
            this.f42867h = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void e() {
            while (this.f42867h.poll() != null) {
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void f() {
            b(this.f42867h);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment k() {
            return this;
        }
    }

    public interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    }

    public final class ValueIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<V> {
        @Override // com.google.common.collect.MapMakerInternalMap.HashIterator, java.util.Iterator
        public final Object next() {
            return c().f42881b;
        }
    }

    public final class Values extends AbstractCollection<V> {
        public Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            return MapMakerInternalMap.a(this).toArray(objArr);
        }
    }

    public static class WeakKeyDummyValueEntry<K> extends AbstractWeakKeyEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> {

        public static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Segment a(MapMakerInternalMap mapMakerInternalMap, int i2) {
                return new WeakKeyDummyValueSegment(mapMakerInternalMap, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry b(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                WeakKeyDummyValueSegment weakKeyDummyValueSegment = (WeakKeyDummyValueSegment) segment;
                WeakKeyDummyValueEntry weakKeyDummyValueEntry = (WeakKeyDummyValueEntry) internalEntry;
                WeakKeyDummyValueEntry weakKeyDummyValueEntry2 = (WeakKeyDummyValueEntry) internalEntry2;
                K k2 = weakKeyDummyValueEntry.get();
                if (k2 == null) {
                    return null;
                }
                int i2 = weakKeyDummyValueEntry.f42840a;
                return weakKeyDummyValueEntry2 == null ? new WeakKeyDummyValueEntry(weakKeyDummyValueSegment.f42870h, k2, i2) : new LinkedWeakKeyDummyValueEntry(weakKeyDummyValueSegment.f42870h, k2, i2, weakKeyDummyValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Strength c() {
                return Strength.f42858a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final /* bridge */ /* synthetic */ void d(Segment segment, InternalEntry internalEntry, Object obj) {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry e(Segment segment, Object obj, int i2, InternalEntry internalEntry) {
                WeakKeyDummyValueSegment weakKeyDummyValueSegment = (WeakKeyDummyValueSegment) segment;
                WeakKeyDummyValueEntry weakKeyDummyValueEntry = (WeakKeyDummyValueEntry) internalEntry;
                return weakKeyDummyValueEntry == null ? new WeakKeyDummyValueEntry(weakKeyDummyValueSegment.f42870h, obj, i2) : new LinkedWeakKeyDummyValueEntry(weakKeyDummyValueSegment.f42870h, obj, i2, weakKeyDummyValueEntry);
            }
        }

        public static final class LinkedWeakKeyDummyValueEntry<K> extends WeakKeyDummyValueEntry<K> {

            /* renamed from: b, reason: collision with root package name */
            public final WeakKeyDummyValueEntry f42869b;

            public LinkedWeakKeyDummyValueEntry(ReferenceQueue referenceQueue, Object obj, int i2, WeakKeyDummyValueEntry weakKeyDummyValueEntry) {
                super(referenceQueue, obj, i2);
                this.f42869b = weakKeyDummyValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public final InternalEntry c() {
                return this.f42869b;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public final /* bridge */ /* synthetic */ Object getValue() {
                return MapMaker.Dummy.f42826a;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public /* bridge */ /* synthetic */ Object getValue() {
            return MapMaker.Dummy.f42826a;
        }
    }

    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {

        /* renamed from: h, reason: collision with root package name */
        public final ReferenceQueue f42870h;

        public WeakKeyDummyValueSegment(MapMakerInternalMap mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
            this.f42870h = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void e() {
            while (this.f42870h.poll() != null) {
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void f() {
            a(this.f42870h);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment k() {
            return this;
        }
    }

    public static class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, WeakKeyStrongValueEntry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public volatile Object f42871b;

        public static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final Helper f42872a = new Helper();

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Segment a(MapMakerInternalMap mapMakerInternalMap, int i2) {
                return new WeakKeyStrongValueSegment(mapMakerInternalMap, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry b(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                WeakKeyStrongValueSegment weakKeyStrongValueSegment = (WeakKeyStrongValueSegment) segment;
                WeakKeyStrongValueEntry weakKeyStrongValueEntry = (WeakKeyStrongValueEntry) internalEntry;
                WeakKeyStrongValueEntry weakKeyStrongValueEntry2 = (WeakKeyStrongValueEntry) internalEntry2;
                K k2 = weakKeyStrongValueEntry.get();
                if (k2 == null) {
                    return null;
                }
                int i2 = weakKeyStrongValueEntry.f42840a;
                WeakKeyStrongValueEntry weakKeyStrongValueEntry3 = weakKeyStrongValueEntry2 == null ? new WeakKeyStrongValueEntry(weakKeyStrongValueSegment.f42874h, k2, i2) : new LinkedWeakKeyStrongValueEntry(weakKeyStrongValueSegment.f42874h, k2, i2, weakKeyStrongValueEntry2);
                weakKeyStrongValueEntry3.f42871b = weakKeyStrongValueEntry.f42871b;
                return weakKeyStrongValueEntry3;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Strength c() {
                return Strength.f42858a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final void d(Segment segment, InternalEntry internalEntry, Object obj) {
                ((WeakKeyStrongValueEntry) internalEntry).f42871b = obj;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry e(Segment segment, Object obj, int i2, InternalEntry internalEntry) {
                WeakKeyStrongValueSegment weakKeyStrongValueSegment = (WeakKeyStrongValueSegment) segment;
                WeakKeyStrongValueEntry weakKeyStrongValueEntry = (WeakKeyStrongValueEntry) internalEntry;
                return weakKeyStrongValueEntry == null ? new WeakKeyStrongValueEntry(weakKeyStrongValueSegment.f42874h, obj, i2) : new LinkedWeakKeyStrongValueEntry(weakKeyStrongValueSegment.f42874h, obj, i2, weakKeyStrongValueEntry);
            }
        }

        public static final class LinkedWeakKeyStrongValueEntry<K, V> extends WeakKeyStrongValueEntry<K, V> {

            /* renamed from: c, reason: collision with root package name */
            public final WeakKeyStrongValueEntry f42873c;

            public LinkedWeakKeyStrongValueEntry(ReferenceQueue referenceQueue, Object obj, int i2, WeakKeyStrongValueEntry weakKeyStrongValueEntry) {
                super(referenceQueue, obj, i2);
                this.f42873c = weakKeyStrongValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public final InternalEntry c() {
                return this.f42873c;
            }
        }

        public WeakKeyStrongValueEntry(ReferenceQueue referenceQueue, Object obj, int i2) {
            super(referenceQueue, obj, i2);
            this.f42871b = null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getValue() {
            return this.f42871b;
        }
    }

    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {

        /* renamed from: h, reason: collision with root package name */
        public final ReferenceQueue f42874h;

        public WeakKeyStrongValueSegment(MapMakerInternalMap mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
            this.f42874h = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void e() {
            while (this.f42874h.poll() != null) {
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void f() {
            a(this.f42874h);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment k() {
            return this;
        }
    }

    public static class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public volatile WeakValueReference f42875b;

        public static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Segment a(MapMakerInternalMap mapMakerInternalMap, int i2) {
                return new WeakKeyWeakValueSegment(mapMakerInternalMap, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry b(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                WeakKeyWeakValueSegment weakKeyWeakValueSegment = (WeakKeyWeakValueSegment) segment;
                WeakKeyWeakValueEntry weakKeyWeakValueEntry = (WeakKeyWeakValueEntry) internalEntry;
                WeakKeyWeakValueEntry weakKeyWeakValueEntry2 = (WeakKeyWeakValueEntry) internalEntry2;
                K k2 = weakKeyWeakValueEntry.get();
                if (k2 == null) {
                    return null;
                }
                int i2 = Segment.f42851g;
                if (weakKeyWeakValueEntry.f42875b.get() == null) {
                    return null;
                }
                int i3 = weakKeyWeakValueEntry.f42840a;
                WeakKeyWeakValueEntry weakKeyWeakValueEntry3 = weakKeyWeakValueEntry2 == null ? new WeakKeyWeakValueEntry(weakKeyWeakValueSegment.f42877h, k2, i3) : new LinkedWeakKeyWeakValueEntry(weakKeyWeakValueSegment.f42877h, k2, i3, weakKeyWeakValueEntry2);
                weakKeyWeakValueEntry3.f42875b = weakKeyWeakValueEntry.f42875b.a(weakKeyWeakValueSegment.f42878i, weakKeyWeakValueEntry3);
                return weakKeyWeakValueEntry3;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final Strength c() {
                return Strength.f42859b;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final void d(Segment segment, InternalEntry internalEntry, Object obj) {
                WeakKeyWeakValueEntry weakKeyWeakValueEntry = (WeakKeyWeakValueEntry) internalEntry;
                WeakValueReference weakValueReference = weakKeyWeakValueEntry.f42875b;
                weakKeyWeakValueEntry.f42875b = new WeakValueReferenceImpl(((WeakKeyWeakValueSegment) segment).f42878i, obj, weakKeyWeakValueEntry);
                weakValueReference.clear();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public final InternalEntry e(Segment segment, Object obj, int i2, InternalEntry internalEntry) {
                WeakKeyWeakValueSegment weakKeyWeakValueSegment = (WeakKeyWeakValueSegment) segment;
                WeakKeyWeakValueEntry weakKeyWeakValueEntry = (WeakKeyWeakValueEntry) internalEntry;
                return weakKeyWeakValueEntry == null ? new WeakKeyWeakValueEntry(weakKeyWeakValueSegment.f42877h, obj, i2) : new LinkedWeakKeyWeakValueEntry(weakKeyWeakValueSegment.f42877h, obj, i2, weakKeyWeakValueEntry);
            }
        }

        public static final class LinkedWeakKeyWeakValueEntry<K, V> extends WeakKeyWeakValueEntry<K, V> {

            /* renamed from: c, reason: collision with root package name */
            public final WeakKeyWeakValueEntry f42876c;

            public LinkedWeakKeyWeakValueEntry(ReferenceQueue referenceQueue, Object obj, int i2, WeakKeyWeakValueEntry weakKeyWeakValueEntry) {
                super(referenceQueue, obj, i2);
                this.f42876c = weakKeyWeakValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public final InternalEntry c() {
                return this.f42876c;
            }
        }

        public WeakKeyWeakValueEntry(ReferenceQueue referenceQueue, Object obj, int i2) {
            super(referenceQueue, obj, i2);
            this.f42875b = MapMakerInternalMap.f42828j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public final WeakValueReference a() {
            return this.f42875b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getValue() {
            return this.f42875b.get();
        }
    }

    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {

        /* renamed from: h, reason: collision with root package name */
        public final ReferenceQueue f42877h;

        /* renamed from: i, reason: collision with root package name */
        public final ReferenceQueue f42878i;

        public WeakKeyWeakValueSegment(MapMakerInternalMap mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
            this.f42877h = new ReferenceQueue();
            this.f42878i = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void e() {
            while (this.f42877h.poll() != null) {
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final void f() {
            a(this.f42877h);
            b(this.f42878i);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public final Segment k() {
            return this;
        }
    }

    public interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        WeakValueReference a();
    }

    public interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        WeakValueReference a(ReferenceQueue referenceQueue, WeakValueEntry weakValueEntry);

        InternalEntry c();

        void clear();

        Object get();
    }

    public static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {

        /* renamed from: a, reason: collision with root package name */
        public final InternalEntry f42879a;

        public WeakValueReferenceImpl(ReferenceQueue referenceQueue, Object obj, InternalEntry internalEntry) {
            super(obj, referenceQueue);
            this.f42879a = internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final WeakValueReference a(ReferenceQueue referenceQueue, WeakValueEntry weakValueEntry) {
            return new WeakValueReferenceImpl(referenceQueue, get(), weakValueEntry);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public final InternalEntry c() {
            return this.f42879a;
        }
    }

    public final class WriteThroughEntry extends AbstractMapEntry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42880a;

        /* renamed from: b, reason: collision with root package name */
        public Object f42881b;

        public WriteThroughEntry(Object obj, Object obj2) {
            this.f42880a = obj;
            this.f42881b = obj2;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (this.f42880a.equals(entry.getKey()) && this.f42881b.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f42880a;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.f42881b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public final int hashCode() {
            return this.f42880a.hashCode() ^ this.f42881b.hashCode();
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public final Object setValue(Object obj) {
            Object objPut = MapMakerInternalMap.this.put(this.f42880a, obj);
            this.f42881b = obj;
            return objPut;
        }
    }

    public MapMakerInternalMap(MapMaker mapMaker, InternalEntryHelper internalEntryHelper) {
        mapMaker.getClass();
        this.f42832d = Math.min(4, 65536);
        this.f42833e = ((Strength) MoreObjects.a(mapMaker.f42825b, Strength.f42858a)).a();
        this.f42834f = internalEntryHelper;
        int iMin = Math.min(16, 1073741824);
        int i2 = 1;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.f42832d) {
            i5++;
            i4 <<= 1;
        }
        this.f42830b = 32 - i5;
        this.f42829a = i4 - 1;
        this.f42831c = new Segment[i4];
        int i6 = iMin / i4;
        while (i2 < (i4 * i6 < iMin ? i6 + 1 : i6)) {
            i2 <<= 1;
        }
        while (true) {
            Segment[] segmentArr = this.f42831c;
            if (i3 >= segmentArr.length) {
                return;
            }
            segmentArr[i3] = this.f42834f.a(this, i2);
            i3++;
        }
    }

    public static ArrayList a(AbstractCollection abstractCollection) {
        ArrayList arrayList = new ArrayList(abstractCollection.size());
        Iterators.a(arrayList, abstractCollection.iterator());
        return arrayList;
    }

    public final int b(Object obj) {
        int iB = this.f42833e.b(obj);
        int i2 = iB + ((iB << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = (i5 << 2) + (i5 << 14) + i5;
        return (i6 >>> 16) ^ i6;
    }

    public final Segment c(int i2) {
        return this.f42831c[(i2 >>> this.f42830b) & this.f42829a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        for (Segment segment : this.f42831c) {
            if (segment.f42853b != 0) {
                segment.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = segment.f42856e;
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    segment.e();
                    segment.f42857f.set(0);
                    segment.f42854c++;
                    segment.f42853b = 0;
                    segment.unlock();
                } catch (Throwable th) {
                    segment.unlock();
                    throw th;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        int iB = b(obj);
        Segment segmentC = c(iB);
        segmentC.getClass();
        try {
            if (segmentC.f42853b == 0) {
                return false;
            }
            InternalEntry internalEntryD = segmentC.d(iB, obj);
            if (internalEntryD != null) {
                if (internalEntryD.getValue() != null) {
                    z = true;
                }
            }
            return z;
        } finally {
            segmentC.g();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Object value;
        if (obj != null) {
            Segment[] segmentArr = this.f42831c;
            long j2 = -1;
            int i2 = 0;
            while (i2 < 3) {
                int length = segmentArr.length;
                long j3 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    Segment segment = segmentArr[i3];
                    int i4 = segment.f42853b;
                    AtomicReferenceArray atomicReferenceArray = segment.f42856e;
                    for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                        for (InternalEntry internalEntryC = (InternalEntry) atomicReferenceArray.get(i5); internalEntryC != null; internalEntryC = internalEntryC.c()) {
                            if (internalEntryC.getKey() == null || (value = internalEntryC.getValue()) == null) {
                                segment.m();
                                value = null;
                            }
                            if (value != null && this.f42834f.c().a().d(obj, value)) {
                                return true;
                            }
                        }
                    }
                    j3 += segment.f42854c;
                }
                if (j3 == j2) {
                    return false;
                }
                i2++;
                j2 = j3;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f42837i;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.f42837i = entrySet;
        return entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iB = b(obj);
        Segment segmentC = c(iB);
        segmentC.getClass();
        try {
            InternalEntry internalEntryD = segmentC.d(iB, obj);
            if (internalEntryD == null) {
                return null;
            }
            Object value = internalEntryD.getValue();
            if (value == null) {
                segmentC.m();
            }
            return value;
        } finally {
            segmentC.g();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        Segment[] segmentArr = this.f42831c;
        long j2 = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].f42853b != 0) {
                return false;
            }
            j2 += segmentArr[i2].f42854c;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < segmentArr.length; i3++) {
            if (segmentArr[i3].f42853b != 0) {
                return false;
            }
            j2 -= segmentArr[i3].f42854c;
        }
        return j2 == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.f42835g;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.f42835g = keySet;
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iB = b(obj);
        return c(iB).h(obj, iB, obj2, false);
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
        int iB = b(obj);
        return c(iB).h(obj, iB, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iB = b(obj);
        Segment segmentC = c(iB);
        segmentC.lock();
        try {
            segmentC.j();
            AtomicReferenceArray atomicReferenceArray = segmentC.f42856e;
            int length = (atomicReferenceArray.length() - 1) & iB;
            InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
            for (InternalEntry internalEntryC = internalEntry; internalEntryC != null; internalEntryC = internalEntryC.c()) {
                Object key = internalEntryC.getKey();
                if (internalEntryC.b() == iB && key != null && segmentC.f42852a.f42833e.d(obj, key)) {
                    Object value = internalEntryC.getValue();
                    if (value == null && internalEntryC.getValue() != null) {
                        return null;
                    }
                    segmentC.f42854c++;
                    InternalEntry internalEntryI = segmentC.i(internalEntry, internalEntryC);
                    int i2 = segmentC.f42853b - 1;
                    atomicReferenceArray.set(length, internalEntryI);
                    segmentC.f42853b = i2;
                    return value;
                }
            }
            return null;
        } finally {
            segmentC.unlock();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object replace(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iB = b(obj);
        Segment segmentC = c(iB);
        segmentC.lock();
        try {
            segmentC.j();
            AtomicReferenceArray atomicReferenceArray = segmentC.f42856e;
            int length = (atomicReferenceArray.length() - 1) & iB;
            InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
            for (InternalEntry internalEntryC = internalEntry; internalEntryC != null; internalEntryC = internalEntryC.c()) {
                Object key = internalEntryC.getKey();
                if (internalEntryC.b() == iB && key != null && segmentC.f42852a.f42833e.d(obj, key)) {
                    Object value = internalEntryC.getValue();
                    if (value != null) {
                        segmentC.f42854c++;
                        segmentC.l(internalEntryC, obj2);
                        return value;
                    }
                    if (internalEntryC.getValue() == null) {
                        segmentC.f42854c++;
                        InternalEntry internalEntryI = segmentC.i(internalEntry, internalEntryC);
                        int i2 = segmentC.f42853b - 1;
                        atomicReferenceArray.set(length, internalEntryI);
                        segmentC.f42853b = i2;
                    }
                    return null;
                }
            }
            return null;
        } finally {
            segmentC.unlock();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        long j2 = 0;
        for (int i2 = 0; i2 < this.f42831c.length; i2++) {
            j2 += r0[i2].f42853b;
        }
        return Ints.f(j2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.f42836h;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.f42836h = values;
        return values;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(Object obj, Object obj2) {
        boolean z = false;
        if (obj == null || obj2 == null) {
            return false;
        }
        int iB = b(obj);
        Segment segmentC = c(iB);
        segmentC.lock();
        try {
            segmentC.j();
            AtomicReferenceArray atomicReferenceArray = segmentC.f42856e;
            int length = (atomicReferenceArray.length() - 1) & iB;
            InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
            for (InternalEntry internalEntryC = internalEntry; internalEntryC != null; internalEntryC = internalEntryC.c()) {
                Object key = internalEntryC.getKey();
                if (internalEntryC.b() == iB && key != null && segmentC.f42852a.f42833e.d(obj, key)) {
                    if (segmentC.f42852a.f42834f.c().a().d(obj2, internalEntryC.getValue())) {
                        z = true;
                    } else if (internalEntryC.getValue() != null) {
                        return false;
                    }
                    segmentC.f42854c++;
                    InternalEntry internalEntryI = segmentC.i(internalEntry, internalEntryC);
                    int i2 = segmentC.f42853b - 1;
                    atomicReferenceArray.set(length, internalEntryI);
                    segmentC.f42853b = i2;
                    return z;
                }
            }
            return false;
        } finally {
            segmentC.unlock();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        obj.getClass();
        obj3.getClass();
        if (obj2 == null) {
            return false;
        }
        int iB = b(obj);
        Segment segmentC = c(iB);
        segmentC.lock();
        try {
            segmentC.j();
            AtomicReferenceArray atomicReferenceArray = segmentC.f42856e;
            int length = (atomicReferenceArray.length() - 1) & iB;
            InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
            for (InternalEntry internalEntryC = internalEntry; internalEntryC != null; internalEntryC = internalEntryC.c()) {
                Object key = internalEntryC.getKey();
                if (internalEntryC.b() == iB && key != null && segmentC.f42852a.f42833e.d(obj, key)) {
                    Object value = internalEntryC.getValue();
                    if (value == null) {
                        if (internalEntryC.getValue() == null) {
                            segmentC.f42854c++;
                            InternalEntry internalEntryI = segmentC.i(internalEntry, internalEntryC);
                            int i2 = segmentC.f42853b - 1;
                            atomicReferenceArray.set(length, internalEntryI);
                            segmentC.f42853b = i2;
                        }
                        return false;
                    }
                    if (!segmentC.f42852a.f42834f.c().a().d(obj2, value)) {
                        return false;
                    }
                    segmentC.f42854c++;
                    segmentC.l(internalEntryC, obj3);
                    return true;
                }
            }
            return false;
        } finally {
            segmentC.unlock();
        }
    }
}
