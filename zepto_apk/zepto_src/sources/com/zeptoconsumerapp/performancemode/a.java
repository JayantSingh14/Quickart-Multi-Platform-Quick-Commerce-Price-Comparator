package com.zeptoconsumerapp.performancemode;

import com.zeptoconsumerapp.Startup.AppCoroutineManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.internal.ContextScope;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PerformanceModeEventManager f47748a;

    public /* synthetic */ a(PerformanceModeEventManager performanceModeEventManager) {
        this.f47748a = performanceModeEventManager;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        PerformanceModeEventManager performanceModeEventManager = this.f47748a;
        if (performanceModeEventManager.f47727c) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = jCurrentTimeMillis - performanceModeEventManager.f47728d;
            if (j2 >= 3000) {
                performanceModeEventManager.f47728d = jCurrentTimeMillis;
                ContextScope contextScope = AppCoroutineManager.f47545b;
                if (contextScope == null) {
                    throw new IllegalStateException("AppCoroutineManager not initialized");
                }
                BuildersKt.c(contextScope, null, new PerformanceModeEventManager$emitThrottledPerformanceUpdate$1(performanceModeEventManager, null), 3);
            } else if (performanceModeEventManager.f47726b == null) {
                long j3 = 3000 - j2;
                ContextScope contextScope2 = AppCoroutineManager.f47545b;
                if (contextScope2 == null) {
                    throw new IllegalStateException("AppCoroutineManager not initialized");
                }
                performanceModeEventManager.f47726b = BuildersKt.c(contextScope2, null, new PerformanceModeEventManager$emitThrottledPerformanceUpdate$2(j3, performanceModeEventManager, null), 3);
            }
        }
        return Unit.f53572a;
    }
}
