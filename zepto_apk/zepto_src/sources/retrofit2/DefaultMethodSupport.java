package retrofit2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
final class DefaultMethodSupport {

    /* renamed from: a, reason: collision with root package name */
    public static Constructor f58094a;

    public static Object a(Method method, Class cls, Object obj, Object[] objArr) throws NoSuchMethodException, SecurityException {
        Constructor declaredConstructor = f58094a;
        if (declaredConstructor == null) {
            declaredConstructor = org.xbill.DNS.config.b.c().getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            f58094a = declaredConstructor;
        }
        return org.xbill.DNS.config.b.h(declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }
}
