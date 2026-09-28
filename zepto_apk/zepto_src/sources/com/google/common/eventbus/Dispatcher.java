package com.google.common.eventbus;

import java.util.ArrayDeque;
import java.util.Queue;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class Dispatcher {

    public static final class ImmediateDispatcher extends Dispatcher {
    }

    public static final class LegacyAsyncDispatcher extends Dispatcher {

        public static final class EventWithSubscriber {
        }
    }

    public static final class PerThreadQueuedDispatcher extends Dispatcher {

        /* renamed from: com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$1, reason: invalid class name */
        public class AnonymousClass1 extends ThreadLocal<Queue<Event>> {
            @Override // java.lang.ThreadLocal
            public final Queue<Event> initialValue() {
                return new ArrayDeque();
            }
        }

        /* renamed from: com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$2, reason: invalid class name */
        public class AnonymousClass2 extends ThreadLocal<Boolean> {
            @Override // java.lang.ThreadLocal
            public final /* bridge */ /* synthetic */ Boolean initialValue() {
                return Boolean.FALSE;
            }
        }

        public static final class Event {
        }
    }
}
