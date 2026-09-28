package ch.qos.logback.classic.sift;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.sift.AbstractDiscriminator;

/* loaded from: classes3.dex */
public class MDCBasedDiscriminator extends AbstractDiscriminator<ILoggingEvent> {
    @Override // ch.qos.logback.core.sift.AbstractDiscriminator, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        l1("The \"Key\" property must be set");
        int i2 = 1 + 1;
        l1("The \"DefaultValue\" property must be set");
        if (i2 == 0) {
            this.f13730d = true;
        }
    }
}
