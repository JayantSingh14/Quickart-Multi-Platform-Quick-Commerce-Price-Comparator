package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;

/* loaded from: classes3.dex */
public class MessageConverter extends ClassicConverter {
    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        return ((ILoggingEvent) obj).b();
    }
}
