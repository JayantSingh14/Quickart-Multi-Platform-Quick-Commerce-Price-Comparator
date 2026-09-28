package ch.qos.logback.classic.pattern.color;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

/* loaded from: classes3.dex */
public class HighlightingCompositeConverter extends ForegroundCompositeConverterBase<ILoggingEvent> {
    @Override // ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    public final String h(Object obj) {
        int i2 = ((ILoggingEvent) obj).a().f13240a;
        return i2 != 20000 ? i2 != 30000 ? i2 != 40000 ? "39" : "1;31" : "31" : "34";
    }
}
