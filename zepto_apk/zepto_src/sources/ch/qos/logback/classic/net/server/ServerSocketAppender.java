package ch.qos.logback.classic.net.server;

import ch.qos.logback.classic.net.LoggingEventPreSerializationTransformer;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.net.server.AbstractServerSocketAppender;

/* loaded from: classes3.dex */
public class ServerSocketAppender extends AbstractServerSocketAppender<ILoggingEvent> {
    public static final LoggingEventPreSerializationTransformer n = new LoggingEventPreSerializationTransformer();

    @Override // ch.qos.logback.core.net.server.AbstractServerSocketAppender
    public final LoggingEventPreSerializationTransformer U1() {
        return n;
    }

    @Override // ch.qos.logback.core.net.server.AbstractServerSocketAppender
    public final /* bridge */ /* synthetic */ void W1(Object obj) {
    }
}
