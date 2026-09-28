package kotlin.jvm.internal;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
public class Reflection {

    /* renamed from: a, reason: collision with root package name */
    public static final ReflectionFactory f53802a;

    /* renamed from: b, reason: collision with root package name */
    public static final KClass[] f53803b;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        f53802a = reflectionFactory;
        f53803b = new KClass[0];
    }

    public static ClassReference a(Class cls) {
        f53802a.getClass();
        return new ClassReference(cls);
    }

    public static TypeReference b(Class cls) {
        ClassReference classReferenceA = a(cls);
        List list = Collections.EMPTY_LIST;
        f53802a.getClass();
        return new TypeReference(classReferenceA, true);
    }

    public static TypeReference c(Class cls) {
        ClassReference classReferenceA = a(cls);
        List list = Collections.EMPTY_LIST;
        f53802a.getClass();
        return new TypeReference(classReferenceA, false);
    }
}
