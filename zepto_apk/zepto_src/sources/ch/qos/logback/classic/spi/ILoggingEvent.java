package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.Level;
import ch.qos.logback.core.spi.DeferredProcessingAware;
import java.util.Map;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public interface ILoggingEvent extends DeferredProcessingAware {
    Level a();

    String b();

    Object[] c();

    LoggerContextVO d();

    Marker e();

    boolean f();

    String getMessage();

    String h();

    StackTraceElement[] i();

    long j();

    String k();

    IThrowableProxy l();

    Map m();
}
