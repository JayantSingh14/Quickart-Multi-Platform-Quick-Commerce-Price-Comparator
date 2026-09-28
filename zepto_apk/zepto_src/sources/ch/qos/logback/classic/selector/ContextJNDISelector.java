package ch.qos.logback.classic.selector;

import android.support.v4.media.b;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.classic.util.JNDIUtil;
import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.status.InfoStatus;
import ch.qos.logback.core.status.WarnStatus;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.StatusPrinter;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.NamingException;

/* loaded from: classes3.dex */
public class ContextJNDISelector implements ContextSelector {

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadLocal f13334c = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final Map f13335a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b, reason: collision with root package name */
    public final LoggerContext f13336b;

    public ContextJNDISelector(LoggerContext loggerContext) {
        this.f13336b = loggerContext;
    }

    @Override // ch.qos.logback.classic.selector.ContextSelector
    public final LoggerContext a() throws IOException {
        Context contextA;
        URL urlB;
        LoggerContext loggerContext = (LoggerContext) f13334c.get();
        if (loggerContext != null) {
            return loggerContext;
        }
        String strB = null;
        try {
            contextA = JNDIUtil.a();
            try {
                strB = JNDIUtil.b(contextA, "java:comp/env/logback/context-name");
            } catch (NamingException unused) {
            }
        } catch (NamingException unused2) {
            contextA = null;
        }
        if (strB == null) {
            return this.f13336b;
        }
        Map map = this.f13335a;
        LoggerContext loggerContext2 = (LoggerContext) map.get(strB);
        if (loggerContext2 == null) {
            loggerContext2 = new LoggerContext();
            loggerContext2.a(strB);
            map.put(strB, loggerContext2);
            BasicStatusManager basicStatusManager = loggerContext2.f13434c;
            String strB2 = JNDIUtil.b(contextA, "java:comp/env/logback/configuration-resource");
            if (strB2 != null) {
                basicStatusManager.a(new InfoStatus(b.D("Searching for [", strB2, "]"), this));
                urlB = b(basicStatusManager, strB2);
                if (urlB == null) {
                    basicStatusManager.a(new WarnStatus(b.r(b.y("The jndi resource [", strB2, "] for context ["), loggerContext2.f13433b, "] does not lead to a valid file"), this));
                }
            } else {
                urlB = b(basicStatusManager, "logback-" + loggerContext2.f13433b + ".xml");
            }
            if (urlB != null) {
                try {
                    JoranConfigurator joranConfigurator = new JoranConfigurator();
                    loggerContext2.f();
                    joranConfigurator.V(loggerContext2);
                    joranConfigurator.Y1(urlB);
                } catch (JoranException unused3) {
                }
                StatusPrinter.b(loggerContext2);
            } else {
                try {
                    new ContextInitializer(loggerContext2).a();
                } catch (JoranException unused4) {
                }
            }
            BasicStatusManager basicStatusManager2 = loggerContext2.f13434c;
            if (basicStatusManager2 == null || basicStatusManager2.d().size() == 0) {
                StatusPrinter.b(loggerContext2);
            }
        }
        return loggerContext2;
    }

    public final URL b(BasicStatusManager basicStatusManager, String str) {
        URL resource;
        basicStatusManager.a(new InfoStatus(b.D("Searching for [", str, "]"), this));
        boolean z = Loader.f13812a;
        try {
            resource = Thread.currentThread().getContextClassLoader().getResource(str);
        } catch (Throwable unused) {
            resource = null;
        }
        return resource != null ? resource : Loader.b(str);
    }
}
