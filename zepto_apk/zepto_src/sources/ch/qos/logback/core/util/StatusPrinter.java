package ch.qos.logback.core.util;

import android.support.v4.media.b;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.helpers.ThrowableToStringArray;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusUtil;
import java.io.PrintStream;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class StatusPrinter {

    /* renamed from: a, reason: collision with root package name */
    public static final PrintStream f13813a = System.out;

    /* renamed from: b, reason: collision with root package name */
    public static final CachingDateFormatter f13814b = new CachingDateFormatter("HH:mm:ss,SSS");

    public static void a(StringBuilder sb, String str, Status status) {
        String strK = status.e() ? b.k(str, "+ ") : b.k(str, "|-");
        CachingDateFormatter cachingDateFormatter = f13814b;
        if (cachingDateFormatter != null) {
            sb.append(cachingDateFormatter.a(status.b().longValue()));
            sb.append(StringUtils.SPACE);
        }
        sb.append(strK);
        sb.append(status);
        sb.append(CoreConstants.f13442a);
        if (status.c() != null) {
            for (String str2 : ThrowableToStringArray.a(status.c())) {
                if (!str2.startsWith("Caused by: ")) {
                    if (Character.isDigit(str2.charAt(0))) {
                        sb.append("\t... ");
                    } else {
                        sb.append("\tat ");
                    }
                }
                sb.append(str2);
                sb.append(CoreConstants.f13442a);
            }
        }
        if (status.e()) {
            Iterator it = status.iterator();
            while (it.hasNext()) {
                a(sb, str + "  ", (Status) it.next());
            }
        }
    }

    public static void b(LoggerContext loggerContext) {
        if (loggerContext == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        BasicStatusManager basicStatusManager = loggerContext.f13434c;
        PrintStream printStream = f13813a;
        if (basicStatusManager == null) {
            printStream.println("WARN: Context named \"" + loggerContext.f13433b + "\" has no status manager");
            return;
        }
        Iterator it = StatusUtil.a(0L, basicStatusManager.b()).iterator();
        int iA = 0;
        while (it.hasNext()) {
            Status status = (Status) it.next();
            if (status.a() > iA) {
                iA = status.a();
            }
        }
        if (iA >= 1) {
            StringBuilder sb = new StringBuilder();
            Iterator it2 = StatusUtil.a(0L, basicStatusManager.b()).iterator();
            while (it2.hasNext()) {
                a(sb, "", (Status) it2.next());
            }
            printStream.println(sb.toString());
        }
    }
}
