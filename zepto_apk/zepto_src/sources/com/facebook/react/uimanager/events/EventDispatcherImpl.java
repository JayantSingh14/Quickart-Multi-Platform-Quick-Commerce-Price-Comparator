package com.facebook.react.uimanager.events;

import android.os.Trace;
import android.util.LongSparseArray;
import android.view.Choreographer;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.modules.core.ReactChoreographer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes.dex */
public class EventDispatcherImpl implements EventDispatcher, LifecycleEventListener {
    public static final Comparator q = new AnonymousClass1();

    /* renamed from: c, reason: collision with root package name */
    public final ReactApplicationContext f19712c;
    public volatile ReactEventEmitter n;

    /* renamed from: a, reason: collision with root package name */
    public final Object f19710a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Object f19711b = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final LongSparseArray f19713d = new LongSparseArray();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f19714e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final DispatchEventsRunnable f19715f = new DispatchEventsRunnable();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f19716g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList f19717h = new CopyOnWriteArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f19718i = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final ScheduleDispatchFrameCallback f19719j = new ScheduleDispatchFrameCallback();

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f19720k = new AtomicInteger();

    /* renamed from: l, reason: collision with root package name */
    public Event[] f19721l = new Event[16];

    /* renamed from: m, reason: collision with root package name */
    public int f19722m = 0;
    public short o = 0;
    public volatile boolean p = false;

