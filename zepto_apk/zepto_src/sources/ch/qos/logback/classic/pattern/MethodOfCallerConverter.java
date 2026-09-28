package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;

/* loaded from: classes3.dex */
public class MethodOfCallerConverter extends ClassicConverter {
    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        StackTraceElement[] stackTraceElementArrI = ((ILoggingEvent) obj).i();
        return (stackTraceElementArrI == null || stackTraceElementArrI.length <= 0) ? "?" : stackTraceElementArrI[0].getMethodName();
    }
}
