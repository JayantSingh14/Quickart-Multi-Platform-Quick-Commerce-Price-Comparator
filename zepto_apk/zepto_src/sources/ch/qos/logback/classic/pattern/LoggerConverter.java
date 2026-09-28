package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;

/* loaded from: classes3.dex */
public class LoggerConverter extends NamedConverter {
    @Override // ch.qos.logback.classic.pattern.NamedConverter
    public final String g(ILoggingEvent iLoggingEvent) {
        return iLoggingEvent.k();
    }
}
