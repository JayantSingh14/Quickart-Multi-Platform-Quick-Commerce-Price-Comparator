package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import androidx.media3.exoplayer.analytics.l;
import com.facebook.cache.common.HasDebugData;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes.dex */
public class LruCountingMemoryCache<K, V> implements CountingMemoryCache<K, V>, MemoryCache<K, V>, HasDebugData {

    /* renamed from: a, reason: collision with root package name */
    public final CountingMemoryCache.EntryStateObserver f17753a;

    /* renamed from: b, reason: collision with root package name */
    public final CountingLruMap f17754b;

    /* renamed from: c, reason: collision with root package name */
    public final CountingLruMap f17755c;

    /* renamed from: d, reason: collision with root package name */
    public final ValueDescriptor f17756d;

    /* renamed from: e, reason: collision with root package name */
    public final MemoryCache.CacheTrimStrategy f17757e;

    /* renamed from: f, reason: collision with root package name */
    public final Supplier f17758f;

    /* renamed from: g, reason: collision with root package name */
    public MemoryCacheParams f17759g;

    /* renamed from: h, reason: collision with root package name */
    public long f17760h;

    /* renamed from: com.facebook.imagepipeline.cache.LruCountingMemoryCache$1, reason: invalid class name */
    class AnonymousClass1 implements ValueDescriptor<CountingMemoryCache.Entry<Object, Object>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueDescriptor f17761a;

        public AnonymousClass1(ValueDescriptor valueDescriptor) {
            this.f17761a = valueDescriptor;
        }

