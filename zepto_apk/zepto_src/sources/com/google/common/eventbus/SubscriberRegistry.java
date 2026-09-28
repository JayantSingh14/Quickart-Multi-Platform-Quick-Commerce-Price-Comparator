package com.google.common.eventbus;

import com.google.common.base.Strings;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class SubscriberRegistry {

    /* renamed from: a, reason: collision with root package name */
    public static final LoadingCache f43179a;

    /* renamed from: b, reason: collision with root package name */
    public static final LoadingCache f43180b;

    /* renamed from: com.google.common.eventbus.SubscriberRegistry$1, reason: invalid class name */
    public class AnonymousClass1 extends CacheLoader<Class<?>, ImmutableList<Method>> {
        @Override // com.google.common.cache.CacheLoader
        public final Object a(Object obj) throws SecurityException {
            LoadingCache loadingCache = SubscriberRegistry.f43179a;
            Set setC = new TypeToken.TypeSet().C();
            HashMap map = new HashMap();
            Iterator it = setC.iterator();
            while (it.hasNext()) {
                for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                    if (method.isAnnotationPresent(Subscribe.class) && !method.isSynthetic()) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        boolean z = parameterTypes.length == 1;
                        int length = parameterTypes.length;
                        if (!z) {
                            throw new IllegalArgumentException(Strings.a("Method %s has @Subscribe annotation but has %s parameters. Subscriber methods must have exactly 1 parameter.", method, Integer.valueOf(length)));
                        }
                        boolean zIsPrimitive = parameterTypes[0].isPrimitive();
                        String name = parameterTypes[0].getName();
                        Class<?> cls = parameterTypes[0];
                        Map map2 = Primitives.f43322a;
                        cls.getClass();
                        Class<?> cls2 = (Class) Primitives.f43322a.get(cls);
                        if (cls2 != null) {
                            cls = cls2;
                        }
                        String simpleName = cls.getSimpleName();
                        if (zIsPrimitive) {
                            throw new IllegalArgumentException(Strings.a("@Subscribe method %s's parameter is %s. Subscriber methods cannot accept primitives. Consider changing the parameter to %s.", method, name, simpleName));
                        }
                        MethodIdentifier methodIdentifier = new MethodIdentifier(method);
                        if (!map.containsKey(methodIdentifier)) {
                            map.put(methodIdentifier, method);
                        }
                    }
                }
            }
            return ImmutableList.o(map.values());
        }
    }

    /* renamed from: com.google.common.eventbus.SubscriberRegistry$2, reason: invalid class name */
    public class AnonymousClass2 extends CacheLoader<Class<?>, ImmutableSet<Class<?>>> {
        @Override // com.google.common.cache.CacheLoader
        public final Object a(Object obj) {
            return ImmutableSet.o(new TypeToken.TypeSet().C());
        }
    }

    public static final class MethodIdentifier {

        /* renamed from: a, reason: collision with root package name */
        public final String f43181a;

        /* renamed from: b, reason: collision with root package name */
        public final List f43182b;

        public MethodIdentifier(Method method) {
            this.f43181a = method.getName();
            this.f43182b = Arrays.asList(method.getParameterTypes());
        }

        public final boolean equals(Object obj) {
            if (obj instanceof MethodIdentifier) {
                MethodIdentifier methodIdentifier = (MethodIdentifier) obj;
                if (this.f43181a.equals(methodIdentifier.f43181a) && this.f43182b.equals(methodIdentifier.f43182b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f43181a, this.f43182b});
        }
    }

    static {
        CacheBuilder cacheBuilderB = CacheBuilder.b();
        cacheBuilderB.c();
        f43179a = cacheBuilderB.a(new AnonymousClass1());
        CacheBuilder cacheBuilderB2 = CacheBuilder.b();
        cacheBuilderB2.c();
        f43180b = cacheBuilderB2.a(new AnonymousClass2());
    }
}
