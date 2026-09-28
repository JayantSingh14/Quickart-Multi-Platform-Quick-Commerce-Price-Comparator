package ch.qos.logback.classic.net;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.net.AbstractSocketAppender;

/* loaded from: classes3.dex */
public class SocketAppender extends AbstractSocketAppender<ILoggingEvent> {
    public static final LoggingEventPreSerializationTransformer y = new LoggingEventPreSerializationTransformer();
    public boolean x = false;

    @Override // ch.qos.logback.core.net.AbstractSocketAppender
    public final LoggingEventPreSerializationTransformer W1() {
        return y;
    }

    @Override // ch.qos.logback.core.net.AbstractSocketAppender
    public final void Y1(Object obj) {
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        if (this.x) {
            iLoggingEvent.i();
        }
    }
}
