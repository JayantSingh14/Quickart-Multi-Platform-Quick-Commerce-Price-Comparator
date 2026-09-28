package androidx.collection;

import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class LruCache<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final int f1481a;

    /* renamed from: b, reason: collision with root package name */
    public final LruHashMap f1482b;

    /* renamed from: c, reason: collision with root package name */
    public final Lock f1483c;

    /* renamed from: d, reason: collision with root package name */
    public int f1484d;

    /* renamed from: e, reason: collision with root package name */
    public int f1485e;

    /* renamed from: f, reason: collision with root package name */
    public int f1486f;

    public LruCache(int i2) {
        this.f1481a = i2;
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f1482b = new LruHashMap(0);
        this.f1483c = new Lock();
    }

    public Object a(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    public void b(Object key, Object oldValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(Object key) {
        Object value;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.f1483c) {
            LruHashMap lruHashMap = this.f1482b;
            lruHashMap.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            Object obj = lruHashMap.f1613a.get(key);
            if (obj != null) {
                this.f1485e++;
                return obj;
            }
            this.f1486f++;
            Object value2 = a(key);
            if (value2 == null) {
                return null;
            }
            synchronized (this.f1483c) {
                try {
                    LruHashMap lruHashMap2 = this.f1482b;
                    lruHashMap2.getClass();
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(value2, "value");
                    value = lruHashMap2.f1613a.put(key, value2);
                    if (value != null) {
                        LruHashMap lruHashMap3 = this.f1482b;
                        lruHashMap3.getClass();
                        Intrinsics.checkNotNullParameter(key, "key");
                        Intrinsics.checkNotNullParameter(value, "value");
                        lruHashMap3.f1613a.put(key, value);
                    } else {
                        this.f1484d += e(key, value2);
                        Unit unit = Unit.f53572a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (value != null) {
                b(key, value2);
                return value;
            }
            g(this.f1481a);
            return value2;
        }
    }

    public final Object d(Object key, Object value) {
        Object objPut;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.f1483c) {
            try {
                this.f1484d += e(key, value);
                LruHashMap lruHashMap = this.f1482b;
                lruHashMap.getClass();
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                objPut = lruHashMap.f1613a.put(key, value);
                if (objPut != null) {
                    this.f1484d -= e(key, objPut);
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objPut != null) {
            b(key, objPut);
        }
        g(this.f1481a);
        return objPut;
    }

    public final int e(Object obj, Object obj2) {
        int iF = f(obj, obj2);
        if (iF >= 0) {
            return iF;
        }
        throw new IllegalStateException(("Negative size: " + obj + '=' + obj2).toString());
    }

    public int f(Object key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0092, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r6) {
        /*
            r5 = this;
        L0:
            androidx.collection.internal.Lock r0 = r5.f1483c
            monitor-enter(r0)
            int r1 = r5.f1484d     // Catch: java.lang.Throwable -> L16
            if (r1 < 0) goto L8b
            androidx.collection.internal.LruHashMap r1 = r5.f1482b     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r1 = r1.f1613a     // Catch: java.lang.Throwable -> L16
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto L19
            int r1 = r5.f1484d     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L8b
            goto L19
        L16:
            r6 = move-exception
            goto L93
        L19:
            int r1 = r5.f1484d     // Catch: java.lang.Throwable -> L16
            if (r1 <= r6) goto L89
            androidx.collection.internal.LruHashMap r1 = r5.f1482b     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r1 = r1.f1613a     // Catch: java.lang.Throwable -> L16
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto L28
            goto L89
        L28:
            androidx.collection.internal.LruHashMap r1 = r5.f1482b     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r1 = r1.f1613a     // Catch: java.lang.Throwable -> L16
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = "map.entries"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)     // Catch: java.lang.Throwable -> L16
            boolean r2 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L4d
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L16
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L47
            goto L57
        L47:
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L16
            goto L5d
        L4d:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L16
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L16
            if (r2 != 0) goto L59
        L57:
            r1 = 0
            goto L5d
        L59:
            java.lang.Object r1 = r1.next()     // Catch: java.lang.Throwable -> L16
        L5d:
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L63
            monitor-exit(r0)
            return
        L63:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L16
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L16
            androidx.collection.internal.LruHashMap r3 = r5.f1482b     // Catch: java.lang.Throwable -> L16
            r3.getClass()     // Catch: java.lang.Throwable -> L16
            java.lang.String r4 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r3 = r3.f1613a     // Catch: java.lang.Throwable -> L16
            r3.remove(r2)     // Catch: java.lang.Throwable -> L16
            int r3 = r5.f1484d     // Catch: java.lang.Throwable -> L16
            int r4 = r5.e(r2, r1)     // Catch: java.lang.Throwable -> L16
            int r3 = r3 - r4
            r5.f1484d = r3     // Catch: java.lang.Throwable -> L16
            monitor-exit(r0)
            r5.b(r2, r1)
            goto L0
        L89:
            monitor-exit(r0)
            return
        L8b:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L16
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L16
            throw r1     // Catch: java.lang.Throwable -> L16
        L93:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.g(int):void");
    }

    public final String toString() {
        String str;
        synchronized (this.f1483c) {
            try {
                int i2 = this.f1485e;
                int i3 = this.f1486f + i2;
                str = "LruCache[maxSize=" + this.f1481a + ",hits=" + this.f1485e + ",misses=" + this.f1486f + ",hitRate=" + (i3 != 0 ? (i2 * 100) / i3 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
