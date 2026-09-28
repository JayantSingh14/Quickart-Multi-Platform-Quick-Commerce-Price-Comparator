package ch.qos.logback.classic.html;

import android.support.v4.media.a;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.pattern.MDCConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.helpers.Transform;
import ch.qos.logback.core.html.HTMLLayoutBase;
import ch.qos.logback.core.pattern.Converter;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class HTMLLayout extends HTMLLayoutBase<ILoggingEvent> {

    /* renamed from: j, reason: collision with root package name */
    public final DefaultThrowableRenderer f13275j;

    public HTMLLayout() {
        this.f13488e = "%date%thread%level%logger%mdc%msg";
        this.f13275j = new DefaultThrowableRenderer();
        this.f13491h = new DefaultCssBuilder();
    }

    @Override // ch.qos.logback.core.html.HTMLLayoutBase
    public final String U1(Converter converter) {
        if (!(converter instanceof MDCConverter)) {
            return super.U1(converter);
        }
        String strF = ((MDCConverter) converter).f();
        return strF != null ? strF : "MDC";
    }

    @Override // ch.qos.logback.core.html.HTMLLayoutBase
    public final HashMap V1() {
        return PatternLayout.f13253i;
    }

    @Override // ch.qos.logback.core.Layout
    public final String c1(Object obj) {
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        StringBuilder sb = new StringBuilder();
        if (this.f13492i >= 10000) {
            this.f13492i = 0L;
            sb.append("</table>");
            String str = CoreConstants.f13442a;
            a.u(sb, str, "<p></p><table cellspacing=\"0\">", str);
            T1(sb);
        }
        long j2 = this.f13492i;
        this.f13492i = j2 + 1;
        boolean z = (j2 & 1) != 0;
        String lowerCase = iLoggingEvent.a().f13241b.toLowerCase();
        String str2 = CoreConstants.f13442a;
        a.u(sb, str2, "<tr class=\"", lowerCase);
        if (z) {
            sb.append(" odd\">");
        } else {
            sb.append(" even\">");
        }
        sb.append(str2);
        for (Converter converter = this.f13489f; converter != null; converter = converter.f13648a) {
            sb.append("<td class=\"");
            sb.append(U1(converter));
            sb.append("\">");
            sb.append(Transform.a(converter.b(iLoggingEvent)));
            sb.append("</td>");
            sb.append(CoreConstants.f13442a);
        }
        sb.append("</tr>");
        sb.append(CoreConstants.f13442a);
        if (iLoggingEvent.l() != null) {
            this.f13275j.getClass();
            sb.append("<tr><td class=\"Exception\" colspan=\"6\">");
            for (IThrowableProxy iThrowableProxyL = iLoggingEvent.l(); iThrowableProxyL != null; iThrowableProxyL = iThrowableProxyL.a()) {
                if (iThrowableProxyL.b() > 0) {
                    sb.append("<br />");
                    sb.append("Caused by: ");
                }
                sb.append(iThrowableProxyL.d());
                sb.append(": ");
                sb.append(Transform.a(iThrowableProxyL.getMessage()));
                sb.append(CoreConstants.f13442a);
                int iB = iThrowableProxyL.b();
                StackTraceElementProxy[] stackTraceElementProxyArrE = iThrowableProxyL.e();
                for (int i2 = 0; i2 < stackTraceElementProxyArrE.length - iB; i2++) {
                    StackTraceElementProxy stackTraceElementProxy = stackTraceElementProxyArrE[i2];
                    sb.append("<br />&nbsp;&nbsp;&nbsp;&nbsp;");
                    sb.append(Transform.a(stackTraceElementProxy.toString()));
                    sb.append(CoreConstants.f13442a);
                }
                if (iB > 0) {
                    sb.append("<br />&nbsp;&nbsp;&nbsp;&nbsp;");
                    sb.append("\t... ");
                    sb.append(iB);
                    sb.append(" common frames omitted");
                    sb.append(CoreConstants.f13442a);
                }
            }
            sb.append("</td></tr>");
        }
        return sb.toString();
    }

    @Override // ch.qos.logback.core.html.HTMLLayoutBase, ch.qos.logback.core.LayoutBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() throws NumberFormatException {
        if (this.f13275j == null) {
            l1("ThrowableRender cannot be null.");
        } else {
            super.start();
        }
    }
}