        @Override // com.facebook.imagepipeline.cache.ValueDescriptor
        public final int a(Object obj) {
            LruCountingMemoryCache.this.getClass();
            return this.f17761a.a(((CountingMemoryCache.Entry) obj).f17741b.l());
        }
    }

    public LruCountingMemoryCache(ValueDescriptor valueDescriptor, MemoryCache.CacheTrimStrategy cacheTrimStrategy, Supplier supplier, CountingMemoryCache.EntryStateObserver entryStateObserver) {
        new WeakHashMap();
        this.f17756d = valueDescriptor;
        this.f17754b = new CountingLruMap(new AnonymousClass1(valueDescriptor));
        this.f17755c = new CountingLruMap(new AnonymousClass1(valueDescriptor));
        this.f17757e = cacheTrimStrategy;
        this.f17758f = supplier;
        MemoryCacheParams memoryCacheParams = (MemoryCacheParams) supplier.get();
        Preconditions.d(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f17759g = memoryCacheParams;
        this.f17760h = SystemClock.uptimeMillis();
        this.f17753a = entryStateObserver;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007b  */
    @Override // com.facebook.imagepipeline.cache.MemoryCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.common.references.CloseableReference b(java.lang.Object r9, com.facebook.common.references.CloseableReference r10) {
        /*
            r8 = this;
            com.facebook.imagepipeline.cache.CountingMemoryCache$EntryStateObserver r0 = r8.f17753a
            r9.getClass()
            r10.getClass()
            r8.g()
            monitor-enter(r8)
            com.facebook.imagepipeline.cache.CountingLruMap r1 = r8.f17754b     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r1 = r1.e(r9)     // Catch: java.lang.Throwable -> L2f
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r1 = (com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) r1     // Catch: java.lang.Throwable -> L2f
            com.facebook.imagepipeline.cache.CountingLruMap r2 = r8.f17755c     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r2 = r2.e(r9)     // Catch: java.lang.Throwable -> L2f
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r2 = (com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) r2     // Catch: java.lang.Throwable -> L2f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L34
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L2f
            boolean r5 = r2.f17743d     // Catch: java.lang.Throwable -> L31
            r5 = r5 ^ r3
            com.facebook.common.internal.Preconditions.e(r5)     // Catch: java.lang.Throwable -> L31
            r2.f17743d = r3     // Catch: java.lang.Throwable -> L31
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L2f
            com.facebook.common.references.CloseableReference r2 = r8.i(r2)     // Catch: java.lang.Throwable -> L2f
            goto L35
        L2f:
            r9 = move-exception
            goto L9f
        L31:
            r9 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L31
            throw r9     // Catch: java.lang.Throwable -> L2f
        L34:
            r2 = r4
        L35:
            java.lang.Object r5 = r10.l()     // Catch: java.lang.Throwable -> L2f
            com.facebook.imagepipeline.cache.ValueDescriptor r6 = r8.f17756d     // Catch: java.lang.Throwable -> L2f
            int r5 = r6.a(r5)     // Catch: java.lang.Throwable -> L2f
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L2f
            com.facebook.imagepipeline.cache.MemoryCacheParams r6 = r8.f17759g     // Catch: java.lang.Throwable -> L73
            int r6 = r6.f17768d     // Catch: java.lang.Throwable -> L73
            if (r5 > r6) goto L7b
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L73
            com.facebook.imagepipeline.cache.CountingLruMap r6 = r8.f17755c     // Catch: java.lang.Throwable -> L78
            int r6 = r6.a()     // Catch: java.lang.Throwable -> L78
            com.facebook.imagepipeline.cache.CountingLruMap r7 = r8.f17754b     // Catch: java.lang.Throwable -> L78
            int r7 = r7.a()     // Catch: java.lang.Throwable -> L78
            int r6 = r6 - r7
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L73
            com.facebook.imagepipeline.cache.MemoryCacheParams r7 = r8.f17759g     // Catch: java.lang.Throwable -> L73
            int r7 = r7.f17766b     // Catch: java.lang.Throwable -> L73
            int r7 = r7 - r3
            if (r6 > r7) goto L7b
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L73
            com.facebook.imagepipeline.cache.CountingLruMap r6 = r8.f17755c     // Catch: java.lang.Throwable -> L75
            int r6 = r6.c()     // Catch: java.lang.Throwable -> L75
            com.facebook.imagepipeline.cache.CountingLruMap r7 = r8.f17754b     // Catch: java.lang.Throwable -> L75
            int r7 = r7.c()     // Catch: java.lang.Throwable -> L75
            int r6 = r6 - r7
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L73
            com.facebook.imagepipeline.cache.MemoryCacheParams r7 = r8.f17759g     // Catch: java.lang.Throwable -> L73
            int r7 = r7.f17765a     // Catch: java.lang.Throwable -> L73
            int r7 = r7 - r5
            if (r6 > r7) goto L7b
            goto L7c
        L73:
            r9 = move-exception
            goto L9d
        L75:
            r9 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L75
            throw r9     // Catch: java.lang.Throwable -> L73
        L78:
            r9 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L78
            throw r9     // Catch: java.lang.Throwable -> L73
        L7b:
            r3 = 0
        L7c:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L8c
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r10 = com.facebook.imagepipeline.cache.CountingMemoryCache.Entry.a(r9, r10, r0)     // Catch: java.lang.Throwable -> L2f
            com.facebook.imagepipeline.cache.CountingLruMap r0 = r8.f17755c     // Catch: java.lang.Throwable -> L2f
            r0.d(r9, r10)     // Catch: java.lang.Throwable -> L2f
            com.facebook.common.references.DefaultCloseableReference r4 = r8.h(r10)     // Catch: java.lang.Throwable -> L2f
        L8c:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L2f
            com.facebook.common.references.CloseableReference.e(r2)
            if (r1 == 0) goto L99
            com.facebook.imagepipeline.cache.CountingMemoryCache$EntryStateObserver r9 = r1.f17744e
            if (r9 == 0) goto L99
            r9.a()
        L99:
            r8.f()
            return r4
        L9d:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L73
            throw r9     // Catch: java.lang.Throwable -> L2f
        L9f:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L2f
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.LruCountingMemoryCache.b(java.lang.Object, com.facebook.common.references.CloseableReference):com.facebook.common.references.CloseableReference");
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public final int c(Predicate predicate) {
        ArrayList arrayListF;
        ArrayList arrayListF2;
        CountingMemoryCache.EntryStateObserver entryStateObserver;
        synchronized (this) {
            arrayListF = this.f17754b.f(predicate);
            arrayListF2 = this.f17755c.f(predicate);
            e(arrayListF2);
        }
        Iterator it = arrayListF2.iterator();
        while (it.hasNext()) {
            CloseableReference.e(i((CountingMemoryCache.Entry) it.next()));
        }
        Iterator it2 = arrayListF.iterator();
        while (it2.hasNext()) {
            CountingMemoryCache.Entry entry = (CountingMemoryCache.Entry) it2.next();
            if (entry != null && (entryStateObserver = entry.f17744e) != null) {
                entryStateObserver.a();
            }
        }
        g();
        f();
        return arrayListF2.size();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public final synchronized boolean d(l lVar) {
        return !this.f17755c.b(lVar).isEmpty();
    }

    public final synchronized void e(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CountingMemoryCache.Entry entry = (CountingMemoryCache.Entry) it.next();
                synchronized (this) {
                    entry.getClass();
                    Preconditions.e(!entry.f17743d);
                    entry.f17743d = true;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.facebook.imagepipeline.cache.MemoryCacheParams r0 = r5.f17759g     // Catch: java.lang.Throwable -> L78
            r0.getClass()     // Catch: java.lang.Throwable -> L78
            int r0 = r0.f17766b     // Catch: java.lang.Throwable -> L78
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L78
            com.facebook.imagepipeline.cache.CountingLruMap r1 = r5.f17755c     // Catch: java.lang.Throwable -> L7d
            int r1 = r1.a()     // Catch: java.lang.Throwable -> L7d
            com.facebook.imagepipeline.cache.CountingLruMap r2 = r5.f17754b     // Catch: java.lang.Throwable -> L7d
            int r2 = r2.a()     // Catch: java.lang.Throwable -> L7d
            int r1 = r1 - r2
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L78
            int r0 = r0 - r1
            r1 = 2147483647(0x7fffffff, float:NaN)
            int r0 = java.lang.Math.min(r1, r0)     // Catch: java.lang.Throwable -> L78
            com.facebook.imagepipeline.cache.MemoryCacheParams r1 = r5.f17759g     // Catch: java.lang.Throwable -> L78
            int r2 = r1.f17767c     // Catch: java.lang.Throwable -> L78
            int r1 = r1.f17765a     // Catch: java.lang.Throwable -> L78
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L78
            com.facebook.imagepipeline.cache.CountingLruMap r3 = r5.f17755c     // Catch: java.lang.Throwable -> L7a
            int r3 = r3.c()     // Catch: java.lang.Throwable -> L7a
            com.facebook.imagepipeline.cache.CountingLruMap r4 = r5.f17754b     // Catch: java.lang.Throwable -> L7a
            int r4 = r4.c()     // Catch: java.lang.Throwable -> L7a
            int r3 = r3 - r4
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L78
            int r1 = r1 - r3
            int r1 = java.lang.Math.min(r2, r1)     // Catch: java.lang.Throwable -> L78
            java.util.ArrayList r0 = r5.j(r0, r1)     // Catch: java.lang.Throwable -> L78
            r5.e(r0)     // Catch: java.lang.Throwable -> L78
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L5b
            java.util.Iterator r1 = r0.iterator()
        L47:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L5b
            java.lang.Object r2 = r1.next()
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r2 = (com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) r2
            com.facebook.common.references.CloseableReference r2 = r5.i(r2)
            com.facebook.common.references.CloseableReference.e(r2)
            goto L47
        L5b:
            if (r0 == 0) goto L77
            java.util.Iterator r0 = r0.iterator()
        L61:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L77
            java.lang.Object r1 = r0.next()
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r1 = (com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) r1
            if (r1 == 0) goto L61
            com.facebook.imagepipeline.cache.CountingMemoryCache$EntryStateObserver r1 = r1.f17744e
            if (r1 == 0) goto L61
            r1.a()
            goto L61
        L77:
            return
        L78:
            r0 = move-exception
            goto L80
        L7a:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7a
            throw r0     // Catch: java.lang.Throwable -> L78
        L7d:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7d
            throw r0     // Catch: java.lang.Throwable -> L78
        L80:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L78
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.LruCountingMemoryCache.f():void");
    }

    public final synchronized void g() {
        if (this.f17760h + this.f17759g.f17769e > SystemClock.uptimeMillis()) {
            return;
        }
        this.f17760h = SystemClock.uptimeMillis();
        MemoryCacheParams memoryCacheParams = (MemoryCacheParams) this.f17758f.get();
        Preconditions.d(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f17759g = memoryCacheParams;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public final CloseableReference get(Object obj) {
        CountingMemoryCache.Entry entry;
        Object obj2;
        DefaultCloseableReference defaultCloseableReferenceH;
        CountingMemoryCache.EntryStateObserver entryStateObserver;
        obj.getClass();
        synchronized (this) {
            try {
                entry = (CountingMemoryCache.Entry) this.f17754b.e(obj);
                CountingLruMap countingLruMap = this.f17755c;
                synchronized (countingLruMap) {
                    obj2 = countingLruMap.f17738b.get(obj);
                }
                CountingMemoryCache.Entry entry2 = (CountingMemoryCache.Entry) obj2;
                defaultCloseableReferenceH = entry2 != null ? h(entry2) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (entry != null && (entryStateObserver = entry.f17744e) != null) {
            entryStateObserver.a();
        }
        g();
        f();
        return defaultCloseableReferenceH;
    }

    public final synchronized DefaultCloseableReference h(final CountingMemoryCache.Entry entry) {
        synchronized (this) {
            Preconditions.e(!entry.f17743d);
            entry.f17742c++;
        }
        return CloseableReference.O(entry.f17741b.l(), new ResourceReleaser<Object>() { // from class: com.facebook.imagepipeline.cache.LruCountingMemoryCache.2
            /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
            @Override // com.facebook.common.references.ResourceReleaser
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void a(java.lang.Object r5) {
                /*
                    r4 = this;
                    com.facebook.imagepipeline.cache.LruCountingMemoryCache r5 = com.facebook.imagepipeline.cache.LruCountingMemoryCache.this
                    com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r0 = r2
                    r5.getClass()
                    monitor-enter(r5)
                    monitor-enter(r5)     // Catch: java.lang.Throwable -> L4d
                    int r1 = r0.f17742c     // Catch: java.lang.Throwable -> L51
                    r2 = 0
                    r3 = 1
                    if (r1 <= 0) goto L11
                    r1 = r3
                    goto L12
                L11:
                    r1 = r2
                L12:
                    com.facebook.common.internal.Preconditions.e(r1)     // Catch: java.lang.Throwable -> L51
                    int r1 = r0.f17742c     // Catch: java.lang.Throwable -> L51
                    int r1 = r1 - r3
                    r0.f17742c = r1     // Catch: java.lang.Throwable -> L51
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L4d
                    monitor-enter(r5)     // Catch: java.lang.Throwable -> L4d
                    boolean r1 = r0.f17743d     // Catch: java.lang.Throwable -> L2e
                    if (r1 != 0) goto L30
                    int r1 = r0.f17742c     // Catch: java.lang.Throwable -> L2e
                    if (r1 != 0) goto L30
                    com.facebook.imagepipeline.cache.CountingLruMap r1 = r5.f17754b     // Catch: java.lang.Throwable -> L2e
                    java.lang.Object r2 = r0.f17740a     // Catch: java.lang.Throwable -> L2e
                    r1.d(r2, r0)     // Catch: java.lang.Throwable -> L2e
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L4d
                    r2 = r3
                    goto L31
                L2e:
                    r0 = move-exception
                    goto L4f
                L30:
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L4d
                L31:
                    com.facebook.common.references.CloseableReference r1 = r5.i(r0)     // Catch: java.lang.Throwable -> L4d
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L4d
                    com.facebook.common.references.CloseableReference.e(r1)
                    if (r2 == 0) goto L3c
                    goto L3d
                L3c:
                    r0 = 0
                L3d:
                    if (r0 == 0) goto L46
                    com.facebook.imagepipeline.cache.CountingMemoryCache$EntryStateObserver r0 = r0.f17744e
                    if (r0 == 0) goto L46
                    r0.a()
                L46:
                    r5.g()
                    r5.f()
                    return
                L4d:
                    r0 = move-exception
                    goto L54
                L4f:
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L2e
                    throw r0     // Catch: java.lang.Throwable -> L4d
                L51:
                    r0 = move-exception
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L51
                    throw r0     // Catch: java.lang.Throwable -> L4d
                L54:
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L4d
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.LruCountingMemoryCache.AnonymousClass2.a(java.lang.Object):void");
            }
        });
        return CloseableReference.O(entry.f17741b.l(), new ResourceReleaser<Object>() { // from class: com.facebook.imagepipeline.cache.LruCountingMemoryCache.2
            @Override // com.facebook.common.references.ResourceReleaser
            public final void a(Object v) {
                /*
                    this = this;
                    com.facebook.imagepipeline.cache.LruCountingMemoryCache r5 = com.facebook.imagepipeline.cache.LruCountingMemoryCache.this
                    com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r0 = r2
                    r5.getClass()
                    monitor-enter(r5)
                    monitor-enter(r5)     // Catch: java.lang.Throwable -> L4d
                    int r1 = r0.f17742c     // Catch: java.lang.Throwable -> L51
                    r2 = 0
                    r3 = 1
                    if (r1 <= 0) goto L11
                    r1 = r3
                    goto L12
                L11:
                    r1 = r2
                L12:
                    com.facebook.common.internal.Preconditions.e(r1)     // Catch: java.lang.Throwable -> L51
                    int r1 = r0.f17742c     // Catch: java.lang.Throwable -> L51
                    int r1 = r1 - r3
                    r0.f17742c = r1     // Catch: java.lang.Throwable -> L51
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L4d
                    monitor-enter(r5)     // Catch: java.lang.Throwable -> L4d
                    boolean r1 = r0.f17743d     // Catch: java.lang.Throwable -> L2e
                    if (r1 != 0) goto L30
                    int r1 = r0.f17742c     // Catch: java.lang.Throwable -> L2e
                    if (r1 != 0) goto L30
                    com.facebook.imagepipeline.cache.CountingLruMap r1 = r5.f17754b     // Catch: java.lang.Throwable -> L2e
                    java.lang.Object r2 = r0.f17740a     // Catch: java.lang.Throwable -> L2e
                    r1.d(r2, r0)     // Catch: java.lang.Throwable -> L2e
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L4d
                    r2 = r3
                    goto L31
                L2e:
                    r0 = move-exception
                    goto L4f
                L30:
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L4d
                L31:
                    com.facebook.common.references.CloseableReference r1 = r5.i(r0)     // Catch: java.lang.Throwable -> L4d
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L4d
                    com.facebook.common.references.CloseableReference.e(r1)
                    if (r2 == 0) goto L3c
                    goto L3d
                L3c:
                    r0 = 0
                L3d:
                    if (r0 == 0) goto L46
                    com.facebook.imagepipeline.cache.CountingMemoryCache$EntryStateObserver r0 = r0.f17744e
                    if (r0 == 0) goto L46
                    r0.a()
                L46:
                    r5.g()
                    r5.f()
                    return
                L4d:
                    r0 = move-exception
                    goto L54
                L4f:
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L2e
                    throw r0     // Catch: java.lang.Throwable -> L4d
                L51:
                    r0 = move-exception
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L51
                    throw r0     // Catch: java.lang.Throwable -> L4d
                L54:
                    monitor-exit(r5)     // Catch: java.lang.Throwable -> L4d
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.LruCountingMemoryCache.AnonymousClass2.a(java.lang.Object):void");
            }
        });
    }

    public final synchronized CloseableReference i(CountingMemoryCache.Entry entry) {
        entry.getClass();
        return (entry.f17743d && entry.f17742c == 0) ? entry.f17741b : null;
    }

    public final synchronized ArrayList j(int i2, int i3) {
        K next;
        int iMax = Math.max(i2, 0);
        int iMax2 = Math.max(i3, 0);
        if (this.f17754b.a() <= iMax && this.f17754b.c() <= iMax2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (this.f17754b.a() <= iMax && this.f17754b.c() <= iMax2) {
                return arrayList;
            }
            CountingLruMap countingLruMap = this.f17754b;
            synchronized (countingLruMap) {
                next = countingLruMap.f17738b.isEmpty() ? null : countingLruMap.f17738b.keySet().iterator().next();
            }
            if (next == null) {
                throw new IllegalStateException(String.format("key is null, but exclusiveEntries count: %d, size: %d", Integer.valueOf(this.f17754b.a()), Integer.valueOf(this.f17754b.c())));
            }
            this.f17754b.e(next);
            arrayList.add((CountingMemoryCache.Entry) this.f17755c.e(next));
        }
    }
}
