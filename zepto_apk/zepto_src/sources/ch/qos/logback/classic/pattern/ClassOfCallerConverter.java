package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;

/* loaded from: classes3.dex */
public class ClassOfCallerConverter extends NamedConverter {
    @Override // ch.qos.logback.classic.pattern.NamedConverter
    public final String g(ILoggingEvent iLoggingEvent) {
        StackTraceElement[] stackTraceElementArrI = iLoggingEvent.i();
        return (stackTraceElementArrI == null || stackTraceElementArrI.length <= 0) ? "?" : stackTraceElementArrI[0].getClassName();
    }
}
