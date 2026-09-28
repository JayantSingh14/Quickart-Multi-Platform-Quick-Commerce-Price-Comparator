package ch.qos.logback.core;

import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.FilterAttachable;
import ch.qos.logback.core.spi.LifeCycle;

/* loaded from: classes.dex */
public interface Appender<E> extends LifeCycle, ContextAware, FilterAttachable<E> {
    void A(Object obj);

    void a(String str);

    String getName();
}
