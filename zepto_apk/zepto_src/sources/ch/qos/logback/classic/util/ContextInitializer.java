package ch.qos.logback.classic.util;

import android.support.v4.media.b;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.InfoStatus;
import ch.qos.logback.core.status.WarnStatus;
import ch.qos.logback.core.util.Loader;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;

/* loaded from: classes.dex */
public class ContextInitializer {

    /* renamed from: a, reason: collision with root package name */
    public final LoggerContext f13409a;

    public ContextInitializer(LoggerContext loggerContext) {
        this.f13409a = loggerContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.classic.util.ContextInitializer.a():void");
    }

    public final void b(String str, ClassLoader classLoader, URL url) throws IOException {
        HashSet<URL> hashSet;
        LoggerContext loggerContext = this.f13409a;
        BasicStatusManager basicStatusManager = loggerContext.f13434c;
        if (url == null) {
            basicStatusManager.a(new InfoStatus(b.D("Could NOT find resource [", str, "]"), loggerContext));
            return;
        }
        StringBuilder sbY = b.y("Found resource [", str, "] at [");
        sbY.append(url.toString());
        sbY.append("]");
        basicStatusManager.a(new InfoStatus(sbY.toString(), loggerContext));
        BasicStatusManager basicStatusManager2 = loggerContext.f13434c;
        try {
            boolean z = Loader.f13812a;
            hashSet = new HashSet();
            Enumeration<URL> resources = classLoader.getResources(str);
            while (resources.hasMoreElements()) {
                hashSet.add(resources.nextElement());
            }
        } catch (IOException e2) {
            basicStatusManager2.a(new ErrorStatus(b.D("Failed to get url list for resource [", str, "]"), loggerContext, e2));
            hashSet = null;
        }
        if (hashSet == null || hashSet.size() <= 1) {
            return;
        }
        basicStatusManager2.a(new WarnStatus(b.D("Resource [", str, "] occurs multiple times on the classpath."), loggerContext));
        for (URL url2 : hashSet) {
            StringBuilder sbY2 = b.y("Resource [", str, "] occurs at [");
            sbY2.append(url2.toString());
            sbY2.append("]");
            basicStatusManager2.a(new WarnStatus(sbY2.toString(), loggerContext));
        }
    }
}
