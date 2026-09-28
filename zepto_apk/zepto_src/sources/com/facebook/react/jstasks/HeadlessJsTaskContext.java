package com.facebook.react.jstasks;

import android.util.SparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.appregistry.AppRegistry;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HeadlessJsTaskContext {

    /* renamed from: g, reason: collision with root package name */
    public static final WeakHashMap f19009g = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f19010a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet f19011b = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f19012c = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet f19013d = new CopyOnWriteArraySet();

    /* renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f19014e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final SparseArray f19015f = new SparseArray();

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static HeadlessJsTaskContext a(ReactContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
            Object headlessJsTaskContext = weakHashMap.get(context);
            if (headlessJsTaskContext == null) {
                headlessJsTaskContext = new HeadlessJsTaskContext(context);
                weakHashMap.put(context, headlessJsTaskContext);
            }
            return (HeadlessJsTaskContext) headlessJsTaskContext;
        }
    }

    public HeadlessJsTaskContext(ReactContext reactContext) {
        this.f19010a = new WeakReference(reactContext);
    }

    public final synchronized void a(HeadlessJsTaskEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f19011b.add(listener);
        Iterator it = this.f19013d.iterator();
        while (it.hasNext()) {
            ((Number) it.next()).intValue();
            listener.a();
        }
    }

    public final synchronized void b(int i2) {
        boolean zRemove = this.f19013d.remove(Integer.valueOf(i2));
        this.f19014e.remove(Integer.valueOf(i2));
        SparseArray sparseArray = this.f19015f;
        Runnable runnable = (Runnable) sparseArray.get(i2);
        if (runnable != null) {
            UiThreadUtil.removeOnUiThread(runnable);
            sparseArray.remove(i2);
        }
        if (zRemove) {
            UiThreadUtil.runOnUiThread(new a(this, i2, 0));
        }
    }

    public final synchronized void c(HeadlessJsTaskConfig headlessJsTaskConfig, int i2) {
        try {
            UiThreadUtil.assertOnUiThread();
            Object obj = this.f19010a.get();
            Assertions.d(obj, "Tried to start a task on a react context that has already been destroyed");
            ReactContext reactContext = (ReactContext) obj;
            if (reactContext.getLifecycleState() == LifecycleState.f18693c && !headlessJsTaskConfig.e()) {
                throw new IllegalStateException(("Tried to start task " + headlessJsTaskConfig.c() + " while in foreground, but this is not allowed.").toString());
            }
            this.f19013d.add(Integer.valueOf(i2));
            this.f19014e.put(Integer.valueOf(i2), new HeadlessJsTaskConfig(headlessJsTaskConfig));
            if (reactContext.hasActiveReactInstance()) {
                ((AppRegistry) reactContext.getJSModule(AppRegistry.class)).startHeadlessTask(i2, headlessJsTaskConfig.c(), headlessJsTaskConfig.a());
            } else {
                ReactSoftExceptionLogger.logSoftException("HeadlessJsTaskContext", new RuntimeException("Cannot start headless task, CatalystInstance not available"));
            }
            if (headlessJsTaskConfig.d() > 0) {
                long jD = headlessJsTaskConfig.d();
                a aVar = new a(this, i2, 1);
                this.f19015f.append(i2, aVar);
                UiThreadUtil.runOnUiThread(aVar, jD);
            }
            Iterator it = this.f19011b.iterator();
            while (it.hasNext()) {
                ((HeadlessJsTaskEventListener) it.next()).a();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