    /* renamed from: com.facebook.react.uimanager.events.EventDispatcherImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements Comparator<Event> {
        @Override // java.util.Comparator
        public final int compare(Event event, Event event2) {
            Event event3 = event;
            Event event4 = event2;
            if (event3 == null && event4 == null) {
                return 0;
            }
            if (event3 == null) {
                return -1;
            }
            if (event4 == null) {
                return 1;
            }
            long timestampMs = event3.getTimestampMs() - event4.getTimestampMs();
            if (timestampMs == 0) {
                return 0;
            }
            return timestampMs < 0 ? -1 : 1;
        }
    }

    public class DispatchEventsRunnable implements Runnable {
        public DispatchEventsRunnable() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            EventDispatcherImpl eventDispatcherImpl;
            int i2;
            Intrinsics.checkNotNullParameter("DispatchEventsRunnable", "sectionName");
            Trace.beginSection(androidx.tracing.Trace.g("DispatchEventsRunnable"));
            try {
                int andIncrement = EventDispatcherImpl.this.f19720k.getAndIncrement();
                Intrinsics.checkNotNullParameter("ScheduleDispatchFrameCallback", "sectionName");
                Intrinsics.checkNotNullParameter("ScheduleDispatchFrameCallback", "sectionName");
                androidx.tracing.Trace.c(andIncrement, "ScheduleDispatchFrameCallback");
                EventDispatcherImpl.this.p = false;
                Assertions.c(EventDispatcherImpl.this.n);
                synchronized (EventDispatcherImpl.this.f19711b) {
                    try {
                        EventDispatcherImpl eventDispatcherImpl2 = EventDispatcherImpl.this;
                        int i3 = eventDispatcherImpl2.f19722m;
                        if (i3 > 0) {
                            if (i3 > 1) {
                                Arrays.sort(eventDispatcherImpl2.f19721l, 0, i3, EventDispatcherImpl.q);
                            }
                            int i4 = 0;
                            while (true) {
                                eventDispatcherImpl = EventDispatcherImpl.this;
                                i2 = eventDispatcherImpl.f19722m;
                                if (i4 >= i2) {
                                    break;
                                }
                                Event event = eventDispatcherImpl.f19721l[i4];
                                if (event != null) {
                                    String sectionName = event.getEventName();
                                    int uniqueID = event.getUniqueID();
                                    Intrinsics.checkNotNullParameter(sectionName, "sectionName");
                                    Intrinsics.checkNotNullParameter(sectionName, "sectionName");
                                    androidx.tracing.Trace.c(uniqueID, sectionName);
                                    event.dispatchModern(EventDispatcherImpl.this.n);
                                    event.dispose();
                                }
                                i4++;
                            }
                            Arrays.fill(eventDispatcherImpl.f19721l, 0, i2, (Object) null);
                            eventDispatcherImpl.f19722m = 0;
                            EventDispatcherImpl.this.f19713d.clear();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Iterator it = EventDispatcherImpl.this.f19718i.iterator();
                while (it.hasNext()) {
                    ((BatchEventDispatchedListener) it.next()).onBatchEventDispatched();
                }
            } finally {
                Trace.endSection();
            }
        }
    }

    public class ScheduleDispatchFrameCallback implements Choreographer.FrameCallback {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f19725a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f19726b = false;

        public ScheduleDispatchFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j2) {
            UiThreadUtil.assertOnUiThread();
            if (this.f19726b) {
                this.f19725a = false;
            } else {
                ReactChoreographer.Companion.a().b(ReactChoreographer.CallbackType.f19071d, EventDispatcherImpl.this.f19719j);
            }
            Intrinsics.checkNotNullParameter("ScheduleDispatchFrameCallback", "sectionName");
            Trace.beginSection(androidx.tracing.Trace.g("ScheduleDispatchFrameCallback"));
            try {
                EventDispatcherImpl.k(EventDispatcherImpl.this);
                if (!EventDispatcherImpl.this.p) {
                    EventDispatcherImpl.this.p = true;
                    int i2 = EventDispatcherImpl.this.f19720k.get();
                    Intrinsics.checkNotNullParameter("ScheduleDispatchFrameCallback", "sectionName");
                    Intrinsics.checkNotNullParameter("ScheduleDispatchFrameCallback", "sectionName");
                    androidx.tracing.Trace.a(i2, "ScheduleDispatchFrameCallback");
                    EventDispatcherImpl eventDispatcherImpl = EventDispatcherImpl.this;
                    eventDispatcherImpl.f19712c.runOnJSQueueThread(eventDispatcherImpl.f19715f);
                }
            } finally {
                Trace.endSection();
            }
        }
    }

    public EventDispatcherImpl(ReactApplicationContext reactApplicationContext) {
        this.f19712c = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        this.n = new ReactEventEmitter(reactApplicationContext);
    }

    public static void k(EventDispatcherImpl eventDispatcherImpl) {
        short sShortValue;
        synchronized (eventDispatcherImpl.f19710a) {
            synchronized (eventDispatcherImpl.f19711b) {
                for (int i2 = 0; i2 < eventDispatcherImpl.f19716g.size(); i2++) {
                    try {
                        Event event = (Event) eventDispatcherImpl.f19716g.get(i2);
                        if (event.canCoalesce()) {
                            int viewTag = event.getViewTag();
                            String eventName = event.getEventName();
                            short coalescingKey = event.getCoalescingKey();
                            HashMap map = eventDispatcherImpl.f19714e;
                            Short sh = (Short) map.get(eventName);
                            if (sh != null) {
                                sShortValue = sh.shortValue();
                            } else {
                                short s = eventDispatcherImpl.o;
                                eventDispatcherImpl.o = (short) (s + 1);
                                map.put(eventName, Short.valueOf(s));
                                sShortValue = s;
                            }
                            long j2 = ((sShortValue & 65535) << 32) | viewTag | ((coalescingKey & 65535) << 48);
                            Integer num = (Integer) eventDispatcherImpl.f19713d.get(j2);
                            Event event2 = null;
                            if (num == null) {
                                eventDispatcherImpl.f19713d.put(j2, Integer.valueOf(eventDispatcherImpl.f19722m));
                            } else {
                                Event event3 = eventDispatcherImpl.f19721l[num.intValue()];
                                Event eventCoalesce = event.coalesce(event3);
                                if (eventCoalesce != event3) {
                                    eventDispatcherImpl.f19713d.put(j2, Integer.valueOf(eventDispatcherImpl.f19722m));
                                    eventDispatcherImpl.f19721l[num.intValue()] = null;
                                    event2 = event3;
                                    event = eventCoalesce;
                                } else {
                                    event2 = event;
                                    event = null;
                                }
                            }
                            if (event != null) {
                                eventDispatcherImpl.l(event);
                            }
                            if (event2 != null) {
                                event2.dispose();
                            }
                        } else {
                            eventDispatcherImpl.l(event);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            eventDispatcherImpl.f19716g.clear();
        }
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void a() {
        m();
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void b(BatchEventDispatchedListener batchEventDispatchedListener) {
        this.f19718i.add(batchEventDispatchedListener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void c() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.uimanager.events.EventDispatcherImpl.2
            @Override // java.lang.Runnable
            public final void run() {
                EventDispatcherImpl eventDispatcherImpl = EventDispatcherImpl.this;
                eventDispatcherImpl.getClass();
                UiThreadUtil.assertOnUiThread();
                eventDispatcherImpl.f19719j.f19726b = true;
            }
        });
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void d(EventDispatcherListener eventDispatcherListener) {
        this.f19717h.remove(eventDispatcherListener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void e(EventDispatcherListener eventDispatcherListener) {
        this.f19717h.add(eventDispatcherListener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void f() {
        this.n.unregister(2);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void g(Event event) {
        Assertions.b(event.isInitialized(), "Dispatched event hasn't been initialized");
        Iterator it = this.f19717h.iterator();
        while (it.hasNext()) {
            ((EventDispatcherListener) it.next()).onEventDispatch(event);
        }
        synchronized (this.f19710a) {
            this.f19716g.add(event);
            String sectionName = event.getEventName();
            int uniqueID = event.getUniqueID();
            Intrinsics.checkNotNullParameter(sectionName, "sectionName");
            Intrinsics.checkNotNullParameter(sectionName, "sectionName");
            androidx.tracing.Trace.a(uniqueID, sectionName);
        }
        m();
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void h(BatchEventDispatchedListener batchEventDispatchedListener) {
        this.f19718i.remove(batchEventDispatchedListener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void i(FabricEventEmitter fabricEventEmitter) {
        this.n.register(2, (RCTModernEventEmitter) fabricEventEmitter);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void j(RCTEventEmitter rCTEventEmitter) {
        this.n.register(1, rCTEventEmitter);
    }

    public final void l(Event event) {
        int i2 = this.f19722m;
        Event[] eventArr = this.f19721l;
        if (i2 == eventArr.length) {
            this.f19721l = (Event[]) Arrays.copyOf(eventArr, eventArr.length * 2);
        }
        Event[] eventArr2 = this.f19721l;
        int i3 = this.f19722m;
        this.f19722m = i3 + 1;
        eventArr2[i3] = event;
    }

    public final void m() {
        if (this.n != null) {
            final ScheduleDispatchFrameCallback scheduleDispatchFrameCallback = this.f19719j;
            if (scheduleDispatchFrameCallback.f19725a) {
                return;
            }
            if (!EventDispatcherImpl.this.f19712c.isOnUiQueueThread()) {
                EventDispatcherImpl.this.f19712c.runOnUiQueueThread(new Runnable() { // from class: com.facebook.react.uimanager.events.EventDispatcherImpl.ScheduleDispatchFrameCallback.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScheduleDispatchFrameCallback scheduleDispatchFrameCallback2 = ScheduleDispatchFrameCallback.this;
                        if (scheduleDispatchFrameCallback2.f19725a) {
                            return;
                        }
                        scheduleDispatchFrameCallback2.f19725a = true;
                        ReactChoreographer.Companion.a().b(ReactChoreographer.CallbackType.f19071d, EventDispatcherImpl.this.f19719j);
                    }
                });
            } else {
                if (scheduleDispatchFrameCallback.f19725a) {
                    return;
                }
                scheduleDispatchFrameCallback.f19725a = true;
                ReactChoreographer.Companion.a().b(ReactChoreographer.CallbackType.f19071d, EventDispatcherImpl.this.f19719j);
            }
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostDestroy() {
        UiThreadUtil.assertOnUiThread();
        this.f19719j.f19726b = true;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostPause() {
        UiThreadUtil.assertOnUiThread();
        this.f19719j.f19726b = true;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostResume() {
        m();
    }
}
