package org.shadow.apache.commons.lang3;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import org.shadow.apache.commons.lang3.mutable.MutableObject;

/* loaded from: classes5.dex */
public class ClassUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f57702a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f57703b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map f57704c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map f57705d;

    /* renamed from: org.shadow.apache.commons.lang3.ClassUtils$1, reason: invalid class name */
    final class AnonymousClass1 implements Iterable<Class<?>> {
        @Override // java.lang.Iterable
        public final Iterator<Class<?>> iterator() {
            final MutableObject mutableObject = new MutableObject();
            mutableObject.f57761a = null;
            return new Iterator<Class<?>>() { // from class: org.shadow.apache.commons.lang3.ClassUtils.1.1
                @Override // java.util.Iterator
                public final boolean hasNext() {
                    return mutableObject.f57761a != null;
                }

                @Override // java.util.Iterator
                public final Class<?> next() {
                    MutableObject mutableObject2 = mutableObject;
                    Class<?> cls = mutableObject2.f57761a;
                    mutableObject2.f57761a = cls.getSuperclass();
                    return cls;
                }

                @Override // java.util.Iterator
                public final void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    /* renamed from: org.shadow.apache.commons.lang3.ClassUtils$2, reason: invalid class name */
    final class AnonymousClass2 implements Iterable<Class<?>> {

        /* renamed from: org.shadow.apache.commons.lang3.ClassUtils$2$1, reason: invalid class name */
        class AnonymousClass1 implements Iterator<Class<?>> {
            @Override // java.util.Iterator
            public final boolean hasNext() {
                throw null;
            }

            @Override // java.util.Iterator
            public final Class<?> next() {
                throw null;
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<Class<?>> iterator() {
            new HashSet();
            throw null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Interfaces {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Interfaces[] f57707a = {new Interfaces("INCLUDE", 0), new Interfaces("EXCLUDE", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        Interfaces EF5;

        public static Interfaces valueOf(String str) {
            return (Interfaces) Enum.valueOf(Interfaces.class, str);
        }

        public static Interfaces[] values() {
            return (Interfaces[]) f57707a.clone();
        }
    }

    static {
        String.valueOf(org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR);
        String.valueOf('$');
        HashMap map = new HashMap();
        f57702a = map;
        map.put(Boolean.TYPE, Boolean.class);
        map.put(Byte.TYPE, Byte.class);
        map.put(Character.TYPE, Character.class);
        map.put(Short.TYPE, Short.class);
        map.put(Integer.TYPE, Integer.class);
        map.put(Long.TYPE, Long.class);
        map.put(Double.TYPE, Double.class);
        map.put(Float.TYPE, Float.class);
        Class cls = Void.TYPE;
        map.put(cls, cls);
        f57703b = new HashMap();
        for (Class cls2 : map.keySet()) {
            Class cls3 = (Class) f57702a.get(cls2);
            if (!cls2.equals(cls3)) {
                f57703b.put(cls3, cls2);
            }
        }
        HashMap map2 = new HashMap();
        map2.put("int", "I");
        map2.put("boolean", "Z");
        map2.put("float", "F");
        map2.put("long", "J");
        map2.put("short", "S");
        map2.put("byte", "B");
        map2.put("double", "D");
        map2.put("char", "C");
        map2.put("void", "V");
        HashMap map3 = new HashMap();
        for (Map.Entry entry : map2.entrySet()) {
            map3.put(entry.getValue(), entry.getKey());
        }
        f57704c = Collections.unmodifiableMap(map2);
        f57705d = Collections.unmodifiableMap(map3);
    }

    public static void a(Class cls, LinkedHashSet linkedHashSet) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (linkedHashSet.add(cls2)) {
                    a(cls2, linkedHashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }
}
