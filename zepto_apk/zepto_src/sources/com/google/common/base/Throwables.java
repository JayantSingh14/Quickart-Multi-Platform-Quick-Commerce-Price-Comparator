package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Throwables {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f42322a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f42323b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f42324c;

    /* renamed from: com.google.common.base.Throwables$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractList<StackTraceElement> {
        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            Method method = Throwables.f42323b;
            java.util.Objects.requireNonNull(method);
            Object obj = Throwables.f42322a;
            java.util.Objects.requireNonNull(obj);
            try {
                return (StackTraceElement) method.invoke(obj, null, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                Throwable cause = e3.getCause();
                Throwables.a(cause);
                throw new RuntimeException(cause);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            Method method = Throwables.f42324c;
            java.util.Objects.requireNonNull(method);
            Object obj = Throwables.f42322a;
            java.util.Objects.requireNonNull(obj);
            try {
                return ((Integer) method.invoke(obj, null)).intValue();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                Throwable cause = e3.getCause();
                Throwables.a(cause);
                throw new RuntimeException(cause);
            }
        }
    }

    static {
        Object objInvoke;
        Method method;
        Method method2;
        Method method3 = null;
        try {
            objInvoke = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", null).invoke(null, null);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            objInvoke = null;
        }
        f42322a = objInvoke;
        if (objInvoke == null) {
            method = null;
        } else {
            try {
                method = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod("getStackTraceElement", Throwable.class, Integer.TYPE);
            } catch (ThreadDeath e3) {
                throw e3;
            } catch (Throwable unused2) {
            }
        }
        f42323b = method;
        if (objInvoke != null) {
            try {
                try {
                    method2 = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod("getStackTraceDepth", Throwable.class);
                } catch (ThreadDeath e4) {
                    throw e4;
                } catch (Throwable unused3) {
                    method2 = null;
                }
                if (method2 != null) {
                    method2.invoke(objInvoke, new Throwable());
                    method3 = method2;
                }
            } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused4) {
            }
        }
        f42324c = method3;
    }

    public static void a(Throwable th) {
        th.getClass();
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
