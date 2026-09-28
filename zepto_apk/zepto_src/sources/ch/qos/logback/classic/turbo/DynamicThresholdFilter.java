package ch.qos.logback.classic.turbo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.core.spi.FilterReply;
import java.util.HashMap;
import org.slf4j.MDC;
import org.slf4j.spi.MDCAdapter;

/* loaded from: classes3.dex */
public class DynamicThresholdFilter extends TurboFilter {
    public DynamicThresholdFilter() {
        new HashMap();
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter
    public final FilterReply T1(Level level, String str) {
        MDCAdapter mDCAdapter = MDC.f57876a;
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        l1("No key name was specified");
        this.f13408d = true;
    }
}
