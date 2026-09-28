package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class Primitives {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f43322a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f43323b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(16);
        Class cls = Boolean.TYPE;
        linkedHashMap.put(cls, Boolean.class);
        linkedHashMap2.put(Boolean.class, cls);
        Class cls2 = Byte.TYPE;
        linkedHashMap.put(cls2, Byte.class);
        linkedHashMap2.put(Byte.class, cls2);
        Class cls3 = Character.TYPE;
        linkedHashMap.put(cls3, Character.class);
        linkedHashMap2.put(Character.class, cls3);
        Class cls4 = Double.TYPE;
        linkedHashMap.put(cls4, Double.class);
        linkedHashMap2.put(Double.class, cls4);
        Class cls5 = Float.TYPE;
        linkedHashMap.put(cls5, Float.class);
        linkedHashMap2.put(Float.class, cls5);
        Class cls6 = Integer.TYPE;
        linkedHashMap.put(cls6, Integer.class);
        linkedHashMap2.put(Integer.class, cls6);
        Class cls7 = Long.TYPE;
        linkedHashMap.put(cls7, Long.class);
        linkedHashMap2.put(Long.class, cls7);
        Class cls8 = Short.TYPE;
        linkedHashMap.put(cls8, Short.class);
        linkedHashMap2.put(Short.class, cls8);
        Class cls9 = Void.TYPE;
        linkedHashMap.put(cls9, Void.class);
        linkedHashMap2.put(Void.class, cls9);
        f43322a = Collections.unmodifiableMap(linkedHashMap);
        f43323b = Collections.unmodifiableMap(linkedHashMap2);
    }
}
