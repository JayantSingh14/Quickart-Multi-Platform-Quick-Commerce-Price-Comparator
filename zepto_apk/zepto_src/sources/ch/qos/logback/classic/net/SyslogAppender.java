package ch.qos.logback.classic.net;

import android.support.v4.media.b;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.pattern.SyslogStartConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.net.SyslogAppenderBase;
import ch.qos.logback.core.net.SyslogOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

/* loaded from: classes3.dex */
public class SyslogAppender extends SyslogAppenderBase<ILoggingEvent> {
    public final PatternLayout p = new PatternLayout();
    public final String q = "\t";

    @Override // ch.qos.logback.core.net.SyslogAppenderBase
    public final PatternLayout U1() throws NumberFormatException {
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.f13661h.put("syslogStart", SyslogStartConverter.class.getName());
        if (this.f13609k == null) {
            this.f13609k = "[%thread] %logger %msg";
        }
        patternLayout.f13659f = "%syslogStart{null}%nopex{}" + this.f13609k;
        patternLayout.f13733b = this.f13733b;
        patternLayout.start();
        return patternLayout;
    }

    @Override // ch.qos.logback.core.net.SyslogAppenderBase
    public final SyslogOutputStream V1() {
        return new SyslogOutputStream(this.f13611m);
    }

    @Override // ch.qos.logback.core.net.SyslogAppenderBase
    public final void W1(Object obj, OutputStream outputStream) throws IOException {
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        IThrowableProxy iThrowableProxyL = iLoggingEvent.l();
        if (iThrowableProxyL == null) {
            return;
        }
        String strC1 = this.p.c1(iLoggingEvent);
        boolean z = true;
        while (iThrowableProxyL != null) {
            StackTraceElementProxy[] stackTraceElementProxyArrE = iThrowableProxyL.e();
            try {
                StringBuilder sbW = b.w(strC1);
                if (!z) {
                    sbW.append("Caused by: ");
                }
                sbW.append(iThrowableProxyL.d());
                sbW.append(": ");
                sbW.append(iThrowableProxyL.getMessage());
                outputStream.write(sbW.toString().getBytes());
                outputStream.flush();
                for (StackTraceElementProxy stackTraceElementProxy : stackTraceElementProxyArrE) {
                    outputStream.write((strC1 + stackTraceElementProxy).getBytes());
                    outputStream.flush();
                }
                iThrowableProxyL = iThrowableProxyL.a();
                z = false;
            } catch (IOException unused) {
                return;
            }
        }
    }

    @Override // ch.qos.logback.core.net.SyslogAppenderBase, ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() throws SocketException, NumberFormatException {
        super.start();
        PatternLayout patternLayout = this.p;
        patternLayout.f13661h.put("syslogStart", SyslogStartConverter.class.getName());
        patternLayout.f13659f = "%syslogStart{null}%nopex{}" + this.q;
        patternLayout.f13733b = this.f13733b;
        patternLayout.start();
    }
}
