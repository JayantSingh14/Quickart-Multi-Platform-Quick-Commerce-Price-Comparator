package com.facebook.react.modules.core;

import android.os.SystemClock;
import android.util.SparseArray;
import android.view.Choreographer;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.modules.core.ReactChoreographer;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class JavaTimerManager implements LifecycleEventListener, HeadlessJsTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f19040a;

    /* renamed from: b, reason: collision with root package name */
    public final JavaScriptTimerExecutor f19041b;

    /* renamed from: c, reason: collision with root package name */
    public final ReactChoreographer f19042c;

    /* renamed from: d, reason: collision with root package name */
    public final DevSupportManager f19043d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f19044e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f19045f;

    /* renamed from: g, reason: collision with root package name */
    public final SparseArray f19046g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f19047h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f19048i;

    /* renamed from: j, reason: collision with root package name */
    public final TimerFrameCallback f19049j;

    /* renamed from: k, reason: collision with root package name */
    public final IdleFrameCallback f19050k;

    /* renamed from: l, reason: collision with root package name */
    public IdleCallbackRunnable f19051l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f19052m;
    public boolean n;
    public boolean o;
    public final PriorityQueue p;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public final class IdleCallbackRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final long f19053a;

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f19054b;

        public IdleCallbackRunnable(long j2) {
            this.f19053a = j2;
        }

        public final void a() {
            this.f19054b = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            if (this.f19054b) {
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis() - (this.f19053a / 1000000);
            long jCurrentTimeMillis = System.currentTimeMillis() - jUptimeMillis;
            if (16.666666f - jUptimeMillis < 1.0f) {
                return;
            }
            JavaTimerManager javaTimerManager = JavaTimerManager.this;
            synchronized (javaTimerManager.f19045f) {
                z = javaTimerManager.o;
                Unit unit = Unit.f53572a;
            }
            if (z) {
                JavaTimerManager.this.f19041b.callIdleCallbacks(jCurrentTimeMillis);
            }
            JavaTimerManager.this.f19051l = null;
        }
    }

    @Metadata
    public final class IdleFrameCallback implements Choreographer.FrameCallback {
        public IdleFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j2) {
            JavaTimerManager javaTimerManager = JavaTimerManager.this;
            if (!javaTimerManager.f19047h.get() || javaTimerManager.f19048i.get()) {
                IdleCallbackRunnable idleCallbackRunnable = javaTimerManager.f19051l;
                if (idleCallbackRunnable != null) {
                    idleCallbackRunnable.a();
                }
                IdleCallbackRunnable idleCallbackRunnable2 = javaTimerManager.new IdleCallbackRunnable(j2);
                javaTimerManager.f19051l = idleCallbackRunnable2;
                javaTimerManager.f19040a.runOnJSQueueThread(idleCallbackRunnable2);
                javaTimerManager.f19042c.b(ReactChoreographer.CallbackType.f19072e, this);
            }
        }
    }

    @Metadata
    public static final class Timer {

        /* renamed from: a, reason: collision with root package name */
        public final int f19057a;

        /* renamed from: b, reason: collision with root package name */
        public long f19058b;

        /* renamed from: c, reason: collision with root package name */
        public final int f19059c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f19060d;

        public Timer(int i2, int i3, long j2, boolean z) {
            this.f19057a = i2;
            this.f19058b = j2;
            this.f19059c = i3;
            this.f19060d = z;
        }
    }

    @Metadata
    public final class TimerFrameCallback implements Choreographer.FrameCallback {

        /* renamed from: a, reason: collision with root package name */
        public WritableArray f19061a;

        public TimerFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j2) {
            Timer timer;
            if (!JavaTimerManager.this.f19047h.get() || JavaTimerManager.this.f19048i.get()) {
                long j3 = j2 / 1000000;
                JavaTimerManager javaTimerManager = JavaTimerManager.this;
                synchronized (javaTimerManager.f19044e) {
                    while (!javaTimerManager.p.isEmpty()) {
                        try {
                            Object objPeek = javaTimerManager.p.peek();
                            Intrinsics.c(objPeek);
                            if (((Timer) objPeek).f19058b >= j3 || (timer = (Timer) javaTimerManager.p.poll()) == null) {
                                break;
                            }
                            if (this.f19061a == null) {
                                this.f19061a = Arguments.createArray();
                            }
                            WritableArray writableArray = this.f19061a;
                            if (writableArray != null) {
                                writableArray.pushInt(timer.f19057a);
                            }
                            if (timer.f19060d) {
                                timer.f19058b = timer.f19059c + j3;
                                javaTimerManager.p.add(timer);
                            } else {
                                javaTimerManager.f19046g.remove(timer.f19057a);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    Unit unit = Unit.f53572a;
                }
                WritableArray writableArray2 = this.f19061a;
                if (writableArray2 != null) {
                    JavaTimerManager.this.f19041b.callTimers(writableArray2);
                    this.f19061a = null;
                }
                JavaTimerManager.this.f19042c.b(ReactChoreographer.CallbackType.f19071d, this);
            }
        }
    }

    public JavaTimerManager(ReactApplicationContext reactApplicationContext, JavaScriptTimerExecutor javaScriptTimerExecutor, ReactChoreographer reactChoreographer, DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        Intrinsics.checkNotNullParameter(javaScriptTimerExecutor, "javaScriptTimerExecutor");
        Intrinsics.checkNotNullParameter(reactChoreographer, "reactChoreographer");
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.f19040a = reactApplicationContext;
        this.f19041b = javaScriptTimerExecutor;
        this.f19042c = reactChoreographer;
        this.f19043d = devSupportManager;
        this.f19044e = new Object();
        this.f19045f = new Object();
        this.f19046g = new SparseArray();
        this.f19047h = new AtomicBoolean(true);
        this.f19048i = new AtomicBoolean(false);
        this.f19049j = new TimerFrameCallback();
        this.f19050k = new IdleFrameCallback();
        final a aVar = new a();
        this.p = new PriorityQueue(11, new Comparator() { // from class: com.facebook.react.modules.core.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Number) aVar.invoke(obj, obj2)).intValue();
            }
        });
        reactApplicationContext.addLifecycleEventListener(this);
        WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
        HeadlessJsTaskContext.Companion.a(reactApplicationContext).a(this);
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public final void a() {
        if (this.f19048i.getAndSet(true)) {
            return;
        }
        if (!this.f19052m) {
            this.f19042c.b(ReactChoreographer.CallbackType.f19071d, this.f19049j);
            this.f19052m = true;
        }
        synchronized (this.f19045f) {
            if (this.o && !this.n) {
                this.f19042c.b(ReactChoreographer.CallbackType.f19072e, this.f19050k);
                this.n = true;
            }
            Unit unit = Unit.f53572a;
        }
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public final void b(int i2) {
        WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
        if (HeadlessJsTaskContext.Companion.a(this.f19040a).f19013d.isEmpty()) {
            this.f19048i.set(false);
            c();
            d();
        }
    }

    public final void c() {
        WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
        HeadlessJsTaskContext headlessJsTaskContextA = HeadlessJsTaskContext.Companion.a(this.f19040a);
        if (this.f19052m && this.f19047h.get() && headlessJsTaskContextA.f19013d.isEmpty()) {
            this.f19042c.c(ReactChoreographer.CallbackType.f19071d, this.f19049j);
            this.f19052m = false;
        }
    }

    @DoNotStrip
    public void createTimer(int i2, long j2, boolean z) {
        Timer timer = new Timer(i2, (int) j2, (System.nanoTime() / 1000000) + j2, z);
        synchronized (this.f19044e) {
            this.p.add(timer);
            this.f19046g.put(i2, timer);
            Unit unit = Unit.f53572a;
        }
    }

    public final void d() {
        if (!this.f19047h.get() || this.f19048i.get()) {
            return;
        }
        c();
    }

    @DoNotStrip
    public void deleteTimer(int i2) {
        synchronized (this.f19044e) {
            Timer timer = (Timer) this.f19046g.get(i2);
            if (timer == null) {
                return;
            }
            this.f19046g.remove(i2);
            this.p.remove(timer);
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostDestroy() {
        c();
        d();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostPause() {
        this.f19047h.set(true);
        c();
        d();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostResume() {
        this.f19047h.set(false);
        if (!this.f19052m) {
            this.f19042c.b(ReactChoreographer.CallbackType.f19071d, this.f19049j);
            this.f19052m = true;
        }
        synchronized (this.f19045f) {
            if (this.o && !this.n) {
                this.f19042c.b(ReactChoreographer.CallbackType.f19072e, this.f19050k);
                this.n = true;
            }
            Unit unit = Unit.f53572a;
        }
    }

    @DoNotStrip
    public void setSendIdleEvents(final boolean z) {
        synchronized (this.f19045f) {
            this.o = z;
            Unit unit = Unit.f53572a;
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.core.c
            @Override // java.lang.Runnable
            public final void run() {
                JavaTimerManager javaTimerManager = this.f19077a;
                boolean z2 = z;
                synchronized (javaTimerManager.f19045f) {
                    if (z2) {
                        if (!javaTimerManager.n) {
                            javaTimerManager.f19042c.b(ReactChoreographer.CallbackType.f19072e, javaTimerManager.f19050k);
                            javaTimerManager.n = true;
                        }
                    } else if (javaTimerManager.n) {
                        javaTimerManager.f19042c.c(ReactChoreographer.CallbackType.f19072e, javaTimerManager.f19050k);
                        javaTimerManager.n = false;
                    }
                    Unit unit2 = Unit.f53572a;
                }
            }
        });
    }
}
