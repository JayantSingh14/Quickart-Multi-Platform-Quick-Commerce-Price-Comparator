package org.slf4j;

import ch.qos.logback.classic.selector.ContextSelector;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;

/* loaded from: classes.dex */
public final class LoggerFactory {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f57870a;

    /* renamed from: b, reason: collision with root package name */
    public static final SubstituteLoggerFactory f57871b = new SubstituteLoggerFactory();

    /* renamed from: c, reason: collision with root package name */
    public static final NOPLoggerFactory f57872c = new NOPLoggerFactory();

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f57873d;

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f57874e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f57875f;

    static {
        String property;
        try {
            property = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            property = null;
        }
        f57873d = property == null ? false : property.equalsIgnoreCase("true");
        f57874e = new String[]{"1.6", "1.7"};
        f57875f = "org/slf4j/impl/StaticLoggerBinder.class";
    }

    public static LinkedHashSet a() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = LoggerFactory.class.getClassLoader();
            String str = f57875f;
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(str) : classLoader.getResources(str);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e2) {
            Util.c("Error getting resources from path", e2);
        }
        return linkedHashSet;
    }

    public static Logger b(Class cls) {
        Class clsA;
        Logger loggerC = c(cls.getName());
        if (f57873d && (clsA = Util.a()) != null && !clsA.isAssignableFrom(cls)) {
            Util.b("Detected logger name mismatch. Given name: \"" + loggerC.getName() + "\"; computed name: \"" + clsA.getName() + "\".");
            Util.b("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return loggerC;
    }

    public static Logger c(String str) {
        ILoggerFactory iLoggerFactoryA;
        if (f57870a == 0) {
            synchronized (LoggerFactory.class) {
                try {
                    if (f57870a == 0) {
                        f57870a = 1;
                        e();
                    }
                } finally {
                }
            }
        }
        int i2 = f57870a;
        if (i2 == 1) {
            iLoggerFactoryA = f57871b;
        } else {
            if (i2 == 2) {
                throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            }
            if (i2 == 3) {
                StaticLoggerBinder staticLoggerBinder = StaticLoggerBinder.f57904d;
                if (staticLoggerBinder.f57906a) {
                    ContextSelector contextSelector = staticLoggerBinder.f57908c.f13411a;
                    if (contextSelector == null) {
                        throw new IllegalStateException("contextSelector cannot be null. See also http://logback.qos.ch/codes.html#null_CS");
                    }
                    iLoggerFactoryA = contextSelector.a();
                } else {
                    iLoggerFactoryA = staticLoggerBinder.f57907b;
                }
            } else {
                if (i2 != 4) {
                    throw new IllegalStateException("Unreachable code");
                }
                iLoggerFactoryA = f57872c;
            }
        }
        return iLoggerFactoryA.c(str);
    }

    public static boolean d() {
        String property;
        try {
            property = System.getProperty("java.vendor.url");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return false;
        }
        return property.toLowerCase().contains(LogSubCategory.LifeCycle.ANDROID);
    }

    public static final void e() {
        LinkedHashSet linkedHashSetA;
        try {
            try {
                if (d()) {
                    linkedHashSetA = null;
                } else {
                    linkedHashSetA = a();
                    h(linkedHashSetA);
                }
                StaticLoggerBinder staticLoggerBinder = StaticLoggerBinder.f57904d;
                f57870a = 3;
                g(linkedHashSetA);
            } finally {
                f();
            }
        } catch (Exception e2) {
            f57870a = 2;
            Util.c("Failed to instantiate SLF4J LoggerFactory", e2);
            throw new IllegalStateException("Unexpected initialization failure", e2);
        } catch (NoClassDefFoundError e3) {
            String message = e3.getMessage();
            if (message == null || (!message.contains("org/slf4j/impl/StaticLoggerBinder") && !message.contains("org.slf4j.impl.StaticLoggerBinder"))) {
                f57870a = 2;
                Util.c("Failed to instantiate SLF4J LoggerFactory", e3);
                throw e3;
            }
            f57870a = 4;
            Util.b("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
            Util.b("Defaulting to no-operation (NOP) logger implementation");
            Util.b("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        } catch (NoSuchMethodError e4) {
            String message2 = e4.getMessage();
            if (message2 != null && message2.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f57870a = 2;
                Util.b("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                Util.b("Your binding is version 1.5.5 or earlier.");
                Util.b("Upgrade your binding to version 1.6.x.");
            }
            throw e4;
        }
        if (f57870a == 3) {
            String[] strArr = f57874e;
            try {
                StaticLoggerBinder staticLoggerBinder2 = StaticLoggerBinder.f57904d;
                boolean z = false;
                for (String str : strArr) {
                    if ("1.7.16".startsWith(str)) {
                        z = true;
                    }
                }
                if (z) {
                    return;
                }
                Util.b("The requested version 1.7.16 by your slf4j binding is not compatible with " + Arrays.asList(strArr).toString());
                Util.b("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            } catch (NoSuchFieldError unused) {
            } catch (Throwable th) {
                Util.c("Unexpected problem occured during version sanity check", th);
            }
        }
    }

    public static void f() {
        SubstituteLoggerFactory substituteLoggerFactory = f57871b;
        synchronized (substituteLoggerFactory) {
            try {
                substituteLoggerFactory.f57899a = true;
                Iterator it = new ArrayList(substituteLoggerFactory.f57900b.values()).iterator();
                while (it.hasNext()) {
                    SubstituteLogger substituteLogger = (SubstituteLogger) it.next();
                    substituteLogger.A(c(substituteLogger.getName()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = f57871b.f57901c;
        int size = linkedBlockingQueue.size();
        ArrayList arrayList = new ArrayList(128);
        int i2 = 0;
        while (linkedBlockingQueue.drainTo(arrayList, 128) != 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SubstituteLoggingEvent substituteLoggingEvent = (SubstituteLoggingEvent) it2.next();
                if (substituteLoggingEvent != null) {
                    SubstituteLogger substituteLoggerA = substituteLoggingEvent.a();
                    String name = substituteLoggerA.getName();
                    if (substituteLoggerA.y()) {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    }
                    if (!substituteLoggerA.x()) {
                        if (substituteLoggerA.w()) {
                            substituteLoggerA.z(substituteLoggingEvent);
                        } else {
                            Util.b(name);
                        }
                    }
                }
                int i3 = i2 + 1;
                if (i2 == 0) {
                    if (substituteLoggingEvent.a().w()) {
                        Util.b("A number (" + size + ") of logging calls during the initialization phase have been intercepted and are");
                        Util.b("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        Util.b("See also http://www.slf4j.org/codes.html#replay");
                    } else if (!substituteLoggingEvent.a().x()) {
                        Util.b("The following set of substitute loggers may have been accessed");
                        Util.b("during the initialization phase. Logging calls during this");
                        Util.b("phase were not honored. However, subsequent logging calls to these");
                        Util.b("loggers will work as normally expected.");
                        Util.b("See also http://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i2 = i3;
            }
            arrayList.clear();
        }
        SubstituteLoggerFactory substituteLoggerFactory2 = f57871b;
        substituteLoggerFactory2.f57900b.clear();
        substituteLoggerFactory2.f57901c.clear();
    }

    public static void g(LinkedHashSet linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.size() <= 1) {
            return;
        }
        Util.b("Actual binding is of type [" + StaticLoggerBinder.f57904d.f57908c.getClass().getName() + "]");
    }

    public static void h(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.size() > 1) {
            Util.b("Class path contains multiple SLF4J bindings.");
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                Util.b("Found binding in [" + ((URL) it.next()) + "]");
            }
            Util.b("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
