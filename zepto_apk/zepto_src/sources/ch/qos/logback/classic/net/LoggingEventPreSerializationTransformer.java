package ch.qos.logback.classic.net;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.classic.spi.LoggingEventVO;
import ch.qos.logback.classic.spi.ThrowableProxyVO;
import ch.qos.logback.core.spi.PreSerializationTransformer;

/* loaded from: classes3.dex */
public class LoggingEventPreSerializationTransformer implements PreSerializationTransformer<ILoggingEvent> {
    public final LoggingEventVO a(Object obj) {
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        if (iLoggingEvent == null) {
            return null;
        }
        if (!(iLoggingEvent instanceof LoggingEvent)) {
            if (iLoggingEvent instanceof LoggingEventVO) {
                return (LoggingEventVO) iLoggingEvent;
            }
            throw new IllegalArgumentException("Unsupported type ".concat(iLoggingEvent.getClass().getName()));
        }
        LoggingEventVO loggingEventVO = new LoggingEventVO();
        loggingEventVO.f13361b = iLoggingEvent.k();
        loggingEventVO.f13362c = iLoggingEvent.d();
        loggingEventVO.f13360a = iLoggingEvent.h();
        loggingEventVO.f13363d = iLoggingEvent.a();
        loggingEventVO.f13364e = iLoggingEvent.getMessage();
        loggingEventVO.f13366g = iLoggingEvent.c();
        loggingEventVO.f13369j = iLoggingEvent.e();
        loggingEventVO.f13370k = iLoggingEvent.m();
        loggingEventVO.f13371l = iLoggingEvent.j();
        loggingEventVO.f13367h = ThrowableProxyVO.f(iLoggingEvent.l());
        if (iLoggingEvent.f()) {
            loggingEventVO.f13368i = iLoggingEvent.i();
        }
        return loggingEventVO;
    }
}
