package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes3.dex */
public class LoggerContextAwareBase extends ContextAwareBase implements LoggerContextAware {
    @Override // ch.qos.logback.core.spi.ContextAwareBase, ch.qos.logback.core.spi.ContextAware
    public final void V(Context context) {
        if (!(context instanceof LoggerContext) && context != null) {
            throw new IllegalArgumentException("LoggerContextAwareBase only accepts contexts of type c.l.classic.LoggerContext");
        }
        super.V(context);
    }
}
