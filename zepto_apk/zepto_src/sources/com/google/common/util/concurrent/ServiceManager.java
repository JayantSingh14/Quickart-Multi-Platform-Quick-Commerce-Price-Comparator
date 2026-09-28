package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import java.util.Map;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
public final class ServiceManager implements ServiceManagerBridge {

    /* renamed from: com.google.common.util.concurrent.ServiceManager$1, reason: invalid class name */
    public class AnonymousClass1 implements ListenerCallQueue.Event<Listener> {
        public final String toString() {
            return "healthy()";
        }
    }

    /* renamed from: com.google.common.util.concurrent.ServiceManager$2, reason: invalid class name */
    public class AnonymousClass2 implements ListenerCallQueue.Event<Listener> {
        public final String toString() {
            return "stopped()";
        }
    }

    public static final class EmptyServiceManagerWarning extends Throwable {
    }

    public static abstract class Listener {
    }

    public static final class NoOpService extends AbstractService {
    }

    public static final class ServiceListener extends Service.Listener {
    }

    public static final class ServiceManagerState {

        /* renamed from: com.google.common.util.concurrent.ServiceManager$ServiceManagerState$1, reason: invalid class name */
        class AnonymousClass1 implements Function<Map.Entry<Service, Long>, Long> {
            @Override // com.google.common.base.Function
            public final Long apply(Map.Entry<Service, Long> entry) {
                return entry.getValue();
            }
        }

        /* renamed from: com.google.common.util.concurrent.ServiceManager$ServiceManagerState$2, reason: invalid class name */
        class AnonymousClass2 implements ListenerCallQueue.Event<Listener> {
            public final String toString() {
                throw null;
            }
        }

        public final class AwaitHealthGuard extends Monitor.Guard {
        }

        public final class StoppedGuard extends Monitor.Guard {
        }
    }

    static {
        new LazyLogger(ServiceManager.class);
    }

    public final String toString() {
        new MoreObjects.ToStringHelper("ServiceManager");
        Collections2.b(Predicates.h(Predicates.g(NoOpService.class)));
        throw null;
    }
}
