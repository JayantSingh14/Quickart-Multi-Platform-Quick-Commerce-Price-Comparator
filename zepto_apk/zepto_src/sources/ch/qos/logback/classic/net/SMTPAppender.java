package ch.qos.logback.classic.net;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.boolex.OnErrorEvaluator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.net.SMTPAppenderBase;

/* loaded from: classes3.dex */
public class SMTPAppender extends SMTPAppenderBase<ILoggingEvent> {
    @Override // ch.qos.logback.core.net.SMTPAppenderBase
    public final PatternLayout V1() throws NumberFormatException {
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.f13733b = this.f13733b;
        patternLayout.f13659f = "%logger{20} - %m";
        patternLayout.f13660g = null;
        patternLayout.start();
        return patternLayout;
    }

    @Override // ch.qos.logback.core.net.SMTPAppenderBase, ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        if (this.f13606l == null) {
            OnErrorEvaluator onErrorEvaluator = new OnErrorEvaluator();
            onErrorEvaluator.V(this.f13733b);
            onErrorEvaluator.a("onError");
            onErrorEvaluator.f13458e = true;
            this.f13606l = onErrorEvaluator;
        }
        super.start();
    }
}
