package ch.qos.logback.core;

import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.spi.LogbackLock;
import ch.qos.logback.core.spi.PropertyContainer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public interface Context extends PropertyContainer {
    BasicStatusManager D();

    void N(LifeCycle lifeCycle);

    void O(Object obj, String str);

    ScheduledExecutorService T();

    void a(String str);

    String getName();

    ScheduledExecutorService l0();

    Object n0(String str);

    void s(ScheduledFuture scheduledFuture);

    void s0(String str, String str2);

    LogbackLock t0();

    long v0();
}
