package ch.qos.logback.classic.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.spi.MDCAdapter;

/* loaded from: classes3.dex */
public class LogbackMDCAdapter implements MDCAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f13413a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public final ThreadLocal f13414b = new ThreadLocal();

    @Override // org.slf4j.spi.MDCAdapter
    public final Map a() {
        Map map = (Map) this.f13413a.get();
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }

    @Override // org.slf4j.spi.MDCAdapter
    public final void b(Map map) {
        this.f13414b.set(1);
        Map mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        mapSynchronizedMap.putAll(map);
        this.f13413a.set(mapSynchronizedMap);
    }

    @Override // org.slf4j.spi.MDCAdapter
    public final void clear() {
        this.f13414b.set(1);
        this.f13413a.remove();
    }
}
