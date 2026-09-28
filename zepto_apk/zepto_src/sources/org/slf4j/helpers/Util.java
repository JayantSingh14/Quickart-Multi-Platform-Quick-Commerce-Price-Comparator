package org.slf4j.helpers;

/* loaded from: classes.dex */
public final class Util {

    /* renamed from: a, reason: collision with root package name */
    public static ClassContextSecurityManager f57902a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f57903b = false;

    /* loaded from: classes5.dex */
    public static final class ClassContextSecurityManager extends SecurityManager {
        @Override // java.lang.SecurityManager
        public final Class[] getClassContext() {
            return super.getClassContext();
        }
    }

    public static Class a() {
        int i2;
        ClassContextSecurityManager classContextSecurityManager = f57902a;
        if (classContextSecurityManager == null) {
            if (f57903b) {
                classContextSecurityManager = null;
            } else {
                try {
                    classContextSecurityManager = new ClassContextSecurityManager();
                } catch (SecurityException unused) {
                    classContextSecurityManager = null;
                }
                f57902a = classContextSecurityManager;
                f57903b = true;
            }
        }
        if (classContextSecurityManager == null) {
            return null;
        }
        Class[] classContext = classContextSecurityManager.getClassContext();
        String name = Util.class.getName();
        int i3 = 0;
        while (i3 < classContext.length && !name.equals(classContext[i3].getName())) {
            i3++;
        }
        if (i3 >= classContext.length || (i2 = i3 + 2) >= classContext.length) {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        }
        return classContext[i2];
    }

    public static final void b(String str) {
        System.err.println("SLF4J: " + str);
    }

    public static final void c(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }
}
