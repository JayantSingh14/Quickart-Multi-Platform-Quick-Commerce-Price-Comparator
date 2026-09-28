package com.facebook.react.modules.core;

import com.facebook.fbreact.specs.NativeTimingSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.JavaTimerManager;
import com.facebook.react.modules.core.ReactChoreographer;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.time.DateUtils;
import org.jetbrains.annotations.NotNull;

@ReactModule(name = "Timing")
@Metadata
/* loaded from: classes.dex */
public final class TimingModule extends NativeTimingSpec implements JavaScriptTimerExecutor {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "Timing";

    @NotNull
    private final JavaTimerManager javaTimerManager;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimingModule(@NotNull ReactApplicationContext reactContext, @NotNull DevSupportManager devSupportManager) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.javaTimerManager = new JavaTimerManager(reactContext, this, ReactChoreographer.Companion.a(), devSupportManager);
    }

    @Override // com.facebook.react.modules.core.JavaScriptTimerExecutor
    public void callIdleCallbacks(double d2) {
        JSTimers jSTimers;
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn == null || (jSTimers = (JSTimers) reactApplicationContextIfActiveOrWarn.getJSModule(JSTimers.class)) == null) {
            return;
        }
        jSTimers.callIdleCallbacks(d2);
    }

    @Override // com.facebook.react.modules.core.JavaScriptTimerExecutor
    public void callTimers(@NotNull WritableArray timerIDs) {
        JSTimers jSTimers;
        Intrinsics.checkNotNullParameter(timerIDs, "timerIDs");
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn == null || (jSTimers = (JSTimers) reactApplicationContextIfActiveOrWarn.getJSModule(JSTimers.class)) == null) {
            return;
        }
        jSTimers.callTimers(timerIDs);
    }

    @Override // com.facebook.fbreact.specs.NativeTimingSpec
    public void createTimer(double d2, double d3, double d4, boolean z) {
        int i2 = (int) d2;
        int i3 = (int) d3;
        JavaTimerManager javaTimerManager = this.javaTimerManager;
        javaTimerManager.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = (long) d4;
        boolean zG = javaTimerManager.f19043d.g();
        JavaScriptTimerExecutor javaScriptTimerExecutor = javaTimerManager.f19041b;
        if (zG && Math.abs(j2 - jCurrentTimeMillis) > DateUtils.MILLIS_PER_MINUTE) {
            javaScriptTimerExecutor.emitTimeDriftWarning("Debugger and device times have drifted by more than 60s. Please correct this by running adb shell \"date `date +%m%d%H%M%Y.%S`\" on your debugger machine.");
        }
        long jMax = Math.max(0L, (j2 - jCurrentTimeMillis) + i3);
        if (i3 != 0 || z) {
            javaTimerManager.createTimer(i2, jMax, z);
            return;
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(i2);
        javaScriptTimerExecutor.callTimers(writableArrayCreateArray);
    }

    @Override // com.facebook.fbreact.specs.NativeTimingSpec
    public void deleteTimer(double d2) {
        this.javaTimerManager.deleteTimer((int) d2);
    }

    @Override // com.facebook.react.modules.core.JavaScriptTimerExecutor
    public void emitTimeDriftWarning(@NotNull String warningMessage) {
        JSTimers jSTimers;
        Intrinsics.checkNotNullParameter(warningMessage, "warningMessage");
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn == null || (jSTimers = (JSTimers) reactApplicationContextIfActiveOrWarn.getJSModule(JSTimers.class)) == null) {
            return;
        }
        jSTimers.emitTimeDriftWarning(warningMessage);
    }

    @VisibleForTesting
    public final boolean hasActiveTimersInRange(long j2) {
        JavaTimerManager javaTimerManager = this.javaTimerManager;
        synchronized (javaTimerManager.f19044e) {
            JavaTimerManager.Timer timer = (JavaTimerManager.Timer) javaTimerManager.p.peek();
            if (timer == null) {
                return false;
            }
            if (!timer.f19060d && ((long) timer.f19059c) < j2) {
                return true;
            }
            Iterator it = javaTimerManager.p.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                JavaTimerManager.Timer timer2 = (JavaTimerManager.Timer) it.next();
                Intrinsics.c(timer2);
                if (!timer2.f19060d && ((long) timer2.f19059c) < j2) {
                    return true;
                }
            }
            Unit unit = Unit.f53572a;
            return false;
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        JavaTimerManager listener = this.javaTimerManager;
        listener.getClass();
        WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
        ReactApplicationContext reactApplicationContext = listener.f19040a;
        HeadlessJsTaskContext headlessJsTaskContextA = HeadlessJsTaskContext.Companion.a(reactApplicationContext);
        Intrinsics.checkNotNullParameter(listener, "listener");
        headlessJsTaskContextA.f19011b.remove(listener);
        reactApplicationContext.removeLifecycleEventListener(listener);
        listener.c();
        if (listener.n) {
            listener.f19042c.c(ReactChoreographer.CallbackType.f19072e, listener.f19050k);
            listener.n = false;
        }
    }

    @Override // com.facebook.fbreact.specs.NativeTimingSpec
    public void setSendIdleEvents(boolean z) {
        this.javaTimerManager.setSendIdleEvents(z);
    }
}
