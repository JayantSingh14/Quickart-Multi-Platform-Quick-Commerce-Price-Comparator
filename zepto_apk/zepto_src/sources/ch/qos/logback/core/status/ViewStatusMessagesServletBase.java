package ch.qos.logback.core.status;

import ch.qos.logback.core.util.CachingDateFormatter;
import javax.servlet.http.HttpServlet;

/* loaded from: classes3.dex */
public abstract class ViewStatusMessagesServletBase extends HttpServlet {
    static {
        new CachingDateFormatter("yyyy-MM-dd HH:mm:ss");
    }
}
