package ch.qos.logback.classic.turbo;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
class LRUMessageCache extends LinkedHashMap<String, Integer> {

    /* renamed from: a, reason: collision with root package name */
    public final int f13398a;

    public LRUMessageCache(int i2) {
        super((int) (i2 * 1.3333334f), 0.75f, true);
        if (i2 < 1) {
            throw new IllegalArgumentException("Cache size cannot be smaller than 1");
        }
        this.f13398a = i2;
    }

    public final int a(String str) {
        Integer numValueOf;
        if (str == null) {
            return 0;
        }
        synchronized (this) {
            try {
                Integer num = (Integer) super.get(str);
                numValueOf = num == null ? 0 : Integer.valueOf(num.intValue() + 1);
                super.put(str, numValueOf);
            } catch (Throwable th) {
                throw th;
            }
        }
        return numValueOf.intValue();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final synchronized void clear() {
        super.clear();
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry<String, Integer> entry) {
        return size() > this.f13398a;
    }
}
