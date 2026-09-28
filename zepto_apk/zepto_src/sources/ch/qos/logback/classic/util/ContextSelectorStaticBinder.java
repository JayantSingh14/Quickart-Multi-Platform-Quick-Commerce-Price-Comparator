package ch.qos.logback.classic.util;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.selector.ContextJNDISelector;
import ch.qos.logback.classic.selector.ContextSelector;
import ch.qos.logback.classic.selector.DefaultContextSelector;
import ch.qos.logback.core.util.Loader;

/* loaded from: classes.dex */
public class ContextSelectorStaticBinder {

    /* renamed from: c, reason: collision with root package name */
    public static final ContextSelectorStaticBinder f13410c = new ContextSelectorStaticBinder();

    /* renamed from: a, reason: collision with root package name */
    public ContextSelector f13411a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13412b;

    public final void a(LoggerContext loggerContext, Object obj) throws IllegalAccessException, ClassNotFoundException {
        String property;
        Class<?> cls;
        Object obj2 = this.f13412b;
        if (obj2 == null) {
            this.f13412b = obj;
        } else if (obj2 != obj) {
            throw new IllegalAccessException("Only certain classes can access this method.");
        }
        try {
            property = System.getProperty("logback.ContextSelector");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            DefaultContextSelector defaultContextSelector = new DefaultContextSelector();
            defaultContextSelector.f13337a = loggerContext;
            this.f13411a = defaultContextSelector;
        } else {
            if (property.equals("JNDI")) {
                this.f13411a = new ContextJNDISelector(loggerContext);
                return;
            }
            if (Loader.f13812a) {
                cls = Class.forName(property);
            } else {
                try {
                    cls = Thread.currentThread().getContextClassLoader().loadClass(property);
                } catch (Throwable unused2) {
                    cls = Class.forName(property);
                }
            }
            this.f13411a = (ContextSelector) cls.getConstructor(LoggerContext.class).newInstance(loggerContext);
        }
    }
}
