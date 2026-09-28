package org.apache.xml.security.utils;

import org.apache.xpath.CachedXPathAPI;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public class CachedXPathAPIHolder {

    /* renamed from: a, reason: collision with root package name */
    static ThreadLocal f57313a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    static ThreadLocal f57314b = new ThreadLocal();

    public static CachedXPathAPI a() {
        CachedXPathAPI cachedXPathAPI = (CachedXPathAPI) f57313a.get();
        if (cachedXPathAPI != null) {
            return cachedXPathAPI;
        }
        CachedXPathAPI cachedXPathAPI2 = new CachedXPathAPI();
        f57313a.set(cachedXPathAPI2);
        f57314b.set(null);
        return cachedXPathAPI2;
    }

    public static void a(Document document) {
        if (f57314b.get() != document) {
            CachedXPathAPI cachedXPathAPI = (CachedXPathAPI) f57313a.get();
            if (cachedXPathAPI == null) {
                f57313a.set(new CachedXPathAPI());
            } else {
                cachedXPathAPI.getXPathContext().reset();
            }
            f57314b.set(document);
        }
    }
}
