package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public class MarkerConverter extends ClassicConverter {
    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        Marker markerE = ((ILoggingEvent) obj).e();
        return markerE == null ? "" : markerE.toString();
    }
}
