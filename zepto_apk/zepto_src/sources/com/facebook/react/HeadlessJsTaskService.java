package com.facebook.react;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.internal.bolts.Task;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class HeadlessJsTaskService extends Service implements HeadlessJsTaskEventListener {

    /* renamed from: b, reason: collision with root package name */
    public static PowerManager.WakeLock f18413b;

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f18414a = new CopyOnWriteArraySet();

    public static void c(Context context) {
        PowerManager.WakeLock wakeLock = f18413b;
        if (wakeLock == null || !wakeLock.isHeld()) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            Assertions.c(powerManager);
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, HeadlessJsTaskService.class.getCanonicalName());
            f18413b = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            f18413b.acquire();
        }
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public final void b(int i2) {
        CopyOnWriteArraySet copyOnWriteArraySet = this.f18414a;
        copyOnWriteArraySet.remove(Integer.valueOf(i2));
        if (copyOnWriteArraySet.size() == 0) {
            stopSelf();
        }
    }

    public final ReactContext d() {
        if (!ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            return ((ReactApplication) getApplication()).a().f().f();
        }
        ReactHost reactHostB = ((ReactApplication) getApplication()).b();
        Assertions.d(reactHostB, "getReactHost() is null in New Architecture");
        return ((ReactHostImpl) reactHostB).m();
    }

    public HeadlessJsTaskConfig e(Intent intent) {
        return null;
    }

    public final void f(ReactContext reactContext, final HeadlessJsTaskConfig headlessJsTaskConfig) {
        WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
        final HeadlessJsTaskContext headlessJsTaskContextA = HeadlessJsTaskContext.Companion.a(reactContext);
        headlessJsTaskContextA.a(this);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.HeadlessJsTaskService.1
            @Override // java.lang.Runnable
            public final void run() {
                int iIncrementAndGet;
                HeadlessJsTaskContext headlessJsTaskContext = headlessJsTaskContextA;
                HeadlessJsTaskConfig taskConfig = headlessJsTaskConfig;
                synchronized (headlessJsTaskContext) {
                    Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
                    iIncrementAndGet = headlessJsTaskContext.f19012c.incrementAndGet();
                    headlessJsTaskContext.c(taskConfig, iIncrementAndGet);
                }
                HeadlessJsTaskService.this.f18414a.add(Integer.valueOf(iIncrementAndGet));
            }
        });
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        ReactContext reactContextD = d();
        if (reactContextD != null) {
            WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
            HeadlessJsTaskContext headlessJsTaskContextA = HeadlessJsTaskContext.Companion.a(reactContextD);
            Intrinsics.checkNotNullParameter(this, "listener");
            headlessJsTaskContextA.f19011b.remove(this);
        }
        PowerManager.WakeLock wakeLock = f18413b;
        if (wakeLock != null) {
            wakeLock.release();
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        final HeadlessJsTaskConfig headlessJsTaskConfigE = e(intent);
        if (headlessJsTaskConfigE == null) {
            return 2;
        }
        UiThreadUtil.assertOnUiThread();
        c(this);
        ReactContext reactContextD = d();
        if (reactContextD != null) {
            f(reactContextD, headlessJsTaskConfigE);
            return 3;
        }
        if (!ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            final ReactInstanceManager reactInstanceManagerF = ((ReactApplication) getApplication()).a().f();
            reactInstanceManagerF.s.add(new ReactInstanceEventListener() { // from class: com.facebook.react.HeadlessJsTaskService.3
                @Override // com.facebook.react.ReactInstanceEventListener
                public final void a(ReactApplicationContext reactApplicationContext) {
                    PowerManager.WakeLock wakeLock = HeadlessJsTaskService.f18413b;
                    HeadlessJsTaskService.this.f(reactApplicationContext, headlessJsTaskConfigE);
                    reactInstanceManagerF.s.remove(this);
                }
            });
            reactInstanceManagerF.d();
            return 3;
        }
        final ReactHost reactHostB = ((ReactApplication) getApplication()).b();
        ((ReactHostImpl) reactHostB).u.add(new ReactInstanceEventListener() { // from class: com.facebook.react.HeadlessJsTaskService.2
            @Override // com.facebook.react.ReactInstanceEventListener
            public final void a(ReactApplicationContext reactApplicationContext) {
                PowerManager.WakeLock wakeLock = HeadlessJsTaskService.f18413b;
                HeadlessJsTaskService.this.f(reactApplicationContext, headlessJsTaskConfigE);
                reactHostB.e(this);
            }
        });
        ReactHostImpl reactHostImpl = (ReactHostImpl) reactHostB;
        Task.a(new com.facebook.react.runtime.a(reactHostImpl, 3), reactHostImpl.f19243e).c(new com.facebook.react.runtime.j(1), Task.f19311g);
        return 3;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public final void a() {
    }
}
