package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class LruCache<T, Y> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f16521a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    public final long f16522b;

    /* renamed from: c, reason: collision with root package name */
    public long f16523c;

    public LruCache(long j2) {
        this.f16522b = j2;
    }

    public final void a() {
        f(0L);
    }

    public final synchronized Object b(Object obj) {
        return this.f16521a.get(obj);
    }

    public int c(Object obj) {
        return 1;
    }

    public void d(Object obj, Object obj2) {
    }

    public final synchronized Object e(Object obj, Object obj2) {
        long jC = c(obj2);
        if (jC >= this.f16522b) {
            d(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f16523c += jC;
        }
        Object objPut = this.f16521a.put(obj, obj2);
        if (objPut != null) {
            this.f16523c -= c(objPut);
            if (!objPut.equals(obj2)) {
                d(obj, objPut);
            }
        }
        f(this.f16522b);
        return objPut;
    }

    public final synchronized void f(long j2) {
        while (this.f16523c > j2) {
            Iterator it = this.f16521a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            this.f16523c -= c(value);
            Object key = entry.getKey();
            it.remove();
            d(key, value);
        }
    }
}
