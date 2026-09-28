package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.PostCompileProcessor;

/* loaded from: classes3.dex */
public class EnsureExceptionHandling implements PostCompileProcessor<ILoggingEvent> {
    public final void a(Context context, Converter converter) {
        if (converter == null) {
            throw new IllegalArgumentException("cannot process empty chain");
        }
        for (Converter converter2 = converter; converter2 != null; converter2 = converter2.f13648a) {
            if (converter2 instanceof ThrowableHandlingConverter) {
                return;
            }
        }
        while (true) {
            Converter converter3 = converter.f13648a;
            if (converter3 == null) {
                break;
            } else {
                converter = converter3;
            }
        }
        Converter extendedThrowableProxyConverter = ((LoggerContext) context).q ? new ExtendedThrowableProxyConverter() : new ThrowableProxyConverter();
        if (converter.f13648a != null) {
            throw new IllegalStateException("Next converter has been already set");
        }
        converter.f13648a = extendedThrowableProxyConverter;
    }
}
