package ch.qos.logback.classic.log4j;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.LayoutBase;
import ch.qos.logback.core.helpers.Transform;

/* loaded from: classes3.dex */
public class XMLLayout extends LayoutBase<ILoggingEvent> {

    /* renamed from: e, reason: collision with root package name */
    public StringBuilder f13293e = new StringBuilder(256);

    @Override // ch.qos.logback.core.Layout
    public final String c1(Object obj) {
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        if (this.f13293e.capacity() > 2048) {
            this.f13293e = new StringBuilder(256);
        } else {
            this.f13293e.setLength(0);
        }
        this.f13293e.append("<log4j:event logger=\"");
        this.f13293e.append(Transform.a(iLoggingEvent.k()));
        this.f13293e.append("\"\r\n");
        this.f13293e.append("             timestamp=\"");
        this.f13293e.append(iLoggingEvent.j());
        this.f13293e.append("\" level=\"");
        this.f13293e.append(iLoggingEvent.a());
        this.f13293e.append("\" thread=\"");
        this.f13293e.append(Transform.a(iLoggingEvent.h()));
        this.f13293e.append("\">\r\n");
        this.f13293e.append("  <log4j:message>");
        this.f13293e.append(Transform.a(iLoggingEvent.b()));
        this.f13293e.append("</log4j:message>\r\n");
        IThrowableProxy iThrowableProxyL = iLoggingEvent.l();
        if (iThrowableProxyL != null) {
            StackTraceElementProxy[] stackTraceElementProxyArrE = iThrowableProxyL.e();
            this.f13293e.append("  <log4j:throwable><![CDATA[");
            for (StackTraceElementProxy stackTraceElementProxy : stackTraceElementProxyArrE) {
                this.f13293e.append('\t');
                this.f13293e.append(stackTraceElementProxy.toString());
                this.f13293e.append("\r\n");
            }
            this.f13293e.append("]]></log4j:throwable>\r\n");
        }
        this.f13293e.append("\r\n</log4j:event>\r\n\r\n");
        return this.f13293e.toString();
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        this.f13445d = true;
    }
}
