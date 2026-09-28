package ch.qos.logback.classic.net;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.net.AbstractSSLSocketAppender;

/* loaded from: classes3.dex */
public class SSLSocketAppender extends AbstractSSLSocketAppender<ILoggingEvent> {
    public final LoggingEventPreSerializationTransformer z = new LoggingEventPreSerializationTransformer();

    @Override // ch.qos.logback.core.net.AbstractSocketAppender
    public final LoggingEventPreSerializationTransformer W1() {
        return this.z;
    }

    @Override // ch.qos.logback.core.net.AbstractSocketAppender
    public final /* bridge */ /* synthetic */ void Y1(Object obj) {
    }
}
