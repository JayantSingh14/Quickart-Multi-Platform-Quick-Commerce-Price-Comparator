package ch.qos.logback.classic.encoder;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.PatternLayoutEncoderBase;

/* loaded from: classes3.dex */
public class PatternLayoutEncoder extends PatternLayoutEncoderBase<ILoggingEvent> {
    @Override // ch.qos.logback.core.encoder.LayoutWrappingEncoder, ch.qos.logback.core.encoder.EncoderBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() throws NumberFormatException {
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.f13733b = this.f13733b;
        patternLayout.f13659f = null;
        patternLayout.start();
        this.f13476e = patternLayout;
        this.f13475d = true;
    }
}
