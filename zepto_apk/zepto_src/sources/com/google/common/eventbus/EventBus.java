package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.eventbus.Dispatcher;
import com.google.common.util.concurrent.MoreExecutors;
import in.juspay.hypersdk.analytics.LogConstants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class EventBus {

    /* renamed from: a, reason: collision with root package name */
    public final String f43177a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f43178b;

    public static final class LoggingHandler implements SubscriberExceptionHandler {
    }

    static {
        Logger.getLogger(EventBus.class.getName());
    }

    public EventBus() {
        Executor executorA = MoreExecutors.a();
        new Dispatcher.PerThreadQueuedDispatcher.AnonymousClass1();
        new Dispatcher.PerThreadQueuedDispatcher.AnonymousClass2();
        new ConcurrentHashMap();
        this.f43177a = LogConstants.DEFAULT_CHANNEL;
        this.f43178b = executorA;
    }

    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperB = MoreObjects.b(this);
        toStringHelperB.c(this.f43177a);
        return toStringHelperB.toString();
    }
}
