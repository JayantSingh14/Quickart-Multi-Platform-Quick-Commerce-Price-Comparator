package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f54441b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54442c = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final ReferenceQueue f54443a;
    private volatile /* synthetic */ Object core$volatile;

    @Metadata
    public final class Core {

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f54444g = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load$volatile");

        /* renamed from: a, reason: collision with root package name */
        public final int f54445a;

        /* renamed from: b, reason: collision with root package name */
        public final int f54446b;

        /* renamed from: c, reason: collision with root package name */
        public final int f54447c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicReferenceArray f54448d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AtomicReferenceArray f54449e;
        private volatile /* synthetic */ int load$volatile;

        @Metadata
        @SourceDebugExtension
        public final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator {

            /* renamed from: a, reason: collision with root package name */
            public final Function2 f54451a;

            /* renamed from: b, reason: collision with root package name */
            public int f54452b = -1;

            /* renamed from: c, reason: collision with root package name */
            public Object f54453c;

            /* renamed from: d, reason: collision with root package name */
            public Object f54454d;

            public KeyValueIterator(Function2 function2) {
                this.f54451a = function2;
                a();
            }

            public final void a() {
                T t;
                while (true) {
                    int i2 = this.f54452b + 1;
                    this.f54452b = i2;
                    Core core = Core.this;
                    if (i2 >= core.f54445a) {
                        return;
                    }
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) core.f54448d.get(i2);
                    if (hashedWeakRef != null && (t = hashedWeakRef.get()) != 0) {
                        this.f54453c = t;
                        Object obj = core.f54449e.get(this.f54452b);
                        if (obj instanceof Marked) {
                            obj = ((Marked) obj).f54467a;
                        }
                        if (obj != null) {
                            this.f54454d = obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f54452b < Core.this.f54445a;
            }

            @Override // java.util.Iterator
            public final Object next() {
                if (this.f54452b >= Core.this.f54445a) {
                    throw new NoSuchElementException();
                }
                Object obj = this.f54453c;
                if (obj == null) {
                    Intrinsics.h("key");
                    throw null;
                }
                Object obj2 = this.f54454d;
                if (obj2 == null) {
                    Intrinsics.h(CLConstants.FIELD_PAY_INFO_VALUE);
                    throw null;
                }
                Object objInvoke = this.f54451a.invoke(obj, obj2);
                a();
                return objInvoke;
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException("not implemented");
            }
        }

        public Core(int i2) {
            this.f54445a = i2;
            this.f54446b = Integer.numberOfLeadingZeros(i2) + 1;
            this.f54447c = (i2 * 2) / 3;
            this.f54448d = new AtomicReferenceArray(i2);
            this.f54449e = new AtomicReferenceArray(i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
        
            return r4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(java.lang.Object r10, java.lang.Object r11, kotlinx.coroutines.debug.internal.HashedWeakRef r12) {
            /*
                r9 = this;
                int r0 = r10.hashCode()
                r1 = -1640531527(0xffffffff9e3779b9, float:-9.713111E-21)
                int r0 = r0 * r1
                int r1 = r9.f54446b
                int r0 = r0 >>> r1
                r1 = 0
            Lc:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r9.f54448d
                java.lang.Object r3 = r2.get(r0)
                kotlinx.coroutines.debug.internal.HashedWeakRef r3 = (kotlinx.coroutines.debug.internal.HashedWeakRef) r3
                kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.f54460a
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.f54444g
                if (r3 != 0) goto L54
                r6 = 0
                if (r11 != 0) goto L1e
                return r6
            L1e:
                if (r1 != 0) goto L32
            L20:
                int r1 = r5.get(r9)
                int r3 = r9.f54447c
                if (r1 < r3) goto L29
                goto L6d
            L29:
                int r3 = r1 + 1
                boolean r1 = r5.compareAndSet(r9, r1, r3)
                if (r1 == 0) goto L20
                r1 = 1
            L32:
                r7 = r1
                if (r12 != 0) goto L43
                kotlinx.coroutines.debug.internal.HashedWeakRef r12 = new kotlinx.coroutines.debug.internal.HashedWeakRef
                kotlinx.coroutines.debug.internal.ConcurrentWeakMap r1 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this
                java.lang.ref.ReferenceQueue r1 = r1.f54443a
                r12.<init>(r10, r1)
                if (r10 == 0) goto L43
                r10.hashCode()
            L43:
                r8 = r12
            L44:
                boolean r12 = r2.compareAndSet(r0, r6, r8)
                if (r12 == 0) goto L4b
                goto L63
            L4b:
                java.lang.Object r12 = r2.get(r0)
                if (r12 == 0) goto L44
                r1 = r7
                r12 = r8
                goto Lc
            L54:
                java.lang.Object r2 = r3.get()
                boolean r3 = r10.equals(r2)
                if (r3 == 0) goto L7c
                if (r1 == 0) goto L63
                r5.decrementAndGet(r9)
            L63:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r9.f54449e
                java.lang.Object r5 = r3.get(r0)
                boolean r10 = r5 instanceof kotlinx.coroutines.debug.internal.Marked
                if (r10 == 0) goto L6e
            L6d:
                return r4
            L6e:
                boolean r10 = r3.compareAndSet(r0, r5, r11)
                if (r10 == 0) goto L75
                return r5
            L75:
                java.lang.Object r10 = r3.get(r0)
                if (r10 == r5) goto L6e
                goto L63
            L7c:
                if (r2 != 0) goto L81
                r9.c(r0)
            L81:
                if (r0 != 0) goto L85
                int r0 = r9.f54445a
            L85:
                int r0 = r0 + (-1)
                goto Lc
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.a(java.lang.Object, java.lang.Object, kotlinx.coroutines.debug.internal.HashedWeakRef):java.lang.Object");
        }

        public final Core b() {
            int i2;
            Object obj;
            while (true) {
                ConcurrentWeakMap concurrentWeakMap = ConcurrentWeakMap.this;
                int iC = concurrentWeakMap.c();
                if (iC < 4) {
                    iC = 4;
                }
                Core core = new Core(Integer.highestOneBit(iC) * 4);
                while (i2 < this.f54445a) {
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) this.f54448d.get(i2);
                    Object obj2 = hashedWeakRef != null ? hashedWeakRef.get() : null;
                    if (hashedWeakRef != null && obj2 == null) {
                        c(i2);
                    }
                    while (true) {
                        AtomicReferenceArray atomicReferenceArray = this.f54449e;
                        obj = atomicReferenceArray.get(i2);
                        if (!(obj instanceof Marked)) {
                            Marked marked = obj == null ? ConcurrentWeakMapKt.f54461b : obj.equals(Boolean.TRUE) ? ConcurrentWeakMapKt.f54462c : new Marked(obj);
                            while (!atomicReferenceArray.compareAndSet(i2, obj, marked)) {
                                if (atomicReferenceArray.get(i2) != obj) {
                                    break;
                                }
                            }
                            break;
                        }
                        obj = ((Marked) obj).f54467a;
                        break;
                    }
                    i2 = (obj2 == null || obj == null || core.a(obj2, obj, hashedWeakRef) != ConcurrentWeakMapKt.f54460a) ? i2 + 1 : 0;
                }
                return core;
            }
        }

        public final void c(int i2) {
            while (true) {
                AtomicReferenceArray atomicReferenceArray = this.f54449e;
                Object obj = atomicReferenceArray.get(i2);
                if (obj == null || (obj instanceof Marked)) {
                    return;
                }
                while (!atomicReferenceArray.compareAndSet(i2, obj, null)) {
                    if (atomicReferenceArray.get(i2) != obj) {
                        break;
                    }
                }
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = ConcurrentWeakMap.f54441b;
                ConcurrentWeakMap concurrentWeakMap = ConcurrentWeakMap.this;
                concurrentWeakMap.getClass();
                ConcurrentWeakMap.f54441b.decrementAndGet(concurrentWeakMap);
                return;
            }
        }
    }

    @Metadata
    public static final class Entry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* renamed from: a, reason: collision with root package name */
        public final Object f54456a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f54457b;

        public Entry(Object obj, Object obj2) {
            this.f54456a = obj;
            this.f54457b = obj2;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f54456a;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.f54457b;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException("not implemented");
        }
    }

    @Metadata
    public final class KeyValueSet<E> extends AbstractMutableSet<E> {

        /* renamed from: a, reason: collision with root package name */
        public final Function2 f54458a;

        public KeyValueSet(Function2 function2) {
            this.f54458a = function2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException("not implemented");
        }

        @Override // kotlin.collections.AbstractMutableSet
        public final int b() {
            return ConcurrentWeakMap.this.c();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            Core core = (Core) ConcurrentWeakMap.f54442c.get(ConcurrentWeakMap.this);
            core.getClass();
            return core.new KeyValueIterator(this.f54458a);
        }
    }

    public ConcurrentWeakMap() {
        this(false);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final Set a() {
        return new KeyValueSet(new a(0));
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final Set b() {
        return new KeyValueSet(new a(1));
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final int c() {
        return f54441b.get(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Iterator it = ((KeyValueSet) b()).iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final synchronized Object d(Object obj, Object obj2) {
        Object objA;
        Core coreB = (Core) f54442c.get(this);
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = Core.f54444g;
            objA = coreB.a(obj, obj2, null);
            if (objA == ConcurrentWeakMapKt.f54460a) {
                coreB = coreB.b();
                f54442c.set(this, coreB);
            }
        }
        return objA;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        Core core = (Core) f54442c.get(this);
        core.getClass();
        int iHashCode = (obj.hashCode() * (-1640531527)) >>> core.f54446b;
        while (true) {
            HashedWeakRef hashedWeakRef = (HashedWeakRef) core.f54448d.get(iHashCode);
            if (hashedWeakRef == null) {
                return null;
            }
            Object obj2 = hashedWeakRef.get();
            if (obj.equals(obj2)) {
                Object obj3 = core.f54449e.get(iHashCode);
                return obj3 instanceof Marked ? ((Marked) obj3).f54467a : obj3;
            }
            if (obj2 == null) {
                core.c(iHashCode);
            }
            if (iHashCode == 0) {
                iHashCode = core.f54445a;
            }
            iHashCode--;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        Core core = (Core) f54442c.get(this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = Core.f54444g;
        Object objA = core.a(obj, obj2, null);
        if (objA == ConcurrentWeakMapKt.f54460a) {
            objA = d(obj, obj2);
        }
        if (objA == null) {
            f54441b.incrementAndGet(this);
        }
        return objA;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        Core core = (Core) f54442c.get(this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = Core.f54444g;
        Object objA = core.a(obj, null, null);
        if (objA == ConcurrentWeakMapKt.f54460a) {
            objA = d(obj, null);
        }
        if (objA != null) {
            f54441b.decrementAndGet(this);
        }
        return objA;
    }

    public ConcurrentWeakMap(boolean z) {
        this.core$volatile = new Core(16);
        this.f54443a = z ? new ReferenceQueue() : null;
    }
}
