package com.facebook.react.uimanager.events;

import android.os.Handler;
import android.os.Trace;
import android.view.Choreographer;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.systrace.Systrace;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class FabricEventDispatcher implements EventDispatcher, LifecycleEventListener {

    /* renamed from: h, reason: collision with root package name */
    public static final Handler f19729h;

    /* renamed from: a, reason: collision with root package name */
    public final ReactEventEmitter f19730a;

    /* renamed from: b, reason: collision with root package name */
    public final ReactApplicationContext f19731b;

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f19732c;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList f19733d;

    /* renamed from: e, reason: collision with root package name */
    public final ScheduleDispatchFrameCallback f19734e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19735f;

    /* renamed from: g, reason: collision with root package name */
    public final a f19736g;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class ScheduleDispatchFrameCallback implements Choreographer.FrameCallback {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f19737a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f19738b;

        public ScheduleDispatchFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j2) {
            UiThreadUtil.assertOnUiThread();
            if (this.f19738b) {
                this.f19737a = false;
            } else {
                ReactChoreographer.Companion.a().b(ReactChoreographer.CallbackType.f19071d, FabricEventDispatcher.this.f19734e);
            }
            Intrinsics.checkNotNullParameter("BatchEventDispatchedListeners", "sectionName");
            Trace.beginSection(androidx.tracing.Trace.g("BatchEventDispatchedListeners"));
            try {
                Iterator it = FabricEventDispatcher.this.f19733d.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    ((BatchEventDispatchedListener) it.next()).onBatchEventDispatched();
                }
            } finally {
                Trace.endSection();
            }
        }
    }

    static {
        Handler uiThreadHandler = UiThreadUtil.getUiThreadHandler();
        Intrinsics.checkNotNullExpressionValue(uiThreadHandler, "getUiThreadHandler(...)");
        f19729h = uiThreadHandler;
    }

    public FabricEventDispatcher(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.f19731b = reactContext;
        this.f19732c = new CopyOnWriteArrayList();
        this.f19733d = new CopyOnWriteArrayList();
        this.f19734e = new ScheduleDispatchFrameCallback();
        this.f19736g = new a(this, 1);
        reactContext.addLifecycleEventListener(this);
        this.f19730a = new ReactEventEmitter(reactContext);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void a() {
        l();
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void b(BatchEventDispatchedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f19733d.add(listener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void c() {
        UiThreadUtil.runOnUiThread(new a(this, 0));
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void d(EventDispatcherListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f19732c.remove(listener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void e(EventDispatcherListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f19732c.add(listener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void f() {
        this.f19730a.unregister(2);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void g(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Iterator it = this.f19732c.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ((EventDispatcherListener) it.next()).onEventDispatch(event);
        }
        if (event.experimental_isSynchronous()) {
            Systrace.a("FabricEventDispatcher.dispatchSynchronous('" + event.getEventName() + "')");
            try {
                UIManager uIManagerF = UIManagerHelper.f(this.f19731b, 2, true);
                if (uIManagerF instanceof SynchronousEventReceiver) {
                    int surfaceId = event.getSurfaceId();
                    int viewTag = event.getViewTag();
                    String eventName = event.getEventName();
                    Intrinsics.checkNotNullExpressionValue(eventName, "getEventName(...)");
                    ((SynchronousEventReceiver) uIManagerF).receiveEvent(surfaceId, viewTag, eventName, event.canCoalesce(), event.getEventData(), event.getEventCategory(), true);
                } else {
                    ReactSoftExceptionLogger.logSoftException("FabricEventDispatcher", new ReactNoCrashSoftException("Fabric UIManager expected to implement SynchronousEventReceiver."));
                }
                Trace.endSection();
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } else {
            event.dispatchModern(this.f19730a);
        }
        event.dispose();
        l();
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void h(BatchEventDispatchedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f19733d.remove(listener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void i(FabricEventEmitter eventEmitter) {
        Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
        this.f19730a.register(2, (RCTModernEventEmitter) eventEmitter);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void j(RCTEventEmitter eventEmitter) {
        Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
        this.f19730a.register(1, eventEmitter);
    }

    public final void k() {
        UiThreadUtil.assertOnUiThread();
        if (!ReactNativeFeatureFlags.f18968a.useOptimizedEventBatchingOnAndroid()) {
            this.f19734e.f19738b = true;
            return;
        }
        this.f19735f = false;
        f19729h.removeCallbacks(this.f19736g);
    }

    public final void l() {
        if (ReactNativeFeatureFlags.f18968a.useOptimizedEventBatchingOnAndroid()) {
            if (this.f19735f) {
                return;
            }
            this.f19735f = true;
            f19729h.postAtFrontOfQueue(this.f19736g);
            return;
        }
        ScheduleDispatchFrameCallback scheduleDispatchFrameCallback = this.f19734e;
        if (scheduleDispatchFrameCallback.f19737a) {
            return;
        }
        if (!FabricEventDispatcher.this.f19731b.isOnUiQueueThread()) {
            FabricEventDispatcher.this.f19731b.runOnUiQueueThread(new a(scheduleDispatchFrameCallback, 2));
        } else {
            if (scheduleDispatchFrameCallback.f19737a) {
                return;
            }
            scheduleDispatchFrameCallback.f19737a = true;
            ReactChoreographer.Companion.a().b(ReactChoreographer.CallbackType.f19071d, FabricEventDispatcher.this.f19734e);
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostDestroy() {
        k();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostPause() {
        k();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostResume() {
        l();
        if (ReactNativeFeatureFlags.f18968a.useOptimizedEventBatchingOnAndroid()) {
            return;
        }
        this.f19734e.f19738b = false;
    }
}
