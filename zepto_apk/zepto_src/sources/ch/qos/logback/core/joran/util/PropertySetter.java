package ch.qos.logback.core.joran.util;

import android.support.v4.media.b;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.spi.DefaultClass;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.joran.spi.HostClassAndPropertyDouble;
import ch.qos.logback.core.joran.util.beans.BeanDescription;
import ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
import ch.qos.logback.core.joran.util.beans.BeanDescriptionFactory;
import ch.qos.logback.core.joran.util.beans.BeanUtil;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.util.AggregationType;
import ch.qos.logback.core.util.PropertySetterException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class PropertySetter extends ContextAwareBase {

    /* renamed from: d, reason: collision with root package name */
    public final Object f13580d;

    /* renamed from: e, reason: collision with root package name */
    public final Class f13581e;

    /* renamed from: f, reason: collision with root package name */
    public final BeanDescription f13582f;

    /* renamed from: ch.qos.logback.core.joran.util.PropertySetter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13583a;

        static {
            int[] iArr = new int[AggregationType.values().length];
            f13583a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13583a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13583a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13583a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13583a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public PropertySetter(BeanDescriptionCache beanDescriptionCache, Object obj) throws SecurityException {
        Class<?> returnType;
        Method[] methodArr;
        this.f13580d = obj;
        Class<?> cls = obj.getClass();
        this.f13581e = cls;
        HashMap map = beanDescriptionCache.f13588d;
        if (!map.containsKey(cls)) {
            if (beanDescriptionCache.f13589e == null) {
                Context context = beanDescriptionCache.f13733b;
                BeanDescriptionFactory beanDescriptionFactory = new BeanDescriptionFactory();
                beanDescriptionFactory.V(context);
                beanDescriptionCache.f13589e = beanDescriptionFactory;
            }
            BeanDescriptionFactory beanDescriptionFactory2 = beanDescriptionCache.f13589e;
            beanDescriptionFactory2.getClass();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            HashMap map4 = new HashMap();
            Method[] methods = cls.getMethods();
            int length = methods.length;
            int i2 = 0;
            while (i2 < length) {
                Method method = methods[i2];
                if (method.isBridge()) {
                    methodArr = methods;
                } else {
                    int length2 = method.getParameterTypes().length;
                    Class<?> cls2 = Void.TYPE;
                    if (length2 <= 0 && (returnType = method.getReturnType()) != cls2) {
                        String name = method.getName();
                        methodArr = methods;
                        if ((name.startsWith("get") || name.startsWith("is")) && (!name.startsWith("is") || returnType.equals(Boolean.TYPE) || returnType.equals(Boolean.class))) {
                            String strA = BeanUtil.a(method);
                            Method method2 = (Method) map2.put(strA, method);
                            if (method2 != null) {
                                if (method2.getName().startsWith("is")) {
                                    map2.put(strA, method2);
                                }
                                beanDescriptionFactory2.J1(b.m("Class '", cls.getCanonicalName(), "' contains multiple getters for the same property '", strA, "'."));
                            }
                        }
                    } else {
                        methodArr = methods;
                    }
                    if (method.getParameterTypes().length == 1 && method.getReturnType() == cls2 && method.getName().startsWith("set")) {
                        String strA2 = BeanUtil.a(method);
                        if (((Method) map3.put(strA2, method)) != null) {
                            beanDescriptionFactory2.J1(b.m("Class '", cls.getCanonicalName(), "' contains multiple setters for the same property '", strA2, "'."));
                        }
                    } else {
                        if ((method.getParameterTypes().length == 1 && method.getReturnType() == cls2) ? method.getName().startsWith("add") : false) {
                            String strA3 = BeanUtil.a(method);
                            if (((Method) map4.put(strA3, method)) != null) {
                                beanDescriptionFactory2.J1(b.m("Class '", cls.getCanonicalName(), "' contains multiple adders for the same property '", strA3, "'."));
                            }
                        }
                    }
                }
                i2++;
                methods = methodArr;
            }
            map.put(cls, new BeanDescription(map2, map3, map4));
        }
        this.f13582f = (BeanDescription) map.get(cls);
    }

    public static AggregationType U1(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> cls = parameterTypes.length != 1 ? null : parameterTypes[0];
        if (cls == null) {
            return AggregationType.f13790a;
        }
        Package r0 = cls.getPackage();
        return (cls.isPrimitive() || (r0 != null && "java.lang".equals(r0.getName())) || StringToObjectConverter.b(cls) || cls.isEnum() || Charset.class.isAssignableFrom(cls)) ? AggregationType.f13791b : AggregationType.f13792c;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ch.qos.logback.core.util.AggregationType T1(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = 1
            java.lang.String r1 = r5.substring(r1, r2)
            java.lang.String r1 = r1.toUpperCase()
            r0.append(r1)
            java.lang.String r1 = r5.substring(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.reflect.Method r0 = r4.V1(r0)
            ch.qos.logback.core.util.AggregationType r1 = ch.qos.logback.core.util.AggregationType.f13790a
            if (r0 == 0) goto L53
            ch.qos.logback.core.util.AggregationType r0 = U1(r0)
            int r3 = r0.ordinal()
            if (r3 == 0) goto L5e
            if (r3 == r2) goto L50
            r2 = 2
            if (r3 == r2) goto L4d
            r2 = 3
            if (r3 == r2) goto L3b
            r2 = 4
            if (r3 == r2) goto L3b
            goto L53
        L3b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected AggregationType "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r4.l1(r0)
            goto L53
        L4d:
            ch.qos.logback.core.util.AggregationType r5 = ch.qos.logback.core.util.AggregationType.f13794e
            return r5
        L50:
            ch.qos.logback.core.util.AggregationType r5 = ch.qos.logback.core.util.AggregationType.f13793d
            return r5
        L53:
            java.lang.reflect.Method r5 = r4.W1(r5)
            if (r5 == 0) goto L5e
            ch.qos.logback.core.util.AggregationType r5 = U1(r5)
            return r5
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.joran.util.PropertySetter.T1(java.lang.String):ch.qos.logback.core.util.AggregationType");
    }

    public final Method V1(String str) {
        return (Method) this.f13582f.f13587c.get(BeanUtil.c(str));
    }

    public final Method W1(String str) {
        return (Method) this.f13582f.f13586b.get(BeanUtil.c(str));
    }

    public final Class X1(String str, AggregationType aggregationType, DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        Class cls;
        Method methodW1;
        Class<?> superclass = this.f13580d.getClass();
        defaultNestedComponentRegistry.getClass();
        String lowerCase = str.toLowerCase();
        while (true) {
            if (superclass == null) {
                cls = null;
                break;
            }
            cls = (Class) defaultNestedComponentRegistry.f13555a.get(new HostClassAndPropertyDouble(superclass, lowerCase));
            if (cls != null) {
                break;
            }
            superclass = superclass.getSuperclass();
        }
        if (cls != null) {
            return cls;
        }
        if (aggregationType == AggregationType.f13794e) {
            methodW1 = V1(str);
        } else {
            if (aggregationType != AggregationType.f13792c) {
                throw new IllegalStateException(aggregationType + " not allowed here");
            }
            methodW1 = W1(str);
        }
        if (methodW1 != null) {
            DefaultClass defaultClass = (DefaultClass) methodW1.getAnnotation(DefaultClass.class);
            Class clsValue = defaultClass != null ? defaultClass.value() : null;
            if (clsValue != null) {
                return clsValue;
            }
            Class<?>[] parameterTypes = methodW1.getParameterTypes();
            Class<?> cls2 = parameterTypes.length != 1 ? null : parameterTypes[0];
            if (cls2 != null && !cls2.isInterface()) {
                try {
                    if (cls2.newInstance() != null) {
                        return cls2;
                    }
                } catch (IllegalAccessException | InstantiationException unused) {
                }
            }
        }
        return null;
    }

    public final void Y1(Method method, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj2 = this.f13580d;
        Class<?> cls = obj.getClass();
        try {
            method.invoke(obj2, obj);
        } catch (Exception e2) {
            o1("Could not invoke method " + method.getName() + " in class " + obj2.getClass().getName() + " with parameter of type " + cls.getName(), e2);
        }
    }

    public final boolean Z1(String str, Class[] clsArr, Object obj) {
        Class<?> cls = obj.getClass();
        if (clsArr.length != 1) {
            StringBuilder sbY = b.y("Wrong number of parameters in setter method for property [", str, "] in ");
            sbY.append(this.f13580d.getClass().getName());
            l1(sbY.toString());
            return false;
        }
        if (clsArr[0].isAssignableFrom(obj.getClass())) {
            return true;
        }
        l1("A \"" + cls.getName() + "\" object is not assignable to a \"" + clsArr[0].getName() + "\" variable.");
        StringBuilder sb = new StringBuilder("The class \"");
        sb.append(clsArr[0].getName());
        sb.append("\" was loaded by ");
        l1(sb.toString());
        l1("[" + clsArr[0].getClassLoader() + "] whereas object of type ");
        l1("\"" + cls.getName() + "\" was loaded by [" + cls.getClassLoader() + "].");
        return false;
    }

    public final void a2(Object obj, String str) {
        Method methodW1 = W1(str);
        Object obj2 = this.f13580d;
        if (methodW1 == null) {
            StringBuilder sbY = b.y("Not setter method for property [", str, "] in ");
            sbY.append(obj2.getClass().getName());
            J1(sbY.toString());
        } else if (Z1(str, methodW1.getParameterTypes(), obj)) {
            try {
                Y1(methodW1, obj);
            } catch (Exception e2) {
                o1("Could not set component " + obj2 + " for parent component " + obj2, e2);
            }
        }
    }

    public final void b2(String str, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (str2 == null) {
            return;
        }
        Method methodW1 = W1(str);
        if (methodW1 == null) {
            StringBuilder sbY = b.y("No setter for property [", str, "] in ");
            sbY.append(this.f13581e.getName());
            sbY.append(CLConstants.DOT_SALT_DELIMETER);
            J1(sbY.toString());
            return;
        }
        try {
            c2(methodW1, str2);
        } catch (PropertySetterException e2) {
            O1(b.m("Failed to set property [", str, "] to value \"", str2, "\". "), e2);
        }
    }

    public final void c2(Method method, String str) throws IllegalAccessException, PropertySetterException, IllegalArgumentException, InvocationTargetException {
        Class<?>[] parameterTypes = method.getParameterTypes();
        try {
            Object objA = StringToObjectConverter.a(this, str, parameterTypes[0]);
            if (objA != null) {
                try {
                    method.invoke(this.f13580d, objA);
                } catch (Exception e2) {
                    throw new PropertySetterException(e2);
                }
            } else {
                throw new PropertySetterException("Conversion to type [" + parameterTypes[0] + "] failed.");
            }
        } catch (Throwable th) {
            throw new PropertySetterException("Conversion to type [" + parameterTypes[0] + "] failed. ", th);
        }
    }
}
