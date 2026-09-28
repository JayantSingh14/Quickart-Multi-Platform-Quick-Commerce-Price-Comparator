package com.facebook.imagepipeline.cache;

import androidx.media3.exoplayer.analytics.l;
import com.facebook.common.internal.Predicate;
import com.facebook.imagepipeline.cache.LruCountingMemoryCache;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes.dex */
public class CountingLruMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final ValueDescriptor f17737a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f17738b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public int f17739c = 0;

    public CountingLruMap(ValueDescriptor valueDescriptor) {
        this.f17737a = valueDescriptor;
    }

    public final synchronized int a() {
        return this.f17738b.size();
    }

    public final synchronized ArrayList b(l lVar) {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f17738b.entrySet().size());
        for (Map.Entry<K, V> entry : this.f17738b.entrySet()) {
            if (lVar.mo0apply((Object) entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public final synchronized int c() {
        return this.f17739c;
    }

    public final synchronized void d(Object obj, Object obj2) {
        Object objRemove = this.f17738b.remove(obj);
        this.f17739c -= objRemove == null ? 0 : ((LruCountingMemoryCache.AnonymousClass1) this.f17737a).a(objRemove);
        this.f17738b.put(obj, obj2);
        this.f17739c += ((LruCountingMemoryCache.AnonymousClass1) this.f17737a).a(obj2);
    }

    public final synchronized Object e(Object obj) {
        Object objRemove;
        objRemove = this.f17738b.remove(obj);
        this.f17739c -= objRemove == null ? 0 : ((LruCountingMemoryCache.AnonymousClass1) this.f17737a).a(objRemove);
        return objRemove;
    }

    public final synchronized ArrayList f(Predicate predicate) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<Map.Entry<K, V>> it = this.f17738b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (predicate.mo0apply(next.getKey())) {
                arrayList.add(next.getValue());
                int i2 = this.f17739c;
                V value = next.getValue();
                this.f17739c = i2 - (value == null ? 0 : ((LruCountingMemoryCache.AnonymousClass1) this.f17737a).a(value));
                it.remove();
            }
        }
        return arrayList;
    }
}
