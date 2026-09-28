package io.sentry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class Hint {

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap f51635g;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f51636a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f51637b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public Attachment f51638c = null;

    /* renamed from: d, reason: collision with root package name */
    public Attachment f51639d = null;

    /* renamed from: e, reason: collision with root package name */
    public Attachment f51640e = null;

    /* renamed from: f, reason: collision with root package name */
    public ReplayRecording f51641f = null;

    static {
        HashMap map = new HashMap();
        f51635g = map;
        map.put("boolean", Boolean.class);
        map.put("char", Character.class);
        map.put("byte", Byte.class);
        map.put("short", Short.class);
        map.put("int", Integer.class);
        map.put("long", Long.class);
        map.put("float", Float.class);
        map.put("double", Double.class);
    }

    public final synchronized void a() {
        try {
            Iterator it = this.f51636a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getKey() == null || !((String) entry.getKey()).startsWith("sentry:")) {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Object b(Class cls, String str) {
        Object obj = this.f51636a.get(str);
        if (cls.isInstance(obj)) {
            return obj;
        }
        Class cls2 = (Class) f51635g.get(cls.getCanonicalName());
        if (obj != null && cls.isPrimitive() && cls2 != null) {
            if (cls2.isInstance(obj)) {
                return obj;
            }
        }
        return null;
    }

    public final synchronized void c(Object obj, String str) {
        this.f51636a.put(str, obj);
    }
}
