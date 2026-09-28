package com.facebook.hermes.intl;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class JSObjects {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f17604a = new UndefinedObject();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f17605b = new NullObject();

    public static class NullObject {
    }

    public static class UndefinedObject {
    }

    public static Object a(String str, Map map) {
        HashMap map2 = (HashMap) map;
        if (!map2.containsKey(str)) {
            return f17604a;
        }
        Object obj = map2.get(str);
        return obj == null ? f17605b : obj;
    }
}
