package ch.qos.logback.classic.net.server;

import ch.qos.logback.classic.net.LoggingEventPreSerializationTransformer;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.net.server.SSLServerSocketAppenderBase;

/* loaded from: classes3.dex */
public class SSLServerSocketAppender extends SSLServerSocketAppenderBase<ILoggingEvent> {
    public static final LoggingEventPreSerializationTransformer p = new LoggingEventPreSerializationTransformer();

    @Override // ch.qos.logback.core.net.server.AbstractServerSocketAppender
    public final LoggingEventPreSerializationTransformer U1() {
        return p;
    }

    @Override // ch.qos.logback.core.net.server.AbstractServerSocketAppender
    public final /* bridge */ /* synthetic */ void W1(Object obj) {
    }
}
