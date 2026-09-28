package ch.qos.logback.classic.util;

import ch.qos.logback.core.util.Loader;

/* loaded from: classes.dex */
public class EnvUtil {
    public static boolean a() {
        boolean z = Loader.f13812a;
        ClassLoader classLoader = EnvUtil.class.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return classLoader.loadClass("groovy.lang.Binding") != null;
    }
}
