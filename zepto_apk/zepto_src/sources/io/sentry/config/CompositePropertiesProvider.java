package io.sentry.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
final class CompositePropertiesProvider implements PropertiesProvider {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f52728a;

    public CompositePropertiesProvider(ArrayList arrayList) {
        this.f52728a = arrayList;
    }

    @Override // io.sentry.config.PropertiesProvider
    public final String b(String str) {
        Iterator it = this.f52728a.iterator();
        while (it.hasNext()) {
            String strB = ((PropertiesProvider) it.next()).b(str);
            if (strB != null) {
                return strB;
            }
        }
        return null;
    }

    @Override // io.sentry.config.PropertiesProvider
    public final Map c() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Iterator it = this.f52728a.iterator();
        while (it.hasNext()) {
            concurrentHashMap.putAll(((PropertiesProvider) it.next()).c());
        }
        return concurrentHashMap;
    }
}
