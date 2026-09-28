package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.spi.MDCAdapter;

/* loaded from: classes5.dex */
public class BasicMDCAdapter implements MDCAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final InheritableThreadLocal f57885a = new AnonymousClass1();

    /* renamed from: org.slf4j.helpers.BasicMDCAdapter$1, reason: invalid class name */
    public class AnonymousClass1 extends InheritableThreadLocal<Map<String, String>> {
        @Override // java.lang.InheritableThreadLocal
        public final Map<String, String> childValue(Map<String, String> map) {
            Map<String, String> map2 = map;
            if (map2 == null) {
                return null;
            }
            return new HashMap(map2);
        }
    }

    @Override // org.slf4j.spi.MDCAdapter
    public final Map a() {
        Map map = (Map) this.f57885a.get();
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    @Override // org.slf4j.spi.MDCAdapter
    public final void b(Map map) {
        this.f57885a.set(new HashMap(map));
    }

    @Override // org.slf4j.spi.MDCAdapter
    public final void clear() {
        InheritableThreadLocal inheritableThreadLocal = this.f57885a;
        Map map = (Map) inheritableThreadLocal.get();
        if (map != null) {
            map.clear();
            inheritableThreadLocal.remove();
        }
    }
}
