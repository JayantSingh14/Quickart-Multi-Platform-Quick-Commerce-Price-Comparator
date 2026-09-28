package ch.qos.logback.core.boolex;

import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;

/* loaded from: classes3.dex */
public interface EventEvaluator<E> extends ContextAware, LifeCycle {
    void a(String str);

    String getName();

    boolean k0(Object obj);
}
