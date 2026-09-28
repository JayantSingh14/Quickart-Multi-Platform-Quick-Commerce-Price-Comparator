package ch.qos.logback.classic;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AsyncAppenderBase;

/* loaded from: classes3.dex */
public class AsyncAppender extends AsyncAppenderBase<ILoggingEvent> {
    @Override // ch.qos.logback.core.AsyncAppenderBase
    public final boolean U1(Object obj) {
        return ((ILoggingEvent) obj).a().f13240a <= 20000;
    }

    @Override // ch.qos.logback.core.AsyncAppenderBase
    public final void V1(Object obj) {
        ((ILoggingEvent) obj).g();
    }
}
