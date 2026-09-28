package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
final class ClassesInfoCache {

    /* renamed from: c, reason: collision with root package name */
    public static final ClassesInfoCache f4761c = new ClassesInfoCache();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f4762a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f4763b = new HashMap();

    @Deprecated
    public static class CallbackInfo {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f4764a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f4765b;

        public CallbackInfo(HashMap map) {
            this.f4765b = map;
            for (Map.Entry entry : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) entry.getValue();
                List arrayList = (List) this.f4764a.get(event);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f4764a.put(event, arrayList);
                }
                arrayList.add((MethodReference) entry.getKey());
            }
        }

        public static void a(List list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, LifecycleObserver lifecycleObserver) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    MethodReference methodReference = (MethodReference) list.get(size);
                    methodReference.getClass();
                    try {
                        int i2 = methodReference.f4766a;
                        Method method = methodReference.f4767b;
                        if (i2 == 0) {
                            method.invoke(lifecycleObserver, null);
                        } else if (i2 == 1) {
                            method.invoke(lifecycleObserver, lifecycleOwner);
                        } else if (i2 == 2) {
                            method.invoke(lifecycleObserver, lifecycleOwner, event);
                        }
                    } catch (IllegalAccessException e2) {
                        throw new RuntimeException(e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to call observer method", e3.getCause());
                    }
                }
            }
        }
    }

    @Deprecated
    public static final class MethodReference {

        /* renamed from: a, reason: collision with root package name */
        public final int f4766a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f4767b;

        public MethodReference(Method method, int i2) throws SecurityException {
            this.f4766a = i2;
            this.f4767b = method;
            method.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodReference)) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            return this.f4766a == methodReference.f4766a && this.f4767b.getName().equals(methodReference.f4767b.getName());
        }

        public final int hashCode() {
            return this.f4767b.getName().hashCode() + (this.f4766a * 31);
        }
    }

    public static void c(HashMap map, MethodReference methodReference, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = (Lifecycle.Event) map.get(methodReference);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(methodReference, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + methodReference.f4767b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    public final CallbackInfo a(Class cls, Method[] methodArr) throws SecurityException {
        int i2;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.f4762a;
        if (superclass != null) {
            CallbackInfo callbackInfoA = (CallbackInfo) map2.get(superclass);
            if (callbackInfoA == null) {
                callbackInfoA = a(superclass, null);
            }
            map.putAll(callbackInfoA.f4765b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            CallbackInfo callbackInfoA2 = (CallbackInfo) map2.get(cls2);
            if (callbackInfoA2 == null) {
                callbackInfoA2 = a(cls2, null);
            }
            for (Map.Entry entry : callbackInfoA2.f4765b.entrySet()) {
                c(map, (MethodReference) entry.getKey(), (Lifecycle.Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e2) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else {
                    if (!LifecycleOwner.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i2 = 1;
                }
                Lifecycle.Event eventValue = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (eventValue != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i2 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                c(map, new MethodReference(method, i2), eventValue, cls);
                z = true;
            }
        }
        CallbackInfo callbackInfo = new CallbackInfo(map);
        map2.put(cls, callbackInfo);
        this.f4763b.put(cls, Boolean.valueOf(z));
        return callbackInfo;
    }

    public final boolean b(Class cls) throws SecurityException {
        HashMap map = this.f4763b;
        Boolean bool = (Boolean) map.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (((OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class)) != null) {
                    a(cls, declaredMethods);
                    return true;
                }
            }
            map.put(cls, Boolean.FALSE);
            return false;
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }
}
